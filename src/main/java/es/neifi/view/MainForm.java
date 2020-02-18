package es.neifi.view;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.plaf.PanelUI;

import es.neifi.model.DependencyInjection;

import java.awt.event.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

public class MainForm extends JDialog {

	private static final long serialVersionUID = 1L;
	private JFrame frmAppgestin;
	private int cardLayoutIndex = 0;

	// panels

	ClientsManagement clientsPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					MainForm window = new MainForm();
					window.frmAppgestin.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unused")
	private void initialize() {
		
		//colors
		DependencyInjection panelFactory = new DependencyInjection(new ClientsManagement(), new OrdersManagement());
		Color gray = new Color(100, 100, 99);
		Color greenBlue = new Color(144, 255, 220);
		Color green = new Color(135, 203, 172);
		Color black = new Color(38, 38, 38);
		Color bone = new Color(230, 232, 230);
        
		// form
		frmAppgestin = new JFrame();
		frmAppgestin.setBackground(gray);
		frmAppgestin.setForeground(bone);
		frmAppgestin.setTitle("APPGESTIÓN");
		frmAppgestin.setType(Type.NORMAL);
		frmAppgestin.setLocation(1920, 1080);
		frmAppgestin.setResizable(false);
		frmAppgestin.setBounds(100, 100, 1400, 900);
		frmAppgestin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frmAppgestin.getContentPane().setLayout(new CardLayout());
		
		// menuPanel
		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(UIManager.getBorder("Button.border"));
		menuPanel.setBounds(0, 0, 95, 871);
		menuPanel.setLayout(null);
		menuPanel.setBackground(green);
		frmAppgestin.getContentPane().add(menuPanel);
		// centerPanel
		JPanel centerPanel = new JPanel();
		CardLayout cardLayout = new CardLayout(40,30);
		
		centerPanel.setBackground(bone);
		centerPanel.setBounds(92, 79, 1400, 792);
		centerPanel.setLayout(cardLayout);
		centerPanel.add("cliMng", panelFactory.getCliMng());
		centerPanel.add("ordMng", panelFactory.getOrdMng());
		frmAppgestin.getContentPane().add(centerPanel);
		// topPanel
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 1400, 78);
		topPanel.setBackground(gray);
		frmAppgestin.getContentPane().add(topPanel);

		// Clients button
		Icon iconClient = new ImageIcon(
				"src/main/icons/customer.png");
		JButton btnClienstManagement = new JButton(iconClient);
		btnClienstManagement.setFocusPainted(false);
		btnClienstManagement.setForeground(bone);
		btnClienstManagement.setBorderPainted(false);
		btnClienstManagement.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClienstManagement.setBackground(gray);
		btnClienstManagement.setBounds(-1, 79, 95, 73);
		menuPanel.add(btnClienstManagement);
		btnClienstManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cardLayout.show(centerPanel, "cliMng");
			}

		});

		// Order button
		Icon iconOrder = new ImageIcon(
				"src/main/icons/order.png");
		JButton btnOrderManagement = new JButton(iconOrder);
		btnOrderManagement.setBorderPainted(false);
		btnOrderManagement.setForeground(bone);
		btnOrderManagement.setFocusPainted(false);
		btnOrderManagement.setFont(new Font("Dialog", Font.BOLD, 16));
		btnOrderManagement.setBackground(gray);
		btnOrderManagement.setBounds(-1, 163, 95, 73);
		menuPanel.add(btnOrderManagement);
		btnOrderManagement.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				cardLayout.show(centerPanel, "ordMng");
				
				
			}

		});
	}
}
