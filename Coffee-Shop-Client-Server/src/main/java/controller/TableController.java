package controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DAO.ProductDAO;
import controller.ProductController;
import model.ProductModel;
import view.forms.MainView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TableController {
    private ProductController productController;
    private MainView mv;
    private ProductDAO productDAO;
    //private JTable table;
    

    public TableController(ProductController productController,MainView mv,ProductDAO productDAO) {
        this.productController = productController;       
        this.mv = mv;
        this.productDAO = productDAO;
        
        mv.BdashboardForm.addActionListener((e)->{
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
        
        
        
        
       
        mv.IPsearch_dashboard.addActionListener((e)->{
        	List<ProductModel> products = productDAO.getByNameProduct(mv.IPsearch_dashboard.getText());        	
        	searchProduct_Product(mv.Table_dasboard, products);
        });
        
        mv.IPsearch_product.addActionListener((e)->{    
        	List<ProductModel> products = productDAO.getByNameProduct(mv.IPsearch_product.getText());       	
        	searchProduct_Product(mv.Table_product, products);
        });
        
 
        
        mv.Badd_invoice.addActionListener((e)->{
        	try {
				if (!mv.IPquantity.getText().isEmpty() 
						&& Integer.valueOf(mv.IPquantity.getText()) > 0
						&& !mv.LBshowPrice.getText().isEmpty()
						&& !mv.LBshowProduct.getText().isEmpty()) {
					int Total = Integer.valueOf(mv.LBshowPrice.getText()) * Integer.valueOf(mv.IPquantity.getText());
					DefaultTableModel model = (DefaultTableModel) mv.Table_invoice.getModel();

					model.addRow(new Object[] { mv.LBshowProduct.getText(), mv.IPquantity.getText(), Total });
					mv.LBwarning_dashboard.setText("");
					resetBill();
				} else {
					if (mv.LBshowProduct.getText().isEmpty()) {
						mv.LBwarning_dashboard.setText("Please select product");
					} else {
						mv.LBwarning_dashboard.setText("Please enter quantity");
					}
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Connect failed !");
				e1.printStackTrace();
			}
        });
        mv.Brefresh_invoice.addActionListener((e)->{
        	DefaultTableModel model = (DefaultTableModel) mv.Table_invoice.getModel();
        	model.setRowCount(0);
        	mv.LBtotal.setText("");
        	mv.LBshowPrice.setText("");
        	mv.LBshowProduct.setText("");
        	mv.IPquantity.setText("");
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

