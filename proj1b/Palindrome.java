public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> letters = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            letters.addLast(word.charAt(i));
        }
        return letters;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> letters = wordToDeque(word);
        String front = "", back = "";
        for (int i = 0; i < word.length() / 2; i++) {
            front += letters.removeFirst();
            back += letters.removeLast();
        }
        return front.equals(back);
    }

//    public boolean isPalindromeRecur(String word) {
//        if (word.length() == 0 || word.length() == 1) {
//            return true;
//        }
//        Deque<Character> letters = wordToDeque(word);
//        return isPalindromeRecurHelper(letters);
//    }
//
//    private boolean isPalindromeRecurHelper(Deque<Character> letters) {
//        if (letters.size() < 2) {
//            return true;
//        }
//        boolean partial = letters.removeFirst().equals(letters.removeLast());
//        return partial && isPalindromeRecurHelper(letters);
//    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> letters = wordToDeque(word);
        char front, back;
        for (int i = 0; i < word.length() / 2; i++) {
            front = letters.removeFirst();
            back = letters.removeLast();
            if (!cc.equalChars(front, back)) {
                return false;
            }
        }
        return true;
    }

//    public boolean isPalindromeRecur(String word, CharacterComparator cc) {
//        if (word.length() == 0 || word.length() == 1) {
//            return true;
//        }
//        Deque<Character> letters = wordToDeque(word);
//        return isPalindromeRecurHelper(letters, cc);
//    }

//    private boolean isPalindromeRecurHelper(Deque<Character> letters, CharacterComparator cc) {
//        if (letters.size() < 2) {
//            return true;
//        }
//        char front = letters.removeFirst();
//        char last = letters.removeLast();
//        boolean partial = cc.equalChars(front, last);
//        return partial && isPalindromeRecurHelper(letters, cc);
//    }

}
