import java.io.File;
import java.util.Scanner;

public class MachineOnState extends BigState{
    private State off;//listener

    public void setOff(MachineOffState off){
        this.off=off;
    }
    @Override
    public void EnterState() {
        System.out.println("Enter MachineOn state");
        boolean toTurnOff=turnOff();
        if(internetOn()&!toTurnOff)
        {
            //all starters states on OnState
        }
        while(internetOn()&&!toTurnOff)//checks that internet is on and user doesn't want to turn off the machine
        {
            toTurnOff=turnOff();
        }
        //turn off everything!- todo
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
