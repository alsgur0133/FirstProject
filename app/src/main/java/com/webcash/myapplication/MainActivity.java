package com.webcash.myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    ListView listView;
    Button btn,btnTimer;
    String[] items = {"예를들어 onCreate() Activity가 처음 만들어질 때 호출되는 함수 onStart() 사용자에게 보여지기 직전에 호출되는 함수 등을 통해 Activity에 생명을 부여하는것"
    ,"Task는 어플리케이션에서 실행되는 Activity를 보관하고 관리하며 Stack형태의 연속된 Activity로 이루어진다. 선입후출형태로 나중에 적재된 액티비티일 수록 가장 먼저 사용된다."
    ,"Fragment Life Cycle이란 Activity Life Cycle처럼 생명주기이다. 프래그먼트는 액티비티안에서 존재하게 되므로, Activity의 존재와도 연관된 생명주기들을 추가적으로 가지고 있다. 예를 예를들어 onCreate(),프래그먼트가 Activity에 attach될 때 호출되는 onAttach()함수 등"
    ,"안드로이드에서 가장 많이 사용하는 위젯 중 하나가 리스튜이다. 직관저긍로 여러개 아이템을 보여주고 선택하게 해주는 위젯"
    ,"ViewPager을 사용하면 손가락으로 쓸어서 페이지를 넘기는 기능을 사용할 수 있게 됩니다. 슬라이드? 기능"
    ,"RecyclerView는 View가 화면을 벗어날 때 그 View들을 버리지 않고 재활용하는데 Adapter의 서브클래스와 ViewHolder의 서브 클래스가 함께 동작해야 한다. 즉 ViewHolder는 하나의 View를 보존하는 일을 한다."
    ,"  Adalter는 ListView와 실제 데이터의 중간 역할을 하는 추상 인터페이스이다. 원하는대로 데이터만 주면 되도록 서로 분리시키는 것이다."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {//Activity의 생명주기

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    listView = findViewById(R.id.ListView);
    btn = findViewById(R.id.btn1);
    btnTimer= findViewById(R.id.btnTimer);
    btnTimer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,TimerActivity.class);
        startActivity(intent);
        }
    });
    btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RecycleView.class);
                startActivity(intent);

            }
        });
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(MainActivity.this,items[i],Toast.LENGTH_LONG).show();


        }

    });
        ViewPager pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(2);

        MoviePagerAdapter adapter = new MoviePagerAdapter(getSupportFragmentManager());

        Main2Activity fragment1 = new Main2Activity();
        adapter.addItem(fragment1);

        Main3Activity fragment2 = new Main3Activity();
        adapter.addItem(fragment2);

        pager.setAdapter(adapter);
    }
    class MoviePagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MoviePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item) {
            items.add(item);
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }

    }


}

