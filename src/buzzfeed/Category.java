package buzzfeed;

public class Category {
    String label;
    String description; 
    int points = 0;

    Category(String c, String description) {
        this.label = c;
        this.description = description;
    }
}
