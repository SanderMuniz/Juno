package com.sandev.juno.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sandev.juno.data.database.dao.TermoDAO;
import com.sandev.juno.data.model.Termo;

@Database(entities = {Termo.class}, version = 1, exportSchema = false)
public abstract class JunoDatabase extends RoomDatabase {

    private static final String DATABASE = "juno.db";

    public static JunoDatabase getInstance(Context context) {
        return Room
                .databaseBuilder(context, JunoDatabase.class, DATABASE)
                .allowMainThreadQueries()
                .build();
    }

    public abstract TermoDAO getTermDAO();
}
