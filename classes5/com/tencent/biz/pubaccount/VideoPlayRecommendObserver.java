package com.tencent.biz.pubaccount;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class VideoPlayRecommendObserver
  implements BusinessObserver
{
  public static final int a = 1;
  
  public VideoPlayRecommendObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject != null) {}
    try
    {
      a(paramBoolean, (ArrayList)paramObject);
      return;
    }
    catch (Exception paramObject) {}
    a(false, new ArrayList(0));
    return;
  }
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\VideoPlayRecommendObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */