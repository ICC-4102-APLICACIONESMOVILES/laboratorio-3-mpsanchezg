package dao_access;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import models.User;

/**
 * Created by mpsan on 02-04-2018.
 */

@Dao
public interface UserDao {

    @Insert
    void insertOnlySingleUser (User users);
    @Insert
    void insertMultipleUsers (List<User> userList);

    @Query("SELECT * FROM User WHERE uId = :uId")
    User fetchOneUserbyUserId(int uId);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);
}
