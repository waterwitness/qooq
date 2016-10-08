import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class kpf
  implements Runnable
{
  kpf(kpe paramkpe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((BaseChatPie.d(this.a.a.a) != null) && (BaseChatPie.d(this.a.a.a).getParent() != null)) {
      ((ViewGroup)BaseChatPie.d(this.a.a.a).getParent()).removeView(BaseChatPie.d(this.a.a.a));
    }
    BaseChatPie.b(this.a.a.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kpf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */