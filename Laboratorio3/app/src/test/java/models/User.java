package models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mpsan on 02-04-2018.
 */
@Entity
public class User {
    @PrimaryKey
    private int uId;

    @ColumnInfo(name = "first_name")
    private String userName;

    @ColumnInfo(name = "last_name")
    private String userEmail;

    public User(){

    }

    public int getUId() { return  uId;}
    public void setUId(String movieId) { this.uId = uId; }

    public String getUserName(){ return userName;}
    public  void setUserName(){ this.userName = userName; }

    public String getUserEmail(){ return userEmail;}
    public void setUserEmail(){ this.userEmail = userEmail; }


}

