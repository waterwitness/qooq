import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qlink.QQProxyForQlink;

public class yeq
  implements DialogInterface.OnClickListener
{
  public yeq(QQProxyForQlink paramQQProxyForQlink, ScannerView paramScannerView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.d();
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\yeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */