package two.model;


import javafx.scene.image.Image;

public class MemoryCard {

    private final int id;
    private final Image image;
    private final Image backgroundImage;

    public MemoryCard(final Image image, final Image backgroundImage, final int id) {
        this.image = image;
        this.backgroundImage = backgroundImage;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Image getImage() {
        return image;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }
}
