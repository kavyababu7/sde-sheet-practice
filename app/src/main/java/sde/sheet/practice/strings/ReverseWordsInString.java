package sde.sheet.practice.strings;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String sentence = "This is a sample sentence";
        System.out.println(reverseSentence(sentence));
        System.out.println(reverseSentenceWithoutExtraSpace(sentence));
    }

    private static String reverseSentenceWithoutExtraSpace(String sentence) {
        int end = sentence.length() - 1;
        String ans = "";
        int index = 0;
        String temp = "";
        while (index <= end){
            if (sentence.charAt(index) != ' ') {
                temp += sentence.charAt(index);
            } else {
                ans = temp + " " + ans;
                temp = "";
            }
            index++;
        }
        return temp + " " + ans;
    }

    private static String reverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        String reversedWord = "";
        for (int i = words.length - 1; i >= 0; i--) {
            reversedWord += words[i] + " ";
        }
        return reversedWord;
    }
}
