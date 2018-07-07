package com.example.waiyan.asartaline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.waiyan.asartaline.R;
import com.example.waiyan.asartaline.adapters.MainRecyclerAdapter;
import com.example.waiyan.asartaline.delegates.RestaurantDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RestaurantDelegate{

    @BindView(R.id.ctbl)
    CollapsingToolbarLayout ctbl;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.card_view)
    CardView cardView;
    @BindView(R.id.rv_main)
    RecyclerView rvMain;

    private MainRecyclerAdapter mainAdaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);
        setSupportActionBar(toolbar);

        //collapsing toolbar control with cardView...
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                /**
                 * verticalOffset changes in diapason
                 * from 0 - appBar is fully unwrapped
                 * to -appBarLayout's height - appBar is totally collapsed
                 * so in example we hide FAB when user folds half of the appBarLayout
                 */
                if (appBarLayout.getHeight() / 2 < -verticalOffset) {
                    cardView.setVisibility(View.GONE);
                } else {
                    cardView.setVisibility(View.VISIBLE);
                }
            }
        });

        rvMain.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false));
        mainAdaper=new MainRecyclerAdapter(this);
        rvMain.setAdapter(mainAdaper);

    }

    @Override
    public void onTapRestaurant() {
        Intent intent=new Intent(MainActivity.this,DetailActivity.class);
        startActivity(intent);
    }
}
