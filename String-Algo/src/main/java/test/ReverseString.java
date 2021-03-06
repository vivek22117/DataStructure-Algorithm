package test;

public class ReverseString {

    private static String input = " I Love India";

    public static void main(String[] args) {
        reverse(input);
        reverseCharacters(input);
    }

    private static void reverse(String input) {

        String[] wordArray = input.trim().split(" ");

        int length = wordArray.length -1;

        StringBuilder sb = new StringBuilder();
        while (length >= 0) {
            sb.append(wordArray[length]).append(" ");
            length--;
        }
        System.out.println(sb.toString());
    }

    private static void reverseCharacters(String input) {

        char[] chars = input.trim().toCharArray();

        int length = chars.length -1;

        StringBuilder sb = new StringBuilder();
        while (length >= 0) {
            sb.append(chars[length]);
            length--;
        }
        System.out.println(sb.toString());
    }
}
