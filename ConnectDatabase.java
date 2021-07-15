
package Bai1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
public class ConnectDatabase {
    private static Connection conn = null;
    private final String user = "sa";
    private final String password = "123456";
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=SANPHAM";

    public void connectDataBase() {
        try {
            conn = DriverManager.getConnection(url, user,password);
            System.out.println("Connect success");
        } catch (SQLException e) 
        {
            System.out.println("connect error: " + e.getMessage());
        }
    }
      public void insertLoaiSP(String tenLoaiSP){
        String query = "insert into LoaiSanPham values(?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,tenLoaiSP);
            boolean flag = preparedStatement.execute();

        } catch (SQLException throwables) {
            System.out.println("error: " + throwables.getMessage());
        }

    }
    public List<SanPham> SanPhams() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham";
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int MaSP = rs.getInt("MaSP");
                String TenSanPham = rs.getString("TenSP");
                String NhaSanXuat = rs.getString("NhaSanXuat");
                int MaLoaiSP = rs.getInt("MaLoaiSP");
                list.add(new SanPham(MaSP, TenSanPham, NhaSanXuat, getTen(MaLoaiSP)));
            }
        } catch (SQLException throwables) {
            System.out.println("error: " + throwables.getMessage());
        }
        return list;
    }

    public List<LoaiSanPham> LoaiSanPhams() {
        List<LoaiSanPham> list = new ArrayList<>();
        String query = "select * from LoaiSanPham";
        try {
            Statement statements = conn.createStatement();
            ResultSet rl = statements.executeQuery(query);
            while (rl.next()) {
                int MaLoaiSP = rl.getInt("MaLoaiSP");
                String TenLoaiSP = rl.getString("TenLoaiSP");
                list.add(new LoaiSanPham(MaLoaiSP, TenLoaiSP));
            }
            statements.close();
        } catch (SQLException throwables) {
            System.out.println("error: " + throwables.getMessage());
        }
        return list;
    }
    public String getTen(int id){
        String result = null;
        String query = "select * from LoaiSanPham where MaLoaiSP = "+id;
        try {
            Statement statement = conn.createStatement();
            ResultSet rl = statement.executeQuery(query);
            while (rl.next()) {
                result = rl.getString("TenLoaiSP");
                break;
            }
            statement.close();
        } catch (SQLException throwables) {
            System.out.println("error: " + throwables.getMessage());
        }
        return result;
    }
}
