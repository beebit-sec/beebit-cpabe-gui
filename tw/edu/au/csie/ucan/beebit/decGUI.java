package tw.edu.au.csie.ucan.beebit; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class decGUI {
	
	private JFrame jframe;
	private JLabel labPKey, labFile, labSKey;
	private JTextField txtPKey, txtFile, txtSKey;
	private JButton btnDecrypt, btnExit, btnSelectPKey, btnSelectFile, btnSelectSKey;
	private JFileChooser fChooser;	

	/**
	 * Launch the application.
	 */
	public static void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					decGUI window = new decGUI();
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
	public decGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jframe = new JFrame();
		jframe.setResizable(false);
		jframe.setTitle("Beebit CPABE GUI (DECRYPTION)");
		jframe.getContentPane().setForeground(Color.PINK);
		jframe.setBounds(100, 100, 450, 470);
		jframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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

		// Public Key Area
		labPKey = new JLabel("Public Key:");
		labPKey.setBounds(40, 100, 150, 20);
                jframe.getContentPane().add(labPKey);

		txtPKey = new JTextField("Select Public Key ...");
                txtPKey.setBounds(150, 100, 260, 20);
                jframe.getContentPane().add(txtPKey);

                btnSelectPKey = new JButton("Select ...");
                btnSelectPKey.setBounds(40, 120, 100, 20);
                jframe.getContentPane().add(btnSelectPKey);
                btnSelectPKey.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                fChooser = new JFileChooser();
                                int returnValue = fChooser.showOpenDialog(null);
                                if(returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedPath = fChooser.getSelectedFile();
                                        txtPKey.setText(selectedPath.getAbsolutePath());
                                }
                        }
                });

                // Secrect Key Area
                labSKey = new JLabel("Secrect Key:");
                labSKey.setBounds(40, 150, 150, 20);
                jframe.getContentPane().add(labSKey);
                
                txtSKey = new JTextField("Select Secrect Key ...");
                txtSKey.setBounds(150, 150, 260, 20);
                jframe.getContentPane().add(txtSKey);

                btnSelectSKey = new JButton("Select ...");
                btnSelectSKey.setBounds(40, 170, 100, 20);
                jframe.getContentPane().add(btnSelectSKey);
                btnSelectSKey.addActionListener(new ActionListener() {
              		public void actionPerformed(ActionEvent e) {
                   		fChooser = new JFileChooser();
                             	int returnValue = fChooser.showOpenDialog(null);
                             	if(returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedPath = fChooser.getSelectedFile();
                                        txtSKey.setText(selectedPath.getAbsolutePath());
                                }
			}
		});

		// File Area
                labFile = new JLabel("Target File:");
                labFile.setBounds(40, 200, 150, 20);
                jframe.getContentPane().add(labFile);

                txtFile = new JTextField("Select Target File ...");
                txtFile.setBounds(150, 200, 260, 20);
                jframe.getContentPane().add(txtFile);

                btnSelectFile = new JButton("Select ...");
                btnSelectFile.setBounds(40, 220, 100, 20);
                jframe.getContentPane().add(btnSelectFile);
                btnSelectFile.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                fChooser = new JFileChooser();
                                int returnValue = fChooser.showOpenDialog(null);
                                if(returnValue == JFileChooser.APPROVE_OPTION) {
                                        File selectedPath = fChooser.getSelectedFile();
                                        txtFile.setText(selectedPath.getAbsolutePath());
                                }
                        }
                });

		btnDecrypt = new JButton("DECRYPT");
		btnDecrypt.setBounds(40, 300, 180, 90);
		jframe.getContentPane().add(btnDecrypt);
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpabeJNI beebit = new cpabeJNI();
					
				String pkey = txtPKey.getText();
				String skey = txtSKey.getText();
				String file = txtFile.getText();
				int len = beebit.fdec(pkey, skey, file);
				if(len == -1)
				{
				        JOptionPane.showMessageDialog(null,"DEC FAILED(JNI) \n");
				} else {
					JOptionPane.showMessageDialog(null,"DEC SUCCESS(JNI) \n");
				}
		}});
		
		btnExit = new JButton("EXIT");
		btnExit.setBounds(230, 300, 180, 90);
		jframe.getContentPane().add(btnExit);
                btnExit.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                jframe.dispose();
                        }
                });
	}
}

