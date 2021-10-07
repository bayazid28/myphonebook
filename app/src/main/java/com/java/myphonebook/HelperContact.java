package com.java.myphonebook;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.lang.annotation.Target;

public class HelperContact {
    private DatabaseReference databaseReference;

    public HelperContact(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Contact.class.getSimpleName());
    }
    public  Task<Void> add(Contact contact){
       return databaseReference.push().setValue(contact);
    }
    public Query get(){
        return databaseReference.orderByKey();
    }

}
