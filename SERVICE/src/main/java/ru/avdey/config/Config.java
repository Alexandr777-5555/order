package ru.avdey.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";

    // хранит данные в коллекции
    private static Properties properties=new Properties(); // это частный случай MAP (имя , значение )


    public synchronized static String getProperties(String name) {
        if (properties.isEmpty()) {
            // загрузка данных из файла использовать будем потоки ввода вывода
            //говорим у класса конфиг есть класс Loader взять в нем текущий поток байтов
            // который находится в файле dao.properties
            // по русски хочу открыть поток байтов из такого файла dao.properties
            try(InputStream stream= Config.class.getClassLoader()
                    .getResourceAsStream("dao.properties")) {
                properties.load(stream); // загружаем все настройки из файла

            } catch (IOException e){

                e.printStackTrace(); // объяснить что не очень все хорошо получилось
                throw new RuntimeException();
            }

        }
        return properties.getProperty(name);
    }


}
