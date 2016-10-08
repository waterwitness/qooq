package com.tencent.biz;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import hfm;
import java.util.ArrayList;

public class PoiMapActivity$ShopListAdapter
  extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  int c;
  int d;
  
  public PoiMapActivity$ShopListAdapter(PoiMapActivity paramPoiMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Int = 0;
    this.d = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public PoiMapActivity.Shops a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (PoiMapActivity.Shops)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.a((int)(PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity) * 1000000.0D), (int)(PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity) * 1000000.0D), this.jdField_c_of_type_Int, 10);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.b(paramString);
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    if (this.jdField_c_of_type_Int != paramInt1) {
      return;
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 8;
    int j = this.jdField_a_of_type_ComTencentBizPoiMapActivity.getResources().getDimensionPixelSize(2131493277);
    int k = this.jdField_a_of_type_ComTencentBizPoiMapActivity.getResources().getDimensionPixelSize(2131493278);
    Object localObject2 = a(paramInt);
    Object localObject1;
    if (this.d == 0) {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2130903726, null);
        localObject1 = new PoiMapActivity.ShopHolderView(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299865));
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299867));
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131299859);
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_b_of_type_AndroidViewView = paramView.findViewById(2131299860);
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299868));
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299869));
        ((PoiMapActivity.ShopHolderView)localObject1).e = ((TextView)paramView.findViewById(2131299871));
        ((PoiMapActivity.ShopHolderView)localObject1).f = ((TextView)paramView.findViewById(2131299872));
        ((PoiMapActivity.ShopHolderView)localObject1).g = ((TextView)paramView.findViewById(2131299870));
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_c_of_type_AndroidViewView = paramView.findViewById(2131299864);
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_d_of_type_AndroidViewView = paramView.findViewById(2131299863);
        paramView.setTag(localObject1);
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_c_of_type_AndroidViewView.setBackgroundDrawable(null);
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_c_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ComTencentBizPoiMapActivity.e);
        if (paramInt != this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label295;
        }
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_c_of_type_AndroidViewView.setVisibility(8);
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_d_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup = paramView;
      }
    }
    label295:
    label577:
    label618:
    label623:
    do
    {
      do
      {
        do
        {
          return paramViewGroup;
          localObject1 = (PoiMapActivity.ShopHolderView)paramView.getTag();
          break;
          paramViewGroup = paramView;
        } while (!(localObject2 instanceof PoiMapActivity.GeneralShops));
        paramViewGroup = (PoiMapActivity.GeneralShops)localObject2;
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_c_of_type_AndroidViewView.setVisibility(0);
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_d_of_type_AndroidViewView.setVisibility(8);
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.e);
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_Int);
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(paramViewGroup.a);
        ((PoiMapActivity.ShopHolderView)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.a);
        if (!TextUtils.isEmpty(paramViewGroup.f))
        {
          localObject2 = URLDrawable.getDrawable(paramViewGroup.f, j, k);
          ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          ((URLDrawable)localObject2).setURLDrawableListener(new hfm(this, ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetImageView));
          ((PoiMapActivity.ShopHolderView)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(paramViewGroup.jdField_b_of_type_JavaLangString);
          localObject2 = new SpannableString(paramViewGroup.jdField_c_of_type_JavaLangString);
          ((SpannableString)localObject2).setSpan(new StrikethroughSpan(), 0, paramViewGroup.jdField_c_of_type_JavaLangString.length(), 33);
          ((PoiMapActivity.ShopHolderView)localObject1).e.setText((CharSequence)localObject2);
          ((PoiMapActivity.ShopHolderView)localObject1).e.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.a);
          ((PoiMapActivity.ShopHolderView)localObject1).f.setText(paramViewGroup.d);
          ((PoiMapActivity.ShopHolderView)localObject1).f.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.a);
          ((PoiMapActivity.ShopHolderView)localObject1).g.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.a);
          localObject2 = ((PoiMapActivity.ShopHolderView)localObject1).jdField_b_of_type_AndroidViewView;
          if (paramViewGroup.jdField_c_of_type_Int != 0) {
            break label618;
          }
          paramInt = 8;
          ((View)localObject2).setVisibility(paramInt);
          localObject1 = ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidViewView;
          if (paramViewGroup.jdField_b_of_type_Int != 0) {
            break label623;
          }
        }
        for (;;)
        {
          ((View)localObject1).setVisibility(i);
          return paramView;
          ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          break;
          paramInt = 0;
          break label577;
          i = 0;
        }
        paramViewGroup = paramView;
      } while (this.d != 1);
      if (paramView != null) {
        break label993;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2130903727, null);
      localObject1 = new PoiMapActivity.ShopHolderView(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_c_of_type_AndroidViewView = paramView.findViewById(2131299864);
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131299873));
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299865));
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299867));
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131299859);
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_b_of_type_AndroidViewView = paramView.findViewById(2131299860);
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299874));
      ((PoiMapActivity.ShopHolderView)localObject1).e = ((TextView)paramView.findViewById(2131299871));
      ((PoiMapActivity.ShopHolderView)localObject1).h = ((TextView)paramView.findViewById(2131299876));
      ((PoiMapActivity.ShopHolderView)localObject1).i = ((TextView)paramView.findViewById(2131299875));
      paramView.setTag(localObject1);
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_c_of_type_AndroidViewView.setBackgroundDrawable(null);
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_c_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ComTencentBizPoiMapActivity.e);
      paramViewGroup = paramView;
    } while (!(localObject2 instanceof PoiMapActivity.SingleShops));
    paramViewGroup = (PoiMapActivity.SingleShops)localObject2;
    ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.e);
    ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_Int);
    ((PoiMapActivity.ShopHolderView)localObject1).jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.a);
    if (!TextUtils.isEmpty(paramViewGroup.f))
    {
      localObject2 = URLDrawable.getDrawable(paramViewGroup.f, j, k);
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      label938:
      paramInt = 1;
      label940:
      if (paramInt > 5) {
        break label1051;
      }
      localObject2 = new ImageView(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      if (paramInt * 2 > paramViewGroup.d) {
        break label1017;
      }
      ((ImageView)localObject2).setImageResource(2130839501);
    }
    for (;;)
    {
      paramInt += 1;
      break label940;
      label993:
      localObject1 = (PoiMapActivity.ShopHolderView)paramView.getTag();
      break;
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      break label938;
      label1017:
      if (paramInt * 2 - 1 == paramViewGroup.d) {
        ((ImageView)localObject2).setImageResource(2130839500);
      } else {
        ((ImageView)localObject2).setImageResource(2130839499);
      }
    }
    label1051:
    if ((TextUtils.isEmpty(paramViewGroup.jdField_b_of_type_JavaLangString)) || (paramViewGroup.jdField_b_of_type_JavaLangString.trim().startsWith("0")))
    {
      ((PoiMapActivity.ShopHolderView)localObject1).e.setVisibility(8);
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      ((PoiMapActivity.ShopHolderView)localObject1).i.setText(paramViewGroup.jdField_c_of_type_JavaLangString);
      ((PoiMapActivity.ShopHolderView)localObject1).i.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.a);
      ((PoiMapActivity.ShopHolderView)localObject1).h.setText(paramViewGroup.a);
      ((PoiMapActivity.ShopHolderView)localObject1).h.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.a);
      localObject2 = ((PoiMapActivity.ShopHolderView)localObject1).jdField_a_of_type_AndroidViewView;
      if (paramViewGroup.jdField_b_of_type_Int != 0) {
        break label1230;
      }
      paramInt = 8;
      label1168:
      ((View)localObject2).setVisibility(paramInt);
      localObject1 = ((PoiMapActivity.ShopHolderView)localObject1).jdField_b_of_type_AndroidViewView;
      if (paramViewGroup.jdField_c_of_type_Int != 0) {
        break label1235;
      }
    }
    for (;;)
    {
      ((View)localObject1).setVisibility(i);
      return paramView;
      ((PoiMapActivity.ShopHolderView)localObject1).e.setVisibility(0);
      ((PoiMapActivity.ShopHolderView)localObject1).jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      ((PoiMapActivity.ShopHolderView)localObject1).e.setText(paramViewGroup.jdField_b_of_type_JavaLangString);
      break;
      label1230:
      paramInt = 0;
      break label1168;
      label1235:
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\PoiMapActivity$ShopListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */