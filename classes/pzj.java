import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pzj
  implements Runnable
{
  public pzj(LebaHelper paramLebaHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LebaHelper.c(this.a);
    LebaHelper.a(this.a);
    LebaHelper.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */