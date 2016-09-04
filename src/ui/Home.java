package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Label;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	private JFrame frame;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JDesktopPane desktopPane = new JDesktopPane();
		tabbedPane.addTab("New tab", null, desktopPane, null);
		desktopPane.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 160, 561);
		desktopPane.add(panel);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(200, 59, 549, 160);
		desktopPane.add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(200, 302, 549, 191);
		desktopPane.add(textArea_1);
		
		Button button = new Button("Enkripsi");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(664, 235, 85, 34);
		desktopPane.add(button);
		
		JLabel lblHasil = new JLabel("HASIL");
		lblHasil.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHasil.setBounds(200, 275, 46, 14);
		desktopPane.add(lblHasil);
		
		Label label = new Label("TEXT");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(200, 24, 62, 22);
		desktopPane.add(label);
	}
}
