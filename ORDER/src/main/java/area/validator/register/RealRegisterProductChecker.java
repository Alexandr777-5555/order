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
            // 1 необходимо создать экземпляр клиента Jersey
            // это обычный запрос без всяких скрытых и безопасности обычный простой запрос
            Client client= ClientBuilder.newClient();
            // 2 куда вы собираетесь  - цель
         //   System.out.println(client.getConfiguration().getRuntimeType());
            ProductRegisterResponse response = client.target(
                    Config.getProperties(Config.SERVICE_URL))
                    // 3 определить параметры запроса мы JSON отправляем
                    .request(MediaType.APPLICATION_JSON)
                   // .acceptEncoding("UTF-8")//TODO это я написал
                    //4 отрпавить запрос методом пост
                    //в параметрах request и в каком формате преобразование  по параметрам передаем
                    .post(Entity.entity(request, MediaType.APPLICATION_JSON))
                    // 5 ожидаемый ответ (набор полей )
                    .readEntity(ProductRegisterResponse.class);
            return response; // TODO тут нет ответа !!!
        } catch (Exception e){
            throw new StoreRegisterException("1", e.getMessage(), e);
        }




    }
}
