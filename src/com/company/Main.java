package com.company;



import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {


        File input = null;
        File operations = null;
//        input=new File(args[1]);
//        operations=new File(args[0]);
        for (int i = 0; i < args.length; i++) {

            // Установка файла для чтения.
            if (args[i].equals("-i")) {
                if (args.length == i + 1) {

                    return;
                }
                operations = new File(args[++i]);
                if (!checkFile(operations))
                    return;
                continue;
            }

            input = new File(args[i]);
        }


        Reader reader;
        if (input == null) {
            reader = new InputStreamReader(System.in);

        } else
            reader = new FileReader(input);

        new Calculator(operations, reader).execute();
    }

    private static boolean checkFile(File file) {
        if (!file.exists()) {

            return false;
        } else return !file.isDirectory();
    }

}