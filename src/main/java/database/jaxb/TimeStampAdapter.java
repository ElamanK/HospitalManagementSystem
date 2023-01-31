package database.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeStampAdapter extends XmlAdapter<String, Timestamp> {

    @Override
    public Timestamp unmarshal(String timestamp) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate = format.parse(timestamp);
        return new Timestamp(parsedDate.getTime());
    }

    @Override
    public String marshal(Timestamp timestamp) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(timestamp);
    }

}
