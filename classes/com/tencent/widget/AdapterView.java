package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;
import xso;

public abstract class AdapterView
  extends ViewGroup
{
  static final int aA = 0;
  static final int aB = 1;
  static final int aC = 2;
  static final int aD = 100;
  public static final int aI = -1;
  public static final int as = -1;
  public static final int at = -2;
  public static final String c = "XListView";
  public static final long f = Long.MIN_VALUE;
  public static final boolean o = false;
  private float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  AdapterView.OnItemLongClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener;
  AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener;
  private xso jdField_a_of_type_Xso;
  private boolean jdField_a_of_type_Boolean;
  @ViewDebug.ExportedProperty(category="list")
  int aE;
  @ViewDebug.ExportedProperty(category="list")
  public int aF;
  @ViewDebug.ExportedProperty(category="list")
  public int aG;
  int aH;
  protected int aJ;
  @ViewDebug.ExportedProperty(category="scrolling")
  public int au;
  int av;
  int aw;
  int ax;
  int ay;
  int az;
  long jdField_b_of_type_Long;
  AdapterView.OnItemClickListener jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  private boolean jdField_b_of_type_Boolean;
  long c;
  long d;
  public long e;
  long g;
  public boolean p;
  boolean q;
  public boolean r;
  boolean s;
  
  public AdapterView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Long = Long.MIN_VALUE;
    this.p = false;
    this.q = false;
    this.aE = -1;
    this.d = Long.MIN_VALUE;
    this.aF = -1;
    this.e = Long.MIN_VALUE;
    this.aJ = -1;
    this.g = Long.MIN_VALUE;
    this.s = false;
  }
  
  public AdapterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Long = Long.MIN_VALUE;
    this.p = false;
    this.q = false;
    this.aE = -1;
    this.d = Long.MIN_VALUE;
    this.aF = -1;
    this.e = Long.MIN_VALUE;
    this.aJ = -1;
    this.g = Long.MIN_VALUE;
    this.s = false;
  }
  
  public AdapterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Long = Long.MIN_VALUE;
    this.p = false;
    this.q = false;
    this.aE = -1;
    this.d = Long.MIN_VALUE;
    this.aF = -1;
    this.e = Long.MIN_VALUE;
    this.aJ = -1;
    this.g = Long.MIN_VALUE;
    this.s = false;
  }
  
  public static void D() {}
  
  protected static int a(String paramString)
  {
    try
    {
      int i = Class.forName("com.android.internal.R$styleable").getField(paramString).getInt(null);
      return i;
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  private void a(boolean paramBoolean)
  {
    if (c_()) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        setVisibility(8);
      }
      for (;;)
      {
        if (this.r) {
          onLayout(false, this.mLeft, this.mTop, this.mRight, this.mBottom);
        }
        return;
        setVisibility(0);
      }
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    setVisibility(0);
  }
  
  protected static int[] a(String paramString)
  {
    try
    {
      paramString = (int[])Class.forName("com.android.internal.R$styleable").getField(paramString).get(null);
      return paramString;
    }
    catch (Exception paramString) {}
    return new int[0];
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener == null) {
      return;
    }
    int i = r();
    if (i >= 0)
    {
      View localView = a();
      this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener.b(this, localView, i, a().getItemId(i));
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener.a(this);
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    Adapter localAdapter = a();
    boolean bool1 = bool2;
    if (localAdapter != null)
    {
      int i = localAdapter.getCount();
      bool1 = bool2;
      if (i > 0) {
        if (s() <= 0)
        {
          bool1 = bool2;
          if (t() >= i - 1) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void d(String paramString)
  {
    TraceUtils.a(paramString);
  }
  
  void A()
  {
    if ((this.aF != this.aJ) || (this.e != this.g))
    {
      f_();
      this.aJ = this.aF;
      this.g = this.e;
    }
  }
  
  protected void B()
  {
    if ((VersionUtils.e()) && (isHardwareAccelerated()) && ((getParent() instanceof View))) {
      ((View)getParent()).invalidate();
    }
  }
  
  protected void C()
  {
    if ((getParent() instanceof View)) {}
    try
    {
      Field localField = View.class.getDeclaredField("mPrivateFlags");
      localField.setAccessible(true);
      int i = localField.getInt(getParent());
      localField.set(getParent(), Integer.valueOf(i | 0x80000000));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("XListView", 2, localException.getMessage(), localException);
      }
      ((View)getParent()).invalidate();
    }
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    return paramInt;
  }
  
  public int a(View paramView)
  {
    try
    {
      for (;;)
      {
        View localView = (View)paramView.getParent();
        boolean bool = localView.equals(this);
        if (bool) {
          break;
        }
        paramView = localView;
      }
      j = getChildCount();
    }
    catch (ClassCastException paramView)
    {
      return -1;
    }
    int j;
    int i = 0;
    while (i < j)
    {
      if (getChildAt(i).equals(paramView)) {
        return i + this.au;
      }
      i += 1;
    }
    return -1;
  }
  
  @ViewDebug.CapturedViewProperty
  public long a()
  {
    return this.d;
  }
  
  public long a(int paramInt)
  {
    Adapter localAdapter = a();
    if ((localAdapter == null) || (paramInt < 0)) {
      return Long.MIN_VALUE;
    }
    return localAdapter.getItemId(paramInt);
  }
  
  public abstract View a();
  
  public abstract Adapter a();
  
  public final AdapterView.OnItemClickListener a()
  {
    return this.jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  }
  
  public final AdapterView.OnItemLongClickListener a()
  {
    return this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener;
  }
  
  public final AdapterView.OnItemSelectedListener a()
  {
    return this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener;
  }
  
  public Object a()
  {
    Adapter localAdapter = a();
    int i = r();
    if ((localAdapter != null) && (localAdapter.getCount() > 0) && (i >= 0)) {
      return localAdapter.getItem(i);
    }
    return null;
  }
  
  public Object a(int paramInt)
  {
    Adapter localAdapter = a();
    if ((localAdapter == null) || (paramInt < 0)) {
      return null;
    }
    return localAdapter.getItem(paramInt);
  }
  
  public boolean a(View paramView, int paramInt, long paramLong)
  {
    boolean bool = false;
    if (this.jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener != null)
    {
      playSoundEffect(0);
      if (paramView != null) {
        paramView.sendAccessibilityEvent(1);
      }
      this.jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener.a(this, paramView, paramInt, paramLong);
      bool = true;
    }
    return bool;
  }
  
  public void addView(View paramView)
  {
    throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
  }
  
  public View b()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected float c()
  {
    if (this.jdField_a_of_type_Float == 0.0F)
    {
      TypedValue localTypedValue = new TypedValue();
      if (!getContext().getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
      }
      this.jdField_a_of_type_Float = localTypedValue.getDimension(getContext().getResources().getDisplayMetrics());
    }
    return this.jdField_a_of_type_Float;
  }
  
  boolean c_()
  {
    return false;
  }
  
  protected boolean canAnimate()
  {
    return (super.canAnimate()) && (this.aG > 0);
  }
  
  @ViewDebug.CapturedViewProperty
  public int d_()
  {
    return this.aG;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    View localView = a();
    return (localView != null) && (localView.getVisibility() == 0) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent));
  }
  
  protected void dispatchRestoreInstanceState(SparseArray paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  void f_()
  {
    if (this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener != null)
    {
      if ((!this.q) && (!this.s)) {
        break label78;
      }
      if (this.jdField_a_of_type_Xso == null) {
        this.jdField_a_of_type_Xso = new xso(this, null);
      }
      post(this.jdField_a_of_type_Xso);
    }
    for (;;)
    {
      if ((this.aF != -1) && (isShown()) && (!isInTouchMode())) {
        sendAccessibilityEvent(4);
      }
      return;
      label78:
      b();
    }
  }
  
  public void h(int paramInt)
  {
    this.aF = paramInt;
    this.e = a(paramInt);
  }
  
  public void i(int paramInt)
  {
    this.aE = paramInt;
    this.d = a(paramInt);
    if ((this.p) && (this.ay == 0) && (paramInt >= 0))
    {
      this.ax = paramInt;
      this.jdField_b_of_type_Long = this.d;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.jdField_a_of_type_Xso);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setScrollable(b());
    View localView = a();
    if (localView != null) {
      paramAccessibilityEvent.setEnabled(localView.isEnabled());
    }
    paramAccessibilityEvent.setCurrentItemIndex(r());
    paramAccessibilityEvent.setFromIndex(s());
    paramAccessibilityEvent.setToIndex(t());
    paramAccessibilityEvent.setItemCount(d_());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    try
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setScrollable(b());
      View localView = a();
      if (localView != null) {
        paramAccessibilityNodeInfo.setEnabled(localView.isEnabled());
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.az = getHeight();
  }
  
  public boolean onRequestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (super.onRequestSendAccessibilityEvent(paramView, paramAccessibilityEvent))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      onInitializeAccessibilityEvent(localAccessibilityEvent);
      paramView.dispatchPopulateAccessibilityEvent(localAccessibilityEvent);
      paramAccessibilityEvent.appendRecord(localAccessibilityEvent);
      return true;
    }
    return false;
  }
  
  @ViewDebug.CapturedViewProperty
  public int r()
  {
    return this.aE;
  }
  
  public void removeAllViews()
  {
    throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
  }
  
  public void removeView(View paramView)
  {
    throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
  }
  
  public void removeViewAt(int paramInt)
  {
    throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
  }
  
  public int s()
  {
    return this.au;
  }
  
  void s()
  {
    int m = this.aG;
    int i;
    if (m > 0) {
      if (this.p)
      {
        this.p = false;
        i = u();
        if ((i >= 0) && (a(i, true) == i))
        {
          i(i);
          i = 1;
          if (i == 0)
          {
            int k = r();
            int j = k;
            if (k >= m) {
              j = m - 1;
            }
            k = j;
            if (j < 0) {
              k = 0;
            }
            j = a(k, true);
            if (j >= 0) {
              break label153;
            }
            j = a(k, false);
            label97:
            if (j >= 0)
            {
              i(j);
              A();
              i = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.aF = -1;
        this.e = Long.MIN_VALUE;
        this.aE = -1;
        this.d = Long.MIN_VALUE;
        this.p = false;
        A();
      }
      return;
      continue;
      label153:
      break label97;
      i = 0;
      break;
      i = 0;
    }
  }
  
  public boolean s()
  {
    if (VersionUtils.d()) {
      for (ViewParent localViewParent = getParent(); (localViewParent != null) && ((localViewParent instanceof ViewGroup)); localViewParent = localViewParent.getParent()) {
        if (((ViewGroup)localViewParent).shouldDelayChildPressedState()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public abstract void setAdapter(Adapter paramAdapter);
  
  public void setEmptyView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView = a();
    if ((paramView == null) || (paramView.isEmpty())) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    boolean bool = true;
    Adapter localAdapter = a();
    int i;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (!paramBoolean) {
        this.jdField_b_of_type_Boolean = false;
      }
      if (!paramBoolean) {
        break label69;
      }
      paramBoolean = bool;
      if (i != 0) {
        if (!c_()) {
          break label69;
        }
      }
    }
    label69:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      super.setFocusable(paramBoolean);
      return;
      i = 0;
      break;
    }
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    boolean bool = true;
    Adapter localAdapter = a();
    int i;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (paramBoolean) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (!paramBoolean) {
        break label69;
      }
      paramBoolean = bool;
      if (i != 0) {
        if (!c_()) {
          break label69;
        }
      }
    }
    label69:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      super.setFocusableInTouchMode(paramBoolean);
      return;
      i = 0;
      break;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public abstract void setSelection(int paramInt);
  
  public int t()
  {
    return this.au + getChildCount() - 1;
  }
  
  void t()
  {
    if (getChildCount() > 0)
    {
      this.p = true;
      this.c = this.az;
      if (this.aF >= 0)
      {
        localView = getChildAt(this.aF - this.au);
        this.jdField_b_of_type_Long = this.d;
        this.ax = this.aE;
        if (localView != null) {
          this.av = localView.getTop();
        }
        this.ay = 0;
      }
    }
    else
    {
      return;
    }
    View localView = getChildAt(0);
    Adapter localAdapter = a();
    if ((this.au >= 0) && (this.au < localAdapter.getCount())) {}
    for (this.jdField_b_of_type_Long = localAdapter.getItemId(this.au);; this.jdField_b_of_type_Long = -1L)
    {
      this.ax = this.au;
      if (localView != null) {
        this.av = localView.getTop();
      }
      this.ay = 1;
      return;
    }
  }
  
  int u()
  {
    int i2 = this.aG;
    int n;
    if (i2 == 0)
    {
      n = -1;
      return n;
    }
    long l1 = this.jdField_b_of_type_Long;
    int i = this.ax;
    if (l1 == Long.MIN_VALUE) {
      return -1;
    }
    i = Math.min(i2 - 1, Math.max(0, i));
    long l2 = SystemClock.uptimeMillis();
    Adapter localAdapter = a();
    label68:
    int i1;
    int j;
    int k;
    if (localAdapter == null)
    {
      return -1;
      if ((i1 != 0) || ((j != 0) && (n == 0)))
      {
        i = k + 1;
        k = i;
        j = 0;
      }
    }
    for (;;)
    {
      int m;
      if (SystemClock.uptimeMillis() <= l2 + 100L)
      {
        n = i;
        if (localAdapter.getItemId(i) == l1) {
          break;
        }
        if (k != i2 - 1) {
          break label153;
        }
        n = 1;
        if (m != 0) {
          break label159;
        }
      }
      label153:
      label159:
      for (i1 = 1;; i1 = 0)
      {
        if ((n == 0) || (i1 == 0)) {
          break label163;
        }
        return -1;
        n = 0;
        break;
      }
      label163:
      break label68;
      if ((n != 0) || ((j == 0) && (i1 == 0)))
      {
        i = m - 1;
        m = i;
        j = 1;
        continue;
        k = i;
        m = i;
        j = 0;
      }
    }
  }
  
  void z()
  {
    boolean bool2 = false;
    Adapter localAdapter = a();
    int i;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      if ((i != 0) && (!c_())) {
        break label108;
      }
      i = 1;
      label36:
      if ((i == 0) || (!this.jdField_b_of_type_Boolean)) {
        break label113;
      }
      bool1 = true;
      label49:
      super.setFocusableInTouchMode(bool1);
      if ((i == 0) || (!this.jdField_a_of_type_Boolean)) {
        break label118;
      }
    }
    label108:
    label113:
    label118:
    for (boolean bool1 = true;; bool1 = false)
    {
      super.setFocusable(bool1);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if (localAdapter != null)
        {
          bool1 = bool2;
          if (!localAdapter.isEmpty()) {}
        }
        else
        {
          bool1 = true;
        }
        a(bool1);
      }
      return;
      i = 0;
      break;
      i = 0;
      break label36;
      bool1 = false;
      break label49;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\widget\AdapterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */