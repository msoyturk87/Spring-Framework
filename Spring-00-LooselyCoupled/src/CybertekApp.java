import service.FullTimeMentor;
import service.MentorAccount;

public class CybertekApp {
    public static void main(String[] args) {
        FullTimeMentor fullTime=new FullTimeMentor();
        MentorAccount mentor=new MentorAccount(fullTime);   // Poly way
        mentor.manageAccount();
    }
}
