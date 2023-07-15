package productcrudapp.Dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productcrudapp.model.Product;

//class to do all the Operations on the Relational Database using HibernateTemplate
@Component
public class ProductDao {
	
	//HibernateTemplate object automatically instantiated by spring MVC 
	//Configuration in /productcrudapp/src/main/webapp/WEB-INF/spring-servlet.xml 
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//To Add or Update Product Object in Relational Database
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	//To Get List of all Products stored in Relational Database
	public List<Product> getAllProducts(){
		return this.hibernateTemplate.loadAll(Product.class);
	}
	
	//To Delete Product Object in Relational Database
	@Transactional
	public void deleteProduct(int pid) {
		this.hibernateTemplate.delete(this.hibernateTemplate.load(Product.class, pid));
	}
	
	//To Get Product Object in Relational Database
	public Product getProduct(int pid) {
		return this.hibernateTemplate.get(Product.class,pid);
	}
	
	
}
