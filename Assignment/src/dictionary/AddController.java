package dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import struct.Dictionary;

import java.util.Optional;

public class AddController {
    @FXML
    private TextArea txtExplain;
    @FXML
    private TextField txtWord;
    @FXML
    private Button btnCancel, btnSub;

    public void SubAction() {
        Optional<ButtonType> result = Message.Confirmation("add this word");
        if (DictionaryManagement.searchWord(txtWord.getText()) != null) {
            Message.Error(txtWord.getText() + " is exist");
        } else {
            if (result.get() == ButtonType.OK) {
                DictionaryManagement.addWord(txtWord.getText(), txtExplain.getText());
                Message.Success("Done!!!");
            }
        }
    }


    public void CancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
