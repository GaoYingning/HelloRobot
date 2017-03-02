package com.demo.sisyphus.hellorobot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etMsg;
    private Button btnSend;
    private RecyclerView rvChat;

    ChatAdapter chatAdapter;
    private ArrayList<Msg> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        btnSend.setOnClickListener(this);
    }

    private void initView(){
        etMsg = (EditText) findViewById(R.id.et_msg);
        btnSend = (Button) findViewById(R.id.btn_send);

        rvChat = (RecyclerView) findViewById(R.id.rv_chat);
        rvChat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        list = new ArrayList<>();
        list.add(new Msg("hello", 1));
        list.add(new Msg("我是图灵机器人", 1));
        list.add(new Msg("很高兴可以给你解答问题", 1));

        chatAdapter = new ChatAdapter(this, list);
        rvChat.setAdapter(chatAdapter);
    }

    @Override
    public void onClick(View v) {
        list.add(new Msg(etMsg.getText().toString(), 0));
        chatAdapter.notifyItemInserted(chatAdapter.getItemCount()-1);
        rvChat.smoothScrollToPosition(chatAdapter.getItemCount()-1);
    }
}
