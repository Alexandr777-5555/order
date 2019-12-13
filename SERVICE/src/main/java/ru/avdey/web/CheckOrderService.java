package ru.avdey.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.avdey.dao.CheckOrderDao;
import ru.avdey.dao.PoolConnectionBuilder;
import ru.avdey.domain.ProductRequest;
import ru.avdey.domain.ProductResponse;
import ru.avdey.exception.ProductCheckException;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/check")
@Singleton
public class CheckOrderService {

    private CheckOrderDao checkOrderDao ;
    private static final Logger LOGGER= LoggerFactory.getLogger(CheckOrderService.class);

    @PostConstruct // выполнить действия сразу после создания объекта
    public void init(){

        LOGGER.info("SERVICE CREATED");
        checkOrderDao=new CheckOrderDao();
        checkOrderDao.setConnectionBuilder(new PoolConnectionBuilder());
        LOGGER.info("START");
       // System.out.println("старт");
    }


    @POST // сложные параметры постом надо передавать
    @Consumes(MediaType.APPLICATION_JSON) // потребляет в виде JSON
    @Produces(MediaType.APPLICATION_JSON) // производит
    public ProductResponse checkOrder(ProductRequest request) throws ProductCheckException { // у меня есть аннотированный параметр
        /*
        request = new ProductRequest();
        request.setProduct_id(1);
        request.setTitle("молоко");
        request.setProductCount(76);
        request.setPrice(25.08);
        request.setDate(LocalDate.of(2012, 05, 15));
         */

         LOGGER.info("ProductResponse ЗАПРОС  - " + request.toString());
       // System.out.println(request.toString());
        return checkOrderDao.checkProductForName(request);

       // throw new ProductCheckException("EXCEPTION!!!");
    }


    // делаем что бы возвращала



}
