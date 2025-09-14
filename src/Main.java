import java.util.Scanner;

class Pet{
    private String name, color, race;
    private int day,month,year; //birthdate

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pet[] petList= new Pet[3];

        System.out.println("Let's recorder three pets on the list");
        for(int i=0; i<3; i++){
            petList[i]=new Pet();

            System.out.println("******Insert dates of pet "+ (i+1));
            System.out.print("Name: ");
            petList[i].setName(scanner.nextLine());

            System.out.print("Color: ");
            petList[i].setColor(scanner.nextLine());

            System.out.print("Race: ");
            petList[i].setRace(recorderRace(scanner));
            System.out.println("Now, enter the pet's birthdate ");
            System.out.print("Day: ");
            petList[i].setDay(scanner.nextInt());
            System.out.print("Month: ");
            petList[i].setMonth(scanner.nextInt());
            System.out.print("Year: ");
            petList[i].setYear(scanner.nextInt());
            scanner.nextLine();//Fixing the nextInt's bug
            System.out.println();
        }
        printPetList(petList);
    }

    static String recorderRace(Scanner scanner){
        String race=scanner.nextLine();
        if(isValidRace(race)){
            return race;
        }else{
            System.out.println("This race is invalid. Insert other");
            return recorderRace(scanner);
        }
    }

    static boolean isValidRace(String race){
        return race.equalsIgnoreCase("pitbull") || race.equalsIgnoreCase("box")
                || race.equalsIgnoreCase("husky");
    }

    static void printPetList(Pet[] petList){
        System.out.println("Printing Pet List: \n\n");
        for (Pet pet:petList){
            System.out.println("********Name: "+ pet.getName());
            System.out.println("Race: "+ pet.getRace());
            System.out.println("Color: "+ pet.getColor());
            System.out.println("Birthdate: "+pet.getDay()+"/"+pet.getMonth()+"/"+pet.getYear()+"\n\n");
        }
    }
}