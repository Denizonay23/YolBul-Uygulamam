package com.example.yolbul;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class PasswordEkrani extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private int counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_ekrani);
        Name = (EditText)findViewById(R.id.editText);
        Password = (EditText)findViewById(R.id.editText2);
        Login = (Button)findViewById(R.id.button3);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }
    private void validate(String userName, String userPassword){

        if((userName.equals ("Deniz")) && (userPassword.equals("Denizcik"))){

            Intent ıntent = new Intent(PasswordEkrani.this,GirisEkrani.class);
            startActivity(ıntent);
        }else{
            counter --;
            if (counter == 0){
                Login.setEnabled(false);
            }
        }

    }
}
