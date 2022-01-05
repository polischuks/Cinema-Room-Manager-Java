package cinema;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class CinemaRoom {
    int rows;
    int seetsInRow;

    public CinemaRoom(int rows, int seets) {
        this.rows = rows;
        this.seetsInRow = seets;
    }

    private final int LIMIT_TO_PRICE = 60;
    private final int PRICE = 10;
    private final int BIG_PRICE = 8;

    private int rowNumberTicket;
    private int seatNumberTicket;
    private int totalSeetsCinema;

    ArrayList<SeetInCinemaRoom> listOfSeetsInCinemaRoom = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    public void startCinema() {
        createCinema();
        mainMenu();
    }

    public void mainMenu() {
         do {
            System.out.println("\n" +
                    "1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            switch (scanner.nextInt()) {
                case 1: { printCinemaRoom(); }
                case 2: {
                    inputDataTicket();
                }
                case 3: { statisticsCinemaRoom(); }
                case 0: { return; }
                default: System.exit(0);
            }
        } while(true);
    }

    private void statisticsCinemaRoom() {
        int currentIncome = 0;
        int totalIncome = 0;
        int count = 0;


        for (SeetInCinemaRoom seet : listOfSeetsInCinemaRoom) { totalIncome += seet.getPrice(); }
        for (SeetInCinemaRoom seet : listOfSeetsInCinemaRoom) {
            if (" B".equals(seet.getLabel())) {
                currentIncome += seet.getPrice();
                count++;
            }
        }

        String percentage = String.format("%.2f", ((count * 100.00) / (this.seetsInRow * this.rows)));

        System.out.println("\n" +
                "Number of purchased tickets: "+ count +"\n" +
                "Percentage: "+ percentage +"%\n" +
                "Current income: $"+ currentIncome +"\n" +
                "Total income: $" + totalIncome);
        mainMenu();
    }

    private void printCinemaRoom() {
         printTopRoom();

         for (SeetInCinemaRoom room : listOfSeetsInCinemaRoom) {
             if (room.getNumberSeetInRow() == 1) { System.out.print(room.getNumberRow()); }
             if (room.getNumberSeetInRow() < this.seetsInRow) { System.out.print(room.getLabel()); }
             if (room.getNumberSeetInRow() == this.seetsInRow) {
                 System.out.print(room.getLabel());
                 System.out.println();
             }
         }
        System.out.println();
        mainMenu();
    }

    private void printTopRoom() {
        System.out.println("\n" +
                "Cinema:");
        for (int i = 0; i <= this.seetsInRow; i++) {
            if (i == 0) { System.out.print(" "); }
            else { System.out.printf(" %d",i);}
        }
        System.out.println();
    }

    private String buyTicket() {
        String numberTicket = ""+rowNumberTicket+seatNumberTicket+"";
        for (SeetInCinemaRoom seet : listOfSeetsInCinemaRoom) {
            if (numberTicket.equals(seet.getNumberTicket())) {
                if (" B".equals(seet.getLabel())) {
                    System.out.println("That ticket has already been purchased!");
                    inputDataTicket();
                } else {
                    System.out.printf("Ticket price: $%d",(seet.getPrice()));
                    System.out.println("\n");
                    seet.setLabel(" B");
                    return numberTicket;
                }
            }
        }
        mainMenu();
        return numberTicket;
    }

    private void inputDataTicket() {
        System.out.println("Enter a row number:");
        rowNumberTicket = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        seatNumberTicket = scanner.nextInt();
        if (rowNumberTicket > this.rows || seatNumberTicket > this.seetsInRow) {
            System.out.println("Wrong input!");
            inputDataTicket();
        } else { buyTicket(); }
    }
    
    private void createCinema(){
        int totalSeetsCinema = this.rows * this.seetsInRow;
        for (int i = 1; i <= this.rows; i++){
            for (int j = 1; j <= this.seetsInRow; j++) {
                if (totalSeetsCinema < LIMIT_TO_PRICE) {
                    listOfSeetsInCinemaRoom.add(new SeetInCinemaRoom(" S", i, j, ""+i+j+"",PRICE));
                } else {
                    if (totalSeetsCinema > LIMIT_TO_PRICE && i <= (rows / 2)) {
                        listOfSeetsInCinemaRoom.add(new SeetInCinemaRoom(" S", i, j, ""+i+j+"",PRICE));
                    } else {
                        if (totalSeetsCinema > LIMIT_TO_PRICE && i > (rows / 2)) {
                        listOfSeetsInCinemaRoom.add(new SeetInCinemaRoom(" S", i, j, ""+i+j+"",BIG_PRICE));
                        }
                    }
                }
            }
        }
    }
}
