package com.example.w22comp1008lhw3;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DealHandOfCardsController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView deckImageView;

    @FXML
    private VBox deckVBox;


    private DeckOfCards deck;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deck = new DeckOfCards();
        deck.shuffle();
    }

    /**
     * This is connected to the button and will deal cards when ever the button
     * is pushed
     */
    @FXML
    private void dealCards()
    {
        ArrayList<Card> hand = new ArrayList<>();

        //deal out the top 5 cards into the hand
        for (int i=1; i<=5; i++)
        {
            Card card = deck.dealTopCard();
            if (card == null)
            {
                deckImageView.setVisible(false);
                break;
            }

            hand.add(card);  //this isn't truly necessary for this view only approach,
                             //but if you were creating a game, this is how you would give the hand
                             //to a player

            //create new ImageView object and add to the anchor pane
            ImageView imageView = new ImageView();
            imageView.setFitWidth(190);
            imageView.setFitHeight(287);

            //get the position of the upper left corner of the deck of cards
            Bounds boundsForImageView = deckImageView.localToScene(deckImageView.getBoundsInLocal());
            double deckPositionX = boundsForImageView.getMinX();
            double deckPositionY = boundsForImageView.getMinY();
            System.out.println(deckPositionX + "," + deckPositionY);

            //configure the new Card object to be positioned on top of the deck of cards
            imageView.setLayoutX(deckPositionX);
            imageView.setLayoutY(deckPositionY);

            //add the image to the newly created Card
            imageView.setImage(new Image(getClass().getResource("images/redCardBack.png").toExternalForm()));

            //add the new Card image to the anchor pane
            anchorPane.getChildren().add(imageView);

            //animate the card to slide across the table
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(imageView);
            transition.setDuration(Duration.millis(2000));
            transition.setByX(300 + (i*50));
            transition.play();

            //add a "event handler" for a mouse click on the imageview holding the card
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    imageView.setImage(card.getCardImage());
                }
            });
        }
    }
}
