public class WaitForInternetState extends DownloadState {
    private DownloadingState downloading=null;
    private IdleDownload idle=null;

    private DownloadState exitState;

    public void setIdle(IdleDownload idle) {
        this.idle = idle;
    }

    public void setDownloading(DownloadingState downloading) {
        this.downloading = downloading;
    }

    @Override
    public void EnterState() {
        System.out.println("Enter WaitForInternet state");
        while(!downloadAborted()&&!internetOn());//wait for 1 command
        if(downloadAborted())
            exitState=idle;
        else//internet on
            exitState=downloading;
        ExitState();
    }

    @Override
    public void ExitState() {
        System.out.println("Exit WaitForInternet state");
        onState.setDownloadState(exitState);
        exitState.EnterState();
    }
}
