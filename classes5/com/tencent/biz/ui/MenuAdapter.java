package com.tencent.biz.ui;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class MenuAdapter
  extends PagerAdapter
  implements CellLayout.OnLayoutListener
{
  public static final int a = 9;
  public static final String a = "MenuAdapter";
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  CustomMenuBar.OnMenuItemClickListener jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener;
  PopupMenuPA.AnimationCallbacks jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks;
  List jdField_a_of_type_JavaUtilList;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  
  public MenuAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(CellLayout paramCellLayout)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.height = paramCellLayout.a();
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a(CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void a(PopupMenuPA.AnimationCallbacks paramAnimationCallbacks)
  {
    this.jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks = paramAnimationCallbacks;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewGroup)paramView).removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int i = 1;
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    while (this.jdField_b_of_type_Int == 2) {
      return 1;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size() / 9;
    if (this.jdField_a_of_type_JavaUtilList.size() % 9 > 0) {}
    for (;;)
    {
      return i + j;
      i = 0;
    }
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1;
    Object localObject2;
    if (this.jdField_b_of_type_Int == 2)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext;
      localObject2 = this.jdField_a_of_type_JavaUtilList;
      if (paramInt == 0) {
        bool1 = true;
      }
      localObject1 = MenuViewFactory.a((Context)localObject1, (List)localObject2, bool1, 2, this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener, this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks != null) {
        ((CellLayout)localObject1).setAnimationCallbacks(this.jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks);
      }
      ((ViewGroup)paramView).addView((View)localObject1);
      if (paramInt == 0) {
        ((CellLayout)localObject1).setOnLayoutListener(this);
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      return localObject1;
    }
    int i = this.jdField_a_of_type_JavaUtilList.size();
    int j = paramInt * 9;
    if (paramInt == getCount() - 1) {}
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList.subList(j, i);
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      bool1 = bool2;
      if (paramInt == 0) {
        bool1 = true;
      }
      localObject1 = MenuViewFactory.a((Context)localObject2, (List)localObject1, bool1, 1, this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener, this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks != null) {
        ((CellLayout)localObject1).setAnimationCallbacks(this.jdField_a_of_type_ComTencentBizUiPopupMenuPA$AnimationCallbacks);
      }
      ((ViewGroup)paramView).addView((View)localObject1);
      break;
      i = j + 9;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ui\MenuAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */