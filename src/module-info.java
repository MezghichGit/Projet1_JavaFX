module Projet1_CursusJava {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
	opens entities to javafx.base;
	opens application to javafx.graphics, javafx.fxml;
}
