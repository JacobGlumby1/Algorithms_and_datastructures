package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CSVwriter {

    String filename;
    String bigOh;


    public CSVwriter(String filename, String bigOh) throws IOException {
        this.filename = filename + ".csv";
        this.bigOh = bigOh;
        try(FileWriter pw = new FileWriter(this.filename,true)){
        pw.append("N_Elements");
        pw.append(",");
        pw.append("Counter");
            pw.append(",");
            pw.append(this.bigOh);
        pw.append("\n");
        pw.flush();

        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void writeData(int N, int count, int NlogN) throws IOException {
        FileWriter pw = new FileWriter(this.filename,true);
        pw.append(String.valueOf(N));
        pw.append(",");
        pw.append(String.valueOf(count));
        pw.append(",");
        pw.append(String.valueOf(NlogN));
        pw.append("\n");

        pw.flush();
        pw.close();
    }


}
