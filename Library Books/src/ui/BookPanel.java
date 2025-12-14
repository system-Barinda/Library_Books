package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Book;
import service.BookService;

public class BookPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;
    private BookService service = new BookService();

    public BookPanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel(
                new String[]{"ID", "Title", "Author", "ISBN", "Category", "Status"}, 0);

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnLoad = new JButton("Load Books");
        btnLoad.addActionListener(e -> loadBooks());

        JPanel top = new JPanel();
        top.add(btnLoad);

        add(top, BorderLayout.NORTH);
    }

    private void loadBooks() {
        try {
            model.setRowCount(0);
            for (Book b : service.getAllBooks()) {
                model.addRow(new Object[]{
                        b.getId(),
                        b.getTitle(),
                        b.getAuthor(),
                        b.getIsbn(),
                        b.getCategory(),
                        b.getStatus()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
