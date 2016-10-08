import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.qphone.base.util.QLog;

public class vwk
  implements Runnable
{
  public vwk(SnapshotService paramSnapshotService, vwr paramvwr, vwp paramvwp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "start once debug, webview id =" + vwr.a(this.jdField_a_of_type_Vwr) + ", seq=" + this.jdField_a_of_type_Vwp.a);
    }
    this.jdField_a_of_type_Vwr.a.a.invalidate();
    if (this.jdField_a_of_type_Vwr.a.a.getX5WebViewExtension() != null) {
      this.jdField_a_of_type_Vwr.a.a.loadUrl("javascript:window.scrollTo(0, 0);");
    }
    for (;;)
    {
      SnapshotService.a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService, this.jdField_a_of_type_Vwp, this.jdField_a_of_type_Vwr);
      return;
      this.jdField_a_of_type_Vwr.a.a.pageUp(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vwk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */