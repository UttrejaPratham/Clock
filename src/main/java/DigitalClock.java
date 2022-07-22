import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DigitalClock extends JDialog {
    int runtime = 0;

    private JPanel contentPane;
    private JLabel Clock;
    private JLabel Date;

    public DigitalClock() {


        setLocationRelativeTo(null);

        setUndecorated(true);
        setContentPane(contentPane);
        setModal(true);

        new Thread() {
            public void run() {
                while (runtime == 0) {
                    Calendar calendar = new GregorianCalendar();
                    int hour = calendar.get(Calendar.HOUR);
                    int minute = calendar.get(Calendar.MINUTE);
                    int second = calendar.get(Calendar.SECOND);
                    int am_pm = calendar.get(Calendar.AM_PM);
                    int date = calendar.get(Calendar.DATE);
                    int day = calendar.get(Calendar.DAY_OF_WEEK);
                    int month = calendar.get(Calendar.MONTH);

                    String period = new String();
                    if (am_pm == 1) {
                        period = "PM";
                    } else {
                        period = "AM";
                    }
                    String showMonth = new String();
                    switch (month){
                            case 0 :
                            showMonth = "January";
                            break;
                            case 1 :
                            showMonth = "February";
                            break;
                            case 2 :
                            showMonth = "March";
                            break;
                            case 3 :
                            showMonth = "April";
                            break;
                            case 4 :
                            showMonth = "May";
                            break;
                            case 5 :
                            showMonth = "June";
                            break;
                            case 6 :
                            showMonth = "July";
                            break;
                            case 7 :
                            showMonth = "August";
                            break;
                            case 8 :
                            showMonth = "September";
                            break;
                            case 9 :
                            showMonth = "October";
                            break;
                            case 10 :
                            showMonth = "November";
                            break;
                            case 11 :
                            showMonth = "December";
                            break;
                    }
                    String showDay = new String();
                    if(day == 1){
                        showDay = "Sunday";
                    }if(day == 2){
                        showDay = "Monday";
                    }if(day == 3){
                        showDay = "Tuesday";
                    }if(day == 4){
                        showDay = "Wednesday";
                    }if(day == 5){
                        showDay = "Thursday" ;
                    }if(day == 6){
                        showDay = "Friday";
                    }if(day == 7){
                        showDay = "Saturday";
                    }

                    String time = hour + ":" + minute + ":" + second + " " + period;
                    String showDM = showDay + " " + " " + showMonth + " " + date;

                    Clock.setText(time);
                    Date.setText(showDM);
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        DigitalClock dialog = new DigitalClock();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
