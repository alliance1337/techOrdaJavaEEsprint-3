package kz.bitlab.techorda.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static User getUser(String email) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from tech_orda_db.users where email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
                user.setRole(resultSet.getInt("role_id"));

            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void addUser(User user) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO tech_orda_db.users (email, password, full_name, role_id) " +
                    "VALUES (?, ?, ?, ?)");

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setInt(4, user.getRole());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addNews(News news) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO tech_orda_db.news (title, content, post_date, user_id)" +
                    "VALUES (?, ?, NOW(), ?)");

            statement.setString(1, news.getTitle());
            statement.setString(2, news.getContent());
            statement.setLong(3, news.getUser().getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<News> getNews() {
        ArrayList<News> news = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT n.id, n.title, n.content, n.user_id, u.full_name, n.post_date " +
                    "FROM tech_orda_db.news n " +
                    "INNER JOIN tech_orda_db.users u on u.id = n.user_id " +
                    "ORDER BY n.post_date DESC");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                News n = new News();
                n.setId(resultSet.getLong("id"));
                n.setTitle(resultSet.getString("title"));
                n.setContent(resultSet.getString("content"));
                n.setPostDate(resultSet.getTimestamp("post_date"));

                User user = new User();

                user.setId(resultSet.getLong("user_id"));
                user.setFullName(resultSet.getString("full_name"));
                n.setUser(user);
                news.add(n);

            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public static News getNewsById(Long id) {
        News news = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT n.id, n.title, n.content, n.user_id, u.full_name, n.post_date " +
                    "FROM tech_orda_db.news n " +
                    "INNER JOIN tech_orda_db.users u on u.id = n.user_id " +
                    "where n.id = ?");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                news = new News();
                news.setId(resultSet.getLong("id"));
                news.setTitle(resultSet.getString("title"));
                news.setContent(resultSet.getString("content"));
                news.setPostDate(resultSet.getTimestamp("post_date"));

                User user = new User();

                user.setId(resultSet.getLong("user_id"));
                user.setFullName(resultSet.getString("full_name"));
                news.setUser(user);

            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public static void updateNews(News news) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE tech_orda_db.news SET title = ?, content = ? " +
                    "WHERE id = ?");

            statement.setString(1, news.getTitle());
            statement.setString(2, news.getContent());
            statement.setLong(3, news.getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addComment(Comment comment) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO tech_orda_db.comments (comment, user_id, news_id, post_date) " +
                    "VALUES (?, ?, ?, NOW())");

            statement.setString(1, comment.getComment());
            statement.setLong(2, comment.getUser().getId());
            statement.setLong(3, comment.getNews().getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Comment> getComments(Long newsId) {

        ArrayList<Comment> comments = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT co.id, co.comment, co.post_date, co.news_id, co.user_id, u.full_name " +
                    "FROM tech_orda_db.comments co " +
                    "INNER JOIN tech_orda_db.users u ON u.id = co.user_id " +
                    "WHERE co.news_id = ? " +
                    "ORDER BY co.post_date DESC");

            statement.setLong(1, newsId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Comment comment = new Comment();
                comment.setId(resultSet.getLong("id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setPostDate(resultSet.getTimestamp("post_date"));
                User user = new User();
                user.setId(resultSet.getLong("user_id"));
                user.setFullName(resultSet.getString("full_name"));
                comment.setUser(user);

                News news = new News();
                news.setId(resultSet.getLong("news_id"));
                comment.setNews(news);

                comments.add(comment);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    public static void deleteNews(Long id) {
        try {
            PreparedStatement statement1 = connection.prepareStatement("" +
                    "DELETE from tech_orda_db.comments where news_id = ?");

            statement1.setLong(1, id);

            statement1.executeUpdate();

            statement1.close();


            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE from tech_orda_db.news where id = ?");

            statement.setLong(1, id);

            statement.executeUpdate();

            statement.close();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void updateUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE tech_orda_db.users SET full_name = ?, password = ? " +
                    "WHERE id = ?");

            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setLong(3, user.getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUserById(Long id) {
        User users = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT n.full_name, n.password " +
                    "FROM tech_orda_db.users n " +
                    "where n.id = ? ");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                users = new User();
                users.setFullName(resultSet.getString("full_name"));
                users.setPassword(resultSet.getString("password"));

            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }


}










