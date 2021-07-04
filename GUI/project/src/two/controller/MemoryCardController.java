package two.controller;

import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.util.Duration;
import two.model.MemoryCard;
import two.model.Score;
import two.model.Time;
import two.view.MemoryCardView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class MemoryCardController {

    private final List<ImageView> imageViews, cardsMatched;
    private final List<MemoryCard> memoryCards;

    private final MemoryCardView memoryCardView;
    private int cardsClicked, id1;
    private ImageView imageView1, imageView2;
    private MemoryCard memoryCard1, memoryCard2;
    private final ScoreController scoreController;
    private final TimeController timeController;

    @FXML
    private GridPane gridPane;
    @FXML
    protected Label matchedCardsLabel, timeLabel;

    public MemoryCardController() {
        imageViews = new ArrayList<>();
        cardsMatched = new ArrayList<>();
        memoryCards = new ArrayList<>();

        memoryCardView = new MemoryCardView();

        scoreController = new ScoreController(new Score());

        timeController = new TimeController(new Time(0), this);
        timeController.initialize();
    }

    public void newGame() {
        prepareImageViews(imageViews);
        prepareMemoryCards(memoryCards);
        Collections.shuffle(imageViews);
        setImageViewsToMemoryCards(imageViews, memoryCards);

        initializeMemoryCardClickListener();
    }

    public void initializeMemoryCardClickListener() {
        for (int i = 0; i < imageViews.size(); i++) {
            final ImageView imageView = imageViews.get(i);
            final MemoryCard memoryCard = memoryCards.get(i);
            imageViews.get(i).setOnMouseClicked(mouseEvent -> memoryCardClick(imageView, memoryCard));
        }
    }

    public void memoryCardClick(final ImageView imageView, final MemoryCard memoryCard) {
        cardsClicked++;
        imageView.setDisable(true);

        final ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.4), imageView);
        scaleTransition.setToX(-1);
        scaleTransition.setFromX(0.1);
        scaleTransition.play();
        scaleTransition.setOnFinished(event -> {
            imageView.setScaleX(1);
            imageView.setImage(memoryCard.getImage());
        });

        if (cardsClicked == 1) {
            id1 = memoryCard.getId();
            imageView1 = imageView;
            memoryCard1 = memoryCard;
        } else {
            int id2 = memoryCard.getId();
            imageView2 = imageView;
            memoryCard2 = memoryCard;

            disableAllImageViews();

            if (id2 == id1) {
                scoreController.updateCardsMatched();
                matchedCardsLabel.setText("Matched cards: " + scoreController.getScore().getCardsMatched());
                cardsMatched.add(imageView1);
                cardsMatched.add(imageView2);

                final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.7), event -> {
                    imageView1.setDisable(true);
                    imageView1.setOpacity(0.2);

                    imageView2.setDisable(true);
                    imageView2.setOpacity(0.2);

                    enableAllImageViewsAndDisableAllCardsMatched();
                }));
                timeline.play();
            } else {
                final Timeline timeline = new Timeline(
                        new KeyFrame(
                                Duration.seconds(2),
                                event -> {
                                    imageView1.setImage(memoryCard1.getBackgroundImage());
                                    imageView1.setDisable(false);

                                    imageView2.setImage(memoryCard2.getBackgroundImage());
                                    imageView2.setDisable(false);

                                    enableAllImageViewsAndDisableAllCardsMatched();
                                }
                        )
                );
                timeline.play();
            }
            //Finish the game
            if (memoryCardView.getSize() == cardsMatched.size()) {
                final Timeline timeline = new Timeline(
                        new KeyFrame(
                                Duration.seconds(1),
                                event -> endGame()
                        )
                );
                timeline.play();
            }
            cardsClicked = 0;
        }
    }

    public void endGame() {
        imageViews.forEach(imageView -> gridPane.getChildren().remove(imageView));

        final Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game ended!");
        alert.setHeaderText("All cards matched.");
        alert.setContentText("Thank you for playing.");
        alert.show();

        timeController.stop();
    }

    public void enableAllImageViewsAndDisableAllCardsMatched() {
        for (final ImageView imageView : imageViews) {
            imageView.setDisable(false);
        }

        for (final ImageView foundCard : cardsMatched) {
            foundCard.setDisable(true);
        }
    }

    public void disableAllImageViews() {
        for (final ImageView imageView : imageViews) {
            imageView.setDisable(true);
        }
    }

    public void prepareImageViews(final List<ImageView> imageViews) {
        gridPane.setVgap(11);
        gridPane.setHgap(11);

        for (int i = 0; i < memoryCardView.getColumns(); i++) {
            gridPane.getColumnConstraints().add(new ColumnConstraints(memoryCardView.getImageWidth()));
        }

        for (int i = 0; i < memoryCardView.getRows(); i++) {
            gridPane.getRowConstraints().add(new RowConstraints(memoryCardView.getImageHeight()));
        }

        for (int i = 0; i < memoryCardView.getRows(); i++) {
            for (int j = 0; j < memoryCardView.getColumns(); j++) {
                final ImageView imageView = new ImageView();
                imageView.setFitWidth(memoryCardView.getImageWidth());
                imageView.setFitHeight(memoryCardView.getImageHeight());
                gridPane.add(imageView, j, i);
                imageViews.add(imageView);
            }
        }
    }

    public void prepareMemoryCards(final List<MemoryCard> memoryCards) {
        int j = 0;
        int id = 0;

        for (int i = 1; i <= memoryCardView.getSize(); i++) {
            if (i % 2 == 1) {
                j++;
                id++;
            }

            memoryCards.add(
                    new MemoryCard(
                            new Image("/images/cards/" + j + ".png"),
                            new Image("/images/cardBackground.png"),
                            id
                    )
            );
        }
    }

    public void setImageViewsToMemoryCards(final List<ImageView> imageViews, final List<MemoryCard> memoryCards) {
        IntStream.range(0, imageViews.size()).forEach(i -> imageViews.get(i).setImage(memoryCards.get(i).getBackgroundImage()));
    }
}
