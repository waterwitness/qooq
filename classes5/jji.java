import android.hardware.Camera;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class jji
  implements Runnable
{
  jji(jjh paramjjh)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidHardwareCamera == null) {
      return;
    }
    try
    {
      this.a.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
      ScannerView.b(this.a.jdField_a_of_type_ComTencentBizWidgetsScannerView, true);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */