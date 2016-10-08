package com.tencent.biz.pubaccount.readinjoy.common;

import android.os.HandlerThread;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ReadInJoySSOHandlerThread
  extends HandlerThread
{
  public ReadInJoySSOHandlerThread(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\common\ReadInJoySSOHandlerThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */