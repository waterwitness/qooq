package com.tencent.widget;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.kapalaiadapter.AdapterBugsLib;
import com.tencent.mobileqq.utils.kapalaiadapter.DeviceInfoUtil2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarTintManager;
import java.lang.reflect.Field;
import xvt;
import xvu;
import xvv;

public class XPanelContainer
  extends FrameLayout
  implements Runnable
{
  public static final int a = 0;
  private static final long jdField_a_of_type_Long = 150L;
  private static final String jdField_a_of_type_JavaLangString = XPanelContainer.class.getSimpleName();
  public static boolean a = false;
  public static final int b = 1;
  public static int c = 0;
  private static final long jdField_c_of_type_Long = 1L;
  private static boolean jdField_c_of_type_Boolean = VersionUtils.e();
  public static int d = 0;
  public static volatile int e = 0;
  private static int jdField_f_of_type_Int = 0;
  private static final int i = -1;
  private static final int r = 0;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
  private View jdField_a_of_type_AndroidViewView;
  public XPanelContainer.OnChangeMultiScreenListener a;
  private XPanelContainer.PanelCallback jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private long jdField_b_of_type_Long = -1L;
  private View jdField_b_of_type_AndroidViewView;
  public boolean b;
  private boolean d;
  private boolean e;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = true;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int m = -1;
  private int n = -1;
  private int o;
  private int p = 0;
  private int q;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public XPanelContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public XPanelContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = true;
    if (jdField_c_of_type_Int == 0)
    {
      jdField_c_of_type_Int = (int)(196.0F * paramContext.getResources().getDisplayMetrics().density);
      jdField_f_of_type_Int = jdField_c_of_type_Int;
      if (!SystemBarTintManager.a(paramContext)) {
        break label294;
      }
      i1 = SystemBarTintManager.a(paramContext);
    }
    label294:
    for (jdField_d_of_type_Int = (int)((paramContext.getResources().getDisplayMetrics().heightPixels + i1) * 0.4D);; jdField_d_of_type_Int = (int)(paramContext.getResources().getDisplayMetrics().heightPixels * 0.4D))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, " mMAXExternalPanelheight = " + jdField_d_of_type_Int + "mExternalPanelheight=" + jdField_c_of_type_Int);
      }
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, " mDefaultExternalPanelheight = " + jdField_f_of_type_Int + "mMAXExternalPanelheight=" + jdField_d_of_type_Int + "density=" + paramContext.getResources().getDisplayMetrics().density + "mNavigationBarHeight=" + i1);
      }
      this.o = ImmersiveUtils.a(getContext());
      if ((Build.VERSION.SDK_INT >= 21) && (!DeviceInfoUtil2.a())) {
        setOnSystemUiVisibilityChangeListener(new xvt(this));
      }
      return;
    }
  }
  
  private void c()
  {
    if ((jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean))
    {
      if (this.jdField_d_of_type_Boolean) {
        if (this.q >= jdField_c_of_type_Int)
        {
          this.q = 0;
          this.jdField_d_of_type_Boolean = false;
        }
      }
      while ((!this.jdField_e_of_type_Boolean) || (this.q > 0)) {
        return;
      }
      this.q = 0;
      this.jdField_e_of_type_Boolean = false;
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() >= this.jdField_b_of_type_Long + 0L)
    {
      this.q = 0;
      return;
    }
    float f1 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_b_of_type_Long) / 0.0F;
    this.q = ((int)(jdField_c_of_type_Int - AnimateUtils.a(f1) * jdField_c_of_type_Int));
  }
  
  private void c(int paramInt)
  {
    if (paramInt != this.jdField_h_of_type_Int)
    {
      int i1 = this.jdField_h_of_type_Int;
      this.jdField_h_of_type_Int = paramInt;
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback != null) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(i1, this.jdField_h_of_type_Int);
      }
      URLDrawable.resume();
      if ((this.jdField_b_of_type_AndroidViewView != null) && (paramInt <= 1))
      {
        if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) {
          break label86;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView = null;
        postDelayed(this, 1L);
      }
    }
    return;
    label86:
    this.jdField_b_of_type_AndroidViewView = null;
  }
  
  public int a()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.j = -1;
    c(0);
    requestLayout();
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.XPanelContainer", 2, " showExternalPanel panelId = " + paramInt + " mStatus = " + this.jdField_h_of_type_Int + " ready = " + this.jdField_h_of_type_Boolean);
    }
    if (!this.jdField_h_of_type_Boolean) {}
    label107:
    label157:
    label198:
    label220:
    label259:
    label277:
    label295:
    label535:
    label713:
    label763:
    label845:
    label863:
    label881:
    label1121:
    label1160:
    do
    {
      for (;;)
      {
        return;
        this.p = paramInt;
        Object localObject1;
        Object localObject3;
        if (jdField_a_of_type_Boolean)
        {
          if (paramInt == 1) {
            if (this.jdField_a_of_type_AndroidViewView.requestFocusFromTouch())
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " requestFocusFromTouch success ");
              }
              if (!this.jdField_a_of_type_AndroidViewView.requestFocus()) {
                break label277;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " requestFocus success ");
              }
              if (!this.jdField_a_of_type_AndroidViewView.hasFocus()) {
                break label259;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " hasFocus true ");
              }
              localObject1 = (InputMethodManager)getContext().getSystemService("input_method");
              if (!((InputMethodManager)localObject1).showSoftInput(this.jdField_a_of_type_AndroidViewView, 0)) {
                break label295;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput success ");
              }
              if (!((InputMethodManager)localObject1).isActive()) {
                break label535;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " imm.isActive() = true");
              }
              if (this.jdField_b_of_type_AndroidViewView != null) {
                this.jdField_b_of_type_AndroidViewView.setVisibility(8);
              }
            }
          }
          for (;;)
          {
            requestLayout();
            return;
            if (!QLog.isColorLevel()) {
              break label107;
            }
            QLog.e("Q.aio.XPanelContainer", 2, " requestFocusFromTouch fail ");
            break label107;
            if (!QLog.isColorLevel()) {
              break label157;
            }
            QLog.d("Q.aio.XPanelContainer", 2, " hasFocus false ");
            break label157;
            if (!QLog.isColorLevel()) {
              break label157;
            }
            QLog.e("Q.aio.XPanelContainer", 2, " requestFocus fail ");
            break label157;
            if (QLog.isColorLevel()) {
              QLog.e("Q.aio.XPanelContainer", 2, " showSoftInput fail ");
            }
            try
            {
              Object localObject4 = localObject1.getClass();
              Object localObject2 = ((Class)localObject4).getDeclaredField("mServedView");
              localObject4 = ((Class)localObject4).getDeclaredField("mNextServedView");
              ((Field)localObject2).setAccessible(true);
              ((Field)localObject4).setAccessible(true);
              localObject2 = ((Field)localObject2).get(localObject1);
              localObject4 = ((Field)localObject4).get(localObject1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput fail mNextServedObject = " + localObject4 + " mServedObject" + localObject2 + " messageInputer = " + this.jdField_a_of_type_AndroidViewView);
              }
              if ((localObject2 == null) || (this.jdField_a_of_type_AndroidViewView == null) || (localObject2 == this.jdField_a_of_type_AndroidViewView) || (!(localObject2 instanceof View))) {
                break label198;
              }
              ((InputMethodManager)localObject1).hideSoftInputFromWindow(((View)localObject2).getWindowToken(), 0);
              this.jdField_a_of_type_AndroidViewView.requestFocusFromTouch();
              this.jdField_a_of_type_AndroidViewView.requestFocus();
              if ((!((InputMethodManager)localObject1).showSoftInput(this.jdField_a_of_type_AndroidViewView, 0)) && (QLog.isColorLevel())) {
                QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput fail ");
              }
              if (!QLog.isColorLevel()) {
                break label198;
              }
              QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput end");
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
            }
            break label198;
            if (!QLog.isColorLevel()) {
              break label220;
            }
            QLog.d("Q.aio.XPanelContainer", 2, " imm.isActive() = false");
            break label220;
            if (paramInt > 1)
            {
              localObject3 = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
              localObject1 = localObject3;
              if (localObject3 == null) {}
              try
              {
                localObject1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(paramInt);
                if (localObject1 == null) {
                  break;
                }
                addView((View)localObject1);
                this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
                if (localObject1 == this.jdField_b_of_type_AndroidViewView) {
                  continue;
                }
                if (this.jdField_b_of_type_AndroidViewView != null) {
                  this.jdField_b_of_type_AndroidViewView.setVisibility(8);
                }
                ((View)localObject1).setVisibility(0);
                this.jdField_b_of_type_AndroidViewView = ((View)localObject1);
              }
              catch (Exception localException3)
              {
                for (;;)
                {
                  localObject1 = localObject3;
                  if (QLog.isColorLevel())
                  {
                    QLog.d(jdField_a_of_type_JavaLangString, 2, localException3, new Object[0]);
                    localObject1 = localObject3;
                  }
                }
              }
            }
            a();
          }
        }
        if (paramInt == 1)
        {
          if (this.jdField_a_of_type_AndroidViewView.requestFocusFromTouch())
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.XPanelContainer", 2, " requestFocusFromTouch success ");
            }
            if (!this.jdField_a_of_type_AndroidViewView.requestFocus()) {
              break label863;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.XPanelContainer", 2, " requestFocus success ");
            }
            if (!this.jdField_a_of_type_AndroidViewView.hasFocus()) {
              break label845;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.XPanelContainer", 2, " hasFocus true ");
            }
            localObject1 = (InputMethodManager)getContext().getSystemService("input_method");
            if (!((InputMethodManager)localObject1).showSoftInput(this.jdField_a_of_type_AndroidViewView, 0)) {
              break label881;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput success ");
            }
          }
          for (;;)
          {
            if (!((InputMethodManager)localObject1).isActive()) {
              break label1121;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.aio.XPanelContainer", 2, " imm.isActive() = true");
            return;
            if (!QLog.isColorLevel()) {
              break label713;
            }
            QLog.e("Q.aio.XPanelContainer", 2, " requestFocusFromTouch fail ");
            break label713;
            if (!QLog.isColorLevel()) {
              break label763;
            }
            QLog.d("Q.aio.XPanelContainer", 2, " hasFocus false ");
            break label763;
            if (!QLog.isColorLevel()) {
              break label763;
            }
            QLog.e("Q.aio.XPanelContainer", 2, " requestFocus fail ");
            break label763;
            if (QLog.isColorLevel()) {
              QLog.e("Q.aio.XPanelContainer", 2, " showSoftInput fail ");
            }
            try
            {
              Object localObject5 = localObject1.getClass();
              localObject3 = ((Class)localObject5).getDeclaredField("mServedView");
              localObject5 = ((Class)localObject5).getDeclaredField("mNextServedView");
              ((Field)localObject3).setAccessible(true);
              ((Field)localObject5).setAccessible(true);
              localObject3 = ((Field)localObject3).get(localObject1);
              localObject5 = ((Field)localObject5).get(localObject1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput fail mNextServedObject = " + localObject5 + " mServedObject" + localObject3 + " messageInputer = " + this.jdField_a_of_type_AndroidViewView);
              }
              if ((localObject3 != null) && (this.jdField_a_of_type_AndroidViewView != null) && (localObject3 != this.jdField_a_of_type_AndroidViewView) && ((localObject3 instanceof View)))
              {
                ((InputMethodManager)localObject1).hideSoftInputFromWindow(((View)localObject3).getWindowToken(), 0);
                this.jdField_a_of_type_AndroidViewView.requestFocusFromTouch();
                this.jdField_a_of_type_AndroidViewView.requestFocus();
                if ((!((InputMethodManager)localObject1).showSoftInput(this.jdField_a_of_type_AndroidViewView, 0)) && (QLog.isColorLevel())) {
                  QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput fail ");
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput end");
                }
              }
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, " imm.isActive() = false");
          }
        }
        else
        {
          if (paramInt <= 1) {
            break label1502;
          }
          View localView;
          if (paramInt == 3)
          {
            com.tencent.mobileqq.emoticonview.EmoticonMainPanel.jdField_b_of_type_Long = System.currentTimeMillis();
            StartupTracker.a(null, "AIO_EmoticonPanel_OpenDuration");
            localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
            localObject1 = localView;
            if (localView != null) {}
          }
          try
          {
            localObject1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(paramInt);
            if (localObject1 != null)
            {
              addView((View)localObject1);
              this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
              if (localObject1 != this.jdField_b_of_type_AndroidViewView)
              {
                if (this.jdField_b_of_type_AndroidViewView != null) {
                  this.jdField_b_of_type_AndroidViewView.setVisibility(8);
                }
                ((View)localObject1).setVisibility(0);
                this.jdField_b_of_type_AndroidViewView = ((View)localObject1);
              }
              if (this.jdField_h_of_type_Int == 0)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.d("Q.aio.XPanelContainer", 4, " showExternalPanel mAnimationPosition= " + this.q + "mExternalPanelheight=" + jdField_c_of_type_Int);
                }
                if (this.q > 0) {
                  continue;
                }
                this.j = paramInt;
                URLDrawable.pause();
                this.jdField_f_of_type_Boolean = paramBoolean;
                if ((jdField_c_of_type_Boolean) && (paramBoolean))
                {
                  this.jdField_d_of_type_Boolean = true;
                  paramInt = getHeight();
                  int i1 = jdField_c_of_type_Int;
                  localObject1 = ValueAnimator.ofInt(new int[] { paramInt, paramInt - jdField_c_of_type_Int });
                  ((ValueAnimator)localObject1).setDuration(150L);
                  ((ValueAnimator)localObject1).addUpdateListener(new xvu(this, paramInt));
                  ((ValueAnimator)localObject1).start();
                  return;
                  if (paramInt != 21) {
                    break label1160;
                  }
                  StartupTracker.a(null, "apollo_panel_open");
                }
              }
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              localObject1 = localView;
              if (QLog.isColorLevel())
              {
                QLog.d(jdField_a_of_type_JavaLangString, 2, localException4, new Object[0]);
                localObject1 = localView;
              }
            }
            this.q = jdField_c_of_type_Int;
            this.jdField_b_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
            requestLayout();
            return;
          }
        }
      }
      if (this.jdField_h_of_type_Int == 1)
      {
        this.j = paramInt;
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
    } while (this.jdField_h_of_type_Int == paramInt);
    c(paramInt);
    return;
    label1502:
    throw new IllegalArgumentException("wrong argument..must be SOFT_INPUT,EXTERNAL_EMOTICON,EXTERNAL_INPUT");
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public boolean a()
  {
    return a(true);
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.p();
    boolean bool;
    if (this.jdField_h_of_type_Int > 0)
    {
      bool = true;
      if (!jdField_a_of_type_Boolean) {
        break label73;
      }
      if (this.jdField_h_of_type_Int == 1) {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
      }
      this.p = 0;
      requestLayout();
    }
    label73:
    do
    {
      return bool;
      bool = false;
      break;
      if (this.jdField_h_of_type_Int == 1)
      {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        return bool;
      }
    } while (this.jdField_h_of_type_Int <= 1);
    if (this.q > 0) {
      return true;
    }
    this.p = 0;
    this.j = 0;
    if (paramBoolean) {}
    for (int i1 = jdField_c_of_type_Int;; i1 = 0)
    {
      this.q = i1;
      this.jdField_b_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      if ((!jdField_c_of_type_Boolean) || (!paramBoolean)) {
        break;
      }
      this.jdField_e_of_type_Boolean = true;
      i1 = getHeight();
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i1 - jdField_c_of_type_Int, i1 });
      localValueAnimator.setDuration(150L);
      localValueAnimator.addUpdateListener(new xvv(this, i1));
      localValueAnimator.start();
      return bool;
    }
    requestLayout();
    return bool;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.XPanelContainer", 2, " clearAllPanel ");
    }
    int i1 = 0;
    try
    {
      while (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i1));
        if (localView.getParent() != null) {
          removeView(localView);
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      this.jdField_b_of_type_AndroidViewView = null;
      EmoticonPanelViewBinder.b();
    }
  }
  
  public void b(int paramInt)
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      getChildAt(i1).offsetTopAndBottom(paramInt);
      i1 += 1;
    }
    invalidate();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (VersionUtils.f()) {
      if ((paramConfiguration.orientation != this.l) && ((this.m != paramConfiguration.screenWidthDp) || (this.n != paramConfiguration.screenHeightDp)))
      {
        this.l = -1;
        this.n = -1;
        this.n = -1;
        this.k = -1;
        a();
      }
    }
    while (paramConfiguration.orientation == this.l) {
      return;
    }
    this.l = -1;
    this.k = -1;
    a();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1;
    if (((DeviceInfoUtil2.a()) || ((Build.VERSION.SDK_INT >= 21) && (getSystemUiVisibility() == 0))) && (((getContext() instanceof SplashActivity)) || ((getContext() instanceof ChatActivity))))
    {
      if (getParent() != null) {
        ((View)getParent()).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      }
      if (this.jdField_a_of_type_ArrayOfInt[1] >= this.o - 5) {
        break label382;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (DeviceInfoUtil2.a())
      {
        boolean bool2 = AdapterBugsLib.a((Activity)getContext());
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.aio.XPanelContainer", 2, "  isFenPingDevicesForMeizu tmpIsMultiScreen= " + bool2);
          bool1 = bool2;
        }
      }
      if (jdField_a_of_type_Boolean != bool1)
      {
        this.jdField_g_of_type_Boolean = true;
        jdField_a_of_type_Boolean = bool1;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$OnChangeMultiScreenListener != null) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer$OnChangeMultiScreenListener.f(jdField_a_of_type_Boolean);
        }
        this.jdField_b_of_type_Boolean = false;
      }
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_g_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$OnChangeMultiScreenListener != null) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer$OnChangeMultiScreenListener.f(jdField_a_of_type_Boolean);
        }
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, "  multi screen change to normal ");
          }
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView = null;
        }
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        b();
        c(0);
        this.p = 0;
        this.j = -1;
        jdField_c_of_type_Int = jdField_f_of_type_Int;
        jdField_e_of_type_Int = 0;
        try
        {
          paramInt1 = paramInt3 - paramInt1 - this.mPaddingRight;
          paramInt3 = this.mPaddingLeft;
          paramInt2 = paramInt4 - paramInt2 - this.mPaddingBottom;
          paramInt4 = this.mPaddingTop;
          View localView = getChildAt(0);
          localView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4, 1073741824));
          localView.layout(paramInt3, paramInt4, paramInt1, paramInt2);
          return;
          label382:
          bool1 = false;
        }
        catch (Exception localException1)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("Q.aio.XPanelContainer", 2, "  error = " + localException1);
          return;
        }
      }
    }
    int i2 = paramInt4 - paramInt2;
    int i1 = this.jdField_h_of_type_Int;
    Object localObject;
    float f1;
    if ((this.k < 0) && (paramBoolean) && (i2 > 0))
    {
      localObject = getResources().getConfiguration();
      this.l = ((Configuration)localObject).orientation;
      if (VersionUtils.f())
      {
        this.m = ((Configuration)localObject).screenWidthDp;
        this.n = ((Configuration)localObject).screenHeightDp;
      }
      this.k = i2;
      if (getResources().getConfiguration().orientation != 2) {
        break label922;
      }
      f1 = 0.3F * this.k;
      label525:
      int i3 = (int)f1;
      if ((this.k <= i2) || (this.k - i2 <= i3)) {
        break label936;
      }
      bool1 = true;
      label554:
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " onLayout before finalStatus = ", Integer.valueOf(i1), " softInputShowing = ", Boolean.valueOf(bool1), " mStatus = ", Integer.valueOf(this.jdField_h_of_type_Int), " changed = ", Boolean.valueOf(paramBoolean), " mPendingStatus = ", Integer.valueOf(this.j), " mIsMultiScreen = ", Boolean.valueOf(jdField_a_of_type_Boolean), " mCoordinates[1] = ", Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[1]), " mClickStatus = ", Integer.valueOf(this.p) });
      }
      paramInt3 = paramInt3 - paramInt1 - this.mPaddingRight;
      i2 = this.mPaddingLeft;
      paramInt2 = paramInt4 - paramInt2 - this.mPaddingBottom;
      paramInt4 = this.mPaddingTop;
      localObject = getChildAt(0);
    }
    for (;;)
    {
      try
      {
        if (!jdField_a_of_type_Boolean) {
          break label1123;
        }
        jdField_c_of_type_Int = jdField_f_of_type_Int;
        jdField_e_of_type_Int = 0;
        if (this.p != 1) {
          break label942;
        }
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4, 1073741824));
        ((View)localObject).layout(i2, paramInt4, paramInt3, paramInt2);
        c(this.p);
        this.j = 0;
        return;
      }
      catch (Exception localException2)
      {
        QLog.e("Q.aio.XPanelContainer", 1, "main.getContext: " + ((View)localObject).getContext() + " \n " + localException2.toString() + " crash happen restore init status", localException2);
        if (this.jdField_b_of_type_AndroidViewView != null) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        c(0);
        this.j = -1;
        requestLayout();
        return;
      }
      if (i2 <= this.k) {
        break;
      }
      this.k = i2;
      break;
      label922:
      f1 = 0.2F * this.k;
      break label525;
      label936:
      bool1 = false;
      break label554;
      label942:
      if (this.p == 0)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4, 1073741824));
        ((View)localObject).layout(i2, paramInt4, paramInt3, paramInt2);
      }
      else
      {
        if ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0))
        {
          this.p = 0;
          this.j = -1;
          c(this.p);
          requestLayout();
          return;
        }
        this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_f_of_type_Int, 1073741824));
        this.jdField_b_of_type_AndroidViewView.layout(i2, paramInt2 - jdField_f_of_type_Int, paramInt3, paramInt2);
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4 - jdField_f_of_type_Int, 1073741824));
        ((View)localObject).layout(i2, paramInt4, paramInt3, paramInt2 - jdField_f_of_type_Int);
      }
    }
    label1123:
    if (((!bool1) || (this.jdField_h_of_type_Int == 1)) && (this.jdField_g_of_type_Int == 0)) {
      this.jdField_g_of_type_Int = paramInt2;
    }
    if (getResources().getConfiguration().orientation == 2)
    {
      if (jdField_e_of_type_Int != 0) {
        b();
      }
      jdField_e_of_type_Int = 0;
      jdField_c_of_type_Int = jdField_f_of_type_Int;
    }
    if ((bool1) && (this.jdField_h_of_type_Int != 1))
    {
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4, 1073741824));
      ((View)localObject).layout(i2, paramInt4, paramInt3, paramInt2);
      paramInt1 = this.jdField_g_of_type_Int - paramInt2;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " onLayout inputHeight ", Integer.valueOf(paramInt1), " mExternalPanelheight = ", Integer.valueOf(jdField_c_of_type_Int), " mDefaultExternalPanelheight = ", Integer.valueOf(jdField_f_of_type_Int), " mAddedHeight = ", Integer.valueOf(jdField_e_of_type_Int) });
      }
      if ((getResources().getConfiguration().orientation == 1) && (jdField_c_of_type_Int != paramInt1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.XPanelContainer", 2, " mExternalPanelheight=" + jdField_c_of_type_Int + " inputHeight=" + paramInt1 + " mDefaultExternalPanelheight=" + jdField_f_of_type_Int + " mMAXHExternalPanelheight=" + jdField_d_of_type_Int + " mAnimationPosition=" + this.q);
        }
        if (this.q == 0)
        {
          if (paramInt1 <= jdField_f_of_type_Int) {
            break label1649;
          }
          if (paramInt1 <= jdField_d_of_type_Int) {
            break label1642;
          }
          if (jdField_d_of_type_Int <= jdField_f_of_type_Int) {
            break label1633;
          }
          jdField_c_of_type_Int = jdField_d_of_type_Int;
          label1454:
          jdField_e_of_type_Int = jdField_c_of_type_Int - jdField_f_of_type_Int;
        }
        b();
        if (QLog.isColorLevel()) {
          QLog.d("XPanelContainer", 2, "mExternalPanelheight=" + jdField_c_of_type_Int + "mAddedHeight=" + jdField_e_of_type_Int);
        }
      }
      label1513:
      if ((!paramBoolean) || (!bool1)) {
        break label2563;
      }
      paramInt1 = 1;
      this.j = -1;
    }
    for (;;)
    {
      c(paramInt1);
      this.p = paramInt1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " onLayout after finalStatus = ", Integer.valueOf(paramInt1), " softInputShowing = ", Boolean.valueOf(bool1), " mStatus = ", Integer.valueOf(this.jdField_h_of_type_Int), " changed = ", Boolean.valueOf(paramBoolean), " mPendingStatus = ", Integer.valueOf(this.j) });
      return;
      label1633:
      jdField_c_of_type_Int = jdField_f_of_type_Int;
      break label1454;
      label1642:
      jdField_c_of_type_Int = paramInt1;
      break label1454;
      label1649:
      jdField_c_of_type_Int = jdField_f_of_type_Int;
      break label1454;
      if ((this.j > 1) && ((!bool1) || (paramBoolean)))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel mannule layout  =  softInputShowing " + bool1 + " changed = " + paramBoolean);
        }
        if ((bool1) && (paramBoolean))
        {
          requestLayout();
          return;
        }
        c();
        if ((jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean)) {
          if (this.jdField_d_of_type_Boolean) {
            paramInt1 = this.q;
          }
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_c_of_type_Int, 1073741824));
          this.jdField_b_of_type_AndroidViewView.layout(i2, paramInt2 - paramInt1, paramInt3, paramInt2 - paramInt1 + jdField_c_of_type_Int);
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel mannule layout calcposition d= " + paramInt1 + "mAnimationPosition = " + this.q + "isOpenAnim=" + this.jdField_d_of_type_Boolean + "mExternalPanelheight=" + jdField_c_of_type_Int);
          }
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4 - paramInt1, 1073741824));
          ((View)localObject).layout(i2, paramInt4, paramInt3, paramInt2 - paramInt1);
          if ((this.jdField_d_of_type_Boolean) || (this.q != 0)) {
            break label2027;
          }
          c(this.j);
          this.j = -1;
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel mannule layout,end ，not canvas =  isOpenAnim " + this.jdField_d_of_type_Boolean + " mAnimationPosition = " + this.q);
          return;
          paramInt1 = jdField_c_of_type_Int;
          continue;
          if (!this.jdField_f_of_type_Boolean) {
            this.jdField_f_of_type_Boolean = true;
          }
          paramInt1 = jdField_c_of_type_Int - this.q;
        }
        label2027:
        if (jdField_c_of_type_Boolean) {
          break;
        }
        postDelayed(this, 1L);
        return;
      }
      if ((this.j == 0) && (this.jdField_h_of_type_Int > 1))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.aio.XPanelContainer", 4, " onLayout reget =  mAnimationPosition = " + this.q);
        }
        c();
        this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_c_of_type_Int, 1073741824));
        this.jdField_b_of_type_AndroidViewView.layout(i2, paramInt2 - this.q, paramInt3, paramInt2 - this.q + jdField_c_of_type_Int);
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4 - this.q, 1073741824));
        ((View)localObject).layout(i2, paramInt4, paramInt3, paramInt2 - this.q);
        if (this.q == 0)
        {
          c(this.j);
          this.j = -1;
          return;
        }
        if (jdField_c_of_type_Boolean) {
          break;
        }
        postDelayed(this, 1L);
        return;
      }
      if ((this.jdField_h_of_type_Int > 1) && (!bool1))
      {
        if (QLog.isDevelopLevel()) {
          if (this.jdField_b_of_type_AndroidViewView != null) {
            break label2355;
          }
        }
        label2355:
        for (paramInt1 = 0;; paramInt1 = this.jdField_b_of_type_AndroidViewView.getVisibility())
        {
          QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel ,confirm it mExternalPanelheight= " + jdField_c_of_type_Int + " bottom = " + paramInt2 + "  mCurPanel.getVisibility() " + paramInt1);
          if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) {
            break;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout panel hold on error ,restore status NONE ");
          }
          c(0);
          this.j = -1;
          requestLayout();
          return;
        }
        if (QLog.isDevelopLevel())
        {
          ViewParent localViewParent = this.jdField_b_of_type_AndroidViewView.getParent();
          QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel ,confirm it vp.ViewParent = " + localViewParent.getClass().getName());
        }
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4 - jdField_c_of_type_Int, 1073741824));
        ((View)localObject).layout(i2, paramInt4, paramInt3, paramInt2 - jdField_c_of_type_Int);
        this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_c_of_type_Int, 1073741824));
        this.jdField_b_of_type_AndroidViewView.layout(i2, paramInt2 - jdField_c_of_type_Int, paramInt3, paramInt2);
        break label1513;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.aio.XPanelContainer", 4, " onLayout use default layout = ");
      }
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - paramInt4, 1073741824));
      ((View)localObject).layout(i2, paramInt4, paramInt3, paramInt2);
      break label1513;
      label2563:
      if (this.j != 0)
      {
        paramInt1 = i1;
        if (paramBoolean)
        {
          paramInt1 = i1;
          if (bool1) {}
        }
      }
      else
      {
        paramInt1 = 0;
        this.j = -1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), getDefaultSize(getSuggestedMinimumHeight(), paramInt2));
  }
  
  public void run()
  {
    requestLayout();
  }
  
  public void setOnChangeMultiScreenListener(XPanelContainer.OnChangeMultiScreenListener paramOnChangeMultiScreenListener)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer$OnChangeMultiScreenListener = paramOnChangeMultiScreenListener;
  }
  
  public void setOnPanelChangeListener(XPanelContainer.PanelCallback paramPanelCallback)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback = paramPanelCallback;
  }
  
  public void setReadyToShow(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\XPanelContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */