package com.example.venn.mygridview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.venn.mygridview.views.MGridView;


public class MainActivity extends Activity {

    private MGridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGridView = (MGridView) this.findViewById(R.id.m_grid);

        for (int i = 0; i < 10; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.mipmap.ic_launcher);
            mGridView.addChild(imageView);

            TextView textView = new TextView(this);
            textView.setText("哈哈哈哈");
            mGridView.addChild(textView);

        }
    }
}
