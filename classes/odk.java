import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.Set;

public class odk
  implements Runnable
{
  public odk(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (TroopRemindSettingManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.a.jdField_a_of_type_AndroidWidgetToast = ChatActivityUtils.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131367611));
      this.a.jdField_a_of_type_AndroidWidgetToast.show();
      TroopRemindSettingManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    Object localObject = (DiscussionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if ((localObject != null) && (((DiscussionManager)localObject).a.contains(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ((DiscussionManager)localObject).a.remove(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    localObject = (TroopAppMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
    if (localObject != null)
    {
      if (this.a.dV != ((TroopAppMgr)localObject).a())
      {
        this.a.dV = ((TroopAppMgr)localObject).a();
        this.a.b.sendEmptyMessage(4);
      }
      if ((!((TroopAppMgr)localObject).a()) || (((TroopAppMgr)localObject).b())) {
        ((TroopAppMgr)localObject).a(true);
      }
    }
    localObject = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if ((localObject != null) && (((TroopManager)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) != null)) {
      this.a.b.sendEmptyMessage(6);
    }
    TVKTroopVideoManager.a(this.a.jdField_a_of_type_AndroidContentContext);
    int j;
    int i;
    if (TVK_SDKMgr.isInstalled(this.a.jdField_a_of_type_AndroidContentContext.getApplicationContext()))
    {
      j = 0;
      i = NetworkUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      if (i != 1) {
        break label396;
      }
      i = 0;
    }
    for (;;)
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "BizTechReport", "", "TVKVideo", "install", 0, j, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, String.valueOf(i), "", "");
      return;
      j = 1;
      break;
      label396:
      if (i == 2) {
        i = 3;
      } else if (i == 3) {
        i = 2;
      } else if (i == 4) {
        i = 1;
      } else {
        i = 4;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\odk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */