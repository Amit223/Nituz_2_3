import java.util.Scanner;

public class DownloadingState extends DownloadState{
    private IdleDownload idle=null;
    private ErrorState error=null;
    private WaitForInternetState wait=null;
    private FinishSuccessfulState finish=null;

    private DownloadState exitstate=null;

    public void setIdle(IdleDownload idle) {
        this.idle = idle;
    }

    public void setError(ErrorState error) {
        this.error = error;
    }

    public void setWait(WaitForInternetState wait) {
        this.wait = wait;
    }

    public void setFinish(FinishSuccessfulState finish) {
        this.finish = finish;
    }

    @Override
    public void EnterState() {
        System.out.println("Enter Downloading state");
        if(downloadAborted())//wont download
            exitstate=idle;
        else if(internetOff())
            exitstate=wait;
        else if(downloadError()) {//need to enter to error and decrease points
            exitstate = error;
            decreasePoints();
        }
        else{//download file
            File f=downloadQueue.poll();
            f.setDownloadstatus(1);//finish download
            exitstate=finish;
        }
        ExitState();


    }

    private void decreasePoints() {
        if(user.getPoints()>0)
            user.deccreasePoints();
    }

    @Override
    public void ExitState() {
        System.out.println("Exit Downloading state");
        onState.setDownloadState(exitstate);
        exitstate.EnterState();
    }

    private boolean downloadError(){
        System.out.println("if you want error to happen to download press OK, press any other key to continue");
        Scanner reader = new Scanner(System.in);
        String inFromUser=reader.next();
        if(inFromUser.equals("OK"))
            return true;
        return false;
    }
}
