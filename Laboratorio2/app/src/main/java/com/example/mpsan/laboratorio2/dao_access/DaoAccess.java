package com.example.mpsan.laboratorio2.dao_access;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.mpsan.laboratorio2.models.Forms;
import java.util.List;

/**
 * Created by mpsan on 03-04-2018.
 */

@Dao
public interface DaoAccess {

    @Insert
    void insertOnlySingleForm(Forms forms);

    @Insert
    void instertMultipleForms(List<Forms> formsList);

    @Query("SELECT * FROM Forms WHERE FormID = :FormID")
    Forms fetchOneFormsbyFormID (int FormID);

    @Update
    void updateForm (Forms forms);

    @Delete
    void deleteForm (Forms forms);
}
