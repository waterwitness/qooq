import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.qphone.base.util.QLog;

public class pxr
  implements Runnable
{
  public pxr(FrameHelperActivity paramFrameHelperActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((FrameHelperActivity.a(this.a)) || (this.a.getActivity() == null) || (this.a.getActivity().app == null)) {
      return;
    }
    String str = this.a.getActivity().app.a();
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.a.getActivity().app, 1, str);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "FrameHelperActivity, updateSelfFace:" + str);
    }
    this.a.a.obtainMessage(12, localFaceDrawable).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */