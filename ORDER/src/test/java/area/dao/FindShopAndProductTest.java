package area.dao;


import area.domen.Shop;
import area.exception.DaoException;
import area.product.ProductCut;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * тестируем функциональность поиска продуктов и магазинов
 *
 */
public class FindShopAndProductTest {

    private static final Logger LOGGER= LoggerFactory.getLogger(FindShopAndProductTest.class);
    @BeforeClass
    public static void startup() throws Exception {

        DBInit.startUp();
        System.out.println("Старт");

    }

    // @Before
    public void before() {

    }


    @Test
    public void testShopsCountSuccess()  throws DaoException {
        LocalDateTime time1=LocalDateTime.now();
        LocalDateTime time2=LocalDateTime.now();

        LOGGER.info("test {} {} " , time1  , time2);
        RequestDao request=new RequestDao();
        List<Shop> shops = request.findShop("");
        Assert.assertTrue(shops.size()==7);
    }

    @Test
    public void testFindProductsSuccess() throws DaoException {

        RequestDao requestDao=new RequestDao();
        List<ProductCut> list=requestDao.findProduct("");
        Assert.assertTrue(list.size()==7);
    }

}
