import com.clou.uhf.G3Lib.Enumeration.eReadType;


public class Tag6C {

    public static String tag6C(final String connID) throws InterruptedException {

        while (true) {
        
                final int antNum = 1;
                final eReadType readType = eReadType.Inventory;
                final int readStart = 256; //0x0100 
                final int readLen = 5;

                com.clou.uhf.G3Lib.Tag6C.GetEPC_TID_UserData(connID, antNum, readType,readStart, readLen);
                
                }
            }
        }
    

                                
