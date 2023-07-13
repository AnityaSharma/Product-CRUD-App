package productcrudapp.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.Dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/first")
	public String home(Model m) {
		
		List<Product> products=productDao.getAllProducts();
		m.addAttribute("product",products);
		
		System.out.println("Running Controller");
		return "indexx";
	}
	
	@RequestMapping(value="/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title","Add Product");
		return "addProductForm";
	}
	
	@RequestMapping(value = "handle-product" ,method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request) {
		
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		
		redirectView.setUrl(request.getContextPath()+"/");
		
		return redirectView;
	}
	
	//To delete a product
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId,HttpServletRequest request) {
		productDao.deleteProduct(productId);
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	

}
