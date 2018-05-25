package tw.edu.au.csie.ucan.beebit; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*; 

public class keygenGUI {
	
	private JFrame jframe;
	private JLabel labPKey, labMKey, labSKeyPath, labCSV;
	private JTextField txtPKey, txtMKey, txtSKeyPath, txtCSV;
	private JButton btnSelectPKey, btnSelectMKey, btnSelectSKeyPath, btnSelectCSV;
	private JButton btnEditCSV, btnKeygen, btnExit;
	private JFileChooser fChooser;

	/**
	 * Launch the application.
	 */
	public static void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					keygenGUI window = new keygenGUI();
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

	public keygenGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		jframe = new JFrame();
		jframe.setResizable(false);
		jframe.setTitle("Beebit CPABE GUI (KEYGEN)");
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

		// Master Key Area
		labMKey = new JLabel("Master Key:");
		labMKey.setBounds(40, 150, 150, 20);
		jframe.getContentPane().add(labMKey);

		txtMKey = new JTextField("Select Master Key ...");
                txtMKey.setBounds(150, 150, 260, 20);
                jframe.getContentPane().add(txtMKey);

		btnSelectMKey = new JButton("Select ...");
                btnSelectMKey.setBounds(40, 170, 100, 20);
                jframe.getContentPane().add(btnSelectMKey);
                btnSelectMKey.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                fChooser = new JFileChooser();
                                int returnValue = fChooser.showOpenDialog(null);
                                if(returnValue == JFileChooser.APPROVE_OPTION) {
                                        File selectedPath = fChooser.getSelectedFile();
                                        txtMKey.setText(selectedPath.getAbsolutePath());
                               	}
                        }
                });

		// Secrect Key Area
		labSKeyPath = new JLabel("Secrect Key:");
		labSKeyPath.setBounds(40, 200, 150, 20);
		jframe.getContentPane().add(labSKeyPath);

		txtSKeyPath = new JTextField("Select Secrect Key Path ...");
                txtSKeyPath.setBounds(150, 200, 260, 20);
                jframe.getContentPane().add(txtSKeyPath);

		btnSelectSKeyPath = new JButton("Select ...");
                btnSelectSKeyPath.setBounds(40, 220, 100, 20);
                jframe.getContentPane().add(btnSelectSKeyPath);
                btnSelectSKeyPath.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                fChooser = new JFileChooser();
                                fChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                                int returnValue = fChooser.showOpenDialog(null);
                                if(returnValue == JFileChooser.APPROVE_OPTION) {
                                        File selectedPath = fChooser.getSelectedFile();
                                        txtSKeyPath.setText(selectedPath.getAbsolutePath());
                               	}
                        }
                });

		// CSV Area
		labCSV = new JLabel("CSV File:");
		labCSV.setBounds(40, 250, 150, 20);
		jframe.getContentPane().add(labCSV);

		txtCSV = new JTextField("Select CSV File ...");
                txtCSV.setBounds(150, 250, 260, 20);
                jframe.getContentPane().add(txtCSV);

                btnSelectCSV = new JButton("Select ...");
                btnSelectCSV.setBounds(40, 270, 100, 20);
                jframe.getContentPane().add(btnSelectCSV);
                btnSelectCSV.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                fChooser = new JFileChooser();
                                int returnValue = fChooser.showOpenDialog(null);
                                if(returnValue == JFileChooser.APPROVE_OPTION) {
                                        File selectedPath = fChooser.getSelectedFile();
                                        txtCSV.setText(selectedPath.getAbsolutePath());
                                }
                        }
                });

		// TODO: Number of attributes is limited to 6 now.
		btnKeygen = new JButton("KEYGEN");
		btnKeygen.setBounds(165, 300, 120, 90);
		jframe.getContentPane().add(btnKeygen);
		btnKeygen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
 				FileReader fr =null; 
				BufferedReader br =null; 
				String tempString=""; 
				String[] tempArray; 
				String[][] score; 
				String[] name=new String[10]; 
				
				try{ 
					int i;
					fr= new FileReader(txtCSV.getText());  
					br = new BufferedReader(fr); 
					String data; 
					while ((data = br.readLine()) != null){ 
						tempString = data; 
						tempArray = tempString.split(","); 
						for(i = 0 ; i < tempArray.length ; i++){ 
							name[i] = tempArray[i]; 
						}
						System.out.print("\n"); 
						score=new String[][]{{name[0]}}; 
						for(String [] y: score){ 
							String pk = txtPKey.getText();
							String mk = txtMKey.getText();
							String skp = txtSKeyPath.getText();

							cpabeJNI beebit = new cpabeJNI();
							if(beebit.keygen(pk, mk, String.format("%s/secKey_%s",skp, name[0]),3,name[0],name[1],name[2],name[3],name[4],name[5],name[6]) == -1) 
							{
								JOptionPane.showMessageDialog(null,name[0]+" "+"KEYGEN FAILED(JNI)\n");
							} else {
								JOptionPane.showMessageDialog(null,name[0]+" "+"KEYGEN SUCCESS(JNI)\n");	
							}
						} 
					}
					System.out.println(); 
				}catch(IOException h){ 
			
				} 
				finally{ 
					try{ 
						br.close();
						fr.close(); 
					} catch(IOException g){
			
					} 
				} 
		}});
		
		btnEditCSV = new JButton("EDIT CSV");
		btnEditCSV.setBounds(40, 300, 120, 90);
		jframe.getContentPane().add(btnEditCSV);
		btnEditCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {					
					Desktop.getDesktop().open(new java.io.File(txtCSV.getText()));
				}
				catch(Exception ioe){
					ioe.printStackTrace();
				}					
				
			}
		});

		btnExit = new JButton("EXIT");
                btnExit.setBounds(290, 300, 120, 90);
                jframe.getContentPane().add(btnExit);
                btnExit.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                jframe.dispose();
                        }
                });
	}
}
