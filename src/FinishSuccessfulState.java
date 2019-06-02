public class FinishSuccessfulState extends DownloadState {
    IdleDownload idle=null;

    public void setIdle(IdleDownload idle) {
        this.idle = idle;
    }

    @Override
    public void EnterState() {
        System.out.println("Enter FinishSuccessful state");
        user.increasePoints();
        ExitState();
    }

    @Override
    public void ExitState() {
        System.out.println("Exit FinishSuccessful state");
        onState.setDownloadState(idle);
        idle.EnterState();
    }
}
