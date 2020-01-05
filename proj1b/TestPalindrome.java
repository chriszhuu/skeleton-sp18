import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.*/
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String a = "a";
        assertTrue(palindrome.isPalindrome(a));
        String racecar = "racecar";
        assertTrue(palindrome.isPalindrome(racecar));
        String horse = "horse";
        assertFalse(palindrome.isPalindrome(horse));
        String b = "";
        assertTrue(palindrome.isPalindrome(b));
        String noon = "noon";
        assertTrue(palindrome.isPalindrome(noon));
        String norn = "norn";
        assertFalse(palindrome.isPalindrome(norn));
    }

//    @Test
//    public void testIsPalindromeRecur() {
//        String a = "a";
//        assertTrue(palindrome.isPalindromeRecur(a));
//        String racecar = "racecar";
//        assertTrue(palindrome.isPalindromeRecur(racecar));
//        String horse = "horse";
//        assertFalse(palindrome.isPalindromeRecur(horse));
//        String b = "";
//        assertTrue(palindrome.isPalindromeRecur(b));
//        String noon = "noon";
//        assertTrue(palindrome.isPalindromeRecur(noon));
//        String norn = "norn";
//        assertFalse(palindrome.isPalindromeRecur(norn));
//    }

    @Test
    public void testIsPalindromeOffByOne() {
        CharacterComparator obo = new OffByOne();
        String a = "a";
        assertTrue(palindrome.isPalindrome(a, obo));
        String flake = "flake";
        assertTrue(palindrome.isPalindrome(flake, obo));
        String horse = "horse";
        assertFalse(palindrome.isPalindrome(horse, obo));
        String b = "";
        assertTrue(palindrome.isPalindrome(b, obo));
//        String noon = "noon";
//        assertTrue(palindrome.isPalindrome(noon));
//        String norn = "norn";
//        assertFalse(palindrome.isPalindrome(norn));
    }

//    @Test
//    public void testIsPalindromeOffByOneRecur() {
//        CharacterComparator obo = new OffByOne();
//        String a = "a";
//        assertTrue(palindrome.isPalindromeRecur(a, obo));
//        String flake = "flake";
//        assertTrue(palindrome.isPalindromeRecur(flake, obo));
//        String horse = "horse";
//        assertFalse(palindrome.isPalindromeRecur(horse, obo));
//        String b = "";
//        assertTrue(palindrome.isPalindromeRecur(b, obo));
//    }
}
