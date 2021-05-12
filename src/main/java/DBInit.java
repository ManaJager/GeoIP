import com.maxmind.geoip2.DatabaseReader;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class DBInit {

    public DBInit() {
    }

    public DatabaseReader init() throws IOException {
        File database = new File(
                Objects.requireNonNull(ExampleGeoIP.class.getClassLoader().getResource("GeoLite2-City.mmdb")).getFile()
        );

        // This creates the DatabaseReader object. To improve performance, reuse
        // the object across lookups. The object is thread-safe.
        return new DatabaseReader.Builder(database).build();
    }
}
