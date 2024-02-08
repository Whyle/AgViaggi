package data;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOObjectFile<T> {
    String separator = ";";
    String fileName = "file.txt";

    IOObjectFile(String fileName, String separator) {
        this.separator = separator;
        this.fileName = fileName;
    }

    public String serialize(T obj) {
        return "";
    }

    public T deserialize(String[] attributes) {
        return null;
    }

    /**
     * Open the file and load the data
     * example of file content: Emma;4;BUSINESS;Roma;05-05-2023
     * 10:32;Modena;10-05-2023 15:49;TRUE
     * 
     * @return ArrayList<T>
     */
    public ArrayList<T> loadData() {
        ArrayList<T> list = new ArrayList<T>();

        // read each line of the file and call deserialize
        // add the object to the list
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] attributes = line.split(separator);
                list.add(deserialize(attributes));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void remove(int line) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            lines.remove(line);
            Files.write(Paths.get(fileName), lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T get(int index) {
        return loadData().get(index);
    }

    public void set(int index, T obj) {
        ArrayList<T> list = loadData();
        list.set(index, obj);
        saveData(list);
    }

    public void saveData(ArrayList<T> list) {
        try {
            List<String> lines = new ArrayList<String>();
            for (T obj : list) {
                lines.add(serialize(obj));
            }
            Files.write(Paths.get(fileName), lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        try {
            Files.write(Paths.get(fileName), "".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}