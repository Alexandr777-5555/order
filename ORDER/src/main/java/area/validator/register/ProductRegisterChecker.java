package area.validator.register;


import area.answers.ProductRegisterResponse;
import area.order.Order;


public interface ProductRegisterChecker {


    ProductRegisterResponse checkProduct(Product product) throws Exception;


}
