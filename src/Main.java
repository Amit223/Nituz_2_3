import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) {
        //declare off state which start on:
        MachineOnState on=new MachineOnState();
        MachineOffState off=new MachineOffState(on);
        on.setOff(off);
        off.EnterState();

    }

}
