import com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

public class pco
  implements Runnable
{
  public pco(NewPreFlowCamera paramNewPreFlowCamera)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.setProgress((NewPreFlowCamera.a(this.a) + NewPreFlowCamera.b(this.a)) / 2);
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "onProgress setProgress=" + (NewPreFlowCamera.a(this.a) + NewPreFlowCamera.b(this.a)) / 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */