import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

public class lic
  implements TabBarView.OnTabChangeListener
{
  public lic(EmosmActivity paramEmosmActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    if (paramInt2 == 0) {
      this.a.f = 1;
    }
    for (;;)
    {
      this.a.c = false;
      this.a.runOnUiThread(this.a.a);
      return;
      if (paramInt2 == 1) {
        this.a.f = 2;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */