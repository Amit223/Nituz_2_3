public class Disk {
    private static Disk ourInstance = new Disk(100);
    private int diskspace;

    public static Disk getInstance() {
        return ourInstance;
    }

    private Disk(int diskspace) {
        this.diskspace=diskspace;
    }

    public int AvailablePlace() {
        return diskspace;
    }

    public void takeDiskspace(int takenSpace) {
        if(diskspace>takenSpace)
            diskspace-=takenSpace;
    }
}
