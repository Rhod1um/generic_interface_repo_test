package com.example.interface_repo_test.repository;

import java.util.List;

public interface Interface_repo<E> {

    List<E> readAll(String sql);
    E read(); //dynamisk returtype

    void create(E p);

    void update(E p);

    void delete(int id);
}
