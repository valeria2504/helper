package com.example.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

import java.sql.*;
import javafx.event.ActionEvent;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.json.JSONObject;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HelloController {

    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;


    @FXML
    private GridPane GridPaneTTT;


    @FXML
    protected AnchorPane anchorpaneChatGPT;
    @FXML
    private AnchorPane anchorpaneMenu;
    @FXML
    protected AnchorPane anchorpaneWeather;
    @FXML
    protected AnchorPane anchorpaneTicTacToe;
    @FXML
    protected AnchorPane anchorpaneCalculator;
    @FXML
    protected AnchorPane anchorpaneNotes;
    @FXML
    protected AnchorPane anchorpaneNotes2;


    @FXML
    protected Button btnLogIn;
    @FXML
    protected Button btnSaveNotes;
    @FXML
    protected Button btnNotes;
    @FXML
    protected Button btnAdd;
    @FXML
    protected Button btnBracket1;
    @FXML
    protected Button btnBracket2;
    @FXML
    protected Button btnCalculator;
    @FXML
    protected Button btnDelete;
    @FXML
    protected Button btnDiv;
    @FXML
    protected Button btnMul;
    @FXML
    protected Button btnNum0;
    @FXML
    protected Button btnNum1;
    @FXML
    protected Button btnNum2;
    @FXML
    protected Button btnNum3;
    @FXML
    protected Button btnNum4;
    @FXML
    protected Button btnNum5;
    @FXML
    protected Button btnNum6;
    @FXML
    protected Button btnNum7;
    @FXML
    protected Button btnNum8;
    @FXML
    protected Button btnNum9;
    @FXML
    protected Button btnNumDot;
    @FXML
    protected Button btnNew;
    @FXML
    protected Button btnResult;
    @FXML
    protected Button btnSub;
    @FXML
    protected Button btnTTT1, btnTTT2, btnTTT3, btnTTT4, btnTTT5, btnTTT6, btnTTT7, btnTTT8, btnTTT9;
    @FXML
    private Button btnTicTacToe;
    @FXML
    protected Button btn3;
    @FXML
    private Button btnChatGPT;
    @FXML
    private Button btnEnterChatGPT;
    @FXML
    protected Button btnEnterWeather;
    @FXML
    private Button btnWeather;
    @FXML
    private Button btnNewgame;
    @FXML
    private Button btnTTTnext;


    @FXML
    protected Label labelClouds;
    @FXML
    protected Label labelPrecipitation;
    @FXML
    protected Label labelTemperature;
    @FXML
    protected Label labelWind;
    @FXML
    protected Label labelCalculatorResult;


    @FXML
    protected Pane paneEnd;


    @FXML
    private TextArea textareaChatGPT;
    @FXML
    protected TextArea textareaNotes;


    @FXML
    protected Text textEnd;
    @FXML
    protected Text textScoreO;
    @FXML
    protected Text textScoreX;
    @FXML
    protected Text textNotesError;

    @FXML
    private TextField textfieldChatGPT;
    @FXML
    protected TextField textfieldWeather;
    @FXML
    protected TextField textfieldPassword;
    @FXML
    protected TextField textfieldFirstName;
    @FXML
    protected TextField textfieldLastName;


    @FXML
    protected ImageView imageCloud1;
    @FXML
    protected ImageView imageCloud2;
    @FXML
    protected ImageView imageCloud11;
    @FXML
    protected ImageView imageCloud22;


    //TIC TAC TOE
    @FXML
    void clickbtnTicTacToe(ActionEvent event) {
    }

    @FXML
    void btnTTTclick(ActionEvent event) {
    }

    @FXML
    void clickbtnTTTnext(ActionEvent event) {

    }

    @FXML
    void clickbtnNewgame(ActionEvent event) {
    }

    //CHAT GPT
    @FXML
    void clickbtnChatGPT(ActionEvent event) {

    }

    @FXML
    void clickbtnEnterChatGPT(ActionEvent event) {
    }

    //WEATHER
    @FXML
    void clickbtnWeather(ActionEvent event) {
    }

    @FXML
    void clickbtnEnterWeather(ActionEvent event) {
    }

    //CALCULATOR
    @FXML
    void clickbtnCalculator(ActionEvent event) {
    }

    @FXML
    void clickbtnResult(ActionEvent event) {
    }

    @FXML
    void clickbtnNew(ActionEvent event) {
    }

    @FXML
    void clickbtnDelete(ActionEvent event) {
    }

    @FXML
    void clickbtnAction(ActionEvent event) {
    }

    @FXML
    void clickbtnNum(ActionEvent event) {
    }

    @FXML
    void clickbtnParenthesis(ActionEvent event) {
    }

    //NOTES
    @FXML
    void clickbtnNotes(ActionEvent event) {
    }

    @FXML
    void clickbtnLogIn(ActionEvent event) {
    }

    @FXML
    void clickbtnSave(ActionEvent event) {
    }


    @FXML
    void initialize() {
    }
}





