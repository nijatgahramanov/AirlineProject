package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.DirectoryInter;
import com.company.entity.Directory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DirectoryInterImpl extends AbstractDao implements DirectoryInter {
    private Directory getDirectory(ResultSet rs) throws Exception {
        Integer id = rs.getInt("id");
        String fromCity = rs.getString("from_city");
        String toCity = rs.getString("to_city");
        String price = rs.getString("price");
        String quantity = rs.getString("quantity");


        return new Directory(fromCity, toCity, price, quantity);
    }

    @Override
    public boolean addDirectory(Directory directory) {
        Directory direct = null;
        try (Connection c = connect()) {
            PreparedStatement stmt =
                    c.prepareStatement("insert into " +
                            "directory(from_city,to_city,price,quantity) values(?,?,?,?)");
            stmt.setString(1, directory.getFromCity());
            stmt.setString(2, directory.getToCity());
            stmt.setString(3, directory.getPrice());
            stmt.setString(4, directory.getQuantity());
            return stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Directory> getAllDirectory() {
        List<Directory> list = new ArrayList<>();

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from directory");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Directory d = getDirectory(rs);
                list.add(d);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    @Override
    public Directory getByDirectoryId(Integer id) {
        Directory directory = null;

        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.executeQuery("select * from directory where id = " + id);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                directory = getDirectory(rs);
            }

            c.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return directory;
    }
}
