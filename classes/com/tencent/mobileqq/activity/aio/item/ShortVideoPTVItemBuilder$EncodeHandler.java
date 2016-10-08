package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ShortVideoPTVItemBuilder$EncodeHandler
  extends Handler
{
  public ShortVideoPTVItemBuilder$EncodeHandler(Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      do
      {
        return;
        i = paramMessage.arg1;
        paramMessage = paramMessage.getData();
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoPTVItemBuilder", 2, "ret is " + i);
      QLog.i("ShortVideoPTVItemBuilder", 2, "data is " + paramMessage);
      return;
      i = paramMessage.arg1;
      switch (paramMessage.arg1)
      {
      default: 
        return;
      }
      paramMessage = paramMessage.getData().getString("maxvideo.file.mp4");
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoPTVItemBuilder", 2, "ret is " + i);
    QLog.i("ShortVideoPTVItemBuilder", 2, "targetFile is " + paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ShortVideoPTVItemBuilder$EncodeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */