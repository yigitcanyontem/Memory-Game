import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class FirstLayer extends JPanel {
    static int k = 0;
    static Map<JButton,String > map;
    static Set<String> command;
    static JButton btn1;
    static JButton btn2;
    static JButton btn3;
    static JButton btn4;
    static JButton btn5;
    static JButton btn6;
    static JButton btn7;
    static JButton btn8;
    static JButton btn9;
    static JButton btn10;
    static JButton btn11;
    static JButton btn12;
    static JButton btn13;
    static JButton btn14;
    static JButton btn15;
    static JButton btn16;
    static JButton btn17;
    static JButton btn18;
    static JButton btn19;
    static JButton btn20;
    static ButtonGroup buttonGroup;
    static ImageIcon back = new ImageIcon(Objects.requireNonNull(FirstLayer.class.getResource("/cards/11.jpg")));
    static ArrayList<JButton> arrayList;
    static ArrayList<JButton> arrayList1;
    static Map<JButton,ActionListener> actionMap;
    static JButton[] array;
    public FirstLayer() {
        setLayout(new GridLayout(4,5,2,2));

        buttonGroup = new ButtonGroup();
        command = new HashSet<>();
        map = new HashMap<>();
        arrayList = new ArrayList<>();
        actionMap = new HashMap<>();
        arrayList1 = new ArrayList<>();

        btn1 = new JButton(back);
        btn2 = new JButton(back);
        btn3 = new JButton(back);
        btn4 = new JButton(back);
        btn5 = new JButton(back);
        btn6 = new JButton(back);
        btn7 = new JButton(back);
        btn8 = new JButton(back);
        btn9 = new JButton(back);
        btn10 = new JButton(back);
        btn11 = new JButton(back);
        btn12 = new JButton(back);
        btn13 = new JButton(back);
        btn14 = new JButton(back);
        btn15 = new JButton(back);
        btn16 = new JButton(back);
        btn17 = new JButton(back);
        btn18 = new JButton(back);
        btn19 = new JButton(back);
        btn20 = new JButton(back);


        array = new JButton[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20};

        for (JButton button:array){
            add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!map.containsKey(button)){
                        button.setIcon(PlayGround.cardAdder());
                        button.setActionCommand(PlayGround.temp+"");
                        map.put(button,PlayGround.card_hold);
                    }else{
                        button.setIcon(new ImageIcon(Objects.requireNonNull(PlayGround.class.getResource(map.get(button)))));
                    }


                    command.add(button.getActionCommand());
                    k += 1;
                    arrayList.add(button);

                    if(arrayList.size()==1){
                        ToolBar.stopWatch.start();
                    }


                    actionMap.put(button,button.getActionListeners()[0]);
                    button.removeActionListener(button.getActionListeners()[0]);

                    if (k == 2){
                        disabler();
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                try {
                                    checker();
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        },500);
                    }
                }
            });
            buttonGroup.add(button);
        }

        setBackground(new Color(87, 103, 143));

    }
    private void checker() throws InterruptedException {
        ToolBar.moveCounter++;
        ToolBar.moveUpdater();
        if (k == 2){
            k = 0;
            if (command.size() == 1){
                for (JButton x:arrayList){
                    x.setEnabled(false);
                    arrayList1.add(x);
                    if (arrayList1.size() == 20){
                        ToolBar.stopWatch.stop();
                    }
                }
            }else {
                for (JButton x:arrayList){
                    x.setIcon(back);
                    x.addActionListener(actionMap.get(x));
                }
            }
            enabler();
            arrayList.clear();
            command.clear();
        }
    }

    private void disabler(){
        for(JButton jButton:array){
            if (!arrayList.contains(jButton)){
                jButton.setEnabled(false);
            }
        }

    }
    private void enabler(){
        for(JButton jButton:array){
            if (!arrayList1.contains(jButton)){
                jButton.setEnabled(true);
            }
        }
    }
}
