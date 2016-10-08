import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gor
  implements Runnable
{
  public gor(SmallScreenService paramSmallScreenService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (SmallScreenService.f) {
      this.a.b(2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */