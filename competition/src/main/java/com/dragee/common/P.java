package com.dragee.common;

/** 着色打印
 * @author tys on 11/3/20
 */
public class P {

    public static void green (String context) {
        System.out.println(Colors.GREEN_BOLD + context);
        System.out.print(Colors.RESET);
    }
    public static void white (String context) {
        System.out.println(Colors.WHITE_BOLD + context);
        System.out.print(Colors.RESET);
    }
    public static void blue (String context) {
        System.out.println(Colors.BLUE_BOLD + context);
        System.out.print(Colors.RESET);
    }
    public static void yellow (String context) {
        System.out.println(Colors.YELLOW_BOLD + context);
        System.out.print(Colors.RESET);
    }
    public static void purple (String context) {
        System.out.println(Colors.PURPLE_BOLD + context);
        System.out.print(Colors.RESET);
    }
    public static void cyan (String context) {
        System.out.println(Colors.CYAN_BOLD + context);
        System.out.print(Colors.RESET);
    }
    public static void red (String context) {
        System.out.println(Colors.RED_BOLD + context);
        System.out.print(Colors.RESET);
    }

    public interface Colors {
        // Reset
        String RESET = "\33[0m";  // Text Reset

        // Regular Colors
        String BLACK = "\33[0;30m";   // BLACK
        String RED = "\33[0;31m";     // RED
        String GREEN = "\33[0;32m";   // GREEN
        String YELLOW = "\33[0;33m";  // YELLOW
        String BLUE = "\33[0;34m";    // BLUE
        String PURPLE = "\33[0;35m";  // PURPLE
        String CYAN = "\33[0;36m";    // CYAN
        String WHITE = "\33[0;37m";   // WHITE

        // Bold
        String BLACK_BOLD = "\33[1;30m";  // BLACK
        String RED_BOLD = "\33[1;31m";    // RED
        String GREEN_BOLD = "\33[1;32m";  // GREEN
        String YELLOW_BOLD = "\33[1;33m"; // YELLO
        String BLUE_BOLD = "\33[1;34m";   // BLUE
        String PURPLE_BOLD = "\33[1;35m"; // PURPL
        String CYAN_BOLD = "\33[1;36m";   // CYAN
        String WHITE_BOLD = "\33[1;37m";  // WHITE

        // Underline
        String BLACK_UNDERLINED = "\33[4;30m";  // BLACK
        String RED_UNDERLINED = "\33[4;31m";    // RED
        String GREEN_UNDERLINED = "\33[4;32m";  // GREEN
        String YELLOW_UNDERLINED = "\33[4;33m"; // YELLOW
        String BLUE_UNDERLINED = "\33[4;34m";   // BLUE
        String PURPLE_UNDERLINED = "\33[4;35m"; // PURPLE
        String CYAN_UNDERLINED = "\33[4;36m";   // CYAN
        String WHITE_UNDERLINED = "\33[4;37m";  // WHITE

        // Background
        String BLACK_BACKGROUND = "\33[40m";  // BLACK
        String RED_BACKGROUND = "\33[41m";    // RED
        String GREEN_BACKGROUND = "\33[42m";  // GREEN
        String YELLOW_BACKGROUND = "\33[43m"; // YELLOW
        String BLUE_BACKGROUND = "\33[44m";   // BLUE
        String PURPLE_BACKGROUND = "\33[45m"; // PURPLE
        String CYAN_BACKGROUND = "\33[46m";   // CYAN
        String WHITE_BACKGROUND = "\33[47m";  // WHITE

        // High Intensity
        String BLACK_BRIGHT = "\33[0;90m";  // BLACK
        String RED_BRIGHT = "\33[0;91m";    // RED
        String GREEN_BRIGHT = "\33[0;92m";  // GREEN
        String YELLOW_BRIGHT = "\33[0;93m"; // YELLOW
        String BLUE_BRIGHT = "\33[0;94m";   // BLUE
        String PURPLE_BRIGHT = "\33[0;95m"; // PURPLE
        String CYAN_BRIGHT = "\33[0;96m";   // CYAN
        String WHITE_BRIGHT = "\33[0;97m";  // WHITE

        // Bold High Intensity
        String BLACK_BOLD_BRIGHT = "\33[1;90m"; // BLACK
        String RED_BOLD_BRIGHT = "\33[1;91m";   // RED
        String GREEN_BOLD_BRIGHT = "\33[1;92m"; // GREEN
        String YELLOW_BOLD_BRIGHT = "\33[1;93m";// YELLOW
        String BLUE_BOLD_BRIGHT = "\33[1;94m";  // BLUE
        String PURPLE_BOLD_BRIGHT = "\33[1;95m";// PURPLE
        String CYAN_BOLD_BRIGHT = "\33[1;96m";  // CYAN
        String WHITE_BOLD_BRIGHT = "\33[1;97m"; // WHITE

        // High Intensity backgrounds
        String BLACK_BACKGROUND_BRIGHT = "\33[0;100m";// BLACK
        String RED_BACKGROUND_BRIGHT = "\33[0;101m";// RED
        String GREEN_BACKGROUND_BRIGHT = "\33[0;102m";// GREEN
        String YELLOW_BACKGROUND_BRIGHT = "\33[0;103m";// YELLOW
        String BLUE_BACKGROUND_BRIGHT = "\33[0;104m";// BLUE
        String PURPLE_BACKGROUND_BRIGHT = "\33[0;105m"; // PURPLE
        String CYAN_BACKGROUND_BRIGHT = "\33[0;106m";  // CYAN
        String WHITE_BACKGROUND_BRIGHT = "\33[0;107m";   // WHITE


    }



    public static void main(String[] args) {
        double a = 10;
        double b = 10.0;
        boolean result = a == b;
        System.out.println(result);
        P.green("嘻嘻");
        P.blue("嘻嘻");
        P.red("嘻嘻");
        P.purple("嘻嘻");
        P.white("嘻嘻");
        P.yellow("嘻嘻");
        P.cyan("嘻嘻");
    }


}
