package ru.avdey.domain;


import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//что бы возможно было преобразование из строки и обратно используется XmlAdapter<String , LocalDate>

public class LocalDateAdapter extends XmlAdapter<String , LocalDate> {
    @Override
    public LocalDate unmarshal(String v) throws Exception {
        if(v==null){
            return LocalDate.parse(v, DateTimeFormatter.ofPattern("03.03.2003"));
        }

        return LocalDate.parse(v, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
