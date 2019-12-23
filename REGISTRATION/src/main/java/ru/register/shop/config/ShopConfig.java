package ru.register.shop.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.register.shop.dao.ShopDao;

/**
 *  конфигурируем бины с помощью кода
 *
 */
@Configuration
@PropertySource(value = {"classpath:/registration.properties"} )
public class ShopConfig {

  @Bean
    public ShopDao buildShopDAO(){
      System.out.println("SHOPDAO CREATE");
      return new ShopDao();
  }






}
