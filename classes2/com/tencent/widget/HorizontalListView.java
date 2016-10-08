package com.tencent.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import xtl;
import xtm;
import xtn;
import xto;
import xtp;
import xtq;
import xtr;
import xts;

public class HorizontalListView
  extends AdapterView
{
  private static final int jdField_a_of_type_Int = 50;
  public static final String a;
  private static final String jdField_b_of_type_JavaLangString = "BUNDLE_ID_CURRENT_X";
  private static final String jdField_c_of_type_JavaLangString = "BUNDLE_ID_PARENT_STATE";
  protected static final int d = -1;
  protected static final int e = 0;
  public static final boolean g;
  static final int q = -1;
  static final int r = 0;
  static final int s = 1;
  static final int t = 2;
  static final int u = 3;
  static final int v = 4;
  static final int w = 5;
  static final int x = 6;
  private static final int z = -1;
  private int A = -1;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private float jdField_a_of_type_Float;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ContextMenu.ContextMenuInfo jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  public ListAdapter a;
  private HorizontalListView.OnItemScrollEventListener jdField_a_of_type_ComTencentWidgetHorizontalListView$OnItemScrollEventListener;
  private HorizontalListView.OnScrollStateChangedListener jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener;
  private HorizontalListView.RunningOutOfDataListener jdField_a_of_type_ComTencentWidgetHorizontalListView$RunningOutOfDataListener;
  public OverScroller a;
  private Integer jdField_a_of_type_JavaLangInteger;
  public Runnable a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private xto jdField_a_of_type_Xto;
  private xtr jdField_a_of_type_Xtr;
  xts jdField_a_of_type_Xts;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private Runnable jdField_c_of_type_JavaLangRunnable;
  private boolean jdField_c_of_type_Boolean;
  private Runnable jdField_d_of_type_JavaLangRunnable;
  private boolean jdField_d_of_type_Boolean;
  private Runnable e = new xtl(this);
  protected int f;
  protected int g;
  protected int h;
  protected boolean h;
  public int i;
  public boolean i;
  protected int j = Integer.MAX_VALUE;
  protected int k;
  public int l;
  public int m;
  protected int n;
  protected int o = 4097;
  protected int p;
  public int y = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = HorizontalListView.class.getSimpleName();
    jdField_g_of_type_Boolean = false;
  }
  
  public HorizontalListView(Context paramContext)
  {
    this(paramContext, null);
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(0);
    }
  }
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(0);
    }
    a();
    ViewCompat.setImportantForAccessibility(this, 1);
  }
  
  private int a()
  {
    return getHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetListAdapter;
    if (localObject == null)
    {
      paramInt1 = getPaddingLeft() + getPaddingRight();
      return paramInt1;
    }
    int i4 = getPaddingLeft() + getPaddingRight();
    if ((this.jdField_g_of_type_Int > 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {}
    for (int i1 = this.jdField_g_of_type_Int;; i1 = 0)
    {
      paramInt4 = i4;
      int i3 = paramInt1;
      int i2 = paramInt2;
      if (paramInt2 == -1)
      {
        i2 = ((ListAdapter)localObject).getCount() - 1;
        i3 = paramInt1;
      }
      for (paramInt4 = i4;; paramInt4 = paramInt1)
      {
        if (i3 > i2) {
          break label173;
        }
        localObject = c(i3);
        paramInt1 = paramInt4;
        if (localObject != null)
        {
          a((View)localObject);
          paramInt1 = paramInt4;
          if (i3 > 0) {
            paramInt1 = paramInt4 + i1;
          }
          paramInt2 = paramInt1 + ((View)localObject).getMeasuredWidth();
          a(i3, (View)localObject);
          paramInt1 = paramInt3;
          if (paramInt2 > paramInt3) {
            break;
          }
          paramInt1 = paramInt2;
        }
        i3 += 1;
      }
    }
    label173:
    return paramInt4;
  }
  
  private ViewGroup.LayoutParams a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (localLayoutParams == null) {
      paramView = new ViewGroup.LayoutParams(-2, -1);
    }
    return paramView;
  }
  
  private void a(float paramFloat, int paramInt)
  {
    int i3 = this.j;
    int i4 = this.k;
    int i1 = getOverScrollMode();
    int i7;
    int i5;
    int i6;
    int i2;
    if ((i1 == 0) || ((i1 == 1) && (i3 > 0)))
    {
      i1 = 1;
      i7 = getScrollX() + this.jdField_i_of_type_Int;
      i5 = this.jdField_i_of_type_Int;
      i6 = i7 + paramInt;
      if (i7 >= i4)
      {
        i2 = paramInt;
        if (i7 <= i3) {}
      }
      else
      {
        i2 = b(paramInt, i3);
      }
      if ((i1 == 0) || ((i6 >= i4) && (i6 <= i3))) {
        break label198;
      }
      if (i6 >= i4) {
        break label184;
      }
      paramInt = i6 - getScrollX() - i4;
      label118:
      i1 = getWidth();
      overScrollBy(paramInt, 0, getScrollX(), 0, 0, 0, i1 - 50, 0, true);
      label143:
      if (i6 >= i4) {
        break label225;
      }
      this.jdField_i_of_type_Int = i4;
    }
    for (;;)
    {
      if (i5 != this.jdField_i_of_type_Int)
      {
        d();
        requestLayout();
      }
      this.jdField_a_of_type_Float = paramFloat;
      return;
      i1 = 0;
      break;
      label184:
      paramInt = i6 - getScrollX() - i3;
      break label118;
      label198:
      if (i7 != i5) {
        scrollTo(0, 0);
      }
      this.jdField_i_of_type_Int += i2;
      break label143;
      label225:
      if (i6 > i3) {
        this.jdField_i_of_type_Int = i3;
      }
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    int i1 = 0;
    while (i1 < paramInt)
    {
      this.jdField_a_of_type_JavaUtilList.add(new LinkedList());
      i1 += 1;
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    int i2 = getChildCount();
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    this.jdField_a_of_type_AndroidGraphicsRect.top = getPaddingTop();
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = (this.jdField_a_of_type_AndroidGraphicsRect.top + a());
    int i1 = 0;
    while (i1 < i2)
    {
      if ((i1 != i2 - 1) || (!a(this.m)))
      {
        View localView = getChildAt(i1);
        localRect.left = localView.getRight();
        localRect.right = (localView.getRight() + this.jdField_g_of_type_Int);
        if (localRect.left < getPaddingLeft()) {
          localRect.left = getPaddingLeft();
        }
        if (localRect.right > getWidth() - getPaddingRight()) {
          localRect.right = (getWidth() - getPaddingRight());
        }
        a(paramCanvas, localRect);
        if ((i1 == 0) && (localView.getLeft() > getPaddingLeft()))
        {
          localRect.left = getPaddingLeft();
          localRect.right = localView.getLeft();
          a(paramCanvas, localRect);
        }
      }
      i1 += 1;
    }
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramRect);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (paramMotionEvent.getPointerId(i1) == this.A) {
      if (i1 != 0) {
        break label83;
      }
    }
    label83:
    for (i1 = 1;; i1 = 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getX(i1);
      this.A = paramMotionEvent.getPointerId(i1);
      if (this.jdField_a_of_type_AndroidViewVelocityTracker != null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      }
      this.E = ((int)paramMotionEvent.getX(i1));
      this.F = ((int)paramMotionEvent.getY(i1));
      return;
    }
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = a(paramView);
    int i2 = ViewGroup.getChildMeasureSpec(this.jdField_c_of_type_Int, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    if (localLayoutParams.width > 0) {}
    for (int i1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);; i1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(i1, i2);
      return;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getChildCount() > 0)
    {
      int i1 = getScrollX();
      View localView1 = getChildAt(0);
      View localView2 = getChildAt(getChildCount() - 1);
      bool1 = bool2;
      if (paramInt1 >= localView1.getLeft() - i1)
      {
        bool1 = bool2;
        if (paramInt2 >= localView1.getTop())
        {
          bool1 = bool2;
          if (paramInt1 < localView2.getRight() - i1)
          {
            bool1 = bool2;
            if (paramInt2 < localView2.getBottom()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private int b()
  {
    return getWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int i2 = getScrollX();
    int i1 = i2;
    if (getScrollX() > 0)
    {
      i1 = i2;
      if (getScrollX() > paramInt2) {
        i1 = getScrollX() - paramInt2;
      }
    }
    paramInt2 = getWidth();
    if (paramInt1 * i1 < 0) {}
    while (paramInt2 == 0) {
      return paramInt1;
    }
    return (paramInt2 - Math.abs(i1)) * paramInt1 / paramInt2 / 2;
  }
  
  private void b()
  {
    a();
    removeAllViewsInLayout();
    requestLayout();
  }
  
  private void b(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView != paramView)
    {
      d();
      this.jdField_a_of_type_AndroidViewView = paramView;
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setPressed(true);
    }
    setPressed(true);
  }
  
  private void b(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = generateDefaultLayoutParams();
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams1);
      return;
      localLayoutParams1 = localLayoutParams2;
      if (!checkLayoutParams(localLayoutParams2)) {
        localLayoutParams1 = generateLayoutParams(localLayoutParams2);
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    return paramInt < this.jdField_a_of_type_JavaUtilList.size();
  }
  
  private View c(int paramInt)
  {
    View localView1 = a(paramInt);
    View localView2 = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt, localView1, this);
    if ((localView1 != null) && (localView2 != localView1)) {
      a(paramInt, localView1);
    }
    if (localView2 != null) {
      b(localView2, paramInt);
    }
    return localView2;
  }
  
  private void c()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      a(getChildAt(i1));
      i1 += 1;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setPressed(false);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    setPressed(false);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      return;
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void h()
  {
    if (jdField_g_of_type_Boolean) {
      a("checkSpringback", new Object[] { Integer.valueOf(this.y) });
    }
    if (this.jdField_d_of_type_JavaLangRunnable == null) {
      this.jdField_d_of_type_JavaLangRunnable = new xtn(this);
    }
    removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    getHandler().post(this.jdField_d_of_type_JavaLangRunnable);
  }
  
  private void i()
  {
    this.jdField_c_of_type_Boolean = false;
    g();
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView$RunningOutOfDataListener != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.getCount() - (this.m + 1) < this.jdField_b_of_type_Int) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView$RunningOutOfDataListener.a();
    }
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
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      localObject2 = getChildAt(i1);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return getFirstVisiblePosition() + i1;
        }
      }
      i1 -= 1;
    }
    return -1;
  }
  
  ContextMenu.ContextMenuInfo a(View paramView, int paramInt, long paramLong)
  {
    return new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
  }
  
  protected View a(int paramInt)
  {
    paramInt = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt);
    if (b(paramInt)) {
      return (View)((Queue)this.jdField_a_of_type_JavaUtilList.get(paramInt)).poll();
    }
    return null;
  }
  
  public ListAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetOverScroller = new OverScroller(getContext());
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0.005F);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.p = localViewConfiguration.getScaledTouchSlop();
    this.B = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.C = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.l = -1;
    this.m = -1;
    this.f = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.j = Integer.MAX_VALUE;
    this.k = 0;
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    this.y = -1;
    g(4097);
    this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new xtq(this);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 + paramInt2 + this.jdField_g_of_type_Int < getWidth()) && (this.m + 1 < this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()))
    {
      this.m += 1;
      if (this.l < 0) {
        this.l = this.m;
      }
      View localView = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(this.m, a(this.m), this);
      a(localView, -1);
      if (this.m == 0) {}
      for (int i1 = 0;; i1 = this.jdField_g_of_type_Int)
      {
        i1 = paramInt1 + (i1 + localView.getMeasuredWidth());
        j();
        paramInt1 = i1;
        if (!jdField_g_of_type_Boolean) {
          break;
        }
        a("fillListRight", new Object[] { "mRightViewAdapterIndex", Integer.valueOf(this.m) });
        paramInt1 = i1;
        break;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Xts == null) {
      this.jdField_a_of_type_Xts = new xts(this);
    }
    this.jdField_a_of_type_Xts.a(paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(int paramInt, View paramView)
  {
    paramInt = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt);
    if (b(paramInt)) {
      ((Queue)this.jdField_a_of_type_JavaUtilList.get(paramInt)).offer(paramView);
    }
  }
  
  protected void a(View paramView, int paramInt)
  {
    addViewInLayout(paramView, paramInt, a(paramView), true);
    a(paramView);
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    int i1 = 0;
    if ((jdField_g_of_type_Boolean) && (QLog.isDevelopLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder(200);
      localStringBuilder.setLength(0);
      localStringBuilder.append(paramString);
      localStringBuilder.append(", mDisplayOffset = ").append(this.f);
      localStringBuilder.append(", mMaxX = ").append(this.j);
      localStringBuilder.append(", mMinX = ").append(this.k);
      localStringBuilder.append(", mCurrentX = ").append(this.jdField_h_of_type_Int);
      localStringBuilder.append(", mNextX = ").append(this.jdField_i_of_type_Int);
      localStringBuilder.append(", mScrollX = ").append(getScrollX());
      localStringBuilder.append(", mLeftViewAdapterIndex= ").append(this.l);
      localStringBuilder.append(", mRightViewAdapterIndex = ").append(this.m);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        int i2 = paramVarArgs.length;
        while (i1 < i2)
        {
          paramString = paramVarArgs[i1];
          localStringBuilder.append(",").append(paramString);
          i1 += 1;
        }
      }
      QLog.i(jdField_a_of_type_JavaLangString, 4, localStringBuilder.toString());
    }
  }
  
  protected boolean a()
  {
    if (!this.jdField_h_of_type_Boolean) {}
    int i1;
    do
    {
      View localView;
      do
      {
        return false;
        if (!this.jdField_i_of_type_Boolean) {
          if (Math.abs(this.jdField_h_of_type_Int - this.j) < this.p) {
            i1 = 1;
          }
        }
        while (i1 != 0)
        {
          i1 = this.j;
          this.jdField_h_of_type_Int = i1;
          this.jdField_i_of_type_Int = i1;
          invalidate();
          return false;
          i1 = 0;
          continue;
          if (Math.abs(this.jdField_h_of_type_Int - this.k) < this.p) {
            i1 = 1;
          } else {
            i1 = 0;
          }
        }
        if (this.p + this.f >= 0)
        {
          this.jdField_i_of_type_Int += this.f;
          invalidate();
          return false;
        }
        localView = getChildAt(0);
      } while (localView == null);
      i1 = this.jdField_i_of_type_Int;
      int i2 = this.f + i1;
      int i3 = localView.getMeasuredWidth();
      i1 = i2;
      if (this.f <= -(i3 / 2 + 0.5D)) {
        i1 = i2 + i3;
      }
    } while (!this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.jdField_i_of_type_Int + getScrollX(), 0, i1, i1, 0, 0));
    if (jdField_g_of_type_Boolean) {
      a("checkScrollToChild", new Object[] { Integer.valueOf(this.y), Integer.valueOf(i1) });
    }
    invalidate();
    return true;
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt == this.jdField_a_of_type_AndroidWidgetListAdapter.getCount() - 1;
  }
  
  public boolean a(View paramView, int paramInt, long paramLong)
  {
    AdapterView.OnItemLongClickListener localOnItemLongClickListener = getOnItemLongClickListener();
    if (localOnItemLongClickListener != null) {}
    for (boolean bool1 = localOnItemLongClickListener.onItemLongClick(this, paramView, paramInt, paramLong);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        this.jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo = a(paramView, paramInt, paramLong);
        bool2 = super.showContextMenuForChild(this);
      }
      if (bool2) {
        performHapticFeedback(0);
      }
      return bool2;
    }
  }
  
  public void a_(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
  }
  
  int b(int paramInt)
  {
    int i1 = getChildCount();
    if (i1 > 0)
    {
      i1 -= 1;
      while (i1 >= 0)
      {
        if (paramInt >= getChildAt(i1).getLeft()) {
          return i1 + getFirstVisiblePosition();
        }
        i1 -= 1;
      }
    }
    return -1;
  }
  
  protected View b()
  {
    return getChildAt(0);
  }
  
  public View b(int paramInt)
  {
    if ((paramInt >= this.l) && (paramInt <= this.m)) {
      return getChildAt(paramInt - this.l);
    }
    return null;
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 + paramInt2 - this.jdField_g_of_type_Int > 0) && (this.l >= 1))
    {
      this.l -= 1;
      View localView = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(this.l, a(this.l), this);
      a(localView, 0);
      int i1;
      label71:
      int i2;
      if (this.l == 0)
      {
        i1 = localView.getMeasuredWidth();
        i1 = paramInt1 - i1;
        i2 = this.f;
        if (i1 + paramInt2 != 0) {
          break label159;
        }
      }
      label159:
      for (paramInt1 = localView.getMeasuredWidth();; paramInt1 = this.jdField_g_of_type_Int + localView.getMeasuredWidth())
      {
        this.f = (i2 - paramInt1);
        paramInt1 = i1;
        if (!jdField_g_of_type_Boolean) {
          break;
        }
        a("fillListLeft", new Object[] { "mLeftViewAdapterIndex", Integer.valueOf(this.l) });
        paramInt1 = i1;
        break;
        i1 = this.jdField_g_of_type_Int + localView.getMeasuredWidth();
        break label71;
      }
    }
  }
  
  public boolean b()
  {
    return (this.jdField_d_of_type_Boolean) && ((getParent() instanceof View));
  }
  
  public int c(int paramInt)
  {
    int i1 = this.jdField_i_of_type_Int + paramInt;
    if (i1 < 0) {
      return -1;
    }
    if (i1 > this.j) {
      return 1;
    }
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.jdField_i_of_type_Int, 0, paramInt, 0, 20);
    g(4098);
    requestLayout();
    return 0;
  }
  
  protected View c()
  {
    return getChildAt(getChildCount() - 1);
  }
  
  protected void c(int paramInt)
  {
    int i2 = 0;
    View localView = c();
    if (localView != null) {}
    for (int i1 = localView.getRight();; i1 = 0)
    {
      a(i1, paramInt);
      localView = b();
      i1 = i2;
      if (localView != null) {
        i1 = localView.getLeft();
      }
      b(i1, paramInt);
      return;
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.y = 4;
    g(4099);
    int i1 = this.jdField_h_of_type_Int;
    if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a())
    {
      i1 = getScrollX();
      i1 = this.jdField_i_of_type_Int + i1;
    }
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a(i1, 0, -paramInt1, 0, paramInt2);
    this.jdField_a_of_type_Float = 0.0F;
    g();
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  protected boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a(this.m))
    {
      View localView = c();
      bool1 = bool2;
      if (localView != null)
      {
        int i1 = this.j;
        int i2 = this.jdField_h_of_type_Int;
        this.j = (localView.getRight() - getPaddingLeft() + i2 - b());
        if (this.j < 0) {
          this.j = 0;
        }
        bool1 = bool2;
        if (this.j != i1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_ComTencentWidgetOverScroller.b())
    {
      i1 = getScrollX();
      int i3 = this.jdField_i_of_type_Int + i1;
      int i4 = this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
      int i5 = this.jdField_i_of_type_Int;
      if (jdField_g_of_type_Boolean) {
        a("computeScroll", new Object[] { "MOVING", Integer.valueOf(i3), Integer.valueOf(i4) });
      }
      int i6;
      int i8;
      int i2;
      if (i3 != i4)
      {
        i6 = this.j;
        int i7 = this.k;
        i1 = getOverScrollMode();
        if ((i1 == 0) || ((i1 == 1) && (i6 > 0)))
        {
          i1 = 1;
          if ((i1 == 0) || ((i4 >= i7) && (i4 <= i6))) {
            break label314;
          }
          i8 = getWidth() - 50;
          i2 = 0;
          if ((i4 >= i7) || (i4 >= -i8) || (i4 >= i3)) {
            break label253;
          }
          i1 = 1;
          label166:
          if (i1 == 0) {
            break label287;
          }
          this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
          this.jdField_a_of_type_ComTencentWidgetOverScroller.a(getScrollX() + this.jdField_i_of_type_Int, getScrollY(), this.jdField_i_of_type_Int, this.jdField_i_of_type_Int, 0, 0);
          label208:
          if (i4 >= i7) {
            break label342;
          }
          this.jdField_i_of_type_Int = i7;
        }
      }
      for (;;)
      {
        if (i5 != this.jdField_i_of_type_Int)
        {
          d();
          requestLayout();
        }
        awakenScrollBars();
        postInvalidate();
        return;
        i1 = 0;
        break;
        label253:
        i1 = i2;
        if (i6 == Integer.MAX_VALUE) {
          break label166;
        }
        i1 = i2;
        if (i4 <= i6 + i8) {
          break label166;
        }
        i1 = i2;
        if (i4 <= i3) {
          break label166;
        }
        i1 = 1;
        break label166;
        label287:
        overScrollBy(i4 - i3, 0, getScrollX(), getScrollY(), 0, 0, i8, 0, false);
        break label208;
        label314:
        if (i3 != i5) {
          scrollTo(0, 0);
        }
        this.jdField_i_of_type_Int += i4 - i3;
        break label208;
        label342:
        if (i4 > i6)
        {
          this.jdField_i_of_type_Int = i6;
          continue;
          if (Math.abs(getScrollX()) < this.p)
          {
            this.jdField_i_of_type_Int = i3;
            scrollTo(0, 0);
          }
          else
          {
            h();
          }
        }
      }
    }
    int i1 = getScrollX();
    if ((this.o == 4099) || ((this.o == 4097) && (this.j == this.jdField_i_of_type_Int) && (i1 != 0))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((jdField_g_of_type_Boolean) && (QLog.isDevelopLevel())) {
        a("computeScroll", new Object[] { "over", Integer.valueOf(this.o), Boolean.valueOf(bool) });
      }
      if (!bool) {
        break;
      }
      this.y = -1;
      if (Math.abs(i1) >= this.p) {
        break label524;
      }
      scrollTo(0, 0);
      g(4097);
      return;
    }
    label524:
    h();
  }
  
  protected void d(int paramInt)
  {
    View localView = b();
    if ((localView != null) && (localView.getRight() + paramInt <= 0))
    {
      int i2 = this.f;
      if (a(this.l)) {}
      for (int i1 = localView.getMeasuredWidth();; i1 = this.jdField_g_of_type_Int + localView.getMeasuredWidth())
      {
        this.f = (i1 + i2);
        a(this.l, localView);
        removeViewInLayout(localView);
        if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnItemScrollEventListener != null) {
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnItemScrollEventListener.a(this.l, true);
        }
        this.l += 1;
        localView = b();
        break;
      }
    }
    for (localView = c(); (localView != null) && (localView.getLeft() + paramInt >= getWidth()); localView = c())
    {
      a(this.m, localView);
      removeViewInLayout(localView);
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnItemScrollEventListener != null) {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnItemScrollEventListener.a(this.m, false);
      }
      this.m -= 1;
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Xts == null) {
      this.jdField_a_of_type_Xts = new xts(this);
    }
    this.jdField_a_of_type_Xts.a(paramInt1, paramInt2);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  protected void e(int paramInt)
  {
    int i2 = 0;
    int i3 = getChildCount();
    if (i3 > 0)
    {
      if (jdField_g_of_type_Boolean) {
        a("positionChildren", new Object[] { Integer.valueOf(this.f), Integer.valueOf(paramInt), Integer.valueOf(this.f + paramInt) });
      }
      if (this.l == 0) {
        this.k = (this.f + this.jdField_h_of_type_Int);
      }
      this.f += paramInt;
      int i1 = this.f;
      paramInt = i2;
      while (paramInt < i3)
      {
        View localView = getChildAt(paramInt);
        i2 = getPaddingLeft() + i1;
        int i4 = getPaddingTop();
        localView.layout(i2, i4, localView.getMeasuredWidth() + i2, localView.getMeasuredHeight() + i4);
        i1 += localView.getMeasuredWidth() + this.jdField_g_of_type_Int;
        paramInt += 1;
      }
    }
  }
  
  public void f(int paramInt)
  {
    this.y = 6;
    g(4099);
    if (getChildCount() > 0)
    {
      this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.jdField_i_of_type_Int + getScrollX(), 0, paramInt, 0, this.k, this.j, 0, 0, Math.max(0, getWidth() / 2), 0);
      requestLayout();
    }
  }
  
  public void g(int paramInt)
  {
    int i1 = paramInt;
    if (this.jdField_h_of_type_Boolean)
    {
      i1 = paramInt;
      if (this.o != paramInt)
      {
        i1 = paramInt;
        if (paramInt == 4097) {
          switch (this.o)
          {
          default: 
            i1 = paramInt;
          }
        }
      }
    }
    for (;;)
    {
      if ((this.o != i1) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener != null)) {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener.a(i1);
      }
      this.o = i1;
      return;
      i1 = paramInt;
      if (a())
      {
        paramInt = 4099;
        i1 = paramInt;
        if (jdField_g_of_type_Boolean)
        {
          a("setCurrentScrollState", new Object[] { "SCROLL_STATE_TOUCH_SCROLL" });
          i1 = paramInt;
          continue;
          i1 = paramInt;
          if (a())
          {
            i1 = paramInt;
            if (jdField_g_of_type_Boolean)
            {
              a("setCurrentScrollState", new Object[] { "SCROLL_STATE_FLING" });
              i1 = paramInt;
            }
          }
        }
      }
    }
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.l;
  }
  
  public int getLastVisiblePosition()
  {
    return this.m;
  }
  
  public int getOverScrollMode()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.getOverScrollMode();
    }
    return 0;
  }
  
  public View getSelectedView()
  {
    return b(this.n);
  }
  
  public void h(int paramInt)
  {
    if (this.jdField_a_of_type_Xts == null) {
      this.jdField_a_of_type_Xts = new xts(this);
    }
    this.jdField_a_of_type_Xts.a(paramInt);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(AbsListView.class.getName());
    if (isEnabled())
    {
      if (getFirstVisiblePosition() > 0) {
        paramAccessibilityNodeInfo.addAction(8192);
      }
      if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
        break label63;
      }
    }
    label63:
    for (int i1 = 0;; i1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount())
    {
      if (getLastVisiblePosition() < i1 - 1) {
        paramAccessibilityNodeInfo.addAction(4096);
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 2) && (this.jdField_c_of_type_Boolean)) {
      return true;
    }
    switch (i1 & 0xFF)
    {
    }
    for (;;)
    {
      boolean bool1;
      if (!this.jdField_c_of_type_Boolean)
      {
        bool1 = bool2;
        if (!super.onInterceptTouchEvent(paramMotionEvent)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      i1 = this.A;
      if (i1 != -1)
      {
        float f1 = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(i1));
        if ((int)Math.abs(f1 - this.jdField_a_of_type_Float) > this.p)
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_a_of_type_Float = f1;
          f();
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
          ViewParent localViewParent = getParent();
          if (localViewParent != null)
          {
            localViewParent.requestDisallowInterceptTouchEvent(true);
            continue;
            f1 = paramMotionEvent.getX();
            if (!a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
            {
              this.jdField_c_of_type_Boolean = false;
              g();
            }
            else
            {
              this.jdField_a_of_type_Float = f1;
              this.A = paramMotionEvent.getPointerId(0);
              e();
              this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
              if (!this.jdField_a_of_type_ComTencentWidgetOverScroller.a()) {}
              for (bool1 = true;; bool1 = false)
              {
                this.jdField_c_of_type_Boolean = bool1;
                g(4097);
                break;
              }
              this.jdField_c_of_type_Boolean = false;
              this.A = -1;
              g();
              if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a(getScrollX() + this.jdField_i_of_type_Int, getScrollY(), this.jdField_i_of_type_Int, this.jdField_i_of_type_Int, 0, 0))
              {
                this.y = 6;
                g(4099);
                invalidate();
              }
              for (;;)
              {
                d();
                break;
                this.y = -1;
                g(4097);
              }
              a(paramMotionEvent);
            }
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null) {}
    do
    {
      return;
      invalidate();
      int i1;
      if (this.jdField_a_of_type_Boolean)
      {
        i1 = this.jdField_h_of_type_Int;
        a();
        removeAllViewsInLayout();
        this.jdField_i_of_type_Int = i1;
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_JavaLangRunnable != null)
        {
          post(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_JavaLangRunnable = null;
        }
      }
      if (this.jdField_a_of_type_JavaLangInteger != null)
      {
        this.jdField_i_of_type_Int = this.jdField_a_of_type_JavaLangInteger.intValue();
        this.jdField_a_of_type_JavaLangInteger = null;
      }
      if (this.jdField_i_of_type_Int < this.k) {
        this.jdField_i_of_type_Int = this.k;
      }
      for (;;)
      {
        c();
        i1 = this.jdField_h_of_type_Int - this.jdField_i_of_type_Int;
        d(i1);
        c(i1);
        e(i1);
        this.jdField_h_of_type_Int = this.jdField_i_of_type_Int;
        if (!c()) {
          break;
        }
        onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
        if (this.jdField_i_of_type_Int > this.j) {
          this.jdField_i_of_type_Int = this.j;
        }
      }
      View localView = c();
      if ((localView != null) && (localView.getRight() + this.jdField_g_of_type_Int < b()) && (this.m < this.jdField_a_of_type_AndroidWidgetListAdapter.getCount() - 1))
      {
        onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentWidgetOverScroller.a());
    ViewCompat.postOnAnimation(this, this.e);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i4 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    int i1;
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null)
    {
      i1 = 0;
      if ((i1 <= 0) || ((i5 != 0) && (i5 != Integer.MIN_VALUE) && (i4 != 0))) {
        break label218;
      }
      View localView = c(0);
      if (localView == null) {
        break label218;
      }
      measureChild(localView, paramInt1, paramInt2);
      paramInt1 = localView.getMeasuredWidth();
      i1 = localView.getMeasuredHeight();
      a(0, localView);
    }
    for (;;)
    {
      if ((i5 == 0) || (i5 == Integer.MIN_VALUE))
      {
        paramInt2 = getPaddingTop() + getPaddingBottom() + i1 + getVerticalFadingEdgeLength() * 2;
        this.jdField_c_of_type_Int = View.MeasureSpec.makeMeasureSpec(paramInt2, i5);
        label140:
        if (i4 != 0) {
          break label194;
        }
        paramInt1 = getPaddingLeft() + getPaddingRight() + paramInt1 + getVerticalScrollbarWidth();
      }
      for (;;)
      {
        setMeasuredDimension(paramInt1, paramInt2);
        return;
        i1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
        break;
        this.jdField_c_of_type_Int = paramInt2;
        paramInt2 = i3;
        break label140;
        label194:
        paramInt1 = i2;
        if (i4 == Integer.MIN_VALUE) {
          paramInt1 = a(0, -1, i2, -1);
        }
      }
      label218:
      i1 = 0;
      paramInt1 = 0;
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
    awakenScrollBars();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramParcelable.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(paramParcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    localBundle.putInt("BUNDLE_ID_CURRENT_X", this.jdField_h_of_type_Int);
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    f();
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    label107:
    int i1;
    label403:
    label434:
    label753:
    label783:
    label906:
    label969:
    label1152:
    label1253:
    label1261:
    label1270:
    label1277:
    label1311:
    label1501:
    do
    {
      do
      {
        Object localObject;
        int i2;
        do
        {
          do
          {
            return true;
            if (getChildCount() == 0) {
              return false;
            }
            if (this.y == 6)
            {
              this.y = 5;
              this.E = ((int)paramMotionEvent.getX());
              this.F = ((int)paramMotionEvent.getY());
              if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a()) {
                break label434;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              this.jdField_c_of_type_Boolean = bool;
              if (bool)
              {
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
              }
              if (!this.jdField_a_of_type_ComTencentWidgetOverScroller.a()) {
                this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
              }
              this.jdField_a_of_type_Float = paramMotionEvent.getX();
              this.A = paramMotionEvent.getPointerId(0);
              g(4097);
              if (!jdField_g_of_type_Boolean) {
                break;
              }
              a("onTouchEvent", new Object[] { "DOWN", Boolean.valueOf(this.jdField_c_of_type_Boolean) });
              return true;
              if (b())
              {
                this.y = 0;
                if (this.jdField_b_of_type_JavaLangRunnable == null) {
                  this.jdField_b_of_type_JavaLangRunnable = new xtp(this);
                }
                postDelayed(this.jdField_b_of_type_JavaLangRunnable, ViewConfiguration.getTapTimeout());
                this.D = getFirstVisiblePosition();
                this.E = ((int)paramMotionEvent.getX());
                this.F = ((int)paramMotionEvent.getY());
                break label107;
              }
              i2 = a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
              i1 = i2;
              if (!this.jdField_a_of_type_Boolean)
              {
                if ((this.y == 4) || (i2 < 0) || (!a().isEnabled(i2))) {
                  break label403;
                }
                this.y = 0;
                if (this.jdField_b_of_type_JavaLangRunnable == null) {
                  this.jdField_b_of_type_JavaLangRunnable = new xtp(this);
                }
                postDelayed(this.jdField_b_of_type_JavaLangRunnable, ViewConfiguration.getTapTimeout());
                i1 = i2;
              }
              for (;;)
              {
                this.D = i1;
                break;
                i1 = i2;
                if (this.y == 4)
                {
                  this.y = 3;
                  i1 = b((int)paramMotionEvent.getX());
                }
              }
            }
            i1 = paramMotionEvent.findPointerIndex(this.A);
          } while (i1 == -1);
          f1 = paramMotionEvent.getX(i1);
          i2 = (int)(this.jdField_a_of_type_Float - f1);
          i1 = i2;
          if (!this.jdField_c_of_type_Boolean)
          {
            i1 = i2;
            if (Math.abs(i2) > this.p)
            {
              paramMotionEvent = getParent();
              if (paramMotionEvent != null) {
                paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              }
              this.jdField_c_of_type_Boolean = true;
              if (i2 <= 0) {
                break;
              }
              i1 = i2 - this.p;
            }
          }
        } while (!this.jdField_c_of_type_Boolean);
        switch (this.y)
        {
        }
        for (;;)
        {
          g(4098);
          a(f1, i1);
          return true;
          i1 = i2 + this.p;
          break;
          paramMotionEvent = getHandler();
          if (paramMotionEvent != null) {
            paramMotionEvent.removeCallbacks(this.jdField_a_of_type_Xto);
          }
          if (this.jdField_c_of_type_JavaLangRunnable != null) {
            removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
          }
          d();
          if (getScrollX() != 0)
          {
            this.y = 5;
          }
          else
          {
            this.y = 3;
            continue;
            if (getScrollX() != 0) {
              this.y = 5;
            } else {
              this.y = 3;
            }
          }
        }
        if ((this.jdField_c_of_type_Boolean) || (Math.abs(getScrollX()) > this.p))
        {
          localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.C);
          if (Build.VERSION.SDK_INT >= 8)
          {
            f1 = ((VelocityTracker)localObject).getXVelocity(this.A);
            i1 = (int)f1;
            if (getChildCount() <= 0) {
              break label969;
            }
            if (Math.abs(i1) <= this.B) {
              break label906;
            }
            f(-i1);
            this.A = -1;
            i();
          }
        }
        else
        {
          switch (this.y)
          {
          }
        }
        for (;;)
        {
          setPressed(false);
          invalidate();
          paramMotionEvent = getHandler();
          if (paramMotionEvent != null) {
            paramMotionEvent.removeCallbacks(this.jdField_a_of_type_Xto);
          }
          if (!jdField_g_of_type_Boolean) {
            break;
          }
          a("onTouchEvent", new Object[] { "UP", Integer.valueOf(this.y) });
          return true;
          f1 = ((VelocityTracker)localObject).getXVelocity();
          break label753;
          if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a(getScrollX() + this.jdField_i_of_type_Int, getScrollY(), this.jdField_i_of_type_Int, this.jdField_i_of_type_Int, 0, 0))
          {
            this.y = 6;
            g(4099);
            invalidate();
            break label783;
          }
          g(4097);
          break label783;
          g(4097);
          break label783;
          i2 = this.D;
          localObject = getChildAt(i2 - getFirstVisiblePosition());
          f1 = paramMotionEvent.getX();
          xtr localxtr;
          if ((f1 > getPaddingLeft()) && (f1 < getWidth() - getPaddingRight()))
          {
            i1 = 1;
            if (this.jdField_a_of_type_Xtr == null) {
              this.jdField_a_of_type_Xtr = new xtr(this, null);
            }
            localxtr = this.jdField_a_of_type_Xtr;
            localxtr.a = i2;
            localxtr.a();
            if ((localObject == null) || (((View)localObject).hasFocusable()) || (i1 == 0)) {
              break label1311;
            }
            if (this.y != 0)
            {
              d();
              if (this.jdField_c_of_type_JavaLangRunnable != null) {
                removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
              }
            }
            if ((this.y != 0) && (this.y != 1)) {
              break label1277;
            }
            Handler localHandler = getHandler();
            if (localHandler != null)
            {
              if (this.y != 0) {
                break label1253;
              }
              paramMotionEvent = this.jdField_b_of_type_JavaLangRunnable;
              localHandler.removeCallbacks(paramMotionEvent);
            }
            if ((this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_AndroidWidgetListAdapter.isEnabled(i2))) {
              break label1270;
            }
            this.y = 1;
            if (!b()) {
              break label1261;
            }
            b((View)getParent());
          }
          for (;;)
          {
            if (this.jdField_c_of_type_JavaLangRunnable != null) {
              removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
            }
            this.jdField_c_of_type_JavaLangRunnable = new xtm(this, localxtr);
            postDelayed(this.jdField_c_of_type_JavaLangRunnable, ViewConfiguration.getPressedStateDuration());
            return true;
            i1 = 0;
            break;
            paramMotionEvent = this.jdField_a_of_type_Xto;
            break label1152;
            b((View)localObject);
          }
          this.y = -1;
          return true;
          if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetListAdapter.isEnabled(i2))) {
            localxtr.run();
          }
          for (;;)
          {
            this.y = -1;
            break;
            localxtr.run();
          }
          this.y = -1;
          continue;
          this.y = -1;
        }
        d();
        if ((this.jdField_c_of_type_Boolean) && (getChildCount() > 0))
        {
          if (!this.jdField_a_of_type_ComTencentWidgetOverScroller.a(getScrollX() + this.jdField_i_of_type_Int, getScrollY(), this.jdField_i_of_type_Int, this.jdField_i_of_type_Int, 0, 0)) {
            break label1501;
          }
          this.y = 6;
          g(4099);
          invalidate();
        }
        for (;;)
        {
          this.A = -1;
          i();
          switch (this.y)
          {
          default: 
            this.y = -1;
            d();
            paramMotionEvent = getHandler();
            if (paramMotionEvent != null) {
              paramMotionEvent.removeCallbacks(this.jdField_a_of_type_Xto);
            }
            break;
          }
          if (!jdField_g_of_type_Boolean) {
            break;
          }
          a("onTouchEvent", new Object[] { "CANCEL", Integer.valueOf(this.y) });
          return true;
          g(4097);
        }
        i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
        float f1 = paramMotionEvent.getX(i1);
        float f2 = paramMotionEvent.getY(i1);
        this.jdField_a_of_type_Float = f1;
        this.A = paramMotionEvent.getPointerId(i1);
        this.E = ((int)f1);
        this.F = ((int)f2);
        i1 = a((int)f1, (int)f2);
      } while (i1 < 0);
      this.D = i1;
      return true;
      a(paramMotionEvent);
      i1 = paramMotionEvent.findPointerIndex(this.A);
      if ((i1 < paramMotionEvent.getPointerCount()) && (-1 != i1)) {
        this.jdField_a_of_type_Float = paramMotionEvent.getX(i1);
      }
      i1 = a(this.E, this.F);
    } while (i1 < 0);
    this.D = i1;
    return true;
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int i3 = getOverScrollMode();
    int i1;
    int i2;
    if (computeHorizontalScrollRange() > computeHorizontalScrollExtent())
    {
      i1 = 1;
      if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) {
        break label176;
      }
      i2 = 1;
      label34:
      if ((i3 != 0) && ((i3 != 1) || (i1 == 0))) {
        break label182;
      }
      i1 = 1;
      label53:
      if ((i3 != 0) && ((i3 != 1) || (i2 == 0))) {
        break label188;
      }
      i2 = 1;
      label72:
      paramInt3 += paramInt1;
      if (i1 == 0) {
        paramInt7 = 0;
      }
      paramInt4 += paramInt2;
      if (i2 == 0) {
        paramInt8 = 0;
      }
      i1 = -paramInt7;
      if (paramInt7 != Integer.MAX_VALUE) {
        break label194;
      }
      paramInt1 = Integer.MAX_VALUE;
      label113:
      paramInt5 = -paramInt8;
      if (paramInt8 != Integer.MAX_VALUE) {
        break label203;
      }
      paramInt2 = Integer.MAX_VALUE;
      label128:
      if (paramInt3 <= paramInt1) {
        break label212;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      label136:
      boolean bool = false;
      if (paramInt4 > paramInt2) {
        bool = true;
      }
      for (;;)
      {
        onOverScrolled(paramInt1, paramInt2, paramBoolean, bool);
        if ((paramBoolean) || (bool))
        {
          return true;
          i1 = 0;
          break;
          label176:
          i2 = 0;
          break label34;
          label182:
          i1 = 0;
          break label53;
          label188:
          i2 = 0;
          break label72;
          label194:
          paramInt1 = paramInt7 + paramInt5;
          break label113;
          label203:
          paramInt2 = paramInt8 + paramInt6;
          break label128;
          label212:
          if (paramInt3 >= i1) {
            break label251;
          }
          paramBoolean = true;
          paramInt1 = i1;
          break label136;
          if (paramInt4 >= paramInt5) {
            break label245;
          }
          bool = true;
          paramInt2 = paramInt5;
          continue;
        }
        return false;
        label245:
        paramInt2 = paramInt4;
      }
      label251:
      paramBoolean = false;
      paramInt1 = paramInt3;
    }
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramInt, paramBundle)) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null) {}
    for (int i1 = 0;; i1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()) {
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    int i2;
    if ((isEnabled()) && (getLastVisiblePosition() < i1 - 1))
    {
      paramInt = getWidth();
      i1 = getPaddingLeft();
      i2 = getPaddingRight();
      a(this.jdField_a_of_type_Float, paramInt - i1 - i2);
      return true;
    }
    return false;
    if ((isEnabled()) && (getFirstVisiblePosition() > 0))
    {
      paramInt = getWidth();
      i1 = getPaddingLeft();
      i2 = getPaddingRight();
      a(this.jdField_a_of_type_Float, -(paramInt - i1 - i2));
      return true;
    }
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      g();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void sendAccessibilityEvent(int paramInt)
  {
    if (paramInt == 4096)
    {
      int i1 = getFirstVisiblePosition();
      int i2 = getLastVisiblePosition();
      if ((this.G == i1) && (this.H == i2)) {
        return;
      }
      this.G = i1;
      this.H = i2;
    }
    super.sendAccessibilityEvent(paramInt);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetListAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      if (paramListAdapter != null)
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
        this.jdField_a_of_type_AndroidWidgetListAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      }
      if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
        a(this.jdField_a_of_type_AndroidWidgetListAdapter.getViewTypeCount());
      }
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      setDividerWidth(paramDrawable.getIntrinsicWidth());
      return;
    }
    setDividerWidth(0);
  }
  
  public void setDividerWidth(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setOnItemScollEventListener(HorizontalListView.OnItemScrollEventListener paramOnItemScrollEventListener)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnItemScrollEventListener = paramOnItemScrollEventListener;
  }
  
  public void setOnScrollStateChangedListener(HorizontalListView.OnScrollStateChangedListener paramOnScrollStateChangedListener)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener = paramOnScrollStateChangedListener;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(paramInt);
    }
  }
  
  public void setRestoreX(int paramInt)
  {
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
  }
  
  public void setRunningOutOfDataListener(HorizontalListView.RunningOutOfDataListener paramRunningOutOfDataListener, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView$RunningOutOfDataListener = paramRunningOutOfDataListener;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setSelection(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setStayDisplayOffsetZero(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setTransTouchStateToParent(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\HorizontalListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */