package com.jamilsoft.implicitlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText Website_editText;
    private  EditText Location_editText;
    private  EditText Share_editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Website_editText = (EditText)findViewById(R.id.website_edittext);
        Location_editText = (EditText)findViewById(R.id.location_edittext);
        Share_editText = (EditText)findViewById(R.id.share_edittext);
    }

    public void openwebsite(View view) {
        String url = Website_editText.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);

        }else {
            Log.d("Implicitintents","Could not Resolve the Problem");
        }

    }

    public void open_location(View view) {
        String Loc = Location_editText.getText().toString();
        Uri Location = Uri.parse("geo:0,0?q=" + Loc);

        Intent intent = new Intent(Intent.ACTION_VIEW,Location);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else {
            Log.d("Implicit","Could not some your Problem");
        }
    }

    public void sharetext(View view) {
        String share = Share_editText.getText().toString();
        String mimetype = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimetype)
                .setChooserTitle("Hey Share me")
                .setText(share)

                .startChooser();

    }
}
