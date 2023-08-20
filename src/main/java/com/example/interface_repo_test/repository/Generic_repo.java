package com.example.interface_repo_test.repository;

import com.example.interface_repo_test.util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.*;

public class Generic_repo<E> implements Interface_repo<E> {

    Connection conn = DatabaseConnector.getConnection(); //skal interfacet have den?

    @Override
    public List<E> readAll(String sql) {
        List<E> wishes = new ArrayList<>();

        try {
            PreparedStatement pst =  conn.prepareStatement(sql); {
                pst.setString(1, email);
                ResultSet resultset = pst.executeQuery();

                // VI skal have joinet Email til Wishene: det gøres ved at lave Email om til FK
                // og binde dem sammen via en join forbindelse

                while(resultset.next()){
                    wishes.add(new<E> (
                            resultset.getInt("wish_id"),
                            resultset.getString("wish_description"),
                            resultset.getString("email")));
                }
                model.addAttribute("wishList", wishes); //----------------her sendes wishes til formen

                ArrayList<Integer> IDs = new ArrayList<>();
                ArrayList<String> descriptions = new ArrayList<>();
                ArrayList<String> emails = new ArrayList<>();

                for(Wish w : wishes) {
                    IDs.add(w.getId());
                    model.addAttribute("idList", IDs);

                    descriptions.add(w.getDescription());
                    model.addAttribute("descriptionList", descriptions);
                }

                //sout terminal
                for (Wish w:wishes) {
                    System.out.println(w.toString());
                }
            }
 /*       PreparedStatement pst =  conn.prepareStatement("select * from wishing_well.wishing_list"); {
          ResultSet resultset = pst.executeQuery();
   */
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return wishes;
    }

    @Override
    public E read() {
        return null;
    }

    @Override
    public void create(E p) {

    }

    @Override
    public void update(E p) {

    }

    @Override
    public void delete(int id) {

    }
}
