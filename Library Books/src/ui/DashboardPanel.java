package ui;

import java.awt.*;
import javax.swing.*;

public class DashboardPanel extends JPanel {

    public DashboardPanel() {
        setLayout(new GridLayout(2, 4, 15, 15));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        add(createCard("119", "Total Book Issue", new Color(13, 110, 253)));
        add(createCard("118", "Total Book Returned", new Color(255, 193, 7)));
        add(createCard("0", "Book Not Returned", new Color(220, 53, 69)));
        add(createCard("₹ 0", "Total Fines", new Color(25, 135, 84)));

        add(createCard("17", "Total Book", new Color(25, 135, 84)));
        add(createCard("18", "Total Author", new Color(220, 53, 69)));
        add(createCard("4", "Total Category", new Color(255, 193, 7)));
        add(createCard("11", "Location Rack", new Color(13, 110, 253)));
    }

    private JPanel createCard(String value, String label, Color color) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(color);

        JLabel lblValue = new JLabel(value, SwingConstants.CENTER);
        lblValue.setFont(new Font("Arial", Font.BOLD, 28));
        lblValue.setForeground(Color.WHITE);

        JLabel lblText = new JLabel(label, SwingConstants.CENTER);
        lblText.setForeground(Color.WHITE);

        card.add(lblValue, BorderLayout.CENTER);
        card.add(lblText, BorderLayout.SOUTH);

        return card;
    }
}
