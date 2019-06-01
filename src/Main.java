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
        //connect
        noReq.setHandle(handle);
        handle.setNoReq(noReq);
        //connect to on
        noReq.setOnState(on);
        handle.setOnState(on);

        //declare check states
        CheckIdleState idle_check=new CheckIdleState();
        CheckDiskState check=new CheckDiskState();
        ReCheckDisk reCheck=new ReCheckDisk();
        DownloadFirstFileState download=new DownloadFirstFileState();
        //connect
        idle_check.setStates(check);
        check.setStates(idle_check,reCheck,download);
        reCheck.setStates(idle_check,download);
        download.setStates(idle_check);
        //connect to on
        idle_check.setOnState(on);
        check.setOnState(on);
        reCheck.setOnState(on);
        download.setOnState(on);

        //set on states
        on.setOffState(off);
        on.setRequestState(noReq);
        on.setCheckState(idle_check);

        //start
        off.EnterState();

    }

}
