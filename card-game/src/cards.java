import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class cards extends Application {

    private int myLives = 20;
    private int computerLives = 20;
    Random rand = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub

        primaryStage.setTitle("Code Game");

        Text instructions = new Text("INSTRUCTIONS!");
        Text instructions1 = new Text("First to 0 loses!");
        Text instructions2 = new Text("Health = Lives + 1");
        Text instructions3 = new Text("Spell = Lives + ???");
        Text instructions4 = new Text("Attack = Computer Lives - ???");

        Text myLivesText = new Text("My lives:");
        Text computerLivesText = new Text("Computer lives:");
        Button healthButton = new Button("Health");
        Button spellButton = new Button("Spell");
        Button attackButton = new Button("Attack");

        BorderPane border = new BorderPane();
        HBox hbox = new HBox();
        border.setTop(hbox);
        VBox vbox = new VBox();
        border.setLeft(vbox);

        myLivesText.setLayoutX(0);
        myLivesText.setLayoutY(0);
        computerLivesText.setLayoutX(200);
        computerLivesText.setLayoutY(200);
        healthButton.setLayoutX(0);
        spellButton.setLayoutX(200);
        attackButton.setLayoutX(300);
        healthButton.setLayoutY(0);
        spellButton.setLayoutY(200);
        attackButton.setLayoutY(300);

        healthButton.setMaxSize(200, 100);
        spellButton.setMaxSize(200, 100);
        attackButton.setMaxSize(200, 100);

        vbox.getChildren().add(myLivesText);
        vbox.getChildren().add(computerLivesText);
        hbox.getChildren().add(healthButton);
        hbox.getChildren().add(spellButton);
        hbox.getChildren().add(attackButton);

        // Add instructions to the window
        vbox.getChildren().add(instructions);
        vbox.getChildren().add(instructions1);
        vbox.getChildren().add(instructions2);
        vbox.getChildren().add(instructions3);
        vbox.getChildren().add(instructions4);

        Scene scene = new Scene(border, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();

        healthButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                // Add 1 to the user's lives
                myLives = myLives + 1;

                if (myLives <= 0) {
                    System.out.println("You have lost!");
                    Text loserText = new Text("You lose!");
                    vbox.getChildren().add(loserText);
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setContentText("YOU LOSE!");
                    alert.showAndWait();
                }

                System.out.println("My lives: " + myLives);
                System.out.println("Computer lives: " + computerLives);
                myLivesText.setText("My lives: " + myLives);

                computerTurn();

                if (computerLives <= 0) {
                    System.out.println("You win!");
                    Text winnerText = new Text("You win!");
                    vbox.getChildren().add(winnerText);
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setContentText("YOU WIN!");
                    alert.showAndWait();
                }

                computerLivesText.setText("Computer Lives: " + computerLives);

            }
        });

        spellButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                // Randomly pick a number that the spell will be
                int randomSpellNumber = rand.nextInt(6);

                myLives = myLives + randomSpellNumber;

                if (myLives <= 0) {
                    System.out.println("You have lost!");
                    Text loserText = new Text("You lose!");
                    vbox.getChildren().add(loserText);
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setContentText("YOU LOSE!");
                    alert.showAndWait();
                }

                System.out.println("My lives: " + myLives);
                System.out.println("Computer lives: " + computerLives);
                myLivesText.setText("My lives: " + myLives);

                computerTurn();

                if (computerLives <= 0) {
                    System.out.println("You win!");
                    Text winnerText = new Text("You win!");
                    vbox.getChildren().add(winnerText);
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setContentText("YOU WIN!");
                    alert.showAndWait();
                }

                computerLivesText.setText("Computer Lives: " + computerLives);

            }
        });

        attackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                // Randomly choose the amount of damage the user will do to the computer
                int randomAttackNumber = rand.nextInt(6);

                computerLives = computerLives - randomAttackNumber;

                System.out.println("My lives: " + myLives);
                System.out.println("Computer lives: " + computerLives);
                myLivesText.setText("My lives: " + myLives);

                computerTurn();

                if (computerLives <= 0) {
                    System.out.println("You win!");
                    Text winnerText = new Text("You win!");
                    vbox.getChildren().add(winnerText);
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setContentText("YOU WIN!");
                    alert.showAndWait();
                }

                computerLivesText.setText("Computer Lives: " + computerLives);

            }
        });

    }

    public static void main(String[] args) {

        launch(args);

    }

    public int computerTurn() {

        // Let computer choose randomly which move they will make

        int whichButton = rand.nextInt(3);

        // Computer choooses health
        if (whichButton == 0) {
            computerLives = computerLives + 1;
        }

        // Computer chooses spell
        if (whichButton == 1) {
            computerLives = computerLives + rand.nextInt(6);
        }

        // Computer chooses attack
        if (whichButton == 2) {
            computerLives = myLives - rand.nextInt(6);
        }

        return computerLives;

    }

}
