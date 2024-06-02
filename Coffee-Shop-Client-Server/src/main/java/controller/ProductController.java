package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;

import DAO.ProductDAO;
import model.ProductModel;
import view.forms.MainView;
import view.forms.LoginView;

public class ProductController  {
    private ProductDAO productDAO;
    private MainView mv;
    private LoginView lv;
    private ProductModel productModel;
    
    
    

	public ProductController(ProductDAO productDAO, MainView mainView, LoginView loginView, ProductModel productModel) {
		
		this.productDAO = productDAO;
		this.mv = mainView;
		this.lv = loginView;
		this.productModel = productModel;
		
		
		mv.Badd.addActionListener((e)->{
			mv.LBwarning.setText("");	
			addProduct();
		});
		
		mv.Bupdate.addActionListener((e)->{
			mv.LBwarning.setText("");	
			updateProduct();
		});
		mv.Bdelete.addActionListener((e)->{	
			mv.LBwarning.setText("");	
			deleteProduct();
		});
		
		
		
	}
	
	
//----------------------------------------------------------------------------------------------------------------------------------//
	
	
	public void addProduct() {
	    String productName = mv.IPproduct.getText();
	    String priceText = mv.IPprice.getText();

	    if (productName.isEmpty()) {
	        mv.LBwarning.setText("Please enter product name");
	        return;
	    }

	    if (priceText.isEmpty()) {
	        mv.LBwarning.setText("Please enter product price");
	        return;
	    }

	    int price;
	    try {
	        price = Integer.parseInt(priceText);
	        if (price <= 0) {
	            mv.LBwarning.setText("Product price must be greater than 0");
	            return;
	        }
	    } catch (NumberFormatException e) {
	        mv.LBwarning.setText("Invalid product price");
	        return;
	    }

	    if (!mv.RBdrink.isSelected() && !mv.RBfood.isSelected()) {
	        mv.LBwarning.setText("Please select product category");
	        return;
	    }

	    if (!mv.RBavailable.isSelected() && !mv.RBnotAvailable.isSelected()) {
	        mv.LBwarning.setText("Please select product status");
	        return;
	    }

	    boolean isDrink = mv.RBdrink.isSelected();
	    boolean isAvailable = mv.RBavailable.isSelected();

	    ProductModel product = new ProductModel();
	    product.setProductName(productName);
	    product.setProductPrice(price);
	    product.setProductCategory(isDrink);
	    product.setProductStatus(isAvailable);

	    productDAO.addProduct(product);
	    mv.LBnotificate.setText("You have added " + productName + " to the list");
	}

    
    
	public void updateProduct() {
	    String productName = mv.IPproduct.getText();
	    String priceText = mv.IPprice.getText();

	    if (productName.isEmpty()) {
	        mv.LBwarning.setText("Please enter product name");
	        return;
	    }

	    if (priceText.isEmpty()) {
	        mv.LBwarning.setText("Please enter product price");
	        return;
	    }

	    if (mv.group_category.getSelection() == null) {
	        mv.LBwarning.setText("Please select product category");
	        return;
	    }

	    if (mv.group_status.getSelection() == null) {
	        mv.LBwarning.setText("Please select product status");
	        return;
	    }

	    Integer productIdInteger = productDAO.getProductIDByName(productName);
	    if (productIdInteger == null) {
	        mv.LBwarning.setText("Product does not exist");
	        return;
	    }

	    int productId = productIdInteger.intValue(); // Chuyển Integer thành int
	    boolean isDrink = mv.RBdrink.isSelected();
	    boolean isAvailable = mv.RBavailable.isSelected();

	    ProductModel product = new ProductModel();
	    product.setProductID(productId);
	    product.setProductName(productName);
	    product.setProductPrice(Integer.parseInt(priceText));
	    product.setProductCategory(isDrink);
	    product.setProductStatus(isAvailable);

	    productDAO.updateProduct(product);
	    mv.LBnotificate.setText("You just updated " + productName + ", please click REFRESH");
	}



	public void deleteProduct() {
	    String productName = mv.IPproduct.getText();

	    if (productName.isEmpty()) {
	        mv.LBwarning.setText("Please select the product again");
	        return;
	    }

	    Integer productIdInteger = productDAO.getProductIDByName(productName);

	    if (productIdInteger == null || productIdInteger == -1) {
	        mv.LBwarning.setText("Product does not exist");
	        return;
	    }

	    int productId = productIdInteger.intValue(); // Chuyển Integer thành int

	    try {
	        ProductModel product = productDAO.getProductById(productId);
	        productDAO.deleteProduct(product);
	    } catch (Exception e) {
	        mv.LBwarning.setText("An error occurred while deleting the product");
	        e.printStackTrace();
	    }
	}


    public ProductModel getProductById(Integer productId) {
        return productDAO.getProductById(productId);
    }

    public List<ProductModel> getAllProducts() {
        return productDAO.getAllProducts();
    }


	
    

    
}
