package struct;

import java.util.HashMap;
import java.util.Map;


// Map: dictionary<word, Struct>

public class Dictionary {

    private int index;
    private String word;
    private String explain;

    public Dictionary(int index, String word, String explain) {
        this.index = index;
        this.word = word;
        this.explain = explain;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getWord() {
        return word;
    }

    public int getIndex() {
        return index;
    }

    public String getExplain() {
        return explain;
    }

    @Override
    public String toString() {
        return this.word+this.explain;
    }

}
