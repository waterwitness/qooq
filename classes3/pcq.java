import com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

public class pcq
  implements Runnable
{
  public pcq(NewPreFlowCamera paramNewPreFlowCamera)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.setProgress((NewPreFlowCamera.a(this.a) + NewPreFlowCamera.b(this.a)) / 2);
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "VideoSoDownloadProgress setProgress=" + (NewPreFlowCamera.a(this.a) + NewPreFlowCamera.b(this.a)) / 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pcq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */