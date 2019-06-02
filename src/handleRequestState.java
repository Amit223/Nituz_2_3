import java.io.File;

public class handleRequestState extends RequestState {
    private RequestState noReq;
    private File file=null;

    public void setNoReq(RequestState noReq){
        this.noReq=noReq;
    }
    public void setFile(File f){
        this.file=f;
    }
    @Override
    public void EnterState() {
        System.out.println("Enter handleRequestState State");
        if(!downloadAborted()) {
            addToCheckQueue(file);
        }
        //download aborted or end function
        this.ExitState();
        onState.setRequestState(noReq);
        noReq.EnterState();


    }

    @Override
    public void ExitState() {
        System.out.println("Exit handleRequestState State");
    }


    private void addToCheckQueue(File f){
        checkQueue.add(f);
    }
}
