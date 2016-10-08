import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class qwp
  implements Runnable
{
  qwp(qwn paramqwn)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((QLog.isColorLevel()) && (this.a.a.a != null)) {
      QLog.w("BusinessCard_FlowCameraPhotoActivity", 2, "onSend error " + this.a.a.a.toString() + "errorCode=" + this.a.a.a.a);
    }
    this.a.a.e();
    QQToast.a(this.a.a, 2131371231, 1).a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qwp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */