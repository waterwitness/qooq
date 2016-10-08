import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.now.NowProxy;

public class lym
  implements Runnable
{
  public lym(Now paramNow)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((NowProxy)this.a.a.getManager(181)).a(BaseApplicationImpl.getContext());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lym.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */