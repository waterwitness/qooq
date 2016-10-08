import android.app.Activity;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class yjp
  implements Runnable
{
  public yjp(AppInterface paramAppInterface, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface.isLogin()) && (!PublicAccountUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "2711679534"))) {
        PublicAccountUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, "2711679534", null, false);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yjp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */