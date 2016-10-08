package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import puv;

public class CardPayObserver
  implements BusinessObserver
{
  private static Map a;
  
  public CardPayObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (a == null) {
      a = new ConcurrentHashMap();
    }
  }
  
  public static void a()
  {
    if (a != null)
    {
      a.clear();
      a = null;
    }
  }
  
  public static void a(String paramString, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (a != null)
    {
      paramString = new puv(paramString, System.currentTimeMillis());
      a.put(paramString, paramOnInvokeFinishLinstener);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject2;
    Object localObject1;
    RemoteCommand.OnInvokeFinishLinstener localOnInvokeFinishLinstener;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append(paramBoolean).append("/");
      if (paramObject == null)
      {
        localObject1 = null;
        QLog.i("Cardpay BusinessObserver", 2, (String)localObject1);
      }
    }
    else
    {
      localOnInvokeFinishLinstener = null;
      localObject2 = null;
      switch (paramInt)
      {
      default: 
        localObject1 = "";
      }
    }
    for (;;)
    {
      if (a != null) {
        break label110;
      }
      return;
      localObject1 = paramObject.toString();
      break;
      localObject1 = "CardPayControl.queryChannel";
      continue;
      localObject1 = "CardPayControl.queryPayOrder";
    }
    label110:
    Iterator localIterator = a.keySet().iterator();
    if (localIterator.hasNext())
    {
      puv localpuv = (puv)localIterator.next();
      if (!localpuv.jdField_a_of_type_JavaLangString.equals(localObject1)) {
        break label355;
      }
      localOnInvokeFinishLinstener = (RemoteCommand.OnInvokeFinishLinstener)a.get(localpuv);
      localObject2 = localpuv;
    }
    label355:
    for (;;)
    {
      break;
      if (localOnInvokeFinishLinstener != null)
      {
        localObject1 = new Bundle();
        if ((paramObject != null) && ((paramObject instanceof JceStruct))) {
          ((Bundle)localObject1).putSerializable(paramObject.getClass().getSimpleName(), (JceStruct)paramObject);
        }
        localOnInvokeFinishLinstener.onInvokeFinish((Bundle)localObject1);
        if (a != null) {
          a.remove(localObject2);
        }
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          ReportController.a(null, "P_CliOper", "cardpay", "", "sso-req", "finish", paramInt, i, "" + (System.currentTimeMillis() - ((puv)localObject2).jdField_a_of_type_Long), ((puv)localObject2).jdField_a_of_type_JavaLangString, "", "");
          return;
        }
      }
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ReportController.a(null, "P_CliOper", "cardpay", "", "sso-req", "finish", paramInt, i, "-1", "disappear", "", "");
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\CardPayObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */