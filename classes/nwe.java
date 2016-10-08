import android.os.Handler;
import android.view.View;
import com.tencent.biz.ui.CustomMenuBar.OnMenuItemClickListener;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class nwe
  implements CustomMenuBar.OnMenuItemClickListener
{
  public nwe(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.l = true;
    this.a.i.setVisibility(0);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 10000L);
    StructMsg.ButtonInfo localButtonInfo = this.a.a(paramInt1);
    EnterpriseQQManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramString, this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a(), localButtonInfo);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Bqq_Crm", "", "Aio_menu", "Clk_menu", 0, 0, this.a.a(), paramInt1 + "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nwe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */