public class BooleanLogicX {
    public static void main(String[] args) {
    
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 != 0 || year % 100 == 0) && year % 400 != 0) {
            return false;
        }

        return true;
    }

    public static boolean isThirteen(int month, int day, int year) {

        final int CRNT_MONTH = 9;
        final int CRNT_DAY = 27;
        final int CRNT_YEAR = 2023;
        final int THIRTEEN = 13;

        if (month <= 0 || month >= 12) {
            System.out.println("Please enter a valid month");
            return false;
        } else if (day <= 0 || day > 31) {
            System.out.println("Please enter a valid day");
            return false;
        } else if (year > CRNT_YEAR) {
            System.out.println("Please enter a valid year");
        } else if (year < 1900) {
            System.out.println("Are you sure you are still alive?");
            return true;
        } else if (CRNT_YEAR < year + THIRTEEN) {
            return false;
        } else if (CRNT_YEAR == year + THIRTEEN && CRNT_MONTH < month) {
            return false;
        } else if (CRNT_YEAR == year + THIRTEEN && CRNT_MONTH == month && CRNT_DAY < day) {
            return false;
        } else {
            return true;
        }
        return false;
    }

    public static void unitTestIsThirteen() {
        // input current month, day, year here
        final int DAY = 27;
        final int MONTH = 9;
        final int YEAR = 2023;
        System.out.println("Do the actual and expected results match?");
        // actual result expected result
        System.out.println("Birthday in next year:");
        System.out.print(">m >d >y: ");
        System.out.println(isThirteen(MONTH + 1, DAY + 1, YEAR - 12) == false);
        System.out.print(" <m >d >y: ");
        System.out.println(isThirteen(MONTH - 1, DAY + 1, YEAR - 12) == false);
        System.out.print(" =m >d >y: ");
        System.out.println(isThirteen(MONTH, DAY + 1, YEAR - 12) == false);

        System.out.print(" >m <d >y: ");
        System.out.println(isThirteen(MONTH + 1, DAY - 1, YEAR - 12) == false);
        System.out.print(" <m <d >y: ");
        System.out.println(isThirteen(MONTH - 1, DAY - 1, YEAR - 12) == false);
        System.out.print(" =m <d >y: ");
        System.out.println(isThirteen(MONTH, DAY - 1, YEAR - 12) == false);

        System.out.print(" >m =d >y: ");
        System.out.println(isThirteen(MONTH + 1, DAY, YEAR - 12) == false);
        System.out.print(" <m =d >y: ");
        System.out.println(isThirteen(MONTH - 1, DAY, YEAR - 12) == false);
        System.out.print(" =m =d >y: ");
        System.out.println(isThirteen(MONTH, DAY, YEAR - 12) == false);

        System.out.println("Birthday in previous year:");
        System.out.print(" >m >d <y: ");
        System.out.println(isThirteen(MONTH + 1, DAY + 1, YEAR - 14) == true);
        System.out.print(" <m >d <y: ");
        System.out.println(isThirteen(MONTH - 1, DAY + 1, YEAR - 14) == true);
        System.out.print(" =m >d <y: ");
        System.out.println(isThirteen(MONTH, DAY + 1, YEAR - 14) == true);

        System.out.print(" >m <d <y: ");
        System.out.println(isThirteen(MONTH + 1, DAY - 1, YEAR - 14) == true);
        System.out.print(" <m <d <y: ");
        System.out.println(isThirteen(MONTH - 1, DAY - 1, YEAR - 14) == true);
        System.out.print(" =m <d <y: ");
        System.out.println(isThirteen(MONTH, DAY - 1, YEAR - 14) == true);

        System.out.print(" >m =d <y: ");
        System.out.println(isThirteen(MONTH + 1, DAY, YEAR - 14) == true);
        System.out.print(" <m =d <y: ");
        System.out.println(isThirteen(MONTH - 1, DAY, YEAR - 14) == true);
        System.out.print(" =m =d <y: ");
        System.out.println(isThirteen(MONTH, DAY, YEAR - 14) == true);

        System.out.println("Birthday in this year:");
        System.out.print(" >m >d <y: ");
        System.out.println(isThirteen(MONTH + 1, DAY + 1, YEAR - 13) == false);
        System.out.print(" <m >d <y: ");
        System.out.println(isThirteen(MONTH - 1, DAY + 1, YEAR - 13) == true);
        System.out.print(" =m >d <y: ");
        System.out.println(isThirteen(MONTH, DAY + 1, YEAR - 13) == false);

        System.out.print(" >m <d <y: ");
        System.out.println(isThirteen(MONTH + 1, DAY - 1, YEAR - 13) == false);
        System.out.print(" <m <d <y: ");
        System.out.println(isThirteen(MONTH - 1, DAY - 1, YEAR - 13) == true);
        System.out.print(" =m <d <y: ");
        System.out.println(isThirteen(MONTH, DAY - 1, YEAR - 13) == true);

        System.out.print(" >m =d <y: ");
        System.out.println(isThirteen(MONTH + 1, DAY, YEAR - 13) == false);
        System.out.print(" <m =d <y: ");
        System.out.println(isThirteen(MONTH - 1, DAY, YEAR - 13) == true);
        System.out.print(" =m =d <y: ");
        System.out.println(isThirteen(MONTH, DAY, YEAR - 13) == true);

    }
}
