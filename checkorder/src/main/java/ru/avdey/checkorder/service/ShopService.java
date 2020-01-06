package ru.avdey.checkorder.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.avdey.checkorder.dao.ShopRepository;
import ru.avdey.checkorder.domain.Discount;
import ru.avdey.checkorder.domain.DocumentOrder;
import ru.avdey.checkorder.domain.Shop;
import ru.avdey.checkorder.view.ShopRequest;
import ru.avdey.checkorder.view.ShopResponse;
import ru.avdey.checkorder.view.adapter.LocalDateAdapter;

import javax.annotation.PostConstruct;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopService.class);
    private List<Shop> shopList;

    @Autowired
    private ShopRepository repository;


    @PostConstruct
    private void init() {
        if (shopList == null) {
            System.out.println("use default");
            shopList = Collections.EMPTY_LIST;
        }
    }

    @Transactional
    public List<ShopResponse> getShopInfo(ShopRequest request) {
        shopList = repository.findShop(request.getName(), request.getAddress());
        if (shopList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<DocumentOrder> orders = shopList.get(0).getDocuments();
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



