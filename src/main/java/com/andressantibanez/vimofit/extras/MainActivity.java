package com.andressantibanez.vimofit.extras;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.andressantibanez.vimofit.R;

public class MainActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchAlbumsTests(View v){
        startActivity(new Intent(this, AlbumsTests.class));
    }
}
