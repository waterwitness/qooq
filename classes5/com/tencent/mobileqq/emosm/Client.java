package com.tencent.mobileqq.emosm;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.emosm.web.IPCConstants;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import rgr;
import rgs;

public class Client
  implements IPCConstants
{
  public static final String tag = "Q.emoji.web.Client";
  private ServiceConnection mConnection;
  public boolean mIsBound;
  public final Messenger mMessenger;
  public Messenger mService;
  
  public Client()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mService = null;
    this.mMessenger = new Messenger(new rgs(this, Looper.getMainLooper()));
    this.mConnection = new rgr(this);
  }
  
  public void doBindService(Context paramContext)
  {
    try
    {
      paramContext.bindService(new Intent(paramContext, MessengerService.class), this.mConnection, 1);
      this.mIsBound = true;
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.Client", 2, "Binding...");
      }
      return;
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        this.mIsBound = false;
        if (QLog.isColorLevel()) {
          QLog.e("Q.emoji.web.Client", 2, paramContext.getMessage());
        }
      }
    }
  }
  
  public void doUnbindService(Context paramContext)
  {
    if ((!this.mIsBound) || (this.mService != null)) {}
    try
    {
      Message localMessage = Message.obtain(null, 2);
      localMessage.replyTo = this.mMessenger;
      this.mService.send(localMessage);
      try
      {
        paramContext.unbindService(this.mConnection);
        this.mService = null;
        this.mIsBound = false;
        if (QLog.isColorLevel()) {
          QLog.i("Q.emoji.web.Client", 2, "Unbinding.");
        }
        return;
      }
      catch (IllegalArgumentException paramContext)
      {
        for (;;) {}
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public boolean isClientBinded()
  {
    return this.mService != null;
  }
  
  public void onDisconnectWithService()
  {
    WebIPCOperator.a().b();
  }
  
  public void onPushMsgFromServer(Bundle paramBundle)
  {
    WebIPCOperator.a().d(paramBundle);
  }
  
  public boolean onReqToServer(Bundle paramBundle)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if (this.mService != null) {
      bool2 = bool3;
    }
    try
    {
      Message localMessage = Message.obtain(null, 3, 0, 0);
      bool2 = bool3;
      localMessage.replyTo = this.mMessenger;
      bool2 = bool3;
      localMessage.setData(paramBundle);
      bool2 = bool3;
      this.mService.send(localMessage);
      boolean bool4 = true;
      bool3 = true;
      bool1 = bool3;
      bool2 = bool4;
      if (QLog.isColorLevel())
      {
        bool2 = bool4;
        QLog.i("Q.emoji.web.Client", 2, "req to server");
        bool1 = bool3;
      }
      return bool1;
    }
    catch (RemoteException paramBundle)
    {
      this.mService = null;
    }
    return bool2;
  }
  
  public void onRespFromServer(Bundle paramBundle)
  {
    try
    {
      WebIPCOperator.a().c(paramBundle);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      try
      {
        QLog.e("Q.emoji.web.Client", 2, "onRespFromServer bundle error:" + paramBundle);
        return;
      }
      catch (Throwable paramBundle)
      {
        QLog.e("Q.emoji.web.Client", 2, "print error");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\Client.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */