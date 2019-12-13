package area.main;

import area.answers.ProductRegisterResponse;
import area.validator.register.Product;
import area.validator.register.RealRegisterProductChecker;


public class Main {

    public static void main(String[] args) throws Exception {

        Product product=new Product("ряженка" , 1 ,  76 , 25.08 , null);

       // ProductRegisterRequest request=new ProductRegisterRequest();


        RealRegisterProductChecker checker=new RealRegisterProductChecker();

        ProductRegisterResponse productRegisterResponse = checker.checkProduct(product);

        System.out.println(productRegisterResponse.isExist());
        System.out.println(productRegisterResponse.getCount());
    }
}

