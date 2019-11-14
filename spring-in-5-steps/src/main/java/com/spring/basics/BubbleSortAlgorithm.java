/**
 * 
 */
package com.spring.basics;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author 10661300
 *
 */
@Component
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm{

	public int[] sort(int[] numbers) {
		return numbers;
	}
}
