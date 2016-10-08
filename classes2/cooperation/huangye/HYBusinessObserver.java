package cooperation.huangye;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HYBusinessObserver
  implements BusinessObserver
{
  public static final int a = 0;
  
  public HYBusinessObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBoolean, (HYBusinessPhone)paramObject);
  }
  
  public void a(boolean paramBoolean, HYBusinessPhone paramHYBusinessPhone) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HYBusinessObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */