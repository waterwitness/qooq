package com.tencent.mobileqq.troop.widget;

import NearbyGroup.GroupLabel;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import vuk;

public class TroopLabelLayout
  extends ViewGroup
{
  static final int jdField_a_of_type_Int = 2;
  public static final SparseIntArray a;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 4;
  public static final int l = 101;
  public static final int m = 1000;
  public static final int n = 2000;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  Runnable jdField_a_of_type_JavaLangRunnable = new vuk(this);
  private String jdField_a_of_type_JavaLangString = "TroopLabelLayout";
  public ArrayList a;
  private Map jdField_a_of_type_JavaUtilMap;
  boolean jdField_a_of_type_Boolean = false;
  int b = 5;
  int c = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 1);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(4, 2);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(8, 3);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(7, 4);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(6, 5);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(5, 6);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(3, 8);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(2, 9);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(101, 10);
  }
  
  public TroopLabelLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public TroopLabelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public TroopLabelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public TroopLabelTextView a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    while (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      return null;
    }
    return (TroopLabelTextView)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    label347:
    label414:
    label507:
    label656:
    label662:
    label682:
    label722:
    label735:
    label737:
    for (;;)
    {
      HashMap localHashMap;
      int i1;
      GroupLabel localGroupLabel;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
          break label735;
        }
        localHashMap = new HashMap();
        int i4 = paramArrayList.size();
        i1 = 0;
        int i2 = 0;
        if ((i2 >= i4) || (i1 >= this.b)) {
          break label722;
        }
        localGroupLabel = (GroupLabel)paramArrayList.get(i2);
        if (TextUtils.isEmpty(localGroupLabel.strWording)) {
          i2 += 1;
        }
      }
      if ((localGroupLabel.type != 2001L) && ((this.c >= 2) || (localGroupLabel.type < 1000L) || (localGroupLabel.type >= 2000L)) && ((this.c != 2) || (localGroupLabel.type >= 1000L)))
      {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localGroupLabel);
          if (localGroupLabel.type == 4L)
          {
            if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
              break label737;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setText(localGroupLabel.strWording);
          }
        }
        Object localObject2 = a(i1);
        int i3 = android.graphics.Color.rgb((int)localGroupLabel.edging_color.R, (int)localGroupLabel.edging_color.G, (int)localGroupLabel.edging_color.B);
        int i5 = android.graphics.Color.rgb((int)localGroupLabel.text_color.R, (int)localGroupLabel.text_color.G, (int)localGroupLabel.text_color.B);
        if (localObject2 == null)
        {
          ??? = new TroopLabelTextView(getContext(), i3, i5, this.c);
          if (i1 >= this.b) {
            break label722;
          }
          addView((View)???);
          setTroopLabel(i1, (TroopLabelTextView)???);
          ((TroopLabelTextView)???).bringToFront();
          if (this.c == 2)
          {
            i3 = AIOUtils.a(42.0F, getResources());
            i5 = AIOUtils.a(16.0F, getResources());
            ((TroopLabelTextView)???).setWidth(i3);
            ((TroopLabelTextView)???).setHeight(i5);
            ((TroopLabelTextView)???).setMaskImage(2130840153);
            if (localGroupLabel.strWording.length() < 2) {
              break label656;
            }
            i3 = 2;
            localGroupLabel.strWording = localGroupLabel.strWording.substring(0, i3);
          }
          if (localGroupLabel.type != 1L) {
            break label682;
          }
          localObject2 = new SpannableString("[icon]" + " " + localGroupLabel.strWording);
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
          {
            if (this.c != 0) {
              break label662;
            }
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130843473);
          }
          i3 = (int)(((TroopLabelTextView)???).getTextSize() * 0.8D + 0.5D);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i3, i3);
          ((SpannableString)localObject2).setSpan(new ImageSpan(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, 1), 0, "[icon]".length(), 17);
          ((TroopLabelTextView)???).setText((CharSequence)localObject2);
          ((TroopLabelTextView)???).setContentDescription(localGroupLabel.strWording + "人");
        }
        for (;;)
        {
          ((TroopLabelTextView)???).setVisibility(0);
          localHashMap.put(Integer.valueOf(i1), Boolean.valueOf(true));
          i1 += 1;
          break;
          ((TroopLabelTextView)localObject2).setColor(i3, i5);
          ??? = localObject2;
          if (!QLog.isColorLevel()) {
            break label347;
          }
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "labeltextview cache");
          ??? = localObject2;
          break label347;
          i3 = 1;
          break label414;
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130840147);
          break label507;
          ((TroopLabelTextView)???).setText(localGroupLabel.strWording + "");
          ((TroopLabelTextView)???).setContentDescription(localGroupLabel.strWording);
        }
        setLabelsUnVisible(localHashMap);
        localHashMap.clear();
        return true;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = getPaddingLeft();
    int i3 = getPaddingRight();
    int i4 = (int)DisplayUtils.a(getContext(), 2.0F);
    int i5 = getChildCount();
    paramInt2 = getPaddingLeft();
    int i6 = getPaddingTop();
    paramInt4 = 0;
    View localView;
    if (paramInt4 < i5)
    {
      localView = getChildAt(paramInt4);
      if (localView.getVisibility() != 8) {}
    }
    for (;;)
    {
      paramInt4 += 1;
      break;
      int i7 = localView.getMeasuredWidth();
      int i8 = localView.getMeasuredHeight();
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      if (paramInt2 + i7 > paramInt3 - paramInt1 - i2 - i3)
      {
        if (this.jdField_a_of_type_Boolean) {
          post(this.jdField_a_of_type_JavaLangRunnable);
        }
        return;
      }
      int i1 = localLayoutParams.rightMargin + (i4 + i7) + paramInt2;
      localView.layout(paramInt2, i6, i7 + paramInt2, i8 + i6);
      paramInt2 = i1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    super.onMeasure(paramInt1, paramInt2);
    int i5 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    super.measureChildren(paramInt1, paramInt2);
    View localView;
    switch (i5)
    {
    default: 
      paramInt1 = 0;
      switch (i4)
      {
      default: 
        paramInt2 = i2;
        if (getChildCount() > 0)
        {
          localView = getChildAt(0);
          i1 = 0 + (getPaddingBottom() + getPaddingTop());
          paramInt2 = i1;
          if (localView == null) {}
        }
        break;
      }
      break;
    }
    for (paramInt2 = i1 + localView.getMeasuredHeight();; paramInt2 = i3)
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = i1;
      break;
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt1 < getChildCount())
      {
        paramInt2 += getChildAt(paramInt1).getWidth();
        paramInt1 += 1;
      }
      paramInt1 = paramInt2;
      if (paramInt2 <= i1) {
        break;
      }
      paramInt1 = i1;
      break;
    }
  }
  
  public void setDistanceTextView(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void setLabelType(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setLabelsUnVisible(Map paramMap)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!paramMap.containsKey(localEntry.getKey())) {
          ((TroopLabelTextView)localEntry.getValue()).setVisibility(8);
        }
      }
    }
  }
  
  public void setMaxLabelCount(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setTroopLabel(int paramInt, TroopLabelTextView paramTroopLabelTextView)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramTroopLabelTextView);
    }
  }
  
  public void setmIsNeedPriority(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\TroopLabelLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */