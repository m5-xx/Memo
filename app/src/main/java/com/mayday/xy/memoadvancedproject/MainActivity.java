package com.mayday.xy.memoadvancedproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private DrawerLayout drawerlayout;
    private NavigationView navView;
    private FloatingActionButton md_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initControl();
    }

    private void toast(String toast){
        Toast.makeText(this,toast,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {

        super.onStart();
    }

    private void initControl() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //得到ActionBar的实例
        initNavigationBar();
        navView= (NavigationView) findViewById(R.id.nav_view);
        initNavigationView();
        md_button= (FloatingActionButton) findViewById(R.id.MD_button);
        md_buttonClickListener();
    }

    private void md_buttonClickListener() {
        md_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("触发成功");
            }
        });
    }

    private void initNavigationView() {
        //默认选中
        navView.setCheckedItem(R.id.it_item);
        //处理任务栏列表的触发事件()
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                drawerlayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.it_item1:
                        toast("this is item1");
                        break;
                    case R.id.it_item2:
                        toast("this is item2");
                        break;
                    default:
                        toast("this is other item");
                        break;
                }
                return true;
            }
        });
    }

    private void initNavigationBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.navigationbar);
        }
    }

    /**
     * 用于显示出menu的方法，返回true表示显示，false反之
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }


    /**
     * 用于对menu的触发事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login:

                break;
            //这个case是ActionBar本身的一个变量
            case android.R.id.home:
                drawerlayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

}
