import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.VaccCentre;

public class CentreModify extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField textField;
	
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
	
	public CentreModify () {
		
		VaccCentre selectedCentre =  Main.centres.get(Centre.found_index);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Update Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(109, 10, 228, 35);
		panel.add(lblNewLabel_1);
		
		// centre name field
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFirstName.setBounds(22, 93, 140, 26);
		panel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtFirstName.setText(selectedCentre.getCentreName());
		
		// centre name
		JLabel lblNewLabel_2 = new JLabel("Centre Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(22, 70, 100, 21);
		panel.add(lblNewLabel_2);
		
		// quantity field
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(234, 93, 140, 26);
		panel.add(textField);
		
		textField.setText("" + selectedCentre.getSupply());
		
		// vaccine quantity
		JLabel lblNewLabel_2_1 = new JLabel("Vaccine Supply");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(234, 70, 130, 21);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtFirstName.getText(); // centre name
				System.out.println(name);
				
				String quantity = textField.getText(); //quantity
				System.out.println(quantity);
	
				Main.centres.get(Centre.found_index).setCentreName(name);
				Main.centres.get(Centre.found_index).setSuppy(Integer.parseInt(quantity));
	
					
			
			    JOptionPane.showMessageDialog(new JFrame(), name + " Information Updated");  

			
				
				try {
					Main.storeCentre(Main.centres);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Main.displayAllCentres(Main.centres);
				
			}
		});
		
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(214, 277, 85, 21);
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
		btnReset.setBounds(109, 277, 85, 21);
		btnReset.setBorderPainted(true);

		panel.add(btnReset);
	}
	
}
