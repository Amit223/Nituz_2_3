public class IdleDownload extends DownloadState {
    private DownloadingState downloading=null;

    public void setDownloading(DownloadingState downloading) {
        this.downloading = downloading;
    }

    @Override
    public void EnterState() {
        System.out.println("Enter IdleDownload state");
        while (downloadQueue.size()==0);//no file got checked
        while(!internetOn()||disk.AvailablePlace()==0);
        ExitState();
    }

    @Override
    public void ExitState() {
        System.out.println("Exit IdleDownload state");
        onState.setDownloadState(downloading);
        downloading.EnterState();
    }
}
