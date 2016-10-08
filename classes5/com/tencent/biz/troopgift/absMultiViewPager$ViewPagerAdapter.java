package com.tencent.biz.troopgift;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class absMultiViewPager$ViewPagerAdapter
  extends PagerAdapter
{
  protected ArrayList a;
  
  public absMultiViewPager$ViewPagerAdapter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList();
  }
  
  public ArrayList a()
  {
    return this.a;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.a.get(paramInt));
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)this.a.get(paramInt));
    return this.a.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == (View)paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troopgift\absMultiViewPager$ViewPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */