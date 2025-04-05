package RandomScripts;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PDFWriterExample {
	public static void main(String[] args) {
		// Create a new document
		Document document = new Document();

		try {
			// Specify the output file
			PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));

			// Open the document to write content
			document.open();

			// Add a title
			document.add(new Paragraph("User Information"));
			document.add(new Paragraph(" ")); // Empty line for spacing

			// Sample data
			String[][] data = { { "Name", "Age", "City" }, { "Alice", "25", "New York" },
					{ "Bob", "30", "Los Angeles" }, { "Charlie", "35", "Chicago" } };

			// Write data to the PDF
			for (String[] row : data) {
				document.add(new Paragraph(String.join(" | ", row)));
			}

			System.out.println("PDF created successfully!");

		} catch (DocumentException | FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Close the document
			document.close();
		}
	}
}
