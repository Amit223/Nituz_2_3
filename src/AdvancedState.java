public class AdvancedState extends UserState {
    BeginnerState beginner;
    ProfessionalState professional;
    UserState exitState=null;

    public void setPrev(BeginnerState beginner) {
        this.beginner = beginner;
    }

    public void setNext(ProfessionalState professional) {
        this.professional = professional;
    }

    @Override
    public void EnterState() {
        System.out.println("Enter Advanced State");
        user.setSpeed(1.2);
        while(user.getPoints()>=4&&user.getPoints()<7);
        //or begginer of pro
        if(user.getPoints()<4)
            exitState=beginner;
        else//user.getPoints>=
            exitState=professional;

        ExitState();
    }

    @Override
    public void ExitState() {
        System.out.println("Exit Advanced State");
        onState.setUserState(exitState);
        exitState.EnterState();
    }
}
