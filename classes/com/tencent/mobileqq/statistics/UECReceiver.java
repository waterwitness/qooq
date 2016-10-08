package com.tencent.mobileqq.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;

public class UECReceiver
  extends BroadcastReceiver
{
  public UECReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      if ("Success".equals(BaseApplicationImpl.sInjectResult)) {
        try
        {
          paramContext = UEC.a;
          if (paramContext != null)
          {
            paramIntent = paramIntent.getParcelableArrayListExtra("UECData");
            Iterator localIterator = paramIntent.iterator();
            while (localIterator.hasNext())
            {
              UEC.UECItem localUECItem = (UEC.UECItem)localIterator.next();
              localUECItem.a = (localUECItem.a + "_" + ThreadOptimizer.a().a());
            }
            paramContext.a(paramIntent);
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\statistics\UECReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */