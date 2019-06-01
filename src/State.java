import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public interface State {

    Queue<File> checkQueue =new LinkedList<>();
    Queue<File> downloadQueue =new LinkedList<>();
    public void EnterState();
    public void ExitState();

}
