package controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DAO.OrderDAO;
import DAO.ProductDAO;
import controller.ProductController;
import model.ProductModel;
import model.OrderModel;
import view.forms.MainView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TableController {
    private ProductController productController;
    private OrderController orderController;
    private MainView mv;
    private ProductDAO productDAO;
    private OrderDAO orderDAO;
    //private JTable table;
    

    public TableController(ProductController productController,OrderController orderController,MainView mv,ProductDAO productDAO,OrderDAO orderDAO) {
        this.productController = productController;       
        this.orderController = orderController;
        this.mv = mv;
        this.productDAO = productDAO;
        this.orderDAO = orderDAO;
        
        mv.BdashboardForm.addActionListener((e)->{
        	mv.Brefresh_invoice.doClick();
        	dashboardProductTable();
        });
        mv.BproductForm.addActionListener((e)->{
        	refreshProductTable(mv.Table_product);
        });
        mv.Brefresh.addActionListener((e)->{
        	refreshProductTable(mv.Table_product);
        	mv.LBwarning.setText("");
        	mv.IPproduct.setText("");
        	mv.IPprice.setText("");
        	mv.LBnotificate.setText("");
        	mv.RBavailable.setSelected(false);
        	mv.RBnotAvailable.setSelected(false);
        	mv.RBfood.setSelected(false);
        	mv.RBdrink.setSelected(false);
        	
        });
        
        mv.BsalesOrder.addActionListener((e)->{
        	 
        	refreshOrderTable(mv.Table_order);
        });
        
        mv.Bsearch_order.addActionListener((e)->{
        	try {
				int year = Integer.parseInt(mv.IPyear.getText());
				int month = Integer.parseInt(mv.IPmonth.getText());
				int day = Integer.parseInt(mv.IPday.getText());
				if(mv.IPday.getText().isEmpty() || mv.IPmonth.getText().isEmpty() ||mv.IPyear.getText().isEmpty()) {
					mv.LBnotificate_order.setText("Fill in the date");
				}else if(year < 0 || month < 1 || month > 12 || day < 1 || day > 31) {
					mv.LBnotificate_order.setText("Invalid date");
				}else {
					List<OrderModel> orders = orderDAO.getByDateOrder(year, month, day);
				    searchOrder(mv.Table_order, orders);
				}
			} catch (NumberFormatException e1) {
				mv.LBnotificate_order.setText("Invalid date");
				
			}
        	
            
        });
        mv.BrefreshOrder.addActionListener((e)->{     
        	refreshOrderTable(mv.Table_order);
        	mv.IPday.setText("");
        	mv.IPmonth.setText("");
        	mv.IPyear.setText("");
        	mv.LBnotificate_order.setText("");
        });
        
        mv.IPsearch_order.addActionListener((e)->{
        	List<OrderModel> orders = orderDAO.getByNameOrder(mv.IPsearch_order.getText());      	
        	searchOrder(mv.Table_order, orders);
        });;
       
        mv.IPsearch_dashboard.addActionListener((e)->{
        	List<ProductModel> products = productDAO.getByNameProduct(mv.IPsearch_dashboard.getText());        	
        	searchProduct_Dashboard(mv.Table_dasboard, products);
        });
        
        mv.IPsearch_product.addActionListener((e)->{    
        	List<ProductModel> products = productDAO.getByNameProduct(mv.IPsearch_product.getText());       	
        	searchProduct_Product(mv.Table_product, products);
        });
        
 
        
        mv.Badd_invoice.addActionListener((e)->{     	
        	addInvoice();

        	
        });
        mv.Brefresh_invoice.addActionListener((e)->{
        	DefaultTableModel model = (DefaultTableModel) mv.Table_invoice.getModel();
        	model.setRowCount(0);
        	mv.LBtotal.setText("");
        	mv.LBshowPrice.setText("");
        	mv.LBshowProduct.setText("");
        	mv.IPquantity.setText("");
        	mv.IPreceive.setText("");
        	mv.LBrefund.setText("");
        	mv.LBwarning_invoice.setText("");
        	dashboardProductTable();
        	
        });
        
       mv.Bremove_invoice.addActionListener((e)->{
    	   try {
				int myindex = mv.Table_invoice.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) mv.Table_invoice.getModel();
				model.removeRow(myindex);
				resetBill();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn mục cần xoá");

			}
       });
        
        
        
        
        //------------------------------------chọn dòng trên table --------------------------------//
        
        mv.Table_dasboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) mv.Table_dasboard.getModel();
				int myIndex = mv.Table_dasboard.getSelectedRow(); 
				int productID = Integer.parseInt(model.getValueAt(myIndex, 0).toString());
				mv.LBshowProduct.setText(model.getValueAt(myIndex, 1).toString()); 				
				mv.LBshowPrice.setText(model.getValueAt(myIndex, 3).toString());;
							
			}
		});
        
        mv.Table_product.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) mv.Table_product.getModel();
				int myIndex = mv.Table_product.getSelectedRow(); 
				int productID = Integer.parseInt(model.getValueAt(myIndex, 0).toString());
				mv.IPproduct.setText(model.getValueAt(myIndex, 1).toString()); 
				mv.IPprice.setText(model.getValueAt(myIndex, 3).toString());
				model.getValueAt(myIndex, 2).toString();
				
				if(model.getValueAt(myIndex, 2).toString()=="Drink") {
					mv.RBdrink.setSelected(true);
				}else {
					mv.RBfood.setSelected(true);
				}
				if(model.getValueAt(myIndex, 4).toString()=="Available") {
					mv.RBavailable.setSelected(true);
				}else {
					mv.RBnotAvailable.setSelected(true);
				}
			
			}
		});

    }
    
    
//--------------------------------------------------------------------------------------------------------//
 
    
    
    public void addInvoice() {
        String quantityText = mv.IPquantity.getText();
        String priceText = mv.LBshowPrice.getText();
        String productText = mv.LBshowProduct.getText();

        if (productText.isEmpty()) {
            mv.LBwarning_dashboard.setText("Please select a product");
            return;
        }
        
        if (quantityText.isEmpty()) {
            mv.LBwarning_dashboard.setText("Please enter quantity");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityText);
            if (quantity <= 0) {
                mv.LBwarning_dashboard.setText("Quantity must be greater than 0");
                return;
            }
        } catch (NumberFormatException e) {
            mv.LBwarning_dashboard.setText("Invalid quantity");
            return;
        }

        

        int price;
        try {
            price = Integer.parseInt(priceText);
        } catch (NumberFormatException e) {
            mv.LBwarning_dashboard.setText("Invalid price");
            return;
        }

        int total = price * quantity;
        DefaultTableModel model = (DefaultTableModel) mv.Table_invoice.getModel();
        model.addRow(new Object[]{productText, quantity, total});
        mv.LBwarning_dashboard.setText("");
        resetBill();
    }

    

    public void dashboardProductTable() {
    	
        List<ProductModel> productList = productController.getAllProducts();       
        DefaultTableModel model = (DefaultTableModel) mv.Table_dasboard.getModel();        
        model.setRowCount(0);

        for (ProductModel product : productList) {
        	if (!product.isProductStatus()) {
                // Nếu sản phẩm không có sẵn, bỏ qua việc thêm nó vào bảng
                continue;
            }
        	String category = product.isProductCategory() ? "Drink" : "Food";
            
        	
            model.addRow(new Object[]{product.getProductID(),
            						  product.getProductName(),
            						  category,
        							  product.getProductPrice()
        							  
        							  });
        }
        
        mv.Table_dasboard.setModel(model);                     
    }
    
    public void refreshProductTable(JTable table) {
    	
        List<ProductModel> productList = productController.getAllProducts();       
        DefaultTableModel model = (DefaultTableModel) table.getModel();        
        model.setRowCount(0);

        for (ProductModel product : productList) {
        	String category = product.isProductCategory() ? "Drink" : "Food";
            String status = product.isProductStatus() ? "Available" : "Not Available";
        	
            model.addRow(new Object[]{product.getProductID(),
            						  product.getProductName(),
            						  category,
        							  product.getProductPrice(),
        							  status
        							  });
        }    
        table.setModel(model);                     
    }
    
    public void refreshOrderTable(JTable table) {
    	
        List<OrderModel> orderlist = orderController.getAllOrders();  
        DefaultTableModel model = (DefaultTableModel) table.getModel();        
        model.setRowCount(0);

        for (OrderModel order : orderlist) {

            model.addRow(new Object[]{order.getID(),
            						  order.getCreator(),
            						  order.getTotal(),
        							  order.getDate()
        							  });
        }    
        table.setModel(model);                     
    }
    
    public void searchOrder(JTable table, List<OrderModel> orderlist) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for (OrderModel order : orderlist) {        	             
            model.addRow(new Object[]{order.getID(),
            						  order.getCreator(),
        						      order.getTotal(),
                                      order.getDate()
                                      
                                   	 });
        }
        table.setModel(model);
    }
    
    
    public void searchProduct_Dashboard(JTable table, List<ProductModel> productList) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for (ProductModel product : productList) {
        	if (!product.isProductStatus()) {
                
                continue;
            }
        	String category = product.isProductCategory() ? "Drink" : "Food";         
            model.addRow(new Object[]{product.getProductID(),
        						      product.getProductName(),
        						      category,
                                      product.getProductPrice(),
                                      "Available"
                                   	 });
        }
        table.setModel(model);
    }
    
    public void searchProduct_Product(JTable table, List<ProductModel> productList) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for (ProductModel product : productList) {
        	String category = product.isProductCategory() ? "Drink" : "Food";
            String status = product.isProductStatus() ? "Available" : "Not Available";
            model.addRow(new Object[]{product.getProductID(),
        						      product.getProductName(),
        						      category,
                                      product.getProductPrice(),
                                      status
                                   	 });
        }
        table.setModel(model);
    }
    
    private void resetBill() {
		int sum = 0;
		for (int row = 0; row < mv.Table_invoice.getRowCount(); row++) {
			int value = (int) mv.Table_invoice.getValueAt(row, 2);
			sum += value;
		}
		mv.LBtotal.setText(sum + "");

	}
    
}

