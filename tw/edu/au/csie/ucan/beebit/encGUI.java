package tw.edu.au.csie.ucan.beebit; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class encGUI {
	
	private JFrame jframe;
	private JLabel labKey, labFile, labPolicy;
	private JTextField txtKey, txtFile, txtPolicy;
	private JButton btnEncrypt, btnExit, btnSelectKey, btnSelectFile, btnEditPolicy;
	private JFileChooser fChooser;	

	/**
	 * Launch the application.
	 */
	public static void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					encGUI window = new encGUI();
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
	public encGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jframe = new JFrame();
		jframe.setResizable(false);
		jframe.setTitle("Beebit CPABE GUI (ENCRYPTION)");
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
		labKey = new JLabel("Public Key:");
		labKey.setBounds(40, 100, 150, 20);
                jframe.getContentPane().add(labKey);

		txtKey = new JTextField("Select Public Key ...");
                txtKey.setBounds(150, 100, 260, 20);
                jframe.getContentPane().add(txtKey);

                btnSelectKey = new JButton("Select ...");
                btnSelectKey.setBounds(40, 120, 100, 20);
                jframe.getContentPane().add(btnSelectKey);
                btnSelectKey.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                fChooser = new JFileChooser();
                                int returnValue = fChooser.showOpenDialog(null);
                                if(returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedPath = fChooser.getSelectedFile();
                                        txtKey.setText(selectedPath.getAbsolutePath());
                                }
                        }
                });

                // Plaintext File Area
                labFile = new JLabel("Target File:");
                labFile.setBounds(40, 150, 150, 20);
                jframe.getContentPane().add(labFile);
                
                txtFile = new JTextField("Select Target File ...");
                txtFile.setBounds(150, 150, 260, 20);
                jframe.getContentPane().add(txtFile);

                btnSelectFile = new JButton("Select ...");
                btnSelectFile.setBounds(40, 170, 100, 20);
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

		// Policy Area
                labPolicy = new JLabel("Policy:");
                labPolicy.setBounds(40, 200, 150, 20);
                jframe.getContentPane().add(labPolicy);

                txtPolicy = new JTextField("Edit Policy ...");
                txtPolicy.setBounds(150, 200, 260, 20);
                jframe.getContentPane().add(txtPolicy);

		btnEncrypt = new JButton("ENCRYPT");
		btnEncrypt.setBounds(40, 300, 180, 90);
		jframe.getContentPane().add(btnEncrypt);
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpabeJNI beebit = new cpabeJNI();
				String key = txtKey.getText();
				String file = txtFile.getText();
				String policy = txtPolicy.getText();
				int len = beebit.fenc(key, file, policy, "default");
				if(len == -1)
				{
					JOptionPane.showMessageDialog(null,"ENC FAILED(JNI) \n");
				} else {
					JOptionPane.showMessageDialog(null,"ENC SUCCESS(JNI) \n");
				}		
		}});
	
		// EXIT	
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

