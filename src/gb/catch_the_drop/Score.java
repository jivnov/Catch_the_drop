package gb.catch_the_drop;


import java.awt.Dimension;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Score extends JFrame {

    private static final ArrayList<Integer> people = new ArrayList<>();


// Start reading
    public static void Reader() throws IOException {
        people.clear();
//        System.getProperty("user.dir");
//        Score.class.getResource("/Score.txt");
//        System.out.println(new File("./Score.txt").getCanonicalPath());
//        File score = new File(new File("./Score.txt").getCanonicalPath());
//        System.out.println(score);
        FileReader fr= new FileReader("/Users/andreizhyunou/IdeaProjects/GeekBrains/Catch_the_drop/src/gb/catch_the_drop/Score.txt");
//        FileReader fr= new FileReader(System.getProperty("user.dir")+"/src/gb/catch_the_drop/Score.txt");
//        FileReader fr= new FileReader(score);
        Scanner scan = new Scanner(fr);
        while (scan.hasNextLine()) {
            people.add(Integer.valueOf(scan.nextLine()));
        }
        fr.close();
    }
// End reading

//Start writing
    public static void Writer() {
        FileWriter nFile = null;
        try {
//            nFile = new FileWriter("/Users/andreizhyunou/IdeaProjects/GeekBrains/Catch_the_drop/src/gb/catch_the_drop/Score.txt");
            nFile = new FileWriter("./src/gb/catch_the_drop/Score.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }

        people.add(GameWindow.score);
        Collections.sort(people);
        Collections.reverse(people);
        for (int i = 0; i < 10; i++) {
            try {
                assert nFile != null;
                nFile.write(String.valueOf(people.get(i)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                nFile.append('\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            nFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//End writing

    public static void createScoreTable() throws IOException {
        JFrame score_table = new JFrame("Score");

        Reader();

        String[] columnNames = {
                "Place",
                "Score",
        };

        String[][] data = {
                {"1", String.valueOf(people.get(0))},
                {"2", String.valueOf(people.get(1))},
                {"3", String.valueOf(people.get(2))},
                {"4", String.valueOf(people.get(3))},
                {"5", String.valueOf(people.get(4))},
                {"6", String.valueOf(people.get(5))},
                {"7", String.valueOf(people.get(6))},
                {"8", String.valueOf(people.get(7))},
                {"9", String.valueOf(people.get(8))},
                {"10", String.valueOf(people.get(9))},
        };

        JTable table = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);

        score_table.getContentPane().add(scrollPane);
        score_table.setPreferredSize(new Dimension(450, 200));
        score_table.pack();
        score_table.setVisible(true);
        score_table.setLocation(0, 0);
        score_table.setResizable(false);


    }
}


