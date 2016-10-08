import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class qwm
  implements Runnable
{
  public qwm(FlowCameraPhotoActivity paramFlowCameraPhotoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      this.a.e();
      QQToast.a(this.a, "扫描超时", 1).a();
    } while (!QLog.isColorLevel());
    QLog.d("BusinessCard_FlowCameraPhotoActivity", 2, "request ocr time out!");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qwm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */