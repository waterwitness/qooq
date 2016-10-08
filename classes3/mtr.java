import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.QZoneFeedsServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.NewIntent;

public class mtr
  implements Runnable
{
  public mtr(TroopMemberCardActivity paramTroopMemberCardActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 0, new int[] { 63521 });
    long l2 = 0L;
    long l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (((List)localObject).size() == 1) {
        l1 = ((MessageRecord)((List)localObject).get(0)).time;
      }
    }
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneFeedsServlet.class);
    ((NewIntent)localObject).putExtra("selfuin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    try
    {
      ((NewIntent)localObject).putExtra("hostuin", new long[] { Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue() });
      ((NewIntent)localObject).putExtra("lasttime", l1);
      TroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(TroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("TroopMemberCardActivity", 1, "Long.valueOf " + this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */