package com.tencent.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RemoteViews.RemoteView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableView;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import xrq;
import xsa;
import xty;
import xtz;
import xua;
import xub;

@RemoteViews.RemoteView
public class ListView
  extends AbsListView
  implements SkinnableView
{
  private static final float jdField_a_of_type_Float = 0.33F;
  private static final int jdField_a_of_type_Int;
  static final int aK = -1;
  private static final int jdField_b_of_type_Int;
  private static final int jdField_c_of_type_Int;
  private static final int jdField_d_of_type_Int;
  private static final int jdField_e_of_type_Int;
  private static final int jdField_f_of_type_Int;
  private static final int g;
  private static final int h = 2;
  private static final int i = 0;
  private static final int j = 1;
  private static final int k = 2;
  private static final int l = 3;
  private static final int n = 2131230829;
  private static final int o = 350;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ListView.OnScrollChangeListener jdField_a_of_type_ComTencentWidgetListView$OnScrollChangeListener;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener;
  protected ArrayList a;
  private final xty jdField_a_of_type_Xty = new xty(null);
  private xtz jdField_a_of_type_Xtz;
  private xub jdField_a_of_type_Xub;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  public int aL;
  protected int aM;
  protected int aN;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private xub jdField_b_of_type_Xub;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_d_of_type_Boolean;
  Drawable jdField_e_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_e_of_type_Boolean = true;
  Drawable jdField_f_of_type_AndroidGraphicsDrawableDrawable;
  protected Drawable g;
  private int m = 0;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = a("ListView_footerDividersEnabled");
    jdField_b_of_type_Int = a("ListView_headerDividersEnabled");
    jdField_c_of_type_Int = a("ListView_dividerHeight");
    jdField_d_of_type_Int = a("ListView_overScrollFooter");
    jdField_e_of_type_Int = a("ListView_overScrollHeader");
    jdField_f_of_type_Int = a("ListView_divider");
    jdField_g_of_type_Int = a("ListView_entries");
  }
  
  public ListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramAttributeSet = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, a("ListView"), paramInt, 0));
    CharSequence[] arrayOfCharSequence = paramAttributeSet.a(jdField_g_of_type_Int);
    if (arrayOfCharSequence != null) {
      setAdapter(new ArrayAdapter(paramContext, 17367043, arrayOfCharSequence));
    }
    paramContext = paramAttributeSet.a(jdField_f_of_type_Int);
    if (paramContext != null) {
      setDivider(paramContext);
    }
    paramContext = paramAttributeSet.a(jdField_e_of_type_Int);
    if (paramContext != null) {
      setOverscrollHeader(paramContext);
    }
    paramContext = paramAttributeSet.a(jdField_d_of_type_Int);
    if (paramContext != null) {
      setOverscrollFooter(paramContext);
    }
    paramInt = paramAttributeSet.e(jdField_c_of_type_Int, 0);
    if (paramInt != 0) {
      setDividerHeight(paramInt);
    }
    this.jdField_c_of_type_Boolean = paramAttributeSet.a(jdField_b_of_type_Int, true);
    this.jdField_d_of_type_Boolean = paramAttributeSet.a(jdField_a_of_type_Int, true);
    paramAttributeSet.a();
  }
  
  private int a()
  {
    return Math.max(2, getVerticalFadingEdgeLength());
  }
  
  private int a(int paramInt)
  {
    int i2 = this.au;
    ListAdapter localListAdapter;
    if (paramInt == 130)
    {
      if (this.aF != -1) {}
      for (i1 = this.aF + 1; i1 >= this.jdField_a_of_type_AndroidWidgetListAdapter.getCount(); i1 = i2)
      {
        paramInt = -1;
        return paramInt;
      }
      paramInt = i1;
      if (i1 < i2) {
        paramInt = i2;
      }
      int i3 = t();
      localListAdapter = a();
      i1 = paramInt;
      for (;;)
      {
        if (i1 > i3) {
          break label220;
        }
        if (localListAdapter.isEnabled(i1))
        {
          paramInt = i1;
          if (getChildAt(i1 - i2).getVisibility() == 0) {
            break;
          }
        }
        i1 += 1;
      }
    }
    int i1 = getChildCount() + i2 - 1;
    if (this.aF != -1) {}
    for (paramInt = this.aF - 1; (paramInt < 0) || (paramInt >= this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()); paramInt = getChildCount() + i2 - 1) {
      return -1;
    }
    if (paramInt > i1) {}
    for (;;)
    {
      localListAdapter = a();
      for (;;)
      {
        if (i1 < i2) {
          break label220;
        }
        if (localListAdapter.isEnabled(i1))
        {
          paramInt = i1;
          if (getChildAt(i1 - i2).getVisibility() == 0) {
            break;
          }
        }
        i1 -= 1;
      }
      label220:
      return -1;
      i1 = paramInt;
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
    int i2 = this.jdField_c_of_type_AndroidGraphicsRect.top;
    int i3 = getChildCount();
    View localView;
    if (paramInt1 == 130)
    {
      paramInt1 = i3 - 1;
      if (paramInt2 != -1) {
        paramInt1 = paramInt2 - this.au;
      }
      i2 = this.au;
      localView = getChildAt(paramInt1);
      if (i2 + paramInt1 >= this.aG - 1) {
        break label282;
      }
    }
    label282:
    for (paramInt1 = i1 - a();; paramInt1 = i1)
    {
      if (localView.getBottom() <= paramInt1) {}
      while ((paramInt2 != -1) && (paramInt1 - localView.getTop() >= w())) {
        return 0;
      }
      paramInt2 = localView.getBottom() - paramInt1;
      paramInt1 = paramInt2;
      if (this.au + i3 == this.aG) {
        paramInt1 = Math.min(paramInt2, getChildAt(i3 - 1).getBottom() - i1);
      }
      return Math.min(paramInt1, w());
      if (paramInt2 != -1) {}
      for (paramInt1 = paramInt2 - this.au;; paramInt1 = 0)
      {
        i1 = this.au;
        localView = getChildAt(paramInt1);
        if (i1 + paramInt1 > 0) {}
        for (paramInt1 = a() + i2; (localView.getTop() < paramInt1) && ((paramInt2 == -1) || (localView.getBottom() - paramInt1 < w())); paramInt1 = i2)
        {
          paramInt2 = paramInt1 - localView.getTop();
          paramInt1 = paramInt2;
          if (this.au == 0) {
            paramInt1 = Math.min(paramInt2, i2 - getChildAt(0).getTop());
          }
          return Math.min(paramInt1, w());
        }
        break;
      }
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramInt1;
    if (paramInt3 != this.aG - 1) {
      i1 = paramInt1 - paramInt2;
    }
    return i1;
  }
  
  private int a(int paramInt1, View paramView, int paramInt2)
  {
    int i1 = 0;
    paramView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    offsetDescendantRectToMyCoords(paramView, this.jdField_a_of_type_AndroidGraphicsRect);
    if (paramInt1 == 33)
    {
      paramInt1 = i1;
      if (this.jdField_a_of_type_AndroidGraphicsRect.top < this.jdField_c_of_type_AndroidGraphicsRect.top)
      {
        i1 = this.jdField_c_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_AndroidGraphicsRect.top;
        paramInt1 = i1;
        if (paramInt2 > 0) {
          paramInt1 = i1 + a();
        }
      }
    }
    do
    {
      int i2;
      do
      {
        return paramInt1;
        i2 = getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
        paramInt1 = i1;
      } while (this.jdField_a_of_type_AndroidGraphicsRect.bottom <= i2);
      i1 = this.jdField_a_of_type_AndroidGraphicsRect.bottom - i2;
      paramInt1 = i1;
    } while (paramInt2 >= this.aG - 1);
    return i1 + a();
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    int i1 = paramView.getHeight();
    int i2 = ((AbsListView.LayoutParams)paramView.getLayoutParams()).jdField_a_of_type_Int;
    int i3 = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt1);
    View localView;
    AbsListView.LayoutParams localLayoutParams;
    if (i2 == i3)
    {
      localView = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt1, paramView, this);
      localLayoutParams = (AbsListView.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams != null) {
        break label506;
      }
      localLayoutParams = new AbsListView.LayoutParams(-1, -2, 0);
    }
    label221:
    label284:
    label293:
    label312:
    label414:
    label470:
    label478:
    label506:
    for (;;)
    {
      localLayoutParams.jdField_a_of_type_Int = i3;
      if (localView != paramView)
      {
        bool1 = paramView.isSelected();
        boolean bool2 = paramView.isPressed();
        this.jdField_a_of_type_Xsa.a(paramView, paramInt1);
        if (this.an != 0) {
          localView.setDrawingCacheBackgroundColor(this.an);
        }
        detachViewFromParent(paramInt4);
        addViewInLayout(localView, paramInt4, localLayoutParams, true);
        if (localView.isSelected() != bool1) {
          localView.setSelected(bool1);
        }
        if (localView.isPressed() != bool2) {
          localView.setPressed(bool2);
        }
        if ((this.S != 0) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null))
        {
          if (!(localView instanceof Checkable)) {
            break label414;
          }
          ((Checkable)localView).setChecked(this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt1));
        }
      }
      boolean bool1 = localView.isLayoutRequested();
      if (bool1)
      {
        i2 = ViewGroup.getChildMeasureSpec(this.aa, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right, localLayoutParams.width);
        paramInt4 = localLayoutParams.height;
        if (paramInt4 > 0)
        {
          paramInt4 = View.MeasureSpec.makeMeasureSpec(paramInt4, 1073741824);
          localView.measure(i2, paramInt4);
          paramInt4 = localView.getMeasuredWidth();
          i2 = localView.getMeasuredHeight();
          if (!paramBoolean) {
            break label470;
          }
          if (!bool1) {
            break label478;
          }
          localView.layout(paramInt3, paramInt2, paramInt4 + paramInt3, i2 + paramInt2);
        }
      }
      for (;;)
      {
        if ((this.jdField_g_of_type_Boolean) && (!localView.isDrawingCacheEnabled())) {
          localView.setDrawingCacheEnabled(true);
        }
        if ((VersionUtils.e()) && (((AbsListView.LayoutParams)localView.getLayoutParams()).jdField_b_of_type_Int != paramInt1)) {
          localView.jumpDrawablesToCurrentState();
        }
        return localView.getHeight() - i1;
        localView = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt1, this.jdField_a_of_type_Xsa.b(paramInt1), this);
        break;
        if ((getContext().getApplicationInfo().targetSdkVersion < 11) || (!VersionUtils.e())) {
          break label221;
        }
        localView.setActivated(this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt1));
        break label221;
        paramInt4 = View.MeasureSpec.makeMeasureSpec(0, 0);
        break label284;
        cleanupLayoutState(localView);
        break label293;
        paramInt2 -= i2;
        break label312;
        localView.offsetLeftAndRight(paramInt3 - localView.getLeft());
        localView.offsetTopAndBottom(paramInt2 - localView.getTop());
      }
    }
  }
  
  private View a(int paramInt)
  {
    this.au = Math.min(this.au, this.aF);
    this.au = Math.min(this.au, this.aG - 1);
    if (this.au < 0) {
      this.au = 0;
    }
    return a(this.au, paramInt);
  }
  
  private View a(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    int i1 = this.mBottom - this.mTop;
    int i2;
    if ((this.mGroupFlags & 0x22) == 34)
    {
      i1 -= this.jdField_c_of_type_AndroidGraphicsRect.bottom;
      i2 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i2;
    }
    for (;;)
    {
      boolean bool;
      if ((paramInt1 < i1) && (paramInt2 < this.aG)) {
        if (paramInt2 == this.aF)
        {
          bool = true;
          label70:
          View localView = a(paramInt2, paramInt1, true, this.jdField_c_of_type_AndroidGraphicsRect.left, bool);
          if (localView == null) {
            break label134;
          }
          i2 = localView.getBottom() + this.aL;
          paramInt1 = i2;
          if (!bool) {
            break label134;
          }
          paramInt1 = i2;
          localObject = localView;
        }
      }
      label134:
      for (;;)
      {
        paramInt2 += 1;
        break;
        bool = false;
        break label70;
        return (View)localObject;
      }
      i2 = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i2;
    }
  }
  
  private View a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = getVerticalFadingEdgeLength();
    int i1 = this.aF;
    paramInt2 = b(paramInt2, i2, i1);
    paramInt3 = a(paramInt3, i2, i1);
    View localView = a(i1, paramInt1, true, this.jdField_c_of_type_AndroidGraphicsRect.left, true);
    if (localView.getBottom() > paramInt3) {
      localView.offsetTopAndBottom(-Math.min(localView.getTop() - paramInt2, localView.getBottom() - paramInt3));
    }
    for (;;)
    {
      a(localView, i1);
      if (this.i) {
        break;
      }
      a(getChildCount());
      return localView;
      if (localView.getTop() < paramInt2) {
        localView.offsetTopAndBottom(Math.min(paramInt2 - localView.getTop(), paramInt3 - localView.getBottom()));
      }
    }
    c(getChildCount());
    return localView;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    d("ListView.makeAndAddView");
    try
    {
      if (!this.r)
      {
        localView = this.jdField_a_of_type_Xsa.a(paramInt1);
        if (localView != null)
        {
          a(localView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, true);
          return localView;
        }
      }
      View localView = a(paramInt1, this.jdField_a_of_type_ArrayOfBoolean);
      a(localView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, this.jdField_a_of_type_ArrayOfBoolean[0]);
      return localView;
    }
    finally
    {
      D();
    }
  }
  
  private View a(View paramView, int paramInt)
  {
    paramInt -= 1;
    View localView = a(paramInt, this.jdField_a_of_type_ArrayOfBoolean);
    a(localView, paramInt, paramView.getTop() - this.aL, false, this.jdField_c_of_type_AndroidGraphicsRect.left, false, this.jdField_a_of_type_ArrayOfBoolean[0]);
    return localView;
  }
  
  private View a(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = getVerticalFadingEdgeLength();
    int i3 = this.aF;
    int i1 = b(paramInt2, i2, i3);
    i2 = a(paramInt2, i2, i3);
    int i4;
    if (paramInt1 > 0)
    {
      paramView1 = a(i3 - 1, paramView1.getTop(), true, this.jdField_c_of_type_AndroidGraphicsRect.left, false);
      paramInt1 = this.aL;
      paramView2 = a(i3, paramView1.getBottom() + paramInt1, true, this.jdField_c_of_type_AndroidGraphicsRect.left, true);
      if (paramView2.getBottom() > i2)
      {
        i3 = paramView2.getTop();
        i4 = paramView2.getBottom();
        paramInt2 = (paramInt3 - paramInt2) / 2;
        paramInt2 = Math.min(Math.min(i3 - i1, i4 - i2), paramInt2);
        paramView1.offsetTopAndBottom(-paramInt2);
        paramView2.offsetTopAndBottom(-paramInt2);
      }
      if (!this.i)
      {
        b(this.aF - 2, paramView2.getTop() - paramInt1);
        d();
        a(this.aF + 1, paramView2.getBottom() + paramInt1);
        return paramView2;
      }
      a(this.aF + 1, paramView2.getBottom() + paramInt1);
      d();
      b(this.aF - 2, paramView2.getTop() - paramInt1);
      return paramView2;
    }
    if (paramInt1 < 0)
    {
      if (paramView2 != null) {}
      for (paramView1 = a(i3, paramView2.getTop(), true, this.jdField_c_of_type_AndroidGraphicsRect.left, true);; paramView1 = a(i3, paramView1.getTop(), false, this.jdField_c_of_type_AndroidGraphicsRect.left, true))
      {
        if (paramView1.getTop() < i1)
        {
          paramInt1 = paramView1.getTop();
          i4 = paramView1.getBottom();
          paramInt2 = (paramInt3 - paramInt2) / 2;
          paramView1.offsetTopAndBottom(Math.min(Math.min(i1 - paramInt1, i2 - i4), paramInt2));
        }
        a(paramView1, i3);
        return paramView1;
      }
    }
    paramInt1 = paramView1.getTop();
    paramView1 = a(i3, paramInt1, true, this.jdField_c_of_type_AndroidGraphicsRect.left, true);
    if ((paramInt1 < paramInt2) && (paramView1.getBottom() < paramInt2 + 20)) {
      paramView1.offsetTopAndBottom(paramInt2 - paramView1.getTop());
    }
    a(paramView1, i3);
    return paramView1;
  }
  
  private xty a(int paramInt)
  {
    int i2 = 1;
    int i1 = 1;
    View localView = a();
    if ((localView != null) && (localView.hasFocus()))
    {
      localView = localView.findFocus();
      localView = FocusFinder.getInstance().findNextFocus(this, localView, paramInt);
      if (localView == null) {
        break label377;
      }
      i1 = b(localView);
      if ((this.aF != -1) && (i1 != this.aF))
      {
        i2 = a(paramInt);
        if ((i2 != -1) && (((paramInt == 130) && (i2 < i1)) || ((paramInt == 33) && (i2 > i1)))) {
          return null;
        }
      }
    }
    else
    {
      if (paramInt == 130)
      {
        if (this.au > 0)
        {
          label116:
          i2 = this.jdField_c_of_type_AndroidGraphicsRect.top;
          if (i1 == 0) {
            break label196;
          }
        }
        label196:
        for (i1 = a();; i1 = 0)
        {
          i2 = i1 + i2;
          i1 = i2;
          if (localView != null)
          {
            i1 = i2;
            if (localView.getTop() > i2) {
              i1 = localView.getTop();
            }
          }
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, i1, 0, i1);
          localView = FocusFinder.getInstance().findNextFocusFromRect(this, this.jdField_a_of_type_AndroidGraphicsRect, paramInt);
          break;
          i1 = 0;
          break label116;
        }
      }
      if (this.au + getChildCount() - 1 < this.aG)
      {
        i1 = i2;
        label222:
        i2 = getHeight();
        i3 = this.jdField_c_of_type_AndroidGraphicsRect.bottom;
        if (i1 == 0) {
          break label298;
        }
      }
      label298:
      for (i1 = a();; i1 = 0)
      {
        i2 = i2 - i3 - i1;
        i1 = i2;
        if (localView != null)
        {
          i1 = i2;
          if (localView.getBottom() < i2) {
            i1 = localView.getBottom();
          }
        }
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, i1, 0, i1);
        break;
        i1 = 0;
        break label222;
      }
    }
    i2 = a(paramInt, localView, i1);
    int i3 = w();
    if (i2 < i3)
    {
      localView.requestFocus(paramInt);
      this.jdField_a_of_type_Xty.a(i1, i2);
      return this.jdField_a_of_type_Xty;
    }
    if (c(localView) < i3)
    {
      localView.requestFocus(paramInt);
      this.jdField_a_of_type_Xty.a(i1, i3);
      return this.jdField_a_of_type_Xty;
    }
    label377:
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((this.au + paramInt - 1 == this.aG - 1) && (paramInt > 0))
    {
      paramInt = getChildAt(paramInt - 1).getBottom();
      int i1 = getBottom() - this.mTop - this.jdField_c_of_type_AndroidGraphicsRect.bottom - paramInt;
      View localView = getChildAt(0);
      int i2 = localView.getTop();
      if ((i1 > 0) && ((this.au > 0) || (i2 < this.jdField_c_of_type_AndroidGraphicsRect.top)))
      {
        paramInt = i1;
        if (this.au == 0) {
          paramInt = Math.min(i1, this.jdField_c_of_type_AndroidGraphicsRect.top - i2);
        }
        offsetChildrenTopAndBottom(paramInt);
        if (this.au > 0)
        {
          b(this.au - 1, localView.getTop() - this.aL);
          d();
        }
      }
    }
  }
  
  private void a(Rect paramRect)
  {
    try
    {
      Field localField = View.class.getDeclaredField("mPrivateFlags");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(localField.getInt(this) | 0x80000000));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("XListView", 2, localException.getMessage(), localException);
      }
      postInvalidate(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    int i1 = this.aL;
    if (!this.i)
    {
      b(paramInt - 1, paramView.getTop() - i1);
      d();
      a(paramInt + 1, i1 + paramView.getBottom());
      return;
    }
    a(paramInt + 1, paramView.getBottom() + i1);
    d();
    b(paramInt - 1, paramView.getTop() - i1);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
    AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null)
    {
      localLayoutParams1 = new AbsListView.LayoutParams(-1, -2, 0);
      paramView.setLayoutParams(localLayoutParams1);
    }
    localLayoutParams1.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt1);
    localLayoutParams1.jdField_b_of_type_Boolean = true;
    paramInt2 = ViewGroup.getChildMeasureSpec(paramInt2, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right, localLayoutParams1.width);
    paramInt1 = localLayoutParams1.height;
    if (paramInt1 > 0) {}
    for (paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);; paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt2, paramInt1);
      return;
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (paramInt2 == -1) {
      throw new IllegalArgumentException("newSelectedPosition needs to be valid");
    }
    int i1 = this.aF - this.au;
    paramInt2 -= this.au;
    int i2;
    View localView1;
    boolean bool1;
    if (paramInt1 == 33)
    {
      View localView2 = getChildAt(paramInt2);
      paramInt1 = i1;
      i2 = 1;
      localView1 = paramView;
      paramView = localView2;
      i1 = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i2;
      i2 = getChildCount();
      if (paramView != null)
      {
        if ((paramBoolean) || (paramInt1 == 0)) {
          break label154;
        }
        bool1 = true;
        label92:
        paramView.setSelected(bool1);
        b(paramView, i1, i2);
      }
      if (localView1 != null) {
        if ((paramBoolean) || (paramInt1 != 0)) {
          break label160;
        }
      }
    }
    label154:
    label160:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localView1.setSelected(paramBoolean);
      b(localView1, paramInt2, i2);
      return;
      localView1 = getChildAt(paramInt2);
      paramInt1 = 0;
      break;
      bool1 = false;
      break label92;
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {}
    for (int i1 = -1;; i1 = 0)
    {
      a(paramView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, paramBoolean3, i1);
      return;
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    d("ListView.setupChild");
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("XListView", 2, "ListView setupChild view is null");
      }
      setStatisticCollector();
      D();
      return;
    }
    if (paramBoolean2) {}
    try
    {
      if (!o()) {
        break label435;
      }
      paramBoolean2 = true;
    }
    catch (NullPointerException paramView)
    {
      for (;;)
      {
        int i2;
        try
        {
          AbsListView.LayoutParams localLayoutParams;
          paramView.measure(i2, paramInt4);
          D();
          paramInt4 = paramView.getMeasuredWidth();
          i2 = paramView.getMeasuredHeight();
          if (!paramBoolean1) {
            break label642;
          }
          if (i1 == 0) {
            break label609;
          }
          d("ListView.childLayout");
          paramView.layout(paramInt3, paramInt2, paramInt4 + paramInt3, i2 + paramInt2);
          D();
          if ((this.jdField_g_of_type_Boolean) && (!paramView.isDrawingCacheEnabled())) {
            paramView.setDrawingCacheEnabled(true);
          }
          if ((VersionUtils.e()) && (paramBoolean3) && (((AbsListView.LayoutParams)paramView.getLayoutParams()).jdField_b_of_type_Int != paramInt1)) {
            paramView.jumpDrawablesToCurrentState();
          }
          D();
          return;
          paramBoolean2 = false;
          continue;
          i2 = 0;
          continue;
          boolean bool = false;
          continue;
          int i3 = 0;
          continue;
          i1 = 0;
          continue;
          localLayoutParams.jdField_b_of_type_Boolean = false;
          if (localLayoutParams.jdField_a_of_type_Int == -2) {
            localLayoutParams.jdField_a_of_type_Boolean = true;
          }
          addViewInLayout(paramView, paramInt4, localLayoutParams, true);
          continue;
          paramView = paramView;
          setStatisticCollector();
          continue;
          if ((getContext().getApplicationInfo().targetSdkVersion < 11) || (!VersionUtils.e())) {
            continue;
          }
          paramView.setActivated(this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt1));
          continue;
          paramInt4 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("XListView", 2, localStringIndexOutOfBoundsException.getStackTrace());
          continue;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("XListView", 2, localException.getStackTrace());
          continue;
        }
        cleanupLayoutState(paramView);
        continue;
        paramView.offsetLeftAndRight(paramInt3 - paramView.getLeft());
        paramView.offsetTopAndBottom(paramInt2 - paramView.getTop());
        continue;
        continue;
        int i1 = 1;
        continue;
        paramInt2 -= i2;
      }
    }
    if (paramBoolean2 != paramView.isSelected())
    {
      i2 = 1;
      i1 = this.ag;
      if ((i1 <= 0) || (i1 >= 3) || (this.ab != paramInt1)) {
        break label447;
      }
      bool = true;
      if (bool == paramView.isPressed()) {
        break label453;
      }
      i3 = 1;
      if ((!paramBoolean3) || (i2 != 0)) {
        break label636;
      }
      if (!paramView.isLayoutRequested()) {
        break label459;
      }
      break label636;
      localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams != null) {
        break label633;
      }
      localLayoutParams = new AbsListView.LayoutParams(-1, -2, 0);
      localLayoutParams.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt1);
      if (((!paramBoolean3) || (localLayoutParams.jdField_b_of_type_Boolean)) && ((!localLayoutParams.jdField_a_of_type_Boolean) || (localLayoutParams.jdField_a_of_type_Int != -2))) {
        break label465;
      }
      attachViewToParent(paramView, paramInt4, localLayoutParams);
      if (i2 != 0) {
        paramView.setSelected(paramBoolean2);
      }
      if (i3 != 0) {
        paramView.setPressed(bool);
      }
      if ((this.S != 0) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null))
      {
        if (!(paramView instanceof Checkable)) {
          break label509;
        }
        ((Checkable)paramView).setChecked(this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt1));
      }
      if (i1 == 0) {
        break label601;
      }
      i2 = ViewGroup.getChildMeasureSpec(this.aa, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right, localLayoutParams.width);
      paramInt4 = localLayoutParams.height;
      if (paramInt4 <= 0) {
        break label545;
      }
      paramInt4 = View.MeasureSpec.makeMeasureSpec(paramInt4, 1073741824);
      d("ListView.childMeasure");
    }
  }
  
  private void a(View paramView, ArrayList paramArrayList)
  {
    int i2 = paramArrayList.size();
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2)
      {
        if (((ListView.FixedViewInfo)paramArrayList.get(i1)).jdField_a_of_type_AndroidViewView == paramView) {
          paramArrayList.remove(i1);
        }
      }
      else {
        return;
      }
      i1 += 1;
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      int i2 = paramArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)((ListView.FixedViewInfo)paramArrayList.get(i1)).jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.jdField_a_of_type_Boolean = false;
        }
        i1 += 1;
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt != 17) && (paramInt != 66)) {
      throw new IllegalArgumentException("direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
    }
    int i1 = getChildCount();
    if ((this.t) && (i1 > 0) && (this.aF != -1))
    {
      View localView2 = a();
      if ((localView2 != null) && (localView2.hasFocus()) && ((localView2 instanceof ViewGroup)))
      {
        View localView1 = localView2.findFocus();
        localView2 = FocusFinder.getInstance().findNextFocus((ViewGroup)localView2, localView1, paramInt);
        if (localView2 != null)
        {
          localView1.getFocusedRect(this.jdField_a_of_type_AndroidGraphicsRect);
          offsetDescendantRectToMyCoords(localView1, this.jdField_a_of_type_AndroidGraphicsRect);
          offsetRectIntoDescendantCoords(localView2, this.jdField_a_of_type_AndroidGraphicsRect);
          if (localView2.requestFocus(paramInt, this.jdField_a_of_type_AndroidGraphicsRect)) {
            return true;
          }
        }
        localView1 = FocusFinder.getInstance().findNextFocus((ViewGroup)getRootView(), localView1, paramInt);
        if (localView1 != null) {
          return a(localView1, this);
        }
      }
    }
    return false;
  }
  
  private boolean a(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    if (((paramView1 instanceof ViewGroup)) && (a((View)paramView1, paramView2))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramInt1;
    if (paramInt3 > 0) {
      i1 = paramInt1 + paramInt2;
    }
    return i1;
  }
  
  private int b(View paramView)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      if (a(paramView, getChildAt(i1))) {
        return i1 + this.au;
      }
      i1 += 1;
    }
    throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
  }
  
  private View b(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    int i1;
    int i2;
    if ((this.mGroupFlags & 0x22) == 34)
    {
      i1 = this.jdField_c_of_type_AndroidGraphicsRect.top;
      i2 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i2;
    }
    for (;;)
    {
      if ((paramInt1 > i1) && (paramInt2 >= 0))
      {
        boolean bool;
        if (paramInt2 == this.aF)
        {
          bool = true;
          label52:
          View localView = a(paramInt2, paramInt1, false, this.jdField_c_of_type_AndroidGraphicsRect.left, bool);
          if (localView == null) {
            break label114;
          }
          i2 = localView.getTop() - this.aL;
          paramInt1 = i2;
          if (!bool) {
            break label124;
          }
          paramInt1 = i2;
          localObject = localView;
        }
        label114:
        label124:
        for (;;)
        {
          paramInt2 -= 1;
          break;
          bool = false;
          break label52;
          QLog.e("XListView", 1, "fillUp childis null");
        }
      }
      this.au = (paramInt2 + 1);
      return (View)localObject;
      i2 = 0;
      i1 = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i1;
      i1 = i2;
    }
  }
  
  private View b(View paramView, int paramInt)
  {
    paramInt += 1;
    View localView = a(paramInt, this.jdField_a_of_type_ArrayOfBoolean);
    int i1 = paramView.getBottom();
    a(localView, paramInt, this.aL + i1, true, this.jdField_c_of_type_AndroidGraphicsRect.left, false, this.jdField_a_of_type_ArrayOfBoolean[0]);
    return localView;
  }
  
  private void b(View paramView, int paramInt1, int paramInt2)
  {
    int i1 = paramView.getHeight();
    c(paramView);
    if (paramView.getMeasuredHeight() != i1)
    {
      d(paramView);
      int i2 = paramView.getMeasuredHeight();
      paramInt1 += 1;
      while (paramInt1 < paramInt2)
      {
        getChildAt(paramInt1).offsetTopAndBottom(i2 - i1);
        paramInt1 += 1;
      }
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    int i1 = this.mScrollY;
    int i2 = this.jdField_c_of_type_AndroidGraphicsRect.top;
    if ((this.au > 0) || (getChildAt(0).getTop() > i1 + i2)) {
      bool = true;
    }
    return bool;
  }
  
  private boolean b(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    boolean bool3 = true;
    boolean bool2;
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter == null) || (!this.n))
    {
      bool2 = false;
      return bool2;
    }
    if (this.r) {
      v_();
    }
    int i3 = paramKeyEvent.getAction();
    if (i3 != 1) {}
    label144:
    boolean bool1;
    int i1;
    switch (paramInt1)
    {
    default: 
      bool1 = false;
      i1 = paramInt2;
    }
    for (;;)
    {
      bool2 = bool3;
      if (bool1) {
        break;
      }
      bool2 = bool3;
      if (a(paramInt1, i1, paramKeyEvent)) {
        break;
      }
      switch (i3)
      {
      default: 
        return false;
        int i2;
        if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
        {
          bool2 = p();
          bool1 = bool2;
          i1 = paramInt2;
          if (!bool2) {
            for (;;)
            {
              i2 = paramInt2 - 1;
              bool1 = bool2;
              i1 = i2;
              if (paramInt2 <= 0) {
                break;
              }
              bool1 = bool2;
              i1 = i2;
              if (!h(33)) {
                break;
              }
              bool2 = true;
              paramInt2 = i2;
            }
          }
        }
        else
        {
          if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
            break label144;
          }
          if ((p()) || (g(33)))
          {
            bool1 = true;
            i1 = paramInt2;
          }
          else
          {
            bool1 = false;
            i1 = paramInt2;
            continue;
            if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
            {
              bool2 = p();
              bool1 = bool2;
              i1 = paramInt2;
              if (!bool2) {
                for (;;)
                {
                  i2 = paramInt2 - 1;
                  bool1 = bool2;
                  i1 = i2;
                  if (paramInt2 <= 0) {
                    break;
                  }
                  bool1 = bool2;
                  i1 = i2;
                  if (!h(130)) {
                    break;
                  }
                  bool2 = true;
                  paramInt2 = i2;
                }
              }
            }
            else
            {
              if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                break label144;
              }
              if ((p()) || (g(130)))
              {
                bool1 = true;
                i1 = paramInt2;
              }
              else
              {
                bool1 = false;
                i1 = paramInt2;
                continue;
                if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                  break label144;
                }
                bool1 = a(17);
                i1 = paramInt2;
                continue;
                if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                  break label144;
                }
                bool1 = a(66);
                i1 = paramInt2;
                continue;
                if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                  break label144;
                }
                bool2 = p();
                bool1 = bool2;
                i1 = paramInt2;
                if (!bool2)
                {
                  bool1 = bool2;
                  i1 = paramInt2;
                  if (paramKeyEvent.getRepeatCount() == 0)
                  {
                    bool1 = bool2;
                    i1 = paramInt2;
                    if (getChildCount() > 0)
                    {
                      n();
                      bool1 = true;
                      i1 = paramInt2;
                      continue;
                      if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
                        break label144;
                      }
                      if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers())) {
                        if ((p()) || (!f(130))) {}
                      }
                      for (;;)
                      {
                        bool1 = true;
                        i1 = paramInt2;
                        break;
                        if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(1)) || (p()) || (!f(33))) {}
                      }
                      if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
                      {
                        if ((p()) || (f(33)))
                        {
                          bool1 = true;
                          i1 = paramInt2;
                        }
                        else
                        {
                          bool1 = false;
                          i1 = paramInt2;
                        }
                      }
                      else
                      {
                        if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                          break label144;
                        }
                        if ((p()) || (g(33)))
                        {
                          bool1 = true;
                          i1 = paramInt2;
                        }
                        else
                        {
                          bool1 = false;
                          i1 = paramInt2;
                          continue;
                          if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
                          {
                            if ((p()) || (f(130)))
                            {
                              bool1 = true;
                              i1 = paramInt2;
                            }
                            else
                            {
                              bool1 = false;
                              i1 = paramInt2;
                            }
                          }
                          else
                          {
                            if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                              break label144;
                            }
                            if ((p()) || (g(130)))
                            {
                              bool1 = true;
                              i1 = paramInt2;
                            }
                            else
                            {
                              bool1 = false;
                              i1 = paramInt2;
                              continue;
                              if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                                break label144;
                              }
                              if ((p()) || (g(33)))
                              {
                                bool1 = true;
                                i1 = paramInt2;
                              }
                              else
                              {
                                bool1 = false;
                                i1 = paramInt2;
                                continue;
                                if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                                  break label144;
                                }
                                if ((p()) || (g(130)))
                                {
                                  bool1 = true;
                                  i1 = paramInt2;
                                }
                                else
                                {
                                  bool1 = false;
                                  i1 = paramInt2;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return super.onKeyDown(paramInt1, paramKeyEvent);
    return super.onKeyUp(paramInt1, paramKeyEvent);
    return super.onKeyMultiple(paramInt1, i1, paramKeyEvent);
  }
  
  private int c(View paramView)
  {
    int i1 = 0;
    paramView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    offsetDescendantRectToMyCoords(paramView, this.jdField_a_of_type_AndroidGraphicsRect);
    int i2 = this.mBottom - this.mTop - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
    if (this.jdField_a_of_type_AndroidGraphicsRect.bottom < this.jdField_c_of_type_AndroidGraphicsRect.top) {
      i1 = this.jdField_c_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    }
    while (this.jdField_a_of_type_AndroidGraphicsRect.top <= i2) {
      return i1;
    }
    return this.jdField_a_of_type_AndroidGraphicsRect.top - i2;
  }
  
  private View c(int paramInt1, int paramInt2)
  {
    paramInt2 -= paramInt1;
    int i1 = o();
    View localView = a(i1, paramInt1, true, this.jdField_c_of_type_AndroidGraphicsRect.left, true);
    this.au = i1;
    paramInt1 = localView.getMeasuredHeight();
    if (paramInt1 <= paramInt2) {
      localView.offsetTopAndBottom((paramInt2 - paramInt1) / 2);
    }
    a(localView, i1);
    if (!this.i)
    {
      a(getChildCount());
      return localView;
    }
    c(getChildCount());
    return localView;
  }
  
  private void c()
  {
    if ((this.i) && (this.au == 0) && (getChildCount() > 0))
    {
      int i1 = getChildAt(0).getTop() - this.jdField_c_of_type_AndroidGraphicsRect.top;
      if (i1 > 0) {
        offsetChildrenTopAndBottom(-i1);
      }
    }
  }
  
  private void c(int paramInt)
  {
    int i4;
    if ((this.au == 0) && (paramInt > 0))
    {
      int i1 = getChildAt(0).getTop();
      int i3 = this.jdField_c_of_type_AndroidGraphicsRect.top;
      int i2 = getBottom() - this.mTop - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
      i1 -= i3;
      View localView = getChildAt(paramInt - 1);
      i3 = localView.getBottom();
      i4 = this.au + paramInt - 1;
      if (i1 > 0)
      {
        if ((i4 >= this.aG - 1) && (i3 <= i2)) {
          break label162;
        }
        paramInt = i1;
        if (i4 == this.aG - 1) {
          paramInt = Math.min(i1, i3 - i2);
        }
        offsetChildrenTopAndBottom(-paramInt);
        if (i4 < this.aG - 1)
        {
          a(i4 + 1, localView.getBottom() + this.aL);
          d();
        }
      }
    }
    label162:
    while (i4 != this.aG - 1) {
      return;
    }
    d();
  }
  
  private void c(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    int i2 = ViewGroup.getChildMeasureSpec(this.aa, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right, localLayoutParams1.width);
    int i1 = localLayoutParams1.height;
    if (i1 > 0) {}
    for (i1 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);; i1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(i2, i1);
      return;
    }
  }
  
  private boolean c(View paramView)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i2 = localArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramView == ((ListView.FixedViewInfo)localArrayList.get(i1)).jdField_a_of_type_AndroidViewView) {
        return true;
      }
      i1 += 1;
    }
    localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    i2 = localArrayList.size();
    i1 = 0;
    while (i1 < i2)
    {
      if (paramView == ((ListView.FixedViewInfo)localArrayList.get(i1)).jdField_a_of_type_AndroidViewView) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private View d(int paramInt1, int paramInt2)
  {
    boolean bool;
    View localView5;
    View localView3;
    View localView4;
    View localView1;
    View localView2;
    if (paramInt1 == this.aF)
    {
      bool = true;
      localView5 = a(paramInt1, paramInt2, false, this.jdField_c_of_type_AndroidGraphicsRect.left, bool);
      this.au = paramInt1;
      paramInt2 = this.aL;
      if (this.i) {
        break label124;
      }
      localView3 = b(paramInt1 - 1, localView5.getTop() - paramInt2);
      d();
      localView4 = a(paramInt1 + 1, paramInt2 + localView5.getBottom());
      paramInt1 = getChildCount();
      localView1 = localView3;
      localView2 = localView4;
      if (paramInt1 > 0)
      {
        a(paramInt1);
        localView2 = localView4;
        localView1 = localView3;
      }
    }
    for (;;)
    {
      if (!bool) {
        break label191;
      }
      return localView5;
      bool = false;
      break;
      label124:
      localView3 = a(paramInt1 + 1, localView5.getBottom() + paramInt2);
      d();
      localView4 = b(paramInt1 - 1, localView5.getTop() - paramInt2);
      paramInt1 = getChildCount();
      localView1 = localView4;
      localView2 = localView3;
      if (paramInt1 > 0)
      {
        c(paramInt1);
        localView1 = localView4;
        localView2 = localView3;
      }
    }
    label191:
    if (localView1 != null) {
      return localView1;
    }
    return localView2;
  }
  
  private void d()
  {
    int i3 = 0;
    int i4 = getChildCount();
    int i2;
    int i1;
    if (i4 > 0)
    {
      if (this.i) {
        break label72;
      }
      i2 = getChildAt(0).getTop() - this.jdField_c_of_type_AndroidGraphicsRect.top;
      i1 = i2;
      if (this.au != 0) {
        i1 = i2 - this.aL;
      }
      i2 = i1;
      if (i1 >= 0) {
        break label128;
      }
      i2 = i3;
    }
    label72:
    label128:
    for (;;)
    {
      if (i2 != 0) {
        offsetChildrenTopAndBottom(-i2);
      }
      return;
      i2 = getChildAt(i4 - 1).getBottom() - (getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom);
      i1 = i2;
      if (i4 + this.au < this.aG) {
        i1 = i2 + this.aL;
      }
      i2 = i3;
      if (i1 <= 0) {
        i2 = i1;
      }
    }
  }
  
  private void d(View paramView)
  {
    int i1 = paramView.getMeasuredWidth();
    int i2 = paramView.getMeasuredHeight();
    int i3 = this.jdField_c_of_type_AndroidGraphicsRect.left;
    int i4 = paramView.getTop();
    paramView.layout(i3, i4, i1 + i3, i2 + i4);
  }
  
  private boolean d(int paramInt)
  {
    if (getChildCount() <= 0) {
      return false;
    }
    View localView1 = a();
    int i4 = this.aF;
    int i1 = a(paramInt);
    int i2 = a(paramInt, i1);
    Object localObject;
    int i3;
    label72:
    boolean bool;
    if (this.t)
    {
      localObject = a(paramInt);
      if (localObject != null)
      {
        i1 = ((xty)localObject).a();
        i2 = ((xty)localObject).b();
      }
      if (localObject == null) {
        break label298;
      }
      i3 = 1;
      if (i1 == -1) {
        break label321;
      }
      if (localObject == null) {
        break label304;
      }
      bool = true;
      label85:
      a(localView1, paramInt, i1, bool);
      h(i1);
      i(i1);
      localView1 = a();
      if ((this.t) && (localObject == null))
      {
        View localView2 = getFocusedChild();
        if (localView2 != null) {
          localView2.clearFocus();
        }
      }
      A();
      i3 = 1;
      i4 = i1;
    }
    label161:
    label298:
    label304:
    label318:
    label319:
    label321:
    for (;;)
    {
      if (i2 > 0)
      {
        if (paramInt == 33)
        {
          j(i2);
          i3 = 1;
        }
      }
      else
      {
        if ((this.t) && (localObject == null) && (localView1 != null) && (localView1.hasFocus()))
        {
          localObject = localView1.findFocus();
          if ((localObject != null) && ((!a((View)localObject, this)) || (c((View)localObject) > 0))) {
            ((View)localObject).clearFocus();
          }
        }
        if ((i1 != -1) || (localView1 == null) || (a(localView1, this))) {
          break label318;
        }
        p();
        this.ak = -1;
        localView1 = null;
      }
      for (;;)
      {
        if (i3 == 0) {
          break label319;
        }
        if (localView1 != null)
        {
          a(i4, localView1);
          this.aj = localView1.getTop();
        }
        if (!awakenScrollBars()) {
          invalidate();
        }
        j();
        return true;
        localObject = null;
        break;
        i3 = 0;
        break label72;
        bool = false;
        break label85;
        i2 = -i2;
        break label161;
      }
      break;
    }
  }
  
  private View e(int paramInt1, int paramInt2)
  {
    boolean bool;
    View localView5;
    View localView3;
    View localView4;
    View localView1;
    View localView2;
    if (paramInt1 == this.aF)
    {
      bool = true;
      localView5 = a(paramInt1, paramInt2, true, this.jdField_c_of_type_AndroidGraphicsRect.left, bool);
      this.au = paramInt1;
      paramInt2 = this.aL;
      if (this.i) {
        break label124;
      }
      localView3 = b(paramInt1 - 1, localView5.getTop() - paramInt2);
      d();
      localView4 = a(paramInt1 + 1, paramInt2 + localView5.getBottom());
      paramInt1 = getChildCount();
      localView1 = localView3;
      localView2 = localView4;
      if (paramInt1 > 0)
      {
        a(paramInt1);
        localView2 = localView4;
        localView1 = localView3;
      }
    }
    for (;;)
    {
      if (!bool) {
        break label191;
      }
      return localView5;
      bool = false;
      break;
      label124:
      localView3 = a(paramInt1 + 1, localView5.getBottom() + paramInt2);
      d();
      localView4 = b(paramInt1 - 1, localView5.getTop() - paramInt2);
      paramInt1 = getChildCount();
      localView1 = localView4;
      localView2 = localView3;
      if (paramInt1 > 0)
      {
        c(paramInt1);
        localView1 = localView4;
        localView2 = localView3;
      }
    }
    label191:
    if (localView1 != null) {
      return localView1;
    }
    return localView2;
  }
  
  private void e()
  {
    int i1;
    if ((this.ag == 5) && (getScrollY() != 0))
    {
      i1 = getScrollY();
      if ((i1 >= 0) || (this.jdField_a_of_type_Xub == null) || (i1 <= -d()) || ((this.m != 0) && (this.m != 2))) {
        break label87;
      }
      if (this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener != null) {
        this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.a(0, this.jdField_a_of_type_Xub.getChildAt(0), this);
      }
      this.m = 1;
    }
    label87:
    while ((i1 <= 0) || (this.jdField_b_of_type_Xub == null) || (i1 >= v()) || ((this.m != 0) && (this.m != 2))) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener != null) {
      this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.a(1, this.jdField_b_of_type_Xub.getChildAt(0), this);
    }
    this.m = 1;
  }
  
  private void e(View paramView)
  {
    int i1 = getScrollY();
    paramView.getHeight();
    if (paramView == this.jdField_a_of_type_Xub) {
      if ((this.m == 1) && (i1 <= -d()))
      {
        this.m = 2;
        if (this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener != null) {
          this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.b(0, this.jdField_a_of_type_Xub.getChildAt(0), this);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramView != this.jdField_b_of_type_Xub) || (this.m != 1) || (i1 < v()));
      this.m = 2;
    } while (this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener == null);
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.b(1, this.jdField_b_of_type_Xub.getChildAt(0), this);
  }
  
  private void f(View paramView)
  {
    try
    {
      Object localObject = View.class.getDeclaredField("mAttachInfo");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      if (localObject != null)
      {
        Method localMethod = View.class.getDeclaredMethod("dispatchAttachedToWindow", new Class[] { localObject.getClass(), Integer.TYPE });
        localMethod.setAccessible(true);
        localMethod.invoke(paramView, new Object[] { localObject, Integer.valueOf(getVisibility()) });
      }
      return;
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("XListView", 2, paramView.getMessage(), paramView);
    }
  }
  
  private void g(View paramView)
  {
    try
    {
      Object localObject = View.class.getDeclaredField("mAttachInfo");
      ((Field)localObject).setAccessible(true);
      if (((Field)localObject).get(paramView) != null)
      {
        localObject = View.class.getDeclaredMethod("dispatchDetachedFromWindow", new Class[0]);
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(paramView, new Object[0]);
      }
      return;
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("XListView", 2, paramView.getMessage(), paramView);
    }
  }
  
  private void j(int paramInt)
  {
    offsetChildrenTopAndBottom(paramInt);
    int i1 = getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
    int i2 = this.jdField_c_of_type_AndroidGraphicsRect.top;
    xsa localxsa = this.jdField_a_of_type_Xsa;
    View localView;
    if (paramInt < 0)
    {
      paramInt = getChildCount();
      localView = getChildAt(paramInt - 1);
      while (localView.getBottom() < i1)
      {
        int i3 = this.au + paramInt - 1;
        if (i3 >= this.aG - 1) {
          break;
        }
        localView = b(localView, i3);
        paramInt += 1;
      }
      if (localView.getBottom() < i1) {
        offsetChildrenTopAndBottom(i1 - localView.getBottom());
      }
      localView = getChildAt(0);
      if (localView.getBottom() < i2)
      {
        if (localxsa.a(((AbsListView.LayoutParams)localView.getLayoutParams()).jdField_a_of_type_Int))
        {
          detachViewFromParent(localView);
          localxsa.a(localView, this.au);
        }
        for (;;)
        {
          localView = getChildAt(0);
          this.au += 1;
          break;
          removeViewInLayout(localView);
        }
      }
    }
    else
    {
      localView = getChildAt(0);
      while ((localView.getTop() > i2) && (this.au > 0))
      {
        localView = a(localView, this.au);
        this.au -= 1;
      }
      if (localView.getTop() > i2) {
        offsetChildrenTopAndBottom(i2 - localView.getTop());
      }
      paramInt = getChildCount() - 1;
      localView = getChildAt(paramInt);
      if (localView.getTop() > i1)
      {
        if (localxsa.a(((AbsListView.LayoutParams)localView.getLayoutParams()).jdField_a_of_type_Int))
        {
          detachViewFromParent(localView);
          localxsa.a(localView, this.au + paramInt);
        }
        for (;;)
        {
          paramInt -= 1;
          localView = getChildAt(paramInt);
          break;
          removeViewInLayout(localView);
        }
      }
    }
  }
  
  private boolean t()
  {
    int i1 = getChildCount();
    int i2 = getChildAt(i1 - 1).getBottom();
    int i3 = this.au;
    int i4 = getScrollY();
    int i5 = getHeight();
    int i6 = this.jdField_c_of_type_AndroidGraphicsRect.bottom;
    return (i1 + i3 - 1 < this.aG - 1) || (i2 < i4 + i5 - i6);
  }
  
  public void H()
  {
    I();
  }
  
  public void I()
  {
    if ((getScrollY() != 0) && (!this.v)) {
      x();
    }
    this.m = 0;
  }
  
  public void J()
  {
    if (this.mScrollY < 0)
    {
      y();
      if (!this.i)
      {
        setSelectionFromTop(this.au, this.jdField_c_of_type_AndroidGraphicsRect.top - this.mScrollY);
        onScrollChanged(0, 0, 0, this.mScrollY);
        this.mScrollY = 0;
      }
    }
    else
    {
      this.m = 0;
      return;
    }
    this.U = 100;
    View localView = getChildAt(0);
    if (localView == null) {}
    for (int i1 = 0;; i1 = this.az - localView.getBottom() - this.jdField_c_of_type_AndroidGraphicsRect.bottom)
    {
      setSelectionFromBottom(this.au, i1 + this.mScrollY);
      break;
    }
  }
  
  public void K()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (localView.getAnimation() != null) {
        localView.clearAnimation();
      }
      i1 += 1;
    }
  }
  
  public void L()
  {
    scrollTo(0, -d() - 1);
    if ((this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener != null) && (this.jdField_a_of_type_Xub != null))
    {
      if (!this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.a(0, this.jdField_a_of_type_Xub.getChildAt(0), this)) {
        I();
      }
    }
    else {
      return;
    }
    this.m = 3;
  }
  
  public void M()
  {
    scrollTo(0, v() + 1);
    if ((this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener != null) && (this.jdField_b_of_type_Xub != null))
    {
      if (!this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.a(1, this.jdField_b_of_type_Xub.getChildAt(0), this)) {
        I();
      }
    }
    else {
      return;
    }
    this.m = 3;
  }
  
  final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i3 = 0;
    Object localObject = this.jdField_a_of_type_AndroidWidgetListAdapter;
    if (localObject == null)
    {
      paramInt1 = this.jdField_c_of_type_AndroidGraphicsRect.top + this.jdField_c_of_type_AndroidGraphicsRect.bottom;
      return paramInt1;
    }
    int i4 = this.jdField_c_of_type_AndroidGraphicsRect.top + this.jdField_c_of_type_AndroidGraphicsRect.bottom;
    int i1;
    label69:
    boolean bool;
    label111:
    View localView;
    if ((this.aL > 0) && (this.jdField_d_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      i1 = this.aL;
      int i2 = paramInt3;
      if (paramInt3 == -1) {
        i2 = ((ListAdapter)localObject).getCount() - 1;
      }
      localObject = this.jdField_a_of_type_Xsa;
      bool = d();
      boolean[] arrayOfBoolean = this.jdField_a_of_type_ArrayOfBoolean;
      paramInt3 = paramInt2;
      paramInt2 = i4;
      if (paramInt3 > i2) {
        break label265;
      }
      localView = a(paramInt3, arrayOfBoolean);
      a(localView, paramInt3, paramInt1);
      if (paramInt3 <= 0) {
        break label267;
      }
      paramInt2 += i1;
    }
    label265:
    label267:
    for (;;)
    {
      if ((bool) && (((xsa)localObject).a(((AbsListView.LayoutParams)localView.getLayoutParams()).jdField_a_of_type_Int))) {
        ((xsa)localObject).a(localView, -1);
      }
      paramInt2 = localView.getMeasuredHeight() + paramInt2;
      if (paramInt2 >= paramInt4)
      {
        paramInt1 = paramInt4;
        if (paramInt5 < 0) {
          break;
        }
        paramInt1 = paramInt4;
        if (paramInt3 <= paramInt5) {
          break;
        }
        paramInt1 = paramInt4;
        if (i3 <= 0) {
          break;
        }
        paramInt1 = paramInt4;
        if (paramInt2 == paramInt4) {
          break;
        }
        return i3;
        i1 = 0;
        break label69;
      }
      i4 = i3;
      if (paramInt5 >= 0)
      {
        i4 = i3;
        if (paramInt3 >= paramInt5) {
          i4 = paramInt2;
        }
      }
      paramInt3 += 1;
      i3 = i4;
      break label111;
      return paramInt2;
    }
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    ListAdapter localListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
    int i1;
    if ((localListAdapter == null) || (isInTouchMode())) {
      i1 = -1;
    }
    int i2;
    label137:
    do
    {
      do
      {
        return i1;
        i2 = localListAdapter.getCount();
        if (this.jdField_e_of_type_Boolean) {
          break label137;
        }
        if (paramBoolean)
        {
          i1 = Math.max(0, paramInt);
          for (;;)
          {
            paramInt = i1;
            if (i1 >= i2) {
              break;
            }
            paramInt = i1;
            if (localListAdapter.isEnabled(i1)) {
              break;
            }
            i1 += 1;
          }
        }
        i1 = Math.min(paramInt, i2 - 1);
        for (;;)
        {
          paramInt = i1;
          if (i1 < 0) {
            break;
          }
          paramInt = i1;
          if (localListAdapter.isEnabled(i1)) {
            break;
          }
          i1 -= 1;
        }
        if (paramInt < 0) {
          break;
        }
        i1 = paramInt;
      } while (paramInt < i2);
      return -1;
      if (paramInt < 0) {
        break;
      }
      i1 = paramInt;
    } while (paramInt < i2);
    return -1;
  }
  
  public ListAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter;
  }
  
  protected xrq a()
  {
    return new xua(this);
  }
  
  void a(Canvas paramCanvas, Rect paramRect, int paramInt)
  {
    Drawable localDrawable = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
    localDrawable.setBounds(paramRect);
    localDrawable.draw(paramCanvas);
  }
  
  void a(Canvas paramCanvas, View paramView, Drawable paramDrawable, Rect paramRect)
  {
    paramCanvas.save();
    if (paramDrawable != null)
    {
      int i1 = paramDrawable.getMinimumHeight();
      paramCanvas.clipRect(paramRect);
      if (paramRect.bottom - paramRect.top < i1) {
        paramRect.bottom = (i1 + paramRect.top);
      }
      paramDrawable.setBounds(paramRect);
      paramDrawable.draw(paramCanvas);
    }
    if (paramView != null)
    {
      e(paramView);
      paramView.offsetTopAndBottom(paramRect.top - paramView.getTop());
      drawChild(paramCanvas, paramView, getDrawingTime());
    }
    paramCanvas.restore();
  }
  
  void a(Canvas paramCanvas, View paramView, Drawable paramDrawable1, Drawable paramDrawable2, Rect paramRect)
  {
    int i1 = paramCanvas.save();
    int i2;
    if (paramDrawable1 != null)
    {
      i2 = paramDrawable1.getIntrinsicHeight();
      if (i2 >= paramRect.height()) {
        break label162;
      }
      Rect localRect = new Rect(paramRect);
      localRect.top = (localRect.top + paramRect.height() - i2);
      paramDrawable1.setBounds(localRect);
    }
    for (;;)
    {
      paramDrawable1.draw(paramCanvas);
      if (paramDrawable2 != null)
      {
        i2 = paramDrawable2.getMinimumHeight();
        if (paramRect.bottom - paramRect.top < i2) {
          paramRect.top = (paramRect.bottom - i2);
        }
        paramDrawable2.setBounds(paramRect);
        paramDrawable2.draw(paramCanvas);
      }
      if (paramView != null)
      {
        e(paramView);
        paramView.offsetTopAndBottom(paramRect.bottom - paramView.getBottom());
        drawChild(paramCanvas, paramView, getDrawingTime());
      }
      paramCanvas.restoreToCount(i1);
      return;
      label162:
      paramDrawable1.setBounds(paramRect);
    }
  }
  
  public void a(View paramView)
  {
    a(paramView, null, true);
  }
  
  public void a(View paramView, Object paramObject, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (!(this.jdField_a_of_type_AndroidWidgetListAdapter instanceof HeaderViewListAdapter))) {
      throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
    }
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.jdField_a_of_type_AndroidViewView = paramView;
    localFixedViewInfo.jdField_a_of_type_JavaLangObject = paramObject;
    localFixedViewInfo.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilArrayList.add(localFixedViewInfo);
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_Xrq != null)) {
      this.jdField_a_of_type_Xrq.onChanged();
    }
  }
  
  public boolean a(View paramView)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      if ((this.jdField_a_of_type_AndroidWidgetListAdapter == null) || (!((HeaderViewListAdapter)this.jdField_a_of_type_AndroidWidgetListAdapter).a(paramView))) {
        break label60;
      }
      if (this.jdField_a_of_type_Xrq != null) {
        this.jdField_a_of_type_Xrq.onChanged();
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      a(paramView, this.jdField_a_of_type_JavaUtilArrayList);
      return bool;
      return false;
    }
  }
  
  public Drawable b()
  {
    return this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void b(View paramView)
  {
    b(paramView, null, true);
  }
  
  public void b(View paramView, Object paramObject, boolean paramBoolean)
  {
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.jdField_a_of_type_AndroidViewView = paramView;
    localFixedViewInfo.jdField_a_of_type_JavaLangObject = paramObject;
    localFixedViewInfo.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaUtilArrayList.add(localFixedViewInfo);
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_Xrq != null)) {
      this.jdField_a_of_type_Xrq.onChanged();
    }
  }
  
  public boolean b(View paramView)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      if ((this.jdField_a_of_type_AndroidWidgetListAdapter == null) || (!((HeaderViewListAdapter)this.jdField_a_of_type_AndroidWidgetListAdapter).b(paramView))) {
        break label60;
      }
      if (this.jdField_a_of_type_Xrq != null) {
        this.jdField_a_of_type_Xrq.onChanged();
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      a(paramView, this.jdField_b_of_type_JavaUtilArrayList);
      return bool;
      return false;
    }
  }
  
  @Deprecated
  public long[] b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds())) {
      return a();
    }
    Object localObject;
    int i4;
    long[] arrayOfLong;
    int i2;
    int i1;
    if ((this.S != 0) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null))
    {
      localObject = this.jdField_a_of_type_AndroidUtilSparseBooleanArray;
      i4 = ((SparseBooleanArray)localObject).size();
      arrayOfLong = new long[i4];
      ListAdapter localListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
      i2 = 0;
      i1 = 0;
      if (i2 < i4)
      {
        if (!((SparseBooleanArray)localObject).valueAt(i2)) {
          break label152;
        }
        int i3 = i1 + 1;
        arrayOfLong[i1] = localListAdapter.getItemId(((SparseBooleanArray)localObject).keyAt(i2));
        i1 = i3;
      }
    }
    label152:
    for (;;)
    {
      i2 += 1;
      break;
      if (i1 == i4) {
        return arrayOfLong;
      }
      localObject = new long[i1];
      System.arraycopy(arrayOfLong, 0, localObject, 0, i1);
      return (long[])localObject;
      return new long[0];
    }
  }
  
  int c(int paramInt)
  {
    int i2 = getChildCount();
    if (i2 > 0)
    {
      if (!this.i)
      {
        i1 = 0;
        while (i1 < i2)
        {
          if (paramInt <= getChildAt(i1).getBottom()) {
            return i1 + this.au;
          }
          i1 += 1;
        }
      }
      int i1 = i2 - 1;
      while (i1 >= 0)
      {
        if (paramInt >= getChildAt(i1).getTop()) {
          return i1 + this.au;
        }
        i1 -= 1;
      }
    }
    return -1;
  }
  
  public Drawable c()
  {
    return this.jdField_e_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public View c()
  {
    return this.jdField_a_of_type_Xub;
  }
  
  public boolean c()
  {
    return (this.mScrollY < 0) && (this.jdField_a_of_type_Xub != null);
  }
  
  protected boolean canAnimate()
  {
    return (super.canAnimate()) && (this.aG > 0);
  }
  
  public int d()
  {
    if ((this.aM == 0) && (this.jdField_a_of_type_Xub != null)) {
      return this.jdField_a_of_type_Xub.getHeight();
    }
    return this.aM;
  }
  
  public long d()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      return this.jdField_a_of_type_Long;
    }
    return 350L;
  }
  
  public Drawable d()
  {
    return this.jdField_f_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public View d()
  {
    return this.jdField_b_of_type_Xub;
  }
  
  public void d(boolean paramBoolean)
  {
    int i2 = getChildCount();
    if (paramBoolean) {
      if ((this.mGroupFlags & 0x22) != 34) {
        break label138;
      }
    }
    label138:
    for (int i1 = h();; i1 = 0)
    {
      if (i2 > 0) {
        i1 = getChildAt(i2 - 1).getBottom() + this.aL;
      }
      a(this.au + i2, i1);
      a(getChildCount());
      return;
      if ((this.mGroupFlags & 0x22) == 34) {}
      for (i1 = i();; i1 = 0)
      {
        if (i2 > 0) {}
        for (i1 = getChildAt(0).getTop() - this.aL;; i1 = getHeight() - i1)
        {
          b(this.au - 1, i1);
          c(getChildCount());
          return;
        }
      }
    }
  }
  
  @ViewDebug.ExportedProperty(category="list")
  protected boolean d()
  {
    return true;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_g_of_type_Boolean) {
      this.h = true;
    }
    int i6 = this.aL;
    Drawable localDrawable1 = this.jdField_e_of_type_AndroidGraphicsDrawableDrawable;
    xub localxub1 = this.jdField_a_of_type_Xub;
    xub localxub2 = this.jdField_b_of_type_Xub;
    Drawable localDrawable2 = this.jdField_f_of_type_AndroidGraphicsDrawableDrawable;
    Drawable localDrawable3 = this.jdField_g_of_type_AndroidGraphicsDrawableDrawable;
    int i4;
    int i3;
    label75:
    int i5;
    label90:
    Rect localRect;
    int i7;
    int i2;
    int i8;
    Object localObject;
    label240:
    label248:
    int i9;
    boolean bool1;
    label421:
    Paint localPaint;
    int i15;
    if ((localDrawable1 != null) || (localxub1 != null) || (localDrawable3 != null))
    {
      i4 = 1;
      if ((localDrawable2 == null) && (localxub2 == null)) {
        break label765;
      }
      i3 = 1;
      if ((i6 <= 0) || (this.jdField_d_of_type_AndroidGraphicsDrawableDrawable == null)) {
        break label771;
      }
      i5 = 1;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect.top = 0;
        localRect.bottom = getHeight();
        localRect.left = 0;
        localRect.right = getWidth();
        i7 = paramCanvas.save();
        if (this.mScrollY > 0)
        {
          localRect.top += this.mScrollY;
          localRect.bottom += this.mScrollY;
        }
        if (this.u)
        {
          i2 = 0;
          i8 = getChildCount();
          i1 = i2;
          if (i8 > 0)
          {
            localObject = getChildAt(i8 - 1);
            i1 = i2;
            if (localObject != null)
            {
              if (t() != d_() - 1) {
                break label777;
              }
              i1 = ((View)localObject).getTop();
            }
          }
          if (i1 >= 0) {
            break label787;
          }
          i2 = 0;
          paramCanvas.clipRect(0, i2, localRect.right, localRect.bottom);
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        paramCanvas.restoreToCount(i7);
      }
      if ((i5 == 0) && (i4 == 0) && (i3 == 0)) {
        break label929;
      }
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      localRect.left = this.mPaddingLeft;
      localRect.right = (this.mRight - this.mLeft - this.mPaddingRight);
      i7 = getChildCount();
      int i10 = this.jdField_a_of_type_JavaUtilArrayList.size();
      i8 = this.aG;
      int i11 = this.jdField_b_of_type_JavaUtilArrayList.size();
      boolean bool2 = this.jdField_c_of_type_Boolean;
      boolean bool3 = this.jdField_d_of_type_Boolean;
      i9 = this.au;
      boolean bool4 = this.jdField_e_of_type_Boolean;
      localObject = this.jdField_a_of_type_AndroidWidgetListAdapter;
      if (!VersionUtils.a()) {
        break label817;
      }
      if ((!isOpaque()) || (super.isOpaque())) {
        break label811;
      }
      bool1 = true;
      if ((bool1) && (this.jdField_a_of_type_AndroidGraphicsPaint == null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(q());
      }
      localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      i1 = 0;
      if ((this.mGroupFlags & 0x22) == 34) {
        i1 = this.jdField_c_of_type_AndroidGraphicsRect.bottom;
      }
      int i12 = this.mBottom;
      int i13 = this.mTop;
      int i14 = getScrollY();
      i15 = getScrollY();
      if ((i7 > 0) && (i15 < 0))
      {
        if (i4 != 0)
        {
          localRect.bottom = (0 - this.aL);
          localRect.top = i15;
          a(paramCanvas, localxub1, localDrawable3, localDrawable1, localRect);
        }
        if (i5 != 0)
        {
          localRect.bottom = 0;
          localRect.top = (-i6);
          a(paramCanvas, localRect, -1);
        }
      }
      if (i5 == 0) {
        break label859;
      }
      i2 = 0;
      label595:
      if (i2 >= i7) {
        break label859;
      }
      if (((bool2) || (i9 + i2 >= i10)) && ((bool3) || (i9 + i2 < i8 - i11 - 1)))
      {
        i4 = getChildAt(i2).getBottom();
        if ((i4 < i14 + (i12 - i13 - i1)) && ((i3 == 0) || (i2 != i7 - 1)))
        {
          if ((!bool4) && ((!((ListAdapter)localObject).isEnabled(i9 + i2)) || ((i2 != i7 - 1) && (!((ListAdapter)localObject).isEnabled(i9 + i2 + 1))))) {
            break label826;
          }
          localRect.top = i4;
          localRect.bottom = (i4 + i6);
          a(paramCanvas, localRect, i2);
        }
      }
    }
    for (;;)
    {
      i2 += 1;
      break label595;
      i4 = 0;
      break;
      label765:
      i3 = 0;
      break label75;
      label771:
      i5 = 0;
      break label90;
      label777:
      i1 = ((View)localObject).getBottom();
      break label240;
      label787:
      i2 = i1;
      if (i1 <= localRect.bottom) {
        break label248;
      }
      i2 = localRect.bottom;
      break label248;
      label811:
      bool1 = false;
      break label421;
      label817:
      bool1 = isOpaque();
      break label421;
      label826:
      if (bool1)
      {
        localRect.top = i4;
        localRect.bottom = (i4 + i6);
        paramCanvas.drawRect(localRect, localPaint);
      }
    }
    label859:
    int i1 = this.mBottom + i15 + this.aL;
    if ((i3 != 0) && (i9 + i7 == i8) && (i1 > this.mBottom))
    {
      localRect.top = (this.mBottom + this.aL);
      localRect.bottom = i1;
      a(paramCanvas, localxub2, localDrawable2, localRect);
    }
    label929:
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = super.dispatchKeyEvent(paramKeyEvent);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (getFocusedChild() != null)
      {
        bool1 = bool2;
        if (paramKeyEvent.getAction() == 0) {
          bool1 = onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent);
        }
      }
    }
    return bool1;
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    if (this.h) {
      this.h = false;
    }
    return bool;
  }
  
  public void e(int paramInt)
  {
    super.e(paramInt);
  }
  
  public boolean e()
  {
    return this.t;
  }
  
  public void f(int paramInt)
  {
    super.f(paramInt);
  }
  
  public boolean f()
  {
    return (this.mScrollY > 0) && (this.jdField_b_of_type_Xub != null);
  }
  
  boolean f(int paramInt)
  {
    boolean bool;
    if (paramInt == 33)
    {
      paramInt = Math.max(0, this.aF - getChildCount() - 1);
      bool = false;
    }
    for (;;)
    {
      if (paramInt >= 0)
      {
        paramInt = a(paramInt, bool);
        if (paramInt >= 0)
        {
          this.U = 4;
          this.av = (this.mPaddingTop + getVerticalFadingEdgeLength());
          if ((bool) && (paramInt > this.aG - getChildCount())) {
            this.U = 3;
          }
          if ((!bool) && (paramInt < getChildCount())) {
            this.U = 1;
          }
          g(paramInt);
          j();
          if (!awakenScrollBars()) {
            invalidate();
          }
          return true;
          if (paramInt != 130) {
            break label153;
          }
          paramInt = Math.min(this.aG - 1, this.aF + getChildCount() - 1);
          bool = true;
          continue;
        }
      }
      return false;
      label153:
      paramInt = -1;
      bool = false;
    }
  }
  
  void g(int paramInt)
  {
    int i1 = 1;
    i(paramInt);
    int i2 = this.aF;
    if (i2 >= 0) {
      if (paramInt != i2 - 1) {}
    }
    for (;;)
    {
      v_();
      if (i1 != 0) {
        awakenScrollBars();
      }
      return;
      if (paramInt != i2 + 1) {
        i1 = 0;
      }
    }
  }
  
  boolean g(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 33)
    {
      if (this.aF == 0) {
        break label123;
      }
      paramInt = a(0, true);
      bool1 = bool2;
      if (paramInt >= 0)
      {
        this.U = 1;
        g(paramInt);
        j();
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if ((bool1) && (!awakenScrollBars()))
      {
        awakenScrollBars();
        invalidate();
      }
      return bool1;
      if ((paramInt == 130) && (this.aF < this.aG - 1))
      {
        paramInt = a(this.aG - 1, true);
        bool1 = bool2;
        if (paramInt >= 0)
        {
          this.U = 3;
          g(paramInt);
          j();
          bool1 = bool2;
        }
      }
      else
      {
        label123:
        bool1 = false;
      }
    }
  }
  
  boolean h(int paramInt)
  {
    try
    {
      this.q = true;
      boolean bool = d(paramInt);
      if (bool) {
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
      }
      return bool;
    }
    finally
    {
      this.q = false;
    }
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    paramArrayOfInt = super.invalidateChildInParent(paramArrayOfInt, paramRect);
    int i1;
    if ((paramRect.bottom > 0) && (paramRect.top < getHeight()))
    {
      i1 = getScrollY();
      if ((i1 >= 0) || (paramRect.top + i1 >= 0)) {
        break label50;
      }
      a(paramRect);
    }
    label50:
    while ((i1 <= 0) || (paramRect.bottom <= getHeight() - i1)) {
      return paramArrayOfInt;
    }
    a(paramRect);
    return paramArrayOfInt;
  }
  
  public boolean isOpaque()
  {
    return false;
  }
  
  protected int l()
  {
    int i2 = 0;
    int i3 = getScrollY();
    boolean bool;
    if ((this.jdField_a_of_type_Xub != null) && (i3 < 0)) {
      if (i3 <= -d())
      {
        if (this.m != 2) {
          break label291;
        }
        if (this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener == null) {
          break label285;
        }
        bool = this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.a(0, this.jdField_a_of_type_Xub.getChildAt(0), this);
        this.m = 3;
      }
    }
    for (;;)
    {
      int i1;
      if (bool)
      {
        i1 = i2;
        if (this.jdField_a_of_type_Xub != null) {
          i1 = -d();
        }
      }
      do
      {
        do
        {
          do
          {
            return i1;
            this.m = 0;
            return 0;
            i1 = i2;
          } while (this.m >= 2);
          if (this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener != null) {
            this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.c(0, this.jdField_a_of_type_Xub.getChildAt(0), this);
          }
          this.m = 0;
          return 0;
          i1 = i2;
        } while (this.jdField_b_of_type_Xub == null);
        i1 = i2;
      } while (i3 <= 0);
      if (i3 >= v())
      {
        if (this.m != 2) {
          break label279;
        }
        if (this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener == null) {
          break label273;
        }
        bool = this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.a(1, this.jdField_b_of_type_Xub.getChildAt(0), this);
        label199:
        this.m = 3;
      }
      for (;;)
      {
        if (bool)
        {
          i1 = i2;
          if (this.jdField_b_of_type_Xub == null) {
            break;
          }
          return v();
        }
        this.m = 0;
        return 0;
        i1 = i2;
        if (this.m >= 2) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener != null) {
          this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.c(1, this.jdField_b_of_type_Xub.getChildAt(0), this);
        }
        this.m = 0;
        return 0;
        label273:
        bool = false;
        break label199;
        label279:
        bool = false;
      }
      label285:
      bool = false;
      break;
      label291:
      bool = false;
    }
  }
  
  void l()
  {
    a(this.jdField_a_of_type_JavaUtilArrayList);
    a(this.jdField_b_of_type_JavaUtilArrayList);
    super.l();
    this.U = 0;
  }
  
  public int m()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int n()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    int i2 = getChildCount();
    if (i2 > 0)
    {
      int i1 = 0;
      while (i1 < i2)
      {
        a(getChildAt(i1));
        i1 += 1;
      }
      removeAllViews();
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    int i3 = 0;
    int i2 = 0;
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    ListAdapter localListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
    int i1 = -1;
    int i5 = i3;
    int i6 = i1;
    Rect localRect;
    int i4;
    if (localListAdapter != null)
    {
      i5 = i3;
      i6 = i1;
      if (paramBoolean)
      {
        i5 = i3;
        i6 = i1;
        if (paramRect != null)
        {
          paramRect.offset(getScrollX(), getScrollY());
          if (localListAdapter.getCount() < getChildCount() + this.au)
          {
            this.U = 0;
            v_();
          }
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          i4 = Integer.MAX_VALUE;
          int i7 = getChildCount();
          int i8 = this.au;
          i3 = 0;
          i5 = i2;
          i6 = i1;
          if (i3 < i7) {
            if (!localListAdapter.isEnabled(i8 + i3))
            {
              i5 = i2;
              i2 = i1;
              i1 = i5;
            }
          }
        }
      }
    }
    for (;;)
    {
      i5 = i3 + 1;
      i3 = i2;
      i2 = i1;
      i1 = i3;
      i3 = i5;
      break;
      View localView = getChildAt(i3);
      localView.getDrawingRect(localRect);
      offsetDescendantRectToMyCoords(localView, localRect);
      i5 = a(paramRect, localRect, paramInt);
      if (i5 < i4)
      {
        i1 = localView.getTop();
        i2 = i3;
        i4 = i5;
        continue;
        if (i6 >= 0)
        {
          setSelectionFromTop(this.au + i6, i5);
          return;
        }
        requestLayout();
      }
      else
      {
        i5 = i1;
        i1 = i2;
        i2 = i5;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    e();
    return bool;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return b(paramInt, 1, paramKeyEvent);
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return b(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return b(paramInt, 1, paramKeyEvent);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Xub != null)
    {
      this.jdField_a_of_type_Xub.layout(this.jdField_c_of_type_AndroidGraphicsRect.left, this.jdField_c_of_type_AndroidGraphicsRect.top, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_Xub.getMeasuredWidth(), this.jdField_a_of_type_Xub.getMeasuredHeight());
      this.b_ = this.jdField_a_of_type_Xub.getHeight();
    }
    if (this.jdField_b_of_type_Xub != null)
    {
      this.jdField_b_of_type_Xub.layout(this.jdField_c_of_type_AndroidGraphicsRect.left, getMeasuredHeight() - this.jdField_b_of_type_Xub.getMeasuredHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_b_of_type_Xub.getMeasuredWidth(), getMeasuredHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom);
      this.ar = this.jdField_b_of_type_Xub.getHeight();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    int i1;
    int i2;
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null)
    {
      paramInt2 = 0;
      this.aG = paramInt2;
      if ((this.aG <= 0) || ((i6 != 0) && (i5 != 0))) {
        break label361;
      }
      View localView = a(0, this.jdField_a_of_type_ArrayOfBoolean);
      a(localView, 0, paramInt1);
      i1 = localView.getMeasuredWidth();
      i2 = localView.getMeasuredHeight();
      if (!VersionUtils.e()) {
        break label356;
      }
      paramInt2 = combineMeasuredStates(0, localView.getMeasuredState());
      label105:
      if ((d()) && (this.jdField_a_of_type_Xsa.a(((AbsListView.LayoutParams)localView.getLayoutParams()).jdField_a_of_type_Int))) {
        this.jdField_a_of_type_Xsa.a(localView, -1);
      }
    }
    for (;;)
    {
      if (i6 == 0) {
        paramInt2 = i1 + (this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right) + getVerticalScrollbarWidth();
      }
      for (;;)
      {
        i1 = i3;
        if (i5 == 0) {
          i1 = this.jdField_c_of_type_AndroidGraphicsRect.top + this.jdField_c_of_type_AndroidGraphicsRect.bottom + i2 + getVerticalFadingEdgeLength() * 2;
        }
        i2 = i1;
        if (i5 == Integer.MIN_VALUE) {
          i2 = a(paramInt1, 0, -1, i1, -1);
        }
        setMeasuredDimension(paramInt2, i2);
        this.aa = paramInt1;
        if ((this.jdField_a_of_type_Xub != null) || (this.jdField_b_of_type_Xub != null))
        {
          paramInt1 = ViewGroup.getChildMeasureSpec(this.aa, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_AndroidGraphicsRect.right, -1);
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          if (this.jdField_a_of_type_Xub != null) {
            this.jdField_a_of_type_Xub.measure(paramInt1, paramInt2);
          }
          if (this.jdField_b_of_type_Xub != null) {
            this.jdField_b_of_type_Xub.measure(paramInt1, paramInt2);
          }
        }
        return;
        paramInt2 = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
        break;
        if (VersionUtils.e()) {
          paramInt2 = 0xFF000000 & paramInt2 | i4;
        } else {
          paramInt2 = i4;
        }
      }
      label356:
      paramInt2 = 0;
      break label105;
      label361:
      paramInt2 = 0;
      i2 = 0;
      i1 = 0;
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 0) && (paramInt4 == 0) && (this.jdField_a_of_type_Xub != null)) {
      f(this.jdField_a_of_type_Xub);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetListView$OnScrollChangeListener != null) {
        this.jdField_a_of_type_ComTencentWidgetListView$OnScrollChangeListener.a(this.au, getChildCount(), this.aG);
      }
      return;
      if ((paramInt2 == 0) && (paramInt4 < 0) && (this.jdField_a_of_type_Xub != null)) {
        g(this.jdField_a_of_type_Xub);
      } else if ((paramInt2 > 0) && (paramInt4 == 0) && (this.jdField_b_of_type_Xub != null)) {
        f(this.jdField_b_of_type_Xub);
      } else if ((paramInt2 == 0) && (paramInt4 > 0) && (this.jdField_b_of_type_Xub != null)) {
        g(this.jdField_b_of_type_Xub);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0)
    {
      View localView = getFocusedChild();
      if (localView != null)
      {
        int i1 = this.au;
        int i2 = indexOfChild(localView);
        int i3 = Math.max(0, localView.getBottom() - (paramInt2 - this.mPaddingTop));
        int i4 = localView.getTop();
        if (this.jdField_a_of_type_Xtz == null) {
          this.jdField_a_of_type_Xtz = new xtz(this, null);
        }
        post(this.jdField_a_of_type_Xtz.a(i1 + i2, i4 - i3));
      }
      K();
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onThemeChanged()
  {
    this.jdField_a_of_type_Xsa.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      SkinEngine.invalidateAll(((ListView.FixedViewInfo)localIterator.next()).jdField_a_of_type_AndroidViewView);
    }
    localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      SkinEngine.invalidateAll(((ListView.FixedViewInfo)localIterator.next()).jdField_a_of_type_AndroidViewView);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {}
    for (this.v = true;; this.v = false) {
      do
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        e();
        return bool;
      } while ((i1 != 1) && (i1 != 3));
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    int i5 = paramRect.top;
    paramRect.offset(paramView.getLeft(), paramView.getTop());
    paramRect.offset(-paramView.getScrollX(), -paramView.getScrollY());
    int i4 = getHeight();
    int i2 = getScrollY();
    int i3 = i2 + i4;
    int i6 = getVerticalFadingEdgeLength();
    int i1 = i2;
    if (b()) {
      if (this.aF <= 0)
      {
        i1 = i2;
        if (i5 <= i6) {}
      }
      else
      {
        i1 = i2 + i6;
      }
    }
    i5 = getChildAt(getChildCount() - 1).getBottom();
    i2 = i3;
    if (t()) {
      if (this.aF >= this.aG - 1)
      {
        i2 = i3;
        if (paramRect.bottom >= i5 - i6) {}
      }
      else
      {
        i2 = i3 - i6;
      }
    }
    if ((paramRect.bottom > i2) && (paramRect.top > i1)) {
      if (paramRect.height() > i4)
      {
        i1 = paramRect.top - i1 + 0;
        i1 = Math.min(i1, i5 - i2);
      }
    }
    for (;;)
    {
      if (i1 != 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (paramBoolean)
        {
          j(-i1);
          a(-1, paramView);
          this.aj = paramView.getTop();
          invalidate();
        }
        return paramBoolean;
        i1 = paramRect.bottom - i2 + 0;
        break;
        if ((paramRect.top >= i1) || (paramRect.bottom >= i2)) {
          break label335;
        }
        if (paramRect.height() > i4) {}
        for (i2 = 0 - (i2 - paramRect.bottom);; i2 = 0 - (i1 - paramRect.top))
        {
          i1 = Math.max(i2, getChildAt(0).getTop() - i1);
          break;
        }
      }
      label335:
      i1 = 0;
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_Xrq != null)) {
      this.jdField_a_of_type_AndroidWidgetListAdapter.unregisterDataSetObserver(this.jdField_a_of_type_Xrq);
    }
    l();
    this.jdField_a_of_type_Xsa.b();
    int i1;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) || (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetListAdapter = new HeaderViewListAdapter(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilArrayList, paramListAdapter);
      this.aJ = -1;
      this.jdField_g_of_type_Long = Long.MIN_VALUE;
      super.setAdapter(paramListAdapter);
      if (this.jdField_a_of_type_AndroidWidgetListAdapter == null) {
        break label244;
      }
      this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidWidgetListAdapter.areAllItemsEnabled();
      this.aH = this.aG;
      this.aG = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
      z();
      this.jdField_a_of_type_Xrq = new xua(this);
      this.jdField_a_of_type_AndroidWidgetListAdapter.registerDataSetObserver(this.jdField_a_of_type_Xrq);
      this.jdField_a_of_type_Xsa.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getViewTypeCount());
      if (!this.i) {
        break label234;
      }
      i1 = a(this.aG - 1, false);
      label200:
      h(i1);
      i(i1);
      if (this.aG == 0) {
        A();
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
      break;
      label234:
      i1 = a(0, true);
      break label200;
      label244:
      this.jdField_e_of_type_Boolean = true;
      z();
      A();
    }
  }
  
  public void setCacheColorHint(int paramInt)
  {
    if (paramInt >>> 24 == 255) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (bool)
      {
        if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
          this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
      }
      super.setCacheColorHint(paramInt);
      return;
    }
  }
  
  public void setContentBackground(int paramInt)
  {
    setContentBackground(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setContentBackground(Drawable paramDrawable)
  {
    setContentBackground(paramDrawable, true);
  }
  
  public void setContentBackground(Drawable paramDrawable, boolean paramBoolean)
  {
    setContentBackground(paramDrawable, paramBoolean, false);
  }
  
  public void setContentBackground(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_g_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    for (;;)
    {
      this.u = paramBoolean2;
      return;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramBoolean1) {
        this.jdField_g_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838671);
      }
    }
  }
  
  public void setDelAnimationDuration(long paramLong)
  {
    if (paramLong > 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    boolean bool = false;
    if (paramDrawable != null)
    {
      this.aL = paramDrawable.getIntrinsicHeight();
      if (this.aL >= 0) {
        break label69;
      }
    }
    label69:
    for (int i1 = 0;; i1 = this.aL)
    {
      this.aL = i1;
      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if ((paramDrawable == null) || (paramDrawable.getOpacity() == -1)) {
        bool = true;
      }
      this.jdField_b_of_type_Boolean = bool;
      requestLayout();
      invalidate();
      return;
      this.aL = 0;
      break;
    }
  }
  
  public void setDividerHeight(int paramInt)
  {
    this.aL = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setFooterDividersEnabled(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setHeaderDividersEnabled(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setInsertAnimation(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation = paramAnimation;
  }
  
  public void setItemsCanFocus(boolean paramBoolean)
  {
    this.t = paramBoolean;
    if (!paramBoolean) {
      setDescendantFocusability(393216);
    }
  }
  
  public void setOnScrollChangeListener(ListView.OnScrollChangeListener paramOnScrollChangeListener)
  {
    this.jdField_a_of_type_ComTencentWidgetListView$OnScrollChangeListener = paramOnScrollChangeListener;
  }
  
  public void setOverScrollFooter(View paramView)
  {
    if (paramView == null) {
      if (this.jdField_b_of_type_Xub != null)
      {
        this.jdField_b_of_type_Xub.removeAllViewsInLayout();
        xub.a(this.jdField_b_of_type_Xub, null);
        this.jdField_b_of_type_Xub = null;
      }
    }
    for (;;)
    {
      this.m = 0;
      this.mScrollY = 0;
      return;
      if (this.jdField_b_of_type_Xub == null)
      {
        this.jdField_b_of_type_Xub = new xub(getContext());
        xub.a(this.jdField_b_of_type_Xub, this);
      }
      this.jdField_b_of_type_Xub.removeAllViewsInLayout();
      this.jdField_b_of_type_Xub.addView(paramView);
    }
  }
  
  public void setOverScrollFooterHeight(int paramInt)
  {
    this.aN = paramInt;
  }
  
  public void setOverScrollHeader(View paramView)
  {
    if (paramView == null) {
      if (this.jdField_a_of_type_Xub != null)
      {
        this.jdField_a_of_type_Xub.removeAllViewsInLayout();
        xub.a(this.jdField_a_of_type_Xub, null);
        this.jdField_a_of_type_Xub = null;
      }
    }
    for (;;)
    {
      this.m = 0;
      this.mScrollY = 0;
      return;
      if (this.jdField_a_of_type_Xub == null)
      {
        this.jdField_a_of_type_Xub = new xub(getContext());
        xub.a(this.jdField_a_of_type_Xub, this);
      }
      this.jdField_a_of_type_Xub.removeAllViewsInLayout();
      this.jdField_a_of_type_Xub.addView(paramView);
    }
  }
  
  public void setOverScrollHeight(int paramInt)
  {
    this.aM = paramInt;
  }
  
  public void setOverScrollListener(OverScrollViewListener paramOverScrollViewListener)
  {
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = paramOverScrollViewListener;
  }
  
  public void setOverscrollFooter(Drawable paramDrawable)
  {
    this.jdField_f_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    invalidate();
  }
  
  public void setOverscrollHeader(Drawable paramDrawable)
  {
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (getScrollY() < 0) {
      invalidate();
    }
  }
  
  public void setSelection(int paramInt)
  {
    setSelectionFromTop(paramInt, 0);
  }
  
  public void setSelectionAfterHeaderView()
  {
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i1 > 0)
    {
      this.aE = 0;
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null)
    {
      setSelection(i1);
      return;
    }
    this.aE = i1;
    this.U = 2;
  }
  
  public void setSelectionFromBottom(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null) {}
    for (;;)
    {
      return;
      if (!isInTouchMode())
      {
        int i1 = a(paramInt1, true);
        paramInt1 = i1;
        if (i1 >= 0)
        {
          i(i1);
          paramInt1 = i1;
        }
      }
      while (paramInt1 >= 0)
      {
        requestLayout();
        this.U = 100;
        if (this.p)
        {
          this.ax = paramInt1;
          this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt1);
        }
        this.aw = (this.jdField_c_of_type_AndroidGraphicsRect.bottom + paramInt2);
        return;
        this.ak = paramInt1;
      }
    }
  }
  
  public void setSelectionFromTop(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null) {}
    for (;;)
    {
      return;
      if (!isInTouchMode())
      {
        int i1 = a(paramInt1, true);
        paramInt1 = i1;
        if (i1 >= 0)
        {
          i(i1);
          paramInt1 = i1;
        }
      }
      while (paramInt1 >= 0)
      {
        requestLayout();
        this.U = 4;
        if (this.p)
        {
          this.ax = paramInt1;
          this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt1);
        }
        this.av = (this.jdField_c_of_type_AndroidGraphicsRect.top + paramInt2);
        return;
        this.ak = paramInt1;
      }
    }
  }
  
  public void setStatisticCollector()
  {
    ListAdapter localListAdapter = a();
    if ((localListAdapter instanceof HeaderViewListAdapter))
    {
      localListAdapter = ((HeaderViewListAdapter)localListAdapter).getWrappedAdapter();
      if ((localListAdapter instanceof ExpandableListConnector))
      {
        ((ExpandableListConnector)localListAdapter).a().getClass().getName();
        return;
      }
      localListAdapter.getClass().getName();
      return;
    }
    if ((localListAdapter instanceof ExpandableListConnector))
    {
      ((ExpandableListConnector)localListAdapter).a().getClass().getName();
      return;
    }
    localListAdapter.getClass().getName();
  }
  
  public int v()
  {
    if ((this.aN == 0) && (this.jdField_b_of_type_Xub != null)) {
      return this.jdField_b_of_type_Xub.getHeight();
    }
    return this.aN;
  }
  
  public void v_()
  {
    boolean bool1 = this.s;
    if (!bool1)
    {
      this.s = true;
      d("ListView.layoutChildren");
    }
    int i2;
    int i4;
    int i6;
    int i5;
    int i1;
    View localView1;
    View localView3;
    Object localObject5;
    int i3;
    View localView2;
    label230:
    boolean bool2;
    try
    {
      super.v_();
      invalidate();
      if (this.jdField_a_of_type_AndroidWidgetListAdapter == null)
      {
        l();
        j();
        return;
      }
      i2 = this.jdField_c_of_type_AndroidGraphicsRect.top;
      i4 = this.mBottom - this.mTop - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
      i6 = getChildCount();
      i5 = this.au + i6 - 1;
      i1 = 0;
      localView1 = null;
      localView3 = null;
      localObject5 = null;
      switch (this.U)
      {
      case 2: 
        i3 = this.aF - this.au;
        Object localObject1 = localView1;
        if (i3 >= 0)
        {
          localObject1 = localView1;
          if (i3 < i6) {
            localObject1 = getChildAt(i3);
          }
        }
        localView2 = getChildAt(0);
        localView1 = getChildAt(i6 - 1);
        if (this.aE >= 0) {
          i1 = this.aE - this.aF;
        }
        localView3 = getChildAt(i3 + i1);
        for (;;)
        {
          bool2 = this.r;
          if (bool2) {
            s();
          }
          if (this.aG != 0) {
            break;
          }
          l();
          j();
          return;
          i1 = this.aE - this.au;
          if ((i1 < 0) || (i1 >= i6)) {
            break label1500;
          }
          localView3 = getChildAt(i1);
          localView1 = null;
          localView2 = null;
          localObject1 = null;
          i1 = 0;
        }
        if (this.aG != this.jdField_a_of_type_AndroidWidgetListAdapter.getCount())
        {
          localObject1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getClass();
          if ((this.jdField_a_of_type_AndroidWidgetListAdapter instanceof HeaderViewListAdapter)) {
            localObject1 = ((HeaderViewListAdapter)this.jdField_a_of_type_AndroidWidgetListAdapter).getWrappedAdapter().getClass();
          }
          throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + localObject1 + ")]" + "mItemCount=" + this.aG + "mAdapter.getCount()=" + this.jdField_a_of_type_AndroidWidgetListAdapter.getCount());
        }
        break;
      }
    }
    finally
    {
      if (!bool1) {
        this.s = false;
      }
      D();
    }
    h(this.aE);
    int i7 = this.au;
    xsa localxsa = this.jdField_a_of_type_Xsa;
    Object localObject4 = null;
    if (bool2)
    {
      i3 = 0;
      while (i3 < i6)
      {
        localxsa.a(getChildAt(i3), i7 + i3);
        i3 += 1;
      }
    }
    localxsa.a(i6, i7);
    Object localObject6 = getFocusedChild();
    label588:
    label605:
    label680:
    Object localObject3;
    if (localObject6 != null)
    {
      if ((!bool2) || (c((View)localObject6)))
      {
        localObject5 = findFocus();
        if (localObject5 == null) {
          break label1527;
        }
        ((View)localObject5).onStartTemporaryDetach();
        break label1527;
      }
      requestFocus();
      localObject6 = localObject4;
      localObject4 = localObject5;
      localObject5 = localObject6;
      detachAllViewsFromParent();
      switch (this.U)
      {
      case 2: 
        if (i6 == 0) {
          if (!this.i)
          {
            h(a(0, true));
            localObject3 = a(i2);
            label709:
            c();
            localxsa.c();
            if (localObject3 == null) {
              break label1394;
            }
            if ((!this.t) || (!hasFocus()) || (((View)localObject3).hasFocus())) {
              break label1385;
            }
            if ((localObject3 == localObject5) && (((View)localObject4).requestFocus())) {
              break label1537;
            }
            if (!((View)localObject3).requestFocus()) {
              break label1552;
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      label767:
      if (i1 == 0)
      {
        localView1 = getFocusedChild();
        if (localView1 != null) {
          localView1.clearFocus();
        }
        a(-1, (View)localObject3);
        label791:
        this.aj = ((View)localObject3).getTop();
        label799:
        if ((localObject4 != null) && (((View)localObject4).getWindowToken() != null)) {
          ((View)localObject4).onFinishTemporaryDetach();
        }
        this.U = 0;
        this.r = false;
        this.p = false;
        i(this.aF);
        m();
        if (this.aG > 0) {
          A();
        }
        j();
        i2 = this.au + getChildCount() - 1;
        if ((this.jdField_a_of_type_AndroidViewAnimationAnimation == null) || (this.jdField_a_of_type_ArrayOfInt == null) || (!bool2) || (this.aG <= 0) || (i2 < this.aG - 1) || (getChildAt(getChildCount() - 1).getBottom() >= i4)) {
          break label1472;
        }
        localObject3 = this.jdField_a_of_type_ArrayOfInt;
        i3 = localObject3.length;
        i1 = 0;
      }
      for (;;)
      {
        if (i1 < i3)
        {
          i4 = localObject3[i1];
          if ((i4 < this.au) || (i4 > i2)) {
            break label1543;
          }
          getChildAt(i4 - this.au).startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
          break label1543;
          if (localView3 != null)
          {
            localObject3 = a(localView3.getTop(), i2, i4);
            break label709;
          }
          localObject3 = c(i2, i4);
          break label709;
          if (!this.i)
          {
            localObject3 = e(this.ax, this.av);
            break label709;
          }
          localObject3 = d(this.ax, this.az - this.aw);
          break label709;
          localObject3 = b(this.aG - 1, i4);
          d();
          break label709;
          this.au = 0;
          localObject3 = a(i2);
          d();
          break label709;
          localObject3 = e(o(), this.av);
          break label709;
          localObject3 = d(o(), this.az - this.aw);
          break label709;
          localObject3 = a((View)localObject3, localView3, i1, i2, i4);
          break label709;
          h(a(this.aG - 1, false));
          localObject3 = b(this.aG - 1, i4);
          break label709;
          if ((this.aF >= 0) && (this.aF < this.aG))
          {
            i1 = this.aF;
            if (localObject3 == null) {}
            for (;;)
            {
              localObject3 = e(i1, i2);
              break;
              i2 = ((View)localObject3).getTop();
            }
          }
          if (((this.mScrollY == 0) && (!this.i)) || (this.mScrollY < 0))
          {
            if (this.au < this.aG)
            {
              i1 = this.au;
              if (localView2 == null) {}
              for (;;)
              {
                localObject3 = e(i1, i2);
                break;
                i2 = localView2.getTop();
              }
            }
            localObject3 = e(0, i2);
            break label709;
          }
          if (i5 < this.aG)
          {
            if (localView1 == null) {}
            for (i1 = i4;; i1 = localView1.getBottom())
            {
              localObject3 = d(i5, i1);
              break;
            }
          }
          localObject3 = d(this.aG - 1, this.az);
          break label709;
          ((View)localObject3).setSelected(false);
          this.jdField_b_of_type_AndroidGraphicsRect.setEmpty();
          break label791;
          label1385:
          a(-1, (View)localObject3);
          break label791;
          label1394:
          if ((this.ag > 0) && (this.ag < 3))
          {
            localObject3 = getChildAt(this.ab - this.au);
            if (localObject3 != null) {
              a(this.ab, (View)localObject3);
            }
          }
          for (;;)
          {
            if ((!hasFocus()) || (localObject4 == null)) {
              break label1470;
            }
            ((View)localObject4).requestFocus();
            break;
            this.aj = 0;
            this.jdField_b_of_type_AndroidGraphicsRect.setEmpty();
          }
          label1470:
          break label799;
        }
        label1472:
        this.jdField_a_of_type_ArrayOfInt = null;
        if (!bool1) {
          this.s = false;
        }
        D();
        return;
        localObject4 = null;
        localObject5 = null;
        break label605;
        label1500:
        localView1 = null;
        localView2 = null;
        localObject3 = null;
        i1 = 0;
        break label230;
        break;
        localView1 = null;
        localView2 = null;
        localObject3 = null;
        i1 = 0;
        break label230;
        label1527:
        localObject4 = localObject6;
        break label588;
        break label680;
        label1537:
        i1 = 1;
        break label767;
        label1543:
        i1 += 1;
      }
      label1552:
      i1 = 0;
    }
  }
  
  public int w()
  {
    return (int)(0.33F * (getBottom() - this.mTop));
  }
  
  public int x()
  {
    return this.aL;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\widget\ListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */