package ui;

import java.awt.*;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Book;
import service.BookService;

public class LibraryUI extends JFrame {

    // ❌ txtId REMOVED from form
    private JTextField txtTitle, txtAuthor, txtIsbn, txtCategory;
    private JComboBox<String> cmbStatus;
    private JTable table;
    private DefaultTableModel model;
    private BookService service = new BookService();

    // Used internally for update/delete
    private int selectedBookId = -1;

    public LibraryUI() {
        setTitle("Library Books Management System");
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));
        form.setBorder(BorderFactory.createTitledBorder("Book Form"));

        txtTitle = new JTextField();
        txtAuthor = new JTextField();
        txtIsbn = new JTextField();
        txtCategory = new JTextField();
        cmbStatus = new JComboBox<>(new String[]{"Available", "Borrowed"});

        form.add(new JLabel("Title"));
        form.add(txtTitle);
        form.add(new JLabel("Author"));
        form.add(txtAuthor);
        form.add(new JLabel("ISBN"));
        form.add(txtIsbn);
        form.add(new JLabel("Category"));
        form.add(txtCategory);
        form.add(new JLabel("Status"));
        form.add(cmbStatus);

        model = new DefaultTableModel(
                new String[]{"ID", "Title", "Author", "ISBN", "Category", "Status"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttons = new JPanel();
        JButton btnAdd = new JButton("Add");
        JButton btnLoad = new JButton("Load");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        JButton btnClear = new JButton("Clear");

        buttons.add(btnAdd);
        buttons.add(btnLoad);
        buttons.add(btnUpdate);
        buttons.add(btnDelete);
        buttons.add(btnClear);

        add(form, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        btnAdd.addActionListener(e -> addBook());
        btnLoad.addActionListener(e -> loadBooks());
        btnUpdate.addActionListener(e -> updateBook());
        btnDelete.addActionListener(e -> deleteBook());
        btnClear.addActionListener(e -> clearForm());

        table.getSelectionModel().addListSelectionListener(e -> fillFormFromTable());
    }

    // ✅ VALIDATION (unchanged logic, clean)
    private boolean validateData() {

        String title = txtTitle.getText().trim();
        String author = txtAuthor.getText().trim();
        String isbn = txtIsbn.getText().trim();
        String category = txtCategory.getText().trim();

        boolean validTitle = Pattern.matches("^[A-Za-z0-9 ]{2,150}$", title);
        boolean validAuthor = Pattern.matches("^[A-Za-z ]{2,100}$", author);
        boolean validIsbn = Pattern.matches("^[0-9]{10,13}$", isbn);
        boolean validCategory = category.isEmpty()
                || Pattern.matches("^[A-Za-z ]{2,100}$", category);

        return validTitle && validAuthor && validIsbn && validCategory;
    }

    private void addBook() {
        try {
            if (!validateData()) {
                JOptionPane.showMessageDialog(this,
                        "Invalid input!\n" +
                        "- Title: letters & numbers allowed\n" +
                        "- Author: letters only\n" +
                        "- ISBN: 10–13 digits\n" +
                        "- Category: optional (letters only)");
                return;
            }

            Book book = new Book(
                    txtTitle.getText().trim(),
                    txtAuthor.getText().trim(),
                    txtIsbn.getText().trim(),
                    txtCategory.getText().trim(),
                    cmbStatus.getSelectedItem().toString()
            );

            service.addBook(book);
            loadBooks();
            clearForm();

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void updateBook() {
        try {
            if (selectedBookId == -1) {
                JOptionPane.showMessageDialog(this, "Select a book to update");
                return;
            }

            Book book = new Book(
                    txtTitle.getText().trim(),
                    txtAuthor.getText().trim(),
                    txtIsbn.getText().trim(),
                    txtCategory.getText().trim(),
                    cmbStatus.getSelectedItem().toString()
            );
            book.setId(selectedBookId);

            service.updateBook(book);
            loadBooks();
            clearForm();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteBook() {
        try {
            if (selectedBookId == -1) {
                JOptionPane.showMessageDialog(this, "Select a book to delete");
                return;
            }

            service.deleteBook(selectedBookId);
            loadBooks();
            clearForm();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearForm() {
        txtTitle.setText("");
        txtAuthor.setText("");
        txtIsbn.setText("");
        txtCategory.setText("");
        cmbStatus.setSelectedIndex(0);
        selectedBookId = -1;
        table.clearSelection();
    }

    // ✅ ID taken ONLY from table
    private void fillFormFromTable() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            selectedBookId = Integer.parseInt(model.getValueAt(row, 0).toString());
            txtTitle.setText(model.getValueAt(row, 1).toString());
            txtAuthor.setText(model.getValueAt(row, 2).toString());
            txtIsbn.setText(model.getValueAt(row, 3).toString());
            txtCategory.setText(model.getValueAt(row, 4).toString());
            cmbStatus.setSelectedItem(model.getValueAt(row, 5).toString());
        }
    }

    public static void main(String[] args) {
        new LibraryUI().setVisible(true);
    }
}
