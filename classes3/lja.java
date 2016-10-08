import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class lja
  extends PagerAdapter
{
  public lja(FontSettingActivity paramFontSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)FontSettingActivity.a(this.a).get(paramInt));
  }
  
  public int getCount()
  {
    return FontSettingActivity.a(this.a).size();
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    ((ViewPager)paramView).addView((View)FontSettingActivity.a(this.a).get(paramInt), 0);
    return FontSettingActivity.a(this.a).get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */