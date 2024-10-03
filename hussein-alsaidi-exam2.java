import java.util.Scanner;

class Book {
    private double price;
    private String title;
    private String category;
    private String subCategory;
    private String author;
    private int internalInvoiceNumber;
    private String isbn;

    public Book() {
    }


    public Book(double price, String title, String category, String subCategory, String author, int internalInvoiceNumber, String isbn) {
        this.price = price;
        this.title = title;
        this.category = category;
        this.subCategory = subCategory;
        this.author = author;
        this.internalInvoiceNumber = internalInvoiceNumber;
        this.isbn = isbn;
    }


    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public String getAuthor() {
        return author;
    }

    public int getInternalInvoiceNumber() {
        return internalInvoiceNumber;
    }

    public String getIsbn() {
        return isbn;
    }


    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Price: $" + price);
        System.out.println("Category: " + category);
        System.out.println("Sub-Category: " + subCategory);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Internal Invoice Number: " + internalInvoiceNumber);
    }
}

public class BookStore {
    private static Book[] inventory = new Book[8];
    private static Book[] shoppingCart = new Book[20];
    private static int cartItemCount = 0;

    public static void main(String[] args) {
        initializeInventory();

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            displayMenu();
            choice = validateInput(scanner);
            scanner.nextLine();

            switch (choice) {
                case 1:
                    searchForBooks(scanner);
                    break;
                case 2:
                    buyBook(scanner);
                    break;
                case 3:
                    displayCart();
                    break;
                case 4:
                    emptyCart();
                    break;
                case 5:
                    checkout(scanner);
                    break;
                case 6:
                    System.out.println("Thank you for visiting our store. Please come again soon!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }


    private static void displayMenu() {
        System.out.println("Welcome to HFC Books Unlimited!");
        System.out.println("Please select from the options below:");
        System.out.println("1. Search for a book");
        System.out.println("2. Buy Book");
        System.out.println("3. Display Cart Contents");
        System.out.println("4. Empty Cart Contents");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");
        System.out.print("Selection: ");
    }


    private static void initializeInventory() {
        inventory[0] = new Book(39.49, "The Lord of the Rings Trilogy", "Fiction", "Fantasy", "J. R. R. Tolkien", 1, "978-0345538376");
        inventory[1] = new Book(114.99, "The Expanse Series", "Fiction", "Science Fiction", "James S A Corey", 2, "978-0678452547");
        inventory[2] = new Book(11.34, "Harry Potter and the Sorcerer’s Stone", "Fiction", "Fantasy", "J. K. Rowling", 3, "059035342X");
        inventory[3] = new Book(25.62, "Star Wars – The Thrawn Trilogy", "Fiction", "Science Fiction", "Timothy Zahn", 4, "B003H2C53");
        inventory[4] = new Book(32.06, "Dungeons and Dragons 5th Edition Player’s Handbook", "Fiction", "Game Manual", "Various", 5, "978-0786965601");
        inventory[5] = new Book(36.11, "Pathfinder Second Edition Core Rulebook", "Fiction", "Game Manual", "Various", 6, "978-1640781689");
        inventory[6] = new Book(25.49, "Pathfinder Second Edition Gamemastery Guide", "Fiction", "Game Manual", "Various", 7, "978-1640781986");
        inventory[7] = new Book(33.99, "Starfinder Core Rulebook", "Fiction", "Game Manual", "Various", 8, "978-160125956");
    }


    private static void searchForBooks(Scanner scanner) {
        System.out.println("Please enter search criteria:");
        System.out.println("1. Fantasy");
        System.out.println("2. Game Manual");
        System.out.println("3. Science Fiction");
        System.out.println("4. All books in stock");
        System.out.println("5. Back to main menu");
        System.out.println("Selection:");
        int criteria = validateInput(scanner);
        scanner.nextLine();

        switch (criteria) {
            case 1:
                searchBySubCategory("Fantasy");
                break;
            case 2:
                searchBySubCategory("Game Manual");
                break;
            case 3:
                searchBySubCategory("Science Fiction");
                break;
            case 4:
                displayAllBooks();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }


    private static void searchBySubCategory(String subCategory) {
        System.out.println("Books in sub-category: " + subCategory);
        for (Book book : inventory) {
            if (book.getSubCategory().equals(subCategory)) {
                book.displayBook();
                System.out.println();
            }
        }
    }


    private static void displayAllBooks() {
        System.out.println("All books in inventory:");
        for (Book book : inventory) {
            book.displayBook();
            System.out.println();
        }
    }


    private static void buyBook(Scanner scanner) {
        System.out.print("Please enter the Internal Invoice Number of the book you would like to purchase: ");
        int invoiceNumber = validateInput(scanner);
        scanner.nextLine();

        boolean found = false;
        for (Book book : inventory) {
            if (book.getInternalInvoiceNumber() == invoiceNumber) {
                found = true;
                if (cartItemCount < shoppingCart.length) {
                    shoppingCart[cartItemCount++] = book;
                    System.out.println("Shopping Cart Contents:");
                    book.displayBook();
                    System.out.println();
                } else {
                    System.out.println("Sorry, the cart is full.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Book with invoice number " + invoiceNumber + " not found.");
        }
    }


    private static void displayCart() {
        if (cartItemCount == 0) {
            System.out.println("The Shopping Cart is Empty.");
            return;
        }

        System.out.println("Shopping Cart Contents:");
        for (int i = 0; i < cartItemCount; i++) {
            System.out.println("Item " + (i + 1) + ":");
            shoppingCart[i].displayBook();
            System.out.println();
        }
    }


    private static void emptyCart() {
        cartItemCount = 0;
        System.out.println("Shopping cart emptied successfully.");
    }

    private static void checkout(Scanner scanner) {
        if (cartItemCount == 0) {
            System.out.println("Your shopping cart is empty. Nothing to checkout.");
            return;
        }

        double subtotal = calculateSubtotal();
        double total = calculateTotal(subtotal);

        System.out.println("Sub-Total: $" + String.format("%.2f", subtotal));
        System.out.println("Total: $" + String.format("%.2f", total));

        displayCart();

        System.out.println("Do you wish to continue to checkout?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choice = validateInput(scanner);
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Thank you! Your order has been placed!");
                emptyCart();
                break;
            case 2:
                System.out.println("Returning to the main menu.");
                break;
            default:
                System.out.println("Invalid choice. Returning to the main menu.");
        }
    }


    private static double calculateSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < cartItemCount; i++) {
            subtotal += shoppingCart[i].getPrice();
        }
        return subtotal;
    }


    private static double calculateTotal(double subtotal) {
        return subtotal * 1.06;
    }

    private static int validateInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        int choice = scanner.nextInt();
        if (choice < 1 || choice > 6) {
            System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            return validateInput(scanner);
        }
        return choice;
    }
}
