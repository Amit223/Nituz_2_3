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


        //declare download states
        IdleDownload idle_download=new IdleDownload();
        DownloadingState downloading=new DownloadingState();
        ErrorState error=new ErrorState();
        WaitForInternetState wait=new WaitForInternetState();
        FinishSuccessfulState finish=new FinishSuccessfulState();
        //connect
        idle_download.setDownloading(downloading);
        downloading.setError(error);
        downloading.setFinish(finish);
        downloading.setIdle(idle_download);
        downloading.setWait(wait);
        error.setDownloading(downloading);
        error.setIdle(idle_download);
        wait.setDownloading(downloading);
        wait.setIdle(idle_download);
        finish.setIdle(idle_download);
        //connect to on
        idle_download.setOnState(on);
        downloading.setOnState(on);
        error.setOnState(on);
        wait.setOnState(on);
        finish.setOnState(on);


        //declare user states
        BeginnerState beginner=new BeginnerState();
        AdvancedState advanced=new AdvancedState();
        ProfessionalState professional=new ProfessionalState();
        //connect
        beginner.setNext(advanced);
        advanced.setPrev(beginner);
        advanced.setNext(professional);
        professional.setPrev(advanced);
        //connect to on
        beginner.setOnState(on);
        advanced.setOnState(on);
        professional.setOnState(on);



        //set on states
        on.setOffState(off);
        on.setRequestState(noReq);
        on.setCheckState(idle_check);
        on.setUserState(beginner);
        on.setDownloadState(idle_download);

        //start
        Thread t=new Thread(){
            public void run(){
                off.EnterState();
            }
        };
        t.start();

    }

}
