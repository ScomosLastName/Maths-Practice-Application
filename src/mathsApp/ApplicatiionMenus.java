package mathsApp;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ApplicatiionMenus extends JPanel implements ActionListener{
	Label prompt1;
	Button additionSelect, subtractionSelect, multiplicationSelect, divisionSelect; 
	
	public void init() {
		//instantiate components
		prompt1 = new Label("Select Gamemode!");
		
		additionSelect = new Button("Addition");
        subtractionSelect = new Button("Subtraction");
        multiplicationSelect = new Button("Multiplication");
        divisionSelect = new Button("Division");
        
        //add components to the panel
        add(prompt1);
        add(additionSelect);
        add(subtractionSelect);
        add(multiplicationSelect);
        add(divisionSelect);
        
        additionSelect.addActionListener(this);
        subtractionSelect.addActionListener(this);
        multiplicationSelect.addActionListener(this);
        divisionSelect.addActionListener(this);
        
        prompt1.setLocation(80, 100);
        
        additionSelect.setLocation(100, 100);
        subtractionSelect.setLocation(100, 120);
        multiplicationSelect.setLocation(100, 140);
        divisionSelect.setLocation(100, 160);
	}
	
	public void paint(Graphics g) {
		paintComponent(g);
	}
	
	 public static void main(String[] a) {
	        JFrame frame = new JFrame("Calculator"); 
	        ApplicatiionMenus panel = new ApplicatiionMenus();
	        panel.init();
	        frame.setSize(300, 300);
	        frame.add(panel);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == additionSelect) {
        	AdditionGame.main(null);
        } else if (e.getSource() == subtractionSelect) {
        	SubtractionGame.main(null);
        } else if (e.getSource() == multiplicationSelect) {
        	MultiplicationGame.main(null);
        } else if (e.getSource() == divisionSelect) {
        	
        }
	}
	

}
