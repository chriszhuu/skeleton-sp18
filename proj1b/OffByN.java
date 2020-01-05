public class OffByN implements CharacterComparator {
    int offset;

    public OffByN(int i) {
        offset = i;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x - y == offset || y - x == offset;
    }
}
