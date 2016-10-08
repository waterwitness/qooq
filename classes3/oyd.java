import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public final class oyd
  implements Runnable
{
  public oyd(QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).size();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "0", "0X80064CB", "0X80064CB", 0, 0, "" + this.jdField_a_of_type_Int, "" + i, "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oyd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */