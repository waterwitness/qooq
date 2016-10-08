import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.HYControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gui
  extends GAudioUIObserver
{
  public gui(HYControlUI paramHYControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt)
  {
    if (this.a.a.a().u) {
      this.a.m(paramInt);
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (!paramString1.equals(this.a.t)) {
      return;
    }
    this.a.g(paramString2);
  }
  
  protected void g()
  {
    this.a.k = true;
  }
  
  protected void h()
  {
    this.a.k = false;
    this.a.m(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */