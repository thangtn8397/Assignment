package dictionary;

import struct.Dictionary;

public class main1 {
    public static void main(String[] args) {
        DictionaryManagement.readFileDict();
//        DictionaryManagement.addWord("thang2","anhthang");
        System.out.println(DictionaryManagement.data.get("thang2"));
    }
}
