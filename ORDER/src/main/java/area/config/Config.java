package area.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * файл конфигурации для обращения к БД
 */
public class Config {
    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";
    public static final String SERVICE_URL = "service.url";

    // хранит данные в коллекции
    private static Properties properties=new Properties(); // это частный случай MAP (имя , значение )


    public synchronized static String getProperties(String name) {
        if (properties.isEmpty()) {
            // загрузка данных из файла использовать будем потоки ввода вывода
            //говорим у класса конфиг есть класс Loader взять в нем текущий поток байтов
            // который находится в файле config.properties
          // по русски хочу открыть поток байтов из такого файла config.properties
            try(InputStream stream= Config.class.getClassLoader()
                    .getResourceAsStream("config.properties")) {
                properties.load(stream); // загружаем все настройки из файла

            } catch (IOException e){

                e.printStackTrace(); // объяснить что не очень все хорошо получилось
                throw new RuntimeException();
            }

        }
        return properties.getProperty(name);
    }


}
