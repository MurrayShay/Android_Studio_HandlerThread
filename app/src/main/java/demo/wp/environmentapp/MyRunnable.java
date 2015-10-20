package demo.wp.environmentapp;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by Owner on 2015/10/3.
 */
public class MyRunnable implements Runnable {
    Handler uiHandler;
    MyRunnable(Handler uiHandler)
    {
        this.uiHandler=uiHandler;
    }
    @Override
    public void run() {
        for (int i=0;i<1000000;i++)
        {
            Log.i("mylog", i + "");
            //從UIThread的Looper的MessageQueue取得Message Object
            Message msg=uiHandler.obtainMessage();
            //自訂訊息碼，供handlerMessage判斷訊息用途
            msg.what=1;
            //設定Message物件中的屬性值
            msg.arg1=i;
            uiHandler.sendMessage(msg);
        }
    }
}
