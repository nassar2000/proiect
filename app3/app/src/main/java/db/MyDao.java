package db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface MyDao {
    @Insert
    public void addInfo(Database info);

    @Query("select * from consumati")
    public List<Database> getData();

    @Delete
    public void deleteInfo(Database info);

    @Update
    public void updateInfo(Database info);


}

