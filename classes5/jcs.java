import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity.QQDialogCancelListener;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.AppActivity;

class jcs
  extends ScannerActivity.QQDialogCancelListener
{
  jcs(jcr paramjcr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (this.a.b)
    {
      this.a.jdField_a_of_type_ComTencentBizWidgetsScannerView.d();
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentBizWidgetsScannerView.a == true)
    {
      this.a.jdField_a_of_type_MqqAppAppActivity.finish();
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizWidgetsScannerView.b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */