/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package lambdademo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Thiago Vignolo
 */
public class LambdaDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        Label annual = new Label("Annual Interest Rate:");
        grid.add(annual, 0, 0);
        TextField annualField = new TextField();
        grid.add(annualField, 1, 0);

        Label years = new Label("Number of Years:");
        grid.add(years, 0, 1);
        TextField yearsField = new TextField();
        grid.add(yearsField, 1, 1);

        Label loan = new Label("Loan Amount:");
        grid.add(loan, 0, 2);
        TextField loanField = new TextField();
        grid.add(loanField, 1, 2);

        Label monthly = new Label("Monthly Payment:");
        grid.add(monthly, 0, 3);
        TextField monthlyField = new TextField();
        grid.add(monthlyField, 1, 3);

        Label total = new Label("Total Payment:");
        grid.add(total, 0, 4);
        TextField totalField = new TextField();
        grid.add(totalField, 1, 4);

        
        Button btn = new Button("Calcular");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 5);


        btn.setOnAction((ActionEvent event) -> {
            double interest = Double.parseDouble(annualField.getText());
            int nyears = Integer.parseInt(yearsField.getText());
            double tloan = Double.parseDouble(loanField.getText());
            double r = interest / 1200;

            double monthlyPayment = (tloan * r)/(1 - (Math.pow(1/(1+r),(12 * nyears))));

           monthlyField.setText(String.format("$%.2f", monthlyPayment));
           totalField.setText(String.format("$%.2f", monthlyPayment * 12 * nyears));
        });
        
        Scene scene = new Scene(grid, 350, 300);
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
