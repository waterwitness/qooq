import android.os.Handler;
import com.tencent.av.ui.BaseCallbackUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gqa
  implements Runnable
{
  public gqa(BaseCallbackUI paramBaseCallbackUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BaseCallbackUI.a(this.a, this.a.c);
    this.a.a.postDelayed(BaseCallbackUI.a(this.a), 400L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gqa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */