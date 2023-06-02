package src;

public class Main {
    public static void main(String[] args) {
        String phrase = "Dog bites man!";
        String reversedPhrase = reversePhrase(phrase);
        String upperCaseFirstLetter = capitalization(reversedPhrase);
        String finalPhrase = punctuation(phrase, upperCaseFirstLetter);
        System.out.println("phrase: " + phrase);
        System.out.println("reversed phrase: " + finalPhrase);
    }

    public static String reversePhrase(String phrase) {
        String[] words = phrase.split(" ");
        String reversedPhrase = "";
        for (int i = words.length - 1; i >= 0; i--) {
            reversedPhrase = reversedPhrase.concat(words[i] + " ");
        }
        return reversedPhrase.trim();
    }

    public static String capitalization(String phrase) {
        return phrase.substring(0, 1).toUpperCase() + phrase.substring(1);
    }

    public static String punctuation(String phrase, String reversedPhrase) {
        String lastLetter = phrase.substring(phrase.length()-1);

        String firstWord = reversedPhrase.split(" ")[0];
        String oldPunctuation = firstWord.substring(firstWord.length()-1);
        if (oldPunctuation.matches("\\p{P}")) {
            reversedPhrase = reversedPhrase.replace(oldPunctuation, "");
        }

        if (lastLetter.matches("\\p{P}")) {
            reversedPhrase = reversedPhrase.concat(lastLetter);
        }

        return reversedPhrase;
    }
}