package cooperation.weiyun;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.AppRuntime;

public class WeiyunVipHelper
{
  public WeiyunVipHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a()
  {
    return BaseApplicationImpl.a().a().getAccount();
  }
  
  public static boolean a()
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\weiyun\WeiyunVipHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */