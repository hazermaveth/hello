import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class main {
	//Setting up variable to gather student info from the form
	public static String studentName = "";
	public static int year = 0;
	public static String studentID = "";
	public static String semester = "";
	public static String studentMajor = "";


	public static void main(String[] args) {
		//Set up the main window
		JFrame myFrame = new JFrame("Advising");
		myFrame.setLayout(new GridLayout(6,1));
		myFrame.setSize(500, 500);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setResizable(false);

		//Set up the first panel containing the label and text field for studentName
		JPanel panelOne = new JPanel();
		panelOne.setBackground(new Color(0,152,0));
		JLabel labelOne = new JLabel("Enter Your Name: ");
		JTextField fieldOne = new JTextField(20);

		//Set up the second panel containing the label and text field for year
		JPanel panelTwo = new JPanel();
		panelTwo.setBackground(new Color(192,192,192));
		JLabel labelTwo = new JLabel("Enter Year for Calculation: ");
		JTextField fieldTwo = new JTextField(20);

		//Set up the third panel containing the label and text field for studentID
		JPanel panelThree = new JPanel();
		panelThree.setBackground(new Color(192,192,192));
		JLabel labelThree = new JLabel("Enter Student ID: ");
		JTextField fieldThree = new JTextField(20);


		//Set up the fourth panel and radio buttons for semester
		JPanel panelFive = new JPanel();
		panelFive.setBackground(new Color(0,152,0));
		JLabel labelFive = new JLabel("Semester for Calculation: ");
		JRadioButton radioOne = new JRadioButton("Fall");
		radioOne.setSelected(true);
		JRadioButton radioTwo = new JRadioButton("Spring");
		ButtonGroup group = new ButtonGroup();
		group.add(radioOne);
		group.add(radioTwo);
		
		//Set up sixth panel for studentMajor
		JPanel panelSix = new JPanel();
		panelSix.setBackground(new Color(0,152,0));
		JLabel labelSix = new JLabel("Enter Your Major: ");
		JTextField fieldSix = new JTextField(20);


		//Set up the fifth panel for the calculate button
		JPanel panelFour = new JPanel();
		panelFour.setBackground(new Color(192,192,192));
		JButton buttonOne = new JButton("Calculate");

		//Adds an action listener to the button to gather all information when pressed
		buttonOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Things to do when button is pressed
				
				studentName = fieldOne.getText();
				System.out.println(studentName);

				year = Integer.parseInt(fieldTwo.getText());
				System.out.println(year);

				studentID = fieldThree.getText();
				System.out.println(studentID);
				
				studentMajor = fieldSix.getText();
				

				if(radioOne.isSelected()){
					semester = radioOne.getText();
				}else{
					semester = radioTwo.getText();
				}
				System.out.println(semester);
				advisor test = new advisor(studentID);
				test.setMajor(studentMajor);
				test.setYear(year);
				test.setSemester(semester);
				test.start();
				
				JOptionPane.showMessageDialog(null, test.stringReq());

			}
		});



		//Adding all components and panels to their respective panel or frame
		panelOne.add(labelOne);
		panelOne.add(fieldOne);
		panelTwo.add(labelTwo);
		panelTwo.add(fieldTwo);
		panelThree.add(labelThree);
		panelThree.add(fieldThree);
		panelFour.add(buttonOne);
		panelFive.add(labelFive);
		panelFive.add(radioOne);
		panelFive.add(radioTwo);
		panelSix.add(labelSix);
		panelSix.add(fieldSix);
		myFrame.add(panelOne);
		myFrame.add(panelThree);
		myFrame.add(panelSix);
		myFrame.add(panelTwo);
		myFrame.add(panelFive);
		myFrame.add(panelFour);

		//Show the main frame
		myFrame.setVisible(true);




		


	}

}
