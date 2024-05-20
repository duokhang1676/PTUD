package printer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;
import java.io.File;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;


public class PrintExample {
    // Phương thức in nội dung của file PDF
 // Phương thức in nội dung của file PDF mà không hiển thị hộp thoại in
	
    public static void printContent() {
    	
        PrinterJob job = PrinterJob.getPrinterJob();

        try {
            // Đọc file PDF
            File file = new File("data/example.pdf");
            PDDocument document = PDDocument.load(file);

            // Tạo một PDFPageable từ file PDF
            PDFPageable pageable = new PDFPageable(document);

            // Đặt Printable của job là PDFPageable
            job.setPageable(pageable);

            // In mà không hiển thị hộp thoại in
            job.print();
            // Đóng document
            document.close();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
    }

}
