public class BeginnerState extends UserState {
    AdvancedState advanced;

    public void setNext(AdvancedState advanced) {
        this.advanced = advanced;
    }

    @Override
    public void EnterState() {
        System.out.println("Enter Beginner State");
        user.setSpeed(1);
        while(user.getPoints()<4);
        //points>=4:
        ExitState();
    }

    @Override
    public void ExitState() {
        System.out.println("Exit Beginner State");
        onState.setUserState(advanced);
        Thread t=new Thread(){
            public void run(){
                advanced.EnterState();
            }
        };
        t.start();

    }
}
