import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager.PageChangedObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

public class iye
  implements ViewPager.OnPageChangeListener
{
  public iye(FaceViewPager paramFaceViewPager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = FaceViewPager.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((FaceViewPager.PageChangedObserver)localIterator.next()).b(paramInt);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iye.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */