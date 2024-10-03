import java.util.Scanner;

public class Character {
    private String name;
    private String ancestry;
    private String characterClass;
    private String gender;
    private String alignment;

    public Character() {}

    public Character(String name, String ancestry, String characterClass, String gender, String alignment) {
        this.name = name;
        this.ancestry = ancestry;
        this.characterClass = characterClass;
        this.gender = gender;
        this.alignment = alignment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAncestry() {
        return ancestry;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public void displayCharacterInfo() {
        System.out.println("Character Name: " + name);
        System.out.println("Ancestry: " + ancestry);
        System.out.println("Class: " + characterClass);
        System.out.println("Gender: " + gender);
        System.out.println("Alignment: " + alignment);
    }

    public boolean verifyEntries() {
        String[] validAncestries = {"Dragonborn", "Dwarf", "Elf", "Gnome", "Goblin", "Halfling", "Half-Elf", "Half-Orc", "Human", "Tiefling"};
        boolean validAncestry = false;
        for (String validAncestryOption : validAncestries) {
            if (ancestry.equalsIgnoreCase(validAncestryOption)) {
                validAncestry = true;
                break;
            }
        }

        String[] validClasses = {"Alchemist", "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Paladin", "Ranger", "Rogue", "Sorcerer", "Witch", "Wizard"};
        boolean validClass = false;
        for (String validClassOption : validClasses) {
            if (characterClass.equalsIgnoreCase(validClassOption)) {
                validClass = true;
                break;
            }
        }


        String[] validGenders = {"Male", "Female", "Non-Binary"};
        boolean validGender = false;
        for (String validGenderOption : validGenders) {
            if (gender.equalsIgnoreCase(validGenderOption)) {
                validGender = true;
                break;
            }
        }

        String[] validAlignments = {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
        boolean validAlignment = false;
        for (String validAlignmentOption : validAlignments) {
            if (alignment.equalsIgnoreCase(validAlignmentOption)) {
                validAlignment = true;
                break;
            }
        }

        return validAncestry && validClass && validGender && validAlignment;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the HFC Roleplaying Game!");
        System.out.println("Please enter the following information for character generation:");

        System.out.print("Character Name: ");
        String name = scanner.nextLine();

        System.out.println("Ancestry:");
        String[] validAncestries = {"Dragonborn", "Dwarf", "Elf", "Gnome", "Goblin", "Halfling", "Half-Elf", "Half-Orc", "Human", "Tiefling"};
        for (int i = 0; i < validAncestries.length; i++) {
            System.out.println((i + 1) + ". " + validAncestries[i]);
        }
        System.out.print("Ancestry Selection: ");
        int ancestryOption = scanner.nextInt();
        String ancestry = validAncestries[ancestryOption - 1];

        System.out.println("\nClass:");
        String[] validClasses = {"Alchemist", "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Paladin", "Ranger", "Rogue", "Sorcerer", "Witch", "Wizard"};
        for (int i = 0; i < validClasses.length; i++) {
            System.out.println((i + 1) + ". " + validClasses[i]);
        }
        System.out.print("Class Selection: ");
        int classOption = scanner.nextInt();
        String characterClass = validClasses[classOption - 1];

        System.out.println("\nGender:");
        String[] validGenders = {"Male", "Female", "Non-Binary"};
        for (int i = 0; i < validGenders.length; i++) {
            System.out.println((i + 1) + ". " + validGenders[i]);
        }
        System.out.print("Gender Selection: ");
        int genderOption = scanner.nextInt();
        String gender = validGenders[genderOption - 1];

        System.out.println("\nAlignment:");
        String[] validAlignments = {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
        for (int i = 0; i < validAlignments.length; i++) {
            System.out.println((i + 1) + ". " + validAlignments[i]);
        }
        System.out.print("Alignment Selection: ");
        int alignmentOption = scanner.nextInt();
        String alignment = validAlignments[alignmentOption - 1];

        Character character = new Character(name, ancestry, characterClass, gender, alignment);

        if (character.verifyEntries()) {
            System.out.println("\nCharacter created successfully:");
            character.displayCharacterInfo();
        } else {
            System.out.println("\nInvalid entries! Please enter valid options.");
        }
        System.out.println("Thank you, have a great day!");


        scanner.close();
    }
}
