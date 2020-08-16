package com.learning.TempConverterTool;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	public static void main(String[] args){
		System.out.println("main");
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");


		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));

		VBox rootNode = loader.load();


		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);


		Scene scene = new Scene(rootNode);


		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");

		primaryStage.show();
	}

	private MenuBar createMenu(){
		Menu fileMenu = new Menu("File");

		MenuItem newMenuItem = new MenuItem("New");
		// event handler
		newMenuItem.setOnAction(event -> {
			System.out.println("New Item Clicked");
		});

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

		MenuItem quitMenuItem = new MenuItem("Quit");
		// event handler
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});


		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);



		Menu helpmenu = new Menu("Help");

		MenuItem aboutMenuItem = new MenuItem("About");
		//eventHandler
		aboutMenuItem.setOnAction(event -> {
			aboutApp();
		});

		helpmenu.getItems().addAll(aboutMenuItem);


		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpmenu);

		return menuBar;


	}

	public static void aboutApp(){

		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);

		alertDialog.setTitle("My First Java Application");
		alertDialog.setHeaderText("This is Unique.");
		alertDialog.setContentText("I am Beginner but soon I'll be pro and start developing Awesome Games-.");

		ButtonType yesbtn = new ButtonType("Yes");
		ButtonType nobtn = new ButtonType("NO");


		alertDialog.getButtonTypes().setAll(yesbtn,nobtn);

		Optional<ButtonType> onClicked = alertDialog.showAndWait();

		if (onClicked.get() == yesbtn){
			System.out.println("yes button");
		}else System.out.println("no button");

	}


}
