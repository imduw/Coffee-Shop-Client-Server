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
import javax.swing.border.TitledBorder;



public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JScrollPane ListProduct;
	public JTable Table_dasboard;
	public JTextField IPsearch_dashboard;
	public JScrollPane ListProductToInvoice;
	public JTable Table_invoice;
	public JScrollPane ListTable_product;
	public JTable Table_product;
	public JTextField IPsearch_product;
	public JTextField IPproduct;
	public JTextField IPprice;
	public JButton BdashboardForm;
	public JButton BhomeForm;
	public JButton BproductForm;
	public JButton BsalesOrder;
	public JPanel CardPanel;
	public JPanel DashboardPanel;
	public JPanel ProductPanel;
	public JPanel SettingPanel;
	public JPanel HomePanel;
	public JButton Bpayment;
	public JButton Badd;
	public JButton Bdelete;
	public JButton Bupdate;
	public JButton Bsignout;
	public ButtonGroup group_category;
	public ButtonGroup group_status;
	public JRadioButton RBavailable;
	public JRadioButton RBdrink;
	public JRadioButton RBfood;
	public JRadioButton RBnotAvailable;
	public JLabel LBwarning;
	public JLabel LBnotificate;
	public JButton Brefresh;
	public JTextField IPquantity;
	public JButton Badd_invoice;
	public JButton Brefresh_invoice;
	public JLabel LBshowProduct;
	public JLabel LBshowPrice;
	public JLabel LBwarning_dashboard;
	public JLabel LBtotal;
	public JButton Bremove_invoice;
	public JLabel LBnameclient;
	public JPanel SalesOrderPanel;
	public JScrollPane ListTable_order;
	public JTable Table_order;
	public JLabel LBnameclient_1;
	

	
	public MainView() {
		
		
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
		
		BhomeForm = new JButton("   Home");
		BhomeForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BhomeForm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	BhomeForm.setBackground(new Color(20, 23, 24)); 
            	BhomeForm.setForeground(new Color(28,233,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	BhomeForm.setBackground(new Color(32, 36, 38));
            	BhomeForm.setForeground(new Color(195, 195, 195));
            }
        });

		BhomeForm.setFocusable(false);
		BhomeForm.setMargin(new Insets(2, 20, 0, 14));
		BhomeForm.setForeground(new Color(195, 195, 195));
		BhomeForm.setBorderPainted(false);
		BhomeForm.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		BhomeForm.setHorizontalAlignment(SwingConstants.LEADING);
		BhomeForm.setBackground(new Color(32, 36, 38));
		BhomeForm.setBounds(0, 133, 233, 45);
		BhomeForm.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/home1.png"))));
		MenuPanel.add(BhomeForm);
		
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
		BdashboardForm.setBounds(7, 190, 226, 45);
		BdashboardForm.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/product.png"))));
		MenuPanel.add(BdashboardForm);
		
		BsalesOrder = new JButton("   Sales Order");
		BsalesOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	BsalesOrder.setBackground(new Color(20, 23, 24));  
            	BsalesOrder.setForeground(new Color(28,233,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	BsalesOrder.setBackground(new Color(32, 36, 38));
            	BsalesOrder.setForeground(new Color(195, 195, 195));
            }
        });
		BsalesOrder.setFocusable(false);
		BsalesOrder.setMargin(new Insets(2, 14, 0, 14));
		BsalesOrder.setHorizontalAlignment(SwingConstants.LEADING);
		BsalesOrder.setForeground(new Color(195, 195, 195));
		BsalesOrder.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		BsalesOrder.setBorderPainted(false);
		BsalesOrder.setBackground(new Color(32, 36, 38));
		BsalesOrder.setBounds(4, 305, 230, 45);
		BsalesOrder.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/invoice.png"))));
		MenuPanel.add(BsalesOrder);
		
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
		ListProduct.getVerticalScrollBar().setBackground(new Color(20,23,24));
		ListProduct.setBorder(new LineBorder(new Color(32, 36, 38), 10, true));
		ListProduct.setBackground(new Color(20, 23, 24));
		ListProduct.setBounds(52, 130, 573, 479);
		DashboardPanel.add(ListProduct);
		
		Table_dasboard = new JTable();
		Table_dasboard.setBorder(new LineBorder(new Color(32, 36, 38), 1, true));
		Table_dasboard.setFocusable(false);
		Table_dasboard.setRowMargin(0);
		Table_dasboard.setGridColor(new Color(128, 128, 128));
		Table_dasboard.setSelectionForeground(new Color(48, 200, 200));
		Table_dasboard.setForeground(new Color(255, 255, 255));
		Table_dasboard.setBackground(new Color(128, 128, 128));
		Table_dasboard.setSelectionBackground(new Color(40, 40, 40));
		Table_dasboard.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 15));
		Table_dasboard.setRowHeight(50);
		Table_dasboard.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Product", "Category", "Price"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Table_dasboard.getColumnModel().getColumn(0).setResizable(false);
		Table_dasboard.getColumnModel().getColumn(0).setPreferredWidth(37);
		Table_dasboard.getColumnModel().getColumn(1).setResizable(false);
		Table_dasboard.getColumnModel().getColumn(1).setPreferredWidth(128);
		Table_dasboard.getColumnModel().getColumn(2).setResizable(false);
		Table_dasboard.getColumnModel().getColumn(2).setPreferredWidth(64);
		Table_dasboard.getColumnModel().getColumn(3).setResizable(false);
		Table_dasboard.getColumnModel().getColumn(3).setPreferredWidth(112);
		ListProduct.setViewportView(Table_dasboard);
		
		JTableHeader header_product = Table_dasboard.getTableHeader();		
		header_product.setResizingAllowed(false);		
		header_product.setReorderingAllowed(false);
		header_product.setDefaultRenderer(new view.renderers.CustomTableHeaderRenderer());
		JViewport viewport = ListProduct.getViewport();
		viewport.setBackground(new Color(20, 23, 24));
		Table_dasboard.setDefaultRenderer(Object.class, new view.renderers.CustomTableCellRenderer());
		CardPanel.add(DashboardPanel);
		
		//------------------------------------------------------------------------------------------------------------------------------//
		
		JPanel invPanel = new JPanel();
		invPanel.setBackground(new Color(20, 23, 24));
		invPanel.setBounds(724, 0, 377, 824);
		DashboardPanel.add(invPanel);
		invPanel.setLayout(null);
		
		//-------------------------------------------Table-Invoice-----------------------------------------------------------------------------//
		
		ListProductToInvoice = new JScrollPane();
		ListProductToInvoice.setBorder(new LineBorder(new Color(32, 36, 38), 6, true));
		ListProductToInvoice.setBackground(new Color(28, 32, 34));
		ListProductToInvoice.setBounds(10,127, 333, 400); 
		
		Table_invoice = new JTable();
		Table_invoice.setFocusable(false);
		Table_invoice.setRowMargin(0);
		Table_invoice.setGridColor(new Color(128, 128, 128));
		Table_invoice.setSelectionForeground(new Color(48, 200, 200));
		Table_invoice.setForeground(new Color(255, 255, 255));
		Table_invoice.setBackground(new Color(128, 128, 128));
		Table_invoice.setSelectionBackground(new Color(40, 40, 40));
		Table_invoice.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 15));
		Table_invoice.setRowHeight(50);
		Table_invoice.setModel(
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
		Table_invoice.getColumnModel().getColumn(0).setResizable(false);
		Table_invoice.getColumnModel().getColumn(0).setPreferredWidth(89);
		Table_invoice.getColumnModel().getColumn(1).setResizable(false);
		Table_invoice.getColumnModel().getColumn(1).setPreferredWidth(52);
		Table_invoice.getColumnModel().getColumn(2).setResizable(false);
		ListProductToInvoice.setViewportView(Table_invoice);
		
		JTableHeader header_invoice = Table_invoice.getTableHeader();		
		header_invoice.setResizingAllowed(false);		
		header_invoice.setReorderingAllowed(false);
		header_invoice.setDefaultRenderer(new view.renderers.CustomTableHeaderRenderer());
		JViewport viewport1 = ListProductToInvoice.getViewport();
		viewport1.setBackground(new Color(20, 23, 24));
		Table_invoice.setDefaultRenderer(Object.class, new view.renderers.CustomTableCellRenderer());
		ListProductToInvoice.setBounds(10, 127, 360, 400);
		invPanel.add(ListProductToInvoice);
		
		//----------------------------------------------------------------------------------------------------------------//
		
		JLabel LBtotaltext = new JLabel("Total :");
		LBtotaltext.setHorizontalAlignment(SwingConstants.LEFT);
		LBtotaltext.setForeground(new Color(245, 245, 245));
		LBtotaltext.setFont(new Font("Visby Round CF", Font.PLAIN, 19));
		LBtotaltext.setBackground(new Color(238, 240, 240));
		LBtotaltext.setBounds(52, 563, 76, 28);
		invPanel.add(LBtotaltext);
		
		 LBtotal = new JLabel(". . .");
		LBtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		LBtotal.setForeground(new Color(245, 245, 245));
		LBtotal.setFont(new Font("Visby Round CF", Font.PLAIN, 19));
		LBtotal.setBackground(new Color(238, 240, 240));
		LBtotal.setBounds(139, 563, 144, 28);
		invPanel.add(LBtotal);
		
		JLabel lblVnd = new JLabel("vnd");
		lblVnd.setHorizontalAlignment(SwingConstants.LEFT);
		lblVnd.setForeground(new Color(245, 245, 245));
		lblVnd.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		lblVnd.setBackground(new Color(238, 240, 240));
		lblVnd.setBounds(293, 569, 32, 16);
		invPanel.add(lblVnd);
		
		Bpayment = new JButton("Payment");
		Bpayment.setAlignmentY(0.0f);
		Bpayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Bpayment.setForeground(new Color(28,233,255));
				Bpayment.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Bpayment.setForeground(new Color(28, 32, 34));
				Bpayment.setBorderPainted(true);
			}
		});
		Bpayment.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(28, 32, 34)));
		Bpayment.setMargin(new Insets(0, 0, 0, 0));
		Bpayment.setFocusable(false);
		Bpayment.setForeground(new Color(28, 32, 34));
		Bpayment.setBackground(new Color(20, 23, 24));
		Bpayment.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 21));
		Bpayment.setBounds(53, 655, 274, 44);
		invPanel.add(Bpayment);
		
		JLabel LBtotaltext_1 = new JLabel("INVOICE");
		LBtotaltext_1.setHorizontalAlignment(SwingConstants.LEFT);
		LBtotaltext_1.setForeground(new Color(56, 185, 199));
		LBtotaltext_1.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 25));
		LBtotaltext_1.setBackground(new Color(238, 240, 240));
		LBtotaltext_1.setBounds(108, 22, 110, 32);
		invPanel.add(LBtotaltext_1);
		
		//-----------------------------------------------------------------------------------------------------------------------//
		
		IPsearch_dashboard = new JTextField();
		IPsearch_dashboard.setCaretColor(new Color(240, 240, 240));
		IPsearch_dashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				IPsearch_dashboard.setText("");
				IPsearch_dashboard.setCaretColor(new Color(240,240,240));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				IPsearch_dashboard.setText("Search");
				IPsearch_dashboard.setCaretPosition(0);
				IPsearch_dashboard.setCaretColor(new Color(20,23,24));
			}
		});
		IPsearch_dashboard.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 14));
		IPsearch_dashboard.setForeground(new Color(240, 240, 240));
		IPsearch_dashboard.setText("Search");
		IPsearch_dashboard.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(230, 230, 230)));
		IPsearch_dashboard.setBackground(new Color(20, 23, 24));
		IPsearch_dashboard.setBounds(190, 56, 381, 40);
		IPsearch_dashboard.setCaretColor(new Color(20,23,24));
		DashboardPanel.add(IPsearch_dashboard);
		IPsearch_dashboard.setColumns(10);
		
		ProductPanel = new JPanel();
		ProductPanel.setBackground(new Color(20, 23, 24));
		CardPanel.add(ProductPanel, "name_18041534092000");
		ProductPanel.setLayout(null);
		//------------------------------------Table ở ProductPanel------------------------------------------------------------------------------------------//
		ListTable_product = new JScrollPane();		
		ListTable_product.setBorder(new LineBorder(new Color(32, 36, 38), 10, true));
		ListTable_product.setBackground(new Color(20, 23, 24));
		ListTable_product.setBounds(55, 130, 682, 606);
		ProductPanel.add(ListTable_product);
		
		Table_product = new JTable();
		Table_product.setFocusable(false);
		Table_product.setRowMargin(0);
		Table_product.setGridColor(new Color(128, 128, 128));
		Table_product.setSelectionForeground(new Color(50, 210, 210));
		Table_product.setForeground(new Color(255, 255, 255));
		Table_product.setBackground(new Color(128, 128, 128));
		Table_product.setSelectionBackground(new Color(40, 40, 40));
		Table_product.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 15));
		Table_product.setRowHeight(50);
		Table_product.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Product", "Category", "Price", "Status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Table_product.getColumnModel().getColumn(0).setResizable(false);
		Table_product.getColumnModel().getColumn(0).setPreferredWidth(32);
		Table_product.getColumnModel().getColumn(1).setResizable(false);
		Table_product.getColumnModel().getColumn(2).setResizable(false);
		Table_product.getColumnModel().getColumn(2).setPreferredWidth(55);
		Table_product.getColumnModel().getColumn(3).setResizable(false);
		Table_product.getColumnModel().getColumn(3).setPreferredWidth(59);
		Table_product.getColumnModel().getColumn(4).setResizable(false);
		Table_product.getColumnModel().getColumn(4).setPreferredWidth(60);
		ListTable_product.setViewportView(Table_product);
		
		JTableHeader header_product_1 = Table_product.getTableHeader();		
		header_product_1.setResizingAllowed(false);		
		header_product_1.setReorderingAllowed(false);
		header_product_1.setDefaultRenderer(new view.renderers.CustomTableHeaderRenderer());
		JViewport viewport_1 = ListTable_product.getViewport();
		viewport_1.setBackground(new Color(20, 23, 24));
		Table_product.setDefaultRenderer(Object.class, new view.renderers.CustomTableCellRenderer());
		CardPanel.add(DashboardPanel);
		
		//-----------------------------------------------------------------------------------------------------------------------------------------//
		
		IPsearch_product = new JTextField();
		IPsearch_product.setCaretColor(new Color(240, 240, 240));
		IPsearch_product.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				IPsearch_product.setText("");
				IPsearch_product.setCaretColor(new Color(240,240,240));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				IPsearch_product.setText("Search");
				IPsearch_product.setCaretPosition(0);
				IPsearch_product.setCaretColor(new Color(20,23,24));
			}
		});
		IPsearch_product.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 14));
		IPsearch_product.setForeground(new Color(240, 240, 240));
		IPsearch_product.setText("Search");
		IPsearch_product.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(230, 230, 230)));
		IPsearch_product.setBackground(new Color(20, 23, 24));
		IPsearch_product.setBounds(190, 56, 381, 40);
		IPsearch_product.setCaretColor(new Color(20,23,24));
		ProductPanel.add(IPsearch_product);
		IPsearch_product.setColumns(10);
		
		IPproduct = new JTextField();
		IPproduct.setCaretColor(new Color(255, 255, 255));
		
		IPproduct.setFont(new Font("Visby Round CF DemiBold", Font.BOLD, 15));
		IPproduct.setForeground(new Color(245, 245, 245));
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
		IPprice.setCaretColor(new Color(255, 255, 255));
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
		
		RBfood = new JRadioButton("  Food");
		RBfood.setFocusable(false);
		RBfood.setMargin(new Insets(2, 2, 0, 2));
		RBfood.setForeground(new Color(240, 240, 240));
		RBfood.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 16));
		RBfood.setBackground(new Color(20, 23, 24));
		RBfood.setBounds(888, 298, 174, 23);
		ProductPanel.add(RBfood);
		
		
		RBdrink = new JRadioButton("  Drink");
		RBdrink.setFocusable(false);
		RBdrink.setForeground(UIManager.getColor("Button.background"));
		RBdrink.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 16));
		RBdrink.setBackground(new Color(20, 23, 24));
		RBdrink.setBounds(888, 343, 174, 23);
		ProductPanel.add(RBdrink);
		
		group_category = new ButtonGroup();
		group_category.add(RBdrink);
		group_category.add(RBfood);
		
		
		
		RBavailable = new JRadioButton("  Available");
		RBavailable.setFocusable(false);
		RBavailable.setForeground(UIManager.getColor("Button.background"));
		RBavailable.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 16));
		RBavailable.setBackground(new Color(20, 23, 24));
		RBavailable.setBounds(887, 403, 174, 23);
		ProductPanel.add(RBavailable);
		
		
		RBnotAvailable = new JRadioButton("  Not available");
		RBnotAvailable.setFocusable(false);
		RBnotAvailable.setForeground(UIManager.getColor("Button.background"));
		RBnotAvailable.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 16));
		RBnotAvailable.setBackground(new Color(20, 23, 24));
		RBnotAvailable.setBounds(887, 439, 174, 23);
		ProductPanel.add(RBnotAvailable);
		
		JLabel LBtotaltext_1_1 = new JLabel("DASHBOARD");
		LBtotaltext_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		LBtotaltext_1_1.setForeground(new Color(56, 185, 199));
		LBtotaltext_1_1.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 25));
		LBtotaltext_1_1.setBackground(new Color(245, 195, 34));
		LBtotaltext_1_1.setBounds(298, 13, 154, 32);
		DashboardPanel.add(LBtotaltext_1_1);
		
		 LBshowProduct = new JLabel("");
		LBshowProduct.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(248, 248, 248)));
		LBshowProduct.setHorizontalAlignment(SwingConstants.CENTER);
		LBshowProduct.setForeground(new Color(248, 248, 248));
		LBshowProduct.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		LBshowProduct.setBounds(115, 649, 140, 32);
		DashboardPanel.add(LBshowProduct);
		
		 LBshowPrice = new JLabel("");
		LBshowPrice.setHorizontalAlignment(SwingConstants.CENTER);
		LBshowPrice.setForeground(new Color(248, 248, 248));
		LBshowPrice.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		LBshowPrice.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(248, 248, 248)));
		LBshowPrice.setBounds(274, 649, 116, 32);
		DashboardPanel.add(LBshowPrice);
		
		IPquantity = new JTextField();
		IPquantity.setHorizontalAlignment(SwingConstants.CENTER);
		IPquantity.setForeground(new Color(245, 245, 245));
		IPquantity.setFont(new Font("Visby Round CF DemiBold", Font.BOLD, 15));
		IPquantity.setColumns(10);
		IPquantity.setCaretColor(Color.WHITE);
		IPquantity.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		IPquantity.setBackground(new Color(20, 23, 24));
		IPquantity.setBounds(573, 656, 59, 23);
		DashboardPanel.add(IPquantity);
		
		JLabel lblNewLabel = new JLabel("Enter a quantity :");
		lblNewLabel.setForeground(new Color(248, 248, 248));
		lblNewLabel.setFont(new Font("Visby Round CF", Font.PLAIN, 14));
		lblNewLabel.setBounds(443, 645, 128, 36);
		DashboardPanel.add(lblNewLabel);
		
		Badd_invoice = new JButton("");
		Badd_invoice.setBorderPainted(false);
		Badd_invoice.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("/image/plus.png"))));
		
		Badd_invoice.setMargin(new Insets(8, 14, 2, 14));
		Badd_invoice.setForeground(new Color(20, 23, 24));
		Badd_invoice.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 14));
		Badd_invoice.setFocusable(false);
		Badd_invoice.setBackground(new Color(20, 23, 24));
		Badd_invoice.setBounds(651, 201, 71, 67);
		DashboardPanel.add(Badd_invoice);
		
		Brefresh_invoice = new JButton("");
		
		Brefresh_invoice.setBorderPainted(false);
		Brefresh_invoice.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("/image/refresh.png"))));
		
		Brefresh_invoice.setMargin(new Insets(8, 14, 2, 14));
		Brefresh_invoice.setForeground(new Color(20, 23, 24));
		Brefresh_invoice.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 14));
		Brefresh_invoice.setFocusable(false);
		Brefresh_invoice.setBackground(new Color(20, 23, 24));
		Brefresh_invoice.setBounds(652, 284, 67, 66);
		DashboardPanel.add(Brefresh_invoice);
		
		 LBwarning_dashboard = new JLabel("");
		LBwarning_dashboard.setHorizontalAlignment(SwingConstants.CENTER);
		LBwarning_dashboard.setForeground(new Color(220, 14, 19));
		LBwarning_dashboard.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		LBwarning_dashboard.setBackground(new Color(236, 15, 20));
		LBwarning_dashboard.setBounds(158, 615, 344, 30);
		DashboardPanel.add(LBwarning_dashboard);
		
		 Bremove_invoice = new JButton("");
		 Bremove_invoice.setBorderPainted(false);
		 Bremove_invoice.setIcon(new ImageIcon(
					Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("/image/delete.png"))));
		
		Bremove_invoice.setMargin(new Insets(8, 14, 2, 14));
		Bremove_invoice.setForeground(new Color(20, 23, 24));
		Bremove_invoice.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 14));
		Bremove_invoice.setFocusable(false);
		Bremove_invoice.setBackground(new Color(20, 23, 24));
		Bremove_invoice.setBounds(653, 366, 67, 63);
		DashboardPanel.add(Bremove_invoice);
		
		group_status = new ButtonGroup();
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
		
		Bdelete = new JButton("Delele");
		Bdelete.setFocusable(false);
		Bdelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Bdelete.setForeground(new Color(28,233,255));
				Bdelete.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Bdelete.setForeground(new Color(20, 23, 24));
				Bdelete.setBorderPainted(true);
			}
		});
		Bdelete.setMargin(new Insets(8, 14, 2, 14));
		Bdelete.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 18));
		Bdelete.setForeground(new Color(20, 23, 24));
		Bdelete.setBackground(new Color(20, 23, 24));
		Bdelete.setBounds(875, 519, 105, 30);
		ProductPanel.add(Bdelete);
		
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
		
		LBwarning = new JLabel("");
		LBwarning.setHorizontalAlignment(SwingConstants.CENTER);
		LBwarning.setBackground(new Color(236, 15, 20));
		LBwarning.setForeground(new Color(220, 14, 19));
		LBwarning.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		LBwarning.setBounds(747, 597, 344, 30);
		ProductPanel.add(LBwarning);
		
		LBnotificate = new JLabel("");
		LBnotificate.setHorizontalAlignment(SwingConstants.CENTER);
		LBnotificate.setForeground(new Color(56, 185, 199));
		LBnotificate.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		LBnotificate.setBackground(new Color(56, 185, 199));
		LBnotificate.setBounds(747, 630, 344, 30);
		ProductPanel.add(LBnotificate);
		
		Brefresh = new JButton("Refresh");
		Brefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Brefresh.setForeground(new Color(28,233,255));
				Brefresh.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Brefresh.setForeground(new Color(20, 23, 24));
				Brefresh.setBorderPainted(true);
			}
		});
		Brefresh.setMargin(new Insets(8, 14, 2, 14));
		Brefresh.setForeground(new Color(20, 23, 24));
		Brefresh.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 18));
		Brefresh.setFocusable(false);
		Brefresh.setBackground(new Color(20, 23, 24));
		Brefresh.setBounds(875, 568, 105, 30);
		ProductPanel.add(Brefresh);
		
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
		
		HomePanel = new JPanel();
		HomePanel.setForeground(new Color(58, 197, 193));
		HomePanel.setBackground(new Color(20, 23, 24));
		CardPanel.add(HomePanel, "name_26379143641400");
		HomePanel.setLayout(null);
		
		JLabel LBlogoclient = new JLabel("");
		LBlogoclient.setBounds(1041, 15, 32, 36);
		HomePanel.add(LBlogoclient);
		LBlogoclient.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/unknown.png"))));
		
		LBnameclient = new JLabel("Hello , ");
		LBnameclient.setBounds(398, 34, 300, 58);
		HomePanel.add(LBnameclient);
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
		LBnameclient.setHorizontalAlignment(SwingConstants.CENTER);
		LBnameclient.setBackground(new Color(238, 240, 240));
		LBnameclient.setForeground(new Color(245, 245, 245));
		LBnameclient.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 33));
		
		LBnameclient_1 = new JLabel("admin");
		LBnameclient_1.setHorizontalAlignment(SwingConstants.RIGHT);
		LBnameclient_1.setForeground(new Color(245, 245, 245));
		LBnameclient_1.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 13));
		LBnameclient_1.setBackground(new Color(238, 240, 240));
		LBnameclient_1.setBounds(918, 24, 118, 22);
		HomePanel.add(LBnameclient_1);
		
		SalesOrderPanel = new JPanel();
		SalesOrderPanel.setBackground(new Color(20, 23, 24));
		CardPanel.add(SalesOrderPanel, "name_1678656511700");
		SalesOrderPanel.setLayout(null);
		
		JLabel LBtotaltext_1_1_3 = new JLabel("SALES ORDER");
		LBtotaltext_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		LBtotaltext_1_1_3.setForeground(new Color(56, 185, 199));
		LBtotaltext_1_1_3.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 25));
		LBtotaltext_1_1_3.setBackground(new Color(245, 195, 34));
		LBtotaltext_1_1_3.setBounds(316, 42, 169, 32);
		SalesOrderPanel.add(LBtotaltext_1_1_3);
		
		//---------------------------------------------------------------------------------------------//
		
		ListTable_order = new JScrollPane();		
		ListTable_order.setBorder(new LineBorder(new Color(32, 36, 38), 10, true));
		ListTable_order.setBackground(new Color(20, 23, 24));
		ListTable_order.setBounds(55, 130, 700, 606);
		SalesOrderPanel.add(ListTable_order);
		
		Table_order = new JTable();
		Table_order.setFocusable(false);
		Table_order.setRowMargin(0);
		Table_order.setGridColor(new Color(128, 128, 128));
		Table_order.setSelectionForeground(new Color(50, 210, 210));
		Table_order.setForeground(new Color(255, 255, 255));
		Table_order.setBackground(new Color(128, 128, 128));
		Table_order.setSelectionBackground(new Color(40, 40, 40));
		Table_order.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 15));
		Table_order.setRowHeight(50);
		Table_order.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Creator", "Total", "Time"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Table_order.getColumnModel().getColumn(0).setResizable(false);
		Table_order.getColumnModel().getColumn(0).setPreferredWidth(32);
		Table_order.getColumnModel().getColumn(1).setResizable(false);
		Table_order.getColumnModel().getColumn(2).setResizable(false);
		Table_order.getColumnModel().getColumn(2).setPreferredWidth(55);
		Table_order.getColumnModel().getColumn(3).setResizable(false);
		Table_order.getColumnModel().getColumn(3).setPreferredWidth(59);
		ListTable_order.setViewportView(Table_order);
		
		JTableHeader header_order_1 = Table_order.getTableHeader();		
		header_order_1.setResizingAllowed(false);		
		header_order_1.setReorderingAllowed(false);
		header_order_1.setDefaultRenderer(new view.renderers.CustomTableHeaderRenderer());
		JViewport viewport_order = ListTable_order.getViewport();
		viewport_order.setBackground(new Color(20, 23, 24));
		Table_order.setDefaultRenderer(Object.class, new view.renderers.CustomTableCellRenderer());
		CardPanel.add(DashboardPanel);
		
		
		BsalesOrder.setVisible(false);
		Bpayment.setVisible(false);
	}
	//----------------------------------------------------------------------------------------------------------------//
	public void addActionListener(ActionListener listener) {
		
		//---------Switch Panel --------------------------//
		
        BdashboardForm.addActionListener(listener);
        BproductForm.addActionListener(listener);
//        BsettingForm.addActionListener(listener);
        BsalesOrder.addActionListener(listener);
        Bsignout.addActionListener(listener);
        
      //-----------Manage Product -------------------------//
        
        Badd.addActionListener(listener);
        Bdelete.addActionListener(listener);
        Bupdate.addActionListener(listener);
        
      //---------------------------------------------------//
        Bpayment.addActionListener(listener);
        
        
    }
}
