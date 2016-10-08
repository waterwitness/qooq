import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.report.ReportCenter;

public class sma
  implements DialogInterface.OnClickListener
{
  public sma(ForwardSdkShareOption paramForwardSdkShareOption)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.c) {
      ReportCenter.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", String.valueOf(this.a.jdField_a_of_type_Long), "1000", "51", "0", false);
    }
    ForwardSdkBaseOption.a(this.a.jdField_a_of_type_AndroidAppActivity, true, "addToQQFavorites", this.a.b);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */