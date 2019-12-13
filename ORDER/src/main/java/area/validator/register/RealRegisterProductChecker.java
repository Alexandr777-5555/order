package area.validator.register;


import area.answers.ProductRegisterResponse;
import area.config.Config;
import area.exception.StoreRegisterException;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class RealRegisterProductChecker implements ProductRegisterChecker {


    @Override
    public ProductRegisterResponse checkProduct(Product product) throws Exception {

        try {
            ProductRegisterRequest request=new ProductRegisterRequest(product);
            Client client= ClientBuilder.newClient();
            ProductRegisterResponse response = client.target(
                    Config.getProperties(Config.SERVICE_URL))
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(request, MediaType.APPLICATION_JSON))
                    .readEntity(ProductRegisterResponse.class);
            return response;
        } catch (Exception e){
            throw new StoreRegisterException("1", e.getMessage(), e);
        }
    }
}
