import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jjg
  implements Runnable
{
  public jjg(ScannerView paramScannerView, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Thread.sleep(1000L);
      Camera localCamera = this.jdField_a_of_type_ComTencentBizWidgetsScannerView.a;
      if (localCamera == null)
      {
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView.b.obtainMessage(10, Boolean.FALSE).sendToTarget();
        return;
      }
      ScannerView.a(this.jdField_a_of_type_ComTencentBizWidgetsScannerView, localCamera, this.jdField_a_of_type_Boolean);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jjg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */