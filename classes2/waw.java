import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;

public class waw
  implements Runnable
{
  public waw(JumpAction paramJumpAction, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (JumpAction.a(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction) != null)
    {
      NearbyProcessMonitor.b(JumpAction.a(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction).a());
      ReportController.b(JumpAction.a(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction), "CliOper", "", "", "0X8005D3B", "0X8005D3B", this.jdField_a_of_type_Int, 0, "", "", JumpAction.a(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction).getAccount(), "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\waw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */