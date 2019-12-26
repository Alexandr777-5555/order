package ru.avdey.checkorder.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.avdey.checkorder.dao.OrderRepository;
import ru.avdey.checkorder.domain.DocumentOrder;
import ru.avdey.checkorder.domain.Product;
import ru.avdey.checkorder.view.OrderRequest;
import ru.avdey.checkorder.view.OrderResponse;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocOrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderResponse>  getOrderInfo(OrderRequest request) {

        List<DocumentOrder> docOrders = orderRepository
                .findDocumentOrders(request.getShopName(), request.getDateCreate(), request.getDesc());
        if (docOrders.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        List<OrderResponse> result = docOrders.stream().map(d -> getResponse(d)).collect(Collectors.toList());
        return result;
    }

    private OrderResponse getResponse(DocumentOrder doc){
        OrderResponse response =new OrderResponse();
        response.setShopName(doc.getShop().getName());
        response.setDateCreate(doc.getDateCreate());
        response.setDesc(doc.getDesc());
        return response;
    }
}
