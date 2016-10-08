package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import ndp;

public class PanelAdapter
  extends PagerAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  PanelRecycleBin jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  int b;
  
  public PanelAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 4;
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin = new PanelRecycleBin();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, ndp paramndp)
  {
    int m = this.jdField_a_of_type_Int;
    int n = this.jdField_b_of_type_Int;
    paramndp.jdField_a_of_type_Int = paramInt;
    int i = 0;
    int j = 0;
    while (j < this.jdField_b_of_type_Int)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramndp.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        PanelAdapter.ViewHolder localViewHolder = (PanelAdapter.ViewHolder)localView.getTag();
        int i1 = m * n * paramInt + i;
        if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          PlusPanel.PluginData localPluginData = (PlusPanel.PluginData)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          if ((localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
          {
            URLDrawable localURLDrawable = (URLDrawable)localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            if (localURLDrawable.getStatus() == 2) {
              localURLDrawable.restartDownload();
            }
          }
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localPluginData.jdField_a_of_type_JavaLangString);
          if (localPluginData.jdField_a_of_type_Boolean)
          {
            localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            label197:
            localViewHolder.jdField_a_of_type_Int = localPluginData.jdField_a_of_type_Int;
            localViewHolder.jdField_b_of_type_Int = localPluginData.jdField_b_of_type_Int;
            localView.setContentDescription(localPluginData.jdField_a_of_type_JavaLangString + "按钮");
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setEnabled(true);
            AccessibilityUtil.a(localView, true);
          }
        }
        for (;;)
        {
          AccessibilityUtil.a(localViewHolder.jdField_a_of_type_AndroidWidgetTextView, false);
          i += 1;
          k += 1;
          break;
          localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label197;
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          localViewHolder.jdField_a_of_type_Int = 0;
          localViewHolder.jdField_b_of_type_Int = 0;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          AccessibilityUtil.a(localView, false);
        }
      }
      j += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View.OnClickListener a()
  {
    return this.jdField_a_of_type_AndroidViewView$OnClickListener;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    for (;;)
    {
      return;
      if (paramInt >= 0)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_AndroidViewViewGroup.getChildCount())
        {
          ndp localndp = (ndp)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localndp != null) && (paramInt == localndp.jdField_a_of_type_Int))
          {
            a(paramInt, localndp);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ndp localndp = (ndp)paramObject;
    ((ViewGroup)paramView).removeView(localndp);
    localndp.a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a((View)paramObject);
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
      return 0;
    }
    return (this.jdField_a_of_type_JavaUtilArrayList.size() + this.jdField_a_of_type_Int * this.jdField_b_of_type_Int - 1) / (this.jdField_a_of_type_Int * this.jdField_b_of_type_Int);
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean) {
      return -2;
    }
    if (((paramObject instanceof ndp)) && (((ndp)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconAdapter", 2, "instantiateItem " + paramInt);
    }
    ndp localndp = (ndp)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a();
    Object localObject;
    if (localndp != null)
    {
      localObject = localndp.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localndp.getTag()).intValue() != XPanelContainer.e))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a();
        localndp = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localndp;
      if (localndp == null) {
        localObject = new ndp(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((ndp)localObject).jdField_a_of_type_Int = paramInt;
      a(paramInt, (ndp)localObject);
      if ((((ndp)localObject).getParent() != paramView) && (paramInt < getCount())) {
        ((ViewGroup)paramView).addView((View)localObject);
      }
      return localObject;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\PanelAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */