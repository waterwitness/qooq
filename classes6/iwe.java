import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStorySelectPendant;
import com.tencent.biz.qqstory.takevideo.pendant.PendantPageAdapter;
import com.tencent.biz.qqstory.takevideo.pendant.PendantPageTabAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iwe
  implements ViewPager.OnPageChangeListener
{
  private iwe(NewStorySelectPendant paramNewStorySelectPendant)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    SLog.a("Q.qqstory.record.NewStorySelectPendant", "onPageSelected %d", Integer.valueOf(paramInt));
    NewStorySelectPendant.a(this.a).a(NewStorySelectPendant.a(this.a).b(paramInt));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */