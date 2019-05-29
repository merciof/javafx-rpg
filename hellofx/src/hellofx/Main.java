 package hellofx;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    
    private TextArea output = new TextArea();
    
    @Override
    public void start(Stage stage) throws Exception {
         stage.setScene(new Scene(createContent()));
         stage.show();
    }
    
    private Parent createContent() {
        
        VBox root = new VBox(10);
        
        root.setPrefSize(800, 600);
        
        root.setPadding(new Insets(15));
        
        output.setPrefHeight(540);
        output.setFont(Font.font(25));
        
        Button btnAttack = new Button("Attack");
        btnAttack.setOnAction(e -> makeMove(Action.ATTACK));
        
        Button btnCharge = new Button("CHARGE");
        btnCharge.setOnAction(e -> makeMove(Action.CHARGE));
        
        Button btnBlock = new Button("BLOCK");
        btnBlock.setOnAction(e -> makeMove(Action.BLOCK));
        
        root.getChildren().addAll(btnAttack, btnCharge, btnBlock, output);
        
        return root;
    }
    
    
    private void makeMove(Action userAction) {
        Action aiAction = makeAiMove();
        
        ActionResult result = userAction.checkAgainst(aiAction);
        
        if(result == ActionResult.DRAW) {
            output.appendText("DRAW\n");
        } else if(result == ActionResult.WIN) {
            output.appendText("WIN\n");
        } else { //LOSE
            output.appendText("LOSE\n");
        }
        
    }
    
    private Action makeAiMove() {
        return Action.values()[(int) (Math.random() * Action.values().length)];
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}
