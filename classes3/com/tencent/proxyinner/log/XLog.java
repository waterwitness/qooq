package com.tencent.proxyinner.log;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XLog
{
  private static final int D = 1;
  private static final int E = 4;
  private static final int I = 2;
  private static final int V = 0;
  private static final int W = 3;
  private static final int WTF = 5;
  public static XLog sInstance = null;
  private List<Event> mEventList = new ArrayList();
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Bundle localBundle = paramAnonymousMessage.getData();
      if (paramAnonymousMessage.what == 0)
      {
        paramAnonymousMessage = XLog.this.mEventList.iterator();
        while (paramAnonymousMessage.hasNext()) {
          ((XLog.Event)paramAnonymousMessage.next()).onLog(localBundle.getString("tag"), localBundle.getString("msg"), localBundle.getInt("level"));
        }
      }
    }
  };
  private boolean mLogHost = false;
  
  public static final int d(String paramString1, String paramString2)
  {
    return getInstance().Log(paramString1, paramString2, 1);
  }
  
  public static final int e(String paramString1, String paramString2)
  {
    return getInstance().Log(paramString1, paramString2, 4);
  }
  
  public static XLog getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new XLog();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static final int i(String paramString1, String paramString2)
  {
    return getInstance().Log(paramString1, paramString2, 2);
  }
  
  public static void perfLog(String paramString)
  {
    Log.i("XProxy_Perf", paramString + " Time = " + System.currentTimeMillis());
  }
  
  public final int Log(String paramString1, String paramString2, int paramInt)
  {
    if (this.mLogHost)
    {
      postLogEvent(paramString1, paramString2, paramInt);
      return 0;
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return Log.d(paramString1, paramString2);
    }
    return Log.i(paramString1, paramString2);
  }
  
  public void addListener(Event paramEvent)
  {
    if ((paramEvent != null) && (!this.mEventList.contains(paramEvent))) {
      this.mEventList.add(paramEvent);
    }
  }
  
  public void postLogEvent(String paramString1, String paramString2, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    Bundle localBundle = new Bundle();
    localBundle.putString("tag", paramString1);
    localBundle.putString("msg", paramString2);
    localBundle.putInt("level", paramInt);
    localMessage.setData(localBundle);
    this.mHandler.sendMessage(localMessage);
  }
  
  public void setSourceInfo(boolean paramBoolean)
  {
    this.mLogHost = paramBoolean;
  }
  
  public static abstract interface Event
  {
    public abstract void onLog(String paramString1, String paramString2, int paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\log\XLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */