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
    	
    		ProductModel product = new ProductModel();
    		
    		if(mv.IPproduct.getText().isEmpty()) {
				mv.LBwarning.setText("Please enter product name");			
			}
    		else if(mv.IPprice.getText().isEmpty()) {
				mv.LBwarning.setText("Please enter product price");	
			}
    		else if(!mv.RBdrink.isSelected() & !mv.RBfood.isSelected()){
				mv.LBwarning.setText("Please select product category");																						        
			}
    		else if(!mv.RBavailable.isSelected() & !mv.RBnotAvailable.isSelected()){
				mv.LBwarning.setText("Please select product status");																						        
			}
    		else {
			        if(mv.RBdrink.isSelected()) {
						product.setProductCategory(true);
					}else if(mv.RBfood.isSelected()) {
						product.setProductCategory(false);
					}
					if(mv.RBavailable.isSelected()) {
						product.setProductStatus(true);
					}else if(mv.RBnotAvailable.isSelected()) {
						product.setProductStatus(false);
					}					
			        product.setProductName(mv.IPproduct.getText());		            
		            product.setProductPrice(Integer.parseInt(mv.IPprice.getText()));
		            
		            
		            productDAO.addProduct(product);
		            mv.LBnotificate.setText("You have added "+mv.IPproduct.getText()+" to the list");
			}
      	

    }
    
    
    public void updateProduct() {
    	int productId = productDAO.getProductIDByName(mv.IPproduct.getText());
    	ProductModel product = productDAO.getProductById(productId);
    	
    	if(mv.IPproduct.getText().isEmpty()) {
			mv.LBwarning.setText("Please enter product name");			
		}
		else if(mv.IPprice.getText().isEmpty()) {
			mv.LBwarning.setText("Please enter product price");	
		}
		else if(mv.group_category.getSelection()==null){
			mv.LBwarning.setText("Please select product category");				
		}
		else if(mv.group_status.getSelection()==null){
			mv.LBwarning.setText("Please select product status");																						        
		}
		else {
		        if(mv.RBdrink.isSelected()) {
					product.setProductCategory(true);
				}else if(mv.RBfood.isSelected()) {
					product.setProductCategory(false);
				}
				if(mv.RBavailable.isSelected()) {
					product.setProductStatus(true);
				}else if(mv.RBnotAvailable.isSelected()) {
					product.setProductStatus(false);
				}
				
		        product.setProductName(mv.IPproduct.getText());		            
	            product.setProductPrice(Integer.parseInt(mv.IPprice.getText()));	
	            
	            productDAO.updateProduct(product);
	            mv.LBnotificate.setText("You just updated "+mv.IPproduct.getText()+",please click REFESH");
		}
    									
		
	}

    public void deleteProduct() {
    	if(mv.IPproduct.getText().isEmpty()) {
			mv.LBwarning.setText("Please select the product again");
    	}else {
    		try {
				int productId = productDAO.getProductIDByName(mv.IPproduct.getText());
				ProductModel product = productDAO.getProductById(productId);
				productDAO.deleteProduct(product);
			} catch (Exception e) {
				mv.LBwarning.setText("Shop does not have this product");
				e.printStackTrace();
			}
    	}
    	
    }

    public ProductModel getProductById(Integer productId) {
        return productDAO.getProductById(productId);
    }

    public List<ProductModel> getAllProducts() {
        return productDAO.getAllProducts();
    }


	
    

    
}
