package cinema;

public class SeetInCinemaRoom {
    String label;
    int numberRow;
    int numberSeetInRow;

    public String getNumberTicket() {
        return numberTicket;
    }

    public void setNumberTicket(String numberTicket) {
        this.numberTicket = numberTicket;
    }

    String numberTicket;
    int price;

    SeetInCinemaRoom(String s, int i, int i1, String s1, int i2) {
        this.label = s;
        this.numberRow = i;
        this.numberSeetInRow = i1;
        this.numberTicket = s1;
        this.price = i2;
    }

    SeetInCinemaRoom() {

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getNumberRow() {
        return numberRow;
    }

    public void setNumberRow(int numberRow) {
        this.numberRow = numberRow;
    }

    public int getNumberSeetInRow() {
        return numberSeetInRow;
    }

    public void setNumberSeetInRow(int numberSeetInRow) {
        this.numberSeetInRow = numberSeetInRow;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }





}
