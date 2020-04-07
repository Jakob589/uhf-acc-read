
import com.clou.uhf.G3Lib.ClouInterface.IAsynchronousMessage;
import com.clou.uhf.G3Lib.ClouInterface.ISearchDevice;
import com.clou.uhf.G3Lib.Models.Device_Model;
import com.clou.uhf.G3Lib.Models.GPI_Model;
import com.clou.uhf.G3Lib.Models.Tag_Model;



public class SampleCodeMain implements IAsynchronousMessage,ISearchDevice {

    static String ConnID = "";

    public static final String VERSION_STRING = "2.0";

    public static void main(final String[] args) {
        

        final SampleCodeMain sampleCodeMain = new SampleCodeMain();

        while (true) {

            try {

                final String connTypeReturn = Connect.connect(sampleCodeMain);
                ConnID = connTypeReturn;

                while (ConnID.isEmpty()) {
                    Thread.sleep(3000);
                }

                Tag6C.tag6C(ConnID);

            } catch (final Exception e) {

                return;
            }

        }

    }

    @Override
    public void WriteDebugMsg(final String s) {

    }

    @Override
    public void WriteLog(final String s) {

    }

    @Override
    public void PortConnecting(final String s) {

    }

    @Override
    public void PortClosing(final String s) {

    }

    @Override
    public void OutPutTags(final Tag_Model tag_model) {

        ParseEPC.parseEPC(tag_model._UserData);
        
    }

    @Override
    public void OutPutTagsOver() {

    }

    @Override
    public void GPIControlMsg(final GPI_Model gpi_model) {

    }

    @Override
    public void DeviceInfo(final Device_Model device_model) {

    }

    @Override
    public void DebugMsg(final String s) {

    }
}
