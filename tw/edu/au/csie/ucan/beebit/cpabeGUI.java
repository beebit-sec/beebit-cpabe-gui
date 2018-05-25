package tw.edu.au.csie.ucan.beebit; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class cpabeGUI {

	private JFrame jframe;
	private JButton btnSetup, btnKeygen, btnEncrypt, btnDecrypt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cpabeGUI window = new cpabeGUI();
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
	public cpabeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() { //private
		jframe = new JFrame();
		jframe.setResizable(false);
		jframe.setTitle("Beebit CPABE GUI (FULL FUNCTION)");
		jframe.setBounds(100, 100, 450, 300);
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
		btnSetup.setBounds(40, 100, 180, 65);
		jframe.getContentPane().add(btnSetup);
		btnSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setupGUI setup = new setupGUI();
				setup.show();
			}
		});
		
		btnKeygen = new JButton("KEYGEN");
		btnKeygen.setBounds(230, 100, 180, 65);
		jframe.getContentPane().add(btnKeygen);
		btnKeygen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				keygenGUI keygen = new keygenGUI();
				keygen.show();
			}
		});
		
		btnEncrypt = new JButton("ENCRYPT");
		btnEncrypt.setBounds(40, 175, 180, 65);
		jframe.getContentPane().add(btnEncrypt);
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				encGUI encrypt = new encGUI();
				encrypt.show();
			}
		});
		
		btnDecrypt = new JButton("DECRYPT");
		btnDecrypt.setBounds(230, 175, 180, 65);
		jframe.getContentPane().add(btnDecrypt);
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				decGUI decrypt = new decGUI();
				decrypt.show();
			}
		});
	}
}
