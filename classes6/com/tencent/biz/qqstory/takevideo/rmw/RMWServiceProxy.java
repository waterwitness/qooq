package com.tencent.biz.qqstory.takevideo.rmw;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iyu;
import iyw;
import iyx;
import iyy;
import java.util.LinkedList;
import java.util.Observer;
import java.util.Queue;

public class RMWServiceProxy
{
  public static final int a = 0;
  private static RMWServiceProxy jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy;
  private static final String jdField_a_of_type_JavaLangString = "RMWServiceProxy";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private Messenger jdField_a_of_type_AndroidOsMessenger;
  private SimpleObservable jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwSimpleObservable;
  private iyy jdField_a_of_type_Iyy;
  private Queue jdField_a_of_type_JavaUtilQueue;
  private final Messenger b;
  private int e;
  private int f;
  
  private RMWServiceProxy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = 0;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwSimpleObservable = new SimpleObservable();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.f = 5;
    this.b = new Messenger(new iyx(this));
  }
  
  public static RMWServiceProxy a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy == null) {
      jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy = new RMWServiceProxy();
    }
    jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy.a(paramContext.getApplicationContext());
    return jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 2: 
      return "CONNECTED";
    case 1: 
      return "CONNECTING";
    case 0: 
      return "DISCONNECTED";
    }
    return "DISCONNECTING";
  }
  
  private void a(ComponentName paramComponentName)
  {
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.e = 0;
    RMWLog.b("RMWServiceProxy", "onServiceDisconnected " + a(this.e));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwSimpleObservable.notifyObservers(new ServiceStateEvent(this.e));
    if (this.jdField_a_of_type_Iyy != null)
    {
      this.jdField_a_of_type_Iyy.a();
      this.jdField_a_of_type_Iyy = null;
    }
  }
  
  private void a(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      paramIBinder.linkToDeath(new iyu(this, paramComponentName), 0);
      this.jdField_a_of_type_AndroidOsMessenger = new Messenger(paramIBinder);
      this.e = 2;
      RMWLog.b("RMWServiceProxy", "onServiceConnected " + a(this.e));
      a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwSimpleObservable.notifyObservers(new ServiceStateEvent(this.e));
      return;
    }
    catch (RemoteException paramComponentName)
    {
      RMWLog.c("RMWServiceProxy", "linkToDeath failed : " + paramComponentName);
      new Handler(Looper.getMainLooper()).postDelayed(new iyw(this), 1000L);
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(Message paramMessage, boolean paramBoolean)
  {
    Messenger localMessenger = this.jdField_a_of_type_AndroidOsMessenger;
    if (localMessenger != null)
    {
      localMessage = Message.obtain(paramMessage);
      paramMessage.recycle();
      if (localMessage.replyTo == null) {
        localMessage.replyTo = this.b;
      }
    }
    while (!paramBoolean) {
      try
      {
        Message localMessage;
        RMWLog.b("RMWServiceProxy", "client.send : " + RMWProto.a(localMessage));
        localMessenger.send(localMessage);
        return;
      }
      catch (RemoteException paramMessage)
      {
        RMWLog.c("RMWServiceProxy", "sendMessageToService error", new Object[] { paramMessage });
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilQueue.offer(paramMessage);
  }
  
  private void a(boolean paramBoolean)
  {
    RMWLog.a("RMWServiceProxy", "setup, current state = " + a(this.e) + ", force = " + paramBoolean);
    d();
    switch (this.e)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    if (paramBoolean) {
      this.f = 5;
    }
    if (this.f > 0)
    {
      this.f -= 1;
      RMWLog.c("RMWServiceProxy", "setup again because of remote died, retry count left = " + this.f);
      this.e = 1;
      RMWLog.a("RMWServiceProxy", "connecting ... " + a(this.e));
      if (this.jdField_a_of_type_Iyy == null) {
        this.jdField_a_of_type_Iyy = new iyy(this);
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, RMWService.class);
      this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, this.jdField_a_of_type_Iyy, 1);
      return;
    }
    RMWLog.c("RMWServiceProxy", "give up setup again");
  }
  
  private void b(Message paramMessage)
  {
    RMWLog.b("RMWServiceProxy", "client.handle : " + RMWProto.a(paramMessage));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwSimpleObservable.notifyObservers(new RMWEvent(paramMessage));
    paramMessage.recycle();
  }
  
  private static void d()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("should invoke at main thread");
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  public void a()
  {
    Messenger localMessenger = this.jdField_a_of_type_AndroidOsMessenger;
    if (localMessenger != null) {
      for (;;)
      {
        Message localMessage = (Message)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (localMessage == null) {
          break;
        }
        if (localMessage.replyTo == null) {
          localMessage.replyTo = this.b;
        }
        try
        {
          RMWLog.b("RMWServiceProxy", "client.flush : " + RMWProto.a(localMessage));
          localMessenger.send(localMessage);
        }
        catch (RemoteException localRemoteException)
        {
          RMWLog.c("RMWServiceProxy", "sendMessageToService error", new Object[] { localRemoteException });
        }
      }
    }
    RMWLog.b("RMWServiceProxy", "can not flushMessageQueue, service state invalid : " + a(this.e));
  }
  
  public void a(Message paramMessage)
  {
    a(paramMessage, false);
  }
  
  public void a(Observer paramObserver)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwSimpleObservable.addObserver(paramObserver);
    paramObserver.update(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwSimpleObservable, new ServiceStateEvent(this.e));
  }
  
  public void b()
  {
    a(true);
  }
  
  public void b(Observer paramObserver)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwSimpleObservable.deleteObserver(paramObserver);
  }
  
  public void c()
  {
    RMWLog.a("RMWServiceProxy", "tearDown, current state = " + a(this.e));
    d();
    switch (this.e)
    {
    default: 
      return;
    }
    a(Message.obtain(null, 7, 0, 0), false);
    a(Message.obtain(null, 8, 0, 0), false);
    a(Message.obtain(null, 9, 0, 0), false);
    a(Message.obtain(null, 10, 0, 0), false);
    this.jdField_a_of_type_AndroidContentContext.unbindService(this.jdField_a_of_type_Iyy);
    a(null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwSimpleObservable.deleteObservers();
    this.jdField_a_of_type_JavaUtilQueue.clear();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\rmw\RMWServiceProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */