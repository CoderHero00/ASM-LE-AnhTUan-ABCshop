/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Lenovo
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {

    @PersistenceContext(unitName = "ABCShopTestServer-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }

    @Override
    public List<Product> getAllProducts() {
         Query query = em.createNamedQuery("Product.findAll");
         List<Product> selectedPro = (List<Product>)query.getResultList();
         return selectedPro;
    }

    @Override
    public String addProduct(Product p) {
        Product NewProduct = new Product(p.getName(),p.getPrice(),p.getQuantity());
        em.persist(NewProduct);
        return "Success";
    }

    @Override
    public String sellProduct(int Productid, int quantity) {
       Product product = em.find(Product.class, Productid);
       if(quantity > product.getQuantity()){
           return "Fail";
       }
       product.setQuantity(product.getQuantity() - quantity);
       return "Success";
    }
    
}
