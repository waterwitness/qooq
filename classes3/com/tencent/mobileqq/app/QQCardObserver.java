package com.tencent.mobileqq.app;

import QCARD.CollectCouponRsp;
import QCARD.GetCollectItemMobileRsp;
import QCARD.GetListRsp;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QQCardObserver
  implements BusinessObserver
{
  public QQCardObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    String str2 = null;
    String str1 = null;
    Bundle localBundle;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      c(paramBoolean, (GetListRsp)paramObject);
      return;
    case 2: 
      a(paramBoolean, (GetListRsp)paramObject);
      return;
    case 3: 
      b(paramBoolean, (GetListRsp)paramObject);
      return;
    case 4: 
      d(paramBoolean, (GetListRsp)paramObject);
      return;
    case 5: 
      c(paramBoolean, (GetListRsp)paramObject);
      return;
    case 6: 
      localBundle = (Bundle)paramObject;
      str2 = localBundle.getString("recommend_card_id");
      paramObject = str1;
      if (paramBoolean) {
        paramObject = (CollectCouponRsp)localBundle.getSerializable("recommend_card_rsp");
      }
      a(paramBoolean, str2, (CollectCouponRsp)paramObject);
      return;
    case 7: 
      localBundle = (Bundle)paramObject;
      str1 = localBundle.getString("recommend_card_id");
      paramObject = str2;
      if (paramBoolean) {
        paramObject = (GetCollectItemMobileRsp)localBundle.getSerializable("recommend_card_rsp");
      }
      a(paramBoolean, str1, (GetCollectItemMobileRsp)paramObject);
      return;
    }
    a();
  }
  
  public void a(boolean paramBoolean, GetListRsp paramGetListRsp) {}
  
  public void a(boolean paramBoolean, String paramString, CollectCouponRsp paramCollectCouponRsp) {}
  
  public void a(boolean paramBoolean, String paramString, GetCollectItemMobileRsp paramGetCollectItemMobileRsp) {}
  
  public void b(boolean paramBoolean, GetListRsp paramGetListRsp) {}
  
  public void c(boolean paramBoolean, GetListRsp paramGetListRsp) {}
  
  public void d(boolean paramBoolean, GetListRsp paramGetListRsp) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\QQCardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */