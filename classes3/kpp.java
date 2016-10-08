import android.provider.Settings.System;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class kpp
  implements Runnable
{
  public kpp(BaseChatPie paramBaseChatPie, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Settings.System.putInt(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a().getContentResolver(), "listview_oversroll", this.jdField_a_of_type_Int);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kpp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */