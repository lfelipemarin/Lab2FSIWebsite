/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.WebsiteDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class WebsiteDAO {

    private final String url = "jdbc:mysql://localhost:3306/website";
    private final String user = "root";
    private final String pass = "root";

    public Connection getConnection() throws Exception {
        Connection c = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            c = DriverManager.getConnection(url, user, pass);
            return c;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public ArrayList<WebsiteDTO> getAll() throws SQLException, Exception {
        ArrayList<WebsiteDTO> websites = new ArrayList<>();
        String sql = "SELECT * FROM website ORDER BY title";
        Connection conn = null;
        PreparedStatement st;
        try {
            conn = getConnection();
            st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                WebsiteDTO web = new WebsiteDTO();
                web.setId(rs.getInt("id"));
                web.setTitle(rs.getString("title"));
                web.setDescription(rs.getString("description"));
                web.setUrl(rs.getString("url"));
                websites.add(web);
            }
            conn.close();
            return websites;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void insertWeb(WebsiteDTO web) throws SQLException, Exception {
        String sql = "INSERT INTO website VALUES (?,?,?,?)";
        Connection conn = null;
        PreparedStatement st;
        try {
            conn = getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, web.getId());
            st.setString(2, web.getTitle());
            st.setString(3, web.getDescription());
            st.setString(3, web.getUrl());

        } catch (SQLException e) {
            throw e;
        }
    }
}
