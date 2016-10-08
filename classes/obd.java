import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class obd
  implements BusinessObserver
{
  public obd(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "success:" + String.valueOf(paramBoolean));
    }
    int k = 1;
    paramInt = 1;
    int j;
    if (!paramBoolean)
    {
      this.a.s(2131364487);
      j = paramInt;
    }
    for (;;)
    {
      if (j != 0) {
        this.a.aD();
      }
      return;
      j = paramInt;
      if (!paramBoolean) {
        continue;
      }
      int i = k;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        j = paramInt;
        if (paramBundle == null) {
          continue;
        }
        i = k;
        mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
        i = k;
        localFollowResponse.mergeFrom(paramBundle);
        i = k;
        j = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (j == 0)
        {
          i = k;
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
          i = k;
          paramBundle = (PublicAccountDataManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
          if (paramBundle != null)
          {
            i = k;
            paramBundle = paramBundle.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
            if (paramBundle != null)
            {
              i = k;
              if (this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null)
              {
                i = k;
                this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11));
              }
              i = k;
              this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(paramBundle);
              paramInt = 1;
              break label456;
            }
          }
        }
        label456:
        for (;;)
        {
          i = paramInt;
          this.a.J = true;
          i = paramInt;
          this.a.O = true;
          i = paramInt;
          this.a.aE();
          j = paramInt;
          i = paramInt;
          if (!this.a.af) {
            break;
          }
          j = paramInt;
          i = paramInt;
          if (PublicAccountChatPie.a(this.a) == null) {
            break;
          }
          i = paramInt;
          PublicAccountChatPie.b(this.a).b();
          j = paramInt;
          break;
          i = k;
          this.a.v();
          paramInt = 0;
          break label456;
          i = k;
          this.a.v();
          paramInt = 0;
          continue;
          if (j == 58)
          {
            i = k;
            this.a.s(2131364494);
            j = paramInt;
            break;
          }
          i = k;
          this.a.s(2131364487);
          j = paramInt;
          break;
        }
      }
      catch (Exception paramBundle)
      {
        j = i;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\obd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */