package com.may.maystream.testfirbase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private Button btn_show_token,btn_sub,btn_un;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_show_token = (Button)findViewById(R.id.btn_show_token);
        btn_sub = (Button)findViewById(R.id.btn_sub);
        btn_un = (Button)findViewById(R.id.btn_un);
        mTextView = (TextView)findViewById(R.id.txt);
    }

    public void showToken(View view) {
        // แสดง token มาให้ดูหน่อยเสะ
        mTextView.setText(FirebaseInstanceId.getInstance().getToken());
        Log.i("token", FirebaseInstanceId.getInstance().getToken());
    }
    public void subscribe(View view) {
        // สับตะไคร้หัวข้อ news
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        mTextView.setText("Subscribed to New Topic");
    }
    public void unsubscribe(View view) {
        // ยกเลิกสับตะไคร้หัวข้อ news
        FirebaseMessaging.getInstance().unsubscribeFromTopic("news");
        mTextView.setText("Unsubscribed to New Topic");
    }
}
