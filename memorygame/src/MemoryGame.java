import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MemoryGame extends JFrame {
    static FirstLayer firstLayer;
    static Point loc;
    public MemoryGame() throws HeadlessException {
        super("Memory Game");
        setLayout(new BorderLayout(2,2));

        firstLayer = new FirstLayer();

        JButton start;
        start = new JButton("New Game");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                loc = getLocation();
                FirstLayer.arrayList.clear();
                FirstLayer.arrayList1.clear();
                FirstLayer.command.clear();
                ToolBar.moveCounter = 0;
                PlayGround.j = 0;
                PlayGround.temp = 0;
                PlayGround.set.clear();
                FirstLayer.actionMap.clear();
                FirstLayer.k = 0;
                ToolBar.moveUpdater();
                new MemoryGame();
            }
        });

        add(start,BorderLayout.CENTER);
        add(new ToolBar(), BorderLayout.NORTH);
        add(firstLayer,BorderLayout.SOUTH);

        getContentPane().setBackground(new Color(87, 103, 143));
        setSize(600,600);
        if (loc != null){
            setLocation(loc);
        }
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}