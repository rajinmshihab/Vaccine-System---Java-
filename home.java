import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home {

	private JFrame frmCovidVaccinationSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frmCovidVaccinationSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCovidVaccinationSystem = new JFrame();
		frmCovidVaccinationSystem.setTitle("Covid-19 Vaccination System");
		frmCovidVaccinationSystem.setResizable(true);
		frmCovidVaccinationSystem.getContentPane().setBackground(Color.WHITE);
		frmCovidVaccinationSystem.setBounds(100, 100, 623, 434);
		frmCovidVaccinationSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCovidVaccinationSystem.getContentPane().setLayout(null);
		
		
		JButton personell = new JButton("Personell");
		personell.setBackground(Color.WHITE);
		personell.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frmCovidVaccinationSystem.dispose(); //
				PersonellPanelSelection p = new PersonellPanelSelection();
				p.setVisible(true);
			}
		});
		personell.setFont(new Font("Tahoma", Font.BOLD, 14));
		personell.setBounds(94, 245, 110, 36);
		personell.setFocusPainted(false);

		frmCovidVaccinationSystem.getContentPane().add(personell);
		
		JButton btnRegisterCitizen = new JButton("Register Citizen");
		btnRegisterCitizen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frmCovidVaccinationSystem.dispose();
				register r = new register();
				r.setVisible(true);
			}
		});
		btnRegisterCitizen.setBackground(Color.WHITE);
		btnRegisterCitizen.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegisterCitizen.setBounds(385, 246, 136, 36);
		btnRegisterCitizen.setFocusPainted(false);

		frmCovidVaccinationSystem.getContentPane().add(btnRegisterCitizen);
		
		JLabel lblNewLabel = new JLabel("Covid-19 Vaccination System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(107, 47, 427, 67);
		frmCovidVaccinationSystem.getContentPane().add(lblNewLabel);
	}
}
