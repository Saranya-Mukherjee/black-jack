import java.util.ArrayList;
import java.util.Random;

public class Card {
    int color;
    int number;

    static ArrayList<String> names = new ArrayList<String>(){
        {
            add("ace");
            add("2");
            add("3");
            add("4");
            add("5");
            add("6");
            add("7");
            add("8");
            add("9");
            add("10");
            add("jack");
            add("king");
            add("queen");
        }
    };

    static ArrayList<String> suits = new ArrayList<String>(){
        {
            add("hearts");
            add("diamond");
            add("clover");
            add("spades");
        }
    };

    public int getColor() {
        return color;
    }

    public Card() {
    }

    public Card(int color, int number) {
        this.color = color;
        this.number = number;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    static int make_score_of_card(Card card, Person person) {
        int score = 0;
        if ((card.getNumber() > 1) && (card.getNumber() < 11)) {
            score = card.getNumber();
            return score;
        }
        if (card.getNumber() == 1) {
            if (person.getTotal_score() + 11 < 21) {
                score = 11;
            } else {
                score = 1;
            }
            return score;
        }
        score = 10;
        return score;
    }

    static int get_total_score(ArrayList<Card> cards) {
        int total = 0;
        for(Card card : cards) {
            total += make_score_of_card(card, new Person(0, total));
        }
        return total;
    }

    static Card draw_card(){
        Random rand = new Random();
        Card card = new Card();
        int no = rand.nextInt(13) + 1;
        // 1 == ace; 2-10; 11,12,13 == face;
        int suit = rand.nextInt(4);
        card.setColor(suit);
        card.setNumber(no);
        return card;
    }

    static void print_card(Card card){
        System.out.print(names.get(card.getNumber()-1));
        System.out.print(" of ");
        System.out.println(suits.get(card.getColor()));
    }
}
