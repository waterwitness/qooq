package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;

public class GlobalSearchObserver
  implements BusinessObserver
{
  public GlobalSearchObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramObject = (HashMap)paramObject;
      a(paramBoolean, (ArrayList)((HashMap)paramObject).get("mq_kandian_svc_results"), (ArrayList)((HashMap)paramObject).get("mq_kandian_svc_sentences"));
    }
  }
  
  public void a(boolean paramBoolean, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\GlobalSearchObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */