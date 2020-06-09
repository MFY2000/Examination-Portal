package Exam_System.db;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcDao {

    // Replace below database url, username and password with your actual database credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost/javalogin?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String INSERT_QUERY = "INSERT INTO `oop(object-oriented programming)` (`Id`, `Question`, `A`, `B`, `C`, `D`, `Answer`) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_QUERY_LOGIN = "SELECT * FROM login WHERE email_id = ? and password = ?";

    //Database varaible
    private Connection connection;
    private Statement statement;
    private ResultSet result;

    //Database varaible that save data
    private static String UserId;
    private static String QuizSelete;
    private static String QuizTime;
    private static String QuizNoofAttemt;
    private static String TotalQuizQuestion;
    private static String UserName;
    private ArrayList<String> QuestioAnswer = new ArrayList<String>();

    public jdbcDao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void insertRecord(String Question,String Option_1,String Option_2,String Option_3,String Option_4,String Answer) throws SQLException {

        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, Question);
            preparedStatement.setString(2, Option_1);
            preparedStatement.setString(3, Option_2);
            preparedStatement.setString(4, Option_3);
            preparedStatement.setString(5, Option_4);
            preparedStatement.setString(6, Answer);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

    //    login system
    public boolean validate(String emailId, String password) throws SQLException {

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY_LOGIN)) {
            preparedStatement.setString(1, emailId);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                UserId = emailId;
                return true;
            }


        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
        return false;
    }

    // fetch data
    public ArrayList<String> displayFeildList(){
        List<String> Feild = new ArrayList<String>();
        try {
            String query = "select * from subjectlist";
            result = statement.executeQuery(query);

            while (result.next()){
                Feild.add(result.getString("Field"));
            }}
        catch (Exception e){
            System.out.println("Error : "+e);
        }
            return (ArrayList<String>) Feild;
        }

    public boolean checkPin(String pinEnter,String Feild){
            String query = "SELECT * FROM `subjectlist` WHERE `Field` LIKE "+'"'+Feild+'"'+" ";
            boolean match = false;
            try {
                result = statement.executeQuery(query);
                result.next();
                String pin = result.getString("Pincode");
                if (pin.equals(pinEnter)){
                    match = true;
                    QuizSelete = Feild;
                    QuizTime = result.getString("QuizTime");
                    QuizNoofAttemt =  result.getString("QuizNoofAttemp");
                    TotalQuizQuestion = result.getString("TotalQuestion");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return match;
        }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public static String getQuizSelete() {
        return QuizSelete;
    }

    public static String getTotalQuizQuestion() {
        return TotalQuizQuestion;
    }

    public static String getUserId() {
        return UserId;
    }

    public static String getQuizNoofAttemt() {
        return QuizNoofAttemt;
    }

    public static String getQuizTime() {
        return QuizTime;
    }

    public ArrayList<String> getQuizDetails(int QuestionId){
        String query = "SELECT * FROM "+'`'+ QuizSelete +'`'+" WHERE `Id` LIKE "+'"'+QuestionId+'"'+" ";

        try {
            result = statement.executeQuery(query);
            result.next();
            QuestioAnswer.add(" "+result.getString("Question"));
            QuestioAnswer.add(" "+result.getString("A"));
            QuestioAnswer.add(" "+result.getString("B"));
            QuestioAnswer.add(" "+result.getString("C"));
            QuestioAnswer.add(" "+result.getString("D"));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return QuestioAnswer;

    }



}


