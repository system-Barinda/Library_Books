package ui;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel contentPanel;

    public MainFrame() {
        setTitle("Library System");
        setSize(1200, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ===== Sidebar =====
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(33, 37, 41));
        sidebar.setLayout(new GridLayout(10, 1, 0, 10));
        sidebar.setPreferredSize(new Dimension(200, 0));

        JLabel title = new JLabel("Library System", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 16));

        JButton btnDashboard = createMenuButton("Dashboard");
        JButton btnBook = createMenuButton("Book");
        JButton btnCategory = createMenuButton("Category");

        sidebar.add(title);
        sidebar.add(btnDashboard);
        sidebar.add(btnBook);
        sidebar.add(btnCategory);

        // ===== Content =====
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        contentPanel.add(new DashboardPanel(), "dashboard");
        contentPanel.add(new BookPanel(), "book");
        contentPanel.add(new CategoryPanel(), "category");

        // ===== Actions =====
        btnDashboard.addActionListener(e -> cardLayout.show(contentPanel, "dashboard"));
        btnBook.addActionListener(e -> cardLayout.show(contentPanel, "book"));
        btnCategory.addActionListener(e -> cardLayout.show(contentPanel, "category"));

        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    private JButton createMenuButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(52, 58, 64));
        btn.setForeground(Color.WHITE);
        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
