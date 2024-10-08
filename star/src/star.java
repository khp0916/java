public class star1 {
    public static void star1() {
        for (int i=1;i<=5;i++) {
            for (int j=0;j<i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void star2() {
        for (int i=1;i<6;i++) {
            for (int j=5;j>i;j--) {
                System.out.print(" ");
            }
            for (int j=0;j<i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void star3() {
        for (int i=6;i>0;i--) {
            for (int j=1;j<i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void star4() {
        for (int i=0;i<5;i++) {
            for (int j=0;j<i;j++) {
                System.out.print(" ");
            }
            for (int j=5;j>i;j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void star5() {
        for (int i=1;i<=5;i++) {
            for (int j=0;j<i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i=5;i>0;i--) {
            for (int j=1;j<i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void star6() {
        for (int i=1;i<6;i++) {
            for (int j=5;j>i;j--) {
                System.out.print(" ");
            }
            for (int j=0;j<i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i=1;i<5;i++) {
            for (int j=0;j<i;j++) {
                System.out.print(" ");
            }
            for (int j=5;j>i;j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void star7() {
        for (int i=6;i>1;i--) {
            for (int j=1;j<i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i=2;i<=5;i++) {
            for (int j=0;j<i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void star8() {
        for (int i=0;i<5;i++) {
            for (int j=0;j<i;j++) {
                System.out.print(" ");
            }
            for (int j=5;j>i;j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i=1;i<6;i++) {
            for (int j=5;j>i;j--) {
                System.out.print(" ");
            }
            for (int j=0;j<i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        star8();
    }
}
