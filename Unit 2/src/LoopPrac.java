public class LoopPrac {
    public static void main(String[] args) {
        // drawBox(20, 20);
        // charTest(5000);
        for (char c1 = '0'; c1 <= '9'; c1++) {
            for (char c2 = '0'; c2 <= '9'; c2++) {
                for (char c3 = '0'; c3 <= '9'; c3++) {
                    for (char c4 = '0'; c4 <= '9'; c4++) {
                        for (char c5 = '0'; c5 <= '9'; c5++) {
                            for (char c6 = '0'; c6 <= '9'; c6++) {
                                System.out.println("" + c1 + c2 + c3 + c4 + c5 + c6);
                            }
                        }
                    }
                }
            }

        }
    }

    public static void drawBox(int width, int height) {
        for (int j = 1; j <= height; j++) {
            for (int k = 1; k <= width; k++) {
                if (k == 1 || k == width || j == 1 || j == height) {
                    System.out.print("x");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void charTest(int startChar) {
        final int TABLE_SIZE = 20;
        System.out.println("Index   Character");
        for (int k = startChar; k < startChar + TABLE_SIZE; k++) {
            char c = (char) k;
            System.out.println("   " + k + "      " + c);
        }

    }

}
