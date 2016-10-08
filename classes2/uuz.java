import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;

public class uuz
  implements Runnable
{
  public uuz(AbsStructMsgElement paramAbsStructMsgElement1, AbsStructMsgElement paramAbsStructMsgElement2, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    int j = -1;
    int i = j;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgElement.m)) {}
    try
    {
      i = Integer.parseInt(this.b.m);
      if (PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgElement.n, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        j = 1;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgElement.n, "0X80055C7", "0X80055C7", i, 0, Long.toString(l), Long.toString(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgElement.a), this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgElement.c, Integer.toString(j));
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        i = j;
        continue;
        j = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uuz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */