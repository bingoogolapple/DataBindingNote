package cn.bingoogolapple.databinding.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.bingoogolapple.databinding.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void helloworld(View v) {
        startActivity(new Intent(this, HelloworldActivity.class));
    }

    public void fragmentDemo(View v) {
        startActivity(new Intent(this, FragmentDemoActivity.class));
    }

    public void listViewDemo(View v) {
        startActivity(new Intent(this, ListViewDemoActivity.class));
    }

    public void recyclerViewDemo(View v) {
        startActivity(new Intent(this, RecyclerViewDemoActivity.class));
    }

}