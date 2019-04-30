package com.android.example.kjsceinsignia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class contactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        TextView head1 = (TextView) findViewById(R.id.head1);
        final TextView head1_num = (TextView) findViewById(R.id.head1_num);
        final TextView head1_email = (TextView) findViewById(R.id.head1_email);

        TextView head2 = (TextView) findViewById(R.id.head2);
        final TextView head2_num = (TextView) findViewById(R.id.head2_num);
        final TextView head2_email = (TextView) findViewById(R.id.head2_email);

        final ImageView call1 = (ImageView) findViewById(R.id.call1);
        final ImageView call2 = (ImageView) findViewById(R.id.call2);
        final ImageView mail1 = (ImageView) findViewById(R.id.mail1);
        final ImageView mail2 = (ImageView) findViewById(R.id.mail2);


        head1.setText("Dhairya Singhvi");
        head2.setText("Dharmil Shah");

        head1_num.setText("9757496271");
        head2_num.setText("9930311291");

        head1_email.setText("dhairya.singhvi@somaiya.edu");
        head2_email.setText("dharmil.vs@somaiya.edu");

        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:9757496271"));
                startActivity(callIntent);
            }
        });

        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:9930311291"));
                startActivity(callIntent);
            }
        });

        mail1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                String to= head1_email.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                //need this to prompts email client only
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }

        });

        mail2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                String to= head2_email.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                //need this to prompts email client only
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }

        });
    }
}