package hellofx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private void makeMove(Action action) {
    }

//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();
//    }


    private enum Action{
        ATTACK, CHARGE, BLOCK;
    }
    
    private enum ActionResult{
        WIN, LOSE, DRAW;
    }
    
    private Parent createContent(){
        VBox root = new VBox(10);
        
        Button btnAttack = new Button("Attack");
        btnAttack.setOnAction(e -> makeMove(Action.ATTACK));
        
        return root;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
         stage.setScene(new Scene(createContent()));
         stage.show();
    }

    public static void main(String[] args) {
        launch(args);
     
    }
}
