package com.tencent.mobileqq.richmedia.dc;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Calendar;
import mqq.os.MqqHandler;
import ugk;
import ugl;
import ugm;
import ugn;
import ugo;
import ugp;
import ugs;

public class DCShortVideo
  extends DataCollector
  implements ReportEvent
{
  public static final String a = DCShortVideo.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DCShortVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.b().post(new ugo(this, paramInt, paramBoolean));
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong)
  {
    if ((paramAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.b().post(new ugm(this, paramAppInterface, paramInt1, paramInt3, paramString, paramInt2, paramLong));
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.b().post(new ugn(this, paramAppInterface, paramInt1, paramInt2, paramString));
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, ugs paramugs)
  {
    paramugs.f = paramInt1;
    if (paramInt2 == 0) {
      paramugs.b = 0;
    }
    for (;;)
    {
      paramAppInterface = (NearbyCardManager)paramAppInterface.getManager(105);
      if (paramAppInterface != null)
      {
        paramugs.d = paramAppInterface.a();
        paramugs.e = paramAppInterface.b();
      }
      paramugs.g = Calendar.getInstance().get(11);
      paramugs.h = NetworkUtil.a(BaseApplication.getContext());
      return;
      if (paramInt2 == 3000)
      {
        paramugs.b = 3000;
      }
      else
      {
        if (paramInt2 == 1)
        {
          if ((paramAppInterface instanceof QQAppInterface)) {
            switch (((QQAppInterface)paramAppInterface).b(paramString))
            {
            default: 
              paramugs.b = 1;
            }
          }
          for (;;)
          {
            paramugs.c = 0;
            TroopManager localTroopManager = (TroopManager)paramAppInterface.getManager(51);
            if (localTroopManager == null) {
              break;
            }
            paramString = localTroopManager.b(paramString);
            if (paramString == null) {
              break;
            }
            paramugs.c = paramString.wMemberNum;
            break;
            paramugs.b = 1;
            continue;
            paramugs.b = 3;
            continue;
            paramugs.b = 4;
            continue;
            paramugs.b = 2;
            continue;
            paramugs.b = 1;
          }
        }
        paramugs.b = 9999;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramQQAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.b().post(new ugl(this, paramQQAppInterface, paramInt1, paramInt2, paramString, paramInt3));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString3, long paramLong, String paramString4)
  {
    if ((paramQQAppInterface != null) && (paramString1 != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.b().post(new ugk(this, paramString1, paramQQAppInterface, paramInt1, paramInt2, paramString2, paramLong, paramString4, paramBoolean1, paramInt3, paramString3, paramBoolean2));
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong)
  {
    ThreadManager.b().post(new ugp(this, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt7, paramInt8, paramLong));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richmedia\dc\DCShortVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */