package beans.configuration.web;

import beans.models.Ticket;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class PDFView extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        document.add(new Paragraph("Dear User, Following is the list of available tickets"));

        List<Ticket> tickets = (List<Ticket>) model.get("tickets");

        PdfPTable table = new PdfPTable(2);
        table.setSpacingBefore(10);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        cell.setPhrase(new Phrase("Event Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("User Email", font));
        table.addCell(cell);

        for (Ticket ticket : tickets) {
            table.addCell(ticket.getEvent().getName());
            table.addCell(ticket.getUser().getEmail());
        }

        document.add(table);

        document.add(new Paragraph(
                "The end "));
    }
}
