package clock;

import java.util.*;
import java.io.*;

public class Clock {
    private int hours;
    private int minutes;
    private int seconds;
    private boolean toggleDefault;
    private String time;



  public void setClock(int hours, int minutes, int seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;

  }

  public Clock(int hours, int minutes, int seconds) {
    setClock(hours, minutes, seconds);
  }
    
  public void set() throws IOException {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      
      int hour = 0;
      int minute = 0;
      int second = 0;
      
      String hours1 = "";
      String minutes1 = "";
      String seconds1 = "";
      
      System.out.println("Please enter the hour of the day: ");
       while (true) {
        hours1= br.readLine();
        hour = Integer.parseInt(hours1);
        hours = hour;

        if(hours > 23) {
            System.out.println("Error: Number too big. Please try again!");
            continue;

        }
        break;
      }

      System.out.println("Please enter the minutes:");
       while (true) {
        minutes1 = br.readLine();
        minute = Integer.parseInt(minutes1);
        minutes = minute;

        if(minutes > 59) {
            System.out.println("Error: Number too big. Please try again!");
            continue;
        }
        break;
      }


      System.out.println("Please enter the seconds:");
       while (true) {
        seconds1 = br.readLine();
        second = Integer.parseInt(seconds1);
        seconds = second;

        if(seconds > 59) {
            System.out.println("Error: Number too big. Please try again!");
            continue;
        }
        break;
       }
  }
  
  public void calibrate() {
    Calendar now = Calendar.getInstance();
    hours = now.get(Calendar.HOUR_OF_DAY);
    minutes = now.get(Calendar.MINUTE);
    seconds = now.get(Calendar.SECOND);
    }
  public void reset() {
    hours = 00;
    minutes = 00;
    seconds = 00;
    }
  
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

  public void advance() {
    // Increases time by one second
    seconds++;
    if (seconds > 59){
        seconds = 0;
        minutes++;
        if (minutes > 59) {
            minutes = 0;
            hours++;
            if (hours > 23) {
                hours = 0;
                
            }
        }
    }
 }

  public void advance(boolean realTime){
    this.advance();
        if(realTime)
            this.delay();
  }

  private void delay(){
    long now = System.currentTimeMillis();
    while(System.currentTimeMillis() - now<1000);
  }
  
  public void toggleClockMode() {
    toggleDefault = !toggleDefault;   
  }

  
  public String toggle(){
      int toggleHours = hours;
      String ToD = "am";
      
      if(!toggleDefault && toggleHours > 12){
          hours = hours - 12;
          time = toggleHours + ":" + minutes + seconds;
          
      }
      if(hours >= 12 && !toggleDefault){
          ToD = "PM";
      }
        else if(hours < 12 && !toggleDefault){
            ToD = "AM";
        }
      return time + ToD;
  }


  @Override
  public String toString(){
      String s = String.valueOf(hours).concat(":"). concat
              (String.valueOf(minutes)).concat(":").concat
              (String.valueOf(seconds));
              return s;
  }
}


 