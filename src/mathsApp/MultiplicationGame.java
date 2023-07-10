package mathsApp;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MultiplicationGame extends JPanel implements ActionListener {
	Label questionDisplay;
	TextField answer;
	Button answerButton;
	boolean isPlayerAlive = true;
	int[] questionStored = new int[2]; // array to store question
	
	public static void main(String[] a) {
		JFrame frame = new JFrame("Subtraction Game"); 
        MultiplicationGame panel = new MultiplicationGame();
        panel.init();
        frame.setSize(300, 300);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	public String generateQuestion() { //TODO Stop Repeat Questions
		int[] numbers = new int[2];
		numbers[0] = (int) (Math.random() * 12);
		numbers[1] = (int) (Math.random() * 12);
		
		questionStored[0] = numbers[0];
		questionStored[1] = numbers[1];
		
		return numbers[0] + " x " + numbers [1];
	}
	
	
	
	public void init() {
		
		questionDisplay = new Label(generateQuestion());
		answer = new TextField(10);
		answerButton = new Button("Confirm");
		
		add (questionDisplay);
		add (answer);
		add (answerButton);
		
		answerButton.addActionListener(this);
	}
	
	public void paint(Graphics g) {
		
		
		generateQuestion();
		if (isPlayerAlive) {
			System.out.println(questionStored[0] * questionStored[1]);
			questionDisplay.setText(questionStored[0] + " x " + questionStored[1]);
		} else {
			questionDisplay.setBounds(120, 80, 100, 100);
			questionDisplay.setText("You Loose!");
		}
		paintComponents(g);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == answerButton) {
			if (questionStored[0] * questionStored[1] == Integer.parseInt(answer.getText())) {
				System.out.println("Correct");
			} else {
				answer.setVisible(false);
				answerButton.setVisible(false);
				isPlayerAlive = false;
			}
			repaint();
		}
	}
}
