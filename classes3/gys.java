import android.os.Build;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.utils.QQAnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gys
  extends QQAnimationListener
{
  public gys(VideoControlUI paramVideoControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.t();
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    if (!this.a.m) {
      this.a.j(0);
    }
    if ("GT-I9100G".equals(Build.MODEL))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoControlUI", 2, "Model is 9100G, don't do animation");
      }
      return;
    }
    this.a.af();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */