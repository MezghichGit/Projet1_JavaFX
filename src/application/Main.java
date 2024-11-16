package application;
	
import java.sql.SQLException;

import dao.VoitureDAO;
import entities.Voiture;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.beans.property.SimpleStringProperty;

public class Main extends Application {
	  private TableView<Voiture> table;
	  private ObservableList<Voiture> voitureList;
	/*
	@Override
	public void start(Stage primaryStage) {
		try {
			/*
			//1 création d'un composant
			//Text msg = new Text("Bonjour mes chers stagiaires");
			Button btn = new Button("Cliquer ici");
			//2 création d'un panel de type StackPane
			StackPane root = new StackPane();
			
			
			//3 Affectation du composant(Text) au layout (Pile)
			//root.getChildren().add(msg);
			root.getChildren().add(btn);
			// 4 Création de la scène qui va afficher le layout
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//5 Affectation de la scène au stage
			primaryStage.setScene(scene);
			primaryStage.setTitle("My first Window");
			primaryStage.show();*/
			/*
			VBox layout = new VBox();
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout, 300, 300);
			Label label1 = new Label("This is the First Scene");
	        
			VBox layout2 = new VBox();
	        layout2.setAlignment(Pos.CENTER); 
	        Scene scene2 = new Scene(layout2, 300, 300);
	        Label label2 = new Label("This is the Second Scene");
	         
	        Button button = new Button("Forward");
	        button.setOnAction(e -> primaryStage.setScene(scene2));
	         
	        Button button2 = new Button("Backwards");
	        button2.setOnAction(e -> primaryStage.setScene(scene));
	        
	        TextField text = new TextField();
	        text.setMaxWidth(100);
	        
	        
	        layout.getChildren().addAll(label1, button);
	        layout2.getChildren().addAll(label2, button2, text);
	        
	        
	        primaryStage.setTitle("Switching Between Scene");
	        primaryStage.setScene(scene);   
	        primaryStage.show();
	        
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	/*
	@Override
	    public void start(Stage primaryStage) {
	        // Création des éléments de l'interface
	        TextField textField = new TextField();
	        textField.setPromptText("Entrez un texte");
	        
	        Button button = new Button("Afficher");
	        
	        Label label = new Label();
	        
	        // Action du bouton pour afficher le texte
	        button.setOnAction(event -> {
	            String inputText = textField.getText();
	            label.setText("Texte saisi : " + inputText);
	        });
	        
	        // Disposition des éléments dans un layout vertical
	        VBox vbox = new VBox(10, textField, button, label);
	        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");
	        
	        // Création de la scène et configuration de la fenêtre
	        Scene scene = new Scene(vbox, 300, 200);
	        primaryStage.setTitle("Lecture et Affichage de Texte");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }*/
	 /*
	@Override
	    public void start(Stage primaryStage) {
	        // Création des éléments de l'interface de connexion
	        Label usernameLabel = new Label("Nom d'utilisateur:");
	        TextField usernameField = new TextField();
	        
	        Label passwordLabel = new Label("Mot de passe:");
	        PasswordField passwordField = new PasswordField();
	        
	        Button loginButton = new Button("Se connecter");
	        Label messageLabel = new Label();

	        // Action du bouton pour vérifier les informations de connexion
	        loginButton.setOnAction(event -> {
	            String username = usernameField.getText();
	            String password = passwordField.getText();

	            // Vérification des informations de connexion (à adapter selon vos critères)
	            if ("admin".equals(username) && "password".equals(password)) {
	                messageLabel.setText("Connexion réussie !");
	            } else {
	                messageLabel.setText("Nom d'utilisateur ou mot de passe incorrect.");
	            }
	        });

	        // Disposition des éléments dans un layout vertical
	        VBox vbox = new VBox(10, usernameLabel, usernameField, passwordLabel, passwordField, loginButton, messageLabel);
	        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

	        // Création de la scène et configuration de la fenêtre
	        Scene scene = new Scene(vbox, 300, 200);
	        primaryStage.setTitle("Page de Connexion");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }*/
	
	@Override
    public void start(Stage primaryStage) {
		
		
		// private ObservableList<Voiture> voitureList;
		    
		    
        // Création des éléments de l'interface
        Label marqueLabel = new Label("Marque:");
        TextField marqueField = new TextField();
        
        Label modeleLabel = new Label("Modèle:");
        TextField modeleField = new TextField();
        
        Label prixLabel = new Label("Prix:");
        TextField prixField = new TextField();
        
        Button addButton = new Button("Ajouter Voiture");
        Label resultLabel = new Label();
        
        Button listVoituresBtn = new Button("Liste Voitures");

        // Action du bouton pour ajouter la voiture
        addButton.setOnAction(event -> {
            String marque = marqueField.getText();
            String modele = modeleField.getText();
            double prix;
            
            try {
                prix = Double.parseDouble(prixField.getText());
                
                // Création de l'objet Voiture avec les valeurs saisies
                Voiture voiture = new Voiture(marque, modele, prix);
                
                try {
					VoitureDAO.addVoiture(voiture);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                
                // Affichage des détails de la voiture ajoutée
                resultLabel.setText("Voiture ajoutée : " + voiture);
                /// insertion dans la base de données
                // Réinitialisation des champs
                marqueField.clear();
                modeleField.clear();
                prixField.clear();
            } catch (NumberFormatException e) {
                resultLabel.setText("Erreur : Veuillez entrer un prix valide.");
            }
        });

        listVoituresBtn.setOnAction(
        		event -> {
        			try {
						System.out.println(VoitureDAO.listVoitures());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        );
        try {
			voitureList = FXCollections.observableArrayList(VoitureDAO.listVoitures());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        table = new TableView<>();
        table.setItems(voitureList);
       // Colonnes de la table
        
        TableColumn<Voiture, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.getColumns().add(idColumn);
        
        
        TableColumn<Voiture, String> marqueColumn = new TableColumn<>("Marque");
        marqueColumn.setCellValueFactory(new PropertyValueFactory<>("marque"));
        table.getColumns().add(marqueColumn);
        
        
        TableColumn<Voiture, String> modeleColumn = new TableColumn<>("Modele");
        modeleColumn.setCellValueFactory(new PropertyValueFactory<>("modele"));
        table.getColumns().add(modeleColumn);
        
        
        
        TableColumn<Voiture, Double> prixColumn = new TableColumn<>("Prix");
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        table.getColumns().add(prixColumn);
        
        
        
        //table.getColumns().addAll(marqueColumn, modeleColumn, prixColumn);
        // Disposition des éléments dans un layout vertical
        VBox vbox = new VBox(10, marqueLabel, marqueField, modeleLabel, modeleField, prixLabel, prixField, addButton, resultLabel,listVoituresBtn, table);
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Création de la scène et configuration de la fenêtre
        Scene scene = new Scene(vbox, 240, 500);
        primaryStage.setTitle("Ajouter une Voiture");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	public static void main(String[] args) throws SQLException {
		
		launch(args);
	}
}
