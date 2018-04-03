package com.example.mpsan.laboratorio2.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by mpsan on 03-04-2018.
 */

@Entity
public class Forms {
    @NonNull
    @PrimaryKey (autoGenerate = true)
    private int FormID;
    private String FormName;
    private String DateTime;
    private String FormCategory;
    private String FormSomethingElse;

    public Forms(){

    }

    public int getFormID() { return FormID; }
    public void setFormID(int FormID) { this.FormID = FormID; }

    public String getFormName(){ return FormName; }
    public void setFormName(String FormName) { this.FormName = FormName; }

    public String getDateTime() { return DateTime; }
    public void setDateTime(String DateTime) { this.DateTime = DateTime; }

    public String getFormCategory(){ return FormCategory; }
    public void setFormCategory(String FormCategory) { this.FormCategory = FormCategory; }

    public String getFormSomethingElse() { return FormSomethingElse; }
    public void setFormSomethingElse(String  FormSomethingElse) { this.FormSomethingElse = FormSomethingElse; }

}
