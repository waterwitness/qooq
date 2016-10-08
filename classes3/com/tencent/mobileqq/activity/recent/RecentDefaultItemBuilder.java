package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.IRecentImgv;
import java.util.ArrayList;
import java.util.List;

public class RecentDefaultItemBuilder
  extends RecentItemBaseBuilder
{
  public static final int a = 3;
  public static int b = 0;
  private static final String b = "RecentDefaultItemBuilder";
  private List a;
  
  public RecentDefaultItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private int a(View paramView)
  {
    int i = paramView.getResources().getDisplayMetrics().widthPixels;
    int j = paramView.getPaddingRight();
    int k = paramView.getPaddingLeft();
    paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int m = paramView.leftMargin;
    return i - (paramView.rightMargin + (k + (0 + j) + m));
  }
  
  public static void a(int paramInt, TextView paramTextView, View... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramInt <= 0)) {}
    label211:
    label240:
    label276:
    label283:
    for (;;)
    {
      return;
      int m = paramVarArgs.length;
      int j = 0;
      int i = 0;
      Object localObject;
      if (j < m)
      {
        localObject = paramVarArgs[j];
        if (((View)localObject).getVisibility() == 8) {}
        int k;
        do
        {
          j += 1;
          break;
          if (!(localObject instanceof TextView)) {
            break label240;
          }
          String str = ((TextView)localObject).getText().toString();
          if (TextUtils.isEmpty(str)) {
            break label276;
          }
          TextPaint localTextPaint = ((TextView)localObject).getPaint();
          float f = i;
          i = (int)(localTextPaint.measureText(str) + 0.5F + f);
          i = i + ((View)localObject).getPaddingLeft() + ((View)localObject).getPaddingRight();
          localObject = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
          k = ((LinearLayout.LayoutParams)localObject).leftMargin + i + ((LinearLayout.LayoutParams)localObject).rightMargin;
          i = k;
        } while (k <= paramInt);
        j = 0;
        i = k;
      }
      for (;;)
      {
        if (i == 0) {
          break label283;
        }
        if (j != 0)
        {
          paramVarArgs = paramTextView.getText().toString();
          if (!TextUtils.isEmpty(paramVarArgs))
          {
            j = (int)(paramTextView.getPaint().measureText(paramVarArgs) + 0.5F);
            if (j + i < paramInt) {
              paramInt = 1;
            }
          }
        }
        for (;;)
        {
          paramTextView = (LinearLayout.LayoutParams)paramTextView.getLayoutParams();
          if (paramInt != 0)
          {
            paramTextView.weight = 0.0F;
            return;
            i = ((View)localObject).getWidth() + i;
            break;
            paramInt = 0;
            continue;
          }
          paramTextView.weight = 1.0F;
          return;
          j = 0;
          break label211;
          paramInt = j;
        }
        break;
        j = 1;
      }
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnDragModeChangedListener = null;
    paramViewGroup = paramOnDragModeChangedListener;
    if (paramView != null)
    {
      paramViewGroup = paramOnDragModeChangedListener;
      if ((paramView.getTag() instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder)) {
        paramViewGroup = (RecentDefaultItemBuilder.RecentItemDefaultHolder)paramView.getTag();
      }
    }
    Object localObject;
    if (paramViewGroup == null)
    {
      paramOnDragModeChangedListener = new RecentDefaultItemBuilder.RecentItemDefaultHolder();
      localObject = a(paramContext, 2130904905, paramOnDragModeChangedListener);
      paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131296790));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131298785));
      paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131298399));
      paramOnDragModeChangedListener.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131304700));
      paramOnDragModeChangedListener.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(16908308));
      paramOnDragModeChangedListener.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131297923));
      paramOnDragModeChangedListener.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131299800));
      paramOnDragModeChangedListener.d = ((TextView)((View)localObject).findViewById(2131304701));
      paramOnDragModeChangedListener.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(16908309));
      paramOnDragModeChangedListener.jdField_e_of_type_AndroidWidgetTextView.setGravity(16);
      a((View)localObject, paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetTextView, paramContext);
      ((View)localObject).setTag(paramOnDragModeChangedListener);
      paramView = (View)localObject;
      paramViewGroup = paramOnDragModeChangedListener;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
      {
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
        paramViewGroup = paramOnDragModeChangedListener;
        paramView = (View)localObject;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.j) {
        paramView.setContentDescription(null);
      }
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        localObject = (RecentBaseData)paramObject;
        paramOnDragModeChangedListener = null;
        if (paramRecentFaceDecoder != null) {
          paramOnDragModeChangedListener = paramRecentFaceDecoder.a((RecentBaseData)localObject);
        }
        a(paramView, (RecentBaseData)localObject, paramContext, paramOnDragModeChangedListener);
        if ((paramObject instanceof RecentItemEcShop))
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, Integer.valueOf(paramInt));
          if (AppSetting.j) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(String.format("点击进入%1$s资料卡页面", new Object[] { ((RecentItemEcShop)paramObject).b() }));
          }
        }
      }
      for (;;)
      {
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        if (paramViewGroup != null)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.d.setText("");
          paramViewGroup.jdField_e_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
      }
    }
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int i = paramRecentBaseData.K;
    paramRecentBaseData = paramContext.getResources();
    int j;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      j = 0xF0000 & i;
      if (j != 131072) {
        break label149;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[5]));
      label72:
      j = i & 0xF0;
      if (j != 32) {
        break label179;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[2]));
    }
    for (;;)
    {
      if ((i & 0xF) == 1) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      }
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      label149:
      if (j != 65536) {
        break label72;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[4]));
      break label72;
      label179:
      if (j == 16) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[3]));
      }
    }
  }
  
  public void a(View paramView, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramDrawable == null)) {}
    do
    {
      do
      {
        return;
        paramView = paramView.getTag();
      } while (!(paramView instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder));
      paramView = (RecentDefaultItemBuilder.RecentItemDefaultHolder)paramView;
    } while (paramView.jdField_a_of_type_AndroidWidgetImageView == null);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  protected void a(View paramView, TextView paramTextView, Context paramContext)
  {
    try
    {
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131299798);
      paramView = TimeManager.a().a("000000", 1225168973512L);
      if (TextUtils.isEmpty(paramView))
      {
        paramView = TimeManager.a().a();
        if ((!TextUtils.isEmpty(paramView)) && (paramView.length() != "yyyy-MM-dd".length()))
        {
          i = 1;
          int j;
          if ((b <= 0) || (i != 0))
          {
            f = paramContext.getResources().getDisplayMetrics().density;
            paramContext = paramTextView.getPaint();
            paramTextView = paramContext;
            if (paramContext == null)
            {
              paramTextView = new TextPaint();
              paramTextView.setTextSize(12.0F * f);
            }
            if (i == 0) {
              break label241;
            }
            i = (int)(paramTextView.measureText("yyyy-MM-dd") + f * 6.0F);
            j = (int)(paramTextView.measureText(paramView) + f * 6.0F);
            if (j <= i) {
              break label215;
            }
          }
          label215:
          for (b = j; localLinearLayout.getPaddingRight() < b; b = i)
          {
            i = localLinearLayout.getPaddingLeft();
            j = localLinearLayout.getPaddingTop();
            int k = localLinearLayout.getPaddingBottom();
            int m = b;
            localLinearLayout.setPadding(i, j, b, k);
            return;
          }
        }
      }
    }
    catch (Exception paramView)
    {
      int i;
      float f;
      while (QLog.isDevelopLevel())
      {
        QLog.i("RecentDefaultItemBuilder", 4, paramView.toString());
        return;
        label241:
        b = (int)(paramTextView.measureText("yyyy-MM-dd") + f * 6.0F);
        continue;
        i = 0;
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {}
    do
    {
      do
      {
        return;
        paramView = paramView.getTag();
      } while (!(paramView instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder));
      paramView = (RecentDefaultItemBuilder.RecentItemDefaultHolder)paramView;
    } while (paramView.jdField_b_of_type_AndroidWidgetTextView == null);
    paramView.jdField_b_of_type_AndroidWidgetTextView.setText(paramRecentBaseData.jdField_b_of_type_JavaLangString);
    a(a((View)paramView.jdField_b_of_type_AndroidWidgetTextView.getParent()), paramView.jdField_b_of_type_AndroidWidgetTextView, new View[] { paramView.jdField_c_of_type_AndroidWidgetImageView, paramView.jdField_c_of_type_AndroidWidgetTextView });
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder)) {}
    for (paramContext = (RecentDefaultItemBuilder.RecentItemDefaultHolder)localObject;; paramContext = null)
    {
      if (paramContext == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
        return;
      }
      paramContext.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      localObject = paramRecentBaseData.jdField_b_of_type_JavaLangString;
      CharSequence localCharSequence = paramContext.jdField_b_of_type_AndroidWidgetTextView.getText();
      paramDrawable = (Drawable)localObject;
      if (localObject == null) {
        paramDrawable = "";
      }
      if (!paramDrawable.equals(localCharSequence)) {
        paramContext.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
      }
      int i = paramRecentBaseData.I;
      if (i > 0)
      {
        paramContext.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramContext.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i);
        label168:
        localObject = paramRecentBaseData.jdField_a_of_type_JavaLangCharSequence;
        localCharSequence = paramContext.jdField_c_of_type_AndroidWidgetTextView.getText();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (!TextUtils.isEmpty(paramDrawable)) {
          break label593;
        }
        paramContext.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        a(a((View)paramContext.jdField_b_of_type_AndroidWidgetTextView.getParent()), paramContext.jdField_b_of_type_AndroidWidgetTextView, new View[] { paramContext.jdField_c_of_type_AndroidWidgetImageView, paramContext.jdField_c_of_type_AndroidWidgetTextView });
        localObject = paramRecentBaseData.jdField_c_of_type_JavaLangCharSequence;
        localCharSequence = paramContext.d.getText();
        i = paramContext.d.getCurrentTextColor();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localCharSequence)) {
          paramContext.d.setText(paramDrawable);
        }
        if ((i != paramRecentBaseData.J) && (paramRecentBaseData.J != 0)) {
          paramContext.d.setTextColor(paramRecentBaseData.J);
        }
        localObject = paramRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
        localCharSequence = paramContext.jdField_e_of_type_AndroidWidgetTextView.getText();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (paramDrawable.equals(localCharSequence)) {}
      }
      try
      {
        paramContext.jdField_e_of_type_AndroidWidgetTextView.setText(paramDrawable);
        localObject = paramRecentBaseData.jdField_c_of_type_JavaLangString;
        localCharSequence = paramContext.jdField_a_of_type_AndroidWidgetTextView.getText();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localCharSequence)) {
          paramContext.jdField_a_of_type_AndroidWidgetTextView.setText(paramDrawable);
        }
        a(paramContext, paramRecentBaseData);
        m = paramRecentBaseData.H;
        i = paramRecentBaseData.G;
        if (m > 0) {
          if (i == 0)
          {
            paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            k = 99;
            m = 0;
            j = 0;
            i = 0;
            CustomWidgetUtil.a(paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
            if (paramContext.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
              paramContext.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            if (AppSetting.j) {
              paramView.setContentDescription(paramRecentBaseData.d);
            }
            if ((paramRecentBaseData.K & 0xF0) != 32) {
              break label753;
            }
            paramContext.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130838315);
            long l = paramRecentBaseData.c();
            if (!(paramContext.jdField_a_of_type_AndroidWidgetImageView instanceof IRecentImgv)) {
              break;
            }
            ((IRecentImgv)paramContext.jdField_a_of_type_AndroidWidgetImageView).a(l);
            return;
            paramContext.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            break label168;
            label593:
            if (!paramDrawable.equals(localCharSequence)) {
              paramContext.jdField_c_of_type_AndroidWidgetTextView.setText(paramDrawable);
            }
            paramContext.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int m;
          int k;
          int j;
          localException.printStackTrace();
          paramContext.jdField_e_of_type_AndroidWidgetTextView.setText(paramDrawable + " ");
          continue;
          if (i == 2)
          {
            paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            m = 0;
            j = 0;
            i = 1;
            k = 99;
          }
          else if (i == 3)
          {
            j = 2130843326;
            if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
            paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
            k = 99;
            i = 3;
          }
          else
          {
            j = 2130843325;
            paramContext.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
            k = 99;
            i = 3;
            continue;
            label753:
            paramContext.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130838314);
            continue;
            k = 99;
            m = 0;
            j = 0;
            i = 0;
          }
        }
      }
    }
  }
  
  public void a(RecentDefaultItemBuilder.RecentItemDefaultHolder paramRecentItemDefaultHolder, RecentBaseData paramRecentBaseData)
  {
    switch (paramRecentBaseData.F)
    {
    default: 
      paramRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
      return;
    case 1: 
      paramRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839132);
      return;
    case 2: 
      paramRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramRecentBaseData.jdField_a_of_type_Boolean)
      {
        paramRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839138);
        return;
      }
      paramRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839132);
      return;
    case 3: 
      paramRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramRecentBaseData.jdField_a_of_type_Boolean)
      {
        paramRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839138);
        return;
      }
      paramRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839139);
      return;
    case 5: 
      paramRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839139);
      return;
    }
    paramRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramRecentItemDefaultHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838409);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentDefaultItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */