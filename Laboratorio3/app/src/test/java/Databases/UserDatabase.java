package Databases;

import android.arch.persistence.room.Database;

import dao_access.UserDao;
import models.User;

/**
 * Created by mpsan on 03-04-2018.
 */

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase {
    public abstract UserDao userDao();
}
