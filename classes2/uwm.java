import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio;
import com.tencent.mobileqq.transfile.PAAudioPttDownloadProcessor;
import java.io.File;

public class uwm
  implements View.OnClickListener
{
  public uwm(StructMsgItemPAAudio paramStructMsgItemPAAudio)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(this.a.s)) {
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        str = PAAudioPttDownloadProcessor.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.r);
        if (TextUtils.isEmpty(str))
        {
          this.a.a();
          this.a.a(this.a.s, paramView);
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005C9B", "0X8005C9B", 0, 1, 0, this.a.s, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.a.q, this.a.r);
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (new File(str).exists())
      {
        if (this.a.jdField_a_of_type_Boolean) {
          this.a.d();
        } else {
          this.a.c();
        }
      }
      else
      {
        this.a.a();
        this.a.a(this.a.s, paramView);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uwm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */