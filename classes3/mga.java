import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.data.ApolloRedTouchInfo;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.task.ApolloActionTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class mga
  extends Handler
{
  public mga(QQSettingMe paramQQSettingMe, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      int i;
      do
      {
        do
        {
          return;
          this.a.j();
          return;
          QQSettingMe.a(this.a);
          return;
        } while (this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null);
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().b();
        if (this.a.jdField_e_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, "Bubble");
          this.a.jdField_e_of_type_Boolean = false;
        }
        paramMessage = ApolloActionTask.a(5, this.a.jdField_e_of_type_Int, true);
        i = this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, 5, ApolloActionManager.a().b() + 1000000, paramMessage[0], paramMessage[1]);
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (i != 0));
      paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("apollo_sp", 0);
      if (paramMessage.getBoolean(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "apollo_settingme_first_enter", true))
      {
        ApolloActionManager.a().a.set(2);
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().b(2, 1, this.a.jdField_e_of_type_Int, "点我进入商城", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        paramMessage.edit().putBoolean(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "apollo_settingme_first_enter", false).commit();
        return;
      }
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_a_of_type_Boolean) || (paramMessage.getInt(this.a.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.c, 0) == this.a.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.b));
    ApolloActionManager.a().a.set(2);
    this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().b(2, 1, this.a.jdField_e_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramMessage.edit().putInt(this.a.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.c, this.a.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.b).commit();
    this.a.jdField_e_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "apollo redtouch play bubtext=" + this.a.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_a_of_type_JavaLangString + " and ts = " + this.a.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.b);
    }
    VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotShow", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.d });
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */