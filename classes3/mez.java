import QQService.EVIPSPEC;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;

public class mez
  implements Runnable
{
  public mez(QQSettingMe paramQQSettingMe, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label292;
        }
        Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (localObject1 != null))
        {
          localObject1 = ((FriendsManager)localObject1).c(this.jdField_a_of_type_JavaLangString);
          if (localObject1 != null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard;
            if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
              break label293;
            }
            b = 1;
            ((Card)localObject2).bQQVipOpen = b;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard;
            if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
              break label298;
            }
            b = 1;
            ((Card)localObject2).bSuperVipOpen = b;
            this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard.iQQVipType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_QQVIP);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard.bSuperVipOpen == 1)
            {
              i = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
              ((Card)localObject2).iQQVipLevel = i;
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard);
            this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new mfa(this));
            return;
          }
          int i = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_QQVIP);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label292;
        }
        Object localObject2 = new StringBuilder().append("updateLevelAndVip error card ");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqDataCard != null)
        {
          localObject1 = "not null";
          QLog.d("QQSettingRedesign", 2, (String)localObject1);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      String str = "null";
      continue;
      label292:
      return;
      label293:
      byte b = 0;
      continue;
      label298:
      b = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */