import java.util.Scanner;
import java.util.Random;

public class Character {
    private String name;
    private String ancestry;
    private String characterClass;
    private String gender;
    private String alignment;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public Character() {}

    public Character(String name, String ancestry, String characterClass, String gender, String alignment,
                     int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.name = name;
        this.ancestry = ancestry;
        this.characterClass = characterClass;
        this.gender = gender;
        this.alignment = alignment;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }


    public void generateStats() {
        Random random = new Random();
        strength = random.nextInt(16) + 3;
        dexterity = random.nextInt(16) + 3;
        constitution = random.nextInt(16) + 3;
        intelligence = random.nextInt(16) + 3;
        wisdom = random.nextInt(16) + 3;
        charisma = random.nextInt(16) + 3;
    }

    public void displayStats() {
        System.out.println("Strength: " + strength + "\tDexterity: " + dexterity + "\tConstitution: " + constitution +
                "\tIntelligence: " + intelligence + "\tWisdom: " + wisdom + "\tCharisma: " + charisma);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the HFC Roleplaying Game!");
        System.out.print("How many characters (up to 10) would you like to generate? ");
        int numCharacters = scanner.nextInt();

        Character[] characters = new Character[numCharacters];

        for (int i = 0; i < numCharacters; i++) {
            System.out.println("\nFor character " + (i + 1) + ", are these stats acceptable?");
            Character character = new Character();
            character.generateStats();
            character.displayStats();

            boolean accepted = false;
            while (!accepted) {
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Selection: ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    accepted = true;
                } else if (choice == 2) {
                    character.generateStats();
                    character.displayStats();
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            }

            scanner.nextLine();
            System.out.println("Please enter the following information for character generation:");
            System.out.print("Character Name: ");
            String name = scanner.nextLine();


            System.out.println("Ancestry:");
            String[] validAncestries = {"Dragonborn", "Dwarf", "Elf", "Gnome", "Goblin", "Halfling", "Half-Elf", "Half-Orc", "Human", "Tiefling"};
            for (int j = 0; j < validAncestries.length; j++) {
                System.out.println((j + 1) + ". " + validAncestries[j]);
            }
            System.out.print("Ancestry Selection: ");
            int ancestryOption = scanner.nextInt();
            String ancestry = validAncestries[ancestryOption - 1];


            System.out.println("\nClass:");
            String[] validClasses = {"Alchemist", "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Paladin", "Ranger", "Rogue", "Sorcerer", "Witch", "Wizard"};
            for (int j = 0; j < validClasses.length; j++) {
                System.out.println((j + 1) + ". " + validClasses[j]);
            }
            System.out.print("Class Selection: ");
            int classOption = scanner.nextInt();
            String characterClass = validClasses[classOption - 1];


            System.out.println("\nGender:");
            String[] validGenders = {"Male", "Female", "Non-Binary"};
            for (int j = 0; j < validGenders.length; j++) {
                System.out.println((j + 1) + ". " + validGenders[j]);
            }
            System.out.print("Gender Selection: ");
            int genderOption = scanner.nextInt();
            String gender = validGenders[genderOption - 1];


            System.out.println("\nAlignment:");
            String[] validAlignments = {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
            for (int j = 0; j < validAlignments.length; j++) {
                System.out.println((j + 1) + ". " + validAlignments[j]);
            }
            System.out.print("Alignment Selection: ");
            int alignmentOption = scanner.nextInt();
            String alignment = validAlignments[alignmentOption - 1];


            characters[i] = new Character(name, ancestry, characterClass, gender, alignment,
                    character.strength, character.dexterity, character.constitution, character.intelligence, character.wisdom, character.charisma);
        }


        System.out.println("\nCharacter(s) Successfully Created with the following information:");
        for (int i = 0; i < numCharacters; i++) {
            System.out.println("Name: " + characters[i].name);
            System.out.println("Stats:");
            characters[i].displayStats();
            System.out.println("Ancestry: " + characters[i].ancestry);
            System.out.println("Class: " + characters[i].characterClass);
            System.out.println("Gender: " + characters[i].gender);
            System.out.println("Alignment: " + characters[i].alignment);
            System.out.println();
        }

        System.out.println("Thank you and have a nice day!");
        scanner.close();
    }
}
