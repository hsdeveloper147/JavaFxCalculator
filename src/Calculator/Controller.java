package Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.*;

public class Controller {

    @FXML
    private Label result;
    private long number1=0;
    private String operator="";
    private boolean start = true;
    private Model model = new Model();

    @FXML
    public void processNumber(ActionEvent actionEvent){
        if(start){
            result.setText("");
            start = false;
        }
        String val = ((javafx.scene.control.Button) actionEvent.getSource()).getText();
        result.setText(result.getText() + val);
    }

    @FXML
    public void processOperator(ActionEvent actionEvent){

        String val = ((Button) actionEvent.getSource()).getText();
        if(val.isEmpty()) return;
        if(start) return;
        if(!val.equals("=")){
            if(!operator.isEmpty()){
                return;
            }

            operator = val;
            number1 = Long.parseLong(result.getText());
            result.setText("");
        }
        else {
            if(operator.isEmpty()){
                return;
            }
            long number2 = Long.parseLong(result.getText());
            float out = model.calculate(number1,number2,operator);
            result.setText(String.valueOf(out));

            operator = "";
            start = true;
        }
    }
}
