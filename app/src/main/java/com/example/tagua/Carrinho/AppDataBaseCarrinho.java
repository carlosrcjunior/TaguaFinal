package com.example.tagua.Carrinho;

import android.content.Context;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.tagua.DateConverter;

@Database(entities = {CarrinhoEntity.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDataBaseCarrinho extends RoomDatabase {
    private static AppDataBaseCarrinho sInstance;
    @VisibleForTesting
    public static final String DATABASE_NAME = "carrinho.db";
    public abstract CarrinhoDao carrinhoDao();
    private final MutableLiveData<Boolean> sIsDataBaseCreated = new MutableLiveData<>();
    public static AppDataBaseCarrinho getInstance(final Context context){
        if (sInstance == null){
            synchronized (AppDataBaseCarrinho.class){
                if (sInstance == null){
                    sInstance = buildDatabase(context.getApplicationContext());
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }
    private static AppDataBaseCarrinho buildDatabase(final Context appContext){
        return Room.databaseBuilder(appContext,AppDataBaseCarrinho.class,DATABASE_NAME).allowMainThreadQueries().build();
    }
    private void updateDatabaseCreated(final Context context){
        if (context.getDatabasePath(DATABASE_NAME).exists()){
            setDatabaseCreated();
        }
    }
    public void setDatabaseCreated(){ sIsDataBaseCreated.postValue(true);}
}