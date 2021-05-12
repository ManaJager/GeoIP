import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CutIP {
    public CutIP() {
    }

    public Map<String, String> getCutIP(String ip) {
        Map<String, String> ipMap = new HashMap<>();

        StringTokenizer tokenizer = new StringTokenizer(ip, ".");
        String ipWebKeyClassA, ipWebKeyClassB, ipWebKeyClassC;
        if (tokenizer.countTokens() == 4) {
            String[] ipCutted = new String[tokenizer.countTokens()];
            for (int i = 0; i < 4; i++) {
                ipCutted[i] = tokenizer.nextToken();
            }

            ipMap.put("ipWebKeyClassA", ipCutted[0]);
            ipMap.put("ipWebKeyClassB", ipCutted[0] + "." + ipCutted[1]);
            ipMap.put("ipWebKeyClassC", ipCutted[0] + "." + ipCutted[1] + "." + ipCutted[2]);
        }
        return ipMap;
    }
}
