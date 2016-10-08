import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class nzp
  extends Handler
{
  public nzp(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 5: 
    case 8: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    case 9: 
    case 7: 
      do
      {
        do
        {
          SharedPreferences localSharedPreferences;
          do
          {
            long l;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                      } while (((this.a.af) && ((!this.a.ag) || (((PublicAccountDataManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) == null))) || (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()));
                      try
                      {
                        this.a.aI();
                        return;
                      }
                      catch (Exception paramMessage)
                      {
                        paramMessage.printStackTrace();
                        return;
                      }
                      paramMessage = this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a());
                      this.a.c(paramMessage);
                    } while ((paramMessage == null) || (paramMessage.isEmpty()));
                    this.a.g(true);
                    return;
                    this.a.aG();
                    this.a.aF();
                  } while (this.a.dR == 1);
                  this.a.dU = 5;
                  return;
                } while ((this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) || (this.a.d == null) || (!this.a.d.isShowing()));
                this.a.d.dismiss();
                QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131367671, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
                return;
              } while (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing());
              localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
              l = localSharedPreferences.getLong("switch_city" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0L);
              if (System.currentTimeMillis() - l >= 86400000L) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("Q.aio.BaseChatPie", 2, "switch_city no time =" + (System.currentTimeMillis() - l));
            return;
          } while (paramMessage.arg2 != 1);
          int i = paramMessage.arg1;
          PublicAccountChatPie.a(this.a, DialogUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 230, null, String.format("定位到你当前所在城市在%s，是否切换？", new Object[] { (String)paramMessage.obj }), "否", "是", new nzq(this, i), new nzr(this, localSharedPreferences)));
          PublicAccountChatPie.a(this.a).show();
          return;
          paramMessage = paramMessage.getData();
        } while (paramMessage == null);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a.put(paramMessage.getString("troopUin"), Integer.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessage.getString("troopUin"), 1)));
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.d();
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.e();
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.c();
        return;
      } while (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null);
      this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.H();
      this.a.R = false;
      return;
    }
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */