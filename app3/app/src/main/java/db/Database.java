package db;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "consumati")
    public class Database {
        @PrimaryKey
        public int uid;

        @ColumnInfo(name = "tipu_consumat")
        public String tipulConsumat;

        @ColumnInfo(name = "Pretul")
        public String pretul;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTipulConsumat() {
        return tipulConsumat;
    }

    public void setTipulConsumat(String tipulConsumat) {
        this.tipulConsumat = tipulConsumat;
    }

    public String getPretul() {
        return pretul;
    }

    public void setPretul(String pretul) {
        this.pretul = pretul;
    }
}

