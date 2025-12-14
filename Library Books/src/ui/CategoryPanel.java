package ui;

import java.awt.*;
import javax.swing.*;

public class CategoryPanel extends JPanel {

    public CategoryPanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Category Management", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 22));
        add(label, BorderLayout.CENTER);
    }
}
