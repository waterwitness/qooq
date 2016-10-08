import android.content.Intent;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

class olf
  implements Runnable
{
  olf(ole paramole, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Ole.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a(32, 16, Integer.valueOf(this.jdField_a_of_type_Int));
    Intent localIntent = new Intent("com.tencent.qq.syncQQMessage");
    this.jdField_a_of_type_Ole.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\olf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */