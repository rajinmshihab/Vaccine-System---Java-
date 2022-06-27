

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import utility.Utility;

public class Personell extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	boolean personON = false;
	public static int found_index = 0;
	public static String generated_key;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
					Personell frame = new Personell();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
	
	public static String genKey() {
		String key = "";
		Random random = new Random();
		
		for(int i=0; i<4; i++) {
			key += random.nextInt(9);
		}
		
		return key;
	}
	
	public Personell() {
		try {
			Main.readData(Main.peoples);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		setTitle("Covid-19 Vaccination System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 933);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Covid-19 Vaccination Personell");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(287, 0, 602, 69);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(20, 250, 430, 348);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFirstName.setBounds(22, 93, 140, 26);
		panel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Register People");
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(105, 0, 175, 35);
		panel.add(lblNewLabel_1);
		
		// first name
		JLabel lblNewLabel_2 = new JLabel("Fisrt Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(22, 70, 83, 13);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(224, 93, 140, 26);
		panel.add(textField);
		
		// last name
		JLabel lblNewLabel_2_1 = new JLabel("Last Name");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(221, 64, 83, 13);
		panel.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(22, 156, 140, 26);
		panel.add(textField_1);
		
		// nid
		JLabel lblNewLabel_2_2 = new JLabel("NID");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(22, 133, 83, 13);
		panel.add(lblNewLabel_2_2);
		
		// centre drop down
		JLabel lblNewLabel_2_2_1 = new JLabel("Centre");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(221, 135, 83, 13);
		panel.add(lblNewLabel_2_2_1);
		
		JComboBox centerBox = new JComboBox();
		centerBox.setBackground(Color.WHITE);
		//centerBox.setModel(new DefaultComboBoxModel(Utility.getCentreNames(Main.centres)));
		centerBox.setToolTipText("");
		centerBox.setBounds(224, 156, 140, 26);
		panel.add(centerBox);
		
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
		
		// dob date
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(76, 250, 34, 21);
		panel.add(comboBox);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("DOB");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_2.setBounds(22, 250, 34, 13);
		panel.add(lblNewLabel_2_2_2);
		
		// dob month
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1.setToolTipText("");
		comboBox_1.setBounds(128, 250, 45, 21);
		panel.add(comboBox_1);
		
		// dob year
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003"}));
		comboBox_2.setToolTipText("");
		comboBox_2.setBounds(188, 250, 56, 21);
		panel.add(comboBox_2);

		// gender drop down
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Gender");
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_2_1.setBounds(22, 290, 64, 13);
		panel.add(lblNewLabel_2_2_2_1);

		JComboBox genderBox = new JComboBox();
		genderBox.setBackground(Color.WHITE);
		genderBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		genderBox.setToolTipText("");
		genderBox.setBounds(86, 290, 88, 21);
		panel.add(genderBox);
		
		// age
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(85, 330, 64, 21);
		textField_4.setEditable(false);
		panel.add(textField_4);
		
		JLabel lblNewLabel_2_2_2_1_1 = new JLabel("Age");
		lblNewLabel_2_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_2_1_1.setBounds(22, 330, 64, 15);
		panel.add(lblNewLabel_2_2_2_1_1);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = txtFirstName.getText(); // First Name
				System.out.println(fname);
				
				String lname = textField.getText(); //Last Name
				System.out.println(lname);
				
				String cnic = textField_1.getText();
				System.out.println(cnic);     // CNIC
				
				String city = (String) centerBox.getSelectedItem();
				System.out.println(city);     // city
				
				String gender = (String) genderBox.getSelectedItem();
				System.out.println(gender);     // gender
				
				
				//DOB
				Integer date = Integer.parseInt((String) comboBox.getSelectedItem());
				Integer month = Integer.parseInt((String) comboBox_1.getSelectedItem());
				Integer year = Integer.parseInt((String)comboBox_2.getSelectedItem());
				
				LocalDate today = LocalDate.now();
				LocalDate birthday = LocalDate.of(year, month, date);
				
				Period period = Period.between(birthday, today);
				
				textField_4.setText("" + period.getYears());
							
				String dob = date+"/"+month+"/"+year;
				generated_key = genKey();
				
				// type
				String citizenType = (String) typeBox.getSelectedItem();
				
				//Main.peoples.add(new People(fname, lname, dob, cnic, city, String.valueOf(period.getYears()), gender, false, false, generated_key, citizenType ));
				
			
			    JOptionPane.showMessageDialog(new JFrame(),"Your Key: "+ generated_key);  

				
//				Main.displayAll(Main.peoples);
//				
//				try {
//					Main.storeData(Main.peoples);
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(279, 269, 85, 21);
		btnNewButton.setBorderPainted(false);
		panel.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_4.setText("");
				txtFirstName.setText("");
				
				
			}
		});
		btnReset.setBackground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(279, 303, 85, 21);
		btnReset.setBorderPainted(false);

		panel.add(btnReset);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLUE);
		separator_2.setBounds(22, 45, 381, 13);
		panel.add(separator_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 59, 998, 10);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Search by key");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(60, 118, 139, 25);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(60, 153, 140, 26);
		contentPane.add(textField_5);
		
		JButton login = new JButton("Search");

		login.setForeground(Color.WHITE);
		login.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login.setBorderPainted(false);
		login.setBackground(Color.GRAY);
		login.setBounds(266, 147, 85, 36);
		contentPane.add(login);
		
		
		
		
		JButton btnModify = new JButton("Modify Record");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				modify m = new modify();
//				m.setVisible(true);
		
				
				
				
			}
		});
		btnModify.setForeground(Color.WHITE);
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModify.setBorderPainted(false);
		btnModify.setBackground(new Color(128, 128, 0));
		btnModify.setBounds(759, 504, 190, 38);
		contentPane.add(btnModify);
		
		JLabel sname = new JLabel("Name");
		sname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sname.setBounds(501, 176, 199, 13);
		sname.setVisible(false);

		contentPane.add(sname);
		
		JLabel citizenType = new JLabel("Type");
		citizenType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		citizenType.setBounds(501, 200, 199, 21);
		citizenType.setVisible(false);

		contentPane.add(citizenType);
		
		JLabel sage = new JLabel("Age");
		sage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sage.setBounds(501, 223, 139, 21);
		sage.setVisible(false);

		contentPane.add(sage);
		
		JLabel scnin = new JLabel("NID");
		scnin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scnin.setBounds(501, 256, 199, 13);
		scnin.setVisible(false);

		contentPane.add(scnin);
		
		JLabel scity = new JLabel("City");
		scity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scity.setBounds(501, 279, 205, 21);
		scity.setVisible(false);

		contentPane.add(scity);
		
		JLabel sdob = new JLabel("DOB");
		sdob.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sdob.setBounds(501, 303, 205, 25);
		sdob.setVisible(false);

		contentPane.add(sdob);
		
		JLabel sgender = new JLabel("Gender");
		sgender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sgender.setBounds(501, 326, 205, 25);
		sgender.setVisible(false);

		contentPane.add(sgender);
		
		JLabel personNotFound = new JLabel("Person Not Found");
		personNotFound.setForeground(Color.RED);
		personNotFound.setBackground(Color.WHITE);
		personNotFound.setFont(new Font("Tahoma", Font.BOLD, 15));
		personNotFound.setBounds(60, 229, 165, 26);
		personNotFound.setVisible(false);
		contentPane.add(personNotFound);
		
		JButton btnDeleteRecord = new JButton("Delete Record");
		btnDeleteRecord.setForeground(Color.WHITE);
		btnDeleteRecord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteRecord.setBorderPainted(false);
		btnDeleteRecord.setBackground(new Color(0, 0, 128));
		btnDeleteRecord.setBounds(759, 572, 190, 38);
		contentPane.add(btnDeleteRecord);
		
		
		JLabel label_appointment = new JLabel("Appointment set: ");
		label_appointment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_appointment.setBounds(501, 385, 179, 27);
		label_appointment.setVisible(false);
		contentPane.add(label_appointment);
		
		JLabel label_vacc = new JLabel("Vaccinated");
		label_vacc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_vacc.setBounds(501, 416, 179, 27);
		label_vacc.setVisible(false);
		contentPane.add(label_vacc);
		
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Main.displayAll(Main.peoples);
//				Main.displayAllCentres(Main.centres);

				personNotFound.setVisible(false);
				sname.setVisible(false);
				citizenType.setVisible(false);
				sage.setVisible(false);
				scnin.setVisible(false);
				scity.setVisible(false);
				sdob.setVisible(false);
				sgender.setVisible(false);
				label_appointment.setVisible(false);
				label_vacc.setVisible(false);

				String to_search = textField_5.getText();
				System.out.println(to_search);
				
				boolean isFound = false;
				
//				for(int i=0; i<Main.peoples.size(); i++) {
//					if(Main.peoples.get(i).getKey().equals(to_search)) {
//						found_index = i;
//						isFound = true;
//						break;
//						
//					}
//				}
				
				if(isFound) {
					
					personON = true;
					
//					sname.setText("Name: "+ Main.peoples.get(found_index).getFirstname()+" "+Main.peoples.get(found_index).getLastname());
//					citizenType.setText("Type: " + Main.peoples.get(found_index).getType());
//					sage.setText("Age: "+Main.peoples.get(found_index).getAge());
//					scnin.setText("NID: "+Main.peoples.get(found_index).getCNIC());
//					scity.setText("City: "+ Main.peoples.get(found_index).getCity());
//					sdob.setText("DOB: "+ Main.peoples.get(found_index).getDOB());
//					sgender.setText("Gender: "+ Main.peoples.get(found_index).getGender());
					
					sname.setVisible(true);
					citizenType.setVisible(true);
					sage.setVisible(true);
					scnin.setVisible(true);
					scity.setVisible(true);
					sdob.setVisible(true);
					sgender.setVisible(true);
					
					String appt_status = "Appointment Status: ";
					String vacc_status = "Vaccination Status: ";
					
//					if(Main.peoples.get(found_index).isAppointmentSet()) {
//						appt_status += "TRUE";
//						vacc_status += "TRUE";
//					}else {
//						appt_status += "FALSE";
//						vacc_status += "FALSE";
//					}
					
					
					label_vacc.setText(vacc_status);
					label_vacc.setVisible(true);
					
					label_appointment.setText(appt_status);
					label_appointment.setVisible(true);
					

				}
				else {
					personNotFound.setVisible(true);
				}
				
				
			}
		});
		
		btnDeleteRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!personON) {
				    JOptionPane.showMessageDialog(new JFrame(),"Select a Record to Delete.");  

					
				}else {
					
//					Main.peoples.remove(found_index);
//					try {
//						Main.storeData(Main.peoples);
//					} catch (IOException e1) {
//						
//						e1.printStackTrace();
//					}
					
				    JOptionPane.showMessageDialog(new JFrame(),"Record Deleted.");  
				    personNotFound.setVisible(false);
					sname.setVisible(false);
					sage.setVisible(false);
					scnin.setVisible(false);
					scity.setVisible(false);
					sdob.setVisible(false);
					sgender.setVisible(false);
					label_appointment.setVisible(false);
					label_vacc.setVisible(false);


				}
				
			}
		});
		
		
		JButton btnSetAppointment = new JButton("Set Appointment");
		btnSetAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String searchIndex = textField_5.getText();
				int ind = 0;
				
				
				
//				for(int i=0; i<Main.peoples.size(); i++) {
//					if(Main.peoples.get(i).getKey().equals(searchIndex)) {
//						ind = i;
//						break;
//						
//					}
//				}
				
//				Main.peoples.get(ind).setAppointmentSet(true);
//				Main.peoples.get(ind).setVaccinated(true);
//				
//				try {
//					Main.storeData(Main.peoples);
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				JOptionPane.showMessageDialog(new JFrame(),"Appointment and Vaccination Status Set.");  
				
			}
		});
		btnSetAppointment.setForeground(Color.WHITE);
		btnSetAppointment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSetAppointment.setBorderPainted(false);
		btnSetAppointment.setBackground(new Color(255, 0, 255));
		btnSetAppointment.setBounds(501, 572, 190, 38);
		contentPane.add(btnSetAppointment);
		
		JButton btnRemoveAppointment = new JButton("Remove Appointment");
		btnRemoveAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String searchIndex = textField_5.getText();
				int ind = 0;
				
				
				
//				for(int i=0; i<Main.peoples.size(); i++) {
//					if(Main.peoples.get(i).getKey().equals(searchIndex)) {
//						ind = i;
//						break;
//						
//					}
//				}
//				
//				Main.peoples.get(ind).setAppointmentSet(false);
//				Main.peoples.get(ind).setVaccinated(false);
//				
//				try {
//					Main.storeData(Main.peoples);
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
				
				JOptionPane.showMessageDialog(new JFrame(),"Appointment and Vaccination Status Removed.");  
				
				
			}
		});
		btnRemoveAppointment.setForeground(Color.BLACK);
		btnRemoveAppointment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemoveAppointment.setBorderPainted(false);
		btnRemoveAppointment.setBackground(new Color(0, 128, 0));
		btnRemoveAppointment.setBounds(501, 504, 190, 38);
		contentPane.add(btnRemoveAppointment);
	}
	
}
