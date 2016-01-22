package easyway2twe.com.menuapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    int item_selection = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void selectNetwork(View view){
        registerForContextMenu(view);
        openContextMenu(view);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.network_menu, menu);

        MenuItem item_wifi = menu.findItem(R.id.id_wifi);
        MenuItem item_bluetooth = menu.findItem(R.id.id_bluetoorh);
        MenuItem item_mobile_data = menu.findItem(R.id.id_mobile_data);

        if(item_selection == 1){
            item_wifi.setChecked(true);
        }
        else if(item_selection == 2){
            item_bluetooth.setChecked(true);
        }
        else if(item_selection == 3){
            item_mobile_data.setChecked(true);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.id_wifi){
            Toast.makeText(getApplicationContext(), "Wifi selected", Toast.LENGTH_LONG).show();
            item.setChecked(true);
            item_selection = 1;
            return true;
        }
        else if(item.getItemId() == R.id.id_bluetoorh) {
            Toast.makeText(getApplicationContext(), "Bluetooth selected", Toast.LENGTH_LONG).show();
            item.setChecked(true);
            item_selection = 2;
            return true;
        }
        else if(item.getItemId() == R.id.id_mobile_data){
            Toast.makeText(getApplicationContext(), "Mobile Data selected", Toast.LENGTH_LONG).show();
            item.setChecked(true);
            item_selection = 3;
            return true;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
