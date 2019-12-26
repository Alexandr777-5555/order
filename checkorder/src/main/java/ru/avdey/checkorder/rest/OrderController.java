package ru.avdey.checkorder.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.avdey.checkorder.service.DocOrderService;
import ru.avdey.checkorder.view.OrderRequest;
import ru.avdey.checkorder.view.OrderResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/order")
public class OrderController {

    @Autowired
    private DocOrderService docService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderResponse> getOrderInfo(OrderRequest request) {
        return docService.getOrderInfo(request);
    }

}

