import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utility.Utility;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.awt.event.ActionEvent;

public class modify extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modify frame = new modify();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public modify() {
		
		People selectedPeople = Main.peoples.get(register.found_index);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 463);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		panel.setBounds(63, 31, 423, 347);
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(22, 93, 140, 26);
		panel.add(textField);
		
		textField.setText(selectedPeople.getFirstname());
		
		JLabel lblNewLabel_1 = new JLabel("Update Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(109, 10, 228, 35);
		panel.add(lblNewLabel_1);
		
		// first name
		JLabel lblNewLabel_2 = new JLabel("Fisrt Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(22, 70, 83, 13);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(224, 93, 140, 26);
		panel.add(textField_1);
		
		textField_1.setText(selectedPeople.getLastname());
		
		// last name
		JLabel lblNewLabel_2_1 = new JLabel("Last Name");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(221, 64, 83, 13);
		panel.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(22, 156, 140, 26);
		panel.add(textField_2);
		
		textField_2.setText(selectedPeople.getCNIC());
		
		// nid
		JLabel lblNewLabel_2_2 = new JLabel("NID");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(22, 133, 83, 13);
		panel.add(lblNewLabel_2_2);
		
		
		// centre
		JLabel lblNewLabel_2_2_1 = new JLabel("Centre");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(221, 135, 83, 13);
		panel.add(lblNewLabel_2_2_1);
		
		JComboBox centerBox = new JComboBox();
		centerBox.setBackground(Color.WHITE);
		centerBox.setModel(new DefaultComboBoxModel(Utility.getCentreNames(Main.centres)));
		centerBox.setToolTipText("");
		centerBox.setBounds(224, 156, 140, 26);
		panel.add(centerBox);
		
		centerBox.setSelectedIndex(Utility.getCentreFoundIndex(Main.centres, selectedPeople.getCity()));
		
		// type drop down
		JLabel type = new JLabel("Type");
		type.setFont(new Font("Tahoma", Font.PLAIN, 15));
		type.setBounds(22, 200, 64, 21);
		panel.add(type);
		
		
		JComboBox typeBox = new JComboBox();
		typeBox.setBackground(Color.WHITE);
		typeBox.setModel(new DefaultComboBoxModel(new String[] {"Citizen", "Non-Citizen"}));
		typeBox.setToolTipText("");
		typeBox.setBounds(76, 200, 120, 21);
		panel.add(typeBox);
		
		typeBox.setSelectedIndex(selectedPeople.getType().equals("Citizen") ? 0 : 1);
		
		
		// dob date
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

		comboBox.setToolTipText("");
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(76, 235, 45, 21);
		panel.add(comboBox);
		
		comboBox.setSelectedIndex(Integer.parseInt(selectedPeople.getDOB().split("/")[0]) - 1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("DOB");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_2.setBounds(22, 235, 34, 13);
		panel.add(lblNewLabel_2_2_2);
		
		// dob month
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));

		comboBox_1.setToolTipText("");
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(128, 235, 45, 21);
		panel.add(comboBox_1);
		
		comboBox_1.setSelectedIndex(Integer.parseInt(selectedPeople.getDOB().split("/")[1]) - 1);
		
		// dob year
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003"}));

		comboBox_2.setToolTipText("");
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(188, 235, 56, 21);
		panel.add(comboBox_2);
		
		comboBox_2.setSelectedIndex(Integer.parseInt(selectedPeople.getDOB().split("/")[2]) - 1990);
		
		// gender
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Gender");
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_2_1.setBounds(22, 273, 64, 13);
		panel.add(lblNewLabel_2_2_2_1);
		
		JComboBox genderBox = new JComboBox();
		genderBox.setBackground(Color.WHITE);
		genderBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		genderBox.setToolTipText("");
		genderBox.setBounds(86, 273, 88, 21);
		panel.add(genderBox);
		
		genderBox.setSelectedIndex(selectedPeople.getGender().equals("Male") ? 0 : 1);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(85, 303, 64, 21);
		panel.add(textField_5);
		
		textField_5.setText(selectedPeople.getAge());
		
		JLabel lblNewLabel_2_2_2_1_1 = new JLabel("Age");
		lblNewLabel_2_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_2_1_1.setBounds(22, 303, 64, 21);
		panel.add(lblNewLabel_2_2_2_1_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname = textField.getText(); // First Name
				System.out.println(fname);
				
				String lname = textField_1.getText(); //Last Name
				System.out.println(lname);
				
				String cnic = textField_2.getText();
				System.out.println(cnic);     // Nid
				
				String city = (String) centerBox.getSelectedItem();
				System.out.println(city);     // city
				
				String gender = (String) genderBox.getSelectedItem();
				System.out.println(gender);    // gender
				
				
				//DOB
				Integer date = Integer.parseInt((String) comboBox.getSelectedItem());
				Integer month = Integer.parseInt((String) comboBox_1.getSelectedItem());
				Integer year = Integer.parseInt((String)comboBox_2.getSelectedItem());
				
				LocalDate today = LocalDate.now();
				LocalDate birthday = LocalDate.of(year, month, date);
				
				Period period = Period.between(birthday, today);
				
				textField_5.setText("" + period.getYears());
				
				String dob = date+"/"+month+"/"+year;
				
				String citizenType = (String) typeBox.getSelectedItem();
				
				Main.peoples.get(register.found_index).setFirstname(fname);
				Main.peoples.get(register.found_index).setLastname(lname);
				Main.peoples.get(register.found_index).setType(citizenType);;
				Main.peoples.get(register.found_index).setCNIC(cnic);
				Main.peoples.get(register.found_index).setCity(city);
				Main.peoples.get(register.found_index).setGender(gender);
				Main.peoples.get(register.found_index).setAge(String.valueOf(period.getYears()));
				Main.peoples.get(register.found_index).setDOB(dob);
				
				
			    JOptionPane.showMessageDialog(new JFrame(),"Information Updated!");  

				try {
					Main.storeData(Main.peoples);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(279, 269, 85, 21);
		panel.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBorderPainted(false);
		btnReset.setBackground(Color.WHITE);
		btnReset.setBounds(279, 303, 85, 21);
		panel.add(btnReset);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLUE);
		separator_2.setBounds(22, 45, 381, 13);
		panel.add(separator_2);
	}

}
