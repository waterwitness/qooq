import com.tencent.av.utils.CharacterUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.QZoneFeedsServlet;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.NewIntent;

public final class ksf
  implements Runnable
{
  public ksf(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject;
    long l1;
    if (ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0, new int[] { 63521 });
      long l2 = 0L;
      l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (((List)localObject).size() == 1) {
          l1 = ((MessageRecord)((List)localObject).get(0)).time;
        }
      }
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneFeedsServlet.class);
      ((NewIntent)localObject).putExtra("selfuin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    }
    try
    {
      ((NewIntent)localObject).putExtra("hostuin", new long[] { CharacterUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) });
      ((NewIntent)localObject).putExtra("lasttime", l1);
      ChatActivityFacade.a().jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ChatActivityFacade.a().jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(ChatActivityFacade.a());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(ChatActivityFacade.a(), 1, "Long.valueOf " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ksf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */