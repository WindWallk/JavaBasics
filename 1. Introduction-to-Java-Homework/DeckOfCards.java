import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class DeckOfCards {
	public static void main(String[] args) throws DocumentException, IOException {
		Document document = new Document();
		try{
			PdfWriter.getInstance(document, new FileOutputStream("Deck-of-Cards.pdf"));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch (DocumentException e) {
			e.printStackTrace();
		}
		
		document.open();
		
		BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/times.ttf", BaseFont.IDENTITY_H, true);
		
		Paragraph header = new Paragraph("Deck of cards:");
		header.setAlignment(Element.ALIGN_CENTER);
		document.add(header);
		
		document.add(Chunk.NEWLINE);
		
		PdfPTable table = new PdfPTable(4);
		
		Font black = new Font(baseFont, 40f, 0, BaseColor.BLACK);
    	Font red = new Font(baseFont, 40f, 0, BaseColor.RED);
    	
		String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		String[] suits = {"\u2660", "\u2665", "\u2666", "\u2663"};
		
		// Print the deck to the pdf file
		
		for (int value = 0; value < 13; value++) {
			for (int suit = 0; suit < 4; suit++) {
				Paragraph card = new Paragraph();
				
				if(suit  == 0 || suit == 3){
					card = new Paragraph(values[value] + suits[suit], black);
				}
				else{
					card = new Paragraph(values[value] + suits[suit], red);
				}
				
				PdfPCell cell = new PdfPCell(card);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setFixedHeight(150f);
				table.addCell(cell);
			}
		}
		
		document.add(table);
		document.close();
	}
}
