import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerTableController {

    @FXML
    private TableView<Customer> tableView;

    @FXML
    private TableColumn<Customer, String> nameColumn;

    @FXML
    private TableColumn<Customer, Integer> ageColumn;

    @FXML
    private TableColumn<Customer, String> emailColumn;

    @FXML
    private TableColumn<Customer, String> locationColumn;

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        tableView.setItems(getCustomerData());
    }

    private ObservableList<Customer> getCustomerData() {
        ObservableList<Customer> customers = FXCollections.observableArrayList();
        String query = "SELECT name, age, email, location FROM customers";

        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                String location = resultSet.getString("location");

                customers.add(new Customer(name, age, email, location));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }

    @FXML
    public void switchToBarChart() {
        App.setRoot("BarChartView");
    }
}
