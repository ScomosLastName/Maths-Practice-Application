package mathsApp;

import java.awt.Button;

import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SubtractionGame extends JPanel implements ActionListener{
	Label questionDisplay;
	TextField answer;
	Button answerButton;
	boolean isPlayerAlive = true;
	int[] questionStored = new int[2]; // array to store question
	
	public static void main(String[] a) {
		JFrame frame = new JFrame("Subtraction Game"); 
        SubtractionGame panel = new SubtractionGame();
        panel.init();
        frame.setSize(300, 300);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	public String generateQuestion() {
		int[] numbers = new int[2];
		numbers[0] = (int) (Math.random() * 100);
		numbers[1] = (int) (Math.random() * 100);
		
		questionStored[0] = numbers[0];
		questionStored[1] = numbers[1];
		
		return numbers[0] + " - " + numbers [1];
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
			System.out.println(questionStored[0] - questionStored[1]);
			questionDisplay.setText(questionStored[0] + " - " + questionStored[1]);
		} else {
			questionDisplay.setBounds(120, 80, 100, 100);
			questionDisplay.setText("You Loose!");
		}
		paintComponents(g);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == answerButton) {
			if (questionStored[0] - questionStored[1] == Integer.parseInt(answer.getText())) {
				System.out.println("Correct");
			} else {
				answer.setVisible(false);
				answerButton.setVisible(false);
				isPlayerAlive = false;
			}
			repaint();
		}
	}
	
	public void keyTyped(KeyEvent e) { // TODO fix Key Detection
		
		if (e.getKeyChar()=='\n') {
			if (questionStored[0] - questionStored[1] == Integer.parseInt(answer.getText())) {
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
