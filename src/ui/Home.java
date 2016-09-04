package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.Button;
import javax.swing.JLabel;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

import core.IOFile;
import core.SmallBinaryFile;
import main.Encryptor;
import main.Formattext;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home {

	private JFrame frame;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private Encryptor enc;
	private IOFile iotext;
	private SmallBinaryFile iobin;
	private Formattext formattext;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		init_encrypt();
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setBackground(Color.WHITE);
		
		Button buttonOp = new Button("Enkripsi");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(2, 0, 196, 571);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAlgoritma = new JLabel("ALGORITMA");
		lblAlgoritma.setBounds(20, 74, 77, 14);
		panel.add(lblAlgoritma);
		
		JRadioButton rdbtnVigenere = new JRadioButton("Vigenere 26");
		rdbtnVigenere.setSelected(true);
		buttonGroup_1.add(rdbtnVigenere);
		rdbtnVigenere.setBounds(20, 98, 109, 23);
		panel.add(rdbtnVigenere);
		
		JRadioButton rdbtnVigenere_1 = new JRadioButton("Vigenere 256");
		buttonGroup_1.add(rdbtnVigenere_1);
		rdbtnVigenere_1.setBounds(20, 124, 109, 23);
		panel.add(rdbtnVigenere_1);
		
		JRadioButton rdbtnModifVigenere = new JRadioButton("Modif Vigenere");
		buttonGroup_1.add(rdbtnModifVigenere);
		rdbtnModifVigenere.setBounds(20, 150, 109, 23);
		panel.add(rdbtnModifVigenere);
		
		JRadioButton rdbtnPlayfair = new JRadioButton("Playfair");
		buttonGroup_1.add(rdbtnPlayfair);
		rdbtnPlayfair.setBounds(20, 176, 109, 23);
		panel.add(rdbtnPlayfair);
		
		JLabel lblFormatTeks = new JLabel("Format teks");
		lblFormatTeks.setBounds(20, 229, 77, 14);
		panel.add(lblFormatTeks);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		buttonGroup_2.add(rdbtnNormal);
		rdbtnNormal.setBounds(20, 250, 109, 23);
		panel.add(rdbtnNormal);
		
		JRadioButton rdbtnTanpaSpasi = new JRadioButton("Tanpa spasi");
		rdbtnTanpaSpasi.setSelected(true);
		buttonGroup_2.add(rdbtnTanpaSpasi);
		rdbtnTanpaSpasi.setBounds(20, 276, 109, 23);
		panel.add(rdbtnTanpaSpasi);
		
		JRadioButton rdbtnkarakter = new JRadioButton("5-karakter");
		buttonGroup_2.add(rdbtnkarakter);
		rdbtnkarakter.setBounds(20, 302, 109, 23);
		panel.add(rdbtnkarakter);
		
		JRadioButton rdbtnTeks = new JRadioButton("Teks");
		JRadioButton rdbtnBinary = new JRadioButton("Binary");
		JButton btnPilihFile = new JButton("Pilih file");
		
		JCheckBox chckbxBacaDariFile = new JCheckBox("Baca dari file");
		chckbxBacaDariFile.setBounds(20, 352, 133, 23);
		chckbxBacaDariFile.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(chckbxBacaDariFile.isSelected()) {
					rdbtnTeks.setEnabled(true);
					rdbtnBinary.setEnabled(true);
					btnPilihFile.setEnabled(true);
				} else {
					rdbtnTeks.setEnabled(false);
					rdbtnBinary.setEnabled(false);
					btnPilihFile.setEnabled(false);
				}			
			}
			
		});
		panel.add(chckbxBacaDariFile);
		
		buttonGroup.add(rdbtnTeks);
		rdbtnTeks.setBounds(44, 378, 109, 23);
		rdbtnTeks.setEnabled(false);
		rdbtnTeks.setSelected(true);
		panel.add(rdbtnTeks);
		
		buttonGroup.add(rdbtnBinary);
		rdbtnBinary.setBounds(44, 404, 109, 23);
		rdbtnBinary.setEnabled(false);
		panel.add(rdbtnBinary);
		
		btnPilihFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				chooseFile();
			}
		});
		btnPilihFile.setBounds(44, 435, 89, 23);
		btnPilihFile.setEnabled(false);
		panel.add(btnPilihFile);
		
		JButton btnSimpanHasil = new JButton("Simpan Hasil");
		btnSimpanHasil.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String dir = chooseDir();
			}
		});
		btnSimpanHasil.setBounds(31, 524, 133, 23);
		//btnSimpanHasil.setEnabled(false);
		panel.add(btnSimpanHasil);
		
		JRadioButton rdbtnEnkripsi = new JRadioButton("Enkripsi");
		rdbtnEnkripsi.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rdbtnEnkripsi.isSelected()){
					buttonOp.setLabel("Enkripsi");
				} else {
					buttonOp.setLabel("Dekripsi");
				}
			}
		});
		rdbtnEnkripsi.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnEnkripsi.setBounds(20, 24, 77, 23);
		panel.add(rdbtnEnkripsi);
		rdbtnEnkripsi.setSelected(true);
		buttonGroup_3.add(rdbtnEnkripsi);
		
		JRadioButton rdbtnDeskripsi = new JRadioButton("Dekripsi");
		
		rdbtnDeskripsi.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnDeskripsi.setBounds(99, 24, 109, 23);
		panel.add(rdbtnDeskripsi);
		rdbtnDeskripsi.setSelected(true);
		buttonGroup_3.add(rdbtnDeskripsi);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(232, 59, 517, 124);
		desktopPane.add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(232, 330, 517, 191);
		desktopPane.add(textArea_1);
		
		
		buttonOp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonOp.setBounds(664, 242, 85, 34);
		desktopPane.add(buttonOp);
		
		JLabel lblHasil = new JLabel("HASIL");
		lblHasil.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHasil.setBounds(239, 297, 46, 15);
		desktopPane.add(lblHasil);
		
		Label label = new Label("TEXT");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(239, 31, 62, 22);
		desktopPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(278, 193, 471, 22);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblKey = new JLabel("Key");
		lblKey.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKey.setBounds(244, 197, 46, 14);
		desktopPane.add(lblKey);
	}
	
	private void init_encrypt() {
		enc = new Encryptor();
		iotext = new IOFile();
		iobin = new SmallBinaryFile();
		formattext = new Formattext();
	}
	
	private String chooseFile() {
		JFileChooser fc = new JFileChooser();
		int retVal = fc.showOpenDialog(null);
		String path = "";
		if(retVal == JFileChooser.APPROVE_OPTION) {
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			File workingDirectory = new File(System.getProperty("user.dir"));
			fc.setCurrentDirectory(workingDirectory);
			path = fc.getSelectedFile().getAbsolutePath();
		}
		return path;
	}
	
	private String chooseDir() {
		JFileChooser fc = new JFileChooser();
		int retVal = fc.showOpenDialog(null);
		String path = "";
		if(retVal == JFileChooser.APPROVE_OPTION) {
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			File workingDirectory = new File(System.getProperty("user.dir"));
			fc.setCurrentDirectory(workingDirectory);
			path = fc.getSelectedFile().getAbsolutePath();
		}
		return path;
	}
}
