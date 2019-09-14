package com.bhardwaj.abhishek.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.bhardwaj.abhishek.Adapter.RecyclerAdapter;
import com.bhardwaj.abhishek.model.UserInfo;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private  RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;
    private List<UserInfo> userInfos;
    private ApiInterface apiInterface;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        tv=(TextView)findViewById(R.id.textView);

        // Making a request

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<UserInfo>> call = apiInterface.getUserInfo();

        call.enqueue(new Callback<List<UserInfo>>() {
            @Override
            public void onResponse(Call<List<UserInfo>> call, Response<List<UserInfo>> response) {

                 userInfos = response.body();
                 tv.setText(userInfos.get(1).getTitle());
                recyclerAdapter = new RecyclerAdapter(userInfos);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<UserInfo>> call, Throwable t) {
                Log.d("MAinActivity","On Failure with the request");
            }
        });

    }
}
