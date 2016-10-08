import com.tencent.mobileqq.businessCard.views.BusinessCardView;
import com.tencent.mobileqq.businessCard.views.BusinessCardViewScroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qxe
  implements Runnable
{
  public qxe(BusinessCardView paramBusinessCardView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Float localFloat = Float.valueOf(this.a.a.a() - BusinessCardView.a(this.a));
    if (Math.abs(localFloat.floatValue()) < 0.05F)
    {
      BusinessCardViewScroller localBusinessCardViewScroller = this.a.a;
      if (localFloat.floatValue() > 0.0F) {}
      for (int i = BusinessCardViewScroller.a;; i = BusinessCardViewScroller.b)
      {
        localBusinessCardViewScroller.a(i);
        this.a.removeCallbacks(BusinessCardView.a(this.a));
        return;
      }
    }
    BusinessCardView.a(this.a, this.a.a.a());
    this.a.removeCallbacks(BusinessCardView.a(this.a));
    this.a.postDelayed(BusinessCardView.a(this.a), 100L);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */