package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FormSimpleItem
  extends RelativeLayout
  implements FormItemConstants
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private Drawable c;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q = getResources().getDimensionPixelSize(2131493323);
  private int r;
  private int s;
  private int t;
  private int u;
  
  public FormSimpleItem(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FormSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = getResources().getDimensionPixelSize(2131493684);
    this.s = ((int)(getResources().getDisplayMetrics().density * 35.0F + 0.5D));
    this.t = ((int)(getResources().getDisplayMetrics().density * 15.0F + 0.5D));
    this.c = getResources().getDrawable(2130838201);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.A);
    this.p = paramContext.getDimensionPixelSize(3, i1);
    this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(4);
    this.k = paramContext.getInt(6, 0);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(5);
    this.i = paramContext.getDimensionPixelSize(1, 0);
    this.j = paramContext.getDimensionPixelSize(2, 0);
    this.j = Math.min(this.p, this.j);
    this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(7);
    this.n = paramContext.getInt(11, 3);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(8);
    this.l = paramContext.getDimensionPixelSize(9, 0);
    this.m = paramContext.getDimensionPixelSize(10, 0);
    this.m = Math.min(this.p, this.m);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(12, false);
    this.o = paramContext.getInt(0, 0);
    paramContext.recycle();
    a();
  }
  
  public static ColorStateList a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131428262);
    case 0: 
      return paramResources.getColorStateList(2131428262);
    case 2: 
      return paramResources.getColorStateList(2131428302);
    case 1: 
      return paramResources.getColorStateList(2131428268);
    }
    return paramResources.getColorStateList(2131428313);
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130838349);
    case 0: 
      return paramResources.getDrawable(2130838349);
    case 1: 
      return paramResources.getDrawable(2130838357);
    case 2: 
      return paramResources.getDrawable(2130838355);
    }
    return paramResources.getDrawable(2130838352);
  }
  
  private void b()
  {
    int i3 = 0;
    int i2 = getResources().getDisplayMetrics().widthPixels - this.q * 2;
    int i1;
    if (this.jdField_b_of_type_JavaLangCharSequence == null)
    {
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean)) {
        i1 = this.s + this.q + this.t;
      }
      for (;;)
      {
        this.u = (i2 - i1);
        this.r = 0;
        return;
        if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean)) {
          i1 = this.s;
        } else if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean)) {
          i1 = this.t;
        } else {
          i1 = 0;
        }
      }
    }
    int i4 = i2 - this.q;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      if (this.i == 0)
      {
        i1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        i1 += this.q;
      }
    }
    for (;;)
    {
      i2 = (int)this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_a_of_type_JavaLangCharSequence.toString()) + i1;
      i1 = i3;
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        if (this.l == 0)
        {
          i1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
          label202:
          i1 = this.q + (i1 + 0);
        }
      }
      else
      {
        i3 = i1;
        if (this.jdField_a_of_type_Boolean)
        {
          i3 = this.c.getIntrinsicWidth();
          i3 = this.q + (i3 + i1);
        }
        i3 += (int)this.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_b_of_type_JavaLangCharSequence.toString());
        i1 = i4 / 2;
        if ((i2 < i1) || (i3 < i1)) {
          break label304;
        }
        i2 = i1;
      }
      for (;;)
      {
        this.u = i2;
        this.r = i1;
        return;
        i1 = this.i;
        break;
        i1 = this.l;
        break label202;
        label304:
        if ((i2 > i1) && (i3 < i1))
        {
          i2 = i4 - i3;
          i1 = i3;
        }
        else if ((i2 < i1) && (i3 > i1))
        {
          i1 = i4 - i2;
        }
        else
        {
          i1 = i3;
        }
      }
      i1 = 0;
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {}
    do
    {
      do
      {
        return;
        b();
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.u);
        }
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.n));
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(this.r);
        if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
        {
          if ((this.l > 0) && (this.m > 0))
          {
            this.c.setBounds(0, 0, this.c.getIntrinsicWidth(), this.c.getIntrinsicHeight());
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.l, this.m);
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, this.c, null);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(8);
            return;
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, this.c, null);
          }
        }
        if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
        {
          if ((this.l > 0) && (this.m > 0))
          {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.l, this.m);
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(8);
            return;
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
          }
        }
        if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.c, null);
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(8);
          return;
        }
      } while ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Boolean));
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if ((this.l > 0) && (this.m > 0))
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.l, this.m);
          this.c.setBounds(0, 0, this.c.getIntrinsicWidth(), this.c.getIntrinsicHeight());
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, this.c, null);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(8);
          return;
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, this.c, null);
        }
      }
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if ((this.l > 0) && (this.m > 0))
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.l, this.m);
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
          return;
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
      }
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.c, null);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
        return;
      }
    } while ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Boolean));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public Drawable a()
  {
    return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  protected void a()
  {
    setFocusable(true);
    setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131296464);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.k));
    int i1 = getContext().getResources().getDimensionPixelSize(2131493682);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, i1);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    setLeftIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.i, this.j);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.q;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.u);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_b_of_type_AndroidWidgetTextView.setId(2131296465);
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.n));
    i1 = getContext().getResources().getDimensionPixelSize(2131493683);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, i1);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_b_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.q;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
    c();
    setBackgroundDrawable(a(getResources(), this.o));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c();
  }
  
  public TextView b()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.p, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.p);
  }
  
  public void setArrowIcon(Drawable paramDrawable)
  {
    this.c = paramDrawable;
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.o = paramInt;
    setBackgroundDrawable(a(getResources(), this.o));
  }
  
  public void setCustomHeight(int paramInt)
  {
    if (paramInt > 0)
    {
      this.p = paramInt;
      requestLayout();
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable == null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    else
    {
      return;
    }
    if (paramDrawable.getIntrinsicHeight() > this.p)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.p);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.q);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.i = paramInt1;
        this.j = Math.min(this.p, paramInt2);
        paramDrawable.setBounds(0, 0, paramInt1, this.j);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.q);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setLeftIcon(paramDrawable);
  }
  
  public void setLeftText(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.k));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
  }
  
  public void setLeftTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      this.k = paramInt;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.k));
    }
  }
  
  public void setLeftTextNoColor(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable)
  {
    setRightIcon(paramDrawable, 0, 0);
  }
  
  public void setRightIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      return;
    }
    this.l = paramInt1;
    this.m = Math.min(this.p, paramInt2);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    c();
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    c();
  }
  
  public void setRightTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.n = paramInt;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.n));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\FormSimpleItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */