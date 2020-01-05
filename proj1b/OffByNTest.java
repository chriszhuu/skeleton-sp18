import org.junit.Test;

import static org.junit.Assert.*;

public class OffByNTest {

    @Test
    public void equalChars() {
        OffByN offBy5 = new OffByN(5);
        assertTrue(offBy5.equalChars('a', 'f'));  // true
        assertTrue(offBy5.equalChars('f', 'a'));  // true
        assertFalse(offBy5.equalChars('f', 'h'));  // false
        assertFalse(offBy5.equalChars('$', '#'));  // false
        assertFalse(offBy5.equalChars('A', 'a'));  // false
    }
}
