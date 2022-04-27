package numbers;

import java.util.*;

public class Main {
    final static String[] propertiesArray = new String[]{"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY",
            "SQUARE", "SUNNY", "JUMPING", "HAPPY", "SAD", "EVEN", "ODD"};

    static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    static boolean isNotNatural(long number) {
        return number <= 0;
    }

    static boolean isEven(long number) {
        return number % 2 == 0;
    }

    static boolean isBuzz(long number) {
        return (number % 7 == 0 || number % 10 == 7);
    }

    static boolean isDuck(long number) {
        String stringNumber = String.valueOf(number);
        return (stringNumber.contains("0") && stringNumber.lastIndexOf("0") > 0);
    }

    static boolean isPalindromic(long number) {
        String stringNumber = String.valueOf(number);
        int left = 0;
        int right = stringNumber.length() - 1;
        while (left <= right / 2) {
            if (stringNumber.charAt(left) != stringNumber.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean isGapful(long number) {
        String stringNumber = String.valueOf(number);
        if (stringNumber.length() < 3) {
            return false;
            }
        long divisor = Long.parseLong(stringNumber.charAt(0) + "" + stringNumber.charAt(stringNumber.length() - 1));
        return number % divisor == 0;
    }

    static boolean isSpy(long number) {
        String stringNumber = String.valueOf(number);
        long sum = 0;
        long product = 1;
        for (int i = 0; i < stringNumber.length(); i++) {
            long longFromChar = Long.parseLong(String.valueOf(stringNumber.charAt(i)));
            sum += longFromChar;
            product *= longFromChar;
        }
        return sum == product;
    }

    static boolean isSquare(long number) {
        long root = (long) Math.sqrt(number);
        return root * root == number;
    }

    static boolean isSunny(long number) {
        return isSquare(number + 1);
    }

    static boolean isJumping(long number) {
        char[] numberArray = String.valueOf(number).toCharArray();
        for (int i = 0; i < numberArray.length - 1; i++) {
            if (Math.abs(numberArray[i] - numberArray[i + 1]) != 1) {
                return false;
            }
        }
        return true;
    }

    static boolean isHappy(long number) {
        ArrayList<Long> seen = new ArrayList<>();
        char[] numberArray = String.valueOf(number).toCharArray();
        long sumOfSquares = 0;
        while (true) {
            if (sumOfSquares == 1) {
                return true;
            } else if (sumOfSquares == number || seen.contains(sumOfSquares)) {
                return false;
            }
            seen.add(sumOfSquares);
            sumOfSquares = 0;
            for (char ch : numberArray) {
                sumOfSquares += Long.parseLong(String.valueOf(ch)) * Long.parseLong(String.valueOf(ch));
            }
            numberArray = String.valueOf(sumOfSquares).toCharArray();
        }
    }

    static void showProperties(long number) {
        System.out.println("Properties of " + number);
        System.out.printf("buzz: %s\n", isBuzz(number));
        System.out.printf("duck: %s\n", isDuck(number));
        System.out.printf("palindromic: %s\n", isPalindromic(number));
        System.out.printf("gapful: %s\n", isGapful(number));
        System.out.printf("spy: %s\n", isSpy(number));
        System.out.printf("square: %s\n", isSquare(number));
        System.out.printf("sunny: %s\n", isSunny(number));
        System.out.printf("jumping: %s\n", isJumping(number));
        System.out.printf("happy: %s\n", isHappy(number));
        System.out.printf("sad: %s\n", !isHappy(number));
        System.out.printf("even: %s\n", isEven(number));
        System.out.printf("odd: %s\n", !isEven(number));
    }

    static void showPropertiesInLine(long number) {
        String buzz = isBuzz(number) ? "buzz, " : "";
        String duck = isDuck(number) ? "duck, " : "";
        String palindromic = isPalindromic(number) ? "palindromic, " : "";
        String gapful = isGapful(number) ? "gapful, " : "";
        String spy = isSpy(number) ? "spy, " : "";
        String square = isSquare(number) ? "square, " : "";
        String sunny = isSunny(number) ? "sunny, " : "";
        String jumping = isJumping(number) ? "jumping, " : "";
        String happy = isHappy(number) ? "happy, " : "";
        String sad = !isHappy(number) ? "sad, " : "";
        String even = isEven(number) ? "even" : "odd";

        System.out.printf("%d is %s%s%s%s%s%s%s%s%s%s%s\n", number, buzz, duck, palindromic, gapful, spy, square, sunny, jumping, happy, sad, even);
    }

    static void showNumbersWithProperties(long number, long range, List<String> properties) {
        long result = 0;
        long n = number;
        int i = 0;

        while (i < range) {
            for (String property : properties) {
                switch (property) {
                    case "EVEN":
                    case "-ODD":
                        result = isEven(n) ? result + 1 : 0;
                        break;
                    case "ODD":
                    case "-EVEN":
                        result = !isEven(n) ? result + 1 : 0;
                        break;
                    case "BUZZ":
                        result = isBuzz(n) ? result + 1 : 0;
                        break;
                    case "-BUZZ":
                        result = !isBuzz(n) ? result + 1 : 0;
                        break;
                    case "DUCK":
                        result = isDuck(n) ? result + 1 : 0;
                        break;
                    case "-DUCK":
                        result = !isDuck(n) ? result + 1 : 0;
                        break;
                    case "PALINDROMIC":
                        result = isPalindromic(n) ? result + 1 : 0;
                        break;
                    case "-PALINDROMIC":
                        result = !isPalindromic(n) ? result + 1 : 0;
                        break;
                    case "GAPFUL":
                        result = isGapful(n) ? result + 1 : 0;
                        break;
                    case "-GAPFUL":
                        result = !isGapful(n) ? result + 1 : 0;
                        break;
                    case "SPY":
                        result = isSpy(n) ? result + 1 : 0;
                        break;
                    case "-SPY":
                        result = !isSpy(n) ? result + 1 : 0;
                        break;
                    case "SQUARE":
                        result = isSquare(n) ? result + 1 : 0;
                        break;
                    case "-SQUARE":
                        result = !isSquare(n) ? result + 1 : 0;
                        break;
                    case "SUNNY":
                        result = isSunny(n) ? result + 1 : 0;
                        break;
                    case "-SUNNY":
                        result = !isSunny(n) ? result + 1 : 0;
                        break;
                    case "JUMPING":
                        result = isJumping(n) ? result + 1 : 0;
                        break;
                    case "-JUMPING":
                        result = !isJumping(n) ? result + 1 : 0;
                        break;
                    case "HAPPY":
                    case "-SAD":
                        result = isHappy(n) ? result + 1 : 0;
                        break;
                    case "SAD":
                    case "-HAPPY":
                        result = !isHappy(n) ? result + 1 : 0;
                        break;
                }
            }
            if (result == properties.size()) {
                showPropertiesInLine(n);
                i++;
            }
            result = 0;
            n++;
        }
    }

    static boolean checkProperties(List<String> properties) {
        List<String> wrongProperties = new ArrayList<>();

        for (String property : properties) {
            property = property.charAt(0) == '-' ? property.substring(1) : property;
            if (!Arrays.asList(propertiesArray).contains(property)) {
                wrongProperties.add(property);
            }
            if (properties.contains(property) && properties.contains("-" + property)) {
                System.out.printf("The request contains mutually exclusive properties: [%s, -%s]\n" +
                        "There are no numbers with these properties.\n", property, property);
                return false;
            }
        }

        if (wrongProperties.size() == 1) {
            System.out.printf("The property [%s] is wrong.\n", wrongProperties.get(0));
            System.out.println("Available properties:\n" +
                    "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            return false;
        } else if (wrongProperties.size() > 1){
            System.out.printf("The properties %s are wrong.\n", wrongProperties);
            System.out.println("Available properties:\n" +
                    "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            return false;
        }
        if (properties.contains("EVEN") && properties.contains("ODD")) {
            System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]\n" +
                    "There are no numbers with these properties.");
            return false;
        } else if (properties.contains("-EVEN") && properties.contains("-ODD")) {
            System.out.println("The request contains mutually exclusive properties: [-EVEN, -ODD]\n" +
                    "There are no numbers with these properties.");
            return false;
        } else if (properties.contains("DUCK") && properties.contains("SPY")) {
            System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]\n" +
                    "There are no numbers with these properties.");
            return false;
        } else if (properties.contains("-DUCK") && properties.contains("-SPY")) {
            System.out.println("The request contains mutually exclusive properties: [-DUCK, -SPY]\n" +
                    "There are no numbers with these properties.");
            return false;
        } else if (properties.contains("SUNNY") && properties.contains("SQUARE")) {
            System.out.println("The request contains mutually exclusive properties: [SUNNY, SQUARE]\n" +
                    "There are no numbers with these properties.");
            return false;
        }  else if (properties.contains("HAPPY") && properties.contains("SAD")) {
            System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]\n" +
                    "There are no numbers with these properties.");
            return false;
        } else if (properties.contains("-HAPPY") && properties.contains("-SAD")) {
            System.out.println("The request contains mutually exclusive properties: [-HAPPY, -SAD]\n" +
                    "There are no numbers with these properties.");
            return false;
        }
        return true;
    }

    static void printMenu() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!");
        printMenu();
        long n = -1;
        int listLength;
        while (n != 0) {
            System.out.print("Enter a request: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("")) {
                printMenu();
                continue;
            }
            ArrayList<String> params = new ArrayList<>(Arrays.asList(input.split(" ")));
            if (!isNumeric(params.get(0))) {
                System.out.println("The first parameter should be a natural number or zero.");
                continue;
            }
            n = Long.parseLong(params.get(0));
            listLength = params.size();
            long range = params.size() > 1 ? Long.parseLong(params.get(1)) : 0;
            if (n != 0) {
                if (isNotNatural(n)) {
                    System.out.println("The first parameter should be a natural number or zero.");
                } else if (listLength > 1 && isNotNatural(range)) {
                    System.out.println("The second parameter should be a natural number.");
                } else {
                    switch (listLength) {
                        case 1:
                            showProperties(n);
                            break;
                        case 2:
                            for (long i = 0; i < range; i++) {
                                showPropertiesInLine(n++);
                            }
                            break;
                        default:
                            List<String> parameters = params.subList(2, params.size());
                            parameters.replaceAll(String::toUpperCase);
                            if (checkProperties(parameters)) {
                                showNumbersWithProperties(n, range, parameters);
                            }
                    }
                }
            }
        }
        System.out.println("Goodbye!");
    }
}
