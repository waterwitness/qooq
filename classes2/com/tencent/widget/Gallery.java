package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import com.tencent.image.GifDrawable;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.GalleryURLImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.PhotoUtils;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.util.VersionUtils;
import xse;
import xtd;
import xte;
import xtf;
import xtg;
import xth;

public class Gallery
  extends AbsSpinner
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
{
  private static final int D = -1;
  private static final int E = 0;
  private static final int F = 1;
  private static final int G = 2;
  private static int P = 20;
  public static final float a = 2.0F;
  public static final int a = 2131296388;
  private static RectF jdField_a_of_type_AndroidGraphicsRectF;
  private static final String jdField_a_of_type_JavaLangString = "Gallery";
  public static float b = 0.0F;
  public static final int b = 2131296385;
  protected static Rect b;
  public static final int c = 2131296386;
  private static final boolean jdField_d_of_type_Boolean = false;
  public static final int j = 2131296389;
  private static final float jdField_k_of_type_Float = 1.5F;
  public static final int k = 2131296390;
  public static final int l = 2131296391;
  public static final int m = 2131296392;
  public static final int n = 101;
  public static final int o = 102;
  public static final int p = 0;
  public static final int q = 1;
  public static final int r = 2;
  public static final int s = 3;
  private static final int jdField_t_of_type_Int;
  private static final int jdField_u_of_type_Int;
  private static final int jdField_v_of_type_Int = 0;
  private static final int jdField_w_of_type_Int = 250;
  private int A;
  private int B;
  private int C;
  private int H = -1;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private int O;
  double jdField_a_of_type_Double = 0.0D;
  public long a;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, this);
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  public View a;
  private AdapterView.AdapterContextMenuInfo jdField_a_of_type_ComTencentWidgetAdapterView$AdapterContextMenuInfo;
  Gallery.OnItemRotateListener jdField_a_of_type_ComTencentWidgetGallery$OnItemRotateListener;
  public Gallery.OnScollListener a;
  private ScaleGestureDetector jdField_a_of_type_ComTencentWidgetScaleGestureDetector;
  private Runnable jdField_a_of_type_JavaLangRunnable = new xtd(this);
  private xtf jdField_a_of_type_Xtf = new xtf(this);
  private View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float = 0.0F;
  boolean jdField_c_of_type_Boolean = true;
  float jdField_d_of_type_Float;
  float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean;
  float jdField_f_of_type_Float;
  private boolean jdField_f_of_type_Boolean = true;
  float jdField_g_of_type_Float;
  private boolean jdField_g_of_type_Boolean = true;
  private float jdField_h_of_type_Float;
  long jdField_h_of_type_Long;
  private boolean jdField_h_of_type_Boolean;
  private float jdField_i_of_type_Float = 1.0F;
  private boolean jdField_i_of_type_Boolean;
  private float jdField_j_of_type_Float = jdField_b_of_type_Float;
  private boolean jdField_j_of_type_Boolean;
  private boolean jdField_k_of_type_Boolean;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean jdField_t_of_type_Boolean;
  private boolean jdField_u_of_type_Boolean;
  private boolean jdField_v_of_type_Boolean;
  private boolean jdField_w_of_type_Boolean;
  private int jdField_x_of_type_Int;
  private boolean jdField_x_of_type_Boolean = true;
  private int jdField_y_of_type_Int = 400;
  private boolean jdField_y_of_type_Boolean = true;
  private int jdField_z_of_type_Int;
  private boolean jdField_z_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_t_of_type_Int = a("Gallery_spacing");
    jdField_u_of_type_Int = a("Gallery_animationDuration");
    jdField_b_of_type_AndroidGraphicsRect = new Rect();
    jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    jdField_b_of_type_Float = 2.0F;
  }
  
  public Gallery(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Gallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842864);
  }
  
  public Gallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.w = true;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(true);
    this.jdField_a_of_type_AndroidViewGestureDetector.setOnDoubleTapListener(this);
    this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector = new ScaleGestureDetector(paramContext, this);
    paramAttributeSet = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, a("Gallery"), paramInt, 0));
    paramInt = paramAttributeSet.a(jdField_u_of_type_Int, -1);
    if (paramInt > 0) {
      setAnimationDuration(paramInt);
    }
    setSpacing(paramAttributeSet.d(jdField_t_of_type_Int, 0));
    paramAttributeSet.a();
    if (!VersionUtils.e()) {
      setStaticTransformationsEnabled(true);
    }
    this.C = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    this.jdField_h_of_type_Float = TypedValue.applyDimension(1, 2400.0F, paramContext.getResources().getDisplayMetrics());
    setFadingEdgeLength(0);
  }
  
  private double a(float paramFloat1, float paramFloat2)
  {
    double d2 = Math.atan(paramFloat2 / paramFloat1);
    double d1;
    if (paramFloat1 < 0.0F) {
      d1 = d2 + 3.141592653589793D;
    }
    do
    {
      return d1;
      d1 = d2;
    } while (d2 >= 0.0D);
    return d2 + 6.283185307179586D;
  }
  
  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    int i2 = 1;
    int i3 = 0;
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 1.0F;
    }
    int i4 = paramInt2 * paramInt3 / paramInt1;
    int i5 = URLDrawableHelper.e;
    boolean bool = PhotoUtils.a(paramInt1, paramInt2);
    int i1 = i3;
    if (paramObject != null)
    {
      i1 = i3;
      if ((paramObject instanceof AIOImageData))
      {
        if ((((AIOImageData)paramObject).j & 0x1) != 1) {
          break label128;
        }
        i1 = i2;
      }
    }
    float f1;
    if (((bool) && (paramInt1 <= paramInt3) && (paramInt2 <= paramInt4)) || ((paramInt1 < i5) && (paramInt2 < i5)) || ((i1 != 0) && (paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))) {
      f1 = 1.0F;
    }
    for (;;)
    {
      return Math.min(f1, 2.0F);
      label128:
      i1 = 0;
      break;
      if (paramInt4 >= i4) {
        f1 = paramInt3 / paramInt1;
      } else {
        f1 = paramInt4 / paramInt2;
      }
    }
  }
  
  private int a()
  {
    return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft();
  }
  
  private Matrix a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if (VersionUtils.e()) {
      return paramView.getMatrix();
    }
    return xth.a(a(paramView));
  }
  
  private Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    int i2 = getMeasuredWidth();
    int i1 = getMeasuredHeight();
    switch (paramInt3 & 0x70)
    {
    default: 
      i1 = 0;
      switch (paramInt3 & 0x7)
      {
      case 4: 
      default: 
        paramInt3 = (i2 - this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidGraphicsRect.right - paramInt1) / 2;
        if (paramBoolean)
        {
          paramInt3 = paramInt4 + paramInt3;
          paramInt4 = paramInt3 + paramInt1;
          paramInt1 = paramInt3;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      localRect.left = paramInt1;
      localRect.top = i1;
      localRect.right = paramInt4;
      localRect.bottom = (i1 + paramInt2);
      return localRect;
      i1 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      break;
      int i3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      int i4 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      int i5 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      i1 = (i1 - i3 - i4 - paramInt2) / 2 + i5;
      break;
      i1 = i1 - this.jdField_a_of_type_AndroidGraphicsRect.bottom - paramInt2;
      break;
      if (paramBoolean)
      {
        paramInt3 = paramInt4;
        paramInt4 += paramInt1;
        paramInt1 = paramInt3;
      }
      else
      {
        paramInt1 = paramInt4 - paramInt1;
        continue;
        paramInt1 = paramInt4 - paramInt1 - paramInt3;
        paramInt4 -= paramInt3;
      }
    }
  }
  
  private Rect a(View paramView)
  {
    if (paramView == null) {
      return new Rect();
    }
    Rect localRect = new Rect();
    jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    if (VersionUtils.e()) {}
    for (Matrix localMatrix = paramView.getMatrix();; localMatrix = xth.a(a(paramView)))
    {
      localMatrix.mapRect(jdField_a_of_type_AndroidGraphicsRectF);
      jdField_a_of_type_AndroidGraphicsRectF.offset(paramView.getLeft(), paramView.getTop());
      jdField_a_of_type_AndroidGraphicsRectF.round(localRect);
      return localRect;
    }
  }
  
  private Rect a(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      paramView = new Rect();
    }
    do
    {
      return paramView;
      jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
      a(paramView).mapRect(jdField_a_of_type_AndroidGraphicsRectF);
      jdField_a_of_type_AndroidGraphicsRectF.offset(paramView.getLeft(), paramView.getTop());
      jdField_a_of_type_AndroidGraphicsRectF.round(paramRect);
      paramView = paramRect;
    } while (paramRect.width() >= this.J);
    int i1 = (this.J - paramRect.width()) / 2;
    int i2 = this.J;
    int i3 = paramRect.width();
    paramRect.set(paramRect.left - i1, paramRect.top, i2 - i3 - i1 + paramRect.right, paramRect.bottom);
    return paramRect;
  }
  
  private View a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, View paramView)
  {
    Object localObject2;
    if (!this.r)
    {
      localObject2 = this.jdField_a_of_type_Xse.a(paramInt1);
      if (localObject2 != null)
      {
        paramInt1 = ((View)localObject2).getLeft();
        this.A = Math.max(this.A, ((View)localObject2).getMeasuredWidth() + paramInt1);
        this.jdField_z_of_type_Int = Math.min(this.jdField_z_of_type_Int, paramInt1);
        a((View)localObject2, paramInt2, paramInt3, paramBoolean, true);
      }
    }
    Object localObject1;
    do
    {
      return (View)localObject2;
      localObject2 = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getView(paramInt1, null, this);
      a(paramInt1, this, paramBoolean, false);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = getContext();
        localObject1 = new ImageView((Context)localObject2);
        ((ImageView)localObject1).setImageDrawable(((Context)localObject2).getResources().getDrawable(2130843491));
      }
      a((View)localObject1, paramInt2, paramInt3, paramBoolean, false);
      localObject2 = localObject1;
    } while (paramView == null);
    a(paramView, (View)localObject1);
    return (View)localObject1;
  }
  
  private xtg a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    xtg localxtg = new xtg(null);
    if (paramView.getTag(2131296389) != null) {}
    for (int i3 = ((Integer)paramView.getTag(2131296389)).intValue();; i3 = 0)
    {
      localxtg.jdField_a_of_type_Int = i3;
      if (paramView.getTag(2131296386) != null)
      {
        localxtg.jdField_a_of_type_Float = ((Float)paramView.getTag(2131296386)).floatValue();
        localxtg.b = 17;
        return localxtg;
      }
      int i2;
      int i1;
      if (i3 != 1)
      {
        i2 = paramInt1;
        i1 = paramInt2;
        if (i3 != 3) {}
      }
      else
      {
        i1 = paramInt1;
        i2 = paramInt2;
      }
      if ((paramView instanceof AIOGalleryAdapter.GalleryURLImageView))
      {
        localObject = ((AIOGalleryAdapter.GalleryURLImageView)paramView).a;
        if (localObject == null) {}
      }
      for (Object localObject = ((AIORichMediaInfo)localObject).a;; localObject = null)
      {
        float f1 = a(i2, i1, paramInt3, paramInt4, localObject);
        if (i1 >= i2 * 3)
        {
          paramInt1 = 1;
          if ((paramInt1 == 0) || ((i2 <= paramInt3) && (i1 <= paramInt4)) || ((i2 < URLDrawableHelper.e) && (i1 < URLDrawableHelper.e))) {
            break label305;
          }
          localxtg.b = 49;
          localxtg.jdField_a_of_type_Float = Math.min(paramInt3 / i2, this.jdField_j_of_type_Float);
          localxtg.jdField_a_of_type_Boolean = true;
          paramView.setTag(2131296392, Float.valueOf(f1));
        }
        for (;;)
        {
          if ((!VersionUtils.e()) && ((paramView instanceof ImageView)))
          {
            paramView = ((ImageView)paramView).getDrawable();
            if (((paramView instanceof URLDrawable)) && ((((URLDrawable)paramView).getCurrDrawable() instanceof GifDrawable)) && (localxtg.jdField_a_of_type_Float > 1.0F)) {
              localxtg.jdField_a_of_type_Float = 1.0F;
            }
          }
          return localxtg;
          paramInt1 = 0;
          break;
          label305:
          localxtg.b = 17;
          localxtg.jdField_a_of_type_Boolean = false;
          localxtg.jdField_a_of_type_Float = f1;
        }
      }
    }
  }
  
  private xth a(View paramView)
  {
    xth localxth2 = (xth)paramView.getTag(2131296388);
    xth localxth1 = localxth2;
    if (localxth2 == null)
    {
      localxth1 = new xth();
      paramView.setTag(2131296388, localxth1);
    }
    if (localxth1.jdField_a_of_type_Boolean) {
      a(localxth1);
    }
    return localxth1;
  }
  
  private void a(float paramFloat)
  {
    int i1 = getChildCount();
    if ((i1 == 0) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    View localView = getChildAt(0);
    float f2;
    if (i1 == 1)
    {
      f2 = b(this.jdField_a_of_type_AndroidViewView);
      if (this.jdField_a_of_type_AndroidViewView.getTag(2131296389) == null) {
        break label829;
      }
    }
    label101:
    label268:
    label338:
    label380:
    label489:
    label569:
    label604:
    label684:
    label826:
    label829:
    for (i1 = ((Integer)this.jdField_a_of_type_AndroidViewView.getTag(2131296389)).intValue();; i1 = 0)
    {
      float f1;
      float f3;
      int i2;
      float f5;
      float f6;
      int i3;
      if ((this.jdField_a_of_type_AndroidViewView.getTag(2131296392) instanceof Float))
      {
        f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296392)).floatValue();
        f3 = c(this.jdField_a_of_type_AndroidViewView);
        i2 = b((int)f3, i1);
        f5 = c((int)f3, i2);
        f6 = i2 * 90;
        i3 = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
        int i4 = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
        int i5 = getMeasuredWidth();
        int i6 = getMeasuredHeight();
        if (paramFloat != 0.0F) {
          break label826;
        }
        if (i2 == i1) {
          break label489;
        }
        this.jdField_a_of_type_AndroidViewView.setTag(2131296389, Integer.valueOf(i2));
        xtg localxtg = a(i3, i4, i5, i6, this.jdField_a_of_type_AndroidViewView);
        f1 = localxtg.jdField_a_of_type_Float;
        this.jdField_a_of_type_AndroidViewView.setTag(2131296385, Float.valueOf(localxtg.jdField_a_of_type_Float));
        paramFloat = f1;
        if (this.jdField_a_of_type_ComTencentWidgetGallery$OnItemRotateListener != null)
        {
          this.jdField_a_of_type_ComTencentWidgetGallery$OnItemRotateListener.a(this.jdField_a_of_type_AndroidViewView, r(), i2);
          paramFloat = f1;
        }
      }
      for (;;)
      {
        i2 = 0;
        i1 = 0;
        if ((f2 != paramFloat) || (f6 != f5))
        {
          a(this.jdField_a_of_type_AndroidViewView, paramFloat);
          b(this.jdField_a_of_type_AndroidViewView, f6);
          a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
          a(this.jdField_a_of_type_AndroidViewView, f2);
          b(this.jdField_a_of_type_AndroidViewView, f5);
          if (jdField_b_of_type_AndroidGraphicsRect.right >= this.J + this.jdField_a_of_type_AndroidGraphicsRect.left) {
            break label569;
          }
          i2 = this.J + this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.right;
          if (jdField_b_of_type_AndroidGraphicsRect.height() >= this.K) {
            break label604;
          }
          i1 = this.jdField_a_of_type_AndroidGraphicsRect.top + (this.K - jdField_b_of_type_AndroidGraphicsRect.height()) / 2 - jdField_b_of_type_AndroidGraphicsRect.top;
        }
        for (;;)
        {
          if ((f2 == paramFloat) && (f6 == f5)) {
            break label684;
          }
          this.jdField_a_of_type_Xtf.a(i2, i1, f2, paramFloat, f5, f6);
          return;
          if (!(this.jdField_a_of_type_AndroidViewView.getTag(2131296385) instanceof Float)) {
            break;
          }
          f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
          break label101;
          f3 = Math.min(f1, this.jdField_i_of_type_Float);
          float f4 = Math.max(f1, this.jdField_j_of_type_Float);
          if (Math.abs(f2 - f1) < 1.0E-5D)
          {
            paramFloat = f1;
            break label268;
          }
          paramFloat = f3;
          if (f2 < f3) {
            break label268;
          }
          if (f2 > f4)
          {
            paramFloat = f4;
            break label268;
          }
          paramFloat = f2;
          break label268;
          a(localView, jdField_b_of_type_AndroidGraphicsRect);
          break label338;
          if (jdField_b_of_type_AndroidGraphicsRect.left <= this.jdField_a_of_type_AndroidGraphicsRect.left) {
            break label380;
          }
          i2 = this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.left;
          break label380;
          if (jdField_b_of_type_AndroidGraphicsRect.top > this.jdField_a_of_type_AndroidGraphicsRect.top) {
            i1 = this.jdField_a_of_type_AndroidGraphicsRect.top - jdField_b_of_type_AndroidGraphicsRect.top;
          } else if (jdField_b_of_type_AndroidGraphicsRect.bottom < this.K + this.jdField_a_of_type_AndroidGraphicsRect.top) {
            i1 = this.K + this.jdField_a_of_type_AndroidGraphicsRect.top - jdField_b_of_type_AndroidGraphicsRect.bottom;
          }
        }
        this.jdField_a_of_type_Xtf.a(i2, i1);
        return;
        if (jdField_b_of_type_AndroidGraphicsRect.right + this.jdField_x_of_type_Int / 2 > this.jdField_a_of_type_AndroidGraphicsRect.left + this.J / 2)
        {
          a(localView, jdField_b_of_type_AndroidGraphicsRect);
          i1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
          i2 = this.J;
          i3 = jdField_b_of_type_AndroidGraphicsRect.right;
          this.jdField_a_of_type_Xtf.a(i1 + i2 - i3, 0);
          return;
        }
        a(localView, jdField_b_of_type_AndroidGraphicsRect);
        i1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
        i2 = jdField_b_of_type_AndroidGraphicsRect.right;
        i3 = this.jdField_x_of_type_Int;
        this.jdField_a_of_type_Xtf.a(i1 - i2 - i3, 0);
        return;
      }
    }
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
    float f1 = this.jdField_a_of_type_AndroidViewView.getLeft();
    float f2 = this.jdField_a_of_type_AndroidViewView.getTop();
    a(this.jdField_a_of_type_AndroidViewView).invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (paramFloat1 - f1);
    arrayOfFloat[1] = (paramFloat2 - f2);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(arrayOfFloat);
    int i3 = jdField_b_of_type_AndroidGraphicsRect.width() / 2;
    int i4 = jdField_b_of_type_AndroidGraphicsRect.left;
    int i1 = jdField_b_of_type_AndroidGraphicsRect.height() / 2;
    int i2 = jdField_b_of_type_AndroidGraphicsRect.top;
    a(this.jdField_a_of_type_AndroidViewView, arrayOfFloat[0], arrayOfFloat[1]);
    a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
    i3 = i3 + i4 - (jdField_b_of_type_AndroidGraphicsRect.width() / 2 + jdField_b_of_type_AndroidGraphicsRect.left);
    i1 = i1 + i2 - (jdField_b_of_type_AndroidGraphicsRect.height() / 2 + jdField_b_of_type_AndroidGraphicsRect.top);
    if (VersionUtils.e())
    {
      a(this.jdField_a_of_type_AndroidViewView, i3, i1);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(i3);
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(i1);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, View paramView)
  {
    int i1 = paramView.getMeasuredWidth();
    int i2 = paramView.getMeasuredHeight();
    if ((i2 == 0) || (i1 == 0)) {}
    xtg localxtg;
    do
    {
      return;
      localxtg = a(i1, i2, paramInt1, paramInt2, paramView);
    } while (localxtg == null);
    a(paramView, localxtg.b, paramInt3, paramBoolean);
    float f1 = localxtg.jdField_a_of_type_Float;
    if ((localxtg.jdField_a_of_type_Boolean) && (e())) {
      d(true);
    }
    Rect localRect;
    if (f1 != 0.0F)
    {
      a(paramView, 0.0F, 0.0F);
      a(paramView, f1);
      b(paramView, localxtg.jdField_a_of_type_Int * 90);
      a(paramView, jdField_b_of_type_AndroidGraphicsRect);
      localRect = a(jdField_b_of_type_AndroidGraphicsRect.width(), jdField_b_of_type_AndroidGraphicsRect.height(), localxtg.b, paramInt3, paramBoolean);
      if (!VersionUtils.e()) {
        break label226;
      }
      a(paramView, localRect.left - jdField_b_of_type_AndroidGraphicsRect.left, localRect.top - jdField_b_of_type_AndroidGraphicsRect.top);
    }
    for (;;)
    {
      paramView.setTag(2131296385, Float.valueOf(localxtg.jdField_a_of_type_Float));
      paramView.setTag(2131296389, Integer.valueOf(localxtg.jdField_a_of_type_Int));
      return;
      label226:
      paramView.offsetLeftAndRight(localRect.left - jdField_b_of_type_AndroidGraphicsRect.left);
      paramView.offsetTopAndBottom(localRect.top - jdField_b_of_type_AndroidGraphicsRect.top);
    }
  }
  
  private void a(View paramView)
  {
    if (paramView != null) {
      paramView.setPressed(true);
    }
    setPressed(true);
  }
  
  private void a(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        if (!VersionUtils.e()) {
          break;
        }
        paramView.setScaleX(paramFloat);
        paramView.setScaleY(paramFloat);
      } while (isHardwareAccelerated());
      invalidate();
      return;
      paramView = a(paramView);
    } while (paramView.d == paramFloat);
    paramView.d = paramFloat;
    paramView.jdField_e_of_type_Float = paramFloat;
    paramView.jdField_a_of_type_Boolean = true;
    invalidate();
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {}
    xth localxth;
    do
    {
      return;
      if (VersionUtils.e())
      {
        paramView.setPivotX(paramFloat1);
        paramView.setPivotY(paramFloat2);
        return;
      }
      localxth = a(paramView);
    } while ((localxth.jdField_f_of_type_Float == paramFloat1) && (localxth.jdField_g_of_type_Float == paramFloat2));
    localxth.jdField_f_of_type_Float = paramFloat1;
    localxth.jdField_g_of_type_Float = paramFloat2;
    localxth.jdField_a_of_type_Boolean = true;
    paramView.invalidate();
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (VersionUtils.e())
    {
      paramView.setPivotX(paramFloat1);
      paramView.setPivotY(paramFloat2);
      paramView.setScaleX(paramFloat3);
      paramView.setScaleY(paramFloat3);
      if (!isHardwareAccelerated()) {
        invalidate();
      }
    }
    xth localxth;
    do
    {
      return;
      localxth = a(paramView);
    } while (localxth.d == paramFloat3);
    localxth.jdField_f_of_type_Float = paramFloat1;
    localxth.jdField_g_of_type_Float = paramFloat2;
    localxth.d = paramFloat3;
    localxth.jdField_e_of_type_Float = paramFloat3;
    localxth.jdField_a_of_type_Boolean = true;
    paramView.invalidate();
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    if (VersionUtils.e())
    {
      paramView.setTranslationX(paramView.getTranslationX() + paramInt1);
      paramView.setTranslationY(paramView.getTranslationY() + paramInt2);
      return;
    }
    xth localxth = a(paramView);
    localxth.jdField_b_of_type_Float += paramInt1;
    localxth.jdField_c_of_type_Float += paramInt2;
    localxth.jdField_a_of_type_Boolean = true;
    paramView.invalidate();
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Rect localRect = a(paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), paramInt1, paramInt2, paramBoolean);
    paramView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramView == null) {
      return;
    }
    boolean bool;
    label12:
    label23:
    int i1;
    label42:
    Gallery.LayoutParams localLayoutParams;
    if (paramInt1 == 0)
    {
      bool = true;
      if (bool == paramView.isSelected()) {
        break label136;
      }
      paramInt1 = 1;
      if ((paramBoolean2) && (paramInt1 == 0) && (!paramView.isLayoutRequested())) {
        break label141;
      }
      i1 = 1;
      localLayoutParams = (Gallery.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams != null) {
        break label153;
      }
      localLayoutParams = (Gallery.LayoutParams)generateDefaultLayoutParams();
    }
    label136:
    label141:
    label153:
    for (;;)
    {
      if (paramBoolean1) {}
      for (int i2 = -1;; i2 = 0)
      {
        addViewInLayout(paramView, i2, localLayoutParams, true);
        if (paramInt1 != 0) {
          paramView.setSelected(bool);
        }
        if (i1 == 0) {
          break;
        }
        paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        a(this.J, this.K, paramInt2, paramBoolean1, paramView);
        return;
        bool = false;
        break label12;
        paramInt1 = 0;
        break label23;
        i1 = 0;
        break label42;
      }
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    if (paramView1 != paramView2)
    {
      if (VersionUtils.e()) {
        a(paramView2, paramView1.getPivotX(), paramView1.getPivotY(), paramView1.getScaleX());
      }
    }
    else {
      return;
    }
    paramView2.setTag(2131296388, (xth)paramView1.getTag(2131296388));
  }
  
  private void a(xth paramxth)
  {
    if (paramxth == null) {}
    while (!paramxth.jdField_a_of_type_Boolean) {
      return;
    }
    xth.a(paramxth).reset();
    xth.a(paramxth).setTranslate(paramxth.jdField_b_of_type_Float, paramxth.jdField_c_of_type_Float);
    xth.a(paramxth).preRotate(paramxth.jdField_a_of_type_Float, paramxth.jdField_f_of_type_Float, paramxth.jdField_g_of_type_Float);
    xth.a(paramxth).preScale(paramxth.d, paramxth.jdField_e_of_type_Float, paramxth.jdField_f_of_type_Float, paramxth.jdField_g_of_type_Float);
    paramxth.jdField_a_of_type_Boolean = false;
    xth.a(paramxth, xth.a(paramxth).isIdentity());
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    View localView;
    int i1;
    int i2;
    Rect localRect;
    do
    {
      do
      {
        return;
        localView = this.jdField_a_of_type_AndroidViewView;
        i1 = getMeasuredWidth();
        i2 = getMeasuredHeight();
      } while ((i1 == 0) || (i2 == 0));
      localRect = new Rect();
      a(localView, localRect);
    } while (!localRect.intersect(0, 0, i1, i2));
    localRect.offset(-localView.getLeft(), -localView.getTop());
    a(localView).invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
    Object localObject = new RectF(localRect);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect((RectF)localObject);
    ((RectF)localObject).round(localRect);
    jdField_b_of_type_AndroidGraphicsRect.set(0, 0, localView.getWidth(), localView.getHeight());
    localRect.intersect(jdField_b_of_type_AndroidGraphicsRect);
    float f1 = b(localView);
    localObject = new RegionDrawableData();
    ((RegionDrawableData)localObject).mImageArea = jdField_b_of_type_AndroidGraphicsRect;
    ((RegionDrawableData)localObject).mShowArea = localRect;
    ((RegionDrawableData)localObject).mScale = f1;
    ((RegionDrawableData)localObject).mState = paramInt;
    ((RegionDrawableData)localObject).mShowRegion = paramBoolean;
    ((RegionDrawableData)localObject).mScrollDirection = this.I;
    if (this.jdField_a_of_type_AndroidViewView.getTag(2131296392) != null) {
      ((RegionDrawableData)localObject).mDefaultScale = ((Float)localView.getTag(2131296392)).floatValue();
    }
    for (;;)
    {
      a(this.aF, localView, (RegionDrawableData)localObject);
      return;
      if (localView.getTag(2131296385) != null) {
        ((RegionDrawableData)localObject).mDefaultScale = ((Float)localView.getTag(2131296385)).floatValue();
      }
    }
  }
  
  private float[] a(View paramView)
  {
    float f2;
    if (VersionUtils.e()) {
      f2 = paramView.getTranslationX();
    }
    for (float f1 = paramView.getTranslationY();; f1 = paramView.jdField_c_of_type_Float)
    {
      return new float[] { f2, f1 };
      paramView = a(paramView);
      f2 = paramView.jdField_b_of_type_Float;
    }
  }
  
  private float b(View paramView)
  {
    if (VersionUtils.e()) {
      return paramView.getScaleX();
    }
    return a(paramView).d;
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      paramInt1 = (-paramInt1 + 360) / 360 * 360 + paramInt1;
    }
    for (;;)
    {
      int i1 = paramInt1;
      if (paramInt1 > 360) {
        i1 = paramInt1 % 360;
      }
      paramInt1 = P;
      if ((paramInt2 == 1) || (paramInt2 == 3)) {
        paramInt1 = 90 - P;
      }
      paramInt2 = 180 - paramInt1;
      int i2 = paramInt1 + 180;
      int i3 = 360 - paramInt1;
      if (((i1 >= 0) && (i1 < paramInt1)) || (i1 >= i3)) {
        return 0;
      }
      if ((i1 >= paramInt1) && (i1 < paramInt2)) {
        return 1;
      }
      if ((i1 >= paramInt2) && (i1 < i2)) {
        return 2;
      }
      if ((i1 >= i2) && (i1 < i3)) {
        return 3;
      }
      return 0;
    }
  }
  
  private void b(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    do
    {
      return;
      if (VersionUtils.e())
      {
        paramView.setRotation(paramFloat);
        return;
      }
      paramView = a(paramView);
    } while (paramView.jdField_a_of_type_Float == paramFloat);
    paramView.jdField_a_of_type_Float = paramFloat;
    paramView.jdField_a_of_type_Boolean = true;
  }
  
  private boolean b(View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener != null) {}
    for (boolean bool1 = this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener.a(this, this.jdField_b_of_type_AndroidViewView, paramInt, paramLong);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        this.jdField_a_of_type_ComTencentWidgetAdapterView$AdapterContextMenuInfo = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
        bool2 = super.showContextMenuForChild(this);
      }
      if (bool2) {
        performHapticFeedback(0);
      }
      return bool2;
    }
  }
  
  private float[] b(View paramView)
  {
    float f2;
    if (VersionUtils.e()) {
      f2 = paramView.getPivotX();
    }
    for (float f1 = paramView.getPivotY();; f1 = a(paramView).jdField_g_of_type_Float)
    {
      return new float[] { f2, f1 };
      f2 = a(paramView).jdField_f_of_type_Float;
    }
  }
  
  private float c(View paramView)
  {
    if (VersionUtils.e()) {
      return paramView.getRotation();
    }
    return a(paramView).jdField_a_of_type_Float;
  }
  
  private static int c(int paramInt1, int paramInt2)
  {
    if (paramInt1 < -45) {
      paramInt1 = (-paramInt1 + 360) / 360 * 360 + paramInt1;
    }
    label86:
    for (;;)
    {
      int i1 = paramInt1 - paramInt2 * 90;
      if (i1 > 180) {
        paramInt2 = paramInt1 - 360;
      }
      do
      {
        return paramInt2;
        if (paramInt1 < 275) {
          break label86;
        }
        paramInt1 -= (paramInt1 + 360) / 360 * 360;
        break;
        paramInt2 = paramInt1;
      } while (i1 >= 65356);
      return paramInt1 + 360;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i3 = 0;
    int i2 = 0;
    int i7 = getChildCount();
    int i6 = this.au;
    int i4;
    int i5;
    View localView;
    if (paramBoolean)
    {
      i8 = getPaddingLeft();
      i1 = 0;
      i4 = 0;
      i3 = i2;
      i2 = i4;
      for (;;)
      {
        i4 = i2;
        i5 = i3;
        if (i1 < i7)
        {
          localView = getChildAt(i1);
          if (a(localView, jdField_b_of_type_AndroidGraphicsRect).right > i8)
          {
            i5 = i3;
            i4 = i2;
          }
        }
        else
        {
          detachViewsFromParent(i5, i4);
          if (paramBoolean) {
            this.au = (i4 + this.au);
          }
          return;
        }
        i2 += 1;
        this.jdField_a_of_type_Xse.a(i6 + i1, localView);
        a(i6 + i1, localView, this, paramBoolean);
        a(i6 + i1 + 1, this, paramBoolean, true);
        i3 = i1;
        i1 += 1;
      }
    }
    int i8 = getWidth();
    int i9 = getPaddingRight();
    int i1 = i7 - 1;
    i2 = 0;
    for (;;)
    {
      i4 = i2;
      i5 = i3;
      if (i1 < 0) {
        break;
      }
      localView = getChildAt(i1);
      i4 = i2;
      i5 = i3;
      if (a(localView, jdField_b_of_type_AndroidGraphicsRect).left < i8 - i9) {
        break;
      }
      this.jdField_a_of_type_Xse.a(i6 + i1, localView);
      a(i6 + i1, localView, this, paramBoolean);
      a(i6 + i1 - 1, this, paramBoolean, true);
      i2 += 1;
      i3 = i1;
      i1 -= 1;
    }
  }
  
  private static int d(View paramView)
  {
    return paramView.getLeft() + paramView.getWidth() / 2;
  }
  
  private void d(boolean paramBoolean)
  {
    a(paramBoolean, 0);
  }
  
  private boolean e()
  {
    if (!VersionUtils.e()) {}
    Object localObject;
    do
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_AndroidViewView == null);
      localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    } while ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 102));
    if (this.jdField_a_of_type_AndroidViewView.getWidth() * this.jdField_a_of_type_AndroidViewView.getHeight() >= this.L * this.M << 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void g()
  {
    a(0.0F);
  }
  
  private void h()
  {
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_h_of_type_Boolean = false;
      super.f_();
    }
    invalidate();
  }
  
  private void i()
  {
    int i1;
    if (this.N > 0)
    {
      i1 = getChildCount() - 1;
      this.N = a(getChildAt(i1), jdField_b_of_type_AndroidGraphicsRect).left;
      i1 += this.au;
      this.O = 0;
    }
    for (;;)
    {
      if (i1 != this.aF)
      {
        h(i1);
        i(i1);
        A();
      }
      return;
      if (this.N < 0)
      {
        i1 = this.au;
        this.N = a(getChildAt(0), jdField_b_of_type_AndroidGraphicsRect).left;
        this.O = 0;
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  private void j()
  {
    if (getChildCount() >= 2) {}
    for (;;)
    {
      return;
      int i3 = this.jdField_x_of_type_Int;
      int i4 = getPaddingLeft();
      int i5 = this.J;
      View localView = getChildAt(0);
      int i1;
      int i2;
      if (localView != null)
      {
        i1 = this.au - 1;
        i2 = a(localView, jdField_b_of_type_AndroidGraphicsRect).left - i3;
      }
      while ((i2 > i4) && (i1 >= 0))
      {
        a(i1, i1 - this.aF, i2, false, null);
        if (this.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener != null) {
          this.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener.b(i1);
        }
        this.au = i1;
        i2 -= i5 + i3;
        i1 -= 1;
        continue;
        i2 = getRight() - getLeft() - getPaddingRight();
        this.jdField_e_of_type_Boolean = true;
        i1 = 0;
      }
    }
  }
  
  private void k()
  {
    int i1 = getChildCount();
    if (i1 >= 2) {}
    for (;;)
    {
      return;
      int i3 = this.jdField_x_of_type_Int;
      int i4 = getRight();
      int i5 = getLeft();
      int i6 = getPaddingRight();
      int i7 = this.J;
      int i8 = this.aG;
      View localView = getChildAt(i1 - 1);
      int i2;
      if (localView != null)
      {
        i1 = this.au + i1;
        i2 = a(localView, jdField_b_of_type_AndroidGraphicsRect).right + i3;
      }
      while ((i2 < i4 - i5 - i6) && (i1 < i8))
      {
        a(i1, i1 - this.aF, i2, true, null);
        if (this.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener != null) {
          this.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener.b(i1);
        }
        i2 += i7 + i3;
        i1 += 1;
        continue;
        i1 = this.aG - 1;
        this.au = i1;
        i2 = getPaddingLeft();
        this.jdField_e_of_type_Boolean = true;
      }
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void n()
  {
    this.H = -1;
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(true);
  }
  
  private void o()
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      getChildAt(i1).setPressed(false);
      i1 -= 1;
    }
    setPressed(false);
  }
  
  private void p()
  {
    View localView1 = this.jdField_a_of_type_AndroidViewView;
    View localView2 = getChildAt(this.aF - this.au);
    this.jdField_a_of_type_AndroidViewView = localView2;
    if (localView2 == null) {}
    do
    {
      return;
      localView2.setSelected(true);
      localView2.setFocusable(true);
      if (hasFocus()) {
        localView2.requestFocus();
      }
    } while ((localView1 == null) || (localView1 == localView2));
    localView1.setSelected(false);
    localView1.setFocusable(false);
  }
  
  public float a(View paramView)
  {
    return this.jdField_j_of_type_Float;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        a(localView, jdField_b_of_type_AndroidGraphicsRect);
        if (jdField_b_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2)) {
          return i1 + this.au;
        }
      }
      i1 -= 1;
    }
    return -1;
  }
  
  protected int a(boolean paramBoolean, int paramInt1, int paramInt2, Point paramPoint)
  {
    if (paramBoolean) {}
    View localView2;
    for (int i1 = this.aG - 1;; i1 = 0)
    {
      localView2 = getChildAt(i1 - this.au);
      if ((localView2 != null) || (this.H == 1) || (((!paramBoolean) || (!this.m)) && ((paramBoolean) || (!this.l)))) {
        break label158;
      }
      if ((this.H != 0) && (Math.abs(paramInt1) <= Math.abs(paramInt2))) {
        break;
      }
      paramPoint.jdField_x_of_type_Int = paramInt1;
      paramPoint.jdField_y_of_type_Int = 0;
      this.H = 0;
      return this.H;
    }
    a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
    if (jdField_b_of_type_AndroidGraphicsRect.height() < this.K)
    {
      paramPoint.jdField_x_of_type_Int = 0;
      paramPoint.jdField_y_of_type_Int = 0;
      return this.H;
    }
    this.m = false;
    this.l = false;
    label158:
    if (this.H != 0) {
      this.H = 1;
    }
    View localView1;
    if ((!paramBoolean) || (this.m))
    {
      localView1 = localView2;
      if (!paramBoolean)
      {
        localView1 = localView2;
        if (this.l) {}
      }
    }
    else
    {
      localView1 = this.jdField_a_of_type_AndroidViewView;
    }
    a(localView1, jdField_b_of_type_AndroidGraphicsRect);
    int i2;
    if (paramBoolean)
    {
      i2 = this.J - this.jdField_a_of_type_AndroidGraphicsRect.right - jdField_b_of_type_AndroidGraphicsRect.right;
      if (i2 > 0) {
        i1 = paramInt1 / 4;
      }
    }
    for (;;)
    {
      if (paramInt2 < 0)
      {
        paramInt1 = 1;
        label257:
        if (jdField_b_of_type_AndroidGraphicsRect.height() >= this.K) {
          break label380;
        }
        paramInt1 = 0;
        label272:
        if (i1 <= this.J) {
          break label491;
        }
        paramInt2 = this.J;
      }
      for (;;)
      {
        paramPoint.jdField_x_of_type_Int = paramInt2;
        paramPoint.jdField_y_of_type_Int = paramInt1;
        return this.H;
        i1 = paramInt1;
        if (paramInt1 >= i2) {
          break;
        }
        i1 = (paramInt1 - i2) / 4 + i2;
        break;
        i1 = this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.left;
        if (i1 < 0)
        {
          i1 = paramInt1 / 4;
          break;
        }
        if (paramInt1 <= i1) {
          break label516;
        }
        i1 = (paramInt1 - i1) / 4 + i1;
        break;
        paramInt1 = 0;
        break label257;
        label380:
        if (paramInt1 != 0)
        {
          i2 = this.K - this.jdField_a_of_type_AndroidGraphicsRect.bottom - jdField_b_of_type_AndroidGraphicsRect.bottom;
          if (i2 > 0)
          {
            paramInt1 = paramInt2 / 4;
            break label272;
          }
          paramInt1 = paramInt2;
          if (i1 >= i2) {
            break label272;
          }
          paramInt1 = (paramInt2 - i2) / 6 + i2;
          break label272;
        }
        i2 = this.jdField_a_of_type_AndroidGraphicsRect.top - jdField_b_of_type_AndroidGraphicsRect.top;
        if (i2 < 0)
        {
          paramInt1 = paramInt2 / 4;
          break label272;
        }
        paramInt1 = paramInt2;
        if (i1 <= i2) {
          break label272;
        }
        paramInt1 = (paramInt2 - i2) / 6 + i2;
        break label272;
        label491:
        if (i1 < -this.J) {
          paramInt2 = -this.J;
        } else {
          paramInt2 = i1;
        }
      }
      label516:
      i1 = paramInt1;
    }
  }
  
  public Gallery.OnItemRotateListener a()
  {
    return this.jdField_a_of_type_ComTencentWidgetGallery$OnItemRotateListener;
  }
  
  public Gallery.OnScollListener a()
  {
    return this.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((getChildCount() == 0) || ((paramInt1 == 0) && (paramInt2 == 0))) {
      return;
    }
    boolean bool;
    if (paramInt1 < 0)
    {
      bool = true;
      if (paramInt1 != 0) {
        break label96;
      }
      this.I = 0;
      label32:
      if (!paramBoolean) {
        break label116;
      }
      a(bool, paramInt1, paramInt2, this.jdField_a_of_type_AndroidGraphicsPoint);
      label49:
      paramInt1 = getChildCount() - 1;
      label56:
      if (paramInt1 < 0) {
        break label153;
      }
      if (!VersionUtils.e()) {
        break label135;
      }
      a(getChildAt(paramInt1), this.jdField_a_of_type_AndroidGraphicsPoint.jdField_x_of_type_Int, 0);
    }
    for (;;)
    {
      paramInt1 -= 1;
      break label56;
      bool = false;
      break;
      label96:
      if (paramInt1 < 0)
      {
        this.I = 1;
        break label32;
      }
      this.I = 2;
      break label32;
      label116:
      this.jdField_a_of_type_AndroidGraphicsPoint.jdField_x_of_type_Int = paramInt1;
      this.jdField_a_of_type_AndroidGraphicsPoint.jdField_y_of_type_Int = paramInt2;
      break label49;
      label135:
      getChildAt(paramInt1).offsetLeftAndRight(this.jdField_a_of_type_AndroidGraphicsPoint.jdField_x_of_type_Int);
    }
    label153:
    this.N += this.jdField_a_of_type_AndroidGraphicsPoint.jdField_x_of_type_Int;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.H != 0))
    {
      if (VersionUtils.e())
      {
        a(this.jdField_a_of_type_AndroidViewView, 0, this.jdField_a_of_type_AndroidGraphicsPoint.jdField_y_of_type_Int);
        this.O += this.jdField_a_of_type_AndroidGraphicsPoint.jdField_y_of_type_Int;
      }
    }
    else
    {
      c(bool);
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break label349;
      }
      if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
        break label325;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      label246:
      if ((bool) && (this.m)) {
        k();
      }
      for (;;)
      {
        this.jdField_a_of_type_Xse.a();
        if (paramInt1 != 0) {
          i();
        }
        onScrollChanged(0, 0, 0, 0);
        invalidate();
        return;
        View localView = this.jdField_a_of_type_AndroidViewView;
        if (this.H == 0) {}
        for (paramInt1 = 0;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsPoint.jdField_y_of_type_Int)
        {
          localView.offsetTopAndBottom(paramInt1);
          break;
        }
        label325:
        paramInt1 = 0;
        break label246;
        if ((!bool) && (this.l)) {
          j();
        }
      }
      label349:
      paramInt1 = 0;
    }
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  protected void a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  public void a(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData) {}
  
  protected void a(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f1;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_AndroidViewView.getTag(2131296392) == null) {
        break label81;
      }
      f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296392)).floatValue();
      float f2 = b(this.jdField_a_of_type_AndroidViewView);
      if ((f2 <= f1) || (f2 > this.jdField_j_of_type_Float)) {
        break label116;
      }
      if (!e()) {
        break label100;
      }
      d(true);
    }
    for (;;)
    {
      n();
      this.jdField_c_of_type_Boolean = true;
      return;
      label81:
      f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
      break;
      label100:
      b(this.aF, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      label116:
      d(false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public boolean a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.H == 0)) {}
    Drawable localDrawable;
    do
    {
      return false;
      if ((VersionUtils.e()) || (!(this.jdField_a_of_type_AndroidViewView instanceof ImageView))) {
        break;
      }
      localDrawable = ((ImageView)this.jdField_a_of_type_AndroidViewView).getDrawable();
    } while (((localDrawable instanceof URLDrawable)) && ((((URLDrawable)localDrawable).getCurrDrawable() instanceof GifDrawable)));
    this.jdField_a_of_type_Double = a(paramScaleGestureDetector.d(), paramScaleGestureDetector.e());
    this.jdField_c_of_type_Float = c(this.jdField_a_of_type_AndroidViewView);
    float f1 = 1.0F;
    if (this.jdField_a_of_type_AndroidViewView.getTag(2131296392) != null)
    {
      f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296392)).floatValue();
      if (b(this.jdField_a_of_type_AndroidViewView) > f1 + 1.0E-5F) {
        break label261;
      }
    }
    label261:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      f1 = paramScaleGestureDetector.a();
      float f2 = paramScaleGestureDetector.b();
      this.l = false;
      this.m = false;
      a(f1, f2);
      this.d = f1;
      this.jdField_e_of_type_Float = f2;
      this.jdField_f_of_type_Float = paramScaleGestureDetector.c();
      this.jdField_g_of_type_Float = b(this.jdField_a_of_type_AndroidViewView);
      this.k = true;
      if (e()) {
        d(false);
      }
      return true;
      if (this.jdField_a_of_type_AndroidViewView.getTag(2131296385) == null) {
        break;
      }
      f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
      break;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.l = false;
    this.m = false;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag(2131296385);
    if ((localObject == null) || (!(localObject instanceof Float))) {
      return false;
    }
    float f1 = ((Float)localObject).floatValue();
    float f2 = b(this.jdField_a_of_type_AndroidViewView);
    if ((f2 < f1) || ((Math.abs(f2 - f1) < 1.0E-5D) && (!paramBoolean))) {
      return false;
    }
    a(f1 * this.jdField_i_of_type_Float);
    return true;
  }
  
  int b(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  protected void b(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  void b(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (this.r) {
      s();
    }
    if (this.aG == 0)
    {
      b();
      return;
    }
    paramInt = getChildCount();
    int i1 = this.aF - this.au;
    if ((i1 >= 0) && (i1 < paramInt)) {}
    for (View localView = getChildAt(i1);; localView = null)
    {
      if (this.aE >= 0)
      {
        paramInt = this.aE;
        paramInt = this.aF;
      }
      if (this.aE >= 0) {
        h(this.aE);
      }
      c();
      detachAllViewsFromParent();
      if (this.v)
      {
        this.jdField_a_of_type_Xse.a();
        this.O = 0;
        this.N = 0;
        localView = null;
      }
      this.A = 0;
      this.jdField_z_of_type_Int = 0;
      this.au = this.aF;
      if ((a().hasStableIds()) && (localView != null) && (this.jdField_e_of_type_Long == this.jdField_g_of_type_Long))
      {
        paramInt = 1;
        i1 = this.aF;
        int i2 = this.N;
        if (paramInt != 0) {
          localObject = localView;
        }
        a(i1, 0, i2, true, (View)localObject);
        if (this.N >= 0) {
          break label277;
        }
        k();
      }
      for (;;)
      {
        if (this.jdField_e_of_type_Boolean)
        {
          this.N = 0;
          this.O = 0;
        }
        this.jdField_a_of_type_Xse.a();
        invalidate();
        A();
        this.r = false;
        this.p = false;
        i(this.aF);
        p();
        return;
        paramInt = 0;
        break;
        label277:
        j();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_x_of_type_Boolean = paramBoolean;
  }
  
  boolean b()
  {
    return false;
  }
  
  public boolean b(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.H == 0)) {
      return false;
    }
    float f1 = paramScaleGestureDetector.a();
    float f2 = paramScaleGestureDetector.b();
    float f3 = f1 - this.d;
    float f4 = f2 - this.jdField_e_of_type_Float;
    this.d = f1;
    this.jdField_e_of_type_Float = f2;
    if (VersionUtils.e())
    {
      a(this.jdField_a_of_type_AndroidViewView, (int)f3, (int)f4);
      a(f1, f2);
      f3 = paramScaleGestureDetector.c() / this.jdField_f_of_type_Float;
      f2 = f3 * this.jdField_g_of_type_Float;
      if (this.jdField_a_of_type_AndroidViewView.getTag(2131296392) == null) {
        break label289;
      }
      f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296392)).floatValue();
      label125:
      if (f2 >= f1 * f1 * 0.6F) {
        break label308;
      }
      f1 = f1 * f1 * 0.6F;
    }
    for (;;)
    {
      label145:
      a(this.jdField_a_of_type_AndroidViewView, f1 * paramScaleGestureDetector.i());
      Boolean localBoolean = (Boolean)this.jdField_a_of_type_AndroidViewView.getTag(2131296390);
      if ((this.jdField_z_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (localBoolean != null) && (localBoolean.booleanValue()))
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label331;
        }
        f2 = (float)((a(paramScaleGestureDetector.d(), paramScaleGestureDetector.e()) - this.jdField_a_of_type_Double) / 3.141592653589793D * 180.0D);
        f1 = f2;
        if (f2 > 180.0F) {
          f1 = f2 - 360.0F;
        }
        b(this.jdField_a_of_type_AndroidViewView, f1 + this.jdField_c_of_type_Float);
      }
      for (;;)
      {
        return true;
        this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight((int)f3);
        this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom((int)f4);
        break;
        label289:
        f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
        break label125;
        label308:
        if (f2 <= this.jdField_j_of_type_Float * 1.5F) {
          break label422;
        }
        f1 = this.jdField_j_of_type_Float * 1.5F;
        break label145;
        label331:
        if (f3 <= 0.95F)
        {
          this.jdField_b_of_type_Boolean = true;
          f2 = (float)((a(paramScaleGestureDetector.d(), paramScaleGestureDetector.e()) - this.jdField_a_of_type_Double) / 3.141592653589793D * 180.0D);
          f1 = f2;
          if (f2 > 180.0F) {
            f1 = f2 - 360.0F;
          }
          b(this.jdField_a_of_type_AndroidViewView, f1 + this.jdField_c_of_type_Float);
        }
        else if (f3 >= 1.05F)
        {
          this.jdField_c_of_type_Boolean = false;
        }
      }
      label422:
      f1 = f2;
    }
  }
  
  boolean c()
  {
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof Gallery.LayoutParams;
  }
  
  protected int computeHorizontalScrollExtent()
  {
    return 1;
  }
  
  protected int computeHorizontalScrollOffset()
  {
    return this.aF;
  }
  
  protected int computeHorizontalScrollRange()
  {
    return this.aG;
  }
  
  void d()
  {
    Object localObject;
    if ((!VersionUtils.e()) && ((this.jdField_a_of_type_AndroidViewView instanceof ImageView)))
    {
      localObject = ((ImageView)this.jdField_a_of_type_AndroidViewView).getDrawable();
      if ((!(localObject instanceof URLDrawable)) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof GifDrawable))) {}
    }
    for (int i1 = 1;; i1 = 0)
    {
      float f1;
      if ((this.jdField_t_of_type_Boolean) && (i1 == 0))
      {
        this.l = false;
        this.m = false;
        if (this.jdField_a_of_type_AndroidViewView == null) {
          return;
        }
        if (this.jdField_a_of_type_AndroidViewView.getTag(2131296392) != null) {
          f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296392)).floatValue();
        }
      }
      for (;;)
      {
        float f2 = b(this.jdField_a_of_type_AndroidViewView);
        if (Math.abs(f2 - f1) >= 1.0E-5D)
        {
          if (f2 >= f1) {
            break label514;
          }
          if (!e()) {
            b(this.aF, this.jdField_a_of_type_AndroidViewView, this);
          }
          label157:
          a(f1);
          label162:
          this.jdField_t_of_type_Boolean = false;
          o();
          if (!this.n) {
            break;
          }
          this.n = false;
          this.I = 0;
          if (!e()) {
            break;
          }
          d(true);
          return;
          if (this.jdField_a_of_type_AndroidViewView.getTag(2131296385) == null) {
            break label567;
          }
          f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
          continue;
        }
        int i5 = getMeasuredWidth();
        int i6 = getMeasuredHeight();
        if (this.jdField_a_of_type_AndroidViewView.getTag(2131296389) != null) {}
        for (i1 = ((Integer)this.jdField_a_of_type_AndroidViewView.getTag(2131296389)).intValue();; i1 = 0)
        {
          int i2;
          label303:
          int i3;
          label320:
          int i4;
          if ((i1 == 1) || (i1 == 3))
          {
            i2 = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
            i1 = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
            if ((i2 > i5) || (i1 > i6)) {
              break label375;
            }
            i3 = 1;
            if (i1 < i2 * 3) {
              break label381;
            }
            i4 = 1;
            label332:
            if (i3 == 0) {
              break label387;
            }
            f1 = this.jdField_j_of_type_Float;
          }
          for (;;)
          {
            f1 = Math.min(f1, this.jdField_j_of_type_Float);
            break;
            i2 = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
            i1 = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
            break label303;
            label375:
            i3 = 0;
            break label320;
            label381:
            i4 = 0;
            break label332;
            label387:
            if (i4 != 0)
            {
              f1 = Math.min(i5 / i2, this.jdField_j_of_type_Float);
            }
            else
            {
              localObject = a(this.jdField_a_of_type_AndroidViewView);
              i3 = ((Rect)localObject).right - ((Rect)localObject).left;
              i4 = ((Rect)localObject).bottom;
              int i7 = ((Rect)localObject).top;
              if (i3 < i5)
              {
                if (i3 * 1.5F >= i5) {
                  f1 *= 2.0F;
                } else {
                  f1 = i5 / i2;
                }
              }
              else if ((i4 - i7) * 1.5F >= i6) {
                f1 *= 2.0F;
              } else {
                f1 = i6 / i1;
              }
            }
          }
          label514:
          if (!e()) {
            break label157;
          }
          d(false);
          break label157;
          if (!xtf.a(this.jdField_a_of_type_Xtf).a()) {
            break label162;
          }
          g();
          if (this.H != 0) {
            break label162;
          }
          this.H = 2;
          break label162;
        }
        label567:
        f1 = 1.0F;
      }
    }
  }
  
  public boolean d()
  {
    return this.jdField_z_of_type_Boolean;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.dispatch(this, null, null);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setPressed(paramBoolean);
    }
  }
  
  public void dispatchSetSelected(boolean paramBoolean) {}
  
  public void e()
  {
    this.N = 0;
  }
  
  void f()
  {
    d();
  }
  
  public void f_()
  {
    if (!this.jdField_h_of_type_Boolean) {
      super.f_();
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new Gallery.LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new Gallery.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new Gallery.LayoutParams(paramLayoutParams);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = this.aF - this.au;
    if (i1 < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return i1;
      }
    } while (paramInt2 < i1);
    return paramInt2 + 1;
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    paramView = (xth)paramView.getTag(2131296388);
    if (paramView != null)
    {
      a(paramView);
      paramTransformation.getMatrix().set(xth.a(paramView));
      return true;
    }
    return false;
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.jdField_a_of_type_ComTencentWidgetAdapterView$AdapterContextMenuInfo;
  }
  
  void h(int paramInt)
  {
    super.h(paramInt);
    p();
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_x_of_type_Boolean) {}
    float f1;
    float f2;
    do
    {
      return true;
      this.jdField_t_of_type_Boolean = true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
    } while (this.jdField_a_of_type_AndroidViewView == null);
    a(f1, f2);
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (this.H == 2) {
      this.H = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Xtf.a(false);
      this.B = a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if (this.B >= 0)
      {
        this.jdField_b_of_type_AndroidViewView = getChildAt(this.B - this.au);
        this.jdField_b_of_type_AndroidViewView.setPressed(true);
      }
      this.jdField_j_of_type_Boolean = true;
      a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
      if (jdField_b_of_type_AndroidGraphicsRect.width() != this.J) {
        break;
      }
      this.m = true;
      this.l = true;
      return true;
      n();
    }
    if (jdField_b_of_type_AndroidGraphicsRect.left == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.l = bool1;
      bool1 = bool2;
      if (jdField_b_of_type_AndroidGraphicsRect.right == this.J) {
        bool1 = true;
      }
      this.m = bool1;
      return true;
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (!this.jdField_h_of_type_Boolean) {
        this.jdField_h_of_type_Boolean = true;
      }
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    paramFloat1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
    paramFloat2 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
    int i1;
    int i2;
    label154:
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    float f1;
    if (getChildCount() <= 1)
    {
      a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
      i1 = this.J + this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.right;
      i2 = this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.left;
      if ((jdField_b_of_type_AndroidGraphicsRect.height() < this.K) && (jdField_b_of_type_AndroidGraphicsRect.width() <= this.J))
      {
        g();
        if (this.H != 0) {
          break label693;
        }
        this.H = 2;
        if (this.n) {
          this.n = false;
        }
        return true;
      }
      if (jdField_b_of_type_AndroidGraphicsRect.height() < this.K)
      {
        i3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        i4 = (this.K - jdField_b_of_type_AndroidGraphicsRect.bottom + jdField_b_of_type_AndroidGraphicsRect.top) / 2;
        i5 = jdField_b_of_type_AndroidGraphicsRect.top;
        i6 = this.K;
        i7 = (this.K - jdField_b_of_type_AndroidGraphicsRect.bottom + jdField_b_of_type_AndroidGraphicsRect.top) / 2;
        i8 = jdField_b_of_type_AndroidGraphicsRect.bottom;
        f1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
        if (f1 <= this.jdField_h_of_type_Float) {
          break label707;
        }
        paramFloat1 = this.jdField_h_of_type_Float * paramFloat1 / f1;
        paramFloat2 = 0.0F;
      }
    }
    label693:
    label707:
    for (;;)
    {
      this.jdField_a_of_type_Xtf.a((int)paramFloat1, (int)paramFloat2, i1, i2, i3 + i4 - i5, i6 - i7 - i8);
      break;
      i3 = this.K;
      i4 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      i5 = jdField_b_of_type_AndroidGraphicsRect.bottom;
      i6 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      i7 = jdField_b_of_type_AndroidGraphicsRect.top;
      f1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
      if (f1 > this.jdField_h_of_type_Float)
      {
        paramFloat1 = paramFloat1 * this.jdField_h_of_type_Float / f1;
        paramFloat2 = paramFloat2 * this.jdField_h_of_type_Float / f1;
      }
      for (;;)
      {
        this.jdField_a_of_type_Xtf.a((int)paramFloat1, (int)paramFloat2, i1, i2, i3 + i4 - i5, i6 - i7);
        break;
        if (paramFloat1 < 0.0F)
        {
          i1 = a(getChildAt(1), jdField_b_of_type_AndroidGraphicsRect).left;
          a(getChildAt(0), jdField_b_of_type_AndroidGraphicsRect);
          if (i1 == 0) {
            return true;
          }
          if (this.jdField_a_of_type_Xtf.a(i1, (int)paramFloat1) <= this.jdField_a_of_type_AndroidGraphicsRect.left)
          {
            this.jdField_a_of_type_Xtf.a((int)paramFloat1, 0, this.jdField_a_of_type_AndroidGraphicsRect.left - i1, Integer.MAX_VALUE, 0, 0);
            break;
          }
          if (paramFloat1 < -this.C)
          {
            this.jdField_a_of_type_Xtf.a(this.jdField_a_of_type_AndroidGraphicsRect.left - i1, 0);
            break;
          }
          g();
          break;
        }
        i1 = this.J + this.jdField_a_of_type_AndroidGraphicsRect.left;
        i2 = a(getChildAt(0), jdField_b_of_type_AndroidGraphicsRect).right;
        if (i2 == i1) {
          return true;
        }
        if (this.jdField_a_of_type_Xtf.a(i2, (int)paramFloat1) >= i1)
        {
          this.jdField_a_of_type_Xtf.a((int)paramFloat1, 0, Integer.MIN_VALUE, i1 - i2, 0, 0);
          break;
        }
        if (paramFloat1 > this.C)
        {
          this.jdField_a_of_type_Xtf.a(i1 - i2, 0);
          break;
        }
        g();
        break;
        if (this.H != 1) {
          break label154;
        }
        break label154;
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewView.requestFocus(paramInt);
      this.jdField_a_of_type_AndroidViewView.setSelected(true);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_y_of_type_Boolean;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      do
      {
        do
        {
          return bool;
        } while (!b());
        playSoundEffect(1);
        return true;
      } while (!c());
      playSoundEffect(3);
      return true;
      this.jdField_i_of_type_Boolean = true;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    if ((this.jdField_i_of_type_Boolean) && (this.aG > 0))
    {
      a(this.jdField_a_of_type_AndroidViewView);
      postDelayed(new xte(this), ViewConfiguration.getPressedStateDuration());
      a(getChildAt(this.aF - this.au), this.aF, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(this.aF));
    }
    this.jdField_i_of_type_Boolean = false;
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    float f1 = getResources().getDisplayMetrics().density;
    this.J = (getRight() - getLeft() - this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidGraphicsRect.right);
    this.K = (getBottom() - getTop() - this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    this.L = ((int)Math.ceil(this.J * f1));
    this.M = ((int)Math.ceil(f1 * this.K));
    this.q = true;
    b(0, false);
    this.q = false;
    this.v = false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.jdField_u_of_type_Boolean) {
      return;
    }
    long l1 = a(this.aF);
    b(this.jdField_b_of_type_AndroidViewView, this.aF, l1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    if ((i1 == 1073741824) && (i2 == 1073741824))
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    if (!this.jdField_f_of_type_Boolean) {
      if (this.jdField_j_of_type_Boolean)
      {
        if (!this.jdField_h_of_type_Boolean) {
          this.jdField_h_of_type_Boolean = true;
        }
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 250L);
      }
    }
    for (;;)
    {
      a((int)paramFloat1 * -1, (int)paramFloat2 * -1, true);
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.H == 1) && (e()))
      {
        if (!this.n) {
          this.n = true;
        }
        a(true, 1);
      }
      this.jdField_j_of_type_Boolean = false;
      return true;
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_h_of_type_Boolean = false;
      }
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter != null)
    {
      a(this.jdField_b_of_type_AndroidViewView, this.aF, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(this.aF));
      return true;
    }
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.v = true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.aG == 0) {
      return false;
    }
    l();
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    boolean bool;
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.jdField_u_of_type_Boolean = true;
      if (!this.w) {
        break label136;
      }
      bool = this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector.a(paramMotionEvent);
    }
    for (;;)
    {
      int i1 = paramMotionEvent.getAction();
      if (i1 == 1)
      {
        d();
        m();
        this.k = false;
      }
      for (;;)
      {
        if ((i1 & 0xFF) == 2) {
          this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
        }
        return bool;
        if (this.k) {
          break label136;
        }
        this.jdField_u_of_type_Boolean = false;
        bool = this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
        break;
        if (i1 == 3)
        {
          f();
          m();
          this.k = false;
        }
      }
      label136:
      bool = false;
    }
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    super.setAdapter(paramSpinnerAdapter);
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void setAnimationDuration(int paramInt)
  {
    this.jdField_y_of_type_Int = paramInt;
  }
  
  public void setCallbackDuringFling(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setCallbackOnUnselectedItemClick(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setInterceptTouchEventReturn(boolean paramBoolean)
  {
    this.jdField_y_of_type_Boolean = paramBoolean;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.jdField_j_of_type_Float = paramFloat;
  }
  
  public void setOnItemRotateListener(Gallery.OnItemRotateListener paramOnItemRotateListener)
  {
    this.jdField_a_of_type_ComTencentWidgetGallery$OnItemRotateListener = paramOnItemRotateListener;
  }
  
  public void setOnScollListener(Gallery.OnScollListener paramOnScollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener = paramOnScollListener;
  }
  
  public void setRotateEnable(boolean paramBoolean)
  {
    this.jdField_z_of_type_Boolean = paramBoolean;
  }
  
  public void setSpacing(int paramInt)
  {
    this.jdField_x_of_type_Int = paramInt;
  }
  
  public boolean showContextMenu()
  {
    if ((isPressed()) && (this.aF >= 0)) {
      return b(getChildAt(this.aF - this.au), this.aF, this.jdField_e_of_type_Long);
    }
    return false;
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    int i1 = a(paramView);
    if (i1 < 0) {
      return false;
    }
    return b(paramView, i1, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(i1));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\Gallery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */