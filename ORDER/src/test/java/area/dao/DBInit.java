package area.dao;


import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 *  инициализация БД для тестов
 *
 */
public class DBInit {


  public static void startUpClean() throws Exception{

      //у каждого класса есть класс лоудер который его загружает в JAVA машину
      URL url = OrderFormImplTest.class.getClassLoader().getResource("store_clean.sql");

      List<String> strings = Files.readAllLines(Paths.get(url.toURI()));

      String sql = strings.stream().collect(Collectors.joining());

      try(Connection conn=ConnectionBuilder.getConnection();
          Statement stmt=conn.createStatement();
      ){
          stmt.executeUpdate(sql);
      }

  }



    public static void startUp() throws Exception{

        //у каждого класса есть класс лоудер который его загружает в JAVA машину
        URL url = OrderFormImplTest.class.getClassLoader().getResource("store.sql");

        List<String> strings = Files.readAllLines(Paths.get(url.toURI()));

        String sql = strings.stream().collect(Collectors.joining());

        try(Connection conn=ConnectionBuilder.getConnection();
            Statement stmt=conn.createStatement();
        ){
            stmt.executeUpdate(sql);
        }

    }




}
