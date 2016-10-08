import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class rbu
  implements Runnable
{
  rbu(rbs paramrbs, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(MessageForNearbyMarketGrayTips.TAG, 4, "0X80052C4");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052C4", "0X80052C4", 0, 0, rbs.a(this.jdField_a_of_type_Rbs).frienduin, "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rbu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */