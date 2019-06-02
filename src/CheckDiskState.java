public class CheckDiskState extends CheckState {
    private CheckIdleState idle=null;
    private ReCheckDisk reCheck=null;
    private DownloadFirstFileState download=null;

    private CheckState toExit=null;

    public void setStates(CheckIdleState idle, ReCheckDisk reCheck, DownloadFirstFileState download) {
        this.idle = idle;
        this.reCheck = reCheck;
        this.download = download;

    }

    @Override
    public void EnterState() {
        System.out.println("Enter CheckDisk state");
        while(!downloadAborted()&&(!internetOn()||disk.AvailablePlace()==0)&&disk.AvailablePlace()!=0);//only 1 round
        if(downloadAborted()){
            toExit=idle;
        }
        else{
            if(disk.AvailablePlace()==0){//no space
                toExit=reCheck;
            }
            else if(internetOn())
            {
                toExit=download;
            }
        }

        ExitState();


    }

    @Override
    public void ExitState() {
        System.out.println("Exit CheckDisk state");
        onState.setCheckState(toExit);
        toExit.EnterState();


    }
}
