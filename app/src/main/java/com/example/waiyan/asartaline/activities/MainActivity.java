package com.example.waiyan.asartaline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.waiyan.asartaline.R;
import com.example.waiyan.asartaline.adapters.MainRecyclerAdapter;
import com.example.waiyan.asartaline.data.model.ASarTaLineModel;
import com.example.waiyan.asartaline.data.vos.GetWarDeeVO;
import com.example.waiyan.asartaline.delegates.RestaurantDelegate;
import com.example.waiyan.asartaline.events.ApiErrorEvent;
import com.example.waiyan.asartaline.events.SuccessGetWarDeeEvent;
import com.example.waiyan.asartaline.utils.ASarTaLineConstants;
import com.example.waiyan.asartaline.viewpods.EmptyViewPod;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    @BindView(R.id.vp_empty)
    EmptyViewPod vpEmpty;

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


        swipeRefresh.setRefreshing(true);
        ASarTaLineModel.getObjInstance().loadAstlWarDeeList();

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ASarTaLineModel.getObjInstance().loadAstlWarDeeList();
            }
        });

        vpEmpty.setEmptyData(R.drawable.no_information,"ဝါးတီးမ်ားမရယူႏိုင္တာစိတ္မရိွပါနဲ႔ခင္ဗ်ာ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onTapRestaurant(GetWarDeeVO getWarDeeVO) {
        Intent intent=new Intent(MainActivity.this,DetailActivity.class);
        intent.putExtra(ASarTaLineConstants.WAR_DEE_ID,getWarDeeVO.getWarDeeId());
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetWarDee(SuccessGetWarDeeEvent event){
        mainAdaper.setNewWarDeeList(event.getGetWarDeeVOList());
        swipeRefresh.setRefreshing(false);
        vpEmpty.setVisibility(View.GONE);
        Snackbar.make(swipeRefresh,"OK",Snackbar.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFailGetWarDee(ApiErrorEvent errorEvent){
        swipeRefresh.setRefreshing(false);
        if(!errorEvent.getErrorMessage().equalsIgnoreCase("success")){
            vpEmpty.setVisibility(View.VISIBLE);
            Snackbar.make(swipeRefresh,errorEvent.getErrorMessage(),Snackbar.LENGTH_INDEFINITE).show();//Snack bar show error use indefinite
        }
    }
}
