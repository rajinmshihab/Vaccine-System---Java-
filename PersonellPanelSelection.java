

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PersonellPanelSelection extends JFrame {
	
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonellPanelSelection frame = new PersonellPanelSelection();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PersonellPanelSelection() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 574, 463);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton personell = new JButton("Register Citizen");
		personell.setBackground(Color.WHITE);
		personell.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				register r = new register();
				r.setVisible(true);
			}
		});
		
		personell.setFont(new Font("Tahoma", Font.BOLD, 14));
		personell.setBounds(80, 245, 150, 36);
		personell.setFocusPainted(false);

		contentPane.add(personell);
		
		JButton centre = new JButton("Centre");
		centre.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				Centre c = new Centre();
				c.setVisible(true);
			}
		});
		
		centre.setBackground(Color.WHITE);
		centre.setFont(new Font("Tahoma", Font.BOLD, 12));
		centre.setBounds(300, 246, 136, 36);
		centre.setFocusPainted(false);
		
		contentPane.add(centre);
		
		JLabel lblNewLabel = new JLabel("Select Panel");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(180, 47, 427, 67);
		contentPane.add(lblNewLabel);
	}
}
