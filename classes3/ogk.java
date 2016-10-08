import com.tencent.mobileqq.activity.bless.CountDownView;
import com.tencent.mobileqq.activity.bless.CountDownView.CountDownFinishedListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ogk
  implements Runnable
{
  public ogk(CountDownView paramCountDownView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((CountDownView.a(this.a)) && (CountDownView.a(this.a) >= CountDownView.a().length))
    {
      this.a.b();
      if (CountDownView.a(this.a) != null) {
        CountDownView.a(this.a).t();
      }
    }
    while (CountDownView.a(this.a) >= CountDownView.a().length) {
      return;
    }
    CountDownView.a(this.a);
    this.a.setImageResource(CountDownView.a()[CountDownView.a(this.a)]);
    this.a.postDelayed(CountDownView.a(this.a), 1000L);
    CountDownView.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ogk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */