public class ReCheckDisk extends CheckState {
    private CheckIdleState idle=null;
    private DownloadFirstFileState download=null;

    private CheckState toExit=null;


    public void setStates(CheckIdleState idle, DownloadFirstFileState download) {
        this.idle = idle;
        this.download = download;

    }
    @Override
    public void EnterState() {
        System.out.println("Enter ReCheckDisk state");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(!downloadAborted()&&(!internetOn()||disk.AvailablePlace()==0)&&disk.AvailablePlace()!=0);//only 1 round
        if(downloadAborted()||disk.AvailablePlace()==0){
            toExit=idle;
            deleteFile();
        }
        else{
            toExit=download;
        }

        ExitState();

    }

    @Override
    public void ExitState() {
        System.out.println("Exit ReCheckDisk state");
        onState.setCheckState(toExit);
        Thread t=new Thread(){
            public void run(){
                toExit.EnterState();
            }
        };
        t.start();

    }


    private void deleteFile(){
        checkQueue.poll();//deleted
    }
}
