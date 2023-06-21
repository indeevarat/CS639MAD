package com.example.firebaseemployee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private TextView displayText;
    private EditText fName;
    private EditText lName;
    private int counter;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("employees");
        Employee emp = new Employee("Ninja","Christelle");
        myRef.push().setValue(emp);

        myRef.addValueEventListener(new ValueEventListener() {
            private DataSnapshot dataSnapshot;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Employee emp;
                int counter =0;
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    emp= (Employee)ds.getValue(Employee.class);
                    Log.i("MainActivity",counter + "-Firstname: " + emp.getFirstName() +
                            " Lastname: " + emp.getLastName());
                    counter = counter+1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("The read failed: " + error.getCode());
            }
        });
    }
    public void addEmployee(View view){
        String firstName = fName.getText().toString();
        String lastName = lName.getText().toString();
        if (firstName.equals("empty")||lastName.equals("empty")){
            return;
        }
        Employee rep = new Employee(firstName, lastName);
        myRef.child("empty"+counter).setValue(rep);
        fName.setText("empty");
        lName.setText("empty");

    }
}