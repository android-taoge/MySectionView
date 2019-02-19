package com.yn.taoge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yn.customsection.CustomSectionView;

public class MainActivity extends AppCompatActivity {

    private CustomSectionView sectionView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        sectionView=findViewById(R.id.sectionView);
        sectionView.setSectionClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点我干啥>", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
