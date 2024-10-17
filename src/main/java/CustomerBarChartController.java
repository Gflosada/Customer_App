import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerBarChartController {

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    public void initialize() {
        XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
        dataSeries.setName("Customers by Age");

        String query = "SELECT age, COUNT(*) AS num_customers FROM customers GROUP BY age";

        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String age = resultSet.getString("age");
                int numCustomers = resultSet.getInt("num_customers");
                dataSeries.getData().add(new XYChart.Data<>(age, numCustomers));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        barChart.getData().add(dataSeries);
    }

    @FXML
    public void switchToTableView() {
        App.setRoot("TableView");
    }
}
