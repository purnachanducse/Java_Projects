/**
 * 
 */
package com.batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batch.runner.JobRunner;

/**
 * @author 10661300
 *
 */
@RestController
@RequestMapping("/run")
public class BatchController {

	private JobRunner jobRunner;

	/**
	 * @param jobRunner
	 */
	@Autowired
	public BatchController(JobRunner jobRunner) {
		this.jobRunner = jobRunner;
	}
	
	@RequestMapping("/job")
	public String runJob() {
		jobRunner.runBatchJob();
		return String.format("Job Demo1 submitted successfully");
	}
	
}
