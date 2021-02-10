package com.java8.ooad.workouts;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Panel to display the contact list when name matches
 * 
 * @author Venkat
 *
 */
public class PhoneDirectory extends JFrame{
	
	static List<String> contactList = null;
	
	private JFrame phoneFrame;
	
	private JTextField nameField = null;
	
	private JTextArea phoneContactArea = null;
	
	static {
		contactList = Arrays.asList("Venkat","Bharani","Chris","Dinesh","Elvin","Francis","Gopalakrishnan");
	}
	
	public void initalize() {
		 phoneFrame = new JFrame("panel"); 
	        // create a label to display text 
		 JLabel label = new JLabel("Phone Directory");
		 JPanel phonePanel = new JPanel();
		 JLabel nameLabel = new JLabel("Name");
		 nameField  = new JTextField(25);
		 nameField.addKeyListener(new PhoneFieldListener());
		 nameLabel.setBounds(10, 40, 25, 2);
		 nameField.setBounds(10, 40, 25, 2);
		 phoneContactArea = new JTextArea(20,20);
		 phoneContactArea.setBounds(10, 80, 100, 100);
		 for (String string : contactList) {
			phoneContactArea.append(string+"\n");
			phoneContactArea.revalidate();
		 }
		 phonePanel.add(label);
		 phonePanel.add(nameLabel);
		 phonePanel.add(nameField);
		 phonePanel.add(phoneContactArea);
		 phoneFrame.add(phonePanel);
		 phoneFrame.setSize(500, 500);
		 phoneFrame.show();
	}
	
	public class PhoneFieldListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			StringBuilder sb = new StringBuilder();
			for (String contact : contactList) {
				String textName = getNameField().getText().toString();
				if(contact.toLowerCase().indexOf(textName) != -1) {
					sb.append(contact+"\n");
				}
			}
			if(sb.toString() !=null && !sb.toString().equals("")) {
				getPhoneContactArea().setText("");
				getPhoneContactArea().append(sb.toString());
			}
				
		}

		
	}
	
	public JTextField getNameField() {
		return nameField;
	}



	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}


	public JTextArea getPhoneContactArea() {
		return phoneContactArea;
	}



	public void setPhoneContactArea(JTextArea phoneContactArea) {
		this.phoneContactArea = phoneContactArea;
	}



	public static void main(String[] args) {
		PhoneDirectory pd = new PhoneDirectory();
		pd.initalize();
	}
}
