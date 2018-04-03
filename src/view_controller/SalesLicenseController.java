package view_controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import model.License;
import java.sql.SQLException;

public class SalesLicenseController {
    private JPanel contentPane;
    private JTextField newClientField;
    private JTextField newPriceField;
    private JCheckBox currentCheck;
    private JCheckBox paidCheck;

    SalesLicenseController() {}

    public void show() {

    }
    /*

    public void initialize() {
        setTitle("Ліцензії");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, 500, 550);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        */

		/*
		currentCheck = new JCheckBox("поточні");
		currentCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					refreshTable();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		currentCheck.setSelected(true);
		currentCheck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_currentCheck = new GridBagConstraints();
		gbc_currentCheck.anchor = GridBagConstraints.WEST;
		gbc_currentCheck.insets = new Insets(0, 0, 5, 5);
		gbc_currentCheck.gridx = 1;
		gbc_currentCheck.gridy = 1;
		contentPane.add(currentCheck, gbc_currentCheck);

		paidCheck = new JCheckBox("виплачені");
		paidCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					refreshTable();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		paidCheck.setSelected(true);
		paidCheck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_paidCheck = new GridBagConstraints();
		gbc_paidCheck.insets = new Insets(0, 0, 5, 5);
		gbc_paidCheck.anchor = GridBagConstraints.WEST;
		gbc_paidCheck.gridx = 2;
		gbc_paidCheck.gridy = 1;
		contentPane.add(paidCheck, gbc_paidCheck);*/

		/*

        JButton editButton = new JButton("ЗМІНИТИ");
        editButton.setFont(new Font("Tahoma", Font.BOLD, 9));
        GridBagConstraints gbc_editButton = new GridBagConstraints();
        gbc_editButton.insets = new Insets(0, 0, 5, 5);
        gbc_editButton.gridx = 7;
        gbc_editButton.gridy = 1;
        editButton.setEnabled(false);
        contentPane.add(editButton, gbc_editButton);

        JLabel lblP = new JLabel("Альбом :");
        lblP.setFont(new Font("Tahoma", Font.PLAIN, 12));
        GridBagConstraints gbc_lblP = new GridBagConstraints();
        gbc_lblP.anchor = GridBagConstraints.EAST;
        gbc_lblP.insets = new Insets(0, 0, 5, 5);
        gbc_lblP.gridx = 1;
        gbc_lblP.gridy = 2;
        contentPane.add(lblP, gbc_lblP);

        albumBox = new JComboBox();
        for(String i : saleSer.getAlbSer().getNames())
            albumBox.addItem(i);
        GridBagConstraints gbc_albumBox = new GridBagConstraints();
        gbc_albumBox.gridwidth = 2;
        gbc_albumBox.insets = new Insets(0, 0, 5, 5);
        gbc_albumBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_albumBox.gridx = 2;
        gbc_albumBox.gridy = 2;
        albumBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    refreshTable(albumBox.getSelectedItem().toString());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        contentPane.add(albumBox, gbc_albumBox);

        JButton selectionBtn = new JButton("Обрати");
        selectionBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    initializeSelector(false);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        GridBagConstraints gbc_selectionBtn = new GridBagConstraints();
        gbc_selectionBtn.insets = new Insets(0, 0, 5, 5);
        gbc_selectionBtn.gridx = 4;
        gbc_selectionBtn.gridy = 2;
        contentPane.add(selectionBtn, gbc_selectionBtn);

        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridheight = 2;
        gbc_scrollPane.gridwidth = 7;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 3;
        contentPane.add(scrollPane, gbc_scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        LicenseTableModel model = new LicenseTableModel(saleSer);

        JLabel newLabel = new JLabel("Нова ліцензія");
        newLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        GridBagConstraints gbc_newLabel = new GridBagConstraints();
        gbc_newLabel.insets = new Insets(0, 0, 5, 5);
        gbc_newLabel.gridx = 1;
        gbc_newLabel.gridy = 5;
        contentPane.add(newLabel, gbc_newLabel);

        newPanel = new JPanel();
        newPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        GridBagConstraints gbc_newPanel = new GridBagConstraints();
        gbc_newPanel.gridwidth = 7;
        gbc_newPanel.insets = new Insets(0, 0, 5, 5);
        gbc_newPanel.fill = GridBagConstraints.BOTH;
        gbc_newPanel.gridx = 1;
        gbc_newPanel.gridy = 6;
        contentPane.add(newPanel, gbc_newPanel);
        GridBagLayout gbl_newPanel = new GridBagLayout();
        gbl_newPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gbl_newPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_newPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_newPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        newPanel.setLayout(gbl_newPanel);

        JLabel newAlbumLabel = new JLabel("Альбом :");
        GridBagConstraints gbc_newAlbumLabel = new GridBagConstraints();
        gbc_newAlbumLabel.insets = new Insets(0, 0, 5, 5);
        gbc_newAlbumLabel.anchor = GridBagConstraints.EAST;
        gbc_newAlbumLabel.gridx = 1;
        gbc_newAlbumLabel.gridy = 1;
        newPanel.add(newAlbumLabel, gbc_newAlbumLabel);

        newAlbumBox = new JComboBox();
        for(String i : saleSer.getAlbSer().getNames())
            newAlbumBox.addItem(i);
        GridBagConstraints gbc_newAlbumBox = new GridBagConstraints();
        gbc_newAlbumBox.gridwidth = 3;
        gbc_newAlbumBox.insets = new Insets(0, 0, 5, 5);
        gbc_newAlbumBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_newAlbumBox.gridx = 2;
        gbc_newAlbumBox.gridy = 1;

        JButton newSelectBtn = new JButton("Обрати");
        newSelectBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    initializeSelector(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        newPanel.add(newAlbumBox, gbc_newAlbumBox);

        GridBagConstraints gbc_newSelectBtn = new GridBagConstraints();
        gbc_newSelectBtn.insets = new Insets(0, 0, 5, 5);
        gbc_newSelectBtn.gridx = 5;
        gbc_newSelectBtn.gridy = 1;
        newPanel.add(newSelectBtn, gbc_newSelectBtn);

        JLabel newClient = new JLabel("Покупець :");
        GridBagConstraints gbc_newClient = new GridBagConstraints();
        gbc_newClient.anchor = GridBagConstraints.EAST;
        gbc_newClient.insets = new Insets(0, 0, 5, 5);
        gbc_newClient.gridx = 1;
        gbc_newClient.gridy = 2;
        newPanel.add(newClient, gbc_newClient);

        newClientField = new JTextField();
        GridBagConstraints gbc_newClientField = new GridBagConstraints();
        gbc_newClientField.gridwidth = 3;
        gbc_newClientField.insets = new Insets(0, 0, 5, 5);
        gbc_newClientField.fill = GridBagConstraints.HORIZONTAL;
        gbc_newClientField.gridx = 2;
        gbc_newClientField.gridy = 2;
        newPanel.add(newClientField, gbc_newClientField);
        newClientField.setColumns(10);

        JLabel clientError = new JLabel("!");
        clientError.setForeground(Color.RED);
        clientError.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_clientError = new GridBagConstraints();
        gbc_clientError.insets = new Insets(0, 0, 5, 5);
        gbc_clientError.gridx = 5;
        gbc_clientError.gridy = 2;
        newPanel.add(clientError, gbc_clientError);

        JLabel newPeriodLabel = new JLabel("Місяців :");
        GridBagConstraints gbc_newPeriodLabel = new GridBagConstraints();
        gbc_newPeriodLabel.anchor = GridBagConstraints.EAST;
        gbc_newPeriodLabel.insets = new Insets(0, 0, 5, 5);
        gbc_newPeriodLabel.gridx = 1;
        gbc_newPeriodLabel.gridy = 3;
        newPanel.add(newPeriodLabel, gbc_newPeriodLabel);

        JSpinner newPeriodSpinner = new JSpinner();
        newPeriodSpinner.setModel(new SpinnerNumberModel(1, 1, 24, 1));
        GridBagConstraints gbc_newPeriodSpinner = new GridBagConstraints();
        gbc_newPeriodSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_newPeriodSpinner.gridwidth = 3;
        gbc_newPeriodSpinner.insets = new Insets(0, 0, 5, 5);
        gbc_newPeriodSpinner.gridx = 2;
        gbc_newPeriodSpinner.gridy = 3;
        newPanel.add(newPeriodSpinner, gbc_newPeriodSpinner);

        JLabel monthError = new JLabel("!");
        monthError.setFont(new Font("Tahoma", Font.BOLD, 11));
        monthError.setForeground(Color.RED);
        GridBagConstraints gbc_monthError = new GridBagConstraints();
        gbc_monthError.insets = new Insets(0, 0, 5, 5);
        gbc_monthError.gridx = 5;
        gbc_monthError.gridy = 3;
        newPanel.add(monthError, gbc_monthError);

        JLabel newPriceLabel = new JLabel("Ціна/міс :");
        GridBagConstraints gbc_newPriceLabel = new GridBagConstraints();
        gbc_newPriceLabel.anchor = GridBagConstraints.EAST;
        gbc_newPriceLabel.insets = new Insets(0, 0, 5, 5);
        gbc_newPriceLabel.gridx = 1;
        gbc_newPriceLabel.gridy = 4;
        newPanel.add(newPriceLabel, gbc_newPriceLabel);

        newPriceField = new JTextField();
        GridBagConstraints gbc_newPriceField = new GridBagConstraints();
        gbc_newPriceField.gridwidth = 3;
        gbc_newPriceField.insets = new Insets(0, 0, 5, 5);
        gbc_newPriceField.fill = GridBagConstraints.HORIZONTAL;
        gbc_newPriceField.gridx = 2;
        gbc_newPriceField.gridy = 4;
        newPanel.add(newPriceField, gbc_newPriceField);
        newPriceField.setColumns(10);

        JButton newButton = new JButton("Створити");
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(((String)newClientField.getText()).isEmpty())
                    clientError.setVisible(true);
                else {
                    try {
                        License li = new License(new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                                newClientField.getText(),
                                saleSer.getAlbSer().getIdByShort( (String)newAlbumBox.getSelectedItem() ),
                                new BigDecimal(newPriceField.getText()),
                                ((int) newPeriodSpinner.getValue()));
                        saleSer.newLicenseSale(li);
                        //model.addRow(saleSer.getLicenseRow(li).toArray());
                        refreshTable(null);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        JLabel priceError = new JLabel("!");
        priceError.setForeground(Color.RED);
        priceError.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_priceError = new GridBagConstraints();
        gbc_priceError.insets = new Insets(0, 0, 5, 5);
        gbc_priceError.gridx = 5;
        gbc_priceError.gridy = 4;
        newPanel.add(priceError, gbc_priceError);
        GridBagConstraints gbc_newButton = new GridBagConstraints();
        gbc_newButton.insets = new Insets(0, 0, 5, 5);
        gbc_newButton.gridx = 4;
        gbc_newButton.gridy = 6;
        newPanel.add(newButton, gbc_newButton);

        JButton exitBtn = new JButton("Зачинити");
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    MainFrame mainf;
                    mainf = new MainFrame(saleSer);
                    dispose();
                    mainf.setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
        exitBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        GridBagConstraints gbc_exitBtn = new GridBagConstraints();
        gbc_exitBtn.insets = new Insets(0, 0, 0, 5);
        gbc_exitBtn.gridx = 7;
        gbc_exitBtn.gridy = 7;
        contentPane.add(exitBtn, gbc_exitBtn);
        table.setModel(model);
        //table.getColumn(0).setPreferredWidth(5);
		/*
		table.getSelectionModel().addListSelectionListener((new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				try {
					int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
					License li = (License) saleSer.getById(id);
					if (!li.isPaid()) {
						editButton.setEnabled(true);
					}
					else {
						editButton.setEnabled(false);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
	    }));*/

		/*
        clientError.setVisible(false);
        priceError.setVisible(false);
        monthError.setVisible(false);
        editButton.setVisible(false);
        //refreshTable();
        //table.setVisible(true);
    }

    private void initializeSelector(boolean newAB) throws SQLException {
        /*
        if (dialog == null) {
            dialog = new SelectorDialog(saleSer.getAlbSer(), this, newAB);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        }
        dialog.setVisible(true);
        */
/*    }

    private void refreshTable(String album) throws SQLException {
        //if (currentCheck.isSelected() && paidCheck.isSelected())
        if (album == null)
            table.setModel(new LicenseTableModel(saleSer));
        else
            table.setModel(new LicenseTableModel(saleSer, null, album));
        //else if (!currentCheck.isSelected() && !paidCheck.isSelected())
        //	table.setModel(new LicenseTableModel(saleSer));
    }


    */

}