import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqstory.view.EmptySupportViewPager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

public class izr
  implements ViewPager.OnPageChangeListener
{
  public izr(EmptySupportViewPager paramEmptySupportViewPager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.a.a != null)
    {
      Iterator localIterator = this.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrollStateChanged(paramInt);
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.a.a != null)
    {
      Iterator localIterator = this.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.a.a != null)
    {
      Iterator localIterator = this.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageSelected(paramInt);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */