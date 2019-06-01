import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) {
        //declare off state which start on:
        State off=new MachineOffState();
        off.EnterState();

    }

}
