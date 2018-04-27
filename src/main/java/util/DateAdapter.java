package util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {

    DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, frmt);
    }

    public String marshal(LocalDate v) throws Exception {
        return v.format(frmt);
    }
}
