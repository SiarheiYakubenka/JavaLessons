package by.itclass.lesson20_0512;

import java.io.*;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException {
        String line;
        Scanner scanner = new Scanner(System.in);
        ProcessBuilder builder = new ProcessBuilder("cmd.exe");
        builder.redirectErrorStream(true);

        Process process = builder.start();

        OutputStream output = process.getOutputStream();
        InputStream input = process.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

        while (scanner.hasNext()){

            String intStr = scanner.nextLine();
            intStr +="\n";
            writer.write(intStr);
            writer.flush();
            while ((line = reader.readLine()) != null){
            System.out.println("Stdout:" + line);
        }
            if(intStr.trim() == "exit") {
                break;
            }
        }
        writer.close();

        reader.close();
    }
}
