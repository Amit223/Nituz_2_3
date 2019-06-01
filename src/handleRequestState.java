import java.io.File;
import java.util.Scanner;

public class handleRequestState extends LittleState{
    private State noReq=new noNewfileRequestState();
    private File file;

    public handleRequestState(File file) {
        this.file = file;
    }

    @Override
    public void EnterState() {
        System.out.println("Enter handleRequestState State");
        if(!downloadAborted()) {
            addToCheckQueue(file);
        }
        while(!downloadAborted())
        //download aborted-
        this.ExitState();
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
