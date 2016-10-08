import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class oub
  extends PagerAdapter
{
  public oub(CommonHbFragment paramCommonHbFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)CommonHbFragment.a(this.a).get(paramInt));
  }
  
  public int getCount()
  {
    if (CommonHbFragment.a(this.a) != null) {
      return CommonHbFragment.a(this.a).size();
    }
    return 0;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    ((ViewPager)paramView).addView((View)CommonHbFragment.a(this.a).get(paramInt), 0);
    return CommonHbFragment.a(this.a).get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */