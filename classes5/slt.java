import android.os.SystemClock;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.business.viareport.OpenSdkStatic;

public class slt
  implements Runnable
{
  public slt(ForwardSdkShareOption paramForwardSdkShareOption, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      OpenSdkStatic.a().a(0, "SHARE_CHECK_AGENT", this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkShareOption.b), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\slt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */