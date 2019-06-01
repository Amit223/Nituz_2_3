import java.io.File;
import java.util.Scanner;

public class MachineOnState extends BigState{
    private State off;//listener
    private RequestState requestState;
    private CheckState checkState;

    public void setOffState(MachineOffState off){
        this.off=off;
    }
    public void setRequestState(RequestState requestState){
        this.requestState=requestState;
    }
    public void setCheckState(CheckState checkState){
        this.checkState=checkState;
    }

    @Override
    public void EnterState() {
        System.out.println("Enter MachineOn state");
        boolean toTurnOff=turnOff();
        Thread req=new Thread(){
            public void run(){
                requestState.EnterState();
            }
        };

        Thread check=new Thread(){
            public void run(){
                checkState.EnterState();
            }
        };
        if(internetOn()&!toTurnOff)
        {
            //start all kind of states: RequestState, todo
            req.start();
            check.start();
        }
        while(internetOn()&&!toTurnOff)//checks that internet is on and user doesn't want to turn off the machine
        {
            toTurnOff=turnOff();
        }
        //turn off everything!- todo
        req.interrupt();//stop req
        check.interrupt();

        //exit
        this.ExitState();
        off.EnterState();

    }

    @Override
    public void ExitState() {
        System.out.println("Enter MachineOn state");

    }

    public boolean turnOff(){
        System.out.println("Press E to turn off, any other key to stay");
        Scanner reader = new Scanner(System.in);
        String strFromUser=reader.next();
        if(strFromUser.equals("E"))
            return true;
        return false;
    }


}
