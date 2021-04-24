package com.example.kujana_dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kujana_dashboard.Connection.ConnectionClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class login extends AppCompatActivity implements View.OnClickListener {

    Connection conn;
    EditText LoginEmail,LoginPassword;
    Button btnlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlog = (Button)findViewById(R.id.btnLogin);
        LoginEmail = (EditText)findViewById(R.id.txtLogEmail);
        LoginPassword = (EditText)findViewById(R.id.txtLogPass);

        btnlog.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(login.this, MainActivity.class);
        startActivity(intent);
        //new login.CheckLogin().execute("");
    }

    /*public class CheckLogin extends AsyncTask<String, String, String>{

        String Z = null;
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onPostExecute(String s) {

        }

        @Override
        protected String doInBackground(String... strings) {

            conn = ConnectionClass(ConnectionClass.un.toString(), ConnectionClass.pass.toString(), ConnectionClass.db.toString(), ConnectionClass.ip.toString());

            if(conn == null){

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(login.this, "Check Your Internet Connection..!!", Toast.LENGTH_LONG).show();
                    }
                });
                Z = "On Internet Connection";
            }

            else {
                try {
                    //Check db name, email name and password name of our db

                    String sql = "SELECT * FROM Users WHERE email = '" + LoginEmail.getText() + "' AND password = '" + LoginPassword.getText() + "' ";
                    Statement stat = conn.createStatement();
                    ResultSet rs = stat.executeQuery(sql);

                    if (rs.next()) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(login.this, "Login Success", Toast.LENGTH_LONG).show();
                            }
                        });
                        Z = "Success";
                        Intent intent = new Intent(login.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(login.this, "Incorrect Email Or Password", Toast.LENGTH_LONG).show();
                            }
                        });

                        LoginEmail.setText("");
                        LoginPassword.setText("");

                        //Intent intent = new Intent(login.this, login.class);

                    }
                } catch (Exception e) {

                    isSuccess = false;
                    Log.e("SQL Error: ", e.getMessage());
                }
            }
            return Z;
        }
    }

    @SuppressLint("NewApi")
    public Connection ConnectionClass(String user, String password, String database, String server){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String connectionURL = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionURL = "jdbc:jtds:sqlserver://" +server+ "/" +database + ";user=" + user + ";password=" + password + ";";
            connection = DriverManager.getConnection(connectionURL);


        }catch (Exception e){

            Log.e("SQL Connection Error : ",e.getMessage());
        }
        return connection;
    }*/


}
