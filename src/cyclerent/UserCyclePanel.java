package cyclerent;

import Model.Cycle;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.util.List;

public class UserCyclePanel extends JPanel {

    private JPanel gridContainer;
    private JTextField searchField;
    private Login parentFrame; 
    private ArrayList<Cycle> allCycles;

    public UserCyclePanel(Login parent, ArrayList<Cycle> sharedCycles) {
        this.allCycles = sharedCycles; 
        this.parentFrame = parent; 
        initComponents();
        displayCycles(allCycles);
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 245));

        // --- TOP NAVIGATION BAR ---
        JPanel navBar = new JPanel(new BorderLayout(20, 0));
        navBar.setBackground(new Color(33, 37, 41));
        navBar.setBorder(new EmptyBorder(15, 25, 15, 25));

        JLabel title = new JLabel("CYCLE EXPLORER");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        navBar.add(title, BorderLayout.WEST);

        // Search Section
        JPanel searchBox = new JPanel(new FlowLayout());
        searchBox.setOpaque(false);
        searchField = new JTextField(20);
        searchField.setPreferredSize(new Dimension(200, 30));
        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(e -> performSearch());
        
        searchBox.add(searchField);
        searchBox.add(searchBtn);
        navBar.add(searchBox, BorderLayout.CENTER);

        // Logout Button
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.addActionListener(e -> parentFrame.resetToLogin());
        navBar.add(logoutBtn, BorderLayout.EAST);

        add(navBar, BorderLayout.NORTH);

        // --- CYCLE GRID ---
        gridContainer = new JPanel(new GridLayout(0, 3, 25, 25));
        gridContainer.setBackground(new Color(245, 245, 245));
        gridContainer.setBorder(new EmptyBorder(30, 30, 30, 30));

        JScrollPane scrollPane = new JScrollPane(gridContainer);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void displayCycles(List<Cycle> data) {
        gridContainer.removeAll();
        for (Cycle cycle : data) {
            gridContainer.add(createModernCard(cycle));
        }
        gridContainer.revalidate();
        gridContainer.repaint();
    }

    private JPanel createModernCard(Cycle cycle) {
        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));

        // --- IMAGE SECTION ---
        JLabel imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(200, 150));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Attempting to load from: src/image/Mountain Bike.jpg
        // Note: Java resource paths use forward slashes /
        String imageName = cycle.getModel() + ".jpg";
        java.net.URL imgURL = getClass().getResource("/image/" + imageName);

        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage().getScaledInstance(200, 140, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        } else {
            imageLabel.setText("Image not found: " + imageName);
            imageLabel.setFont(new Font("Arial", Font.ITALIC, 10));
        }
        card.add(imageLabel, BorderLayout.NORTH);

        // --- DETAILS SECTION ---
        JPanel details = new JPanel(new GridLayout(3, 1, 5, 5));
        details.setOpaque(false);
        details.setBorder(new EmptyBorder(0, 10, 0, 10));
        
        JLabel name = new JLabel(cycle.getModel());
        name.setFont(new Font("Segoe UI", Font.BOLD, 16));
        details.add(name);
        
        JLabel price = new JLabel("Rate: Rs. " + cycle.getPrice() + "/hr");
        price.setForeground(new Color(0, 102, 102));
        details.add(price);
        
        JLabel status = new JLabel("● " + cycle.getStatus());
        boolean isAvailable = cycle.getStatus().equalsIgnoreCase("Available");
        status.setForeground(isAvailable ? new Color(40, 167, 69) : new Color(220, 53, 69));
        details.add(status);

        card.add(details, BorderLayout.CENTER);

        // --- ACTION BUTTON ---
        JButton rentBtn = new JButton(isAvailable ? "Rent Now" : "Currently In Use");
        rentBtn.setEnabled(isAvailable);
        rentBtn.setBackground(isAvailable ? new Color(0, 102, 102) : Color.GRAY);
        rentBtn.setForeground(Color.WHITE);
        
        rentBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Do you want to rent the " + cycle.getModel() + "?", 
                "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                cycle.setStatus("In Use"); // This updates the static list in Login
                displayCycles(allCycles); // Re-renders the grid
                JOptionPane.showMessageDialog(this, "Rental Confirmed!");
            }
        });
        card.add(rentBtn, BorderLayout.SOUTH);

        return card;
    }

    private void performSearch() {
        String query = searchField.getText().toLowerCase();
        List<Cycle> filtered = new ArrayList<>();
        for (Cycle c : allCycles) {
            if (c.getModel().toLowerCase().contains(query)) {
                filtered.add(c);
            }
        }
        displayCycles(filtered);
    }
}