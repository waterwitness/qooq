import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class slv
  implements Runnable
{
  public slv(ForwardSdkShareOption paramForwardSdkShareOption)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--fetch openid timeout");
      }
      this.a.h = true;
      this.a.r();
    } while (!ForwardSdkShareOption.a(this.a));
    this.a.jdField_a_of_type_AndroidOsBundle.putString("uin", String.valueOf("-1010"));
    this.a.jdField_a_of_type_AndroidOsBundle.putInt("uintype", -1);
    this.a.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", ForwardAbility.ForwardAbilityType.e.intValue());
    this.a.h();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\slv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */