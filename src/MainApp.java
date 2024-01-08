import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private Scene loginScene, registerScene, mainScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Application Minimaliste");

        // Pages
        createLoginScene();
        createRegisterScene();
        createMainScene();

        // Affiche la page de connexion au démarrage
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private void createLoginScene() {
        // Crée les éléments de la page de connexion
        Label label = new Label("Connectez-vous");
        TextField usernameInput = new TextField();
        TextField passwordInput = new TextField();
        Button loginButton = new Button("Se connecter");

        // Définir l'action du bouton
        loginButton.setOnAction(e -> primaryStage.setScene(mainScene));

        // Organise les éléments dans une disposition VBox
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, usernameInput, passwordInput, loginButton);
        layout.setPadding(new Insets(10));

        // Crée la scène de connexion
        loginScene = new Scene(layout, 300, 200);
    }

    private void createRegisterScene() {
        // Crée les éléments de la page d'inscription
        Label label = new Label("Inscrivez-vous");
        TextField usernameInput = new TextField();
        TextField passwordInput = new TextField();
        Button registerButton = new Button("S'inscrire");

        // Définir l'action du bouton
        registerButton.setOnAction(e -> primaryStage.setScene(mainScene));

        // Organise les éléments dans une disposition VBox
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, usernameInput, passwordInput, registerButton);
        layout.setPadding(new Insets(10));

        // Crée la scène d'inscription
        registerScene = new Scene(layout, 300, 200);
    }

    private void createMainScene() {
        // Crée les éléments de la page principale
        Label label = new Label("Bienvenue dans l'application");

        // Organise les éléments dans une disposition VBox
        StackPane layout = new StackPane();
        layout.getChildren().add(label);

        // Crée la scène principale
        mainScene = new Scene(layout, 300, 200);
    }
}
