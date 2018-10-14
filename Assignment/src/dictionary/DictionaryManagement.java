package dictionary;

import app.Config;
import struct.Dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryManagement {
    static Map<String, Dictionary> data = new HashMap<>();//key &&

    //    private ArrayList<String> keys = new ArrayList<>();
//    private String path = "E_V.txt";
//    public void readFile(){
//        BufferedReader br = null;
//        try{
//            br = new BufferedReader(new FileReader(path));
//            String line;
//            String word,explain;
//            while((line = br.readLine())!= null){
//                word = line.substring(0,line.indexOf("<html>"));
//                explain = line.substring(line.indexOf("<html"));
//                data.put(word,explain);
//                keys.add(word);
//            }
//            br.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    public String lookUp(String word){
//        return data.get("word");
//    }
//    public void Update(String path, String line){
//        Util.writeFile(path,line);
//    }
//    public void addWord(String word){
//
//    }

    public static void readFileDict() {
        List<String> contentFile = Util.readFileLines(Config.FILE_DICTIONARY);
        String word;
        int index = 0;
        if (contentFile != null) {
            for (String line : contentFile) {
                String[] lineData = line.split("<html>");
                word = lineData[0];
                Dictionary dict = new Dictionary(index, word, lineData[1]);
                data.put(word, dict);
                index++;
            }
        }
    }

    public static void addWord(String word, String explain) {
        explain = generateExplain(explain);
        String content = word + explain;
        int n = data.size();
        Dictionary dict = new Dictionary(n + 1, word, explain);
        data.put(word, dict);
        Util.writeFile(Config.FILE_DICTIONARY, content);
    }

    public static Dictionary searchWord(String word) {
        //readFileDict();
        return data.get(word);
    }

    public static void editWord(String word, String explain){
        Dictionary dict = searchWord(word);
        explain = generateExplain(explain);
        String content = word + explain;
        dict.setExplain(explain);
        Util.writeFile(Config.FILE_DICTIONARY,content);
    }
    public static void deleteWord(String word){
        Dictionary dict = searchWord(word);

    }
    public static String generateExplain(String explain) {
        return "<html><i>" + explain + "</i><br /></html>";
    }


}
