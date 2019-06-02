import java.util.Scanner;
import java.util.Timer;

public class ErrorState extends DownloadState {
    private IdleDownload idle=null;
    private DownloadingState downloading=null;

    private DownloadState exitState=null;

    public void setIdle(IdleDownload idle) {
        this.idle = idle;
    }

    public void setDownloading(DownloadingState downloading) {
        this.downloading = downloading;
    }


    @Override
    public void EnterState() {
        System.out.println("Enter Error state");
        if(downloadAborted()){
            exitState=null;
        }
        long startTime = System.currentTimeMillis();
        long estimatedTime =0;
        while(!errorFixed()&&estimatedTime<3000){
            estimatedTime=System.currentTimeMillis() - startTime;
        }
        if(estimatedTime>=3000){//couldn't fix
            deleteFile();
            exitState=idle;
        }
        else{//errorFixed
            //problem fixed
            exitState=downloading;
        }
        ExitState();
    }

    private void deleteFile() {//delete from watch and download
        downloadQueue.poll();
        watchQueue.poll();
    }

    @Override
    public void ExitState() {
        System.out.println("Exit Error state");
        onState.setDownloadState(exitState);
        exitState.EnterState();
    }

    public boolean errorFixed(){
        System.out.println("if you want error to be fixed press FIX, press any other key to continue");
        Scanner reader = new Scanner(System.in);
        String inFromUser=reader.next();
        if(inFromUser.equals("FIX"))
            return true;
        return false;
    }
}
