public class File {
    String path;
    double downloadstatus;
    public File(String path) {
        this.path=path;
        downloadstatus=0;
    }

    public double getDownloadstatus() {
        return downloadstatus;
    }

    public void setDownloadstatus(double adder) {//part downloaded
        this.downloadstatus += adder;
    }
}
