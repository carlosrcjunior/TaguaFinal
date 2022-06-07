package com.example.tagua.Cardapio;

import android.content.Context;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.tagua.DateConverter;

@Database(entities = {CardapioEntity.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDataBaseCardapio extends RoomDatabase {
    private static AppDataBaseCardapio sInstance;
    @VisibleForTesting
    public static final String DATABASE_NAME = "cardapio.db";
    public abstract CardapioDao cardapioDao();
    private final MutableLiveData<Boolean> sIsDatabaseCreated = new MutableLiveData<>();
    public static AppDataBaseCardapio getInstance(final Context context){
        if (sInstance == null){
            synchronized (AppDataBaseCardapio.class){
                if (sInstance == null){
                    sInstance = buildDatabase(context.getApplicationContext());
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;

    }
    private static AppDataBaseCardapio buildDatabase(final Context appContext){
        return Room.databaseBuilder(appContext, AppDataBaseCardapio.class, DATABASE_NAME).allowMainThreadQueries().build();
    }
    private void updateDatabaseCreated(final Context context){
        if (context.getDatabasePath(DATABASE_NAME).exists()){
            setDatabaseCreated();
        }
    }
    public void setDatabaseCreated(){
        sIsDatabaseCreated.postValue(true);
    }
}

