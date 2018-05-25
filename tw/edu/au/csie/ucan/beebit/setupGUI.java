package tw.edu.au.csie.ucan.beebit; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class setupGUI {
	
	private JFrame jframe;
	private JLabel labProject, labPath;
	private JTextField txtProject, txtPath;
	private JFileChooser fpChooser;
	private JButton btnSelect, btnSetup, btnExit;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) { */
	public static void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setupGUI window = new setupGUI();
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
	public setupGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jframe = new JFrame();
		jframe.setResizable(false);
		jframe.setTitle("Beebit CPABE GUI (SETUP)");
		jframe.getContentPane().setForeground(Color.PINK);
		jframe.setBounds(100, 100, 450, 300); // (x, y, width, height)
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

		// Project Name Area
		labProject = new JLabel("Project Name: ");
		labProject.setBounds(40, 100, 150, 20);
		jframe.getContentPane().add(labProject);
	
		txtProject = new JTextField("demo");
		txtProject.setBounds(150, 100, 260, 20);
		jframe.getContentPane().add(txtProject);


		// Key Path Area
		labPath = new JLabel("Key Path: ");
		labPath.setBounds(40, 130, 150, 20);
		jframe.getContentPane().add(labPath);

		txtPath = new JTextField(".");
		txtPath.setBounds(150, 130, 260, 20);
		jframe.getContentPane().add(txtPath);

		btnSelect = new JButton("Select");
		btnSelect.setBounds(40, 150, 100, 20);
		jframe.getContentPane().add(btnSelect);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fpChooser = new JFileChooser();
				fpChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                                int returnValue = fpChooser.showOpenDialog(null);
                                if(returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedPath = fpChooser.getSelectedFile();
					txtPath.setText(selectedPath.getAbsolutePath());
				}
			}
		});

		// SETUP
		btnSetup = new JButton("SETUP");
		btnSetup.setBounds(40, 180, 175, 50);
		jframe.getContentPane().add(btnSetup);
		btnSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpabeJNI beebit = new cpabeJNI();
				String name = txtProject.getText();
				String path = txtPath.getText();
				if(beebit.setup(
					String.format("%s/%s_pubKey",path,name), 
					String.format("%s/%s_mstKey",path,name)) == -1){
					JOptionPane.showMessageDialog(null,"SETUP FAILED (JNI)\n");		
				} else {				
					JOptionPane.showMessageDialog(null,"SETUP SUCCESS(JNI)\n");		
				}
		}});

		// EXIT
		btnExit = new JButton("EXIT");
		btnExit.setBounds(235, 180, 175, 50);
		jframe.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframe.dispose();
			}
		});
	}
}

