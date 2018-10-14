package dictionary;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Util {

    public static List<String> readFileLines(String path) {
        if (!isFileExists(path)) {
            return null;
        }
        try {
            return Files.readAllLines(new File(path).toPath());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFileContentsInline(String path) {
        if (!isFileExists(path)) {
            return null;
        }
        try {
            List<String> contents = Files.readAllLines(new File(path).toPath());
            StringBuilder sb = new StringBuilder();
            for (String content : contents) {
                sb.append(content);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFileContents(String path) {
        if (!isFileExists(path)) {
            return null;
        }
        try {
            List<String> contents = Files.readAllLines(new File(path).toPath());
            return String.join("\n", contents);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeNewFile(String path, String content) {
        if (!isFileExists(path)) {
            return;
        }
        try {
            PrintWriter writer = new PrintWriter(path, "UTF-8");
            writer.println(content);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String path, String content) {
        if (!isFileExists(path)) {
            writeNewFile(path, content);
        } else {
            try {
                List<String> lines = Files.readAllLines(new File(path).toPath());
                lines.add(content);
                Path file = Paths.get(path);
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static Boolean isFileExists(String path) {
        File f = new File(path);
        return f.exists();
    }

    public static void copyText(String textCopy) {
        StringSelection selection = new StringSelection(textCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }
}