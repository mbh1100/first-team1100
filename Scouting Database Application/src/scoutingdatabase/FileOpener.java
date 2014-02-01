package scoutingdatabase;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOpener {

    /*
    static FileOpener instance;
    static String fileName = "Teams";
    private File file;

    public FileOpener() {
        file = new File(System.getProperty("user.dir") + "\\" + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Failed creating file");
                e.printStackTrace();
            }
        }
    }

    public static FileOpener getInstance() {
        if (instance == null) {
            instance = new FileOpener();
        }
        return instance;
    }

    public void getTeamsFromFile() {

        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }

        try {
            String textLine = in.readLine();
            while (textLine != null) {
                int teamNumber = Integer.parseInt(textLine.substring(5));
                textLine = in.readLine();
                Team team = new Team(teamNumber);
            }
        } catch (IOException e) {
            System.out.println("Failed reading");
        }
    }

    public void writeTeamsToFile() {
        PrintWriter out = null;
        
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));
        } catch (IOException e) {
            System.out.println("Failed creating writer");
            e.printStackTrace();
        }
        out.print("");
        for (int i = 0; i < Main.getTeamArraySize(); i++) {
            Team currentTeam = Main.getTeamAt(i);
            out.println("Team:" + currentTeam.getTeamNumber());
        }
        out.close();
    }

    public void openWindowFile() {
        try {
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    * */
}