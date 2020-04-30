/**
 * 
 */
package com.pdf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdf.service.PdfReaderService;

/**
 * @author 10661300
 *
 */
@RestController
public class PdfReaderController {
	
	@Autowired
	private PdfReaderService pdfReaderService;

	@GetMapping("/readPdf")
	public void readPdf() {
		pdfReaderService.readAndPastePdf();
	}
}
