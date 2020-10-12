package gb.catch_the_drop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class EndGame extends JFrame {

    private static Image game_over;
    private static EndGame end_game;

    public static void Final() throws IOException {
        GameWindow.drop_top = -100;
        GameWindow.drop_v = 200;
        GameWindow.game_window.setVisible(false);
        GameWindow.game_window.dispose();
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over2.png"));
        end_game = new EndGame();
        end_game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        end_game.setLocation(200, 100);
        end_game.setSize(900, 450);
        end_game.setResizable(false);
        EndGame.GameFieldEN game_field_en = new EndGame.GameFieldEN();
        end_game.setTitle("Score: " + GameWindow.score);
        Score.Writer();
        game_field_en.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent k) {
                int x3 = k.getX();
                int y3 = k.getY();
                boolean is_start = x3 > 55 && x3 < 335 && y3 > 325 && y3 < 830;
                boolean is_start2 = x3 > 645 && x3 < 785 && y3 > 325 && y3 < 820;;
                if (is_start) {
                    try {
                        Music.PlayClickSound();
                        end_game.setVisible(false);
                        end_game.dispose();
                        System.gc();
                        StartGame.Start_menu();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (is_start2) {
                    Music.PlayClickSound();
                    System.exit(0);
                }
            }
        });
        end_game.add(game_field_en);
        end_game.setVisible(true);
    }



    private static class GameFieldEN extends JPanel{

        @Override
        protected void paintComponent(Graphics g){
            g.drawImage(game_over, 0, 0, null);
        }
    }

}
