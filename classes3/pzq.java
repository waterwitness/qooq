import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class pzq
  implements Runnable
{
  public pzq(MayknowRecommendManager paramMayknowRecommendManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (MayknowRecommendManager.a(this.a).a.a() == 1)
    {
      MayknowRecommendManager.b(this.a);
      return;
    }
    MayknowRecommendManager.a(this.a).postDelayed(this, 5000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */