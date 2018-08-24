/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Product;
import entity.ProductFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Lenovo
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    @EJB
    private ProductFacadeLocal productFacade;

    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getAllProduct")
    public List<Product> getAllProduct() {
        return productFacade.getAllProducts();
    }
    
    @WebMethod(operationName = "addProduct")
    public String addProduct(@WebParam(name = "product") Product product) {
        return productFacade.addProduct(product);
    }
    
    @WebMethod(operationName = "sellProduct")
    public String sellProduct(@WebParam(name = "id") int id, @WebParam(name = "quantity") int quantity) {
        return productFacade.sellProduct(id, quantity);
    }
}
