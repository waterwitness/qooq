import android.content.Context;
import android.content.res.Resources;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class kny
  implements Runnable
{
  public kny(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
    ((FontManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    try
    {
      this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841690);
      this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841691);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.aio.BaseChatPie", 2, "emo qvip_emoji_aio_face_new_default_fail, e=" + localException.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */