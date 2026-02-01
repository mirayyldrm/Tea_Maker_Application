import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TeaMakerView extends JFrame implements Observer {
    private TeaMakerModel model;
    private JButton btnFilled, btnStart, btnBoil, btnReset, btnTotalCups;
    private JTextField txtCups;
    private JLabel lblIdle, lblTea, lblBoiling, lblDone;
    private JLabel lblMonthlyCount;
    private JLabel lblMessage;
    private JLabel lblDay, lblDate;
    private JLabel lblImagePlaceholder;

    public TeaMakerView(TeaMakerModel model) {
        this.model = model;
        model.registerObserver(this);

        setTitle("Tea Maker");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Font fontBold = new Font("Arial", Font.BOLD, 16);

        btnFilled = new JButton("FILLED");
        btnFilled.setFont(fontBold);
        btnFilled.setBorder(border);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridheight = 1;
        add(btnFilled, gbc);

        txtCups = new JTextField("0");
        txtCups.setHorizontalAlignment(JTextField.CENTER);
        txtCups.setFont(fontBold);
        txtCups.setBorder(border);
        gbc.gridx = 1; gbc.gridy = 0;
        add(txtCups, gbc);

        JPanel startPanel = new JPanel(new BorderLayout());
        startPanel.setBorder(border);
        startPanel.setBackground(Color.WHITE);

        lblImagePlaceholder = new JLabel("☕\uFE0F");
        lblImagePlaceholder.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagePlaceholder.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 80));
        startPanel.add(lblImagePlaceholder, BorderLayout.CENTER);

        btnStart = new JButton("START");
        btnStart.setFont(new Font("Arial", Font.BOLD, 24));
        btnStart.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createLineBorder(Color.BLACK, 1)
        ));
        btnStart.setContentAreaFilled(false);
        startPanel.add(btnStart, BorderLayout.SOUTH);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridheight = 4;
        add(startPanel, gbc);

        gbc.gridx = 1;
        gbc.gridheight = 1;

        lblIdle = createStatusLabel("IDLE", border);
        gbc.gridy = 1; add(lblIdle, gbc);

        lblTea = createStatusLabel("MAKING TEA", border);
        gbc.gridy = 2; add(lblTea, gbc);

        lblBoiling = createStatusLabel("BOILING WATER", border);
        gbc.gridy = 3; add(lblBoiling, gbc);

        lblDone = createStatusLabel("DONE", border);
        gbc.gridy = 4; add(lblDone, gbc);

        btnTotalCups = new JButton("Total Cups");
        btnTotalCups.setFont(fontBold);
        btnTotalCups.setBorder(border);
        gbc.gridx = 0; gbc.gridy = 5;
        add(btnTotalCups, gbc);

        lblMonthlyCount = new JLabel("0", SwingConstants.CENTER);
        lblMonthlyCount.setFont(fontBold);
        lblMonthlyCount.setBorder(border);
        lblMonthlyCount.setOpaque(true);
        lblMonthlyCount.setBackground(Color.WHITE);
        gbc.gridx = 1; gbc.gridy = 5;
        add(lblMonthlyCount, gbc);

        btnBoil = new JButton("BOIL WATER");
        btnBoil.setFont(fontBold);
        btnBoil.setBorder(border);
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(btnBoil, gbc);


        lblMessage = new JLabel("Welcome!", SwingConstants.CENTER);
        lblMessage.setFont(new Font("Arial", Font.BOLD, 12));
        lblMessage.setForeground(Color.RED);
        lblMessage.setBorder(border);
        lblMessage.setOpaque(true);
        lblMessage.setBackground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.gridwidth = 2;
        add(lblMessage, gbc);

        gbc.gridwidth = 1;

        lblDay = new JLabel(LocalDate.now().getDayOfWeek().toString(), SwingConstants.CENTER);
        lblDay.setBorder(border);
        lblDay.setFont(fontBold);
        gbc.gridx = 0; gbc.gridy = 8;
        add(lblDay, gbc);

        lblDate = new JLabel(LocalDate.now().toString(), SwingConstants.CENTER);
        lblDate.setBorder(border);
        lblDate.setFont(fontBold);
        gbc.gridx = 1; gbc.gridy = 8;
        add(lblDate, gbc);

        btnReset = new JButton("Reset");
        btnReset.setFont(fontBold);
        btnReset.setBorder(border);
        gbc.gridx = 0; gbc.gridy = 9;
        gbc.gridwidth = 2;
        add(btnReset, gbc);

        update("EMPTY", "Please fill the machine.", 0);
        setVisible(true);
    }

    private JLabel createStatusLabel(String text, Border border) {
        JLabel lbl = new JLabel(text, SwingConstants.CENTER);
        lbl.setOpaque(true);
        lbl.setBackground(Color.WHITE);
        lbl.setFont(new Font("Arial", Font.BOLD, 14));
        lbl.setBorder(border);
        return lbl;
    }

    @Override
    public void update(String stateName, String message, int cupCount) {

        lblIdle.setBackground(Color.WHITE);
        lblTea.setBackground(Color.WHITE);
        lblBoiling.setBackground(Color.WHITE);
        lblDone.setBackground(Color.WHITE);

        switch (stateName) {
            case "IDLE": lblIdle.setBackground(Color.YELLOW); break;
            case "MAKING TEA": lblTea.setBackground(Color.YELLOW); break;
            case "BOILING WATER": lblBoiling.setBackground(Color.YELLOW); break;
            case "DONE": lblDone.setBackground(Color.YELLOW); break;
        }

        lblMessage.setText(message);

        boolean isWorking = stateName.equals("MAKING TEA") || stateName.equals("BOILING WATER");
        btnFilled.setEnabled(!isWorking);
        btnStart.setEnabled(!isWorking);
        btnBoil.setEnabled(!isWorking);
        btnReset.setEnabled(!isWorking);
    }

    public void setFilledListener(ActionListener l) {
        btnFilled.addActionListener(l);
    }
    public void setStartListener(ActionListener l) {
        btnStart.addActionListener(l);
    }
    public void setBoilListener(ActionListener l) {
        btnBoil.addActionListener(l);
    }
    public void setResetListener(ActionListener l) {
        btnReset.addActionListener(l);
    }
    public void setTotalCupsListener(ActionListener l) {
        btnTotalCups.addActionListener(l);
    }

    public String getCupInput() {
        return txtCups.getText();
    }

    public void setMonthlyCountDisplay(int count) {
        lblMonthlyCount.setText(String.valueOf(count));
    }
}