import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class MachineOffState extends BigState {
    State on;//listener

    public MachineOffState(State on) {
        this.on = on;
    }
    @Override
    public void EnterState() {
        System.out.println("Enter MachineOff state");
        idleIntenetCheck();//to check if there is internet. if there is, wait for
    }

    @Override
    public void ExitState() {
        System.out.println("Exit MachineOff state");

    }



    private void idleIntenetCheck(){
        while(internetOff());
        //internet on so can wait for requests to turn on the machine
        turnOn();//try to
    }
    private void turnOn(){
        System.out.println("There is intenet connection. Press O to turn on the machine");
        Scanner reader = new Scanner(System.in);
        String strFromUser=reader.next();
        while(!strFromUser.equals("O")&&!internetOff())//need to check the internet is still on or the request isn't relevant
        {
            strFromUser=reader.next();
        }
        if(!internetOff()) {//there is internet and user wants to exit
            this.ExitState();
            Thread t=new Thread(){
                public void run(){
                    on.EnterState();
                }
            };
            t.start();
        }
        else{
            System.out.println("no intenet connection. Please check and try again");
            idleIntenetCheck();
        }
    }


}
