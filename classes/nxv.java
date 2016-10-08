import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class nxv
  extends QidianBusinessObserver
{
  public nxv(FriendChatPie paramFriendChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, HashMap paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramHashMap.uin)))
      {
        paramHashMap = this.a.jdField_a_of_type_ComTencentQidianQidianManager.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        if (paramHashMap != null)
        {
          FriendChatPie.a(this.a, true);
          FriendChatPie.a(this.a).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          FriendChatPie.a(this.a).setOnClickListener(null);
          FriendChatPie.b(this.a).setText(paramHashMap);
          if (ChatActivityConstants.I) {
            FriendChatPie.c(this.a).setContentDescription(paramHashMap);
          }
          FriendChatPie.b(this.a, true);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
        FriendChatPie.b(this.a, false);
        return;
      } while (!QLog.isColorLevel());
      QLog.d(FriendChatPie.an, 2, "onGetQidianUserDetailInfo not current curFriendUin");
      return;
    }
    QLog.d(FriendChatPie.an, 2, "onGetQidianUserDetailInfo fail");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nxv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */