package com.example.w22comp1008lhw3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CardViewController implements Initializable {

    @FXML
    private Label cardNameLabel;

    @FXML
    private Label faceNameLabel;

    @FXML
    private Label suitLabel;

    @FXML
    private Label cardValueLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cardNameLabel.setText("Ace of Spades");
    }
}