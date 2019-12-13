package ru.avdey.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.avdey.dao.CheckOrderDao;
import ru.avdey.dao.PoolConnectionBuilder;
import ru.avdey.domain.ProductRequest;
import ru.avdey.domain.ProductResponse;
import ru.avdey.exception.ProductCheckException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "CheckOrderServlet" , urlPatterns = {"/checkOrder"})
public class CheckOrderServlet extends HttpServlet {

    private static final Logger LOGGER= LoggerFactory.getLogger(CheckOrderServlet.class);

    private  CheckOrderDao checkOrderDao ;

    @Override
    public void init() throws ServletException {

        LOGGER.info("SERVLET CREATED");
        checkOrderDao=new CheckOrderDao();
        checkOrderDao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println("GET CHECK ORDER");

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

       // String id=req.getParameter("id_prod");



        Integer id=Integer.parseInt(req.getParameter("id"));
        String title=req.getParameter("title");

            //TODO дату не использую сейчас но это нужная вещ
        //   LocalDate date = LocalDate.parse(req.getParameter("date"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));


        // int id=Integer.valueOf(ids);

        // int id=Integer.valueOf(req.getParameter("idprod")) ; // req.getParameter("id_prod");




      //  int count=Integer.valueOf(req.getParameter("count"));

        ProductRequest request = new ProductRequest();

        request.setProduct_id(id);
        request.setTitle(title);
       // request.setTitle("молоко");
        request.setProductCount(76);
        request.setPrice(25.08);
        //TODO и сюда передадим дату date
        request.setDate(LocalDate.of(2012, 05, 15));

           //TODO изменим это потому что неправильно сделано не ищет по ID это не строка
           // TODO по названию ищет продукта

        try {

            ProductResponse response = checkOrderDao.checkProductForName(request);
            if (response.isExist()){

                resp.getWriter().write("YES");
            }
            else {
                resp.getWriter().write("NO");
            }
        } catch (ProductCheckException e) {
            e.printStackTrace();
        }


    }
}
