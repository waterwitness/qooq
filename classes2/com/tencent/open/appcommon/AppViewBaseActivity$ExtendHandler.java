package com.tencent.open.appcommon;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import java.io.PrintStream;
import java.lang.ref.WeakReference;

public class AppViewBaseActivity$ExtendHandler
  extends Handler
{
  protected final WeakReference a;
  
  public AppViewBaseActivity$ExtendHandler(AppViewBaseActivity paramAppViewBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramAppViewBaseActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    System.out.println(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (AppViewBaseActivity)this.a.get();
    } while (paramMessage == null);
    try
    {
      paramMessage.g();
      return;
    }
    catch (Exception paramMessage)
    {
      LogUtility.c("AppViewBaseActivity", "extendHandler>>>", paramMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\AppViewBaseActivity$ExtendHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */