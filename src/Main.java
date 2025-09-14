import java.util.InputMismatchException;
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
            recorderPetBirthdate(petList[i],scanner);
            scanner.nextLine();//Fixing the scanner.nextInt's bug
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

    static void recorderPetBirthdate(Pet pet,Scanner scanner){
        try {
            System.out.print("Day: ");
            pet.setDay(scanner.nextInt());

            System.out.print("Month: ");
            pet.setMonth(scanner.nextInt());

            System.out.print("Year: ");
            pet.setYear(scanner.nextInt());

        }catch(InputMismatchException e){
            System.out.println("Is a invalid date. Enter again");
            scanner.nextLine();//Fixing the scanner.nextInt's bug
            recorderPetBirthdate(pet,scanner);
        }

        if(!(isValidDate(pet.getDay(), pet.getMonth(), pet.getYear()))){
            System.out.println("Is a invalid date. Enter again");
            recorderPetBirthdate(pet,scanner);
        }
    }

    static boolean isValidDate(int day, int month, int year){

        return isValidDateInMonthWith30Days(day, month) || isValidDateInMonthWith31Days(day, month)
                ||isValidDateInFebruary(day, month, year);
    }

    static boolean isValidDateInMonthWith30Days(int day, int month){
        return (month==4 || month==6 || month==9 || month==11) &&(day<31);
    }

    static boolean isValidDateInMonthWith31Days(int day, int month){
        return(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)&&(day<32);
    }

    static boolean isValidDateInFebruary(int day, int month, int year){
        return ((day<29 && (year%4)!=0) || (day<30 && (year%4)==0))&&(month==2);
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