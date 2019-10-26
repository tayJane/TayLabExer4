package com.tay.taylabexer4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.tay.taylabexer4.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] comName, comCoun, comIndus, comCEO;
    ListView lists;
    int[] comLogo = {R.drawable.icbc, R.drawable.jpm, R.drawable.ccb, R.drawable.aboc, R.drawable.boa, R.drawable.apple, R.drawable.ping, R.drawable.boc ,R.drawable.shell, R.drawable.wells, R.drawable.exxon, R.drawable.att, R.drawable.samsung, R.drawable.citi};
    ArrayList<Company> comList = new ArrayList<>();
    String[] comInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comName = getResources().getStringArray(R.array.comName);
        comCoun = getResources().getStringArray(R.array.comCoun);
        comIndus = getResources().getStringArray(R.array.comIndus);
        comCEO = getResources().getStringArray(R.array.comCEO);
        comInfo = getResources().getStringArray(R.array.comInfo);

        for(int i=0; i < comName.length; i++){
            comList.add(new Company(comLogo[i], comName[i], "Country: " + comCoun[i], "Industry: " + comIndus[i], "CEO: " + comCEO[i]));
        }

        lists = findViewById(R.id.listView);

        ArrayAdapter androidArrayAdapter = new Adaptor(this, R.layout.item, comList);

        lists.setAdapter(androidArrayAdapter);
        lists.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        final AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        myDialog.setTitle(comList.get(position).getComName());
        myDialog.setIcon(comList.get(position).getComLogo());
        myDialog.setMessage(comInfo[position]);
        myDialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, comName[position], Toast.LENGTH_LONG).show();
            }
        });
        myDialog.create().show();
    }
}
