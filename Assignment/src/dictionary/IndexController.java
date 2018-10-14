package dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PopupControl;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import struct.Dictionary;

import java.awt.*;
import java.io.IOException;
import java.util.Optional;


public class IndexController {

    @FXML
    private Button btnEdit, btnDel, btnAudio;
    @FXML
    private TextField txtInput;
    @FXML
    private WebView viewExplain;
    static String textInput;
    public void searchAction(){
        textInput = txtInput.getText();
        if(textInput.isEmpty()){
            Message.Error("Please enter word");
        }
        //System.out.println(textInput);
        Dictionary result = DictionaryManagement.searchWord(textInput);
        if(result == null){
            Optional<ButtonType> result1 = Message.Confirmation(txtInput.getText() + " is not exist! Are you add this word ?");
            if (result1.get() == ButtonType.OK) {
                addAction();
            }
        }
        else{
            WebEngine webEngine = viewExplain.getEngine();
            webEngine.loadContent(result.getExplain());
            showButtonAction();
        }


    }
    public void showButtonAction(){
        btnAudio.setVisible(true);
        btnEdit.setVisible(true);
        btnDel.setVisible(true);
    }
    public void addAction(){
        Parent root1 ;
        Stage primaryStage = new Stage();
        try {
            root1 = FXMLLoader.load(getClass().getResource("addWord.fxml"));
            primaryStage.setTitle("Add new word");
            primaryStage.setScene(new Scene(root1));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void editAction(){
        Parent root1 = null;
        Stage primaryStage = new Stage();
        try {
            root1 = FXMLLoader.load(getClass().getResource("edit.fxml"));
            primaryStage.setTitle("Edit word");
            primaryStage.setScene(new Scene(root1));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void delAction(){

    }
//


}
