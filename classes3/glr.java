import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class glr
  extends ControlUIObserver
{
  public glr(RandomDoubleActivity paramRandomDoubleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomDoubleActivity", 2, "onChangeUI_ShowToolbar");
    }
    if ((this.a.a.a().f != 2) || (this.a.a.f)) {}
    while (this.a.a.a().c()) {
      return;
    }
    this.a.l();
    this.a.m();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\glr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */