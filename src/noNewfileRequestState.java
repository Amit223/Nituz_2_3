import java.io.File;
import java.util.Scanner;

public class noNewfileRequestState extends RequestState {
    private handleRequestState handle;

    public void setHandle(handleRequestState handle){
        this.handle=handle;
    }

    @Override
    public void EnterState() {
        System.out.println("Enter noNewfileRequest State");
        File f=fileRequest();
        while(f==null)//no file req
        {
            f=fileRequest();
        }
        //got file request:
        handle.setFile(f);
        this.ExitState();
        onState.setRequestState(handle);
        Thread t=new Thread(){
            public void run(){
                handle.EnterState();
            }
        };
        t.start();
    }

    @Override
    public void ExitState() {
        System.out.println("Exit noNewfileRequest State");

    }

    //todo :is this ok?
    private File fileRequest(){
        Scanner reader = new Scanner(System.in);
        String path=reader.next();
        File f=new File(path);//assume path is ok
        return f;
    }
}
