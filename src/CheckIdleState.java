public class CheckIdleState extends CheckState {
    private CheckDiskState check=null;

    public void setStates(CheckDiskState check) {
        this.check = check;
    }

    @Override
    public void EnterState() {
        System.out.println("Enter CheckIdle state");
        while(checkQueue.size()==0);
        //entered one file!
        this.ExitState();
        onState.setCheckState(check);
        Thread t=new Thread(){
            public void run(){
                check.EnterState();
            }
        };
        t.start();

    }

    @Override
    public void ExitState() {
        System.out.println("Exit CheckIdle state");

    }
}
