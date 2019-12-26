package ru.avdey.checkorder.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.avdey.checkorder.service.ShopService;
import ru.avdey.checkorder.view.ShopRequest;
import ru.avdey.checkorder.view.ShopResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/shop")
public class ShopController {

    @Autowired
    private ShopService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<ShopResponse> getShopInfo(ShopRequest request) {
        return service.getShopInfo(request);
    }

}
