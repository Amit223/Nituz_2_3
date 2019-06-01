import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public abstract class LittleState implements State{
    protected MachineOnState onState=null;
    protected void setOnState(MachineOnState on){
        onState=on;
    }

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
    private boolean checkConnection(){
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }
    protected boolean internetOn() {
        return checkConnection();
    }


    protected boolean internetOff() {
        return !checkConnection();
    }

}
