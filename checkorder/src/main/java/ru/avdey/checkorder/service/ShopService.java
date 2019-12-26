package ru.avdey.checkorder.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.avdey.checkorder.dao.ShopRepository;
import ru.avdey.checkorder.domain.DocumentOrder;
import ru.avdey.checkorder.domain.Shop;
import ru.avdey.checkorder.view.ShopRequest;
import ru.avdey.checkorder.view.ShopResponse;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopService.class);
    @Autowired
    private ShopRepository repository;

    public List<ShopResponse> getShopInfo(ShopRequest request) {
        List<Shop> shops = repository.findShops(request.getName(), request.getAddress());
        if (shops.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<DocumentOrder> orders = shops.get(0).getDocuments();
        List<ShopResponse> result = orders
                .stream()
                .map(doc -> getResponse(doc))
                .collect(Collectors.toList());
        return result;
    }


    private ShopResponse getResponse(DocumentOrder order) {
        ShopResponse resp = new ShopResponse();
        resp.setDateCreate(order.getDateCreate());
        resp.setDesc(order.getDesc());
        resp.setDiscount(order.getDiscount());
        return resp;
    }
}



