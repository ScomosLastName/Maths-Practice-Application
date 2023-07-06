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
		
		additionSelect = new Button("addition");
        subtractionSelect = new Button("subtraction");
        multiplicationSelect = new Button("multiplication");
        divisionSelect = new Button("division");
        
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
}
