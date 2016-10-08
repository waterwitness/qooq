import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;

public class wlq
  implements Runnable
{
  public wlq(CustomHorizontalScrollView paramCustomHorizontalScrollView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.a.getScrollX();
    if (i == CustomHorizontalScrollView.a(this.a))
    {
      int j = i % (CustomHorizontalScrollView.b(this.a) + CustomHorizontalScrollView.c(this.a));
      if (CustomHorizontalScrollView.d(this.a) + i >= CustomHorizontalScrollView.e(this.a)) {
        return;
      }
      if (j < CustomHorizontalScrollView.b(this.a) / 2) {
        this.a.smoothScrollBy(-j, 0);
      }
      for (;;)
      {
        CustomHorizontalScrollView.a(this.a, i);
        return;
        if (j >= CustomHorizontalScrollView.b(this.a) / 2)
        {
          int k = CustomHorizontalScrollView.b(this.a);
          int m = CustomHorizontalScrollView.c(this.a);
          this.a.smoothScrollBy(k + m - j, 0);
        }
      }
    }
    CustomHorizontalScrollView.a(this.a, i);
    CustomHorizontalScrollView.a(this.a).postDelayed(CustomHorizontalScrollView.a(this.a), 5L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wlq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */