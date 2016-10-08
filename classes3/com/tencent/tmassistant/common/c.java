package com.tencent.tmassistant.common;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.tmassistantbase.a.j;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmassistantsdk.internal.b.a;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.ArrayList;
import java.util.Iterator;

public class c
  extends Handler
{
  protected static c a = null;
  protected static HandlerThread b = null;
  
  private c(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public static c a()
  {
    try
    {
      if (a == null)
      {
        b = new HandlerThread("TMAssistantDownloadSDKMessageThread");
        b.start();
        a = new c(b.getLooper());
      }
      c localc = a;
      return localc;
    }
    finally {}
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener)
  {
    if ((paramITMAssistantDownloadClientListener == null) || (paramTMAssistantDownloadClient == null)) {
      return;
    }
    Message localMessage = a().obtainMessage();
    localMessage.what = 3;
    localMessage.obj = new j(paramTMAssistantDownloadClient, paramITMAssistantDownloadClientListener);
    localMessage.sendToTarget();
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((paramITMAssistantDownloadClientListener == null) || (paramTMAssistantDownloadClient == null)) {
      return;
    }
    Message localMessage = a().obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new j(paramTMAssistantDownloadClient, paramITMAssistantDownloadClientListener);
    paramTMAssistantDownloadClient = new Bundle();
    paramTMAssistantDownloadClient.putString("url", paramString1);
    paramTMAssistantDownloadClient.putInt("state", paramInt1);
    paramTMAssistantDownloadClient.putInt("errorCode", paramInt2);
    paramTMAssistantDownloadClient.putString("errorMsg", paramString2);
    localMessage.setData(paramTMAssistantDownloadClient);
    localMessage.sendToTarget();
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener, String paramString, long paramLong1, long paramLong2)
  {
    if ((paramITMAssistantDownloadClientListener == null) || (paramTMAssistantDownloadClient == null))
    {
      m.c("TMAssistantDownloadSDKMessageThread", "listenr:" + paramITMAssistantDownloadClientListener + " === sdkClient" + paramTMAssistantDownloadClient);
      return;
    }
    Message localMessage = a().obtainMessage();
    localMessage.what = 2;
    localMessage.obj = new j(paramTMAssistantDownloadClient, paramITMAssistantDownloadClientListener);
    paramTMAssistantDownloadClient = new Bundle();
    paramTMAssistantDownloadClient.putString("url", paramString);
    paramTMAssistantDownloadClient.putLong("receiveDataLen", paramLong1);
    paramTMAssistantDownloadClient.putLong("totalDataLen", paramLong2);
    localMessage.setData(paramTMAssistantDownloadClient);
    localMessage.sendToTarget();
  }
  
  public void a(byte[] paramArrayOfByte, ArrayList<a> paramArrayList)
  {
    if ((paramArrayOfByte != null) && (paramArrayList != null))
    {
      Message localMessage = a().obtainMessage();
      localMessage.what = 4;
      localMessage.obj = new j(paramArrayOfByte, paramArrayList);
      localMessage.sendToTarget();
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      Object localObject2 = (j)paramMessage.obj;
      Object localObject1 = (TMAssistantDownloadClient)((j)localObject2).a;
      localObject2 = (ITMAssistantDownloadClientListener)((j)localObject2).b;
      Object localObject3 = paramMessage.getData();
      paramMessage = ((Bundle)localObject3).getString("url");
      int i = ((Bundle)localObject3).getInt("state");
      int j = ((Bundle)localObject3).getInt("errorCode");
      localObject3 = ((Bundle)localObject3).getString("errorMsg");
      if (localObject2 != null)
      {
        ((ITMAssistantDownloadClientListener)localObject2).OnDownloadSDKTaskStateChanged((TMAssistantDownloadClient)localObject1, paramMessage, i, j, (String)localObject3);
        return;
        localObject2 = (j)paramMessage.obj;
        localObject1 = (TMAssistantDownloadClient)((j)localObject2).a;
        localObject2 = (ITMAssistantDownloadClientListener)((j)localObject2).b;
        paramMessage = paramMessage.getData();
        localObject3 = paramMessage.getString("url");
        long l1 = paramMessage.getLong("receiveDataLen");
        long l2 = paramMessage.getLong("totalDataLen");
        if (localObject2 != null)
        {
          ((ITMAssistantDownloadClientListener)localObject2).OnDownloadSDKTaskProgressChanged((TMAssistantDownloadClient)localObject1, (String)localObject3, l1, l2);
          return;
          localObject1 = (j)paramMessage.obj;
          paramMessage = (TMAssistantDownloadClient)((j)localObject1).a;
          localObject1 = (ITMAssistantDownloadClientListener)((j)localObject1).b;
          if (localObject1 != null)
          {
            ((ITMAssistantDownloadClientListener)localObject1).OnDwonloadSDKServiceInvalid(paramMessage);
            return;
            localObject1 = (j)paramMessage.obj;
            paramMessage = (byte[])((j)localObject1).a;
            localObject1 = (ArrayList)((j)localObject1).b;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (a)((Iterator)localObject1).next();
                if (localObject2 != null) {
                  ((a)localObject2).a(paramMessage);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistant\common\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */