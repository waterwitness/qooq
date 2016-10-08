import android.database.DataSetObserver;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import com.tencent.biz.qqstory.view.EmptySupportViewPager;
import com.tencent.biz.qqstory.view.PagerIndicator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class izw
  extends DataSetObserver
  implements ViewPager.OnPageChangeListener
{
  private izw(PagerIndicator paramPagerIndicator)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChanged()
  {
    Log.d("PagerIndicator", "onChanged");
    this.a.a(this.a.a.getCurrentItem(), this.a.a.getAdapter());
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Log.d("PagerIndicator", "onPageSelected : " + paramInt);
    this.a.a(this.a.a.getCurrentItem(), this.a.a.getAdapter());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */