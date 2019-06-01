public class ProfessionalState extends UserState {
    AdvancedState advanced=null;
    public void setPrev(AdvancedState advanced) {
        this.advanced = advanced;
    }


    @Override
    public void EnterState() {
        System.out.println("Enter Professional State");
        user.setSpeed(1.5);
        while(user.getPoints()>=7);
        //points<7
        ExitState();
    }

    @Override
    public void ExitState() {
        System.out.println("Exit Professional State");
        onState.setUserState(advanced);
        Thread t=new Thread(){
            public void run(){
                advanced.EnterState();
            }
        };
        t.start();
    }
}
