import implementation.Mentor;
import service.FullTimeMentor;
import service.MentorAccount;
import service.PartTimeMentor;

public class CybertekApp {
    public static void main(String[] args) {

        FullTimeMentor fullTime=new FullTimeMentor();
        MentorAccount mentor=new MentorAccount(fullTime);   // Poly way
        mentor.manageAccount();

        PartTimeMentor partTime=new PartTimeMentor();
        MentorAccount mentor1=new MentorAccount(partTime);
        mentor1.manageAccount();

    }
}
