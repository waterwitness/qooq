package com.tencent.biz.qqstory.pgc;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.pgc.view.BaseContentPagerView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class QQStoryContentActivity$ContentPagerAdaper
  extends PagerAdapter
{
  public QQStoryContentActivity$ContentPagerAdaper(QQStoryContentActivity paramQQStoryContentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (paramInt < this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
      paramViewGroup.removeView((View)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    }
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    ((BaseContentPagerView)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).setOnPagerChangedListener(this.a);
    paramViewGroup.addView((View)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    if ((paramInt == this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem()) && (paramInt == 0)) {
      ((BaseContentPagerView)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).e();
    }
    return this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\QQStoryContentActivity$ContentPagerAdaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */