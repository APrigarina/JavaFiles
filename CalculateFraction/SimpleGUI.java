package fraction;

import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SimpleGUI extends JFrame {

	private JButton button = new JButton("Count");
	private JTextField input = new JTextField("", 20);
	private JLabel label = new JLabel("Input:");
	private JTextField output = new JTextField("", 20);
	private JLabel label2 = new JLabel("Output:");
	CalculateFraction summa = new CalculateFraction();

	public SimpleGUI() {
		super("Calculator");
		this.setBounds(400, 300, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = this.getContentPane();
		setLayout(null);
		
		label.setBounds(160, 0, 200, 50);
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		container.add(label);
		
		input.setFont(new Font("Tahoma", Font.PLAIN, 17));
		input.setBounds(90, 50, 200, 50);
		container.add(input);
		
		label2.setBounds(160, 100, 200, 50);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		container.add(label2);
		
		output.setFont(new Font("Tahoma", Font.PLAIN, 17));
		output.setBounds(90, 150, 200, 50);
		container.add(output);

		button.addActionListener(new ButtonEventListener());
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBounds(115, 250, 150, 50);
		container.add(button);
	}

	class ButtonEventListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String message = "";
			message = summa.poland(input.getText()).toString();
			output.setText(message);

		}
	}

	public static void main(String[] args) {
		SimpleGUI app = new SimpleGUI();
		app.setVisible(true);
	}
}