package com.tencent.av.widget.stageview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.Rotate3dAnimation;
import com.tencent.qphone.base.util.QLog;
import hcj;
import hcl;
import hcm;
import hcn;
import hco;
import hcp;
import hcs;
import hct;
import hcu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class StageEffectView
  extends ViewGroup
{
  private static final double jdField_a_of_type_Double = -18.0D;
  static final float jdField_a_of_type_Float = 96.77058F;
  static final int jdField_a_of_type_Int = 8;
  static final double[] jdField_a_of_type_ArrayOfDouble;
  static final int[] jdField_a_of_type_ArrayOfInt;
  private static final int[][] jdField_a_of_type_Array2dOfInt;
  private static final float jdField_b_of_type_Float;
  public static final int b = 300;
  private static final boolean jdField_b_of_type_Boolean;
  private static final float jdField_c_of_type_Float;
  static final int jdField_c_of_type_Int = 832;
  private static final float jdField_d_of_type_Float = 0.1F;
  static final int jdField_d_of_type_Int = 444;
  private static final float jdField_e_of_type_Float = 0.2F;
  public static final int e = 54;
  static final int jdField_f_of_type_Int = 20000;
  static final int jdField_g_of_type_Int = 2500;
  private static final int jdField_h_of_type_Int = 150;
  private static final int jdField_i_of_type_Int = 16;
  private static final int jdField_j_of_type_Int = 0;
  private static final int jdField_k_of_type_Int = 1;
  private static final int jdField_l_of_type_Int = 2;
  private static final int jdField_m_of_type_Int = 3;
  private static final int jdField_n_of_type_Int = 15;
  private static final int jdField_o_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Camera jdField_a_of_type_AndroidGraphicsCamera;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private OverScroller jdField_a_of_type_ComTencentAvWidgetStageviewOverScroller;
  private StageEffectView.OnIconClickListener jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$OnIconClickListener;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new hcm(this);
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final Comparator jdField_a_of_type_JavaUtilComparator = new hcl(this);
  public boolean a;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  private final StageMemberView[] jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView = new StageMemberView[8];
  private final Integer[] jdField_a_of_type_ArrayOfJavaLangInteger = new Integer[8];
  private double jdField_b_of_type_Double;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Comparator jdField_b_of_type_JavaUtilComparator = new hcn(this);
  private final int[] jdField_b_of_type_ArrayOfInt = new int[1];
  private Comparator jdField_c_of_type_JavaUtilComparator;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private float jdField_f_of_type_Float;
  private float jdField_g_of_type_Float;
  private float jdField_h_of_type_Float;
  private float jdField_i_of_type_Float;
  private float jdField_j_of_type_Float;
  private float jdField_k_of_type_Float;
  private float jdField_l_of_type_Float;
  private float jdField_m_of_type_Float;
  private float jdField_n_of_type_Float;
  private float jdField_o_of_type_Float;
  private int p;
  private int q;
  private int r;
  private int s = 0;
  private int t;
  private int u;
  private int v = -1;
  private int w;
  private int x;
  
  static
  {
    boolean bool1 = true;
    boolean bool2 = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Float = (float)Math.sin(-0.3141592653589793D);
    jdField_c_of_type_Float = (float)Math.cos(-0.3141592653589793D);
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 17500, 2500, 15000, 5000, 12500, 7500, 10000 };
    jdField_a_of_type_ArrayOfDouble = new double[] { 0.0D, 0.6981317007977318D, 2.0943951023931953D, 2.8797932657906435D, 3.141592653589793D, 3.4033920413889427D, 4.1887902047863905D, 5.585053606381854D };
    int[] arrayOfInt = { 3, 1, 0, 2 };
    jdField_a_of_type_Array2dOfInt = new int[][] { new int[0], { 0 }, { 1, 0 }, { 1, 0, 2 }, arrayOfInt, { 3, 1, 0, 2, 4 }, { 5, 3, 1, 0, 2, 4 }, { 5, 3, 1, 0, 2, 4, 6 }, { 5, 3, 1, 0, 2, 4, 6, 7 } };
    if (Build.VERSION.SDK_INT >= 11) {}
    for (;;)
    {
      jdField_b_of_type_Boolean = bool1;
      return;
      bool1 = false;
    }
  }
  
  public StageEffectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StageEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h = 1.0F;
    this.d = true;
    this.jdField_a_of_type_Boolean = a(paramContext);
  }
  
  private double a(float paramFloat, boolean paramBoolean)
  {
    float f1 = 1.0F;
    paramFloat = (paramFloat - this.f) / this.h / 300.0F;
    if (paramFloat > 1.0F) {
      paramFloat = f1;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        return Math.asin(paramFloat) * 0.6499999761581421D;
        if (paramFloat < -1.0F) {
          paramFloat = -1.0F;
        }
      }
      else
      {
        return 3.141592653589793D - Math.asin(paramFloat) * 1.350000023841858D;
      }
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 * paramInt2 < 0)
    {
      int i1 = paramInt1 + paramInt2;
      if (Math.abs(i1) < paramInt3) {
        return paramInt1;
      }
      return -paramInt2 + a(i1, 0, paramInt3);
    }
    return (paramInt3 - Math.abs(paramInt2)) * paramInt1 / paramInt3;
  }
  
  private int a(String[] paramArrayOfString, int paramInt, int[] paramArrayOfInt)
  {
    if (paramInt == 0)
    {
      paramInt = 0;
      return paramInt;
    }
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    label17:
    Object localObject;
    int i4;
    hcu localhcu;
    if (i3 < paramInt)
    {
      localObject = paramArrayOfString[i3];
      if (localObject == null) {
        break label656;
      }
      i4 = 0;
      if (i4 < this.p)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i4] == null) {}
        do
        {
          i4 += 1;
          break;
          localhcu = (hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i4].getTag();
          localhcu.jdField_a_of_type_Hcu = null;
        } while (!((String)localObject).equals(localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString));
        removeViewInLayout(this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i4]);
        this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i4] = null;
        i4 = i2 + 1;
        i2 = i1 + 1;
        i1 = i4;
      }
    }
    for (;;)
    {
      label137:
      i3 += 1;
      i4 = i2;
      i2 = i1;
      i1 = i4;
      break label17;
      i4 = 0;
      for (;;)
      {
        if (i4 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (((String)localObject).equals(((hcu)this.jdField_a_of_type_JavaUtilArrayList.get(i4)).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString))
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(i4);
            i4 = i1 + 1;
            i1 = i2;
            i2 = i4;
            break label137;
          }
          i4 += 1;
          continue;
          paramInt = i1;
          if (i2 <= 0) {
            break;
          }
          Arrays.sort(this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView, 0, this.p, this.jdField_b_of_type_JavaUtilComparator);
          int i7 = this.p - i2;
          paramArrayOfString = jdField_a_of_type_Array2dOfInt[i7];
          int i5 = 0;
          i3 = 0;
          paramInt = 0;
          while (i5 < this.p)
          {
            localObject = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i5];
            if (localObject == null)
            {
              i5 += 1;
            }
            else
            {
              localhcu = (hcu)((StageMemberView)localObject).getTag();
              if ((localhcu.jdField_a_of_type_Int == 0) && ((localhcu.jdField_a_of_type_Int < 0) || (localhcu.jdField_a_of_type_Int >= 10000))) {
                break label425;
              }
            }
          }
          int i6;
          if (i3 < i7)
          {
            i6 = 0;
            i4 = 0;
            i5 = paramInt;
            if (i6 < this.p) {
              if (i3 < i7) {
                break label488;
              }
            }
          }
          for (i5 = paramInt;; i5 = paramInt)
          {
            this.p -= i2;
            paramInt = 0;
            for (;;)
            {
              if (paramInt < this.p)
              {
                this.jdField_a_of_type_ArrayOfJavaLangInteger[paramInt] = Integer.valueOf(paramInt);
                paramInt += 1;
                continue;
                label425:
                i4 = paramInt;
                if (localhcu.jdField_a_of_type_Int != jdField_a_of_type_ArrayOfInt[paramArrayOfString[i3]])
                {
                  a((StageMemberView)localObject, localhcu, jdField_a_of_type_ArrayOfInt[paramArrayOfString[i3]], -1, 0);
                  i4 = Math.max(paramInt, localhcu.jdField_a_of_type_Hct.jdField_a_of_type_Int);
                }
                i3 += 1;
                paramInt = i4;
                break;
                label488:
                localObject = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[(this.p - 1 - i6)];
                if (localObject == null)
                {
                  i5 = i4;
                  i4 = paramInt;
                  paramInt = i5;
                }
                for (;;)
                {
                  i6 += 1;
                  i5 = i4;
                  i4 = paramInt;
                  paramInt = i5;
                  break;
                  localhcu = (hcu)((StageMemberView)localObject).getTag();
                  i5 = paramInt;
                  if (localhcu.jdField_a_of_type_Int != jdField_a_of_type_ArrayOfInt[paramArrayOfString[(i7 - 1 - i4)]])
                  {
                    a((StageMemberView)localObject, localhcu, jdField_a_of_type_ArrayOfInt[paramArrayOfString[(i7 - 1 - i4)]], -1, 0);
                    i5 = Math.max(paramInt, localhcu.jdField_a_of_type_Hct.jdField_a_of_type_Int);
                  }
                  paramInt = i4 + 1;
                  i3 += 1;
                  i4 = i5;
                }
              }
            }
            b();
            invalidate();
            paramInt = i1;
            if (paramArrayOfInt == null) {
              break;
            }
            paramArrayOfInt[0] = i5;
            return i1;
          }
        }
      }
      label656:
      i4 = i1;
      i1 = i2;
      i2 = i4;
    }
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(" + this.p + "), [");
    int i1 = 0;
    while (i1 < this.p)
    {
      hcu localhcu = (hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].getTag();
      localStringBuilder.append("{(" + localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString + ")(" + localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.b + ")(" + localhcu.jdField_a_of_type_Int + ")}, ");
      i1 += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private void a(float paramFloat1, float paramFloat2, ImageView paramImageView, StageMemberView paramStageMemberView, Drawable paramDrawable, boolean paramBoolean)
  {
    int i1 = paramImageView.getWidth();
    int i2 = paramImageView.getHeight();
    float f2 = i1 / 2.0F;
    float f3 = i2 / 2.0F;
    float f1;
    Rotate3dAnimation localRotate3dAnimation;
    if (paramBoolean)
    {
      f1 = 0.0F;
      localRotate3dAnimation = new Rotate3dAnimation(paramFloat1, paramFloat2, f2, f3, f1, true);
      if (!paramBoolean) {
        break label117;
      }
    }
    label117:
    for (i1 = 4;; i1 = 1)
    {
      localRotate3dAnimation.setDuration(i1 * 500);
      localRotate3dAnimation.setAnimationListener(new hcp(this, paramBoolean, paramStageMemberView, paramDrawable, paramImageView, f2, f3));
      paramStageMemberView.b(false);
      paramImageView.startAnimation(localRotate3dAnimation);
      return;
      f1 = 200.0F;
      break;
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0) {}
    label354:
    label558:
    for (;;)
    {
      return;
      int i3 = this.r;
      int i1 = this.p;
      int i2 = this.jdField_a_of_type_JavaUtilArrayList.size() + i1;
      int i4 = this.r;
      if (i2 < 8) {}
      Object localObject1;
      Object localObject2;
      for (i1 = 8;; i1 = i2)
      {
        this.r = MathUtils.a(i4 + paramInt, i1 * 2500);
        i3 /= 2500;
        i4 = this.r / 2500;
        i1 = 0;
        while (i1 < this.p)
        {
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1];
          localObject2 = (hcu)((StageMemberView)localObject1).getTag();
          float f1 = ((hcu)localObject2).d;
          f1 = ((hcu)localObject2).e;
          a((hcu)localObject2, (StageMemberView)localObject1, ((hcu)localObject2).jdField_a_of_type_Int + paramInt);
          i1 += 1;
        }
      }
      if ((i2 > 8) && (i3 != i4))
      {
        hcu localhcu;
        if (paramInt > 0)
        {
          i2 = (i4 + i2 - i3) % i2;
          paramInt = 0;
          for (;;)
          {
            if (paramInt >= this.p) {
              break label354;
            }
            localObject1 = (hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[paramInt].getTag();
            if ((((hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[((paramInt - 1 + 8) % 8)].getTag()).jdField_a_of_type_Int < 10000) && (((hcu)localObject1).jdField_a_of_type_Int >= 10000))
            {
              i1 = 0;
              while (i1 < i2)
              {
                localObject1 = (hcu)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
                localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[((i2 - 1 - i1 + paramInt) % 8)];
                localhcu = (hcu)((StageMemberView)localObject2).getTag();
                ((hcu)localObject1).a(localhcu);
                ((StageMemberView)localObject2).setTag(localObject1);
                ((StageMemberView)localObject2).setBackgroundDrawable(((hcu)localObject1).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
                ((StageMemberView)localObject2).a(((hcu)localObject1).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.b, false);
                a(-1, localhcu);
                i1 += 1;
              }
              break;
            }
            paramInt += 1;
          }
        }
        else if (paramInt < 0)
        {
          i2 = MathUtils.a(i3 - i4, i2);
          paramInt = this.p - 1;
          for (;;)
          {
            if (paramInt < 0) {
              break label558;
            }
            localObject1 = (hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[paramInt].getTag();
            if ((((hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[((paramInt + 1 + 8) % 8)].getTag()).jdField_a_of_type_Int > 10000) && (((hcu)localObject1).jdField_a_of_type_Int < 10000))
            {
              i1 = 0;
              while (i1 < i2)
              {
                localObject1 = (hcu)this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
                i3 = MathUtils.a(paramInt - (i2 - 1 - i1), 8);
                localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i3];
                localhcu = (hcu)((StageMemberView)localObject2).getTag();
                ((hcu)localObject1).a(localhcu);
                ((StageMemberView)localObject2).setTag(localObject1);
                ((StageMemberView)localObject2).setBackgroundDrawable(((hcu)localObject1).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
                ((StageMemberView)localObject2).a(((hcu)localObject1).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.b, false);
                a(0, localhcu);
                i1 += 1;
              }
              break;
            }
            paramInt -= 1;
          }
        }
      }
    }
  }
  
  private static void a(int paramInt1, int paramInt2, View paramView)
  {
    int i1 = paramView.getWidth() / 2;
    int i2 = paramView.getLeft();
    int i3 = paramView.getHeight() / 2;
    int i4 = paramView.getTop();
    paramView.offsetLeftAndRight(paramInt1 - (i1 + i2));
    paramView.offsetTopAndBottom(paramInt2 - (i3 + i4));
  }
  
  private void a(int paramInt, hcu paramhcu)
  {
    paramhcu.jdField_a_of_type_Hcu = null;
    paramhcu.jdField_a_of_type_Hct = null;
    if (paramInt < 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramhcu);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramhcu);
  }
  
  private void a(StageMemberView paramStageMemberView, hcu paramhcu, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0) {
      paramStageMemberView.setVisibility(4);
    }
    paramhcu.jdField_a_of_type_Hct = new hct(paramhcu.jdField_a_of_type_Int, MathUtils.a(paramInt1, 20000), paramInt2, paramInt3, null);
  }
  
  private void a(hcu paramhcu, StageMemberView paramStageMemberView)
  {
    hcu localhcu = paramhcu.jdField_a_of_type_Hcu;
    localhcu.a(paramhcu);
    paramStageMemberView.setTag(localhcu);
    paramStageMemberView.setBackgroundDrawable(localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    paramStageMemberView.a(localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.b, false);
    if (this.jdField_a_of_type_JavaUtilArrayList.remove(localhcu)) {
      a(-1, paramhcu);
    }
  }
  
  private void a(hcu paramhcu, StageMemberView paramStageMemberView, int paramInt)
  {
    paramInt = MathUtils.a(paramInt, 20000);
    int i1 = paramInt / 2500;
    if (i1 < jdField_a_of_type_ArrayOfDouble.length - 1) {}
    for (double d1 = jdField_a_of_type_ArrayOfDouble[(i1 + 1)] - jdField_a_of_type_ArrayOfDouble[i1];; d1 = 6.283185307179586D - jdField_a_of_type_ArrayOfDouble[i1])
    {
      double d2 = (paramInt - i1 * 2500) / 2500.0D;
      paramhcu.jdField_a_of_type_Int = paramInt;
      d1 = d1 * d2 + jdField_a_of_type_ArrayOfDouble[i1];
      this.j = ((float)(Math.sin(d1) * 300.0D));
      this.k = 0.0F;
      this.l = (-(float)(Math.cos(d1) * 300.0D));
      this.m = this.j;
      this.n = (this.k * jdField_c_of_type_Float - this.l * jdField_b_of_type_Float);
      this.o = (this.k * jdField_b_of_type_Float + this.l * jdField_c_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsCamera.save();
      this.jdField_a_of_type_AndroidGraphicsCamera.translate(this.m, this.n, this.o);
      this.jdField_a_of_type_AndroidGraphicsCamera.getMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      this.jdField_a_of_type_AndroidGraphicsCamera.restore();
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.h, this.h);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.f, this.g);
      this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
      paramhcu.jdField_a_of_type_Float = this.m;
      paramhcu.jdField_b_of_type_Float = this.n;
      paramhcu.jdField_c_of_type_Float = this.o;
      paramhcu.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
      paramhcu.f = this.jdField_a_of_type_ArrayOfFloat[0];
      if (this.l > 150.0F) {
        paramhcu.f *= (1.0F - (this.l - 150.0F) / 150.0F * 0.4F);
      }
      paramhcu.d = this.jdField_a_of_type_ArrayOfFloat[2];
      paramhcu.e = this.jdField_a_of_type_ArrayOfFloat[5];
      a((int)paramhcu.d, (int)paramhcu.e, paramStageMemberView);
      if (jdField_b_of_type_Boolean)
      {
        paramStageMemberView.setScaleX(paramhcu.f);
        paramStageMemberView.setScaleY(paramhcu.f);
      }
      if ((paramhcu.jdField_a_of_type_Int == 0) && (this.q == 0))
      {
        paramhcu = new int[2];
        paramStageMemberView.getLocationInWindow(paramhcu);
        this.q = paramhcu[1];
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.p)
    {
      StageMemberView localStageMemberView = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[this.jdField_a_of_type_ArrayOfJavaLangInteger[(this.p - 1 - i1)].intValue()];
      localStageMemberView.a(((hcu)localStageMemberView.getTag()).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.b, true);
      i1 += 1;
    }
  }
  
  private boolean a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsCamera = new Camera();
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = hcj.a();
    setChildrenDrawingOrderEnabled(true);
    setWillNotDraw(true);
    setClipChildren(false);
    this.x = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_a_of_type_ComTencentAvWidgetStageviewOverScroller = new OverScroller(paramContext);
    this.jdField_a_of_type_ComTencentAvWidgetStageviewOverScroller.a(0.05F);
    int i1 = (int)(70.0F * paramContext.getResources().getDisplayMetrics().density + 0.5F);
    float f1 = Math.max(1.0F, 0.75F * paramContext.getResources().getDisplayMetrics().density);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i1, i1, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      paramContext = new Paint();
      paramContext.setAntiAlias(true);
      paramContext.setDither(true);
      float f2 = i1 * 0.0625F + 2.0F;
      RectF localRectF1 = new RectF(f2, f2, i1 - f2, i1 - f2);
      paramContext.setMaskFilter(new BlurMaskFilter(1.0F, BlurMaskFilter.Blur.OUTER));
      paramContext.setStyle(Paint.Style.FILL);
      paramContext.setColor(-1593835521);
      localCanvas.drawOval(localRectF1, paramContext);
      paramContext.setMaskFilter(null);
      paramContext.setColor(-1);
      paramContext.setStrokeWidth(f1 * 2.0F);
      paramContext.setStyle(Paint.Style.STROKE);
      localRectF1.inset(f1, f1);
      localCanvas.drawOval(localRectF1, paramContext);
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i1, i1, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
      RectF localRectF2 = new RectF(f2, f2, i1 - f2, i1 - f2);
      paramContext.setMaskFilter(new BlurMaskFilter(f2 + 4.0F, BlurMaskFilter.Blur.OUTER));
      paramContext.setStyle(Paint.Style.FILL);
      paramContext.setStrokeWidth(f1 * 4.0F);
      paramContext.setColor(-1608790934);
      localCanvas.drawOval(localRectF2, paramContext);
      paramContext.setMaskFilter(null);
      paramContext.setColor(-15554453);
      paramContext.setStrokeWidth(f1 * 4.0F);
      paramContext.setStyle(Paint.Style.STROKE);
      localRectF1.inset(f1, f1);
      localCanvas.drawOval(localRectF2, paramContext);
      this.jdField_c_of_type_Boolean = true;
      if (!jdField_b_of_type_Boolean) {
        setStaticTransformationsEnabled(true);
      }
      return true;
    }
    catch (OutOfMemoryError paramContext) {}
    return false;
  }
  
  private boolean a(hcu paramhcu, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    int i1 = this.p;
    StageMemberView localStageMemberView = new StageMemberView(getContext(), this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsBitmap);
    localStageMemberView.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect = paramhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect;
    localStageMemberView.setBackgroundDrawable(paramhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    localStageMemberView.layout(-54, -54, 54, 66);
    localStageMemberView.setTag(paramhcu);
    if (this.jdField_c_of_type_Boolean) {
      localStageMemberView.a(paramhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.b, false);
    }
    a(true);
    super.addViewInLayout(localStageMemberView, getChildCount(), generateDefaultLayoutParams());
    this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1] = localStageMemberView;
    this.p += 1;
    if ((paramBoolean2) || (paramInt2 > 0) || (paramBoolean1))
    {
      a(paramhcu, localStageMemberView, jdField_a_of_type_ArrayOfInt[7]);
      paramInt1 = jdField_a_of_type_ArrayOfInt[i1] + paramInt1;
      paramBoolean1 = bool;
      if (paramhcu.jdField_a_of_type_Int != paramInt1) {
        a(localStageMemberView, paramhcu, paramInt1, -1, paramInt2);
      }
    }
    for (paramBoolean1 = true;; paramBoolean1 = bool)
    {
      this.jdField_a_of_type_ArrayOfJavaLangInteger[i1] = Integer.valueOf(i1);
      b();
      return paramBoolean1;
      a(paramhcu, localStageMemberView, jdField_a_of_type_ArrayOfInt[i1]);
      invalidate();
    }
  }
  
  private void b()
  {
    Arrays.sort(this.jdField_a_of_type_ArrayOfJavaLangInteger, 0, this.p, this.jdField_a_of_type_JavaUtilComparator);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void e()
  {
    int i2;
    int i1;
    if (this.s != 0)
    {
      i2 = 1;
      if (this.p < 8) {
        break label81;
      }
      i1 = Math.round(this.r / 2500.0F) * 2500 - this.r;
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.s |= 0x2;
      this.t = i1;
      this.u = 0;
      if (i2 == 0) {
        f();
      }
      return;
      i2 = 0;
      break;
      label81:
      int i3 = MathUtils.a(this.r, 0, 20000, false);
      i1 = i3;
      if (i3 > 10000) {
        i1 = -(20000 - i3);
      }
    }
  }
  
  private void f()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      postOnAnimation(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, 16L);
  }
  
  private void g()
  {
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.s = 0;
  }
  
  private void h()
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("must call in ui thread");
    }
  }
  
  public int a()
  {
    if (this.q == 0)
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[0].getLocationInWindow(arrayOfInt);
      this.q = arrayOfInt[1];
    }
    return this.q;
  }
  
  public void a()
  {
    long l1 = SystemClock.uptimeMillis();
    int i2;
    StageMemberView localStageMemberView;
    hcu localhcu;
    int i3;
    label87:
    label221:
    label234:
    float f1;
    int i4;
    if ((this.s & 0x10) == 16)
    {
      i2 = 0;
      i1 = 0;
      if (i1 < this.p)
      {
        localStageMemberView = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1];
        localhcu = (hcu)localStageMemberView.getTag();
        i3 = localhcu.jdField_a_of_type_Int;
        if (localhcu.jdField_a_of_type_Hct != null)
        {
          if (localhcu.jdField_a_of_type_Hct.jdField_a_of_type_ArrayOfInt == null) {
            break label221;
          }
          i2 = localhcu.jdField_a_of_type_Hct.jdField_a_of_type_ArrayOfInt[0];
          if (l1 >= localhcu.jdField_a_of_type_Hct.jdField_a_of_type_Long) {
            break label234;
          }
        }
        for (;;)
        {
          if ((localhcu.jdField_a_of_type_Hcu != null) && (((localhcu.jdField_a_of_type_Hct != null) && (!localhcu.jdField_a_of_type_Hct.jdField_a_of_type_Boolean) && (i3 < 10000) && (localhcu.jdField_a_of_type_Int >= 10000)) || ((localhcu.jdField_a_of_type_Hct != null) && (localhcu.jdField_a_of_type_Hct.jdField_a_of_type_Boolean) && (i3 > 10000) && (localhcu.jdField_a_of_type_Int <= 10000)) || ((this.s == 16) && (localhcu.jdField_a_of_type_Hct == null)))) {
            a(localhcu, localStageMemberView);
          }
          i2 = 1;
          i1 += 1;
          break;
          i2 = localhcu.jdField_a_of_type_Hct.jdField_a_of_type_Int;
          break label87;
          if (l1 < localhcu.jdField_a_of_type_Hct.jdField_a_of_type_Long + i2)
          {
            localStageMemberView.setVisibility(0);
            f1 = (float)(l1 - localhcu.jdField_a_of_type_Hct.jdField_a_of_type_Long) / i2;
            if (localhcu.jdField_a_of_type_Hct.jdField_a_of_type_Boolean) {}
            float f2;
            for (i2 = (int)(localhcu.jdField_a_of_type_Hct.b - this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f1) * localhcu.jdField_a_of_type_Hct.d);; i2 = (int)(this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f1) * localhcu.jdField_a_of_type_Hct.d + f2))
            {
              i4 = localhcu.jdField_a_of_type_Hct.e;
              localhcu.jdField_a_of_type_Hct.e = i2;
              a(localhcu, localStageMemberView, localhcu.jdField_a_of_type_Int + (i2 - i4));
              break;
              f2 = localhcu.jdField_a_of_type_Hct.b;
            }
          }
          localStageMemberView.setVisibility(0);
          i2 = localhcu.jdField_a_of_type_Hct.c;
          i4 = localhcu.jdField_a_of_type_Hct.e;
          localhcu.jdField_a_of_type_Hct.e = localhcu.jdField_a_of_type_Hct.c;
          a(localhcu, localStageMemberView, i2 - i4 + localhcu.jdField_a_of_type_Int);
          localhcu.jdField_a_of_type_Hct = null;
        }
      }
      i1 = i2;
      if (i2 == 0) {
        this.s &= 0xFFFFFFEF;
      }
    }
    for (int i1 = i2;; i1 = 0)
    {
      switch (this.s & 0xF)
      {
      default: 
        b();
        if (i1 == 0) {
          break label954;
        }
        if (Build.VERSION.SDK_INT >= 16) {
          postOnAnimation(this.jdField_a_of_type_JavaLangRunnable);
        }
        break;
      }
      for (;;)
      {
        invalidate();
        return;
        f1 = (float)(l1 - this.jdField_a_of_type_Long) / (Math.abs(this.t) * 0.2F);
        if (f1 >= 1.0F)
        {
          i2 = this.t;
          i3 = this.u;
          this.u = this.t;
          i3 = i2 - i3;
          i2 = i1;
        }
        for (;;)
        {
          i1 = this.p;
          i4 = this.jdField_a_of_type_JavaUtilArrayList.size();
          this.r = MathUtils.a(this.r + i3, (i1 + i4) * 2500);
          i4 = 0;
          for (;;)
          {
            i1 = i2;
            if (i4 >= this.p) {
              break;
            }
            localStageMemberView = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i4];
            localhcu = (hcu)localStageMemberView.getTag();
            i1 = localhcu.jdField_a_of_type_Int;
            a(localhcu, localStageMemberView, localhcu.jdField_a_of_type_Int + i3);
            if ((localhcu.jdField_a_of_type_Hcu != null) && ((i2 == 0) || ((this.u > 0) && (i1 < 10000) && (localhcu.jdField_a_of_type_Int >= 10000)) || ((this.u < 0) && (i1 > 10000) && (localhcu.jdField_a_of_type_Int <= 10000)))) {
              a(localhcu, localStageMemberView);
            }
            i4 += 1;
          }
          i2 = 1;
          i1 = (int)(this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f1) * this.t);
          i3 = this.u;
          this.u = i1;
          i3 = i1 - i3;
        }
        f1 = (float)(l1 - this.jdField_a_of_type_Long) / 500.0F;
        i2 = this.t;
        if (f1 < 1.0F)
        {
          i2 = (int)(this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f1) * this.t);
          i1 = 1;
        }
        a(i2 - this.u);
        this.u = i2;
        break;
        if (this.jdField_a_of_type_ComTencentAvWidgetStageviewOverScroller.b()) {
          i1 = 1;
        }
        i2 = this.jdField_a_of_type_ComTencentAvWidgetStageviewOverScroller.a();
        a(i2 - this.u);
        this.u = i2;
        break;
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 16L);
      }
      label954:
      invalidate();
      g();
      return;
    }
  }
  
  void a(double paramDouble)
  {
    if (this.s != 0) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.s |= 0x3;
      this.jdField_a_of_type_ComTencentAvWidgetStageviewOverScroller.a(this.r, 0, (int)(20000.0D * paramDouble), 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, 0, 0, 2500, 0);
      this.u = this.r;
      if (i1 == 0) {
        f();
      }
      return;
    }
  }
  
  public boolean a()
  {
    h();
    removeAllViewsInLayout();
    int i1 = 0;
    while (i1 < this.p)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1] = null;
      this.jdField_a_of_type_ArrayOfJavaLangInteger[i1] = null;
      i1 += 1;
    }
    this.p = 0;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.r = 0;
    invalidate();
    g();
    return true;
  }
  
  public boolean a(StageEffectView.StageMember paramStageMember, boolean paramBoolean)
  {
    h();
    if (a(paramStageMember.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    hcu localhcu = new hcu(null);
    localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember = paramStageMember;
    if (paramStageMember.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      paramStageMember.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839235);
    }
    if (this.p >= 8)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        Arrays.sort(this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView, this.jdField_b_of_type_JavaUtilComparator);
      }
      a(-1, localhcu);
      return false;
    }
    int i1;
    if (this.s != 0)
    {
      i1 = 1;
      if (this.r <= 10000) {
        break label161;
      }
    }
    label161:
    for (int i2 = this.r - 20000;; i2 = this.r)
    {
      if (a(localhcu, i2, paramBoolean, false, 0))
      {
        this.s |= 0x10;
        if (i1 == 0) {
          f();
        }
      }
      return true;
      i1 = 0;
      break;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    boolean bool1;
    while (i1 < this.p)
    {
      if (paramString.equals(((hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].getTag()).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString))
      {
        bool1 = true;
        return bool1;
      }
      i1 += 1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!paramString.equals(((hcu)localIterator.next()).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString));
    return true;
  }
  
  public boolean a(String paramString, Drawable paramDrawable)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.p)
      {
        if (paramString.equals(((hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].getTag()).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].setIconBadge(3, paramDrawable);
          invalidate();
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public boolean a(String paramString, Drawable paramDrawable, boolean paramBoolean)
  {
    boolean bool = false;
    h();
    int i1 = 0;
    hcu localhcu;
    while (i1 < this.p)
    {
      localhcu = (hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].getTag();
      if (paramString.equals(localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString))
      {
        if (paramDrawable != null) {
          if (paramBoolean)
          {
            a(0.0F, 90.0F, this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].a(), this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1], paramDrawable, false);
            localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
          }
        }
        for (;;)
        {
          paramBoolean = true;
          return paramBoolean;
          this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].setBackgroundDrawable(paramDrawable);
          break;
          if (paramBoolean) {
            a(0.0F, 360.0F, this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].a(), this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1], localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
          }
        }
      }
      i1 += 1;
    }
    i1 = 0;
    for (;;)
    {
      paramBoolean = bool;
      if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      localhcu = (hcu)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (paramString.equals(localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString))
      {
        if (paramDrawable != null) {
          localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        }
        return true;
      }
      i1 += 1;
    }
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool2 = false;
    QLog.d("StageEffectView", 2, "setNameText :" + paramString1 + ",name： " + paramString2);
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      hcu localhcu;
      if (i1 < this.p)
      {
        localhcu = (hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].getTag();
        if (!paramString1.equals(localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString)) {
          break label165;
        }
        if (!localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.b.equals(paramString2)) {
          break label107;
        }
        bool1 = true;
      }
      label107:
      do
      {
        return bool1;
        if (paramString2 != null) {
          break;
        }
        bool1 = bool2;
      } while (!paramBoolean);
      for (;;)
      {
        paramString1 = localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.b;
        this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].a(paramString1, paramBoolean);
        return true;
        bool1 = bool2;
        if (TextUtils.isEmpty(paramString2)) {
          break;
        }
        localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.b = paramString2;
      }
      label165:
      i1 += 1;
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    int i1 = 0;
    boolean bool1;
    while (i1 < this.p)
    {
      localObject = (hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].getTag();
      if (paramString.equals(((hcu)localObject).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString))
      {
        ((hcu)localObject).jdField_a_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].a(paramBoolean);
        bool1 = true;
        return bool1;
      }
      i1 += 1;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    hcu localhcu;
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localhcu = (hcu)((Iterator)localObject).next();
    } while (!paramString.equals(localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString));
    localhcu.jdField_a_of_type_Boolean = paramBoolean;
    return true;
  }
  
  public boolean a(String... paramVarArgs)
  {
    h();
    if (this.s != 0) {}
    int i3;
    for (int i1 = 1;; i1 = 0)
    {
      if ((this.e) || (this.s != 0)) {
        postDelayed(new hco(this, paramVarArgs), 500L);
      }
      int i2 = this.p;
      i3 = a(paramVarArgs, paramVarArgs.length, this.jdField_b_of_type_ArrayOfInt);
      a(true);
      if (this.p >= i2) {
        break label163;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break;
      }
      int i4 = Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), 8 - this.p);
      i2 = 0;
      while (i2 < i4)
      {
        a((hcu)this.jdField_a_of_type_JavaUtilArrayList.remove(0), 0, true, true, 0);
        i2 += 1;
      }
    }
    this.r = 0;
    this.s = 16;
    if (i1 == 0) {
      f();
    }
    label163:
    return i3 > 0;
  }
  
  public boolean b()
  {
    Object localObject1 = null;
    h();
    int i2 = this.p + this.jdField_a_of_type_JavaUtilArrayList.size();
    if ((i2 < 8) || (this.s != 0) || (this.e)) {
      return false;
    }
    Object localObject4 = new hcu[i2];
    int i1 = 0;
    if (i1 < localObject4.length)
    {
      if (i1 < this.p) {
        localObject4[i1] = ((hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].getTag());
      }
      for (;;)
      {
        localObject4[i1].jdField_a_of_type_Hcu = null;
        i1 += 1;
        break;
        localObject4[i1] = ((hcu)this.jdField_a_of_type_JavaUtilArrayList.get(i1 - this.p));
      }
    }
    if (this.jdField_c_of_type_JavaUtilComparator == null) {
      this.jdField_c_of_type_JavaUtilComparator = new hcs(this);
    }
    Object localObject2;
    Object localObject3;
    if (i2 > 8)
    {
      Arrays.sort((Object[])localObject4, this.jdField_c_of_type_JavaUtilComparator);
      localObject2 = new hcu[8];
      localObject3 = new boolean[this.p];
      i1 = 0;
      i2 = 0;
      int i3;
      if (i1 < this.p)
      {
        Object localObject5 = localObject4[i1];
        i3 = 0;
        label204:
        if (i3 < this.p)
        {
          hcu localhcu = (hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i3].getTag();
          if (((hcu)localObject5).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString.equals(localhcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString))
          {
            if (localObject3[i3] != 0) {
              throw new IllegalArgumentException("Duplicate member in arg members. key: " + ((hcu)localObject5).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString);
            }
            localObject3[i3] = 1;
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          i3 += 1;
          break label204;
          localObject2[i2] = localObject5;
          i2 += 1;
        }
      }
      if (i2 > 0)
      {
        i3 = 0;
        int i4 = 0;
        i2 = 0;
        for (i1 = 0;; i1 = i5)
        {
          i6 = i2;
          i5 = i1;
          if (i3 >= this.p) {
            break;
          }
          int i7 = i4;
          i6 = i2;
          i5 = i1;
          if (localObject3[i3] == 0)
          {
            localObject4 = (hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i3].getTag();
            ((hcu)localObject4).jdField_a_of_type_Hcu = localObject2[i4];
            i5 = MathUtils.a(((hcu)localObject4).jdField_a_of_type_Int, 10000, 20000, true);
            i6 = Math.max(i2, i5);
            i5 = Math.max(i1, 20000 - i5);
            if ((((hcu)localObject4).jdField_a_of_type_Hcu != null) && (((hcu)localObject4).jdField_a_of_type_Int == 10000)) {
              a((hcu)localObject4, this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i3]);
            }
            i7 = i4 + 1;
          }
          i3 += 1;
          i4 = i7;
          i2 = i6;
        }
      }
    }
    int i6 = 0;
    int i5 = 0;
    long l1 = 0L;
    i1 = 0;
    label517:
    long l2;
    label606:
    long l3;
    label627:
    long l4;
    if (i1 < this.p)
    {
      localObject3 = (hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[MathUtils.a(i1 - 1, this.p)].getTag();
      localObject4 = (hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[MathUtils.a(i1 + 1, this.p)].getTag();
      localObject2 = (hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].getTag();
      if (((hcu)localObject3).jdField_a_of_type_Hcu != null)
      {
        l2 = ((hcu)localObject3).jdField_a_of_type_Hcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_Long;
        if (((hcu)localObject4).jdField_a_of_type_Hcu == null) {
          break label691;
        }
        l3 = ((hcu)localObject4).jdField_a_of_type_Hcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_Long;
        if (((hcu)localObject2).jdField_a_of_type_Hcu == null) {
          break label704;
        }
        l4 = ((hcu)localObject2).jdField_a_of_type_Hcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_Long;
        label646:
        l2 = l4 + (l2 + l3);
        if (l2 <= l1) {
          break label879;
        }
        localObject1 = localObject2;
        l1 = l2;
      }
    }
    label691:
    label704:
    label879:
    for (;;)
    {
      i1 += 1;
      break label517;
      l2 = ((hcu)localObject3).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_Long;
      break label606;
      l3 = ((hcu)localObject4).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_Long;
      break label627;
      l4 = ((hcu)localObject2).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_Long;
      break label646;
      if (localObject1 == null) {
        break;
      }
      if (((hcu)localObject1).jdField_a_of_type_Int <= 10000) {
        if (((hcu)localObject1).jdField_a_of_type_Int >= i6) {
          this.t = (-((hcu)localObject1).jdField_a_of_type_Int);
        }
      }
      for (;;)
      {
        this.s = 1;
        this.u = 0;
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        f();
        return true;
        if (20000 - ((hcu)localObject1).jdField_a_of_type_Int >= i5)
        {
          this.t = (20000 - ((hcu)localObject1).jdField_a_of_type_Int);
        }
        else
        {
          this.t = (-((hcu)localObject1).jdField_a_of_type_Int - 20000);
          continue;
          if (20000 - ((hcu)localObject1).jdField_a_of_type_Int >= i5) {
            this.t = (20000 - ((hcu)localObject1).jdField_a_of_type_Int);
          } else if (((hcu)localObject1).jdField_a_of_type_Int >= i6) {
            this.t = (-((hcu)localObject1).jdField_a_of_type_Int);
          } else {
            this.t = (40000 - ((hcu)localObject1).jdField_a_of_type_Int);
          }
        }
      }
    }
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    return this.jdField_a_of_type_ArrayOfJavaLangInteger[paramInt2].intValue();
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    hcu localhcu = (hcu)paramView.getTag();
    paramTransformation = paramTransformation.getMatrix();
    paramTransformation.postScale(localhcu.f, localhcu.f);
    paramTransformation.preTranslate(-paramView.getWidth() / 2.0F, -paramView.getHeight() / 2.0F);
    paramTransformation.postTranslate(paramView.getWidth() / 2.0F, paramView.getHeight() / 2.0F);
    return true;
  }
  
  public boolean isLayoutRequested()
  {
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      paramInt2 = paramInt4 - paramInt2;
      paramInt1 = paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight();
      paramInt3 = getPaddingTop();
      paramInt4 = getPaddingBottom();
      float f1 = paramInt1 / 832.0F;
      float f2 = (paramInt2 - paramInt3 - paramInt4) / 444.0F;
      if (f2 >= f1)
      {
        this.h = f1;
        f2 = this.h;
        float f3 = getPaddingLeft();
        this.f = (paramInt1 / 2.0F + f3);
      }
      for (this.g = ((paramInt2 - f2 * 444.0F) / 2.0F + 96.77058F * f1);; this.g = (getPaddingTop() + 96.77058F * f2))
      {
        paramInt1 = 0;
        while (paramInt1 < this.p)
        {
          StageMemberView localStageMemberView = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[paramInt1];
          Object localObject = (hcu)localStageMemberView.getTag();
          a((hcu)localObject, localStageMemberView, ((hcu)localObject).jdField_a_of_type_Int);
          if ((((hcu)localObject).jdField_a_of_type_Int == 0) && (this.q == 0))
          {
            localObject = new int[2];
            localStageMemberView.getLocationInWindow((int[])localObject);
            this.q = localObject[1];
          }
          paramInt1 += 1;
        }
        this.h = f2;
        f1 = getPaddingLeft();
        this.f = (paramInt1 / 2.0F + f1);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight();
    int i3 = getPaddingTop();
    int i4 = getPaddingBottom();
    setMeasuredDimension(getDefaultSize(i1 + 832 + i2, paramInt1), getDefaultSize(i3 + 444 + i4, paramInt2));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    c();
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    float f1;
    Object localObject1;
    Object localObject2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      float f2;
      float f3;
      float f4;
      float f5;
      float f6;
      float f7;
      do
      {
        do
        {
          int i1;
          do
          {
            return true;
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            if (((this.e) || (this.s != 0)) && (this.p > 0))
            {
              localObject1 = getParent();
              if (localObject1 != null) {
                ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(true);
              }
              if (this.jdField_a_of_type_AndroidViewView != null)
              {
                this.jdField_a_of_type_AndroidViewView.setPressed(false);
                this.jdField_a_of_type_AndroidViewView = null;
              }
              i1 = 0;
              while (i1 < this.p)
              {
                ((hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].getTag()).jdField_a_of_type_Hcu = null;
                i1 += 1;
              }
              this.e = true;
              this.s &= 0xFFFFFFF0;
            }
            for (;;)
            {
              a(true);
              this.i = f1;
              this.w = ((int)this.i);
              this.d = true;
              this.jdField_b_of_type_Double = a(f1, this.d);
              this.v = paramMotionEvent.getPointerId(0);
              return true;
              i1 = getChildCount() - 1;
              for (;;)
              {
                if (i1 < 0) {
                  break label398;
                }
                localObject1 = getChildAt(this.jdField_a_of_type_ArrayOfJavaLangInteger[i1].intValue());
                localObject2 = (hcu)((View)localObject1).getTag();
                f3 = ((hcu)localObject2).f * 54.0F;
                f4 = ((hcu)localObject2).e;
                f5 = ((hcu)localObject2).e;
                f6 = ((hcu)localObject2).d;
                f7 = ((hcu)localObject2).d;
                if ((f1 >= f6 - f3) && (f1 < f7 + f3) && (f2 >= f4 - f3) && (f2 < f5 + f3))
                {
                  ((View)localObject1).setPressed(true);
                  if (this.jdField_a_of_type_AndroidViewView == localObject1) {
                    break;
                  }
                  if (this.jdField_a_of_type_AndroidViewView != null) {
                    this.jdField_a_of_type_AndroidViewView.setPressed(false);
                  }
                  this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
                  break;
                }
                i1 -= 1;
              }
            }
            i1 = paramMotionEvent.findPointerIndex(this.v);
          } while ((i1 == -1) || (i1 >= paramMotionEvent.getPointerCount()));
          f1 = paramMotionEvent.getX(i1);
          f2 = this.i;
          if ((!this.e) && (Math.abs(f1 - f2) > this.x) && (this.p > 0))
          {
            this.e = true;
            if (this.jdField_a_of_type_AndroidViewView != null)
            {
              this.jdField_a_of_type_AndroidViewView.setPressed(false);
              this.jdField_a_of_type_AndroidViewView = null;
            }
            i1 = 0;
            while (i1 < this.p)
            {
              ((hcu)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1].getTag()).jdField_a_of_type_Hcu = null;
              i1 += 1;
            }
            this.s &= 0xFFFFFFF0;
          }
          if (this.e)
          {
            double d1 = a(f1, this.d);
            a((int)((d1 - this.jdField_b_of_type_Double) * 45.0D / 40.0D / 6.283185307179586D * 20000.0D));
            b();
            this.jdField_b_of_type_Double = d1;
            this.w = ((int)f1);
            invalidate();
            return true;
          }
        } while (this.jdField_a_of_type_AndroidViewView == null);
        f2 = paramMotionEvent.getY();
        paramMotionEvent = (hcu)this.jdField_a_of_type_AndroidViewView.getTag();
        f3 = paramMotionEvent.f * 54.0F;
        f4 = paramMotionEvent.e;
        f5 = paramMotionEvent.e;
        f6 = paramMotionEvent.d;
        f7 = paramMotionEvent.d;
      } while ((f1 >= f6 - f3) && (f1 < f7 + f3) && (f2 >= f4 - f3) && (f2 < f5 + f3));
      this.jdField_a_of_type_AndroidViewView.setPressed(false);
      this.jdField_a_of_type_AndroidViewView = null;
      return true;
    case 1: 
      label398:
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$OnIconClickListener != null))
      {
        playSoundEffect(0);
        paramMotionEvent = (hcu)this.jdField_a_of_type_AndroidViewView.getTag();
        localObject1 = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$OnIconClickListener;
        localObject2 = this.jdField_a_of_type_AndroidViewView;
        if (paramMotionEvent.jdField_a_of_type_Hcu != null)
        {
          paramMotionEvent = paramMotionEvent.jdField_a_of_type_Hcu.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember;
          ((StageEffectView.OnIconClickListener)localObject1).a(this, (View)localObject2, paramMotionEvent);
        }
      }
      for (;;)
      {
        this.e = false;
        this.v = -1;
        d();
        invalidate();
        return true;
        paramMotionEvent = paramMotionEvent.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember;
        break;
        if (this.e)
        {
          paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
          paramMotionEvent.computeCurrentVelocity(1000, 2000.0F);
          f1 = paramMotionEvent.getXVelocity();
          if (Math.abs(f1) > 400.0F) {
            a(f1 * 5.0E-4D);
          } else {
            e();
          }
        }
      }
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setPressed(false);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    if (this.e) {
      e();
    }
    this.e = false;
    this.v = -1;
    d();
    invalidate();
    return true;
  }
  
  public void setOnIconClickListener(StageEffectView.OnIconClickListener paramOnIconClickListener)
  {
    this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$OnIconClickListener = paramOnIconClickListener;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\widget\stageview\StageEffectView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */