import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.IspResponse;
import com.maxmind.geoip2.record.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class test {
    public static void main(String[] args) throws IOException, GeoIp2Exception {
        // A File object pointing to your GeoIP2 or GeoLite2 database
//        File database = new File("/resources/GeoLite2-City.mmdb");
        File database = new File(
                test.class.getClassLoader().getResource("GeoLite2-City.mmdb").getFile()
        );

// This creates the DatabaseReader object. To improve performance, reuse
// the object across lookups. The object is thread-safe.
        DatabaseReader reader = new DatabaseReader.Builder(database).build();

        InetAddress ipAddress = InetAddress.getByName("5.35.71.149");
// Replace "city" with the appropriate method for your database, e.g.,
// "country".
        CityResponse response = reader.city(ipAddress);

        Country country = response.getCountry();
        System.out.println(country.getIsoCode());            // 'US'
        System.out.println(country.getName());               // 'United States'
        //System.out.println(country.getNames().get("zh-CN")); // '美国'

        //Subdivision subdivision = response.getMostSpecificSubdivision();
        //System.out.println(subdivision.getName());    // 'Minnesota'
        //System.out.println(subdivision.getIsoCode()); // 'MN'

        City city = response.getCity();
        System.out.println(city.getName()); // 'Minneapolis'

        //Postal postal = response.getPostal();
        //System.out.println(postal.getCode()); // '55455'

        Location location = response.getLocation();
        //System.out.println(location.getLatitude());  // 44.9733
        //System.out.println(location.getLongitude()); // -93.2323
        System.out.println(location.getTimeZone());        // 'America/Chicago'
    }
}
