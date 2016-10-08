import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hci
  implements Runnable
{
  public hci(ShimmerTextView paramShimmerTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ShimmerTextView localShimmerTextView = this.a;
    localShimmerTextView.a += 1;
    if (this.a.a >= 50) {
      this.a.a = 0;
    }
    this.a.setGradientX(this.a.getWidth() * this.a.a / 50);
    this.a.postInvalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */