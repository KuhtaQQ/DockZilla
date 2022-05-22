import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class SearchFile {

    private static Scanner sc = new Scanner(System.in);
    private static String path = sc.nextLine();
    private static File file = new File(path);
    private static String fileContent;
    private static ArrayList <String> listFiles = new ArrayList();


    public static void main(String [] args) throws FileNotFoundException {

        processFileFromFolder(file);
        sortingByDependencies();
        resultFile();
        sc.close();
    }
    public static void processFileFromFolder(File folder) throws FileNotFoundException {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory())
            {
                processFileFromFolder(entry);
                continue;
            }else if(entry.isFile()){
                fileContent = processingFile(entry);
                listFiles.add(fileContent);
            }
        }
        Collections.sort(listFiles);
    }

    public static String processingFile(File file) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(line);
            stringBuilder.append(ls);

        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public static String checkingDependencies(String line){
        String fileName = null;

            int index = line.replaceAll("(requier)^([a-zA-Z]:)?(\\\\[a-zA-Z0-9_\\-]+)+\\\\?", "/").lastIndexOf("/");
            fileName = index >= 0 ? line.substring(index + 1) : line;


        return fileName;
    }

    public static void sortingByDependencies(){
        for(int i = 0;i<=listFiles.size(); i++){
            String name = checkingDependencies(listFiles.get(i));
            if (name != null){
                int idx = listFiles.indexOf(name);
                listFiles.set(idx+1, listFiles.get(i));
            }else {
                continue;
            }
        }

    }

    public static File resultFile(){
        File newFile = new File(path, "newFile.txt");
        try {
            FileWriter fw = new FileWriter(newFile, true);
            for(String file: listFiles){
                fw.write(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }



}
