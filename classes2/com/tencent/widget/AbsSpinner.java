package com.tencent.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import xse;

public abstract class AbsSpinner
  extends AdapterView
{
  private static final int jdField_a_of_type_Int = a("AbsSpinner_entries");
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  SpinnerAdapter jdField_a_of_type_AndroidWidgetSpinnerAdapter;
  final xse jdField_a_of_type_Xse = new xse(this);
  boolean jdField_a_of_type_Boolean;
  private Rect b;
  int d;
  int e;
  int f = 0;
  int g;
  int h = 0;
  int i = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AbsSpinner(Context paramContext)
  {
    super(paramContext);
    this.jdField_g_of_type_Int = 0;
    d();
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_g_of_type_Int = 0;
    d();
    paramAttributeSet = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, a("AbsSpinner"), paramInt, 0));
    CharSequence[] arrayOfCharSequence = paramAttributeSet.a(jdField_a_of_type_Int);
    if (arrayOfCharSequence != null)
    {
      paramContext = new ArrayAdapter(paramContext, 17367048, arrayOfCharSequence);
      paramContext.setDropDownViewResource(17367049);
      setAdapter(paramContext);
    }
    paramAttributeSet.a();
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = paramInt1;
    switch (k)
    {
    default: 
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      return 0xFF000000 & paramInt3 | paramInt2;
      paramInt2 = paramInt1;
      if (j < paramInt1)
      {
        paramInt2 = j | 0x1000000;
        continue;
        paramInt2 = j;
      }
    }
  }
  
  private void d()
  {
    setFocusable(true);
    setWillNotDraw(false);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.jdField_b_of_type_AndroidGraphicsRect;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
      localObject1 = this.jdField_b_of_type_AndroidGraphicsRect;
    }
    int j = getChildCount() - 1;
    while (j >= 0)
    {
      localObject2 = getChildAt(j);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return this.au + j;
        }
      }
      j -= 1;
    }
    return -1;
  }
  
  public View a()
  {
    if ((this.aG > 0) && (this.aF >= 0)) {
      return getChildAt(this.aF - this.au);
    }
    return null;
  }
  
  public SpinnerAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetSpinnerAdapter;
  }
  
  protected AdapterView.AdapterDataSetObserver a()
  {
    return new AdapterView.AdapterDataSetObserver(this);
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != this.aJ)
    {
      this.jdField_a_of_type_Boolean = true;
      int j = this.aF;
      i(paramInt);
      b(paramInt - j, paramBoolean);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  int b(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  void b()
  {
    this.r = false;
    this.p = false;
    removeAllViewsInLayout();
    this.aJ = -1;
    this.jdField_g_of_type_Long = Long.MIN_VALUE;
    h(-1);
    i(-1);
    invalidate();
  }
  
  abstract void b(int paramInt, boolean paramBoolean);
  
  int c(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  void c()
  {
    int k = getChildCount();
    xse localxse = this.jdField_a_of_type_Xse;
    int m = this.au;
    int j = 0;
    while (j < k)
    {
      localxse.a(m + j, getChildAt(j));
      j += 1;
    }
  }
  
  public int d_()
  {
    return this.aG;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    int j;
    label56:
    label84:
    label112:
    int k;
    int m;
    if (this.mPaddingLeft > this.f)
    {
      j = this.mPaddingLeft;
      ((Rect)localObject).left = j;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.mPaddingTop <= this.jdField_g_of_type_Int) {
        break label417;
      }
      j = this.mPaddingTop;
      ((Rect)localObject).top = j;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.mPaddingRight <= this.h) {
        break label426;
      }
      j = this.mPaddingRight;
      ((Rect)localObject).right = j;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.mPaddingBottom <= this.i) {
        break label435;
      }
      j = this.mPaddingBottom;
      ((Rect)localObject).bottom = j;
      if (this.r) {
        s();
      }
      j = r();
      if ((j < 0) || (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter == null) || (j >= this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getCount())) {
        break label444;
      }
      View localView = this.jdField_a_of_type_Xse.a(j);
      localObject = localView;
      if (localView == null) {
        localObject = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getView(j, null, this);
      }
      if (localObject != null) {
        this.jdField_a_of_type_Xse.a(j, (View)localObject);
      }
      if (localObject == null) {
        break label444;
      }
      if (((View)localObject).getLayoutParams() == null)
      {
        this.jdField_a_of_type_Boolean = true;
        ((View)localObject).setLayoutParams(generateDefaultLayoutParams());
        this.jdField_a_of_type_Boolean = false;
      }
      measureChild((View)localObject, paramInt1, paramInt2);
      k = b((View)localObject) + this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      j = c((View)localObject) + this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right;
      m = 0;
    }
    for (;;)
    {
      int n = j;
      if (m != 0)
      {
        m = this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        n = j;
        k = m;
        if (i1 == 0)
        {
          n = this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right;
          k = m;
        }
      }
      j = Math.max(k, getSuggestedMinimumHeight());
      k = Math.max(n, getSuggestedMinimumWidth());
      j = a(j, paramInt2, 0);
      setMeasuredDimension(a(k, paramInt1, 0), j);
      this.d = paramInt2;
      this.e = paramInt1;
      return;
      j = this.f;
      break;
      label417:
      j = this.jdField_g_of_type_Int;
      break label56;
      label426:
      j = this.h;
      break label84;
      label435:
      j = this.i;
      break label112;
      label444:
      m = 1;
      j = 0;
      k = 0;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (AbsSpinner.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.jdField_a_of_type_Long >= 0L)
    {
      this.r = true;
      this.p = true;
      this.jdField_b_of_type_Long = paramParcelable.jdField_a_of_type_Long;
      this.ax = paramParcelable.jdField_a_of_type_Int;
      this.ay = 0;
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    AbsSpinner.SavedState localSavedState = new AbsSpinner.SavedState(super.onSaveInstanceState());
    localSavedState.jdField_a_of_type_Long = a();
    if (localSavedState.jdField_a_of_type_Long >= 0L)
    {
      localSavedState.jdField_a_of_type_Int = r();
      return localSavedState;
    }
    localSavedState.jdField_a_of_type_Int = -1;
    return localSavedState;
  }
  
  public void requestLayout()
  {
    if (!this.jdField_a_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    int j = -1;
    if (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter != null)
    {
      this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      b();
    }
    this.jdField_a_of_type_AndroidWidgetSpinnerAdapter = paramSpinnerAdapter;
    this.aJ = -1;
    this.jdField_g_of_type_Long = Long.MIN_VALUE;
    if (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter != null)
    {
      this.aH = this.aG;
      this.aG = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getCount();
      z();
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver = a();
      this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      if (this.aG > 0) {
        j = 0;
      }
      h(j);
      i(j);
      if (this.aG == 0) {
        A();
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      z();
      b();
      A();
    }
  }
  
  public void setSelection(int paramInt)
  {
    i(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setSelection(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.au <= paramInt) && (paramInt <= this.au + getChildCount() - 1)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramInt, paramBoolean);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\AbsSpinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */