import java.util.List;

public class Records{

    public static void main(String[] args){
        
    }

    public static ArrayList<String> getAllUsers() {
      ArrayList list=new ArrayList<>();
     
      try {
        Connection conn = JDBCDataSource.getConnection("jdbc:mysql://localhost:3306/richfield", "root", "");
        PreparedStatement pstmt = conn.prepareStatement("Select * from users");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
        UserBeans users = new UserBeans();
        users.setId(rs.getLong("id"));
        users.setName(rs.getString("name"));
        users.setPassword(rs.getString("password"));
        users.setEmail(rs.getString("email"));
        users.setgender(rs.getString("gender"));
        users.setCity(rs.getString("city"));
        list.add(users);
        }
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }finally {
        JDBCDataSource.closeConnection(conn);
      }
      return list;
    }
}