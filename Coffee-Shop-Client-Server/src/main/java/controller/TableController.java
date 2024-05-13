package controller;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import controller.ProductController;
import dao.ProductDAO;
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
        	dashboardProductTable(mv.Table_dasboard);
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
        });
       
        mv.IPsearch_dashboard.addActionListener((e)->{
        	List<ProductModel> products = productDAO.getByNameProduct(mv.IPsearch_dashboard.getText());
        	for(ProductModel product :products) {
        		System.out.println(product.getProductName());
        	}
        	searchProduct_Product(mv.Table_dasboard, products);
        });
        
        mv.IPsearch_product.addActionListener((e)->{    
        	List<ProductModel> products = productDAO.getByNameProduct(mv.IPsearch_product.getText());
        	for(ProductModel product :products) {
        		System.out.println(product.getProductName());
        	}
        	searchProduct_Product(mv.Table_product, products);
        });
        
        
        mv.Table_product.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) mv.Table_product.getModel();
				int myIndex = mv.Table_product.getSelectedRow(); 
				int productID = Integer.parseInt(model.getValueAt(myIndex, 0).toString());
				mv.IPproduct.setText(model.getValueAt(myIndex, 1).toString()); 
				mv.IPprice.setText(model.getValueAt(myIndex, 3).toString()); 
				
			}
		});

    }
    
    
//--------------------------------------------------------------------------------------------------------//
    
    
    public void dashboardProductTable(JTable table) {
    	
        List<ProductModel> productList = productController.getAllProducts();       
        DefaultTableModel model = (DefaultTableModel) table.getModel();        
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
        
        table.setModel(model);                     
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
    
}

