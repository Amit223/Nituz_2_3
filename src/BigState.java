import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public abstract class BigState implements State{

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
