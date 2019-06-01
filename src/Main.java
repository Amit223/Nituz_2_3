import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) {
        //declare big states
        MachineOnState on=new MachineOnState();
        MachineOffState off=new MachineOffState(on);

        //declare request states
        handleRequestState handle=new handleRequestState();
        noNewfileRequestState noReq=new noNewfileRequestState();
        noReq.setHandle(handle);
        handle.setNoReq(noReq);
        noReq.setOnState(on);
        handle.setOnState(on);

        //set on states
        on.setOffState(off);
        on.setRequestState(noReq);

        //start
        off.EnterState();

    }

}
