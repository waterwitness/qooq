package com.tencent.mobileqq.businessCard;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.BusinessObserver;

public class BusinessCardObserver
  implements BusinessObserver
{
  public static final String a = "BusinessCard_observer";
  
  public BusinessCardObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void b(boolean paramBoolean, String paramString) {}
  
  public void b(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramInt = paramBundle.getInt("resp_result", 0);
      b(paramBoolean, paramBundle.getString("key_card_id"), paramInt);
      return;
    case 2: 
      b(paramBoolean, paramBundle.getString("key_card_id"));
      return;
    case 3: 
      a(paramBoolean, paramBundle.getString("key_card_id"));
      return;
    case 4: 
      a(paramBoolean);
      return;
    }
    a(paramBoolean, paramBundle.getString("key_card_id"), paramBundle.getInt("key_get_detail_type"));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\businessCard\BusinessCardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */