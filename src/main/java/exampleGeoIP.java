import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

public class exampleGeoIP {
    private static final String ip = "5.35.71.149";

    public static void main(String[] args) throws IOException, GeoIp2Exception {

        InetAddress ipAddress;

        try {
            ipAddress = InetAddress.getByName(ip);
        } catch (UnknownHostException e) {
            ipAddress = null;
        }

        CityResponse response = new DBInit().init().city(ipAddress);
        Map<String, String> geoData = new EnrichGeoIP().getGeoIPData(response);

        System.out.println("countryISOCode = " + geoData.get("countryISOCode"));
        System.out.println("countryName = " + geoData.get("countryName"));
        System.out.println("cityName = " + geoData.get("cityName"));
        System.out.println("timeZone = " + geoData.get("timeZone"));

        Map <String, String> ipData = new CutIP().getCutIP(ip);

        System.out.println("ipWebKeyClassA = " + ipData.get("ipWebKeyClassA"));
        System.out.println("ipWebKeyClassB = " + ipData.get("ipWebKeyClassB"));
        System.out.println("ipWebKeyClassC = " + ipData.get("ipWebKeyClassC"));

    }
}
