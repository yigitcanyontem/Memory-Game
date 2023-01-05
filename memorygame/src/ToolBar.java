import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel {
    static JLabel moves;
    static int moveCounter = 0;
    static StopWatch stopWatch;
    public ToolBar() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        moves = new JLabel("Moves: " + moveCounter);
        moves.setFont(new Font("Arial",Font.BOLD,20));
        stopWatch = new StopWatch();


        gc.weightx = 0;
        gc.weighty = 0;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(25,0,0,400);
        add(moves, gc);

        gc.weightx = 0;
        gc.weighty = 0;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.PAGE_START;
        gc.insets = new Insets(5,0,0,0);
        add(stopWatch,gc);
//
        setBackground(new Color(87, 103, 143));
    }
    public static void moveUpdater(){
        moves.setText("Moves: " + moveCounter);
    }
}
