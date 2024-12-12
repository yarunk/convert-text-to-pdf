import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.io.File;
def Message processData(Message message) {
     def body = message.getBody(java.lang.String) as String;
    OutputStream out = new ByteArrayOutputStream()
    PdfWriter writer = new PdfWriter(out)

	// Creating a PdfDocument object
	PdfDocument pdfDoc = new PdfDocument(writer);

	// Creating a Document object
	Document doc = new Document(pdfDoc);

	// Adding text to the document
	Text text1 = new Text(body);

	// Creating a paragraph 1
	Paragraph para1 = new Paragraph(text1);

	// Adding paragraphs to the document
	doc.add(para1);

	// Closing the document
	doc.close();
    message.setHeader('Content-Type', 'application/pdf')
    message.setBody(out.toByteArray())
    return message
}