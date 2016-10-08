package com.tencent.mobileqq.app.proxy.fts;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class FTSSyncHandler
  extends Handler
{
  public static final int a = 1;
  public static final String a = "Q.fts.sync_worker";
  public static final int b = 2;
  private static final int c = 30000;
  private FTSDBManager a;
  
  public FTSSyncHandler(Looper paramLooper, QQAppInterface paramQQAppInterface, FTSDBManager paramFTSDBManager)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramFTSDBManager;
  }
  
  public void a()
  {
    removeCallbacksAndMessages(null);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    ThreadRegulator.a().b();
    super.dispatchMessage(paramMessage);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FTSIndexOperator localFTSIndexOperator = (FTSIndexOperator)paramMessage.obj;
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        if (localFTSIndexOperator.c())
        {
          sendMessageDelayed(obtainMessage(2, localFTSIndexOperator), 30000L);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.fts.sync_worker", 2, "readSyncedCursor is false!!");
      return;
      removeMessages(2, localFTSIndexOperator);
      if (localFTSIndexOperator.d()) {
        localFTSIndexOperator.e();
      }
    } while (this.a.b);
    sendMessageDelayed(obtainMessage(2, localFTSIndexOperator), 30000L);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\proxy\fts\FTSSyncHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */