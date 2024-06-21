package com.example.assignment001;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MainController {

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> emailColumn;

    @FXML
    private TableColumn<Student, String> majorColumn;

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField majorField;

    ObservableList<Student> studentData = FXCollections.observableArrayList();

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        majorColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("major"));
        tableView.setItems(studentData);
    }

    @FXML
    void addStudent(ActionEvent event) {
        Student student = new Student(Integer.parseInt(idField.getText()), nameField.getText(), emailField.getText(), majorField.getText());
        studentData.add(student);
        tableView.refresh();
        clearTextFields();
    }

    @FXML
    void deleteStudent(ActionEvent event) {
        Student student = tableView.getSelectionModel().getSelectedItem();
        studentData.remove(student);
        tableView.refresh();
        clearTextFields();
    }

    @FXML
    void updateStudent(ActionEvent event) {
        Student student = tableView.getSelectionModel().getSelectedItem();
        if (student!= null) {
            student.setId(Integer.parseInt(idField.getText()));
            student.setName(nameField.getText());
            student.setEmail(emailField.getText());
            student.setMajor(majorField.getText());
            tableView.refresh();
            clearTextFields();
        } else {
            showAlert("Error", "Please select a student to update.");
        }
    }

    private void showAlert(String error, String s) {
    }

    @FXML
    void rowClicked(MouseEvent event) {
        Student student = tableView.getSelectionModel().getSelectedItem();
        idField.setText(String.valueOf(student.getId()));
        nameField.setText(student.getName());
        emailField.setText(student.getEmail());
        majorField.setText(student.getMajor());
    }

    public void clearTextFields() {
        idField.clear();
        nameField.clear();
        emailField.clear();
        majorField.clear();
    }
}