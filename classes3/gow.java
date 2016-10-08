import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.smallscreen.SmallScreenVideoController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gow
  implements Runnable
{
  public gow(SmallScreenVideoController paramSmallScreenVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a == null) {}
    while ((this.a.a.a() == null) || (!this.a.a.a().O)) {
      return;
    }
    this.a.a.a(this.a.a.a().c, 1);
    int i = this.a.a.a().f;
    this.a.a.c(this.a.a.a().c, 21);
    if (i == 1) {
      this.a.a.a().f = 3;
    }
    for (;;)
    {
      this.a.a.a().l = 3000;
      this.a.a.a().g = false;
      this.a.a.a().E = 0;
      return;
      if (i == 2) {
        this.a.a.a().f = 4;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */