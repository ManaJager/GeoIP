import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;

import java.util.HashMap;
import java.util.Map;

public class EnrichGeoIP {

    public EnrichGeoIP() {
    }

    public Map<String, String> getGeoIPData(CityResponse response){
        Map<String, String> map = new HashMap<>();
        Country country = response.getCountry();
        City city = response.getCity();
        Location location = response.getLocation();

        map.put("countryISOCode", country.getIsoCode());
        map.put("countryName", country.getName());
        map.put("cityName", city.getName());
        map.put("timeZone", location.getTimeZone());

        return map;
    }
}
