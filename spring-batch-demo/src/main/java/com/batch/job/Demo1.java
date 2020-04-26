/**
 * 
 */
package com.batch.job;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.batch.EmployeeFileRowMapper;
import com.batch.dto.EmployeeDTO;
import com.batch.model.Employee;
import com.batch.processor.EmployeeProcessor;

/**
 * @author 10661300
 *
 */
@Configuration
public class Demo1 {

	private JobBuilderFactory jobBuilderFactory;
	private StepBuilderFactory stepBuilderFactory;
	private EmployeeProcessor employeeProcessor;
	private DataSource dataSource;

	/**
	 * @param jobBuilderFactory
	 * @param stepBuilderFactory
	 * @param employeeProcessor
	 * @param dataSource
	 */
	@Autowired
	public Demo1(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			EmployeeProcessor employeeProcessor, DataSource dataSource) {
		super();
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
		this.employeeProcessor = employeeProcessor;
		this.dataSource = dataSource;
	}

	@Qualifier(value = "demo1")
	@Bean
	public Job demo1Job() {
		return this.jobBuilderFactory.get("demo1")
				.start(stepDemo1()).build();

	}
	
	@Bean
	@StepScope
	Resource inputFileResource(@Value("#{jobParameters[fileName]}") final String fileName) {
		return new ClassPathResource(fileName);
	}

	@Bean
	@StepScope
	public FlatFileItemReader<EmployeeDTO> employeeReader(){
		FlatFileItemReader<EmployeeDTO> reader = new FlatFileItemReader<EmployeeDTO>();
		reader.setResource(inputFileResource(null));
		reader.setLineMapper(new DefaultLineMapper<EmployeeDTO>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setNames("employeeId","firstName","lastName","email","age");
				setDelimiter(",");
			}});
			setFieldSetMapper(new EmployeeFileRowMapper());
		}});
		return reader;
	}
	
	@Bean 
	public JdbcBatchItemWriter<Employee> employeeDBWriterDefault(){
		JdbcBatchItemWriter<Employee> itemWriter = new JdbcBatchItemWriter<Employee>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql("insert into employee(employee_id,first_name,last_name,email,age) values (:employee_id,:first_name,:last_name,:email,:age)");
		itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		return itemWriter;
	}
	
	@Bean
	public Step stepDemo1() {
		return this.stepBuilderFactory.get("step1").<EmployeeDTO,Employee>chunk(5)
				.reader(employeeReader())
				.processor(employeeProcessor)
				.writer(employeeDBWriterDefault())
				.build();
	}

}
