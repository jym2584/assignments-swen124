package question03;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * The Internet Assigned Numbers Authority (IANA) keeps track of IP addresses, domain names, etc.
 * 
 * This information can be retrieved for a given domain, e.g. "rit.edu", by connecting to
 * whois.iana.org on port 43.  Once connected, the program should write a single, new-line terminated,
 * String containing only the domain.
 * 
 * In response, iana will return one or more lines containing information about the domain.
 * 
 * Complete the getWhoIs method such that it
 * - establishes a connection to whois.iana.org on port 43
 * - sends a domain (given as the method parameter)
 * - reads all lines to get the domain details and stores the details in a stringbuffer
 * - returns a string with the domain details
 * 
 * 
 * Example for "microsoft.com"
 * % IANA WHOIS server
 * % for more information on IANA, visit http://www.iana.org
 * % This query returned 1 object

 * refer:        whois.verisign-grs.com

 * domain:       COM

 * organisation: VeriSign Global Registry Services
 * address:      12061 Bluemont Way
 * address:      Reston Virginia 20190
 * address:      United States

 * contact:      administrative
 * name:         Registry Customer Service
 * organisation: VeriSign Global Registry Services
 * address:      12061 Bluemont Way
 * address:      Reston Virginia 20190
 * address:      United States
 * phone:        +1 703 925-6999
 * fax-no:       +1 703 948 3978
 * e-mail:       info@verisign-grs.com
 * 
 * contact:      technical
 * name:         Registry Customer Service
 * organisation: VeriSign Global Registry Services
 * address:      12061 Bluemont Way
 * address:      Reston Virginia 20190
 * address:      United States
 * phone:        +1 703 925-6999
 * fax-no:       +1 703 948 3978
 * e-mail:       info@verisign-grs.com
 * 
 * nserver:      A.GTLD-SERVERS.NET 192.5.6.30 2001:503:a83e:0:0:0:2:30
 * nserver:      B.GTLD-SERVERS.NET 192.33.14.30 2001:503:231d:0:0:0:2:30
 * nserver:      C.GTLD-SERVERS.NET 192.26.92.30 2001:503:83eb:0:0:0:0:30
 * nserver:      D.GTLD-SERVERS.NET 192.31.80.30 2001:500:856e:0:0:0:0:30
 * nserver:      E.GTLD-SERVERS.NET 192.12.94.30 2001:502:1ca1:0:0:0:0:30
 * nserver:      F.GTLD-SERVERS.NET 192.35.51.30 2001:503:d414:0:0:0:0:30
 * nserver:      G.GTLD-SERVERS.NET 192.42.93.30 2001:503:eea3:0:0:0:0:30
 * nserver:      H.GTLD-SERVERS.NET 192.54.112.30 2001:502:8cc:0:0:0:0:30
 * nserver:      I.GTLD-SERVERS.NET 192.43.172.30 2001:503:39c1:0:0:0:0:30
 * nserver:      J.GTLD-SERVERS.NET 192.48.79.30 2001:502:7094:0:0:0:0:30
 * nserver:      K.GTLD-SERVERS.NET 192.52.178.30 2001:503:d2d:0:0:0:0:30
 * nserver:      L.GTLD-SERVERS.NET 192.41.162.30 2001:500:d937:0:0:0:0:30
 * nserver:      M.GTLD-SERVERS.NET 192.55.83.30 2001:501:b1f9:0:0:0:0:30
 * ds-rdata:     30909 8 2 E2D3C916F6DEEAC73294E8268FB5885044A833FC5459588F4A9184CFC41A5766
 * 
 * whois:        whois.verisign-grs.com
 * 
 * status:       ACTIVE
 * remarks:      Registration information: http://www.verisigninc.com
 * 
 * created:      1985-01-01
 * changed:      2017-10-05
 * source:       IANA
 */
public class WhoIs {
    private static final String SERVER = "whois.iana.org";
    private static final int PORT = 43;

    public static String getWhoIs(String domain) throws Exception {
        StringBuffer sb = new StringBuffer();

		Socket socket = new Socket(SERVER, PORT);
		Scanner in = new Scanner(socket.getInputStream());
		PrintWriter out = new PrintWriter(socket.getOutputStream());
        
		out.println(domain); // send domain to server
        out.flush();
        
		while (in.hasNext()) {
			sb.append(in.nextLine() + "\n");
		}
        
        in.close();
        out.close();
        socket.close();

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getWhoIs("microsoft.com"));
    }
    
}
