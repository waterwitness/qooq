import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class och
  extends QidianBusinessObserver
{
  public och(StrangerChatPie paramStrangerChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, HashMap paramHashMap)
  {
    if (((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024)) && (paramBoolean) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramHashMap.uin)))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 1025;
        }
        paramHashMap = this.a.jdField_a_of_type_ComTencentQidianQidianManager.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramHashMap != null)
        {
          StrangerChatPie.a(this.a, true);
          StrangerChatPie.a(this.a).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          StrangerChatPie.a(this.a).setOnClickListener(null);
          StrangerChatPie.b(this.a).setText(paramHashMap);
          if (ChatActivityConstants.I) {
            StrangerChatPie.c(this.a).setContentDescription(paramHashMap);
          }
          StrangerChatPie.a(this.a, true);
          this.a.j();
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          return;
          StrangerChatPie.b(this.a, false);
        }
      } while (!QLog.isColorLevel());
      QLog.d("StrangerChatPie", 2, "onGetQidianUserDetailInfo not current curFriendUin");
      return;
    }
    QLog.d("StrangerChatPie", 2, "onGetQidianUserDetailInfo fail");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\och.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */