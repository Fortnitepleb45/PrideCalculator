import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {
    private Calculator calc; 
    private JTextField inputA;
    private JTextField inputB;
    private JTextField resultField;

    public CalculatorGUI() {
        calc = new Calculator();

        Color[] colors = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY, Color.BLACK, new Color(128, 0, 128), new Color(255, 165, 0), new Color(0, 128, 128)};
        // Window setup
        setTitle("Pride Calculator");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Top input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.add(new JLabel("First Number (A):"));
        inputPanel.setBackground(Math.random() < 0.75 ? colors[(int)(Math.random()*colors.length)] : Color.MAGENTA);
        inputA = new JTextField();
        inputPanel.add(inputA);

        inputPanel.add(new JLabel("Second Number (B):"));
        inputB = new JTextField();
        inputPanel.add(inputB);

        inputPanel.add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(true); // editable result
        inputPanel.add(resultField);

        // Chaining buttons
        JButton useResultAsA = new JButton("Use Result → A");
        JButton useResultAsB = new JButton("Use Result → B");

        useResultAsA.addActionListener(e -> inputA.setText(resultField.getText()));
        useResultAsB.addActionListener(e -> inputB.setText(resultField.getText()));

        inputPanel.add(useResultAsA);
        inputPanel.add(useResultAsB);

        // Buttons Panel (scrollable)
        JPanel buttonPanel = new JPanel(new GridLayout(0, 3, 5, 5));
        buttonPanel.setBackground(Math.random() < 0.75 ? colors[(int)(Math.random()*colors.length +1)] : Math.random() < 0.5 ? Color.BLUE : Color.WHITE);
        addButton(buttonPanel, "Add", (a, b) -> calc.add(a, b));
        addButton(buttonPanel, "Subtract", (a, b) -> calc.subtract(a, b));
        addButton(buttonPanel, "Multiply", (a, b) -> calc.multiply(a, b));
        addButton(buttonPanel, "Divide", (a, b) -> (int) calc.divide(a, b));
        addButton(buttonPanel, "Modulus", (a, b) -> calc.modulus(a, b));
        addButton(buttonPanel, "Power", (a, b) -> (int) calc.power(a, b));
        addButton(buttonPanel, "Square Root (A)", (a, b) -> (int) calc.squareRoot(a));
        addButton(buttonPanel, "Factorial (A)", (a, b) -> (int) calc.factorial(a));
        addButton(buttonPanel, "GCD", (a, b) -> calc.gcd(a, b));
        addButton(buttonPanel, "LCM", (a, b) -> calc.lcm(a, b));
        addButton(buttonPanel, "Is Prime (A)", (a, b) -> calc.isPrime(a) ? 1 : 0);
        addButton(buttonPanel, "Fibonacci (A)", (a, b) -> calc.fibonacci(a));
        addButton(buttonPanel, "Square (A)", (a, b) -> calc.square(a));
        addButton(buttonPanel, "Cube (A)", (a, b) -> calc.cube(a));
        addButton(buttonPanel, "Average", (a, b) -> (int) calc.average(a, b));
        addButton(buttonPanel, "Max", (a, b) -> calc.max(a, b));
        addButton(buttonPanel, "Min", (a, b) -> calc.min(a, b));
        addButton(buttonPanel, "Absolute (A)", (a, b) -> calc.abs(a));
        addButton(buttonPanel, "Negate (A)", (a, b) -> calc.negate(a));
        addButton(buttonPanel, "Increment (A)", (a, b) -> calc.increment(a));
        addButton(buttonPanel, "Decrement (A)", (a, b) -> calc.decrement(a));
        addButton(buttonPanel, "Sum of Digits (A)", (a, b) -> calc.sumOfDigits(a));
        addButton(buttonPanel, "Multiply by 2 (A)", (a, b) -> calc.multiplyByTwo(a));

        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setBackground(Color.cyan);

        // Layout
        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Helper method to create buttons
    private void addButton(JPanel panel, String text, BiOperation op) {
        JButton button = new JButton(text);
        button.setBackground(
            Math.random() < 0.5
                ? (Math.random() < 0.5 ? Color.PINK : Color.BLUE)
                : (Math.random() < 0.5 ? Color.YELLOW : Color.LIGHT_GRAY)
        );
        button.addActionListener(e -> {
            try {
                int a = inputA.getText().isEmpty() ? 0 : Integer.parseInt(inputA.getText());
                int b = inputB.getText().isEmpty() ? 0 : Integer.parseInt(inputB.getText());
                int result = op.apply(a, b);
                resultField.setText(String.valueOf(result));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(button);
    }

    // Functional interface for operations
    @FunctionalInterface
    interface BiOperation {
        int apply(int a, int b);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculatorGUI().setVisible(true);
        });
    }
}
