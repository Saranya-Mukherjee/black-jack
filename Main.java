import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int delay = 2000;
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    static int print_arr(ArrayList<Card> cards){
        System.out.println("Cards:" + cards.size());
        for(Card card: cards){
            Card.print_card(card);
        }
        int tot = Card.get_total_score(cards);
        System.out.println("Total: "+tot);
        System.out.println("********************************");
        return tot;
    }

    static Person loop_over(Person person, ArrayList<Card> cards){
        if (person.getType() == 0){
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.print("Go?0/1: ");
                if(sc.nextInt()==0)
                    break;
                wait(delay);
                Card card = Card.draw_card();
                cards.add(card);
                person.setTotal_score(print_arr(cards));
                if(person.getTotal_score()>21) {
                    System.out.println("HEHEHE FUCK U!!");
                    System.exit(0);
                }
            }
        }
        else{
            while(person.getTotal_score()<17){
                wait(2000);
                Card card = Card.draw_card();
                cards.add(card);
                person.setTotal_score(print_arr(cards));
            }
        }
        return person;
    }

    public static void main(String[] args) {
        Card.cards_drawn = new ArrayList<>();

        Person player = new Person(0, 0);
        ArrayList<Card> cards_player = new ArrayList<Card>();
        cards_player.add(Card.draw_card());
        print_arr(cards_player);
        wait(delay);
        cards_player.add(Card.draw_card());
        player.setTotal_score(print_arr(cards_player));
        Person pl_done = loop_over(player, cards_player);

        Person dealer = new Person(1, 0);
        cards_player = new ArrayList<Card>();
        cards_player.add(Card.draw_card());
        print_arr(cards_player);
        wait(delay);
        cards_player.add(Card.draw_card());
        dealer.setTotal_score(print_arr(cards_player));
        Person dl_done = loop_over(dealer, cards_player);

        System.out.println("Player total: " + pl_done.getTotal_score());
        System.out.println("Dealer total: " + dl_done.getTotal_score());
        if(pl_done.getTotal_score()> dl_done.getTotal_score())
            System.out.println("PLAYER!!");
        else
            System.out.println("DEALER!!");
    }
}