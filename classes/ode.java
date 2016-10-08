import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagStatus;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.os.MqqHandler;
import tencent.im.lbs.member_lbs.NeighbourNumber;
import tencent.im.lbs.member_lbs.RspBody;

public class ode
  extends BizTroopObserver
{
  public ode(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(TroopGagMgr.GagStatus paramGagStatus)
  {
    if ((paramGagStatus.jdField_a_of_type_Int == 2) && (paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$SelfGagInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramGagStatus.jdField_a_of_type_JavaLangString))) {
      this.a.a(paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$SelfGagInfo, true);
    }
  }
  
  protected void a(Object paramObject)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      paramString = (member_lbs.RspBody)paramObject;
      paramObject = (member_lbs.NeighbourNumber)paramString.msg_neighbour_number.get();
      long l2 = ((member_lbs.NeighbourNumber)paramObject).uint64_group_code.get();
      long l1;
      try
      {
        l1 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        l2 = Long.valueOf(l2).longValue();
        if (l1 != l2) {
          continue;
        }
        if (((TroopInfoManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label120;
        }
        this.a.b(false);
        return;
      }
      catch (NumberFormatException paramString) {}
      if (QLog.isColorLevel())
      {
        QLog.d("Q.aio.TroopChatPie.troop.nearby_mem", 2, "onGetNearbyTroopMemberCount NumberFormatException", paramString);
        return;
        label120:
        l1 = ((member_lbs.NeighbourNumber)paramObject).uint64_neighbour_number.get();
        if (l1 > 0L) {
          this.a.b(((member_lbs.NeighbourNumber)paramObject).uint64_neighbour_number.get());
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.TroopChatPie.troop.nearby_mem", 2, "onGetNearbyTroopMemberCount uint64_neighbour_number:" + l1);
        }
        if (paramString.bool_show_tips.get()) {
          try
          {
            paramObject = new String(paramString.str_tips_wording.get().toByteArray(), "UTF-8");
            paramString = new String(paramString.str_tips_web_url.get().toByteArray(), "UTF-8");
            if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)paramObject, paramString);
              return;
            }
          }
          catch (UnsupportedEncodingException paramString) {}
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) {
      return;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2) {}
      for (String str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131364897);; str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131364898))
      {
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 2, str, 1).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        this.a.d(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 1, 2131364899, 1).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    long l = ((Long)paramObject).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "onGetTroopNewGuide isSuccess = " + paramBoolean + ", troopUin = " + l);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(l))))
    {
      paramObject = new odf(this);
      ThreadManager.b().post((Runnable)paramObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */