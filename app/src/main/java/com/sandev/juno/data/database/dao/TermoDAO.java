package com.sandev.juno.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.sandev.juno.data.model.Termo;

import java.util.List;

@Dao
public interface TermoDAO {

    @Insert
    void salvar(Termo termo);

    @Query("SELECT * FROM termo WHERE name LIKE '%'||:nameSearch||'%'")
    List<Termo> listar(String nameSearch);


    @Query("SELECT * FROM termo")
    List<Termo> listarTodos();

}
