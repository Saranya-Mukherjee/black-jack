public class Person {
    int type; // 0 for player; 1 for dealer;

    int total_score;

    public Person(int type, int total_score) {
        this.type = type;
        this.total_score = total_score;
    }

    public Person() {
        this.type = 0;
        this.total_score = 0;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }
}
