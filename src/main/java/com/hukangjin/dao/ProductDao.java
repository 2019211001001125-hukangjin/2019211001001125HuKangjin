package com.hukangjin.dao;

import com.hukangjin.model.Product;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao {
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into Product(ProductName,ProductDescription,picture,price,CategoryId) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if (product.getPicture() != null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        int n = 0;
        String sql = "DELETE FROM product WHERE productId=?";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setInt(1, productId);
        n = ps.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql = "UPDATE product SET productName=?,productDescription=?,picture=?,price=?,categoryId=? WHERE productId=?";
        int n = 0;
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setString(1, instance.getProductName());
        ps.setString(2, instance.getProductDescription());
        ps.setBinaryStream(3, instance.getPicture());
        ps.setDouble(4, instance.getPrice());
        ps.setInt(5, instance.getCategoryId());
        ps.setInt(6, instance.getProductId());
        if (n > 0) {
            return n;
        }
        return 0;

    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "SELECT * FROM product where productId = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, productId);
        ResultSet resultSet = ps.executeQuery();
        Product product=new Product();
        if (resultSet.next()) {
            product.setProductId(resultSet.getInt("ProductId"));
            product.setProductName(resultSet.getString("productName"));
            product.setProductDescription(resultSet.getString("productDescription"));
            product.setCategoryId(resultSet.getInt("categoryId"));
            product.setPrice(resultSet.getDouble("price"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        List<Product> list = new ArrayList<Product>();
        String sql = "select * from Product where categoryId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,categoryId);
        ResultSet resultSet = pt.executeQuery();
        while (resultSet.next()) {
            Product product = new Product();
            product.setProductId(resultSet.getInt("ProductId"));
            product.setProductName(resultSet.getString("ProductName"));
            product.setProductDescription(resultSet.getString("ProductDescription"));
            product.setPrice(resultSet.getDouble("Price"));
            product.setCategoryId(resultSet.getInt("CategoryId"));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> list = new ArrayList<Product>();
        String sql = "select * from Product";
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet resultSet = pt.executeQuery();
        while (resultSet.next()) {
            Product product = new Product();
            product.setProductId(resultSet.getInt("ProductId"));
            product.setProductName(resultSet.getString("ProductName"));
            product.setProductDescription(resultSet.getString("ProductDescription"));
            product.setPrice(resultSet.getDouble("Price"));
            product.setCategoryId(resultSet.getInt("CategoryId"));
            list.add(product);
        }
        System.out.println("successful");
        return list;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product>getPicture(Integer productId,Connection con) throws  SQLException{
        return null;
    }
    public byte[] getPictureById(Integer productId, Connection con) throws SQLException {
        byte[] imgBytes=null;
        String sql="select picture from product where productId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        while (rs.next()){
            Blob blob=rs.getBlob("picture");
            imgBytes=blob.getBytes(1,(int)blob.length());

        }
        return imgBytes;
    }

}
