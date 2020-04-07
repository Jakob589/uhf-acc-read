import com.clou.uhf.G3Lib.CLReader;
import com.clou.uhf.G3Lib.ClouInterface.IAsynchronousMessage;

import java.util.Scanner;


public class Connect {

    public static String connect(final IAsynchronousMessage IA) {

        final Scanner sc = new Scanner(System.in);
        String connID = null;
        String label = null;

        System.out.println("Input IP");
        connID = sc.next();
        label = CLReader.CreateTcpConn(connID, IA) ? "Success" : "Failed";
        sc.close();   
        
        System.out.println(label);
        return connID;
    }

}
