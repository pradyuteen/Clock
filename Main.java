package clock;
/**
 *
 * @author Pradyumna
 */
import java.io.*;

public class Main {

        public static void main(String[] args) throws IOException {

            System.out.println("Welcome to the clock testing program.");
            System.out.println("");
            System.out.println("Commands:");
            System.out.println("-----------");
            System.out.println("a = advance (increase time by one second)");
            System.out.println("c = calibrate (set to current time)");
            System.out.println("q = quit");
            System.out.println("r = reset (set hours, minutes, and second to zero)");
            System.out.println("s = set (allow user to set time)");
            System.out.println("t = toggle (switch from 24-hour clock to 12-hour clock, or vice-versa)");
            System.out.println("");
            System.out.println("The time is now 00:00:00");

            Clock time = new Clock(0, 0, 0);

            while (true){
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                System.out.println("Enter command (a, c, q, r, s, or t):");
                String userInput = br.readLine();
                char inpuT = new Character(userInput.charAt(0));
                
                if (inpuT == 'a'){
                    time.advance();
                    System.out.println("The time is now " + time);
                }
                else if(inpuT == 'c'){
                    time.calibrate();
                    System.out.println("The time is now " + time);
                }
                else if(inpuT == 'q'){
                    break;
                }
                else if(inpuT == 'r'){
                    time.reset();
                    System.out.println("The time is now " + time);
                }
                else if(inpuT == 's'){
                    time.set();
                    System.out.println("The time is now " + time);
                }
                else if(inpuT == 't' ){
                    time.toggle();
                    System.out.println("The time is now " + time);
                }
                else if(inpuT != 'a' || inpuT != 'c' || inpuT != 'q' || inpuT != 'r' || inpuT != 's' || inpuT != 't'){
                    System.out.println("Illegal command. Please try again!");
                }
            }

        }
}
