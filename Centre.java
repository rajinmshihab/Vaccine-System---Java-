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
import model.VaccCentre;

public class Centre extends JFrame {

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
					Centre frame = new Centre();
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
	
	public Centre() {
		try {
			Main.readData(Main.peoples);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		setTitle("Covid-19 Vaccination System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1091, 933);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Covid-19 Vaccination Centre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(287, 0, 602, 69);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(20, 300, 430, 348);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// centre name field
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFirstName.setBounds(22, 93, 140, 26);
		panel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Add Vaccination Centre");
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(93, 11, 250, 35);
		panel.add(lblNewLabel_1);
		
		// centre name
		JLabel lblNewLabel_2 = new JLabel("Centre Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(22, 70, 100, 21);
		panel.add(lblNewLabel_2);
		
		// quantity field
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(263, 93, 140, 26);
		panel.add(textField);
		
		// vaccine quantity
		JLabel lblNewLabel_2_1 = new JLabel("Vaccine Supply");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(263, 70, 130, 21);
		panel.add(lblNewLabel_2_1);
	
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtFirstName.getText(); // centre name
				System.out.println(name);
				
				String quantity = textField.getText(); //quantity
				System.out.println(quantity);
				
	
				Main.centres.add(new VaccCentre(name, Integer.parseInt(quantity)));			
					
			
			    JOptionPane.showMessageDialog(new JFrame(), name + " is added as a new Vaccincation Centre");  

				
				Main.displayAllCentres(Main.centres);
				
				try {
					Main.storeCentre(Main.centres);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(93, 264, 85, 21);
		btnNewButton.setBorderPainted(false);
		panel.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				txtFirstName.setText("");
				
				
			}
		});
		btnReset.setBackground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(224, 264, 85, 21);
		btnReset.setBorderPainted(true);

		panel.add(btnReset);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLUE);
		separator_2.setBounds(25, 45, 381, 13);
		panel.add(separator_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 59, 998, 10);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Search by name");
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
				
				CentreModify m = new CentreModify();
				m.setVisible(true);
		
				
				
				
			}
		});
		btnModify.setForeground(Color.WHITE);
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModify.setBorderPainted(false);
		btnModify.setBackground(new Color(128, 128, 0));
		btnModify.setBounds(533, 572, 190, 38);
		contentPane.add(btnModify);
		
		JLabel centreName = new JLabel("Centre Name");
		centreName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		centreName.setBounds(501, 176, 199, 21);
		centreName.setVisible(false);

		contentPane.add(centreName);
		
		JLabel supply = new JLabel("Supply");
		supply.setFont(new Font("Tahoma", Font.PLAIN, 15));
		supply.setBounds(501, 200, 199, 21);
		supply.setVisible(false);

		contentPane.add(supply);
	
		
		JLabel personNotFound = new JLabel("Centre Not Found");
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
		
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.displayAll(Main.peoples);
				Main.displayAllCentres(Main.centres);

				personNotFound.setVisible(false);
				centreName.setVisible(false);
				supply.setVisible(false);

				String to_search = textField_5.getText();
				System.out.println(to_search);
				
				boolean isFound = false;
				
				for(int i=0; i<Main.centres.size(); i++) {
					if(Main.centres.get(i).getCentreName().equals(to_search)) {
						found_index = i;
						isFound = true;
						break;
						
					}
				}
				
				if(isFound) {
					
					personON = true;
					
					centreName.setText("Centre Name: "+ Main.centres.get(found_index).getCentreName());
					supply.setText("Supply: " + Main.centres.get(found_index).getSupply());
					
					centreName.setVisible(true);
					supply.setVisible(true);
					

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
					
					Main.centres.remove(found_index);
					try {
						Main.storeCentre(Main.centres);
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					
				    JOptionPane.showMessageDialog(new JFrame(),"Record Deleted.");  
				    personNotFound.setVisible(false);
					centreName.setVisible(false);
					supply.setVisible(false);


				}
				
			}
		});
		
	}
	
}
