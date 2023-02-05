package College;
import java.util.Scanner;
public class Library_Management {
    class Book {

    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;
    Scanner input = new Scanner(System.in);
    public Book()
    {
        System.out.println("Enter Serial No of Book:");
        this.sNo = input.nextInt();
        input.nextLine();
 
        System.out.println("Enter Book Name:");
        this.bookName = input.nextLine();
 
        System.out.println("Enter Author Name:");
        this.authorName = input.nextLine();
 
        System.out.println("Enter Quantity of Books:");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;
    }
}
    class Books {
 
    // Class data members
    Book theBooks[] = new Book[50];
    public static int count;
 
    Scanner input = new Scanner(System.in);
 
    // Method 1
    //  To compare books
    public int compareBookObjects(Book b1, Book b2)
    {
        if (b1.bookName.equalsIgnoreCase(b2.bookName)) {
            System.out.println(
                "Book of this Name Already Exists.");
            return 0;
        }
        if (b1.sNo == b2.sNo) {
            System.out.println(
                "Book of this Serial No Already Exists.");
 
            return 0;
        }
        return 1;
    }
 
    // Method 2
    // To add book
    public void addBook(Book b)
    {
 
        for (int i = 0; i < count; i++) {
 
            if (this.compareBookObjects(b, this.theBooks[i])
                == 0)
                return;
        }
 
        if (count < 50) {
 
            theBooks[count] = b;
            count++;
        }
        else {
 
            System.out.println(
                "No Space to Add More Books.");
        }
    }
 
    // Method 3
    // To search book by serial number
    public void searchBySno()
    {
        System.out.println(
            "\t\t\t\tSEARCH BY SERIAL NUMBER\n");
        int sNo;
        System.out.println("Enter Serial No of Book:");
        sNo = input.nextInt();
 
        int flag = 0;
        System.out.println(
            "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
 
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.println(
                    theBooks[i].sNo + "\t\t"
                    + theBooks[i].bookName + "\t\t"
                    + theBooks[i].authorName + "\t\t"
                    + theBooks[i].bookQtyCopy + "\t\t"
                    + theBooks[i].bookQty);
                flag++;
                return;
            }
        }
        if (flag == 0)
            System.out.println("No Book for Serial No "
                               + sNo + " Found.");
    }
 
    // Method 4
    // To search author by name
    public void searchByAuthorName()
    {
 
        // Display message
        System.out.println(
            "\t\t\t\tSEARCH BY AUTHOR'S NAME");
 
        input.nextLine();
 
        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();
 
        int flag = 0;
 
        System.out.println(
            "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
 
        for (int i = 0; i < count; i++) {
            if (authorName.equalsIgnoreCase(
                    theBooks[i].authorName)) {
                System.out.println(
                    theBooks[i].sNo + "\t\t"
                    + theBooks[i].bookName + "\t\t"
                    + theBooks[i].authorName + "\t\t"
                    + theBooks[i].bookQtyCopy + "\t\t"
                    + theBooks[i].bookQty);
                flag++;
            }
        }
        if (flag == 0)
            System.out.println("No Books of " + authorName
                               + " Found.");
    }
 
    // Method 5
    // To display all books
    public void showAllBooks()
    {
 
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println(
            "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
 
        for (int i = 0; i < count; i++) {
 
            System.out.println(
                theBooks[i].sNo + "\t\t"
                + theBooks[i].bookName + "\t\t"
                + theBooks[i].authorName + "\t\t"
                + theBooks[i].bookQtyCopy + "\t\t"
                + theBooks[i].bookQty);
        }
    }
 
    // Method 6
    // To edit the book
    public void upgradeBookQty()
    {
 
        System.out.println(
            "\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");
 
        int sNo = input.nextInt();
 
        for (int i = 0; i < count; i++) {
 
            if (sNo == theBooks[i].sNo) {
 
                // Display message
                System.out.println(
                    "Enter No of Books to be Added:");
 
                int addingQty = input.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;
 
                return;
            }
        }
    }
 
    // Method 7
    // To create menu
    public void dispMenu()
    {
 
        // Displaying menu
        System.out.println(
            "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 0 to Exit Application.");
        System.out.println(
            "Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println(
            "Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book. ");
        System.out.println("Press 8 to Check In Book");
        System.out.println(
            "-------------------------------------------------------------------------------------------------------");
    }
 
    // Method 8
    // To search the library
    public int isAvailable(int sNo)
    {
 
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                if (theBooks[i].bookQtyCopy > 0) {
 
                    System.out.println(
                        "Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }
 
        System.out.println("No Book of Serial Number "
                           + " Available in Library.");
        return -1;
    }
 
    // Method 9
    // To remove the book from the library
    public Book checkOutBook()
    {
 
        System.out.println(
            "Enter Serial No of Book to be Checked Out.");
        int sNo = input.nextInt();
 
        int bookIndex = isAvailable(sNo);
 
        if (bookIndex != -1) {
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }
 
    // Method 10
    // To add the Book to the Library
    public void checkInBook(Book b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBooks[i])) {
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
}
    class Student {
    String studentName;
    String regNum;
 
    College.Book borrowedBooks[] = new College.Book[3];
    public int booksCount = 0;
    Scanner input = new Scanner(System.in);
    public Student()
    {
        // Print statement
        System.out.println("Enter Student Name:");
        this.studentName = input.nextLine();
        System.out.println("Enter Registration Number:");
        this.regNum = input.nextLine();
    }
}
    class Students {
    Scanner input = new Scanner(System.in);
    College.Student theStudents[] = new College.Student[50];
 
    public static int count = 0;
 
    // Method 1
    // To add students
    public void addStudent(College.Student s)
    {
        for (int i = 0; i < count; i++) {
 
            if (s.regNum.equalsIgnoreCase(
                    theStudents[i].regNum)) {
 
                // Print statement
                System.out.println(
                    "Student of Reg Num " + s.regNum
                    + " is Already Registered.");
 
                return;
            }
        }
 
        if (count <= 50) {
            theStudents[count] = s;
            count++;
        }
    }
 
    // Method 2
    // Displaying all students
    public void showAllStudents()
    {
        System.out.println("Student Name\t\tReg Number");
        for (int i = 0; i < count; i++) {
 
            System.out.println(theStudents[i].studentName
                               + "\t\t"
                               + theStudents[i].regNum);
        }
    }
 
    // Method 3
    // To check the Student
    public int isStudent()
    {
        System.out.println("Enter Reg Number:");
 
        String regNum = input.nextLine();
 
        for (int i = 0; i < count; i++) {
 
            if (theStudents[i].regNum.equalsIgnoreCase(
                    regNum)) {
                return i;
            }
        }
        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");
 
        return -1;
    }
 
    // Method 4
    // To remove the book
    public void checkOutBook(College.Books book)
    {
        int studentIndex = this.isStudent();
 
        if (studentIndex != -1) {
            System.out.println("checking out");
 
            book.showAllBooks();
            College.Book b = book.checkOutBook();
 
            System.out.println("checking out");
            if (b != null) {
 
                if (theStudents[studentIndex].booksCount
                    <= 3) {
 
                    System.out.println("adding book");
                    theStudents[studentIndex].borrowedBooks
                        [theStudents[studentIndex]
                             .booksCount]
                        = b;
                    theStudents[studentIndex].booksCount++;
 
                    return;
                }
                else {
 
                    System.out.println(
                        "Student Can not Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }
 
    // Method 5
    // To add the book
    public void checkInBook(College.Books book)
    {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            System.out.println(
                "S.No\t\t\tBook Name\t\t\tAuthor Name");
 
            College.Student s = theStudents[studentIndex];
 
            for (int i = 0; i < s.booksCount; i++) {
 
                System.out.println(
                    s.borrowedBooks[i].sNo + "\t\t\t"
                    + s.borrowedBooks[i].bookName + "\t\t\t"
                    + s.borrowedBooks[i].authorName);
            }
            System.out.println(
                "Enter Serial Number of Book to be Checked In:");
 
            int sNo = input.nextInt();
 
            for (int i = 0; i < s.booksCount; i++) {
                if (sNo == s.borrowedBooks[i].sNo) {
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;
 
                    return;
                }
            }
 
            System.out.println("Book of Serial No " + sNo
                               + "not Found");
        }
    }
}

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
 
        // Displaying menu
        System.out.println(
            "********************Welcome to the Library!********************");
        System.out.println(
            "                  Select From The Following Options:               ");
        System.out.println(
            "**********************************************************************");
 
        // Creating object of book class
        College.Books ob = new College.Books();
        // Creating object of students class
        College.Students obStudent = new College.Students();
 
        int choice;
        int searchChoice;
 
        // Creating menu
        // using do-while loop
        do {
 
            ob.dispMenu();
            choice = input.nextInt();
            switch (choice){
            case 1:
                College.Book b = new College.Book();
                ob.addBook(b);
                break;
            case 2:
                ob.upgradeBookQty();
                break;
            case 3:
 
                System.out.println(
                    " press 1 to Search with Book Serial No.");
                System.out.println(
                    " Press 2 to Search with Book's Author Name.");
                searchChoice = input.nextInt();
                switch (searchChoice) {
                case 1:
                    ob.searchBySno();
                    break;
                case 2:
                    ob.searchByAuthorName();
                }
                break;
            case 4:
                ob.showAllBooks();
                break;
            case 5:
                College.Student s = new College.Student();
                obStudent.addStudent(s);
                break;
            case 6:
                obStudent.showAllStudents();
                break;
            case 7:
                obStudent.checkOutBook(ob);
                break;
            case 8:
                obStudent.checkInBook(ob);
                break;
 
                // Default case that will execute for sure
                // if above cases does not match
            default:
                System.out.println("ENTER BETWEEN 0 TO 8.");
            }
 
        }
        while (choice != 0);
    }
}




