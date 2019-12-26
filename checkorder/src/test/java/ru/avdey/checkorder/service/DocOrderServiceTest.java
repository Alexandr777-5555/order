package ru.avdey.checkorder.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
public class DocOrderServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocOrderServiceTest.class);

    @Autowired
    private DocOrderService docOrderService;

    @Test
    public void  simpleTest(){

        docOrderService.call();

        LOGGER.info("SIMPLE TEST");

    }


}