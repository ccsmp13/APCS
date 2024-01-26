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
        double tempSum = getSecond() + getMinute() * 60;
        if (hour >= 0 && hour <= 12) {

            this.totalSeconds = hour * 60 * 60 + tempSum;

        } else {
            throw new IllegalArgumentException("Idoit: ");
        }
    }

    public void setMinute(int minute) {
        double tempSum = getSecond() + getHour() * 60 * 60;
        if (minute >= 0 && minute <= 60) {
            this.totalSeconds = minute * 60 + tempSum;

        } else {
            throw new IllegalArgumentException("Idoit: ");
        }
    }

    public void setSecond(double second) {
        double tempSum = getMinute() * 60 + getHour() * 60 * 60;
        if (second >= 0 && second <= 60) {

            this.totalSeconds = second + tempSum;

        } else {
            throw new IllegalArgumentException("Idoit: ");
        }
    }

    public int getHour() {

        return (int) (totalSeconds / (60 * 60));
    }

    public int getMinute() {

        return (int) (totalSeconds % (60 * 60)) / 60;
    }

    public double getSecond() {

        return (int) (totalSeconds % (60 * 60)) % 60;
    }

    public String toString() {
        return String.format("%02d:%02d:%04.1f\n",
                getHour(), getMinute(), getSecond());
    }

    public boolean equals(Time that) {
        final double DELTA = .001;
        return Math.abs(this.totalSeconds - that.totalSeconds) < DELTA;
    }

    public Time add(Time other) {
        double sum = (this.totalSeconds + other.totalSeconds) % SECONDS_IN_DAY;
        return new Time(sum);
    }
    
    public Time subtract(Time other) {
        double difference = this.totalSeconds - other.totalSeconds;
        return new Time(difference);
    }
}
