package demo.wp.environmentapp;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Handler uiHandler=new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1)
                tv.setText(msg.arg1+"");

        }
    };
    Handler threadHandler;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        tv=(TextView)findViewById(R.id.textView);
        //啟動具有Looper和MessageQueue的新工作執行緒
        HandlerThread t=new HandlerThread("WorkThread");
        t.start();
        //工作執行緒的經理人並將工作執行緒的循環器傳入(管理工作執行緒的MessageQueue)
        threadHandler=new Handler(t.getLooper());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button)
        {
            MyRunnable runnable=new MyRunnable(uiHandler);
            //將runnable傳入工作執行緒的MessageQueue
            threadHandler.post(runnable);
        }
    }
}




