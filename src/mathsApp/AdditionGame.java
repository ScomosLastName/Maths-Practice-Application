package mathsApp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AdditionGame extends JPanel implements ActionListener {
	Label questionDisplay;
	TextField answer;
	JButton answerButton;
	boolean isPlayerAlive = true;
	int[] questionStored = new int[2]; // array to store question
	int score;
	
	public static void main(String[] a) {
		JFrame frame = new JFrame("Addition Game"); 
        AdditionGame panel = new AdditionGame();
        panel.init();
        panel.setLayout(null);
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
		
		return numbers[0] + " + " + numbers [1];
	}
	
	
	
	public void init() {
		
		
		
		questionDisplay = new Label(generateQuestion());
		answer = new TextField(10);
		answerButton = new JButton("Answer");
		
		add (questionDisplay);
		add (answer);
		add (answerButton);
		
		answerButton.addActionListener(this);
		
		questionDisplay.setBounds(125, 10, 100, 25);
		answer.setBounds(125, 50, 100, 20);
		answerButton.setBounds(10, 50, 80, 20);
	}
	
	public void paint(Graphics g) {
		generateQuestion();
		if (isPlayerAlive) {
			System.out.println(questionStored[0] + questionStored[1]);
			questionDisplay.setText(questionStored[0] + " + " + questionStored[1]);
		} else {
			questionDisplay.setBounds(115, 20, 100, 100);
			questionDisplay.setText("You Loose!");
			g.drawString("your score was: " + score, 115, 130);
		}
		paintComponents(g);
	}

	public void actionPerformed(ActionEvent e) { //TODO Fix Weird thing that pops up when you press the jButton
		if (e.getSource() == answerButton) {
			if (questionStored[0] + questionStored[1] == Integer.parseInt(answer.getText())) {
				System.out.println("Correct");
				answer.setText("");
				answer.requestFocus();
				score++;
				
				answerButton.setVisible(true);
			} else {
				answer.setVisible(false);
				answerButton.setVisible(false);
				isPlayerAlive = false;
			}
			repaint();
		}
	}
	
	public void keyPressed(KeyEvent e) { // TODO fix Key Detection

		
	}
}
