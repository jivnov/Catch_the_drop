package gb.catch_the_drop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class StartGame extends JFrame{

    private static Image background_st;
    private static StartGame start_game;


    public static void Start_menu() throws IOException {
        background_st = ImageIO.read(StartGame.class.getResourceAsStream("background2.png"));
        start_game = new StartGame();
        start_game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        start_game.setLocation(200, 100);
        start_game.setSize(900, 450);
        start_game.setResizable(false);
        StartGame.GameFieldST game_field_st = new StartGame.GameFieldST();
        game_field_st.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent k) {
                int x2 = k.getX();
                int y2 = k.getY();
                boolean is_start = x2 > 180 && x2 < 750 && y2 > 85 && y2 < 208;
                boolean is_start2 = x2 > 210 && x2 < 736 && y2 > 250 && y2 < 373;;
                boolean is_start3 = x2 > 335 && x2 < 560 && y2 > 380 && y2 < 415;;
                if (is_start) {
                    try {
                        Music.PlayClickSound();
                        start_game.setVisible(false);
                        start_game.dispose();
                        Score.Reader();
                        GameWindow.Game();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (is_start2) {
                    Music.PlayClickSound();
                    System.exit(0);
                }
                if (is_start3) {
                    try {
                        Music.PlayClickSound();
                        Score.createScoreTable();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        start_game.add(game_field_st);
        start_game.setVisible(true);
    }


    private static class GameFieldST extends JPanel{

        @Override
        protected void paintComponent(Graphics g){
            g.drawImage(background_st, 0, 0, null);
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        Start_menu();
    }
}
