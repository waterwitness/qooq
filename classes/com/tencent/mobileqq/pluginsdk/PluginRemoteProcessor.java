package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.mobileqq.pluginsdk.ipc.PluginRemoteService.Sub1;
import com.tencent.mobileqq.pluginsdk.ipc.PluginRemoteService.Sub2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginRemoteProcessor
{
  private static PluginRemoteProcessor d;
  private volatile boolean a;
  private LinkedList b = new LinkedList();
  private Handler c = new Handler(Looper.getMainLooper());
  
  private void a(a parama)
  {
    Object localObject = null;
    switch (a.c(parama))
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "processInner, " + parama + ", " + localObject);
      }
      if (localObject != null) {
        break;
      }
    }
    do
    {
      return;
      localObject = PluginRemoteService.Sub1.class;
      break;
      localObject = PluginRemoteService.Sub2.class;
      break;
      Context localContext = a.b(parama).getApplicationContext();
      localObject = new Intent(localContext, (Class)localObject);
      ((Intent)localObject).putExtra("key_binder_type", a.c(parama));
      try
      {
        localContext.bindService((Intent)localObject, parama, 1);
        return;
      }
      catch (SecurityException parama) {}
    } while (!QLog.isColorLevel());
    QLog.i("plugin_tag", 2, "processInner", parama);
  }
  
  private void a(a parama, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "processInnerDelay. " + paramInt + ", " + parama);
    }
    this.c.postDelayed(new i(this, parama), paramInt);
  }
  
  public static PluginRemoteProcessor get()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new PluginRemoteProcessor();
      }
      return d;
    }
    finally {}
  }
  
  public void cancel(ServiceConnection paramServiceConnection)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (a.a(locala) == paramServiceConnection) {
          a.b(locala).unbindService(locala);
        }
      }
      return;
    }
  }
  
  public void process(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginRemoteProcessor.process, " + paramInt);
    }
    paramServiceConnection = new a(paramServiceConnection, ???, paramInt);
    if (this.a)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "queue");
      }
      synchronized (this.b)
      {
        this.b.offer(paramServiceConnection);
        return;
      }
    }
    this.a = true;
    a(paramServiceConnection);
  }
  
  private class a
    implements ServiceConnection
  {
    private ServiceConnection b;
    private Context c;
    private int d;
    
    public a(ServiceConnection paramServiceConnection, Context paramContext, int paramInt)
    {
      this.b = paramServiceConnection;
      this.c = paramContext;
      this.d = paramInt;
    }
    
    public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
    {
      do
      {
        try
        {
          this.c.getApplicationContext().unbindService(this);
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "onServiceConnected, " + this);
          }
          this.b.onServiceConnected(???, paramIBinder);
        }
        catch (Exception localException)
        {
          synchronized (PluginRemoteProcessor.a(PluginRemoteProcessor.this))
          {
            do
            {
              paramIBinder = (a)PluginRemoteProcessor.a(PluginRemoteProcessor.this).poll();
              if (paramIBinder == null) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "continue process");
              }
              PluginRemoteProcessor.a(PluginRemoteProcessor.this, paramIBinder, 300);
              return;
              localException = localException;
            } while (!QLog.isColorLevel());
            QLog.i("plugin_tag", 2, "unbindService, " + this);
          }
        }
        PluginRemoteProcessor.a(PluginRemoteProcessor.this, false);
      } while (!QLog.isColorLevel());
      QLog.i("plugin_tag", 2, "queue empty");
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "onServiceDisconnected, " + this);
      }
      this.b.onServiceDisconnected(paramComponentName);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\PluginRemoteProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */