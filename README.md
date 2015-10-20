Android HandlerThread 執行緒教學
========================================
在此說明 HandlerThread 使用規則
---------------------------------
#### ★Outline
* 本篇為 Android Handler 執行緒教學的延伸應用  *<https://github.com/MurrayShay/Android_Studio_Handler> <br/>*
* 再前篇一開始提到執行續通訊可以是資料傳遞與方法傳遞，在此為一**方法傳遞**
* HandlerThread 中擁有自己的**Looper(循環器)**和**MessageQueue(訊息佇列)**

##### ★使用範例擷取
 ``` Java
 1 Handler mThreadHandler;
 2 HandlerThread mThread;
 3 
 4 mThread = new HandlerThread("HandlerThread");
 5 mThread.start();
 6 mThreadHandler = new mThreadHandler(mThread.getLooper());
 7 mThreadHandler.post(runnable);
 ```

##### ★範例解說
     1 宣告經紀人變數，在此為mThreadHandler。
     2 宣告具有自己的Looper和MessageQueue的工作執行續，在此為mThread。
     4 實例化 HandlerThread 物件。
     5 啟動 mThread 工作執行續。
     6 實例化 Handler 物件，並為經紀人指定其負責的工作執行續(也可說是其下藝人)
     7 經紀人指派工作給其下藝人去執行
     
相關 API 解釋
---------------------------------
####★HandlerThread 類別
###### 鍵構子
``` JAVA
       HandlerThread(String name) //目前Thread一個別名
       HandlerThread(Looper looper) //指定looper
```
###### 方法**(資料傳遞)**
``` JAVA
       void handlerMessage(Message msg) //處理looper所管理的MessageQueue
       boolean sendMessage(Message msg)
       boolean sendMessageAtFrontOfQueue(Message msg)
       boolean sendMessageAtTime(Message msg, long uptimeMillis)
       boolean sendMessageDelayed(Message msg, long delayMillis)
       void removeMessages(int what) //將MessageQueue中的Message.what與參數what相符的訊息移除
```
