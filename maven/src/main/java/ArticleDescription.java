public class ArticleDescription {
    private final Size size;
    private final Color color;
    private final String description;

    public ArticleDescription(
            Size size, Color color, String description) {
        this.size = size;
        this.color = color;
        this.description = description;
    }

    public Size getSize() { return size; }
    public Color getColor() { return color; }
    public String getDescription() { return description; }

    public String toString() {
        return String.format("%s-colored %s in size %s",
                color, description, size);
    }
}
