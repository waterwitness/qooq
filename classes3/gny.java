import android.os.Handler;
import com.tencent.av.smallscreen.BaseSmallScreenService;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gny
  implements Runnable
{
  public gny(BaseSmallScreenService paramBaseSmallScreenService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.a.d)
    {
      boolean bool = SmallScreenUtils.c(((AppInterface)BaseSmallScreenService.a(this.a)).a());
      if (bool != this.a.e)
      {
        this.a.e = bool;
        this.a.e();
      }
      bool = SmallScreenUtils.a();
      if (bool != this.a.b)
      {
        this.a.b = bool;
        this.a.d();
      }
      bool = SmallScreenUtils.b(((AppInterface)BaseSmallScreenService.b(this.a)).a());
      if (bool != this.a.c)
      {
        this.a.c = bool;
        this.a.c();
      }
      this.a.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */