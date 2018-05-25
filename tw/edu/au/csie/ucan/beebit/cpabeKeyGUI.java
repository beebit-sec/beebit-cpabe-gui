package tw.edu.au.csie.ucan.beebit; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class cpabeKeyGUI {

	private JFrame jframe; 
	private JButton btnSetup, btnKeygen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cpabeKeyGUI window = new cpabeKeyGUI();
					window.jframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public cpabeKeyGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		jframe = new JFrame();
		jframe.setResizable(false);
		jframe.setTitle("Beebit CPABE GUI for Key Management");
		jframe.setBounds(100, 100, 450, 280);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		jframe.getContentPane().setLayout(null);
	
		// TITLE (TEMP) Will be replaced by image
		JLabel labTitle = new JLabel("Beebit CPABE", SwingConstants.CENTER);
		labTitle.setBounds(40, 10, 370, 40);	
		labTitle.setFont(new Font("Serif", Font.BOLD, 20));
		jframe.getContentPane().add(labTitle);
		JLabel labSubTitle = new JLabel("UCAN.CSIE.AU.EDU.TW", SwingConstants.CENTER);
		labSubTitle.setBounds(40, 50, 370, 40);	
		labSubTitle.setFont(new Font("Serif", Font.BOLD, 20));
		jframe.getContentPane().add(labSubTitle);
			
		btnSetup = new JButton("SETUP");
		btnSetup.setBounds(40, 100, 165, 100);
		jframe.getContentPane().add(btnSetup);
		btnSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setupGUI setup = new setupGUI();
				setup.show();
			}
		});

		btnKeygen = new JButton("KEYGEN");
		btnKeygen.setBounds(245, 100, 165, 100);
		jframe.getContentPane().add(btnKeygen);
		btnKeygen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				keygenGUI keygen = new keygenGUI();
				keygen.show();
			}
		});
	}
}
