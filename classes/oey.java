import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class oey
  implements Runnable
{
  public oey(TipsManager paramTipsManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (TipsManager.a(this.a) != null) {
      TipsManager.a(this.a).a();
    }
    TipsManager.a(this.a, null);
    if (this.a.a != null) {
      this.a.a.clear();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */