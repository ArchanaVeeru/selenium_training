/**
 * 
 */
package org.archana.selenium_tests;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 * @author ArchanaVeeru
 *
 */
public class PdfDownload {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		URL url=new URL("https://www.betterteam.com/downloads/employee-information-form-download-20170810.pdf");
		InputStream is=url.openStream();
		BufferedInputStream fileparse=new BufferedInputStream(is);
		PDDocument document=null;
		document.PDDocument.load(fileparse);
		String pdfContent=new PDFTextStripper().getText(document);
		System.out.println(pdfContent);
		
	}

}
