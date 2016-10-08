import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mobileqq.activity.welcomeguide.QQAVFunnyFaceInvest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pnw
  implements SurfaceHolder.Callback
{
  public pnw(QQAVFunnyFaceInvest paramQQAVFunnyFaceInvest)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.e(QQAVFunnyFaceInvest.a, 1, "Play!!! surfaceChanged");
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    QLog.e(QQAVFunnyFaceInvest.a, 1, "Play!!! surfaceCreated");
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    QLog.e(QQAVFunnyFaceInvest.a, 1, "Play!!! surfaceDestroyed");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pnw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */