package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ProgressCircle;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import rhf;
import rhg;
import rhh;
import rhj;
import rhk;
import rhl;
import rhm;
import rhn;
import rho;

public class DragSortListView
  extends XListView
{
  private static final int aT = 0;
  private static final int aU = 3;
  private static final int bc = 0;
  private static final int bd = 1;
  private static final int be = 2;
  private static final int bg = 3;
  static final int jdField_g_of_type_Int = 1;
  static final int jdField_h_of_type_Int = 2;
  static final int jdField_i_of_type_Int = 4;
  public static final int p = 1;
  public static final int q = 2;
  public static final int r = 4;
  public static final int s = 8;
  private boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  public float a;
  public int a;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  public Point a;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private View jdField_a_of_type_AndroidViewView;
  private DragSortListView.DragListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragListener;
  public DragSortListView.DragScrollProfile a;
  private DragSortListView.DropListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener;
  private DragSortListView.FloatViewManager jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager;
  private DragSortListView.LeftEventListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LeftEventListener;
  private DragSortListView.RemoveListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener;
  private rhh jdField_a_of_type_Rhh;
  private rhj jdField_a_of_type_Rhj;
  private rhk jdField_a_of_type_Rhk;
  private rhl jdField_a_of_type_Rhl;
  private rhm jdField_a_of_type_Rhm;
  private rhn jdField_a_of_type_Rhn;
  private rho jdField_a_of_type_Rho;
  public boolean a;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private int aQ;
  private int aR;
  private int aS;
  private int aV;
  private int aW;
  private int aX;
  private int aY;
  private int aZ;
  public float b;
  public int b;
  private Point jdField_b_of_type_AndroidGraphicsPoint;
  private boolean jdField_b_of_type_Boolean;
  private int ba;
  private int bb;
  private int bf;
  public float c;
  public int c;
  private boolean c;
  public float d;
  public int d;
  private boolean d;
  public float e;
  public int e;
  private boolean e;
  public float f;
  public int f;
  private float jdField_g_of_type_Float;
  private float jdField_h_of_type_Float;
  private float jdField_i_of_type_Float;
  private float j;
  public int j;
  private float k;
  public int k;
  private float l;
  public int l;
  public int m;
  public int n;
  public int o;
  int jdField_t_of_type_Int;
  private boolean jdField_t_of_type_Boolean;
  int jdField_u_of_type_Int;
  private boolean jdField_u_of_type_Boolean;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool1 = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point();
    this.jdField_b_of_type_AndroidGraphicsPoint = new Point();
    this.g = 1.0F;
    this.h = 1.0F;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 1;
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[1];
    this.i = 0.33333334F;
    this.jdField_j_of_type_Float = 0.33333334F;
    this.jdField_e_of_type_Float = 0.5F;
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScrollProfile = new rhf(this);
    this.bf = 0;
    this.jdField_k_of_type_Float = 0.25F;
    this.jdField_l_of_type_Float = 0.0F;
    this.jdField_a_of_type_Rhm = new rhm(this, 3);
    this.jdField_f_of_type_Float = 0.0F;
    this.C = true;
    this.jdField_t_of_type_Int = -1;
    int i2 = 150;
    int i1;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.q, 0, 0);
      this.jdField_k_of_type_Int = Math.max(1, paramContext.getDimensionPixelSize(0, 1));
      this.v = paramContext.getBoolean(5, false);
      if (this.v) {
        this.jdField_a_of_type_Rhk = new rhk(this);
      }
      this.g = paramContext.getFloat(6, this.g);
      this.h = this.g;
      this.jdField_d_of_type_Boolean = paramContext.getBoolean(10, this.jdField_d_of_type_Boolean);
      this.jdField_e_of_type_Boolean = paramContext.getBoolean(18, this.jdField_e_of_type_Boolean);
      this.jdField_k_of_type_Float = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(7, 0.75F)));
      if (this.jdField_k_of_type_Float > 0.0F)
      {
        bool1 = true;
        this.jdField_c_of_type_Boolean = bool1;
        setDragScrollStart(paramContext.getFloat(1, this.i));
        this.jdField_e_of_type_Float = paramContext.getFloat(2, this.jdField_e_of_type_Float);
        i2 = paramContext.getInt(8, 150);
        i1 = paramContext.getInt(9, 150);
        if (paramContext.getBoolean(17, true))
        {
          bool1 = paramContext.getBoolean(12, false);
          int i3 = paramContext.getInt(4, 1);
          boolean bool2 = paramContext.getBoolean(11, true);
          int i4 = paramContext.getInt(13, 0);
          int i5 = paramContext.getResourceId(14, 0);
          int i6 = paramContext.getResourceId(15, 0);
          int i7 = paramContext.getResourceId(16, 0);
          int i8 = paramContext.getColor(3, -16777216);
          paramAttributeSet = new DragSortController(this, i5, i4, i3, i7, i6);
          paramAttributeSet.b(bool1);
          paramAttributeSet.a(bool2);
          paramAttributeSet.g(i8);
          this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager = paramAttributeSet;
          super.setOnTouchListener(paramAttributeSet);
        }
        paramContext.recycle();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Rhj = new rhj(this);
      this.y = true;
      if (i2 > 0) {
        this.jdField_a_of_type_Rho = new rho(this, 0.5F, i2);
      }
      if (i1 > 0) {
        this.jdField_a_of_type_Rhl = new rhl(this, 0.5F, i1);
      }
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new rhg(this);
      return;
      bool1 = false;
      break;
      i1 = 150;
    }
  }
  
  private void E()
  {
    j(this.jdField_e_of_type_Int - m());
  }
  
  private void F()
  {
    int i1 = 0;
    int i2 = super.s();
    if (this.jdField_e_of_type_Int < i2)
    {
      View localView = super.getChildAt(0);
      if (localView != null) {
        i1 = localView.getTop();
      }
      super.setSelectionFromTop(i2 - 1, i1 - getPaddingTop());
    }
  }
  
  private void G()
  {
    this.bf = 0;
    this.jdField_u_of_type_Boolean = false;
    if (this.jdField_j_of_type_Int == 3) {
      this.jdField_j_of_type_Int = 0;
    }
    this.h = this.g;
    this.z = false;
    this.jdField_a_of_type_Rhm.a();
  }
  
  private void N()
  {
    int i1 = getPaddingTop();
    int i2 = getHeight() - i1 - getPaddingBottom();
    float f1 = i2;
    this.jdField_b_of_type_Float = (i1 + this.i * f1);
    float f2 = i1;
    this.jdField_a_of_type_Float = (f1 * (1.0F - this.jdField_j_of_type_Float) + f2);
    this.aW = ((int)this.jdField_b_of_type_Float);
    this.aX = ((int)this.jdField_a_of_type_Float);
    this.jdField_c_of_type_Float = (this.jdField_b_of_type_Float - i1);
    this.jdField_d_of_type_Float = (i1 + i2 - this.jdField_a_of_type_Float);
  }
  
  private void O()
  {
    int i2 = s();
    int i3 = t();
    int i1 = Math.max(0, m() - i2);
    i3 = Math.min(i3 - i2, d_() - 1 - n() - i2);
    while (i1 <= i3)
    {
      View localView = getChildAt(i1);
      if (localView != null) {
        b(i2 + i1, localView, false);
      }
      i1 += 1;
    }
  }
  
  private void P()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      c(this.jdField_a_of_type_AndroidViewView);
      this.jdField_l_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
      this.m = (this.jdField_l_of_type_Int / 2);
    }
  }
  
  private void Q()
  {
    this.E = true;
  }
  
  private void R()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager != null)
    {
      this.jdField_b_of_type_AndroidGraphicsPoint.set(this.aY, this.n);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidGraphicsPoint, this.jdField_b_of_type_AndroidGraphicsPoint);
    }
    int i1 = this.jdField_a_of_type_AndroidGraphicsPoint.x;
    int i4 = this.jdField_a_of_type_AndroidGraphicsPoint.y;
    int i2 = getPaddingLeft();
    int i3;
    if (((this.bb & 0x1) == 0) && (i1 > i2))
    {
      this.jdField_a_of_type_AndroidGraphicsPoint.x = i2;
      i2 = m();
      i3 = n();
      int i5 = s();
      int i6 = t();
      i1 = getPaddingTop();
      if (i5 < i2) {
        i1 = getChildAt(i2 - i5 - 1).getBottom();
      }
      i2 = i1;
      if ((this.bb & 0x8) == 0)
      {
        i2 = i1;
        if (i5 <= this.jdField_e_of_type_Int) {
          i2 = Math.max(getChildAt(this.jdField_e_of_type_Int - i5).getTop(), i1);
        }
      }
      i1 = getHeight() - getPaddingBottom();
      if (i6 >= d_() - i3 - 1) {
        i1 = getChildAt(d_() - i3 - 1 - i5).getBottom();
      }
      i3 = i1;
      if ((this.bb & 0x4) == 0)
      {
        i3 = i1;
        if (i6 >= this.jdField_e_of_type_Int) {
          i3 = Math.min(getChildAt(this.jdField_e_of_type_Int - i5).getBottom(), i1);
        }
      }
      if (i4 >= i2) {
        break label315;
      }
      this.jdField_a_of_type_AndroidGraphicsPoint.y = i2;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_AndroidGraphicsPoint.y + this.m);
      return;
      if (((this.bb & 0x2) != 0) || (i1 >= i2)) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsPoint.x = i2;
      break;
      label315:
      if (this.jdField_l_of_type_Int + i4 > i3) {
        this.jdField_a_of_type_AndroidGraphicsPoint.y = (i3 - this.jdField_l_of_type_Int);
      }
    }
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt4 - paramInt3;
    paramInt2 = paramInt1 + paramInt2;
    if (paramInt2 < paramInt3) {
      paramInt1 = paramInt2 + i1;
    }
    do
    {
      return paramInt1;
      paramInt1 = paramInt2;
    } while (paramInt2 < paramInt4);
    return paramInt2 - i1;
  }
  
  private int a(int paramInt1, View paramView, int paramInt2, int paramInt3)
  {
    int i1 = b(paramInt1);
    int i4 = paramView.getHeight();
    int i5 = c(paramInt1, i1);
    int i2;
    if (paramInt1 != this.jdField_e_of_type_Int)
    {
      i2 = i4 - i1;
      i1 = i5 - i1;
    }
    for (;;)
    {
      int i6 = this.jdField_l_of_type_Int;
      int i3 = i6;
      if (this.jdField_e_of_type_Int != this.jdField_c_of_type_Int)
      {
        i3 = i6;
        if (this.jdField_e_of_type_Int != this.jdField_d_of_type_Int) {
          i3 = i6 - this.jdField_k_of_type_Int;
        }
      }
      if (paramInt1 <= paramInt2)
      {
        if (paramInt1 > this.jdField_c_of_type_Int) {
          return i3 - i1 + 0;
        }
      }
      else
      {
        if (paramInt1 == paramInt3)
        {
          if (paramInt1 <= this.jdField_c_of_type_Int) {
            return i2 - i3 + 0;
          }
          if (paramInt1 == this.jdField_d_of_type_Int) {
            return i4 - i5 + 0;
          }
          return 0 + i2;
        }
        if (paramInt1 <= this.jdField_c_of_type_Int) {
          return 0 - i3;
        }
        if (paramInt1 == this.jdField_d_of_type_Int) {
          return 0 - i1;
        }
      }
      return 0;
      i1 = i5;
      i2 = i4;
    }
  }
  
  private int a(int paramInt, View paramView, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramInt == this.jdField_e_of_type_Int) {
      paramInt = i1;
    }
    View localView;
    label65:
    do
    {
      return paramInt;
      localView = paramView;
      if (paramInt >= m()) {
        if (paramInt < d_() - n()) {
          break label65;
        }
      }
      for (localView = paramView;; localView = ((ViewGroup)paramView).getChildAt(0))
      {
        paramView = localView.getLayoutParams();
        if ((paramView == null) || (paramView.height <= 0)) {
          break;
        }
        return paramView.height;
      }
      paramInt = localView.getHeight();
    } while ((paramInt != 0) && (!paramBoolean));
    c(localView);
    return localView.getMeasuredHeight();
  }
  
  private static int a(SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    int i1 = 0;
    int i2 = paramSparseBooleanArray.size();
    if (i2 - i1 > 0)
    {
      int i3 = i1 + i2 >> 1;
      if (paramSparseBooleanArray.keyAt(i3) < paramInt) {
        i1 = i3 + 1;
      }
      for (;;)
      {
        break;
        i2 = i3;
      }
    }
    return i1;
  }
  
  private static int a(SparseBooleanArray paramSparseBooleanArray, int paramInt1, int paramInt2)
  {
    int i1 = paramSparseBooleanArray.size();
    paramInt1 = a(paramSparseBooleanArray, paramInt1);
    while ((paramInt1 < i1) && (paramSparseBooleanArray.keyAt(paramInt1) < paramInt2) && (!paramSparseBooleanArray.valueAt(paramInt1))) {
      paramInt1 += 1;
    }
    if (paramInt1 != i1)
    {
      i1 = paramInt1;
      if (paramSparseBooleanArray.keyAt(paramInt1) < paramInt2) {}
    }
    else
    {
      i1 = -1;
    }
    return i1;
  }
  
  private static int a(SparseBooleanArray paramSparseBooleanArray, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i2 = a(paramSparseBooleanArray, paramInt1, paramInt2);
    if (i2 == -1) {
      return 0;
    }
    int i4 = paramSparseBooleanArray.keyAt(i2);
    int i1 = i4 + 1;
    i2 += 1;
    int i3 = 0;
    if (i2 < paramSparseBooleanArray.size())
    {
      int i5 = paramSparseBooleanArray.keyAt(i2);
      if (i5 < paramInt2)
      {
        if (!paramSparseBooleanArray.valueAt(i2)) {}
        for (;;)
        {
          i2 += 1;
          break;
          if (i5 == i1)
          {
            i1 += 1;
          }
          else
          {
            paramArrayOfInt1[i3] = i4;
            paramArrayOfInt2[i3] = i1;
            i3 += 1;
            i1 = i5 + 1;
            i4 = i5;
          }
        }
      }
    }
    i2 = i1;
    if (i1 == paramInt2) {
      i2 = paramInt1;
    }
    paramArrayOfInt1[i3] = i4;
    paramArrayOfInt2[i3] = i2;
    i1 = i3 + 1;
    paramInt2 = i1;
    if (i1 > 1)
    {
      paramInt2 = i1;
      if (paramArrayOfInt1[0] == paramInt1)
      {
        paramInt2 = i1;
        if (paramArrayOfInt2[(i1 - 1)] == paramInt1)
        {
          paramArrayOfInt1[0] = paramArrayOfInt1[(i1 - 1)];
          paramInt2 = i1 - 1;
        }
      }
    }
    return paramInt2;
  }
  
  private int a(MotionEvent paramMotionEvent)
  {
    return super.b((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
  
  private ImageView a(int paramInt)
  {
    paramInt -= s();
    if ((paramInt >= 0) && (paramInt <= getChildCount()))
    {
      View localView = super.getChildAt(paramInt);
      if (localView != null) {
        return (ImageView)localView.findViewById(2131301743);
      }
    }
    return null;
  }
  
  private void a(int paramInt, Canvas paramCanvas)
  {
    Drawable localDrawable = super.b();
    int i4 = super.x();
    ViewGroup localViewGroup;
    int i2;
    int i3;
    int i1;
    if ((localDrawable != null) && (i4 != 0))
    {
      localViewGroup = (ViewGroup)super.getChildAt(paramInt - s());
      if (localViewGroup != null)
      {
        i2 = super.getPaddingLeft();
        i3 = super.getWidth() - super.getPaddingRight();
        i1 = localViewGroup.getChildAt(0).getHeight();
        if (paramInt <= this.jdField_e_of_type_Int) {
          break label130;
        }
        i1 += localViewGroup.getTop();
        paramInt = i1 + i4;
      }
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.clipRect(i2, i1, i3, paramInt);
      localDrawable.setBounds(i2, i1, i3, paramInt);
      localDrawable.draw(paramCanvas);
      paramCanvas.restore();
      return;
      label130:
      paramInt = localViewGroup.getBottom() - i1;
      i1 = paramInt - i4;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      this.aZ = this.aY;
      this.o = this.n;
    }
    this.aY = ((int)paramMotionEvent.getX());
    this.n = ((int)paramMotionEvent.getY());
    if (i1 == 0)
    {
      this.aZ = this.aY;
      this.o = this.n;
    }
    this.aR = ((int)paramMotionEvent.getRawX() - this.aY);
    this.aS = ((int)paramMotionEvent.getRawY() - this.n);
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    paramView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.jdField_a_of_type_AndroidGraphicsRect.left = arrayOfInt[0];
    this.jdField_a_of_type_AndroidGraphicsRect.top = arrayOfInt[1];
    this.jdField_a_of_type_AndroidGraphicsRect.right += arrayOfInt[0];
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    int i1 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    paramView.bottom = (arrayOfInt[1] + i1);
    return this.jdField_a_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2);
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    return c(paramInt, a(paramInt, paramView, paramBoolean));
  }
  
  private void b(int paramInt, View paramView, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i1;
    if ((paramInt != this.jdField_e_of_type_Int) && (paramInt != this.jdField_c_of_type_Int) && (paramInt != this.jdField_d_of_type_Int))
    {
      i1 = -2;
      if (i1 != localLayoutParams.height)
      {
        localLayoutParams.height = i1;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.jdField_c_of_type_Int) || (paramInt == this.jdField_d_of_type_Int))
      {
        if (paramInt >= this.jdField_e_of_type_Int) {
          break label151;
        }
        ((DragSortItemView)paramView).setGravity(80);
      }
    }
    for (;;)
    {
      int i3 = paramView.getVisibility();
      int i2 = 0;
      i1 = i2;
      if (paramInt == this.jdField_e_of_type_Int)
      {
        i1 = i2;
        if (this.jdField_a_of_type_AndroidViewView != null) {
          i1 = 4;
        }
      }
      if (i1 != i3) {
        paramView.setVisibility(i1);
      }
      return;
      i1 = b(paramInt, paramView, paramBoolean);
      break;
      label151:
      if (paramInt > this.jdField_e_of_type_Int) {
        ((DragSortItemView)paramView).setGravity(48);
      }
    }
  }
  
  private int c(int paramInt1, int paramInt2)
  {
    x();
    int i1;
    int i2;
    int i3;
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_c_of_type_Int != this.jdField_d_of_type_Int))
    {
      i1 = 1;
      i2 = this.jdField_l_of_type_Int - this.jdField_k_of_type_Int;
      i3 = (int)(this.jdField_l_of_type_Float * i2);
      if (paramInt1 != this.jdField_e_of_type_Int) {
        break label123;
      }
      if (this.jdField_e_of_type_Int != this.jdField_c_of_type_Int) {
        break label90;
      }
      if (i1 == 0) {
        break label85;
      }
      i1 = i3 + this.jdField_k_of_type_Int;
    }
    label85:
    label90:
    label123:
    do
    {
      do
      {
        return i1;
        i1 = 0;
        break;
        return this.jdField_l_of_type_Int;
        if (this.jdField_e_of_type_Int == this.jdField_d_of_type_Int) {
          return this.jdField_l_of_type_Int - i3;
        }
        i1 = paramInt2;
      } while (this.jdField_j_of_type_Int == 0);
      return this.jdField_k_of_type_Int;
      if (paramInt1 == this.jdField_c_of_type_Int)
      {
        if (i1 != 0) {
          return paramInt2 + i3;
        }
        return paramInt2 + i2;
      }
      i1 = paramInt2;
    } while (paramInt1 != this.jdField_d_of_type_Int);
    return paramInt2 + i2 - i3;
  }
  
  private void c(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i2 = ViewGroup.getChildMeasureSpec(this.aV, j() + k(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0) {}
    for (int i1 = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(i2, i1);
      return;
    }
  }
  
  private void g()
  {
    this.jdField_e_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  private void g(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint.x = (paramInt1 - this.aQ);
    this.jdField_a_of_type_AndroidGraphicsPoint.y = (paramInt2 - this.jdField_f_of_type_Int);
    a(true);
    paramInt1 = Math.min(paramInt2, this.jdField_a_of_type_Int + this.m);
    paramInt2 = Math.max(paramInt2, this.jdField_a_of_type_Int - this.m);
    int i1 = this.jdField_a_of_type_Rhj.a();
    if ((paramInt1 > this.o) && (paramInt1 > this.aX) && (i1 != 1))
    {
      if (i1 != -1) {
        this.jdField_a_of_type_Rhj.a(true);
      }
      this.jdField_a_of_type_Rhj.a(1);
    }
    do
    {
      return;
      if ((paramInt2 < this.o) && (paramInt2 < this.aW) && (i1 != 0))
      {
        if (i1 != -1) {
          this.jdField_a_of_type_Rhj.a(true);
        }
        this.jdField_a_of_type_Rhj.a(0);
        return;
      }
    } while ((paramInt2 < this.aW) || (paramInt1 > this.aX) || (!this.jdField_a_of_type_Rhj.a()));
    this.jdField_a_of_type_Rhj.a(true);
  }
  
  private void h()
  {
    this.jdField_j_of_type_Int = 2;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener != null) && (this.jdField_b_of_type_Int >= 0) && (this.jdField_b_of_type_Int < d_()))
    {
      int i1 = m();
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener.a_(this.jdField_e_of_type_Int - i1, this.jdField_b_of_type_Int - i1);
    }
    c();
    F();
    g();
    O();
    if (this.jdField_u_of_type_Boolean)
    {
      this.jdField_j_of_type_Int = 3;
      return;
    }
    this.jdField_j_of_type_Int = 0;
  }
  
  private void j(int paramInt)
  {
    this.jdField_j_of_type_Int = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener.a(paramInt);
    }
    c();
    F();
    g();
    if (this.jdField_u_of_type_Boolean)
    {
      this.jdField_j_of_type_Int = 3;
      return;
    }
    this.jdField_j_of_type_Int = 0;
  }
  
  private boolean t()
  {
    int i1 = super.s();
    int i2 = this.jdField_c_of_type_Int;
    View localView2 = super.getChildAt(i2 - i1);
    View localView1 = localView2;
    if (localView2 == null)
    {
      i2 = i1 + getChildCount() / 2;
      localView1 = super.getChildAt(i2 - i1);
    }
    int i6 = localView1.getTop();
    int i7 = localView1.getHeight();
    i1 = a(i2, i6);
    int i9 = super.x();
    int i3;
    int i4;
    int i5;
    label155:
    int i8;
    label210:
    float f2;
    if (this.jdField_a_of_type_Int < i1)
    {
      i3 = i1;
      i4 = i1;
      i1 = i3;
      i5 = i2;
      i2 = i5;
      i3 = i4;
      if (i5 >= 0)
      {
        i5 -= 1;
        i1 = a(i5);
        if (i5 == 0)
        {
          i1 = i6 - i9 - i1;
          i3 = i4;
          i2 = i5;
        }
      }
      else
      {
        i5 = super.m();
        i8 = super.n();
        i6 = this.jdField_c_of_type_Int;
        i7 = this.jdField_d_of_type_Int;
        float f1 = this.jdField_l_of_type_Float;
        if (!this.jdField_c_of_type_Boolean) {
          break label652;
        }
        i9 = Math.abs(i1 - i3);
        if (this.jdField_a_of_type_Int >= i1) {
          break label574;
        }
        f2 = this.jdField_k_of_type_Float;
        i4 = (int)(i9 * (f2 * 0.5F));
        f2 = i4;
        i3 += i4;
        if (this.jdField_a_of_type_Int >= i3) {
          break label589;
        }
        this.jdField_c_of_type_Int = (i2 - 1);
        this.jdField_d_of_type_Int = i2;
        this.jdField_l_of_type_Float = ((i3 - this.jdField_a_of_type_Int) * 0.5F / f2);
        label277:
        if (this.jdField_c_of_type_Int >= i5) {
          break label667;
        }
        this.jdField_c_of_type_Int = i5;
        this.jdField_d_of_type_Int = i5;
        i2 = i5;
        label302:
        if ((this.jdField_c_of_type_Int == i6) && (this.jdField_d_of_type_Int == i7) && (this.jdField_l_of_type_Float == f1)) {
          break label710;
        }
      }
    }
    label574:
    label589:
    label652:
    label667:
    label710:
    for (boolean bool = true;; bool = false)
    {
      if (i2 != this.jdField_b_of_type_Int)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragListener.a(this.jdField_b_of_type_Int - i5, i2 - i5);
        }
        this.jdField_b_of_type_Int = i2;
        return true;
        i7 = i6 - (i1 + i9);
        i6 = a(i5, i7);
        i2 = i5;
        i3 = i4;
        i1 = i6;
        if (this.jdField_a_of_type_Int >= i6) {
          break label155;
        }
        i4 = i6;
        i1 = i6;
        i6 = i7;
        break;
        int i10 = d_();
        i3 = i1;
        i5 = i1;
        i1 = i3;
        i4 = i2;
        for (;;)
        {
          i2 = i4;
          i3 = i5;
          if (i4 >= i10) {
            break;
          }
          if (i4 == i10 - 1)
          {
            i1 = i6 + i9 + i7;
            i2 = i4;
            i3 = i5;
            break;
          }
          i8 = i6 + (i9 + i7);
          i7 = a(i4 + 1);
          i6 = a(i4 + 1, i8);
          i2 = i4;
          i3 = i5;
          i1 = i6;
          if (this.jdField_a_of_type_Int < i6) {
            break;
          }
          i4 += 1;
          i5 = i6;
          i1 = i6;
          i6 = i8;
        }
        i4 = i3;
        i3 = i1;
        i1 = i4;
        break label210;
        if (this.jdField_a_of_type_Int < i1 - i4)
        {
          this.jdField_c_of_type_Int = i2;
          this.jdField_d_of_type_Int = i2;
          break label277;
        }
        this.jdField_c_of_type_Int = i2;
        this.jdField_d_of_type_Int = (i2 + 1);
        this.jdField_l_of_type_Float = ((1.0F + (i1 - this.jdField_a_of_type_Int) / f2) * 0.5F);
        break label277;
        this.jdField_c_of_type_Int = i2;
        this.jdField_d_of_type_Int = i2;
        break label277;
        if (this.jdField_d_of_type_Int < d_() - i8) {
          break label302;
        }
        i2 = super.d_() - i8 - 1;
        this.jdField_c_of_type_Int = i2;
        this.jdField_d_of_type_Int = i2;
        break label302;
      }
      return bool;
    }
  }
  
  public float a()
  {
    return this.h;
  }
  
  public int a(int paramInt)
  {
    View localView = super.getChildAt(paramInt - s());
    if (localView != null) {
      return localView.getHeight();
    }
    return c(paramInt, b(paramInt));
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i1 = super.m();
    int i2 = super.n();
    if ((paramInt1 <= i1) || (paramInt1 >= d_() - i2)) {
      return paramInt2;
    }
    i2 = super.x();
    int i4 = this.jdField_l_of_type_Int - this.jdField_k_of_type_Int;
    int i3 = b(paramInt1);
    int i5 = a(paramInt1);
    if (this.jdField_d_of_type_Int <= this.jdField_e_of_type_Int) {
      if ((paramInt1 == this.jdField_d_of_type_Int) && (this.jdField_c_of_type_Int != this.jdField_d_of_type_Int)) {
        if (paramInt1 == this.jdField_e_of_type_Int) {
          i1 = paramInt2 + i5 - this.jdField_l_of_type_Int;
        }
      }
    }
    while (paramInt1 <= this.jdField_e_of_type_Int)
    {
      return (this.jdField_l_of_type_Int - i2 - b(paramInt1 - 1)) / 2 + i1;
      i1 = i5 - i3 + paramInt2 - i4;
      continue;
      i1 = paramInt2;
      if (paramInt1 > this.jdField_d_of_type_Int)
      {
        i1 = paramInt2;
        if (paramInt1 <= this.jdField_e_of_type_Int)
        {
          i1 = paramInt2 - i4;
          continue;
          if ((paramInt1 > this.jdField_e_of_type_Int) && (paramInt1 <= this.jdField_c_of_type_Int))
          {
            i1 = paramInt2 + i4;
          }
          else
          {
            i1 = paramInt2;
            if (paramInt1 == this.jdField_d_of_type_Int)
            {
              i1 = paramInt2;
              if (this.jdField_c_of_type_Int != this.jdField_d_of_type_Int) {
                i1 = paramInt2 + (i5 - i3);
              }
            }
          }
        }
      }
    }
    return (i3 - i2 - this.jdField_l_of_type_Int) / 2 + i1;
  }
  
  public View a(int paramInt1, int paramInt2)
  {
    paramInt1 -= super.s();
    if ((paramInt1 >= 0) && (paramInt1 <= getChildCount()))
    {
      View localView = super.getChildAt(paramInt1);
      if (localView != null) {
        return localView.findViewById(paramInt2);
      }
    }
    return null;
  }
  
  public ShaderAnimLayout a(int paramInt)
  {
    paramInt -= super.s();
    if ((paramInt >= 0) && (paramInt <= super.getChildCount()))
    {
      View localView = super.getChildAt(paramInt);
      if (localView != null) {
        return (ShaderAnimLayout)localView.findViewById(2131296816);
      }
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_j_of_type_Int == 4)
    {
      this.jdField_a_of_type_Rhj.a(true);
      c();
      g();
      O();
      if (this.jdField_u_of_type_Boolean) {
        this.jdField_j_of_type_Int = 3;
      }
    }
    else
    {
      return;
    }
    this.jdField_j_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    a(paramInt, 0.0F);
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if ((this.jdField_j_of_type_Int == 0) || (this.jdField_j_of_type_Int == 4))
    {
      if (this.jdField_j_of_type_Int == 0)
      {
        this.jdField_e_of_type_Int = (m() + paramInt);
        this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
        this.jdField_d_of_type_Int = this.jdField_e_of_type_Int;
        this.jdField_b_of_type_Int = this.jdField_e_of_type_Int;
        View localView = super.getChildAt(this.jdField_e_of_type_Int - s());
        if (localView != null) {
          localView.setVisibility(4);
        }
      }
      this.jdField_j_of_type_Int = 1;
      this.jdField_f_of_type_Float = paramFloat;
      if (this.jdField_u_of_type_Boolean) {
        switch (this.bf)
        {
        }
      }
    }
    while (this.jdField_a_of_type_Rho != null)
    {
      this.jdField_a_of_type_Rho.c();
      return;
      super.onTouchEvent(this.jdField_a_of_type_AndroidViewMotionEvent);
      continue;
      super.onInterceptTouchEvent(this.jdField_a_of_type_AndroidViewMotionEvent);
    }
    j(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener != null)
    {
      int i1 = a_().getCount();
      if ((paramInt1 >= 0) && (paramInt1 < i1) && (paramInt2 >= 0) && (paramInt2 < i1)) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener.a_(paramInt1, paramInt2);
      }
    }
  }
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    this.w = true;
    R();
    int i1 = this.jdField_c_of_type_Int;
    int i2 = this.jdField_d_of_type_Int;
    boolean bool = t();
    if (bool)
    {
      O();
      setSelectionFromTop(paramInt, a(paramInt, paramView, i1, i2) + paramView.getTop() - getPaddingTop());
      v_();
    }
    if ((bool) || (paramBoolean)) {
      invalidate();
    }
    this.w = false;
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = s();
    int i2 = getChildCount() / 2;
    View localView = getChildAt(getChildCount() / 2);
    if (localView == null) {
      return;
    }
    a(i1 + i2, localView, paramBoolean);
  }
  
  public boolean a()
  {
    return this.z;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!this.jdField_u_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager == null)) {}
    View localView;
    do
    {
      return false;
      localView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager.a(paramInt1);
    } while (localView == null);
    return a(paramInt1, localView, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    if ((this.jdField_j_of_type_Int != 0) || (!this.jdField_u_of_type_Boolean) || (this.jdField_a_of_type_AndroidViewView != null) || (paramView == null) || (!this.jdField_d_of_type_Boolean))
    {
      bool = false;
      return bool;
    }
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramInt1 = m() + paramInt1;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_j_of_type_Int = 4;
    this.bb = 0;
    this.bb |= paramInt2;
    this.jdField_a_of_type_AndroidViewView = paramView;
    P();
    this.aQ = paramInt3;
    this.jdField_f_of_type_Int = paramInt4;
    this.ba = this.n;
    this.jdField_a_of_type_AndroidGraphicsPoint.x = (this.aY - this.aQ);
    this.jdField_a_of_type_AndroidGraphicsPoint.y = (this.n - this.jdField_f_of_type_Int);
    paramView = getChildAt(this.jdField_e_of_type_Int - s());
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    if (this.v) {
      this.jdField_a_of_type_Rhk.a();
    }
    switch (this.bf)
    {
    }
    for (;;)
    {
      requestLayout();
      if (this.jdField_a_of_type_Rhn == null) {
        break;
      }
      this.jdField_a_of_type_Rhn.c();
      return true;
      super.onTouchEvent(this.jdField_a_of_type_AndroidViewMotionEvent);
      continue;
      super.onInterceptTouchEvent(this.jdField_a_of_type_AndroidViewMotionEvent);
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getAction();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_j_of_type_Int == 4) {
        a();
      }
      G();
      continue;
      if (this.jdField_j_of_type_Int == 4) {
        a(false);
      }
      G();
      continue;
      g((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    return b(paramBoolean, 0.0F);
  }
  
  public boolean a(boolean paramBoolean, float paramFloat)
  {
    this.jdField_a_of_type_Boolean = true;
    return b(paramBoolean, paramFloat);
  }
  
  public ListAdapter a_()
  {
    if (this.jdField_a_of_type_Rhh == null) {
      return null;
    }
    return this.jdField_a_of_type_Rhh.a();
  }
  
  public int b(int paramInt)
  {
    int i1 = 0;
    if (paramInt == this.jdField_e_of_type_Int) {}
    do
    {
      return i1;
      localObject = getChildAt(paramInt - s());
      if (localObject != null) {
        return a(paramInt, (View)localObject, false);
      }
      i2 = this.jdField_a_of_type_Rhm.a(paramInt);
      i1 = i2;
    } while (i2 != -1);
    Object localObject = a();
    i1 = ((ListAdapter)localObject).getItemViewType(paramInt);
    int i2 = ((ListAdapter)localObject).getViewTypeCount();
    if (i2 != this.jdField_a_of_type_ArrayOfAndroidViewView.length) {
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[i2];
    }
    if (i1 >= 0) {
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[i1] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i1] = localObject;
      }
    }
    for (;;)
    {
      i1 = a(paramInt, (View)localObject, true);
      this.jdField_a_of_type_Rhm.a(paramInt, i1);
      return i1;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.jdField_a_of_type_ArrayOfAndroidViewView[i1], this);
      continue;
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    SparseBooleanArray localSparseBooleanArray = a();
    int i2;
    if (paramInt2 < paramInt1) {
      i2 = paramInt1;
    }
    for (int i1 = paramInt2;; i1 = paramInt1)
    {
      int i3 = i2 + 1;
      int[] arrayOfInt1 = new int[localSparseBooleanArray.size()];
      int[] arrayOfInt2 = new int[localSparseBooleanArray.size()];
      i2 = a(localSparseBooleanArray, i1, i3, arrayOfInt1, arrayOfInt2);
      if ((i2 == 1) && (arrayOfInt1[0] == arrayOfInt2[0])) {}
      for (;;)
      {
        return;
        if (paramInt1 < paramInt2)
        {
          paramInt1 = 0;
          while (paramInt1 != i2)
          {
            setItemChecked(a(arrayOfInt1[paramInt1], -1, i1, i3), true);
            setItemChecked(a(arrayOfInt2[paramInt1], -1, i1, i3), false);
            paramInt1 += 1;
          }
        }
        else
        {
          paramInt1 = 0;
          while (paramInt1 != i2)
          {
            setItemChecked(arrayOfInt1[paramInt1], false);
            setItemChecked(arrayOfInt2[paramInt1], true);
            paramInt1 += 1;
          }
        }
      }
      i2 = paramInt2;
    }
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean b(boolean paramBoolean, float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Rhj.a(true);
      if (paramBoolean) {
        a(this.jdField_e_of_type_Int - m(), paramFloat);
      }
      for (;;)
      {
        if (this.v) {
          this.jdField_a_of_type_Rhk.d();
        }
        return true;
        if (this.jdField_a_of_type_Rhl != null) {
          this.jdField_a_of_type_Rhl.c();
        } else {
          h();
        }
      }
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager.a(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewView = null;
      invalidate();
    }
  }
  
  public void c(int paramInt)
  {
    SparseBooleanArray localSparseBooleanArray = a();
    if (localSparseBooleanArray.size() == 0) {}
    for (;;)
    {
      return;
      int[] arrayOfInt1 = new int[localSparseBooleanArray.size()];
      int[] arrayOfInt2 = new int[localSparseBooleanArray.size()];
      int i2 = localSparseBooleanArray.keyAt(localSparseBooleanArray.size() - 1) + 1;
      int i3 = a(localSparseBooleanArray, paramInt, i2, arrayOfInt1, arrayOfInt2);
      int i1 = 0;
      while (i1 != i3)
      {
        if ((arrayOfInt1[i1] != paramInt) && ((arrayOfInt2[i1] >= arrayOfInt1[i1]) || (arrayOfInt2[i1] <= paramInt))) {
          setItemChecked(a(arrayOfInt1[i1], -1, paramInt, i2), true);
        }
        setItemChecked(a(arrayOfInt2[i1], -1, paramInt, i2), false);
        i1 += 1;
      }
    }
  }
  
  public void d()
  {
    if (this.F) {}
    Object localObject;
    ProgressCircle localProgressCircle;
    do
    {
      do
      {
        return;
        localObject = a(this.jdField_e_of_type_Int);
      } while (localObject == null);
      ((ShaderAnimLayout)localObject).a();
      this.F = true;
      localObject = (RelativeLayout)a(this.jdField_e_of_type_Int, 2131298225);
      localProgressCircle = (ProgressCircle)((RelativeLayout)localObject).findViewById(2131297484);
    } while ((((RelativeLayout)localObject).getVisibility() != 0) || (localProgressCircle.getVisibility() != 0));
    ((RelativeLayout)localObject).setVisibility(8);
    this.jdField_t_of_type_Int = this.jdField_e_of_type_Int;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_j_of_type_Int != 0)
    {
      if (this.jdField_c_of_type_Int != this.jdField_e_of_type_Int) {
        a(this.jdField_c_of_type_Int, paramCanvas);
      }
      if ((this.jdField_d_of_type_Int != this.jdField_c_of_type_Int) && (this.jdField_d_of_type_Int != this.jdField_e_of_type_Int)) {
        a(this.jdField_d_of_type_Int, paramCanvas);
      }
    }
    int i3;
    int i4;
    int i1;
    float f1;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      i3 = this.jdField_a_of_type_AndroidViewView.getWidth();
      i4 = this.jdField_a_of_type_AndroidViewView.getHeight();
      int i2 = this.jdField_a_of_type_AndroidGraphicsPoint.x;
      int i5 = getWidth();
      i1 = i2;
      if (i2 < 0) {
        i1 = -i2;
      }
      if (i1 >= i5) {
        break label216;
      }
      f1 = (i5 - i1) / i5;
    }
    label216:
    for (f1 *= f1;; f1 = 0.0F)
    {
      i1 = (int)(f1 * (255.0F * this.h));
      paramCanvas.save();
      paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      paramCanvas.clipRect(0, 0, i3, i4);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, i3, i4, i1, 31);
      this.jdField_a_of_type_AndroidViewView.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
    }
  }
  
  public void e()
  {
    Object localObject = a(this.jdField_e_of_type_Int);
    if (localObject != null)
    {
      ((ShaderAnimLayout)localObject).d();
      this.F = false;
      if (this.jdField_t_of_type_Int >= 0)
      {
        localObject = (RelativeLayout)a(this.jdField_t_of_type_Int, 2131298225);
        if ((localObject != null) && (((ProgressCircle)((RelativeLayout)localObject).findViewById(2131297484)).getVisibility() == 0)) {
          ((RelativeLayout)localObject).setVisibility(0);
        }
      }
    }
  }
  
  public void f()
  {
    Object localObject = a(this.jdField_e_of_type_Int);
    if (localObject != null)
    {
      ((ShaderAnimLayout)localObject).e();
      this.F = false;
      if (this.jdField_t_of_type_Int >= 0)
      {
        localObject = (RelativeLayout)a(this.jdField_t_of_type_Int, 2131298225);
        if (((ProgressCircle)((RelativeLayout)localObject).findViewById(2131297484)).getVisibility() == 0) {
          ((RelativeLayout)localObject).setVisibility(0);
        }
      }
    }
  }
  
  public boolean f_()
  {
    return this.jdField_a_of_type_Rhj.a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.v) {
      this.jdField_a_of_type_Rhk.b();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1;
    int i2;
    boolean bool2;
    if (!this.jdField_d_of_type_Boolean)
    {
      i1 = (int)paramMotionEvent.getRawX();
      i2 = (int)paramMotionEvent.getRawY();
      if (this.F)
      {
        paramMotionEvent = a(this.jdField_e_of_type_Int);
        if (paramMotionEvent == null) {
          bool2 = false;
        }
      }
    }
    do
    {
      return bool2;
      if (a(paramMotionEvent, i1, i2)) {
        this.A = true;
      }
      do
      {
        for (;;)
        {
          return true;
          e();
          this.C = false;
        }
        paramMotionEvent = (Button)a(this.jdField_u_of_type_Int, 2131298187);
        if (paramMotionEvent == null) {
          return false;
        }
      } while (!a(paramMotionEvent, i1, i2));
      this.B = true;
      return false;
      i1 = b((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      ImageView localImageView = a(i1);
      if ((localImageView != null) && (a(localImageView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())))
      {
        if ((this.F) && (this.jdField_e_of_type_Int != i1))
        {
          this.D = false;
          return true;
        }
        this.jdField_e_of_type_Int = i1;
        this.D = true;
        return true;
      }
      if (this.F)
      {
        i1 = (int)paramMotionEvent.getRawX();
        i2 = (int)paramMotionEvent.getRawY();
        paramMotionEvent = a(this.jdField_e_of_type_Int);
        if (paramMotionEvent == null) {
          return false;
        }
        if (a(paramMotionEvent, i1, i2)) {
          this.A = true;
        }
        return true;
      }
      a(paramMotionEvent);
      this.jdField_t_of_type_Boolean = true;
      i1 = paramMotionEvent.getAction() & 0xFF;
      if (i1 == 0)
      {
        if (this.jdField_j_of_type_Int != 0)
        {
          this.x = true;
          return true;
        }
        this.jdField_u_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break label319;
      }
      bool1 = true;
      if (i1 == 1) {
        break;
      }
      bool2 = bool1;
    } while (i1 != 3);
    this.jdField_u_of_type_Boolean = false;
    return bool1;
    label319:
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.z = true;
    }
    for (boolean bool1 = true;; bool1 = false) {
      switch (i1)
      {
      case 2: 
      default: 
        if (bool1) {
          this.bf = 1;
        }
        break;
      case 1: 
      case 3: 
        G();
        break;
        this.bf = 2;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_AndroidViewView.isLayoutRequested()) {
        P();
      }
      this.jdField_b_of_type_Boolean = true;
    }
    this.aV = paramInt1;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    N();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.x)
    {
      this.x = false;
      bool2 = bool1;
    }
    do
    {
      return bool2;
      if (!this.jdField_d_of_type_Boolean)
      {
        if (paramMotionEvent.getAction() == 0)
        {
          if (this.F)
          {
            if (this.A) {
              if (this.y)
              {
                f();
                a(this.jdField_e_of_type_Int);
                this.A = false;
              }
            }
            for (;;)
            {
              this.F = false;
              return false;
              if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener != null) {
                this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener.a(this.jdField_e_of_type_Int);
              }
              this.A = false;
              return false;
              e();
            }
          }
          Button localButton = (Button)a(this.jdField_u_of_type_Int, 2131298187);
          if ((this.B) && (localButton != null))
          {
            this.B = false;
            this.C = true;
            return false;
          }
          if (!this.C)
          {
            this.C = true;
            return true;
          }
        }
        try
        {
          bool1 = super.onTouchEvent(paramMotionEvent);
          return bool1;
        }
        catch (ArrayIndexOutOfBoundsException paramMotionEvent)
        {
          for (;;)
          {
            paramMotionEvent.printStackTrace();
            bool1 = false;
          }
        }
      }
      if (paramMotionEvent.getAction() == 0)
      {
        if (this.D)
        {
          if (this.F)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LeftEventListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LeftEventListener.a(this.jdField_e_of_type_Int);
            }
            paramMotionEvent = a(this.jdField_e_of_type_Int);
            if (paramMotionEvent != null)
            {
              this.F = false;
              paramMotionEvent.d();
            }
          }
          for (;;)
          {
            this.D = false;
            return false;
            if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LeftEventListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LeftEventListener.b(this.jdField_e_of_type_Int);
            }
            paramMotionEvent = a(this.jdField_e_of_type_Int);
            if (paramMotionEvent != null)
            {
              this.F = true;
              paramMotionEvent.a();
            }
          }
        }
        if (this.F)
        {
          if (this.A) {
            if (!this.jdField_e_of_type_Boolean)
            {
              f();
              a(this.jdField_e_of_type_Int);
              this.A = false;
            }
          }
          for (;;)
          {
            this.F = false;
            return false;
            if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener.a(this.jdField_e_of_type_Int);
            }
            this.A = false;
            return false;
            e();
          }
        }
      }
      bool1 = this.jdField_t_of_type_Boolean;
      this.jdField_t_of_type_Boolean = false;
      if (!bool1) {
        a(paramMotionEvent);
      }
      if (this.jdField_j_of_type_Int == 4)
      {
        a(paramMotionEvent);
        return true;
      }
      bool1 = bool2;
      if (this.jdField_j_of_type_Int == 0)
      {
        bool1 = bool2;
        if (super.onTouchEvent(paramMotionEvent)) {
          bool1 = true;
        }
      }
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        bool2 = bool1;
      }
    } while (!bool1);
    this.bf = 1;
    return bool1;
    G();
    return bool1;
  }
  
  public void requestLayout()
  {
    if (!this.w) {
      super.requestLayout();
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (paramListAdapter != null)
    {
      this.jdField_a_of_type_Rhh = new rhh(this, paramListAdapter);
      paramListAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      if ((paramListAdapter instanceof DragSortListView.DropListener)) {
        setDropListener((DragSortListView.DropListener)paramListAdapter);
      }
      if ((paramListAdapter instanceof DragSortListView.DragListener)) {
        setDragListener((DragSortListView.DragListener)paramListAdapter);
      }
      if ((paramListAdapter instanceof DragSortListView.RemoveListener)) {
        setRemoveListener((DragSortListView.RemoveListener)paramListAdapter);
      }
    }
    for (;;)
    {
      super.setAdapter(this.jdField_a_of_type_Rhh);
      return;
      this.jdField_a_of_type_Rhh = null;
    }
  }
  
  public void setDelImmediately(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.F = false;
    this.A = false;
    this.D = false;
  }
  
  public void setDragListener(DragSortListView.DragListener paramDragListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragListener = paramDragListener;
  }
  
  public void setDragScrollProfile(DragSortListView.DragScrollProfile paramDragScrollProfile)
  {
    if (paramDragScrollProfile != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScrollProfile = paramDragScrollProfile;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    setDragScrollStarts(paramFloat, paramFloat);
  }
  
  public void setDragScrollStarts(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 > 0.5F)
    {
      this.jdField_j_of_type_Float = 0.5F;
      if (paramFloat1 <= 0.5F) {
        break label46;
      }
    }
    label46:
    for (this.i = 0.5F;; this.i = paramFloat1)
    {
      if (getHeight() != 0) {
        N();
      }
      return;
      this.jdField_j_of_type_Float = paramFloat2;
      break;
    }
  }
  
  public void setDragSortListener(DragSortListView.DragSortListener paramDragSortListener)
  {
    setDropListener(paramDragSortListener);
    setDragListener(paramDragSortListener);
    setRemoveListener(paramDragSortListener);
  }
  
  public void setDropListener(DragSortListView.DropListener paramDropListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener = paramDropListener;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public void setFloatViewManager(DragSortListView.FloatViewManager paramFloatViewManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager = paramFloatViewManager;
  }
  
  public void setLeftEventListener(DragSortListView.LeftEventListener paramLeftEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LeftEventListener = paramLeftEventListener;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.jdField_e_of_type_Float = paramFloat;
  }
  
  public void setRemoveListener(DragSortListView.RemoveListener paramRemoveListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener = paramRemoveListener;
  }
  
  public void setSrcPos(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void setTapPos(int paramInt)
  {
    this.jdField_u_of_type_Int = paramInt;
  }
  
  public void v_()
  {
    super.v_();
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if ((this.jdField_a_of_type_AndroidViewView.isLayoutRequested()) && (!this.jdField_b_of_type_Boolean)) {
        P();
      }
      this.jdField_a_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_b_of_type_Boolean = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\view\DragSortListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */