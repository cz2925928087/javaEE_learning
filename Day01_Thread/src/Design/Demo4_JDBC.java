package Design;
import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import static Design.DBUtil.getDataSource;

class DBUtil {
    private static volatile DataSource dataSource = null;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    /*这种写法是错误的,在指令重排序当中
                    * 1.申请内存
                    * 2.初始化内存
                    * 3.将内存地址赋值给引用
                    * 如果按下面注释代码来写的话,就相当于假赋值,
                    * 当实例创建之后,如果出现线程安全问题,(加锁也不是一定能解决线程安全)
                    * 这就导致当实例创建后,就会直接到return,然后和数据库建立连接,但是没有引用赋值,不知道是连接的数据库在哪
                    * 所以就是错误的
                    * !解决方法:先给实例赋值,然后再讲赋值的实例内容给引用
                    * */
                    //DataSource dataSource = new MysqlDataSource();
                    //(MysqlDataSource(DataSource)).setURL("jdbc:mysql://127.0.0.1:3306/class?characterEncoding=utf8&useSSL=false");
                    //(MysqlDataSource(DataSource)).setUser("root");
                    //(MysqlDataSource(DataSource)).setPassword("Cz.200406146737");
                    MysqlDataSource mysqlDataSource = new MysqlDataSource();
                    mysqlDataSource.setURL("jdbc:mysql://127.0.0.1:3306/class?characterEncoding=utf8&useSSL=false");
                    mysqlDataSource.setUser("root");
                    mysqlDataSource.setPassword("Cz.200406146737");
                    dataSource = mysqlDataSource;
                }
            }
        }
        return dataSource;
    }

    private DBUtil() {
    }
}

public class Demo4_JDBC {
    public static void main(String[] args) throws SQLException {
        //2 和数据库服务器进行通信,建立网络连接
        Connection connection = getDataSource().getConnection();

        //3 构造sql语句
        //请输入ID
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入ID ");
        int ID = scanner.nextInt();
        System.out.println(ID);
        System.out.println("请输入姓名 ");
        String name = scanner.next();
        System.out.println(name);
        String sql = "insert into student values(?,?)";
        //预编译语句,客户端先进行编译解析,解析完后再传给服务器
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, ID);
        preparedStatement.setString(2, name);

        //4 执行sql(把sql通过网络发送到服务器)
        /*该方法用于进行"增删改,建表删表"这些操作
          返回值是int类型,意思是该操作影响了几行
        * */
        //用于"查"的方法executeQuery()
        int n = preparedStatement.executeUpdate();
        System.out.println("n = " + n);

        //5 关闭连接等资源
        preparedStatement.close();
        connection.close();
        scanner.close();
    }
}

