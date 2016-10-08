import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.qphone.base.util.QLog;

public class qhw
  implements Runnable
{
  public qhw(VideoBroadcastReceiver paramVideoBroadcastReceiver, int paramInt, String paramString1, String paramString2, String paramString3, Context paramContext, String paramString4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localSessionInfo.d = this.jdField_a_of_type_JavaLangString;
    Object localObject;
    if (this.jdField_a_of_type_Int == 1006)
    {
      localSessionInfo.jdField_a_of_type_JavaLangString = this.b;
      localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
      if (localObject != null) {
        localSessionInfo.e = (((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo);
      }
    }
    for (;;)
    {
      ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localSessionInfo, this.d);
      do
      {
        return;
        if (this.jdField_a_of_type_Int != 1000) {
          break label215;
        }
        localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.b);
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(VideoBroadcastReceiver.jdField_a_of_type_JavaLangString, 2, "findTroopInfo fail ,uin : " + this.b);
      return;
      localSessionInfo.jdField_a_of_type_JavaLangString = this.c;
      localSessionInfo.b = ((TroopInfo)localObject).troopcode;
      localSessionInfo.c = ((TroopInfo)localObject).troopuin;
      continue;
      label215:
      if (this.jdField_a_of_type_Int == 1004)
      {
        localSessionInfo.jdField_a_of_type_JavaLangString = this.c;
        localSessionInfo.b = this.b;
      }
      else
      {
        localSessionInfo.jdField_a_of_type_JavaLangString = this.c;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qhw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */