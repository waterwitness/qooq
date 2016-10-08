import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.qphone.base.util.BaseApplication;

public class uyb
  implements Runnable
{
  public uyb(GroupSystemMsgController paramGroupSystemMsgController, QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("unread_Group_system_msg", this.jdField_a_of_type_Int).commit();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uyb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */