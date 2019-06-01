import java.util.Scanner;

public abstract class LittleState implements State{
    protected MachineOnState onState=null;
    protected void setOnState(MachineOnState on){
        onState=on;
    }

    //todo : is true?
    protected boolean downloadAborted(){
        System.out.println("press E to exit and abort download, S to stay and keep download and then enter");
        Scanner reader = new Scanner(System.in);
        String reqFromUser=reader.next();
        while(!reqFromUser.equals("E")||!reqFromUser.equals("S")){
            reqFromUser=reader.next();
        }
        if(reqFromUser.equals("E"))
            return true;
        return false;//stay
    }
}
