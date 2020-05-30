package db;


import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Database.class}, version = 1)
    public abstract class MydbApp extends RoomDatabase {
        public abstract MyDao MyDao();
    }

