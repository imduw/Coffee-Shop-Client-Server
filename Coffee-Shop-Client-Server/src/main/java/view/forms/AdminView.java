package view.forms;

import java.awt.EventQueue;
import javax.swing.text.*;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import view.renderers.CustomTableHeaderRenderer;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.AncestorListener;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class AdminView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane ListProduct;
	private JTable ListTable;
	private JTextField IPsearch;
	private JScrollPane ListProductToInvoice;
	private JTable ListInvoice;
	private JScrollPane ListProduct_1;
	private JTable ListTable_1;
	private JTextField IPsearch_1;
	private JTextField IPproduct;
	private JTextField IPprice;
	public JButton BdashboardForm;
	public JButton BsettingForm;
	public JButton BorderForm;
	public JButton BproductForm;
	public JButton BinvoiceForm;
	public JPanel CardPanel;
	public JPanel DashboardPanel;
	public JPanel ProductPanel;
	public JPanel SettingPanel;
	public JPanel InvoicePanel;
	public JButton BcheckOut;
	public JButton BSearch;
	public JButton BSearch_1;
	public JButton Badd;
	public JButton Bremove;
	public JButton Bupdate;
	public JButton Bsignout;
	

	
	public AdminView() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(17, 236, 231));
		contentPane.setBorder(new LineBorder(new Color(17, 236, 231), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel MenuPanel = new JPanel();
		MenuPanel.setBackground(new Color(32, 36, 38));
		MenuPanel.setBounds(0, 0, 235, 782);
		contentPane.add(MenuPanel);
		MenuPanel.setLayout(null);
		
		JLabel LBlogo = new JLabel("");
		LBlogo.setBounds(12, 12, 45, 37);
		MenuPanel.add(LBlogo);
		LBlogo.setHorizontalAlignment(SwingConstants.CENTER);
		LBlogo.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/logo.png"))));
		
		JLabel LBnameshop = new JLabel("Shop Manager");
		LBnameshop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBnameshop.setForeground(new Color(28,233,255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBnameshop.setForeground(new Color(245, 245, 245));
				
			}
		});
		LBnameshop.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 21));
		LBnameshop.setForeground(new Color(245, 245, 245));
		LBnameshop.setBounds(62, 22, 168, 30);
		MenuPanel.add(LBnameshop);
		
		BorderForm = new JButton("   Order");
		BorderForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BorderForm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	BorderForm.setBackground(new Color(20, 23, 24)); 
            	BorderForm.setForeground(new Color(28,233,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	BorderForm.setBackground(new Color(32, 36, 38));
            	BorderForm.setForeground(new Color(195, 195, 195));
            }
        });

		BorderForm.setFocusable(false);
		BorderForm.setMargin(new Insets(2, 14, 0, 14));
		BorderForm.setForeground(new Color(195, 195, 195));
		BorderForm.setBorderPainted(false);
		BorderForm.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		BorderForm.setHorizontalAlignment(SwingConstants.LEADING);
		BorderForm.setBackground(new Color(32, 36, 38));
		BorderForm.setBounds(0, 190, 233, 45);
		BorderForm.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/order.png"))));
		MenuPanel.add(BorderForm);
		
		BdashboardForm = new JButton("    Dashboard");
		BdashboardForm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	BdashboardForm.setBackground(new Color(20, 23, 24));
            	BdashboardForm.setForeground(new Color(28,233,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	BdashboardForm.setBackground(new Color(32, 36, 38));
            	BdashboardForm.setForeground(new Color(195, 195, 195));
            }
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
        });
		BdashboardForm.setMargin(new Insets(2, 14, 0, 14));
		BdashboardForm.setFocusable(false);
		BdashboardForm.setHorizontalAlignment(SwingConstants.LEADING);
		BdashboardForm.setForeground(new Color(195, 195, 195));
		BdashboardForm.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		BdashboardForm.setBorderPainted(false);
		BdashboardForm.setBackground(new Color(32, 36, 38));
		BdashboardForm.setBounds(6, 134, 226, 45);
		BdashboardForm.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/product.png"))));
		MenuPanel.add(BdashboardForm);
		
		BinvoiceForm = new JButton("   Invoice");
		BinvoiceForm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	BinvoiceForm.setBackground(new Color(20, 23, 24));  
            	BinvoiceForm.setForeground(new Color(28,233,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	BinvoiceForm.setBackground(new Color(32, 36, 38));
            	BinvoiceForm.setForeground(new Color(195, 195, 195));
            }
        });
		BinvoiceForm.setFocusable(false);
		BinvoiceForm.setMargin(new Insets(2, 14, 0, 14));
		BinvoiceForm.setHorizontalAlignment(SwingConstants.LEADING);
		BinvoiceForm.setForeground(new Color(195, 195, 195));
		BinvoiceForm.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		BinvoiceForm.setBorderPainted(false);
		BinvoiceForm.setBackground(new Color(32, 36, 38));
		BinvoiceForm.setBounds(4, 305, 230, 45);
		BinvoiceForm.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/invoice.png"))));
		MenuPanel.add(BinvoiceForm);
		
		BsettingForm = new JButton("    Setting");
		BsettingForm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	BsettingForm.setBackground(new Color(20, 23, 24)); 
            	BsettingForm.setForeground(new Color(28,233,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	BsettingForm.setBackground(new Color(32, 36, 38));
            	BsettingForm.setForeground(new Color(195, 195, 195));
            }
        });
		BsettingForm.setFocusable(false);
		BsettingForm.setMargin(new Insets(2, 14, 0, 14));
		BsettingForm.setHorizontalAlignment(SwingConstants.LEADING);
		BsettingForm.setForeground(new Color(195, 195, 195));
		BsettingForm.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		BsettingForm.setBorderPainted(false);
		BsettingForm.setBackground(new Color(32, 36, 38));
		BsettingForm.setBounds(6, 361, 228, 45);
		BsettingForm.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/setting.png"))));
		MenuPanel.add(BsettingForm);
		
		BproductForm = new JButton("  Product");
		BproductForm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	BproductForm.setBackground(new Color(20, 23, 24)); 
            	BproductForm.setForeground(new Color(28,233,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	BproductForm.setBackground(new Color(32, 36, 38));
            	BproductForm.setForeground(new Color(195, 195, 195));
            }
        });
		BproductForm.setMargin(new Insets(2, 14, 0, 14));
		BproductForm.setHorizontalAlignment(SwingConstants.LEADING);
		BproductForm.setForeground(new Color(195, 195, 195));
		BproductForm.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		BproductForm.setFocusable(false);
		BproductForm.setBorderPainted(false);
		BproductForm.setBackground(new Color(32, 36, 38));
		BproductForm.setBounds(3, 246, 229, 45);
		BproductForm.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/product-management.png"))));
		MenuPanel.add(BproductForm);
		
		Bsignout = new JButton("");
		Bsignout.setMargin(new Insets(2, 2, 2, 2));
		Bsignout.setForeground(new Color(195, 195, 195));
		Bsignout.setFont(new Font("Visby Round CF", Font.PLAIN, 17));
		Bsignout.setHorizontalAlignment(SwingConstants.LEFT);
		Bsignout.setFocusable(false);
		Bsignout.setBorderPainted(false);
		Bsignout.setBackground(new Color(32, 36, 38));
		Bsignout.setBounds(10, 704, 57, 47);
		Bsignout.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/exit.png"))));
		MenuPanel.add(Bsignout);
		
		JLabel LBlogoclient = new JLabel("");
		LBlogoclient.setBounds(192, 660, 32, 36);
		MenuPanel.add(LBlogoclient);
		LBlogoclient.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/unknown.png"))));
		
		JLabel LBnameclient = new JLabel("admin");
		LBnameclient.setBounds(14, 671, 168, 18);
		MenuPanel.add(LBnameclient);
		LBnameclient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBnameclient.setForeground(new Color(28,233,255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				LBnameclient.setForeground(new Color(245, 245, 245));
			}
		});
		LBnameclient.setHorizontalAlignment(SwingConstants.RIGHT);
		LBnameclient.setBackground(new Color(238, 240, 240));
		LBnameclient.setForeground(new Color(245, 245, 245));
		LBnameclient.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 16));
		
		CardPanel = new JPanel();
		CardPanel.setBackground(new Color(20, 23, 24));
		CardPanel.setBounds(233, 0, 1101, 798);
		contentPane.add(CardPanel);
		CardPanel.setLayout(new CardLayout(0, 0));
		
		DashboardPanel = new JPanel();
		DashboardPanel.setBorder(null);
		DashboardPanel.setBounds(233, 54, 1101, 657);
		DashboardPanel.setBackground(new Color(20, 23, 24));
		DashboardPanel.setLayout(null);
		
		//------------------------------------------Table ở Dashboard------------------------------------------------------------------------------------//
		
		ListProduct = new JScrollPane();
		ListProduct.setBorder(new LineBorder(new Color(32, 36, 38), 10, true));
		ListProduct.setBackground(new Color(20, 23, 24));
		ListProduct.setBounds(55, 129, 682, 534);
		DashboardPanel.add(ListProduct);
		
		ListTable = new JTable();
		ListTable.setFocusable(false);
		ListTable.setRowMargin(0);
		ListTable.setGridColor(new Color(128, 128, 128));
		ListTable.setSelectionForeground(new Color(48, 200, 200));
		ListTable.setForeground(new Color(255, 255, 255));
		ListTable.setBackground(new Color(128, 128, 128));
		ListTable.setSelectionBackground(new Color(40, 40, 40));
		ListTable.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		ListTable.setRowHeight(50);
		ListTable.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Product", "Category", "Price" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		ListTable.getColumnModel().getColumn(0).setResizable(false);
		ListTable.getColumnModel().getColumn(0).setPreferredWidth(43);
		ListTable.getColumnModel().getColumn(1).setResizable(false);
		ListTable.getColumnModel().getColumn(1).setPreferredWidth(108);
		ListTable.getColumnModel().getColumn(2).setResizable(false);
		ListTable.getColumnModel().getColumn(2).setPreferredWidth(98);
		ListTable.getColumnModel().getColumn(3).setResizable(false);
		ListTable.getColumnModel().getColumn(3).setPreferredWidth(88);
		ListProduct.setViewportView(ListTable);
		
		JTableHeader header_product = ListTable.getTableHeader();		
		header_product.setResizingAllowed(false);		
		header_product.setReorderingAllowed(false);
		header_product.setDefaultRenderer(new view.renderers.CustomTableHeaderRenderer());
		JViewport viewport = ListProduct.getViewport();
		viewport.setBackground(new Color(20, 23, 24));
		ListTable.setDefaultRenderer(Object.class, new view.renderers.StripedTableCellRenderer());
		CardPanel.add(DashboardPanel);
		
		//------------------------------------------------------------------------------------------------------------------------------//
		
		JPanel invPanel = new JPanel();
		invPanel.setBackground(new Color(24, 28, 29));
		invPanel.setBounds(794, 0, 307, 824);
		DashboardPanel.add(invPanel);
		invPanel.setLayout(null);
		
		//-------------------------------------------Table-Invoice-----------------------------------------------------------------------------//
		
		ListProductToInvoice = new JScrollPane();
		ListProductToInvoice.setBorder(new LineBorder(new Color(32, 36, 38), 6, true));
		ListProductToInvoice.setBackground(new Color(28, 32, 34));
		ListProductToInvoice.setBounds(19,60, 300, 460); //38, 65, 286, 460
		
		ListInvoice = new JTable();
		ListInvoice.setFocusable(false);
		ListInvoice.setRowMargin(0);
		ListInvoice.setGridColor(new Color(128, 128, 128));
		ListInvoice.setSelectionForeground(new Color(48, 200, 200));
		ListInvoice.setForeground(new Color(255, 255, 255));
		ListInvoice.setBackground(new Color(128, 128, 128));
		ListInvoice.setSelectionBackground(new Color(40, 40, 40));
		ListInvoice.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		ListInvoice.setRowHeight(50);
		ListInvoice.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product", "Quantity", "Price"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ListInvoice.getColumnModel().getColumn(0).setResizable(false);
		ListInvoice.getColumnModel().getColumn(0).setPreferredWidth(89);
		ListInvoice.getColumnModel().getColumn(1).setResizable(false);
		ListInvoice.getColumnModel().getColumn(1).setPreferredWidth(52);
		ListInvoice.getColumnModel().getColumn(2).setResizable(false);
		ListProductToInvoice.setViewportView(ListInvoice);
		
		JTableHeader header_invoice = ListInvoice.getTableHeader();		
		header_invoice.setResizingAllowed(false);		
		header_invoice.setReorderingAllowed(false);
		header_invoice.setDefaultRenderer(new view.renderers.CustomTableHeaderRenderer());
		JViewport viewport1 = ListProductToInvoice.getViewport();
		viewport1.setBackground(new Color(20, 23, 24));
		ListInvoice.setDefaultRenderer(Object.class, new view.renderers.StripedTableCellRenderer());
		ListProductToInvoice.setBounds(10, 54, 286, 492);
		invPanel.add(ListProductToInvoice);
		
		//----------------------------------------------------------------------------------------------------------------//
		
		JLabel LBtotaltext = new JLabel("Total :");
		LBtotaltext.setHorizontalAlignment(SwingConstants.LEFT);
		LBtotaltext.setForeground(new Color(245, 245, 245));
		LBtotaltext.setFont(new Font("Visby Round CF", Font.PLAIN, 19));
		LBtotaltext.setBackground(new Color(238, 240, 240));
		LBtotaltext.setBounds(19, 563, 76, 28);
		invPanel.add(LBtotaltext);
		
		JLabel LBtotal = new JLabel("20000000");
		LBtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		LBtotal.setForeground(new Color(245, 245, 245));
		LBtotal.setFont(new Font("Visby Round CF", Font.PLAIN, 19));
		LBtotal.setBackground(new Color(238, 240, 240));
		LBtotal.setBounds(106, 563, 144, 28);
		invPanel.add(LBtotal);
		
		JLabel lblVnd = new JLabel("vnd");
		lblVnd.setHorizontalAlignment(SwingConstants.LEFT);
		lblVnd.setForeground(new Color(245, 245, 245));
		lblVnd.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		lblVnd.setBackground(new Color(238, 240, 240));
		lblVnd.setBounds(260, 569, 32, 16);
		invPanel.add(lblVnd);
		
		BcheckOut = new JButton("Checkout");
		BcheckOut.setAlignmentY(0.0f);
		BcheckOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				BcheckOut.setForeground(new Color(28,233,255));
				BcheckOut.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				BcheckOut.setForeground(new Color(28, 32, 34));
				BcheckOut.setBorderPainted(true);
			}
		});
		BcheckOut.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(28, 32, 34)));
		BcheckOut.setMargin(new Insets(0, 0, 0, 0));
		BcheckOut.setFocusable(false);
		BcheckOut.setForeground(new Color(28, 32, 34));
		BcheckOut.setBackground(new Color(24, 28, 29));
		BcheckOut.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 21));
		BcheckOut.setBounds(20, 655, 274, 44);
		invPanel.add(BcheckOut);
		
		JLabel LBtotaltext_1 = new JLabel("INVOICE");
		LBtotaltext_1.setHorizontalAlignment(SwingConstants.LEFT);
		LBtotaltext_1.setForeground(new Color(56, 185, 199));
		LBtotaltext_1.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 25));
		LBtotaltext_1.setBackground(new Color(238, 240, 240));
		LBtotaltext_1.setBounds(108, 22, 110, 32);
		invPanel.add(LBtotaltext_1);
		
		//-----------------------------------------------------------------------------------------------------------------------//
		
		IPsearch = new JTextField();
		IPsearch.setCaretColor(new Color(240, 240, 240));
		IPsearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				IPsearch.setText("");
				IPsearch.setCaretColor(new Color(240,240,240));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				IPsearch.setText("Search");
				IPsearch.setCaretPosition(0);
				IPsearch.setCaretColor(new Color(20,23,24));
			}
		});
		IPsearch.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 14));
		IPsearch.setForeground(new Color(240, 240, 240));
		IPsearch.setText("Search");
		IPsearch.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(230, 230, 230)));
		IPsearch.setBackground(new Color(20, 23, 24));
		IPsearch.setBounds(190, 56, 345, 40);
		IPsearch.setCaretColor(new Color(20,23,24));
		DashboardPanel.add(IPsearch);
		IPsearch.setColumns(10);
		
		BSearch = new JButton("");
		BSearch.setFocusable(false);
		BSearch.setBorderPainted(false);
		BSearch.setBackground(new Color(20, 23, 24));
		BSearch.setHorizontalAlignment(SwingConstants.CENTER);
		BSearch.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/glass1.png"))));
		BSearch.setBounds(553, 50, 48, 47);
		DashboardPanel.add(BSearch);
		
		ProductPanel = new JPanel();
		ProductPanel.setBackground(new Color(20, 23, 24));
		CardPanel.add(ProductPanel, "name_18041534092000");
		ProductPanel.setLayout(null);
		//------------------------------------Table ở ProductPanel------------------------------------------------------------------------------------------//
		ListProduct_1 = new JScrollPane();
		ListProduct_1.setBorder(new LineBorder(new Color(32, 36, 38), 10, true));
		ListProduct_1.setBackground(new Color(20, 23, 24));
		ListProduct_1.setBounds(55, 130, 682, 606);
		ProductPanel.add(ListProduct_1);
		
		ListTable_1 = new JTable();
		ListTable_1.setFocusable(false);
		ListTable_1.setRowMargin(0);
		ListTable_1.setGridColor(new Color(128, 128, 128));
		ListTable_1.setSelectionForeground(new Color(48, 200, 200));
		ListTable_1.setForeground(new Color(255, 255, 255));
		ListTable_1.setBackground(new Color(128, 128, 128));
		ListTable_1.setSelectionBackground(new Color(40, 40, 40));
		ListTable_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		ListTable_1.setRowHeight(50);
		ListTable_1.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Product", "Category", "Price" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		ListTable_1.getColumnModel().getColumn(0).setResizable(false);
		ListTable_1.getColumnModel().getColumn(0).setPreferredWidth(43);
		ListTable_1.getColumnModel().getColumn(1).setResizable(false);
		ListTable_1.getColumnModel().getColumn(1).setPreferredWidth(108);
		ListTable_1.getColumnModel().getColumn(2).setResizable(false);
		ListTable_1.getColumnModel().getColumn(2).setPreferredWidth(98);
		ListTable_1.getColumnModel().getColumn(3).setResizable(false);
		ListTable_1.getColumnModel().getColumn(3).setPreferredWidth(88);
		ListProduct_1.setViewportView(ListTable_1);
		
		JTableHeader header_product_1 = ListTable_1.getTableHeader();		
		header_product_1.setResizingAllowed(false);		
		header_product_1.setReorderingAllowed(false);
		header_product_1.setDefaultRenderer(new view.renderers.CustomTableHeaderRenderer());
		JViewport viewport_1 = ListProduct_1.getViewport();
		viewport_1.setBackground(new Color(20, 23, 24));
		ListTable_1.setDefaultRenderer(Object.class, new view.renderers.StripedTableCellRenderer());
		CardPanel.add(DashboardPanel);
		
		//-----------------------------------------------------------------------------------------------------------------------------------------//
		
		IPsearch_1 = new JTextField();
		IPsearch_1.setCaretColor(new Color(240, 240, 240));
		IPsearch_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				IPsearch_1.setText("");
				IPsearch_1.setCaretColor(new Color(240,240,240));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				IPsearch_1.setText("Search");
				IPsearch_1.setCaretPosition(0);
				IPsearch_1.setCaretColor(new Color(20,23,24));
			}
		});
		IPsearch_1.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 14));
		IPsearch_1.setForeground(new Color(240, 240, 240));
		IPsearch_1.setText("Search");
		IPsearch_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(230, 230, 230)));
		IPsearch_1.setBackground(new Color(20, 23, 24));
		IPsearch_1.setBounds(190, 56, 345, 40);
		IPsearch_1.setCaretColor(new Color(20,23,24));
		ProductPanel.add(IPsearch_1);
		IPsearch_1.setColumns(10);
		
		BSearch_1 = new JButton("");
		BSearch_1.setFocusable(false);
		BSearch_1.setBackground(new Color(20, 23, 24));
		BSearch_1.setBorderPainted(false);
		BSearch_1.setBounds(540, 51, 48, 47);
		BSearch_1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/glass1.png"))));
		ProductPanel.add(BSearch_1);
		
		IPproduct = new JTextField();
		
		IPproduct.setFont(new Font("Visby Round CF DemiBold", Font.BOLD, 15));
		IPproduct.setForeground(new Color(245, 245, 245));
		IPproduct.setText("Trà đào");
		IPproduct.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		IPproduct.setBackground(new Color(20, 23, 24));
		IPproduct.setBounds(875, 186, 187, 24);
		ProductPanel.add(IPproduct);
		IPproduct.setColumns(10);
		
		JLabel LBproduct = new JLabel("Product -");
		LBproduct.setHorizontalAlignment(SwingConstants.RIGHT);
		LBproduct.setForeground(new Color(245, 245, 245));
		LBproduct.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 17));
		LBproduct.setBounds(784, 181, 81, 30);
		ProductPanel.add(LBproduct);
		//----------------------------------------------------------------------------//
		
		IPproduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBproduct.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBproduct.setForeground(new Color(245, 245, 245));
			}
		});
		
		
		//----------------------------------------------------------------------------//
		JLabel LBcategory = new JLabel("Category -");
		LBcategory.setHorizontalAlignment(SwingConstants.RIGHT);
		LBcategory.setForeground(new Color(245, 245, 245));
		LBcategory.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 17));
		LBcategory.setBounds(776, 297, 92, 30);
		ProductPanel.add(LBcategory);
		
		JLabel LBprice = new JLabel("Price -");
		LBprice.setHorizontalAlignment(SwingConstants.RIGHT);
		LBprice.setForeground(new Color(245, 245, 245));
		LBprice.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 17));
		LBprice.setBounds(801, 234, 64, 30);
		ProductPanel.add(LBprice);
		
		
		
		JLabel LBstatus = new JLabel("Status -");
		LBstatus.setHorizontalAlignment(SwingConstants.RIGHT);
		LBstatus.setForeground(new Color(245, 245, 245));
		LBstatus.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 17));
		LBstatus.setBounds(788, 398, 80, 30);
		ProductPanel.add(LBstatus);
		
		IPprice = new JTextField();
		IPprice.setText("100000");
		IPprice.setForeground(new Color(245, 245, 245));
		IPprice.setFont(new Font("Visby Round CF DemiBold", Font.BOLD, 15));
		IPprice.setColumns(10);
		IPprice.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		IPprice.setBackground(new Color(20, 23, 24));
		IPprice.setBounds(878, 239, 187, 24);
		ProductPanel.add(IPprice);
		
		//----------------------------------------------------------------------------//
		
		IPprice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBprice.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBprice.setForeground(new Color(245, 245, 245));
			}
		});
		
		
		//----------------------------------------------------------------------------//
		
		JRadioButton RBfood = new JRadioButton("  Food");
		RBfood.setFocusable(false);
		RBfood.setMargin(new Insets(2, 2, 0, 2));
		RBfood.setForeground(new Color(240, 240, 240));
		RBfood.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 16));
		RBfood.setBackground(new Color(20, 23, 24));
		RBfood.setBounds(888, 298, 174, 23);
		ProductPanel.add(RBfood);
		
		
		JRadioButton RBdrink = new JRadioButton("  Drink");
		RBdrink.setFocusable(false);
		RBdrink.setForeground(UIManager.getColor("Button.background"));
		RBdrink.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 16));
		RBdrink.setBackground(new Color(20, 23, 24));
		RBdrink.setBounds(888, 343, 174, 23);
		ProductPanel.add(RBdrink);
		
		ButtonGroup group_category = new ButtonGroup();
		group_category.add(RBdrink);
		group_category.add(RBfood);
		
		
		
		JRadioButton RBavailable = new JRadioButton("  Available");
		RBavailable.setFocusable(false);
		RBavailable.setForeground(UIManager.getColor("Button.background"));
		RBavailable.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 16));
		RBavailable.setBackground(new Color(20, 23, 24));
		RBavailable.setBounds(887, 403, 174, 23);
		ProductPanel.add(RBavailable);
		
		
		JRadioButton RBnotAvailable = new JRadioButton("  Not available");
		RBnotAvailable.setFocusable(false);
		RBnotAvailable.setForeground(UIManager.getColor("Button.background"));
		RBnotAvailable.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 16));
		RBnotAvailable.setBackground(new Color(20, 23, 24));
		RBnotAvailable.setBounds(887, 439, 174, 23);
		ProductPanel.add(RBnotAvailable);
		BSearch.setBounds(540, 52, 48, 47);
		
		JLabel LBtotaltext_1_1 = new JLabel("DASHBOARD");
		LBtotaltext_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		LBtotaltext_1_1.setForeground(new Color(56, 185, 199));
		LBtotaltext_1_1.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 25));
		LBtotaltext_1_1.setBackground(new Color(245, 195, 34));
		LBtotaltext_1_1.setBounds(298, 13, 154, 32);
		DashboardPanel.add(LBtotaltext_1_1);
		
		ButtonGroup group_status = new ButtonGroup();
		group_status.add(RBavailable);
		group_status.add(RBnotAvailable);
		
		RBdrink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBcategory.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBcategory.setForeground(new Color(245, 245, 245));
			}
		});
		
		RBfood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBcategory.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBcategory.setForeground(new Color(245, 245, 245));
			}
		});
		
		RBavailable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBstatus.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBstatus.setForeground(new Color(245, 245, 245));
			}
		});
		
		RBnotAvailable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LBstatus.setForeground(new Color(245,195,34));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LBstatus.setForeground(new Color(245, 245, 245));
			}
		});
		
		Badd = new JButton("Add");
		Badd.setFocusable(false);
		Badd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Badd.setForeground(new Color(28,233,255));
				Badd.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Badd.setForeground(new Color(20, 23, 24));
				Badd.setBorderPainted(true);
			}
		});
		Badd.setMargin(new Insets(8, 14, 2, 14));
		Badd.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 18));
		Badd.setForeground(new Color(20, 23, 24));
		Badd.setBackground(new Color(20, 23, 24));
		Badd.setBounds(759, 519, 101, 30);
		ProductPanel.add(Badd);
		
		Bremove = new JButton("Remove");
		Bremove.setFocusable(false);
		Bremove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Bremove.setForeground(new Color(28,233,255));
				Bremove.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Bremove.setForeground(new Color(20, 23, 24));
				Bremove.setBorderPainted(true);
			}
		});
		Bremove.setMargin(new Insets(8, 14, 2, 14));
		Bremove.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 18));
		Bremove.setForeground(new Color(20, 23, 24));
		Bremove.setBackground(new Color(20, 23, 24));
		Bremove.setBounds(875, 519, 105, 30);
		ProductPanel.add(Bremove);
		
		Bupdate = new JButton("Update");
		Bupdate.setFocusable(false);
		Bupdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Bupdate.setForeground(new Color(28,233,255));
				Bupdate.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Bupdate.setForeground(new Color(20, 23, 24));
				Bupdate.setBorderPainted(true);
			}
		});
		Bupdate.setMargin(new Insets(8, 14, 2, 14));
		Bupdate.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 18));
		Bupdate.setForeground(new Color(20, 23, 24));
		Bupdate.setBackground(new Color(20, 23, 24));
		Bupdate.setBounds(990, 519, 101, 30);
		ProductPanel.add(Bupdate);
		
		JLabel LBtotaltext_1_1_1 = new JLabel("PRODUCT");
		LBtotaltext_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		LBtotaltext_1_1_1.setForeground(new Color(56, 185, 199));
		LBtotaltext_1_1_1.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 25));
		LBtotaltext_1_1_1.setBackground(new Color(238, 240, 240));
		LBtotaltext_1_1_1.setBounds(292, 13, 154, 32);
		ProductPanel.add(LBtotaltext_1_1_1);
		
		SettingPanel = new JPanel();
		SettingPanel.setBackground(new Color(20, 23, 24));
		CardPanel.add(SettingPanel, "name_25910368055600");
		SettingPanel.setLayout(null);
		
		JLabel LBtotaltext_1_1_2 = new JLabel("SETTING");
		LBtotaltext_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		LBtotaltext_1_1_2.setForeground(new Color(56, 185, 199));
		LBtotaltext_1_1_2.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 25));
		LBtotaltext_1_1_2.setBackground(new Color(238, 240, 240));
		LBtotaltext_1_1_2.setBounds(298, 13, 154, 32);
		SettingPanel.add(LBtotaltext_1_1_2);
		
		InvoicePanel = new JPanel();
		InvoicePanel.setForeground(new Color(58, 197, 193));
		InvoicePanel.setBackground(new Color(20, 23, 24));
		CardPanel.add(InvoicePanel, "name_26379143641400");
		InvoicePanel.setLayout(null);
		
		JLabel LBtotaltext_1_1_1_1 = new JLabel("INVOICE");
		LBtotaltext_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		LBtotaltext_1_1_1_1.setForeground(new Color(56, 185, 199));
		LBtotaltext_1_1_1_1.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 25));
		LBtotaltext_1_1_1_1.setBackground(new Color(238, 240, 240));
		LBtotaltext_1_1_1_1.setBounds(298, 13, 154, 32);
		InvoicePanel.add(LBtotaltext_1_1_1_1);
	}
	//----------------------------------------------------------------------------------------------------------------//
	public void addActionListener(ActionListener listener) {
		
		//---------Switch Panel --------------------------//
		
        BdashboardForm.addActionListener(listener);
        BproductForm.addActionListener(listener);
        BsettingForm.addActionListener(listener);
        BinvoiceForm.addActionListener(listener);
        Bsignout.addActionListener(listener);
        
      //-----------Manage Product -------------------------//
        
        Badd.addActionListener(listener);
        Bremove.addActionListener(listener);
        Bupdate.addActionListener(listener);
        
      //---------------------------------------------------//
        BcheckOut.addActionListener(listener);
        BSearch.addActionListener(listener);
        
    }
}
