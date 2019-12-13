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

        req.setCharacterEncoding("UTF-8");
        Integer id=Integer.parseInt(req.getParameter("id"));
        String title=req.getParameter("title");

        ProductRequest request = new ProductRequest();
        request.setProduct_id(id);
        request.setTitle(title);
        request.setProductCount(76);
        request.setPrice(25.08);
        request.setDate(LocalDate.of(2012, 05, 15));


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
