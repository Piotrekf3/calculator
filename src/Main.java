import java.awt.*;
import calculator.*;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            MyFrame mainFrame = new MyFrame();
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setVisible(true);
        });

    }
}
