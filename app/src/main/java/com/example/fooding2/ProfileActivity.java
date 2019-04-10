package com.example.fooding2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    SharedPreferences preferences;
    private CircleImageView avatar;
    private TextView name_tv;
    private TextView addr_tv;
    private TextView tel_tv;
    private TextView mail_tv;
    private TextView hour_tv;
    private TextView info_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        avatar = findViewById(R.id.avatar);
        name_tv = findViewById(R.id.name_text);
        addr_tv = findViewById(R.id.address_text);
        tel_tv = findViewById(R.id.tel_text);
        mail_tv = findViewById(R.id.mail_text);
        hour_tv = findViewById(R.id.hour_text);
        info_tv = findViewById(R.id.info_text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(preferences.contains(EditActivity.URI_PREFS)) {
            avatar.setImageURI(Uri.parse(preferences.getString(EditActivity.URI_PREFS, "")));
            if(avatar.getDrawable() == null)
                avatar.setImageResource(R.drawable.ic_launcher_foreground);
        }
        if(preferences.contains(EditActivity.NAME_PREFS))
            name_tv.setText(preferences.getString(EditActivity.NAME_PREFS, ""));
        if(preferences.contains(EditActivity.ADDR_PREFS))
            addr_tv.setText(preferences.getString(EditActivity.ADDR_PREFS, ""));
        if(preferences.contains(EditActivity.TEL_PREFS))
            tel_tv.setText(preferences.getString(EditActivity.TEL_PREFS, ""));
        if(preferences.contains(EditActivity.MAIL_PREFS))
            mail_tv.setText(preferences.getString(EditActivity.MAIL_PREFS, ""));
        if(preferences.contains(EditActivity.HOUR_PREFS))
            hour_tv.setText(preferences.getString(EditActivity.HOUR_PREFS, ""));
        if(preferences.contains(EditActivity.INFO_PREFS))
            info_tv.setText(preferences.getString(EditActivity.INFO_PREFS, ""));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.edit_mode) {
            Intent i = new Intent(getApplicationContext(), EditActivity.class);
            startActivity(i);
        }
        return true;
    }
}
