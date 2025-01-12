package com.example.sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import org.json.JSONObject;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainController extends HelloController {

    protected ParallelTransition parallelTransition;
    protected final String mainURL = "http://api.openweathermap.org/data/2.5/weather?q=";
    protected final String myURL = "&appid=cf2a2d8b9159edee1a48582fbca44f62";

    protected int xScore = 0;
    protected int oScore = 0;
    protected char nowSymb = 'x';
    protected boolean isGame = true;
    protected char[][] Field = new char[3][3];
    protected boolean isWin = false;

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres"; // URL базы данных
    private static final String USER = "postgres"; // Логин
    private static final String PASSWORD = "Imola11!";// Пароль
    private final int nowID = 1;

    protected ArrayList<String> SymbolC = new ArrayList<String>();

    //TIC TAC TOE
    @Override
    void clickbtnTicTacToe(ActionEvent event) {
        super.clickbtnTicTacToe(event);
        anchorpaneChatGPT.setVisible(false);
        anchorpaneWeather.setVisible(false);
        anchorpaneTicTacToe.setVisible(true);
        anchorpaneCalculator.setVisible(false);
        anchorpaneNotes.setVisible(false);
    }

    @Override
    void clickbtnNewgame(ActionEvent event) {
        super.clickbtnNewgame(event);

        oScore = 0;
        xScore = 0;
        nextGame();

    }

    protected void nextGame(){

        nowSymb = 'x';
        textScoreO.setText("o: " + oScore);
        textScoreX.setText("x: " + xScore);
        isGame = true;
        isWin = false;

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                Field[i][j] = ' ';}
        }
        btnTTT1.setText("");
        btnTTT2.setText("");
        btnTTT3.setText("");
        btnTTT4.setText("");
        btnTTT5.setText("");
        btnTTT6.setText("");
        btnTTT7.setText("");
        btnTTT8.setText("");
        btnTTT9.setText("");
    }

    protected void endGame(){

        isGame = false;

        paneEnd.setVisible(true);

        if (isWin && nowSymb == 'x'){
            xScore++;
            textEnd.setText("X won!!!");
        }
        if (isWin && nowSymb == 'o'){
            oScore++;
            textEnd.setText("O won!!!");
        }
        if (!isWin) {
            textEnd.setText("Draw!");
        }
    }

    @Override
    void clickbtnTTTnext(ActionEvent event) {
        super.clickbtnTTTnext(event);

        nextGame();
        paneEnd.setVisible(false);

    }

    @Override
    void btnTTTclick(ActionEvent event) {
        super.btnTTTclick(event);

        // if you won or the button is not empty you can not set x or o
        Button btn = (Button) event.getSource();
        if(!isGame || btn.getText() != "") {
            return;
        }

        // change of nowSymb
        nowSymb = nowSymb == 'x' ? 'o' : 'x';

        // row and column
        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int columnIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);

        // put data about nowSymb into list
        Field[columnIndex][rowIndex] = nowSymb;

        // set nowSymb
        (btn).setText(String.valueOf(nowSymb));

        // vertical
        if (Field[0][0] == Field[0][1] && Field[0][0] == Field[0][2] && (Field[0][0] == 'x' || Field[0][0] == 'o')) {
            isWin = true;
            endGame();
        }
        if (Field[1][0] == Field[1][1] && Field[1][0] == Field[1][2] && (Field[1][0] == 'x' || Field[1][0] == 'o')) {
            isWin = true;
            endGame();
        }
        if (Field[2][0] == Field[2][1] && Field[2][0] == Field[2][2] && (Field[2][0] == 'x' || Field[2][0] == 'o')) {
            isWin = true;
            endGame();
        }

        // horizontal
        if (Field[0][0] == Field[1][0] && Field[0][0] == Field[2][0] && (Field[0][0] == 'x' || Field[0][0] == 'o')) {
            isWin = true;
            endGame();
        }
        if (Field[0][1] == Field[1][1] && Field[0][1] == Field[2][1] && (Field[0][1] == 'x' || Field[0][1] == 'o')) {
            isWin = true;
            endGame();
        }
        if (Field[0][2] == Field[1][2] && Field[0][2] == Field[2][2] && (Field[0][2] == 'x' || Field[0][2] == 'o')) {
            isWin = true;
            endGame();
        }

        // diagonal
        if (Field[0][0] == Field[1][1] && Field[0][0] == Field[2][2] && (Field[0][0] == 'x' || Field[0][0] == 'o')) {
            isWin = true;
            endGame();
        }
        if (Field[2][0] == Field[1][1] && Field[2][0] == Field[0][2] && (Field[2][0] == 'x' || Field[2][0] == 'o')) {
            isWin = true;
            endGame();
        }

        // draw
        if (btnTTT1.getText() != "" && btnTTT2.getText() != "" && btnTTT3.getText() != "" && btnTTT4.getText() != "" && btnTTT5.getText() != "" && btnTTT6.getText() != "" && btnTTT7.getText() != "" && btnTTT8.getText() != "" && btnTTT9.getText() != "" && !isWin) {
            endGame();
        }

    }


    //CHAT GPT
    @Override
    void clickbtnChatGPT(ActionEvent event) {
        super.clickbtnChatGPT(event);
        anchorpaneChatGPT.setVisible(true);
        anchorpaneWeather.setVisible(false);
        anchorpaneTicTacToe.setVisible(false);
        anchorpaneCalculator.setVisible(false);
        anchorpaneNotes.setVisible(false);
    }


    //WEATHER
    @Override
    void clickbtnWeather(ActionEvent event) {
        super.clickbtnEnterWeather(event);
        anchorpaneChatGPT.setVisible(false);
        anchorpaneWeather.setVisible(true);
        anchorpaneTicTacToe.setVisible(false);
        anchorpaneCalculator.setVisible(false);
        anchorpaneNotes.setVisible(false);
    }

    @Override
    void clickbtnEnterWeather(ActionEvent event) {
        super.clickbtnEnterWeather(event);

        // get sources from the text field
        String getUserCity = textfieldWeather.getText().trim();
        if (!getUserCity.equals("")) { // if input isn't empty
            // get sources from openweathermap
            String output = getUrlContent(mainURL + getUserCity + myURL);

            if (!output.isEmpty()) { // no mistake and city exists
                JSONObject obj = new JSONObject(output);
                // process JSON and set sources in the text field
                // transform Kelvin into Celsius
                double tempKelvin = obj.getJSONObject("main").getDouble("temp");
                double tempCelsius = tempKelvin - 273.15;
                labelTemperature.setText(String.format("%.1f°C", tempCelsius));
                // check if there is precipitation
                if (obj.has("rain")) {
                    labelPrecipitation.setText("rain " + obj.getJSONObject("rain").getDouble("1h") + "mm");
                } else if (obj.has("snow")) {
                    labelPrecipitation.setText("snow " + obj.getJSONObject("snow").getDouble("1h") + "mm");
                } else {
                    labelPrecipitation.setText("no precipitation");
                }
                labelWind.setText(obj.getJSONObject("wind").getDouble("speed") + "m/s");
                labelClouds.setText(obj.getJSONObject("clouds").getDouble("all") + "%");
            }
        }
    }

    // process URL address and get sources from them
    protected String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            labelTemperature.setText("city");
            labelClouds.setText("was");
            labelPrecipitation.setText("not");
            labelWind.setText("founded");
            System.out.println("City was not founded");
        }
        return content.toString(); 
    }


    //CALCULATOR
    @Override
    void clickbtnCalculator(ActionEvent event) {
        super.clickbtnCalculator(event);
        anchorpaneChatGPT.setVisible(false);
        anchorpaneWeather.setVisible(false);
        anchorpaneTicTacToe.setVisible(false);
        anchorpaneCalculator.setVisible(true);
        anchorpaneNotes.setVisible(false);
    }

    @Override
    void clickbtnResult(ActionEvent event) {
        super.clickbtnResult(event);

        getResult();
    }

    protected void getResult(){
        String equationS = labelCalculatorResult.getText();
        try {
            Expression expression = new ExpressionBuilder(equationS).build();
            int result = (int) expression.evaluate();
            labelCalculatorResult.setText(String.valueOf(result));
        } catch (Exception e) {
            System.out.println("Exception in getResult: " + e.getMessage());
        }
    }

    @Override
    void clickbtnDelete(ActionEvent event) {
        super.clickbtnDelete(event);

        try {
            if (labelCalculatorResult.getText() == "" || labelCalculatorResult.getText() == "Hi!"){
                return;
            }
            String nowText = labelCalculatorResult.getText();
            String newText = nowText.substring(0, nowText.length() - 1);
            SymbolC.removeLast();
            labelCalculatorResult.setText(newText);
        } catch (Exception e){
            if (e == null){
                labelCalculatorResult.setText("");
            }
            else {
                System.out.println("Exception in clickbtnDelete: " + e.getMessage());
            }
        }
    }

    @Override
    void clickbtnNew(ActionEvent event) {
        super.clickbtnNew(event);

        labelCalculatorResult.setText("Hi!");
        SymbolC.clear();
    }

    @Override
    void clickbtnAction(ActionEvent event) {
        super.clickbtnAction(event);

        if (labelCalculatorResult.getText().equals("Hi!") || SymbolC.size() == 25
            || Objects.equals(SymbolC.getLast(), "+") || Objects.equals(SymbolC.getLast(), "-")
            || Objects.equals(SymbolC.getLast(), "/") || Objects.equals(SymbolC.getLast(), "*")
            || Objects.equals(SymbolC.getLast(), "(") ){
            return;
        }
        String thisText = labelCalculatorResult.getText();
        Button btn = (Button) event.getSource();
        String nowText = (btn).getText();
        labelCalculatorResult.setText(thisText + nowText);

        String nowAction = (btn).getText();
        SymbolC.add(nowAction);

    }

    @Override
    void clickbtnParenthesis(ActionEvent event) {
        super.clickbtnParenthesis(event);

        if (SymbolC.size() == 25){
            return;
        }
        if (labelCalculatorResult.getText().equals("Hi!")){
            labelCalculatorResult.setText("");
        }

        String thisText = labelCalculatorResult.getText();
        Button btn = (Button) event.getSource();
        String nowText = (btn).getText();
        labelCalculatorResult.setText(thisText + nowText);

        String nowNumber = (btn).getText();
        SymbolC.add(nowNumber);
    }

    @Override
    void clickbtnNum(ActionEvent event) {
        super.clickbtnNum(event);

        if (SymbolC.size() == 25){
            return;
        }
        if (labelCalculatorResult.getText().equals("Hi!")){
            labelCalculatorResult.setText("");
        }

        String thisText = labelCalculatorResult.getText();
        Button btn = (Button) event.getSource();
        String nowText = (btn).getText();
        labelCalculatorResult.setText(thisText + nowText);

        String nowNumber = (btn).getText();
        SymbolC.add(nowNumber);

    }

    //NOTES
    @Override
    void clickbtnNotes(ActionEvent event) {
        super.clickbtnNotes(event);
        anchorpaneChatGPT.setVisible(false);
        anchorpaneWeather.setVisible(false);
        anchorpaneTicTacToe.setVisible(false);
        anchorpaneCalculator.setVisible(false);
        anchorpaneNotes.setVisible(true);
    }

    public void ProgresConnect(int pass, String first, String last){
        String insertSQL = "INSERT INTO users (id, first_name, last_name) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            if (connection != null) {
                System.out.println("Connected");
            }
            preparedStatement.setInt(1, pass);
            preparedStatement.setString(2, first);
            preparedStatement.setString(3, last);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data added");
            }
            textNotesError.setText("You are logged in!");
            textNotesError.setFill(Color.GREEN);

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")){
                textNotesError.setText("Password is already used, try another");
                textNotesError.setFill(Color.RED);
            }
            System.err.println("Connection error: " + e.getMessage());
        }
    }

    @Override
    void clickbtnLogIn(ActionEvent event) {
        super.clickbtnLogIn(event);

        try {
            int password = Integer.parseInt(textfieldPassword.getText());
            String firstName = textfieldFirstName.getText();
            String lastName = textfieldLastName.getText();

            if (Objects.equals(textfieldFirstName.getText(), "") || Objects.equals(textfieldLastName.getText(), "")) {
                textNotesError.setText("All fields must be filled");
                textNotesError.setFill(Color.RED);
                return;
            }
            if (textfieldPassword.getLength() != 8) {
                textNotesError.setText("The password must contain 8 numbers");
                textNotesError.setFill(Color.RED);
                return;
            }

            Integer.parseInt(textfieldPassword.getText());

            ProgresConnect(password, firstName, lastName);

        } catch (NumberFormatException e) {
            if (textfieldPassword.getLength() != 8){
                textNotesError.setText("The password must contain 8 numbers");
                textNotesError.setFill(Color.RED);
            }
            else {
                textNotesError.setText("The password can not contain letters or special characters");
                textNotesError.setFill(Color.RED);
            }

        } catch (Exception e) {
            System.out.println("Exception in btnLogin: " + e);
        }

    }

    @Override
    void initialize() {
        super.initialize();
        //new translated animation
        TranslateTransition imageCloud1Transition = new TranslateTransition(Duration.seconds(20), imageCloud1);
        imageCloud1Transition.setFromX(0); //beginning
        imageCloud1Transition.setToX(-476); //end
        imageCloud1Transition.setInterpolator(Interpolator.LINEAR); //type of moving

        TranslateTransition imageCloud2Transition = new TranslateTransition(Duration.seconds(20), imageCloud2);
        imageCloud2Transition.setFromX(0);
        imageCloud2Transition.setToX(-476);
        imageCloud2Transition.setInterpolator(Interpolator.LINEAR);

        TranslateTransition imageCloud11Transition = new TranslateTransition(Duration.seconds(20), imageCloud11);
        imageCloud11Transition.setFromX(0);
        imageCloud11Transition.setToX(-476);
        imageCloud11Transition.setInterpolator(Interpolator.LINEAR);

        TranslateTransition imageCloud22Transition = new TranslateTransition(Duration.seconds(20), imageCloud22);
        imageCloud22Transition.setFromX(0);
        imageCloud22Transition.setToX(-476);
        imageCloud22Transition.setInterpolator(Interpolator.LINEAR);

        //parallel transition of 4 transitions
        parallelTransition = new ParallelTransition(imageCloud1Transition, imageCloud11Transition, imageCloud2Transition, imageCloud22Transition);
        parallelTransition.setCycleCount(Animation.INDEFINITE);
        parallelTransition.play();
    }
}
