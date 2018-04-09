package com.example.vinay.smarthomes;

/**
 * Created by vinay on 09-04-2018.
 */

import java.sql.DriverManager;
import java.sql.SQLException;
import android.os.AsyncTask;

public class MySQLConnect
{

}
/*public class MySQLConnect extends AsyncTask<Void, Void, String> {
    static final String url = "jdbc:mysql://192.168.43.198:3010/myDb";
    static final String user = "root";
    static final String pass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Download(MainActivity.this, internalUrl).execute(); //async task for getting data from db
    }*/

    /*protected String doInBackground(Void... params) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection(url, user, pass);
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select * from table");
            list = new ArrayList<objClass>();

            while (rs.next()) {
                String field= rs.getString("field");
                MainActivity.playerList.add(new objectClass(field));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "Complete";
    }

    protected void onPostExecute(String result) {
        if (result.equals("Complete")) {
        }
    }
}*/
