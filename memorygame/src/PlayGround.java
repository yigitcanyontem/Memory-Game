import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class PlayGround extends JPanel {
    static Set<Integer> set = new HashSet<>();
    static String[] card = {"1","2","3","4","5","6","7","8","9","10"};
    static int j = 0;
    static Random random = new Random();
    static int temp = 0;
    static String card_hold;
    public PlayGround() {
        setLayout(new GridLayout(4,5,2,2));
        setBackground(new Color(87, 103, 143));
    }

    public static ImageIcon cardAdder(){
        if (j < 20 ){
            if (set.size() == 10){
                set = new HashSet<>();
            }
            int i = random.nextInt(card.length);
            if (!set.contains(i)){
                String tempCard = "/cards/" +card[i]+".jpg";
                card_hold = tempCard;
                ImageIcon player = new ImageIcon(Objects.requireNonNull(PlayGround.class.getResource(tempCard)));
                set.add(i);
                j++;
                temp = i;
                return player;
            }
        }
        return cardAdder();
    }
}
