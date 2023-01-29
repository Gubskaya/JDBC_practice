import java.sql.*;

public class Main {
    private final String URL = "jdbc:postgresql://localhost:5432/university";
    private final String USER = "postgres";
    private final String PASSWORD = "postgres";
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    //Получить количество студентов в имени которых содержится буква «а».
    public int getStudentsName() {
        String SQL = "SELECT count(first_name) FROM students WHERE first_name LIKE '%a%'";
        int count = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    //Получить максимальной возраст среди студентов
    public int getMaxAge() {
        String SQL = "SELECT max(age) FROM students";
        int age = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            age = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return age;
    }

    //Получить среднюю оценку среди студентов
    public double getAverageMark() {
        String SQL = "SELECT avg(mark) FROM students";
        double avgMark = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            avgMark = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return avgMark;
    }

    //Получить кол-во всех студентов
    public int getStudentsCount() {
        String SQL = "SELECT count(*) FROM students";
        int count = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    //Получить возраст самого младшего студента
    public int getMinAge() {
        String SQL = "SELECT min(age) FROM students";
        int age = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            age = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return age;
    }

    //Получить сумму стипендий всех студентов
    public int ScholarshipsSum() {
        String SQL = "SELECT sum(scholarship) FROM students";
        int sum = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            sum = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sum;
    }


    public static void main(String[] args) {
        Main main = new Main();
        int count = main.getStudentsName();
        System.out.println("Kоличество студентов в имени которых содержится буква «а» = " + count);
        int maxAge = main.getMaxAge();
        System.out.println("Максимальный возраст студента = " + maxAge);
        double avgMark = main.getAverageMark();
        System.out.println("Средняя оценка студентов = " + avgMark);
        int countStudents = main.getStudentsCount();
        System.out.println("Количество студентов = " + countStudents);
        int minAge = main.getMinAge();
        System.out.println("Минимальный возраст студента = " + minAge);
        int sumScolarships = main.ScholarshipsSum();
        System.out.println("Сумма стипендий всех студентов = " + sumScolarships);

    }
}
