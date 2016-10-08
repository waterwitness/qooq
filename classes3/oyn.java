import com.tencent.mobileqq.activity.recent.AnonymousEntranceView;
import com.tencent.mobileqq.activity.recent.RecommendCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oyn
  implements Runnable
{
  public oyn(RecommendCallHelper paramRecommendCallHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a == null)
    {
      this.a.b = false;
      return;
    }
    this.a.a.a();
    this.a.a.postDelayed(new oyo(this), AnonymousEntranceView.a());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oyn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */