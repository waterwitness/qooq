package com.tencent.mobileqq.msf.sdk;

import android.os.Bundle;
import com.tencent.mobileqq.msf.core.c.r;
import com.tencent.mobileqq.msf.core.c.r.a;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

class j
{
  private String _bootBroadcastName;
  protected int appid;
  IErrorHandler errorHandler;
  protected final LinkedBlockingQueue highPriorityMessagePairs = new LinkedBlockingQueue();
  protected String msfServiceName;
  protected String processName;
  protected final LinkedBlockingQueue serviceRespMessagePairs = new LinkedBlockingQueue();
  private Object syncQueueLock = new Object();
  
  public boolean addServicePushMsg(FromServiceMsg arg1)
  {
    if ((??? == null) || (???.getServiceCmd() == null)) {
      return false;
    }
    if (k.c.contains(???.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThreadSplit", 2, "addServicePushMsg, high priority added, " + ???.getServiceCmd());
      }
      ???.extraData.putInt(k.a, getQueueSize());
    }
    for (boolean bool = this.highPriorityMessagePairs.add(new MsfMessagePair(null, ???));; bool = this.serviceRespMessagePairs.add(new MsfMessagePair(null, ???)))
    {
      if (???.getServiceCmd().equals("SharpSvr.s2c")) {
        r.a().a(r.a.e, ???.getWupBuffer(), 0);
      }
      synchronized (this.syncQueueLock)
      {
        this.syncQueueLock.notify();
        return bool;
      }
    }
  }
  
  public boolean addServiceRespMsg(MsfMessagePair arg1)
  {
    boolean bool;
    if ((???.fromServiceMsg != null) && (???.fromServiceMsg.getServiceCmd() != null) && (k.c.contains(???.fromServiceMsg.getServiceCmd())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThreadSplit", 2, "addServiceRespMsg, high priority added, " + ???.fromServiceMsg.getServiceCmd());
      }
      ???.fromServiceMsg.extraData.putInt(k.a, getQueueSize());
      ???.fromServiceMsg.extraData.putLong(k.b, System.currentTimeMillis());
      bool = this.highPriorityMessagePairs.add(???);
    }
    synchronized (this.syncQueueLock)
    {
      this.syncQueueLock.notify();
      return bool;
      bool = this.serviceRespMessagePairs.add(???);
    }
  }
  
  public String getBootBroadcastName()
  {
    return this._bootBroadcastName;
  }
  
  public IErrorHandler getErrorHandler()
  {
    return this.errorHandler;
  }
  
  public int getQueueSize()
  {
    return this.serviceRespMessagePairs.size() + this.highPriorityMessagePairs.size();
  }
  
  public LinkedBlockingQueue getRespMsgQueue()
  {
    if (this.highPriorityMessagePairs.size() > 0) {
      return this.highPriorityMessagePairs;
    }
    return this.serviceRespMessagePairs;
  }
  
  public MsfMessagePair getServiceRespMsg()
  {
    if (this.highPriorityMessagePairs.size() > 0) {
      return (MsfMessagePair)this.highPriorityMessagePairs.poll();
    }
    return (MsfMessagePair)this.serviceRespMessagePairs.poll();
  }
  
  public void initSub(String paramString1, int paramInt, String paramString2, IErrorHandler paramIErrorHandler)
  {
    this.appid = paramInt;
    setBootBroadcastName(paramString2);
    this.processName = paramString1;
    this.errorHandler = paramIErrorHandler;
  }
  
  public void queueWait()
  {
    try
    {
      synchronized (this.syncQueueLock)
      {
        if ((this.serviceRespMessagePairs.size() == 0) && (this.highPriorityMessagePairs.size() == 0)) {
          this.syncQueueLock.wait();
        }
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public void setBootBroadcastName(String paramString)
  {
    this._bootBroadcastName = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */