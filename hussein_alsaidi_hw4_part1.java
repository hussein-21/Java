import java.util.Scanner;

class Animal {
    private String type;

    public Animal(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


}

class Dog extends Animal {
    private String mainColor;
    private String secondaryColor;
    private int age;
    private double weight;
    private String name;

    public Dog(String type, String mainColor, String secondaryColor, int age, double weight, String name) {
        super(type);
        this.mainColor = mainColor;
        this.secondaryColor = secondaryColor;
        this.age = age;
        this.weight = weight;
        this.name = name;
    }

    public String getMainColor() {
        return mainColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}

class GermanSheppard extends Dog {
    public GermanSheppard(String name, int age, double weight, String mainColor, String secondaryColor) {
        super("Dog", mainColor, secondaryColor, age, weight, name);
    }
}

class Labrador extends Dog {
    public Labrador(String name, int age, double weight, String mainColor, String secondaryColor) {
        super("Dog", mainColor, secondaryColor, age, weight, name);
    }
}

class Corgi extends Dog {
    public Corgi(String name, int age, double weight, String mainColor, String secondaryColor) {
        super("Dog",  mainColor, secondaryColor, age, weight, name);
    }
}

public class DogAdoptionProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the HFC Dog Adoption Program!");
        System.out.println("What kind of dog would you like to put in for adoption?");
        System.out.println("1. Corgi\n2. German Sheppard\n3. Labrador Retriever");
        System.out.print("Type: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String name, mainColor, secondaryColor;
        int age;
        double weight;

        System.out.println("You have selected a ");
        Dog dog;
        switch (choice) {
            case 1:
                System.out.println("Corgi! Please enter the following information:");
                System.out.print("Name: ");
                name = scanner.nextLine();
                System.out.print("Age: ");
                age = scanner.nextInt();
                System.out.print("Weight: ");
                weight = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Main Color: ");
                mainColor = scanner.nextLine();
                System.out.print("Secondary Color: ");
                secondaryColor = scanner.nextLine();
                dog = new Corgi(name, age, weight, mainColor, secondaryColor);
                break;
            case 2:
                System.out.println("German Sheppard! Please enter the following information:");
                System.out.print("Name: ");
                name = scanner.nextLine();
                System.out.print("Age: ");
                age = scanner.nextInt();
                System.out.print("Weight: ");
                weight = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Main Color: ");
                mainColor = scanner.nextLine();
                System.out.print("Secondary Color: ");
                secondaryColor = scanner.nextLine();
                dog = new GermanSheppard(name, age, weight, mainColor, secondaryColor);
                break;
            case 3:
                System.out.println("Labrador Retriever! Please enter the following information:");
                System.out.print("Name: ");
                name = scanner.nextLine();
                System.out.print("Age: ");
                age = scanner.nextInt();
                System.out.print("Weight: ");
                weight = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Main Color: ");
                mainColor = scanner.nextLine();
                System.out.print("Secondary Color: ");
                secondaryColor = scanner.nextLine();
                dog = new Labrador(name, age, weight, mainColor, secondaryColor);
                break;
            default:
                System.out.println("Invalid choice! Exiting program.");
                return;
        }

        System.out.println("We will create a profile for this dog! Thank you!");
        System.out.println("Dog Profile:");
        System.out.println("Name: " + dog.getName());
        System.out.println("Age: " + dog.getAge());
        System.out.println("Weight: " + dog.getWeight());
        System.out.println("Main Color: " + dog.getMainColor());
        System.out.println("Secondary Color: " + dog.getSecondaryColor());
        System.out.println("Type: " + dog.getType());
    }
}
