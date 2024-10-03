import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

class Cat extends Animal {
    private int age;
    private int livesUsed;
    private String mainColor;
    private String secondaryColor;
    private double weight;
    private String name;

    public Cat(String type, int age, int livesUsed, String mainColor, String secondaryColor, double weight, String name) {
        super(type);
        this.age = age;
        this.livesUsed = livesUsed;
        this.mainColor = mainColor;
        this.secondaryColor = secondaryColor;
        this.weight = weight;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int getLivesUsed() {
        return livesUsed;
    }

    public String getMainColor() {
        return mainColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
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
        super("Dog", mainColor, secondaryColor, age, weight, name);
    }
}

public class AnimalAdoptionProgram3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();
        System.out.println("Welcome to the HFC Animal Adoption Program!");
        while (true) {
            System.out.println("What kind of animal would you like to add to the system?");
            System.out.println("1. Dog\n2. Cat");
            System.out.print("Selection: ");
            int animalChoice = scanner.nextInt();
            scanner.nextLine();

            String name, mainColor, secondaryColor;
            int age, livesUsed;
            double weight;

            switch (animalChoice) {
                case 1:
                    System.out.println("You have selected a Dog to add!");
                    System.out.println("What kind of dog would you like to put in for adoption?");
                    System.out.println("1. Corgi\n2. German Sheppard\n3. Labrador Retriever");
                    System.out.print("Type: ");
                    int dogChoice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("You have selected a ");
                    Dog dog;
                    switch (dogChoice) {
                        case 1:
                            System.out.println("Corgi! Please enter the following information:");
                            break;
                        case 2:
                            System.out.println("German Sheppard! Please enter the following information:");
                            break;
                        case 3:
                            System.out.println("Labrador Retriever! Please enter the following information:");
                            break;
                        default:
                            System.out.println("Invalid dog choice! Exiting program.");
                            return;
                    }
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
                    dog = new Dog("Dog", mainColor, secondaryColor, age, weight, name);
                    animals.add(dog);
                    break;
                case 2:
                    System.out.println("You have selected a Cat to add!");
                    System.out.println("Please enter the following information:");
                    System.out.print("Name: ");
                    name = scanner.nextLine();
                    System.out.print("Age: ");
                    age = scanner.nextInt();
                    System.out.print("Lives Used: ");
                    livesUsed = scanner.nextInt();
                    System.out.print("Weight: ");
                    weight = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Main Color: ");
                    mainColor = scanner.nextLine();
                    System.out.print("Secondary Color: ");
                    secondaryColor = scanner.nextLine();
                    Cat cat = new Cat("Cat", age, livesUsed, mainColor, secondaryColor, weight, name);
                    animals.add(cat);
                    break;
                default:
                    System.out.println("Invalid animal choice! Exiting program.");
                    return;
            }

            System.out.println("We will create a profile for this animal!");
            System.out.println("Do you have more animals to add to the adoption system?");
            System.out.println("1. Yes\n2. No");
            System.out.print("Selection: ");
            int moreAnimals = scanner.nextInt();
            scanner.nextLine(); 

            if (moreAnimals != 1) {
                break;
            }
        }

        System.out.print("Please enter a name for the file the system will generate: ");
        String fileName = scanner.nextLine();
        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            for (Animal animal : animals) {
                if (animal instanceof Dog) {
                    Dog dog = (Dog) animal;
                    writer.write("Type: Dog\n");
                    writer.write("Name: " + dog.getName() + "\n");
                    writer.write("Age: " + dog.getAge() + "\n");
                    writer.write("Weight: " + dog.getWeight() + "\n");
                    writer.write("Main Color: " + dog.getMainColor() + "\n");
                    writer.write("Secondary Color: " + dog.getSecondaryColor() + "\n\n");
                } else if (animal instanceof Cat) {
                    Cat cat = (Cat) animal;
                    writer.write("Type: Cat\n");
                    writer.write("Name: " + cat.getName() + "\n");
                    writer.write("Age: " + cat.getAge() + "\n");
                    writer.write("Lives Used: " + cat.getLivesUsed() + "\n");
                    writer.write("Weight: " + cat.getWeight() + "\n");
                    writer.write("Main Color: " + cat.getMainColor() + "\n");
                    writer.write("Secondary Color: " + cat.getSecondaryColor() + "\n\n");
                }
            }
            writer.close();
            System.out.println("The system has generated a file for you called " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        System.out.println("Thank you!");
    }
}
