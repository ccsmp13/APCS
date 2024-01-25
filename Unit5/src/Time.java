public class Time {
    
    private double totalSeconds;
    private final double SECONDS_IN_DAY = 24 * 60 * 60;
   
    
    public Time() {
        this.totalSeconds = 0;
    }

    public Time(double totalSeconds) {
        this.totalSeconds = totalSeconds;
    }
    
    public Time(int hour, int minute, double second) {
        this.totalSeconds += hour * 60 * 60;
        this.totalSeconds += minute * 60;
        this.totalSeconds += second;
    }

    public void setHour(int hour) {
        if(hour >= 0 && hour <= 12) {
            //TODO update total number of seconds to include new hour with old min and sec
            //getMin and getSec will be useful
        this.hour = hour;

        } else {
            throw new IllegalArgumentException("Idoit: ");
        }
    }

    public void setMinute(int minute) {
        if(minute >= 0 && minute <= 60) {

        this.minute = minute;
        
        } else {
            throw new IllegalArgumentException("Idoit: ");
        }
    }

    public void setSecond(double second) {
        if(second >= 0 && second <= 60) {

            this.second = second;
            
            } else {
                throw new IllegalArgumentException("Idoit: ");
            }
    }
    
    public int getHour() {
        //TODO whole num hour
        return -1;
    }

    public int getMinute() {
        //TODO whole num min
        return -1;
    }

    public double getSecond() {
        //TODO whole num sec
        return -1;
    }
    public String toString() {
        return String.format("%02d:%02d:%04.1f\n",
        this.hour, this.minute, this.second);
        }
        

    public boolean equals(Time that){
        final double DELTA = .001;
        return Math.abs(this.totalSeconds - that.totalSeconds) < DELTA;
    }
    public Time add(Time other){
        double sum = (this.totalSeconds + other.totalSeconds) % SECONDS_IN_DAY;
        return new Time(sum);
    }
    public Time subtract(Time other){
        return null;
    }
}
