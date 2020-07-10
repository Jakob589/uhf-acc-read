public class ParseEPC {
    public static void parseEPC(final String result) {
    
    
    if(result.length() == 20) {

        // format of the result = "AA02FDFF3C00D603E0EE";
        final String parsedResult = result.substring(0,2); //first two bytes are header or check bytes
        if(parsedResult.equals("AA")){
            
            String qosHex = result.substring(18,20);
            String qos = "null";

            //Becaunse little endian we have to flip frist two bytes and second two bytes
            String xHex = result.substring(6,8) + result.substring(4,6);
            String yHex = result.substring(10,12) + result.substring(8,10);
            String zHex = result.substring(14,16) + result.substring(12,14);

            //explanation 
            final int x=toInit16(xHex);
            final int y=toInit16(yHex); 
            final int z=toInit16(zHex);
            
            if (qosHex.equals("EE")) qos = "good";
            if (qosHex.equals("FF")) qos = "best";
            if (qosHex.equals("CC")) qos = "bad" ;

            System.out.print("{\"x\":\"");
            System.out.print(x);
            System.out.print("\", \"y\":\"");
            System.out.print(y);
            System.out.print("\", \"z\":\"");
            System.out.print(z);
            System.out.print("\", \"status\":\"");
            System.out.print("up\" ");
            System.out.print(",\"QoS\":\"");
            System.out.print(qos);
            System.out.println("\" }");
            }
        else{

            printNull(); //called void bellow
            
            }
    }else{

        printNull(); //called void defined below
        
        }
    }
    public static Integer toInit16(final String hex) {
    
    //covertiong signed hexadecimal to deccimal
    //32767 is half all numbers in init16 that measn half are positive half negative

    int dec = Integer.parseInt(hex,16);

    if(dec > 32767){

      String bin = Integer.toString(dec,2);
      String binCompl = bin.replace('0', 'X').replace('1', '0').replace('X', '1');
      dec = (Integer.parseInt(binCompl, 2) + 1) * -1;

    }
    return dec;

    }

    public static void printNull() {

        System.out.print("{\"x\":\"");
        System.out.print("0");
        System.out.print("\", \"y\":\"");
        System.out.print("0");
        System.out.print("\", \"z\":\"");
        System.out.print("0");
        System.out.print("\", \"status\":\"");
        System.out.print("down\",");
        System.out.print(" \"QoS\":\"");
        System.out.print("bad");
        System.out.println("\" }");

    }
}
  




