package es.neifi.view;

import javax.swing.*;
import es.neifi.controller.OrdersDataController;
import es.neifi.model.ClientsTableModel;
import es.neifi.model.XmlReader;
import es.neifi.controller.ClientsDataController;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Button;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class ClientsManagement extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField cif;
	private JTextField zip;
	private JTextField country;
	private JTextField postalAdress;
	private JTextField businessName;
	private JTextField email;
	private JTextField phone;
	private JScrollPane scrollPane;
	protected JTable clientsTable;
	protected ArrayList<JTextField> jTextList;
	protected final ClientsTableModel clientsTableModel = new ClientsTableModel();
	protected int changues = 0;

	private Color gray = new Color(100, 100, 99);
	private Color greenBlue = new Color(144, 255, 220);
	private Color green = new Color(135, 203, 172);
	private Color black = new Color(38, 38, 38);
	private Color bone = new Color(230, 232, 230);
	private Color red = new Color(204, 0, 0);

	private Icon iconAdd;
	private Icon iconRmv;
	private Icon iconEdit;
	private Icon iconSave;
	private Icon iconRfrsh;
	private JTextField iban;

	public ClientsManagement() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private JPanel initialize() {

		this.setBorder(UIManager.getBorder("Button.border"));
		this.setBackground(bone);
		setBounds(0, 0, 1196, 700);
		setLayout(null);

		JLabel lblZip = new JLabel("Postal code");
		lblZip.setBounds(317, 96, 103, 40);
		lblZip.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.add(lblZip);

		cif = new JTextField();
		cif.setBackground(bone);
		cif.setBounds(448, 69, 180, 20);
		cif.setBorder(new LineBorder(new Color(135, 203, 172), 2, true));
		cif.setColumns(10);
		this.add(cif);

		zip = new JTextField();
		zip.setBackground(bone);
		zip.setBounds(448, 109, 180, 20);
		zip.setColumns(10);
		zip.setBorder(BorderFactory.createLineBorder(green, 2, true));
		this.add(zip);

		country = new JTextField();
		country.setBackground(bone);
		country.setBounds(448, 152, 180, 20);
		country.setColumns(10);
		country.setBorder(new LineBorder(new Color(135, 203, 172), 2, true));
		this.add(country);

		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(348, 139, 72, 40);
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.add(lblCountry);

		JLabel lblIban = new JLabel("IBAN");
		lblIban.setBounds(369, 183, 51, 40);
		lblIban.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.add(lblIban);

		postalAdress = new JTextField();
		postalAdress.setBackground(bone);
		postalAdress.setBounds(791, 69, 180, 20);
		postalAdress.setColumns(10);
		postalAdress.setBorder(new LineBorder(new Color(135, 203, 172), 2, true));
		this.add(postalAdress);

		JLabel lblPostalAdress = new JLabel("Postal adress");
		lblPostalAdress.setBounds(661, 66, 120, 20);
		lblPostalAdress.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.add(lblPostalAdress);

		businessName = new JTextField();
		businessName.setBackground(bone);
		businessName.setBounds(791, 109, 180, 20);
		businessName.setColumns(10);
		businessName.setBorder(new LineBorder(new Color(135, 203, 172), 2, true));
		this.add(businessName);

		JLabel lblBusinessName = new JLabel("Business name");
		lblBusinessName.setBounds(646, 106, 135, 20);
		lblBusinessName.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.add(lblBusinessName);

		email = new JTextField();
		email.setBackground(bone);
		email.setBounds(791, 152, 180, 20);
		email.setColumns(10);
		email.setBorder(new LineBorder(new Color(135, 203, 172), 2, true));
		this.add(email);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(730, 139, 51, 40);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.add(lblEmail);

		phone = new JTextField();
		phone.setBackground(bone);
		phone.setBounds(791, 193, 180, 20);
		phone.setColumns(10);
		phone.setBorder(new LineBorder(new Color(135, 203, 172), 2, true));
		this.add(phone);

		JLabel lbliD = new JLabel("Identification");
		lbliD.setBounds(297, 56, 123, 40);
		lbliD.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lbliD);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(723, 184, 58, 40);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.add(lblPhone);

		iconAdd = new ImageIcon(
				"src/main/icons/plus.png");
		JButton btnAddCli = new JButton(iconAdd);
		btnAddCli.setBounds(54, 160, 64, 64);
		btnAddCli.setFocusPainted(false);
		btnAddCli.setForeground(bone);
		btnAddCli.setBorderPainted(false);

		// TODO cambiar comportamiento
		btnAddCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextList = new ArrayList<JTextField>();
				jTextList.add(cif);
				jTextList.add(businessName);
				jTextList.add(country);
				jTextList.add(postalAdress);
				jTextList.add(zip);
				jTextList.add(email);
				jTextList.add(phone);
				jTextList.add(iban);
				ArrayList<String> data = null;
				cif.setEditable(true);
				businessName.setEditable(true);
				country.setEditable(true);
				postalAdress.setEditable(true);
				zip.setEditable(true);
				email.setEditable(true);
				phone.setEditable(true);
				iban.setEditable(true);
				for (JTextField jTextField : jTextList) {
					if (jTextField.getText().isEmpty() || jTextField.getText().isBlank()) {
						jTextField.setBorder(BorderFactory.createLineBorder(red));
					} else {
						data = new ArrayList<String>();
						data.add(cif.getText());
						data.add(businessName.getText());
						data.add(country.getText());
						data.add(postalAdress.getText());
						data.add(zip.getText());
						data.add(email.getText());
						data.add(phone.getText());
						data.add(iban.getText());
						changues++;

					}

				}
				for (JTextField jTextField : jTextList) {
					jTextField.setText("");
				}
				clientsTableModel.toInsert(data);
				data.clear();

			}
		});
		btnAddCli.setForeground(Color.BLACK);
		btnAddCli.setFont(new Font("Dialog", Font.BOLD, 17));
		btnAddCli.setBackground(SystemColor.inactiveCaptionBorder);
		this.add(btnAddCli);

		iconRfrsh = new ImageIcon(
				"src/main/icons/refresh.png");
		JButton btnRefresh = new JButton(iconRfrsh);
		btnRefresh.setBounds(1098, 160, 64, 64);
		btnRefresh.setFocusPainted(false);
		btnRefresh.setForeground(bone);
		
		btnRefresh.setBorderPainted(false);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});

		// delete
		iconRmv = new ImageIcon(
				"src/main/icons/cancel.png");
		JButton btnDelete = new JButton(iconRmv);
		btnDelete.setBounds(128, 160, 64, 64);
		btnDelete.setFocusPainted(false);
		btnDelete.setForeground(bone);
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(SystemColor.inactiveCaptionBorder);
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 17));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row[] = clientsTable.getSelectedRows();

				for (int i = 0; i < row.length; i++) {
					String id = (String) clientsTable.getValueAt(row[i], 0);
					clientsTableModel.toDelete(id);
					changues++;
				}

			}
		});

		this.add(btnDelete);

		// TODO separar metodos save
		iconSave = new ImageIcon(
				"src/main/icons/floppy-disk.png");
		JButton save = new JButton(iconSave);
		save.setBounds(1024, 160, 64, 64);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (clientsTable.getValueAt(clientsTable.getSelectedRow(), 1) != null) {

					if (changues == 0) {

						JOptionPane.showMessageDialog(null, "No hay cambios que guardar");
						throw new RuntimeException("no hay cambios");
					}
					int option = JOptionPane.showConfirmDialog(null, "Desea confirmar los cambios");

					if (option == JOptionPane.OK_OPTION) {
						clientsTableModel.deleteClient();
						clientsTableModel.insertClient();
						update();
						clientsTableModel.updateClient();
						refreshTable();
						selecTionEvent();
						clearText();
						changues = 0;

					} else {

						JOptionPane.showMessageDialog(null, "Cambios no guardados.");

					}
				} else {
					// TODO limpiar lista
					JOptionPane.showMessageDialog(null, "No hay cambios que guardar");
				}

			}
		});
		save.setForeground(Color.BLACK);
		save.setFont(new Font("Dialog", Font.BOLD, 17));
		save.setBackground(SystemColor.inactiveCaptionBorder);
		this.add(save);

		iconEdit = new ImageIcon(
				"src/main/icons/edit.png");
		JButton btnEdit = new JButton(iconEdit);
		btnEdit.setBounds(209, 160, 64, 64);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				businessName.setEditable(true);
				country.setEditable(true);
				postalAdress.setEditable(true);
				zip.setEditable(true);
				email.setEditable(true);
				phone.setEditable(true);
				iban.setEditable(true);
				changues++;
			}
		});

		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Dialog", Font.BOLD, 17));
		btnEdit.setBackground(SystemColor.inactiveCaptionBorder);
		this.add(btnEdit);

		btnRefresh.setForeground(Color.BLACK);
		btnRefresh.setBackground(SystemColor.inactiveCaptionBorder);
		btnRefresh.setFont(new Font("Dialog", Font.BOLD, 17));
		this.add(btnRefresh);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(54, 234, 1108, 427);
		scrollPane.setViewportBorder(null);
		scrollPane.getVerticalScrollBar().setBackground(green);

		this.add(scrollPane);
		scrollPane.setBackground(bone);

		iban = new JTextField();
		iban.setColumns(10);
		iban.setBorder(new LineBorder(new Color(135, 203, 172), 2, true));
		iban.setBackground(new Color(230, 232, 230));
		iban.setBounds(448, 196, 180, 20);
		add(iban);

		// evento seleccion
		refreshTable();
		selecTionEvent();
		return this;

	}

	protected void selecTionEvent() {

		clientsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				cif.setEditable(false);
				businessName.setEditable(false);
				country.setEditable(false);
				postalAdress.setEditable(false);
				zip.setEditable(false);
				email.setEditable(false);
				phone.setEditable(false);
				iban.setEditable(false);

				cif.setText(clientsTable.getValueAt(clientsTable.getSelectedRow(), 0).toString());
				businessName.setText(clientsTable.getValueAt(clientsTable.getSelectedRow(), 1).toString());
				country.setText(clientsTable.getValueAt(clientsTable.getSelectedRow(), 2).toString());
				postalAdress.setText(clientsTable.getValueAt(clientsTable.getSelectedRow(), 3).toString());
				zip.setText(clientsTable.getValueAt(clientsTable.getSelectedRow(), 4).toString());
				email.setText(clientsTable.getValueAt(clientsTable.getSelectedRow(), 5).toString());
				phone.setText(clientsTable.getValueAt(clientsTable.getSelectedRow(), 6).toString());
				iban.setText(clientsTable.getValueAt(clientsTable.getSelectedRow(), 7).toString());

			}
		});

	}

	public void refreshTable() {
		ClientsDataController model = new ClientsDataController();

		clientsTable = new JTable(model);
		clientsTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		clientsTable.setBackground(Color.WHITE);
		clientsTable.getTableHeader().setBackground(green);
		clientsTable.getTableHeader().setBorder(BorderFactory.createLineBorder(green));
		clientsTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		clientsTable.setSelectionBackground(greenBlue);
		clientsTable.getTableHeader().setOpaque(false);
		clientsTable.setRowHeight(25);
		clientsTable.setGridColor(new Color(255, 255, 255));
		scrollPane.setViewportView(clientsTable);
		clientsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	protected void update() {
		jTextList = new ArrayList<JTextField>();
		jTextList.add(cif);
		jTextList.add(businessName);
		jTextList.add(country);
		jTextList.add(postalAdress);
		jTextList.add(zip);
		jTextList.add(email);
		jTextList.add(phone);
		jTextList.add(iban);
		ArrayList<String> data = null;

		for (JTextField jTextField : jTextList) {
			if (jTextField.getText().isEmpty() || jTextField.getText().isBlank()) {
				jTextField.setBackground(Color.LIGHT_GRAY);
			} else {
				data = new ArrayList<String>();
				data.add(cif.getText());
				data.add(businessName.getText());
				data.add(country.getText());
				data.add(postalAdress.getText());
				data.add(zip.getText());
				data.add(email.getText());
				data.add(phone.getText());
				data.add(iban.getText());

			}

		}

		clientsTableModel.toUpdate(data);
		data.clear();

		this.setVisible(true);
	}

	protected void clearText() {
		cif.setText("");
		businessName.setText("");
		email.setText("");
		country.setText("");
		zip.setText("");
		postalAdress.setText("");
		phone.setText("");
		iban.setText("");
	}
}
