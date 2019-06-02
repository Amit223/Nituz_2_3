import java.io.File;

public class DownloadFirstFileState extends CheckState {
    private CheckIdleState idle=null;



    public void setStates(CheckIdleState idle) {
        this.idle = idle;

    }

    @Override
    public void EnterState() {
        System.out.println("Enter downloadFirstFile state");
        if(!downloadAborted()){
           startDownload();
        }
        //abort or function done
        onState.setCheckState(idle);
        idle.EnterState();


    }

    @Override
    public void ExitState() {
        System.out.println("Exit downloadFirstFile state");

    }

    public void startDownload(){
        File f=checkQueue.poll();
        downloadQueue.add(f);
        //todo- make the boolean startDownload in abstract DownloadFileState-true (when done, change to false;
    }

}
