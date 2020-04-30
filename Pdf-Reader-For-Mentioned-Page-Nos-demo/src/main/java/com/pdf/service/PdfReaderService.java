/**
 * 
 */
package com.pdf.service;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.springframework.stereotype.Service;

/**
 * @author 10661300
 *
 */
@Service
public class PdfReaderService {

	public static final String READ_PDF = "C:\\Users\\10661300\\Desktop\\prince.pdf";
	PDDocument newPdf = null;

	public void readAndPastePdf() {
		try {
			// PDFReader
			PDDocument document = PDDocument.load(new File(READ_PDF));
			PDPageTree pages = document.getPages();
			int[] pageNos = new int[] { 1, 2, 5 };
			newPdf = new PDDocument();
			for (int i = 0; i < pageNos.length; i++) {
				newPdf.addPage((PDPage) document.getDocumentCatalog().getPages().get(i));
				newPdf.save("C:\\Users\\10661300\\Desktop\\" + "king" + ".pdf");
				// newPdf.close();
			}
		} catch (IOException e) {
			System.out.println("Exception occurred " + e);
		}
	}
}
