package com.tencent.av.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.ui.GLView.OnTouchListener;
import com.tencent.av.opengl.ui.GLViewGroup;
import com.tencent.av.opengl.ui.animation.GLAnimation;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.utils.UITools;
import com.tencent.av.widget.RotateLayout;
import com.tencent.av.widget.RotateLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;
import com.tencent.qphone.base.util.QLog;
import gzz;
import haa;
import hab;
import hac;
import had;
import hae;
import haf;
import hag;
import hah;
import hai;
import haj;
import hak;
import hal;
import ham;
import han;
import hap;
import haq;
import java.util.LinkedList;
import java.util.List;

public class VideoLayerUI
  extends GLViewGroup
{
  static final String jdField_a_of_type_JavaLangString = "VideoLayerUI";
  static final int j = 0;
  static final int k = 1;
  static final int l = 2;
  static final int p = 3000;
  static final int q = 3000;
  public int a;
  private long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext = null;
  Display jdField_a_of_type_AndroidViewDisplay;
  public GestureDetector a;
  public ScaleGestureDetector a;
  public View a;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public VideoController a;
  public VideoAppInterface a;
  public EffectsRenderController a;
  public MoveGestureDetector a;
  GLRootView jdField_a_of_type_ComTencentAvOpenglUiGLRootView = null;
  GLView.OnTouchListener jdField_a_of_type_ComTencentAvOpenglUiGLView$OnTouchListener = null;
  VideoLayerUI.SmallScreenListener jdField_a_of_type_ComTencentAvUiVideoLayerUI$SmallScreenListener = null;
  public RotateLayout a;
  ham jdField_a_of_type_Ham = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new haa(this);
  public List a;
  boolean jdField_a_of_type_Boolean = false;
  public GLVideoView[] a;
  public int b;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  Runnable jdField_b_of_type_JavaLangRunnable = new hab(this);
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public Runnable c;
  boolean c;
  public int d;
  public Runnable d;
  boolean d;
  public int e;
  boolean e;
  public int f;
  public boolean f;
  int g;
  public boolean g;
  int h = 0;
  public int i = 2;
  public int m = 0;
  int n = 0;
  int o = 0;
  int r = 0;
  
  public VideoLayerUI(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView)
  {
    this(paramVideoAppInterface, paramContext, paramView, false, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VideoLayerUI(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView, boolean paramBoolean, VideoLayerUI.SmallScreenListener paramSmallScreenListener)
  {
    super(paramContext);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView = null;
    this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector = null;
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = null;
    this.jdField_g_of_type_Int = 0;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = null;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_c_of_type_JavaLangRunnable = new han(this);
    this.jdField_d_of_type_JavaLangRunnable = new hai(this);
    this.jdField_g_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "onCreate:" + this + ", isSmallScreen:" + paramBoolean + ", VideoAppInterface:" + paramVideoAppInterface + ", rootView:" + paramView);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.jdField_g_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$SmallScreenListener = paramSmallScreenListener;
    paramVideoAppInterface = paramContext.getSharedPreferences("qav_SP", 0);
    if (this.jdField_g_of_type_Boolean) {}
    for (int i1 = 2;; i1 = paramVideoAppInterface.getInt("video_position", 3))
    {
      this.i = i1;
      j();
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299420));
      if (paramBoolean) {
        m();
      }
      return;
    }
  }
  
  private Boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  static final String a(CharSequence paramCharSequence)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramCharSequence);
    int i1 = paramCharSequence.length();
    QQText.EmotcationSpan[] arrayOfEmotcationSpan = (QQText.EmotcationSpan[])((QQText)paramCharSequence).getSpans(0, i1, QQText.EmotcationSpan.class);
    i1 = 0;
    int i3;
    for (int i2 = 0; i1 < arrayOfEmotcationSpan.length; i2 = i3)
    {
      Object localObject = arrayOfEmotcationSpan[i1];
      i3 = i2;
      if ((localObject instanceof QQText.EmotcationSpan))
      {
        int i4 = ((QQText)paramCharSequence).getSpanStart(localObject);
        int i5 = ((QQText)paramCharSequence).getSpanEnd(localObject);
        i3 = i2;
        if (((QQText.EmotcationSpan)localObject).jdField_c_of_type_Int == 2)
        {
          localObject = ((QQText.EmotcationSpan)localObject).a();
          localStringBuffer.replace(i4 + i2, i5 + i2, (String)localObject);
          i3 = i2 + (((String)localObject).length() - (i5 - i4));
        }
      }
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 300L) {
      return;
    }
    GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2];
    int i1;
    if (this.jdField_g_of_type_Boolean)
    {
      i1 = (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 2.0F);
      localGLVideoView.a(Boolean.valueOf(true));
      localGLVideoView.a(i1, i1, i1, i1);
    }
    for (;;)
    {
      i1 = localGLVideoView.i();
      localGLVideoView.h(1);
      float f1 = localGLVideoView.b().left;
      float f2 = localGLVideoView.b().top;
      Rect localRect = super.a();
      GLAnimation localGLAnimation = new GLAnimation();
      localGLAnimation.b(300);
      localGLAnimation.a(f1, f2, 0.0F, -localRect.left, -localRect.top, 0.0F);
      localGLAnimation.a(localGLVideoView.b().width(), localGLVideoView.b().height(), super.g() + localRect.left + localRect.right, super.h() + localRect.top + localRect.bottom);
      localGLAnimation.a(new haf(this, paramInt2, i1, paramInt1));
      localGLAnimation.a(2);
      localGLVideoView.a(localGLAnimation);
      localGLVideoView.x();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      localGLVideoView.a(Boolean.valueOf(false));
      localGLVideoView.a(0, 0, 0, 0);
    }
  }
  
  int a()
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length; i2 = i3)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      String str = (String)localGLVideoView.a(0);
      i3 = i2;
      if (localGLVideoView.f() == 0)
      {
        i3 = i2;
        if (!TextUtils.isEmpty(str)) {
          i3 = i2 + 1;
        }
      }
      i1 += 1;
    }
    return i2;
  }
  
  int a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView == null) {
      return -1;
    }
    GLVideoView localGLVideoView;
    do
    {
      paramInt += 1;
      if (paramInt >= this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) {
        break label57;
      }
      localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt];
      i1 = paramInt;
      if (TextUtils.isEmpty((String)localGLVideoView.a(0))) {
        break;
      }
    } while (localGLVideoView.f() != 1);
    label57:
    for (int i1 = paramInt;; i1 = -1) {
      return i1;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i2 = 0;
    int i1 = 1;
    int i4 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131493892);
    int i3 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131493893);
    if (paramInt4 - paramInt2 > i4)
    {
      paramInt2 = 1;
      if (paramInt5 - paramInt3 <= i3) {
        break label106;
      }
      paramInt4 = 1;
      label65:
      paramInt5 = d();
      if (paramInt5 != 3) {
        break label174;
      }
      if (paramInt1 != 1) {
        break label126;
      }
      paramInt3 = 3;
    }
    label106:
    label126:
    label164:
    label174:
    label225:
    label235:
    label299:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return paramInt3;
                            if (paramInt4 - paramInt2 < -i4)
                            {
                              paramInt2 = 2;
                              break;
                            }
                            paramInt2 = 0;
                            break;
                            paramInt4 = i2;
                            if (paramInt5 - paramInt3 >= -i3) {
                              break label65;
                            }
                            paramInt4 = 2;
                            break label65;
                            if (paramInt1 == 2) {
                              return 3;
                            }
                            if (paramInt1 == 4) {
                              return 3;
                            }
                            paramInt3 = i1;
                          } while (paramInt1 != 3);
                          if (paramInt2 != 2) {
                            break label164;
                          }
                          paramInt3 = i1;
                        } while (paramInt4 == 2);
                        return 4;
                        if (paramInt4 == 2) {
                          return 2;
                        }
                        return 3;
                        if (paramInt5 != 2) {
                          break label235;
                        }
                        if (paramInt1 == 1) {
                          return 2;
                        }
                        if (paramInt1 == 3) {
                          return 2;
                        }
                        if (paramInt1 == 4) {
                          return 2;
                        }
                        paramInt3 = i1;
                      } while (paramInt1 != 2);
                      if (paramInt2 != 2) {
                        break label225;
                      }
                      paramInt3 = i1;
                    } while (paramInt4 != 1);
                    return 4;
                    if (paramInt4 == 1) {
                      return 3;
                    }
                    return 2;
                    if (paramInt5 != 1) {
                      break label299;
                    }
                    paramInt3 = i1;
                  } while (paramInt1 == 2);
                  paramInt3 = i1;
                } while (paramInt1 == 3);
                paramInt3 = i1;
              } while (paramInt1 == 4);
              paramInt3 = i1;
            } while (paramInt1 != 1);
            if (paramInt2 == 1)
            {
              if (paramInt4 == 1) {
                return 3;
              }
              return 2;
            }
            paramInt3 = i1;
          } while (paramInt4 != 1);
          return 4;
          paramInt3 = i1;
        } while (paramInt5 != 4);
        if (paramInt1 == 1) {
          return 4;
        }
        if (paramInt1 == 2) {
          return 4;
        }
        if (paramInt1 == 3) {
          return 4;
        }
        paramInt3 = i1;
      } while (paramInt1 != 4);
      if (paramInt2 == 1)
      {
        if (paramInt4 == 2) {
          return 2;
        }
        return 3;
      }
      paramInt3 = i1;
    } while (paramInt4 == 2);
    return 4;
  }
  
  int a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        if ((paramString.equals((String)localGLVideoView.a(0))) && (Integer.valueOf(paramInt).equals(localGLVideoView.a(1))) && (localGLVideoView.f() == 0)) {
          return i1;
        }
        i1 += 1;
      }
    }
    return -1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "switchVideo index1: " + paramInt1 + ", index2: " + paramInt2);
    }
    if ((paramInt1 == paramInt2) || (paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) || (paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoLayerUI", 2, "switchVideo index invalid!");
      }
      return;
    }
    if ((paramInt2 == 0) || (this.jdField_g_of_type_Boolean))
    {
      b(paramInt1, paramInt2);
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
    if (i1 == 2) {}
    while (i1 != 4)
    {
      d(paramInt1, paramInt2);
      return;
    }
    if (paramInt1 == 0) {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
    }
    for (;;)
    {
      String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      String str2 = (String)this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(0);
      String str3 = (String)this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(0);
      if ((str1.equals(str2)) || (!str1.equals(str3))) {
        break;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      break;
      if (paramInt2 == 0) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "setOffset topOffset: " + paramInt1 + ", bottomOffset: " + paramInt2);
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    f(true);
    f(this.m);
    int i2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
    Object localObject;
    if (i2 == 4)
    {
      int i1;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().z)
      {
        i1 = 0;
        if (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
        {
          localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
          if (i1 == 0) {
            if ((paramInt1 != 0) && (paramInt2 != 0)) {
              ((GLVideoView)localObject).d(false);
            }
          }
          for (;;)
          {
            i1 += 1;
            break;
            ((GLVideoView)localObject).d(true);
            continue;
            ((GLVideoView)localObject).d(true);
          }
        }
      }
      else
      {
        i1 = 0;
        while (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].d(false);
          i1 += 1;
        }
      }
    }
    if ((i2 == 2) || (i2 == 4)) {
      if (((paramInt1 <= 0) || (paramInt2 <= 0)) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8) && (!this.jdField_e_of_type_Boolean) && (paramBoolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoLayerUI", 2, "setOffset video show qq logo");
        }
        this.jdField_e_of_type_Boolean = paramBoolean;
        if (paramInt2 != 0)
        {
          paramInt1 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131494171);
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = (paramInt1 + paramInt2);
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        localObject = new Transformation();
        ((Transformation)localObject).setAlpha(0.0F);
        localAlphaAnimation = (AlphaAnimation)this.jdField_a_of_type_AndroidWidgetImageView.getAnimation();
        if (localAlphaAnimation != null)
        {
          localAlphaAnimation.setAnimationListener(null);
          localAlphaAnimation.getTransformation(System.currentTimeMillis(), (Transformation)localObject);
        }
        f1 = ((Transformation)localObject).getAlpha();
        this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        localObject = new AlphaAnimation(f1, 1.0F);
        ((AlphaAnimation)localObject).setDuration(800L);
        ((AlphaAnimation)localObject).setFillAfter(true);
        ((AlphaAnimation)localObject).setFillBefore(true);
        this.jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      AlphaAnimation localAlphaAnimation;
      float f1;
      do
      {
        return;
      } while ((paramInt1 <= 0) || (paramInt2 <= 0) || (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) || (!this.jdField_e_of_type_Boolean) || (paramBoolean));
      if (QLog.isColorLevel()) {
        QLog.d("VideoLayerUI", 2, "setOffset video hide qq logo");
      }
      this.jdField_e_of_type_Boolean = paramBoolean;
      paramInt1 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131494171);
      if (((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).bottomMargin != paramInt1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setDuration(500L);
      ((AlphaAnimation)localObject).setFillAfter(true);
      ((AlphaAnimation)localObject).setAnimationListener(new hae(this));
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "setOffset audio hide qq logo");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if ((!this.jdField_c_of_type_Boolean) && (!d())) {
      this.h = paramInt;
    }
    while ((paramInt == this.jdField_g_of_type_Int) && (paramInt != this.h)) {
      return;
    }
    if (paramInt % 90 != this.jdField_g_of_type_Int % 90) {
      this.jdField_c_of_type_Int = 0;
    }
    this.jdField_g_of_type_Int = paramInt;
    this.h = paramInt;
    int i1;
    if (paramBoolean)
    {
      i1 = this.jdField_a_of_type_AndroidViewDisplay.getRotation();
      CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(true);
      i1 = (i1 * 90 + paramInt) % 360;
      label102:
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
      {
        if (this.m != 0)
        {
          paramBoolean = bool;
          if (this.m != 180) {}
        }
        else
        {
          paramBoolean = true;
        }
        f(paramBoolean);
      }
      if (Build.VERSION.SDK_INT < 11) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setPivotX(this.jdField_a_of_type_AndroidWidgetImageView.getWidth() / 2);
      this.jdField_a_of_type_AndroidWidgetImageView.setPivotY(this.jdField_a_of_type_AndroidWidgetImageView.getHeight() / 2);
      if (paramInt % 180 != 0) {
        break label437;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setRotation(paramInt);
      return;
      CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(false);
      i1 = paramInt;
      break label102;
      int i2 = 0;
      while (i2 < super.m())
      {
        super.a(i2).a(i1);
        i2 += 1;
      }
      f(i1);
      this.m = i1;
      continue;
      i2 = 0;
      while (i2 < super.m())
      {
        super.a(i2).a(i1);
        i2 += 1;
      }
      f(i1);
      this.m = i1;
      continue;
      i2 = 0;
      while (i2 < super.m())
      {
        super.a(i2).a(i1);
        i2 += 1;
      }
      f(i1);
      this.m = i1;
      continue;
      i2 = 0;
      while (i2 < super.m())
      {
        super.a(i2).a(i1);
        i2 += 1;
      }
      f(i1);
      this.m = i1;
    }
    label437:
    this.jdField_a_of_type_AndroidWidgetImageView.setRotation((paramInt + 180) % 360);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      k();
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(RecvMsg paramRecvMsg)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1011) {
      return;
    }
    String str1 = paramRecvMsg.d();
    String str2 = paramRecvMsg.b();
    String str3 = paramRecvMsg.c();
    String str4 = paramRecvMsg.e();
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "onReceiveMsg friendUin: " + str1 + ", senderUin: " + str2 + ", senderName: " + str3 + ", msg: " + str4);
    }
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout != null))
    {
      paramRecvMsg = this.jdField_a_of_type_ComTencentAvWidgetRotateLayout;
      if (this.jdField_g_of_type_Boolean) {}
      for (int i1 = 8;; i1 = 4)
      {
        paramRecvMsg.setVisibility(i1);
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      k();
    }
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.isShown())
    {
      if (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getTag()).longValue() >= 3000L)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        b(paramRecvMsg);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 3000L);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 3000L);
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecvMsg);
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    b(paramRecvMsg);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 3000L);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 3000L);
  }
  
  public void a(GLVideoView paramGLVideoView, float paramFloat, long paramLong)
  {
    paramLong /= 10L;
    a(new hag(this, paramLong, paramGLVideoView, (float)Math.pow(paramFloat, 1.0D / paramLong)));
  }
  
  public void a(GLVideoView paramGLVideoView, boolean paramBoolean)
  {
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(200);
    localGLAnimation.b(0.0F, 0.0F, 0.0F, 90.0F, 0.0F, 0.0F);
    localGLAnimation.a(new hac(this, paramGLVideoView, paramBoolean));
    localGLAnimation.a(1);
    paramGLVideoView.a(localGLAnimation);
    paramGLVideoView.x();
  }
  
  public void a(VideoLayerUI.SmallScreenListener paramSmallScreenListener)
  {
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$SmallScreenListener = paramSmallScreenListener;
  }
  
  public void a(String paramString, int paramInt)
  {
    paramInt = a(paramString, paramInt);
    if (paramInt >= 0)
    {
      paramString = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt];
      if (paramInt != 0) {
        break label48;
      }
      if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int != 0)) {
        paramString.d(false);
      }
    }
    else
    {
      return;
    }
    paramString.d(true);
    return;
    label48:
    paramString.d(true);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    int i1 = a(paramString, paramInt1);
    GLVideoView localGLVideoView;
    if (i1 >= 0)
    {
      localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      localGLVideoView.a(0, paramString);
      localGLVideoView.a(1, Integer.valueOf(paramInt2));
      String str1 = paramString + "_" + paramInt1;
      String str2 = paramString + "_" + paramInt2;
      GraphicRenderMgr.getInstance().setGlRender(str1, null);
      GraphicRenderMgr.getInstance().setGlRender(str2, null);
      GraphicRenderMgr.getInstance().setGlRender(str2, localGLVideoView.a());
      if ((i1 != 0) || ((paramInt2 != 5) && (paramInt2 != 2))) {
        break label207;
      }
      localGLVideoView.e(false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoLayerUI", 2, "onVideoSrcTypeChanged uin: " + paramString + ", oldVideoSrcType: " + paramInt1 + ", newVideoSrcType: " + paramInt2 + ", index: " + i1);
      }
      return;
      label207:
      localGLVideoView.e(true);
    }
  }
  
  public void a(String paramString, int paramInt, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i3 = 1;
    int i1 = a(paramString, paramInt);
    int i2 = i1;
    GLVideoView localGLVideoView;
    boolean bool;
    if (i1 < 0)
    {
      i1 = a(0);
      if (i1 >= 0)
      {
        localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        localGLVideoView.g(0);
        n();
        o();
        localGLVideoView.a(0, paramString);
        localGLVideoView.a(1, Integer.valueOf(paramInt));
        String str = paramString + "_" + paramInt;
        GraphicRenderMgr.getInstance().setGlRender(str, null);
        GraphicRenderMgr.getInstance().setGlRender(str, localGLVideoView.a());
        if (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()))
        {
          bool = false;
          this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int, false, bool);
        }
      }
      else
      {
        if ((!paramBoolean2) || (i1 <= 0)) {
          break label378;
        }
        a(0, i1);
        i1 = 0;
      }
    }
    label378:
    for (;;)
    {
      i2 = i1;
      if (i1 > 0) {}
      for (i2 = i3;; i2 = i3)
      {
        if (i1 >= 0)
        {
          localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
          localGLVideoView.b(paramBitmap);
          localGLVideoView.g(paramBoolean1);
          if (!paramBoolean1) {
            localGLVideoView.e(false);
          }
        }
        if (i2 != 0)
        {
          if (this.jdField_a_of_type_Ham != null)
          {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Ham);
            this.jdField_a_of_type_Ham = null;
            f(false);
          }
          this.jdField_a_of_type_Ham = new ham(this, i1);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_Ham);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoLayerUI", 2, "setBackground uin: " + paramString + ", videoSrcType: " + paramInt + ", index: " + i1 + ", needRenderVideo: " + paramBoolean1);
        }
        return;
        bool = true;
        break;
        i3 = 0;
        i1 = i2;
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, float paramFloat, int paramInt2)
  {
    boolean bool = false;
    int i1 = a(paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "setText uin: " + paramString1 + ", videoSrcType: " + paramInt1 + ", text: " + paramString2 + ", textSize: " + paramFloat + ", textColor: " + paramInt2 + ", index: " + i1);
    }
    if (i1 >= 0)
    {
      paramString1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      paramString1.g(0);
      n();
      o();
      paramString1.a(paramString2);
      paramString1.c(paramFloat);
      paramString1.d(paramInt2);
      if (i1 != 0) {
        bool = true;
      }
      paramString1.c(bool);
      if (i1 != 0) {
        break label194;
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2) && (!this.jdField_g_of_type_Boolean)) {
        paramString1.a("");
      }
    }
    else
    {
      return;
    }
    paramString1.c(12);
    return;
    label194:
    paramString1.c(Integer.MAX_VALUE);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "setRemoteHasVideo uin: " + paramString + ", videoSrcType: " + paramInt + ", isRemoteHasVideo: " + paramBoolean1 + ", forceToBigView: " + paramBoolean2 + ", mIsLocalHasVideo: " + this.jdField_c_of_type_Boolean + ", isPC: " + paramBoolean3);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()))) {
      break label108;
    }
    label108:
    while ((Utils.a(this.jdField_a_of_type_AndroidContentContext) == 1) || (!VcSystemInfo.d())) {
      return;
    }
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2)) && (!paramBoolean2) && (!b())) {}
    for (boolean bool = true;; bool = paramBoolean2)
    {
      if (paramBoolean1)
      {
        localObject = null;
        i1 = a(paramString, paramInt);
        String str = paramString + "_" + paramInt;
        if (i1 < 0)
        {
          i1 = a(0);
          if (i1 >= 0)
          {
            localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
            ((GLVideoView)localObject).a(0, paramString);
            ((GLVideoView)localObject).a(1, Integer.valueOf(paramInt));
            GraphicRenderMgr.getInstance().setGlRender(str, ((GLVideoView)localObject).a());
            this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int, false, true);
          }
          paramInt = i1;
          paramString = (String)localObject;
          if (i1 <= 1) {
            break label548;
          }
          paramInt = i1;
          paramString = (String)localObject;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4) {
            break label548;
          }
          paramInt = 1;
          label319:
          if (localObject != null)
          {
            ((GLVideoView)localObject).a(paramBoolean3);
            ((GLVideoView)localObject).b(false);
            if ((!this.jdField_g_of_type_Boolean) && (paramBoolean2)) {
              break label563;
            }
            paramBoolean1 = true;
            label351:
            ((GLVideoView)localObject).e(paramBoolean1);
            ((GLVideoView)localObject).g(0);
            n();
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4) {
              break label579;
            }
            if (i1 != 0) {
              break label568;
            }
            ((GLVideoView)localObject).a(ImageView.ScaleType.CENTER_INSIDE);
          }
          label394:
          if ((bool) && (i1 > 0))
          {
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {
              break label604;
            }
            a(0, i1);
          }
        }
        for (;;)
        {
          if ((this.jdField_g_of_type_Boolean) && (i1 > 0)) {
            o();
          }
          if (paramInt == 0) {
            break;
          }
          if (this.jdField_a_of_type_Ham != null)
          {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Ham);
            this.jdField_a_of_type_Ham = null;
            f(false);
          }
          this.jdField_a_of_type_Ham = new ham(this, i1);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_Ham);
          return;
          paramString = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
          GraphicRenderMgr.getInstance().setGlRender(str, paramString.a());
          this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int, false, true);
          paramInt = i1;
          label548:
          int i2 = 0;
          i1 = paramInt;
          paramInt = i2;
          localObject = paramString;
          break label319;
          label563:
          paramBoolean1 = false;
          break label351;
          label568:
          ((GLVideoView)localObject).a(ImageView.ScaleType.CENTER_CROP);
          break label394;
          label579:
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2) {
            break label394;
          }
          ((GLVideoView)localObject).a(ImageView.ScaleType.CENTER_INSIDE);
          break label394;
          label604:
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean) {
            a(0, i1);
          }
        }
      }
      int i1 = a(paramString, paramInt);
      if (i1 < 0) {
        break;
      }
      paramString = paramString + "_" + paramInt;
      Object localObject = GraphicRenderMgr.getInstance();
      ((GraphicRenderMgr)localObject).flushGlRender(paramString);
      ((GraphicRenderMgr)localObject).setGlRender(paramString, null);
      this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int, true, true);
      b(i1);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299421);
    if (paramBoolean)
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "onLayout|left: " + paramInt1 + ", top: " + paramInt2 + ", right: " + paramInt3 + ", bottom: " + paramInt4);
    }
    f(false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(2131299421).isShown();
  }
  
  boolean a(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    if ((paramCharSequence instanceof QQText))
    {
      paramCharSequence = (QQText.EmotcationSpan[])((QQText)paramCharSequence).getSpans(0, paramCharSequence.length(), QQText.EmotcationSpan.class);
      i1 = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 < paramCharSequence.length)
      {
        if (paramCharSequence[i1].jdField_c_of_type_Int == 2) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return a(paramString, paramInt) >= 0;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "setLocalHasVideo isLocalHasVideo: " + paramBoolean1 + ", forceToBigView: " + paramBoolean2 + ", mIsLocalHasVideo: " + this.jdField_c_of_type_Boolean);
    }
    if ((!VcSystemInfo.d()) || (Utils.a(this.jdField_a_of_type_AndroidContentContext) == 1)) {
      return false;
    }
    Object localObject2;
    int i1;
    String str;
    int i3;
    Object localObject1;
    if (paramBoolean1)
    {
      ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
      localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      i1 = a((String)localObject2, 1);
      str = (String)localObject2 + "_" + 1;
      if (i1 < 0)
      {
        i3 = a(0);
        if (i3 < 0) {
          break label650;
        }
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3];
        ((GLVideoView)localObject1).a(0, localObject2);
        ((GLVideoView)localObject1).a(1, Integer.valueOf(1));
        GraphicRenderMgr.getInstance().setAccountUin((String)localObject2);
        GraphicRenderMgr.getInstance().setGlRender(str, ((GLVideoView)localObject1).a());
        this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int, false, false);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      i1 = i3;
      int i2;
      if (i3 > 1)
      {
        localObject2 = localObject1;
        i1 = i3;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4)
        {
          i2 = 1;
          i1 = i3;
          if (localObject1 != null)
          {
            ((GLVideoView)localObject1).a(false);
            ((GLVideoView)localObject1).e(false);
            ((GLVideoView)localObject1).g(true);
            ((GLVideoView)localObject1).g(0);
            ((GLVideoView)localObject1).a(ImageView.ScaleType.CENTER_CROP);
            if (CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).c()) {
              ((GLVideoView)localObject1).b(CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
            }
            n();
          }
          if ((!this.jdField_g_of_type_Boolean) || (i1 != 0)) {
            break label459;
          }
          i3 = e();
          if (i3 <= 0) {
            break label647;
          }
          a(i1, i3);
          i1 = i3;
        }
      }
      label356:
      label459:
      label647:
      for (;;)
      {
        i3 = i1;
        if (i2 != 0)
        {
          if (this.jdField_a_of_type_Ham != null)
          {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Ham);
            this.jdField_a_of_type_Ham = null;
            f(false);
          }
          this.jdField_a_of_type_Ham = new ham(this, i3);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_Ham);
        }
        for (;;)
        {
          this.jdField_c_of_type_Boolean = paramBoolean1;
          return true;
          localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
          GraphicRenderMgr.getInstance().setGlRender(str, ((GLVideoView)localObject2).a());
          i2 = 0;
          localObject1 = localObject2;
          break;
          i3 = i1;
          if (!paramBoolean2) {
            break label356;
          }
          i3 = i1;
          if (i1 <= 0) {
            break label356;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2)
          {
            a(0, i1);
            i3 = i1;
            break label356;
          }
          i3 = i1;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean) {
            break label356;
          }
          a(0, i1);
          i3 = i1;
          break label356;
          if (!paramBoolean1)
          {
            ThreadManager.a(this.jdField_b_of_type_JavaLangRunnable, 8, null, false);
            localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
            i1 = a((String)localObject1, 1);
            if (i1 >= 0)
            {
              localObject1 = (String)localObject1 + "_" + 1;
              localObject2 = GraphicRenderMgr.getInstance();
              ((GraphicRenderMgr)localObject2).flushGlRender((String)localObject1);
              ((GraphicRenderMgr)localObject2).clearCameraFrames();
              ((GraphicRenderMgr)localObject2).setGlRender((String)localObject1, null);
              this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int, true, false);
              b(i1);
            }
          }
        }
      }
      label650:
      localObject1 = null;
    }
  }
  
  int b()
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length; i2 = i3)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      String str = (String)localGLVideoView.a(0);
      i3 = i2;
      if (localGLVideoView.f() == 0)
      {
        i3 = i2;
        if (localGLVideoView.g())
        {
          i3 = i2;
          if (!TextUtils.isEmpty(str)) {
            i3 = i2 + 1;
          }
        }
      }
      i1 += 1;
    }
    return i2;
  }
  
  public int b(int paramInt)
  {
    Rect localRect = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b();
    this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131493879);
    this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131493880);
    if (((this.jdField_b_of_type_Int == 0) || (this.jdField_a_of_type_Int != 0)) || (a() <= 0)) {
      return 0;
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 2: 
      return this.jdField_a_of_type_Int + localRect.height();
    }
    return this.jdField_b_of_type_Int + localRect.height();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setVisibility(0);
    }
  }
  
  void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "closeVideoView index: " + paramInt);
    }
    int i2 = 0;
    float f1 = 0.0F;
    int i1 = 0;
    boolean bool1 = false;
    Object localObject2 = ImageView.ScaleType.CENTER_INSIDE;
    int i5 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
    Object localObject1 = localObject2;
    int i4;
    if (paramInt == 0)
    {
      i3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b();
      float f2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d();
      i4 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c();
      boolean bool2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].e();
      localObject1 = localObject2;
      bool1 = bool2;
      i1 = i4;
      f1 = f2;
      i2 = i3;
      if (i5 == 4)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a();
        i2 = i3;
        f1 = f2;
        i1 = i4;
        bool1 = bool2;
      }
    }
    int i3 = paramInt;
    while (i3 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) {
      if ((i3 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length - 1) && (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i3 + 1)].f() == 0))
      {
        i4 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3].i();
        int i6 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i3 + 1)].i();
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3].h(i6);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i3 + 1)].h(i4);
        localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3];
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3] = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i3 + 1)];
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i3 + 1)] = localObject2;
        i3 += 1;
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3];
        ((GLVideoView)localObject2).g(1);
        n();
        ((GLVideoView)localObject2).a(null);
        ((GLVideoView)localObject2).g(true);
        ((GLVideoView)localObject2).e(false);
        ((GLVideoView)localObject2).a(false);
        ((GLVideoView)localObject2).f(true);
        ((GLVideoView)localObject2).a(0, null);
        ((GLVideoView)localObject2).a(1, null);
      }
    }
    o();
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c(false);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d(i2);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c(f1);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c(i1);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d(bool1);
      if (i5 == 4) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a((ImageView.ScaleType)localObject1);
      }
    }
    f(false);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].i();
    int i2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].i();
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].h(i2);
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].h(i1);
    i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
    if (i1 == 2) {}
    label170:
    label288:
    label323:
    label636:
    label674:
    label687:
    label721:
    do
    {
      break label288;
      Object localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1];
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1] = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2];
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2] = localObject;
      boolean bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].b();
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(bool1);
      bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].b();
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(bool1);
      float f1 = UITools.a(BaseApplicationImpl.getContext(), 10.0F);
      float f2 = UITools.a(BaseApplicationImpl.getContext(), 14.0F);
      if (paramInt1 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c(f2);
        if (paramInt2 != 0) {
          break label674;
        }
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c(f2);
      }
      for (;;)
      {
        f(false);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 2) {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean = b();
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().l != 3000) {
            break label721;
          }
          if (!b()) {
            break label687;
          }
          ReportController.b(null, "CliOper", "", "", "0X80041B3", "0X80041B3", 0, 0, "", "", "", "");
        }
        return;
        if (i1 != 4) {
          break;
        }
        String str2;
        if (paramInt1 == 0)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
          localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
          String str1 = (String)this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(0);
          str2 = (String)this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(0);
          if (!((String)localObject).equals(str1)) {
            break label636;
          }
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        }
        for (;;)
        {
          i1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].b();
          f1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].d();
          i2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
          bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].e();
          boolean bool2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].d();
          int i3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].b();
          f2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].d();
          int i4 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c();
          boolean bool3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].e();
          boolean bool4 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].d();
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c(bool4);
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].d(i3);
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c(f2);
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c(i4);
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].d(bool3);
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c(bool2);
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].d(i1);
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c(f1);
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c(i2);
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].d(bool1);
          break;
          if (paramInt2 != 0) {
            break label323;
          }
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_INSIDE);
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
          break label323;
          if (((String)localObject).equals(str2)) {
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
          }
        }
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c(f1);
        break label170;
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c(f1);
      }
      ReportController.b(null, "CliOper", "", "", "0X80041B2", "0X80041B2", 0, 0, "", "", "", "");
      return;
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().l != 1);
    if (b())
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005939", "0X8005939", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80046E0", "0X80046E0", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)
    {
      ReportController.b(null, "CliOper", "", "", "0X8005938", "0X8005938", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80046DF", "0X80046DF", 0, 0, "", "", "", "");
  }
  
  public void b(RecvMsg paramRecvMsg)
  {
    if (a().booleanValue()) {}
    do
    {
      return;
      String str2 = paramRecvMsg.d();
      String str3 = paramRecvMsg.b();
      String str1 = paramRecvMsg.c();
      localObject = str1;
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
      {
        localObject = str1;
        if (str3 != null) {
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a(str3, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Long), this.jdField_a_of_type_ComTencentAvVideoController.a().l);
        }
      }
      paramRecvMsg = paramRecvMsg.e();
      if (QLog.isColorLevel()) {
        QLog.d("VideoLayerUI", 2, "showRecvMsg friendUin: " + str2 + ", senderUin: " + str3 + ", senderName: " + (String)localObject + ", msg: " + paramRecvMsg);
      }
      f(this.m);
      i(true);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    } while ((paramRecvMsg == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null));
    Object localObject = new QQText(paramRecvMsg, 11);
    paramRecvMsg = (RecvMsg)localObject;
    if (a((CharSequence)localObject)) {
      paramRecvMsg = a((CharSequence)localObject);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramRecvMsg);
  }
  
  public void b(GLVideoView paramGLVideoView, boolean paramBoolean)
  {
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(200);
    localGLAnimation.b(0.0F, 0.0F, -90.0F, 0.0F, 0.0F, 0.0F);
    localGLAnimation.a(2);
    paramGLVideoView.a(localGLAnimation);
    paramGLVideoView.x();
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "setLocalMute isLocalMute: " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    boolean bool = false;
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0];
    if ((localGLVideoView.f() == 0) && (str.equals(localGLVideoView.a(0)))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoLayerUI", 2, "isLocalFront: " + bool);
      }
      return bool;
      bool = true;
    }
  }
  
  public boolean b(String paramString, int paramInt)
  {
    return a(paramString, paramInt) == 0;
  }
  
  public int c()
  {
    return this.i;
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "onFirstDraw");
    }
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new gzz(this));
    }
  }
  
  public void c(int paramInt)
  {
    int i5 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "setSmallVideoViewLayout position: " + paramInt);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoLayerUI", 2, "setSmallVideoViewLayout mContext == null");
      }
      return;
    }
    int i7 = super.g();
    int i6 = super.h();
    int i4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493877);
    int i3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493878);
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493879);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493880);
    if (this.jdField_g_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidViewDisplay.getRotation() % 2 == 0)
      {
        i4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131494077);
        i3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131494078);
        i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131494079);
        i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131494080);
      }
    }
    else
    {
      if (this.jdField_b_of_type_Int == 0) {
        i2 = i1;
      }
      switch (paramInt)
      {
      default: 
        paramInt = 0;
        i1 = 0;
        i2 = 0;
        i3 = i5;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b(i2, i1, i3, paramInt);
      return;
      i4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131494078);
      i3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131494077);
      i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131494080);
      i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131494079);
      break;
      i4 = i1 + i4;
      paramInt = this.jdField_a_of_type_Int + i2;
      i3 = paramInt + i3;
      i2 = i1;
      i1 = paramInt;
      paramInt = i3;
      i3 = i4;
      continue;
      paramInt = i7 - i4 - i1;
      i4 = paramInt + i4;
      i1 = this.jdField_a_of_type_Int + i2;
      i3 = i1 + i3;
      i2 = paramInt;
      paramInt = i3;
      i3 = i4;
      continue;
      i4 = i1 + i4;
      paramInt = i6 - i3 - i2 - this.jdField_b_of_type_Int;
      i3 = paramInt + i3;
      i2 = i1;
      i1 = paramInt;
      paramInt = i3;
      i3 = i4;
      continue;
      paramInt = i7 - i4 - i1;
      i1 = i6 - i3 - i2 - this.jdField_b_of_type_Int;
      i4 = paramInt + i4;
      i3 = i1 + i3;
      i2 = paramInt;
      paramInt = i3;
      i3 = i4;
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    int i5 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493877);
    int i6 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493878);
    Rect localRect = super.b();
    int i3 = localRect.width() - i5;
    int i2 = localRect.height() - i6;
    int i4 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().left + paramInt1;
    paramInt2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().top + paramInt2;
    if (i4 < 0)
    {
      paramInt1 = 0;
      if (paramInt2 >= 0) {
        break label145;
      }
      paramInt2 = i1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b(paramInt1, paramInt2, paramInt1 + i5, paramInt2 + i6);
      return;
      paramInt1 = i3;
      if (i4 > i3) {
        break;
      }
      paramInt1 = i4;
      break;
      label145:
      if (paramInt2 > i2) {
        paramInt2 = i2;
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "setRemoteMute isRemoteMute: " + paramBoolean);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        if ((localGLVideoView.f() == 0) && (str.equals(localGLVideoView.a(0)))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public int d()
  {
    Rect localRect = super.b();
    int i1 = localRect.centerX();
    int i2 = localRect.centerY();
    int i3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().centerX();
    int i4 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().centerY();
    if ((i3 < i1) && (i4 < i2)) {
      return 1;
    }
    if ((i3 < i1) && (i4 > i2)) {
      return 4;
    }
    if ((i3 > i1) && (i4 < i2)) {
      return 2;
    }
    if ((i3 > i1) && (i4 > i2)) {
      return 3;
    }
    return 0;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setVisibility(8);
    }
  }
  
  public void d(int paramInt)
  {
    int i3 = 0;
    int i6 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493877);
    int i7 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493878);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493879);
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493880);
    if (this.jdField_b_of_type_Int == 0) {
      i1 = i2;
    }
    Object localObject = super.b();
    int i4 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().left;
    int i5 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().top;
    switch (paramInt)
    {
    default: 
      i1 = 0;
      i2 = i3;
    }
    for (;;)
    {
      localObject = new hak(this, paramInt, i4, i5, i1, i2);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post((Runnable)localObject);
      return;
      i3 = i1;
      i1 = i2;
      i2 = i3;
      continue;
      i7 = ((Rect)localObject).width();
      i3 = i1;
      i1 = i7 - i2 - i6;
      i2 = i3;
      continue;
      int i8 = ((Rect)localObject).width();
      i3 = ((Rect)localObject).height() - i1 - i7;
      i1 = i8 - i2 - i6;
      i2 = i3;
      continue;
      i3 = ((Rect)localObject).height() - i1 - i7;
      i1 = i2;
      i2 = i3;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "onCameraOpened isFrontCamera: " + paramBoolean);
    }
    int i1 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), 1);
    if (i1 >= 0) {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].b(paramBoolean);
    }
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        if ((localGLVideoView.f() == 0) && (!str.equals(localGLVideoView.a(0)))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  int e()
  {
    String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      String str2 = (String)localGLVideoView.a(0);
      if ((localGLVideoView.f() == 0) && (!TextUtils.isEmpty(str2)) && (!str2.equals(str1))) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.onResume();
    }
    a(this.h, false);
    f(this.m);
  }
  
  public void e(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      k();
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(paramInt);
      if (paramInt == 1) {
        this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "onCameraSwitched isFrontCamera: " + paramBoolean);
    }
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    int i1 = a(str, 1);
    if (i1 >= 0)
    {
      str = str + "_" + 1;
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.clearCameraFrames();
      localGraphicRenderMgr.flushGlRender(str);
      this.jdField_a_of_type_ComTencentAvVideoController.a(true);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].i(false);
      this.jdField_a_of_type_ComTencentAvVideoController.a(new had(this, i1, paramBoolean));
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().l != 3000) {
        break label282;
      }
      if (!paramBoolean) {
        break label246;
      }
      ReportController.b(null, "CliOper", "", "", "0X80041B5", "0X80041B5", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().z)
      {
        if (!paramBoolean) {
          break;
        }
        ReportController.b(null, "CliOper", "", "", "0X8005211", "0X8005211", 0, 0, "", "", "", "");
      }
      return;
      label246:
      ReportController.b(null, "CliOper", "", "", "0X80041B4", "0X80041B4", 0, 0, "", "", "", "");
      continue;
      label282:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1) {
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
            ReportController.b(null, "CliOper", "", "", "0X800593B", "0X800593B", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X80046E2", "0X80046E2", 0, 0, "", "", "", "");
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
          ReportController.b(null, "CliOper", "", "", "0X800593A", "0X800593A", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80046E1", "0X80046E1", 0, 0, "", "", "", "");
        }
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X8005210", "0X8005210", 0, 0, "", "", "", "");
  }
  
  public boolean e()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.onPause();
    }
  }
  
  public void f(int paramInt)
  {
    if ((this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b();
    Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getLayoutParams();
    int i4 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131493879);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131493880);
    int i5 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131493883);
    int i1 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131493884);
    int i6 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131493885);
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_a_of_type_Int == 0))
    {
      i1 = i5;
      i2 = i4;
    }
    int i7 = a();
    if (i7 <= 0)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(11, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = i5;
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (i1 + this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = (RotateLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((RotateLayout.LayoutParams)localObject1).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i1 = this.jdField_a_of_type_AndroidViewView.getWidth() - i5 * 2;
      paramInt = i1;
      if (i1 > this.o) {
        paramInt = this.o;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(paramInt);
      return;
    }
    int i3 = paramInt;
    if (this.jdField_b_of_type_Int != 0)
    {
      i3 = paramInt;
      if (this.jdField_a_of_type_Int != 0) {
        i3 = 0;
      }
    }
    paramInt = d();
    if (i3 == 0)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(11, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
      if (i7 == 1)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = i5;
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (i1 + this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = (RotateLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((RotateLayout.LayoutParams)localObject2).jdField_a_of_type_Int = i3;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = super.b();
        if (i7 != 1) {
          break label909;
        }
      }
    }
    label909:
    for (paramInt = ((Rect)localObject2).width() - i5 * 2;; paramInt = ((Rect)localObject2).width() - ((Rect)localObject1).width() - i4 - i5 - i6)
    {
      i1 = paramInt;
      if (paramInt > this.o) {
        i1 = this.o;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i1);
      return;
      if (i7 == 2)
      {
        if ((paramInt == 4) || ((paramInt == 1) && (this.jdField_b_of_type_Int != 0))) {}
        for (((RelativeLayout.LayoutParams)localObject2).leftMargin = (((Rect)localObject1).width() + i4 + i6);; ((RelativeLayout.LayoutParams)localObject2).leftMargin = i5)
        {
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (i1 + this.jdField_b_of_type_Int);
          break;
        }
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = i5;
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (i1 + this.jdField_b_of_type_Int + ((Rect)localObject1).height());
      break;
      if (i3 == 90)
      {
        ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
        ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
        if (i7 == 1)
        {
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = i5;
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (i1 + this.jdField_b_of_type_Int);
          break;
        }
        if (i7 < 2) {
          break;
        }
        if (paramInt == 3) {}
        for (((RelativeLayout.LayoutParams)localObject2).bottomMargin = (((Rect)localObject1).height() + i2 + i6 + this.jdField_b_of_type_Int);; ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (i1 + this.jdField_b_of_type_Int))
        {
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = i5;
          break;
        }
      }
      if (i3 == 180)
      {
        ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12, 0);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
        if (i7 == 1)
        {
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = i5;
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (i1 + this.jdField_a_of_type_Int);
          break;
        }
        if (i7 == 2)
        {
          if (paramInt == 2) {}
          for (((RelativeLayout.LayoutParams)localObject2).rightMargin = (((Rect)localObject1).width() + i4 + i6);; ((RelativeLayout.LayoutParams)localObject2).rightMargin = i5)
          {
            ((RelativeLayout.LayoutParams)localObject2).topMargin = (i1 + this.jdField_a_of_type_Int);
            break;
          }
        }
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = i5;
        if (paramInt == 2)
        {
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (i1 + this.jdField_a_of_type_Int + ((Rect)localObject1).height());
          break;
        }
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (i1 + this.jdField_a_of_type_Int);
        break;
      }
      if (i3 != 270) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(11, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
      if (i7 == 1)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = i5;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (i1 + this.jdField_a_of_type_Int);
        break;
      }
      if (i7 < 2) {
        break;
      }
      if (paramInt == 1) {}
      for (((RelativeLayout.LayoutParams)localObject2).topMargin = (((Rect)localObject1).height() + i2 + i6 + this.jdField_a_of_type_Int);; ((RelativeLayout.LayoutParams)localObject2).topMargin = (i1 + this.jdField_a_of_type_Int))
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = i5;
        break;
      }
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "layoutVideoView virtical: " + paramBoolean + ", sessionType: " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int);
    }
    int i3 = super.g();
    int i5 = super.h();
    int i1 = (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 2.0F);
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i1, i1, i1, i1);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b(0, 0, i3, i5);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].i(-16777216);
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2)) {
        break label209;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].a(3, 3, 3, 3);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].i(-16777216);
      c(this.i);
    }
    label209:
    while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 3) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4))
    {
      super.x();
      return;
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, 0, 0, 0);
      break;
    }
    label392:
    int i2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(Boolean.valueOf(this.jdField_g_of_type_Boolean));
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[2].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[3].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[4].a(Boolean.valueOf(true));
      if ((!this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b()) || ((this.m != 0) && (this.m != 180)) || (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].h())) {
        break label773;
      }
      if (this.m == 0) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, 0, 0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493914));
      }
    }
    else
    {
      i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493879);
      if (this.jdField_b_of_type_Int == 0) {
        break label858;
      }
    }
    label492:
    label537:
    label582:
    label773:
    label834:
    label842:
    label850:
    label858:
    for (i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493880);; i1 = i2)
    {
      int i6 = (i3 - i2 * 2) / 4;
      int i4 = i5 - i6 - i1 - this.jdField_b_of_type_Int;
      i5 = i5 - i1 - this.jdField_b_of_type_Int;
      if (paramBoolean)
      {
        i1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().left;
        i2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().right;
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b(i1, i4, i2, i5);
        if (!paramBoolean) {
          break label834;
        }
        i2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[2].b().left;
        i1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[2].b().right;
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[2].b(i2, i4, i1, i5);
        if (!paramBoolean) {
          break label842;
        }
        i1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[3].b().left;
        i2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[3].b().right;
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[3].b(i1, i4, i2, i5);
        if (!paramBoolean) {
          break label850;
        }
        i2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[4].b().left;
        i1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[4].b().right;
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[4].b(i2, i4, i1, i5);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].i(-16777216);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[2].i(-16777216);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[3].i(-16777216);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[4].i(-16777216);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].a(2, 3, 3, 3);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[2].a(2, 3, 2, 3);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[3].a(2, 3, 2, 3);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[4].a(3, 3, 2, 3);
        break;
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493914), 0, 0);
        break label392;
        if (this.jdField_g_of_type_Boolean)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i1, i1, i1, i1);
          break label392;
        }
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, 0, 0, 0);
        break label392;
        i1 = i3 - i2;
        i3 = i3 - i6 - i2;
        i2 = i1;
        i1 = i3;
        break label492;
        i2 = i1 - i6;
        break label537;
        i1 = i2 - i6;
        break label582;
        i2 = i1 - i6;
      }
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.onResume();
    }
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.onPause();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      k();
    }
    TextView localTextView;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i1 = 0;; i1 = 8)
    {
      localTextView.setVisibility(i1);
      return;
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "onDestroy:" + this + ", isSmallScreen:" + this.jdField_g_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Ham);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setOnTouchListener(null);
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(null);
    super.B();
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].g(1);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].g(true);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].e(false);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].a(false);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].f(true);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnTouchListener = null;
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector = null;
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = null;
    this.jdField_a_of_type_Ham = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = null;
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView = null;
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public void i(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "showMsgbox: show = " + paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) || (this.jdField_g_of_type_Boolean)) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources();
      i1 = (int)(((Resources)localObject).getDimension(2131493040) + ((Resources)localObject).getDimension(2131493047));
      int i2 = (int)(((Resources)localObject).getDimension(2131493038) + ((Resources)localObject).getDimension(2131493045));
      int i3 = (int)(((Resources)localObject).getDimension(2131493041) + ((Resources)localObject).getDimension(2131493048));
      f1 = ((Resources)localObject).getDimension(2131493039);
      int i4 = (int)(((Resources)localObject).getDimension(2131493046) + f1);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i1, i2, i3, i4);
      this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(128);
      if ((this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.isShown()) && (!paramBoolean))
      {
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject).setDuration(1000L);
        ((AlphaAnimation)localObject).setFillAfter(true);
        ((AlphaAnimation)localObject).setAnimationListener(new hal(this));
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.startAnimation((Animation)localObject);
        return;
      }
    } while (!paramBoolean);
    Object localObject = new Transformation();
    ((Transformation)localObject).setAlpha(0.0F);
    AlphaAnimation localAlphaAnimation = (AlphaAnimation)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getAnimation();
    if (localAlphaAnimation != null)
    {
      localAlphaAnimation.setAnimationListener(null);
      localAlphaAnimation.getTransformation(System.currentTimeMillis(), (Transformation)localObject);
    }
    float f1 = ((Transformation)localObject).getAlpha();
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.clearAnimation();
    localObject = new AlphaAnimation(f1, 1.0F);
    ((AlphaAnimation)localObject).setDuration(1000L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setFillBefore(true);
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.startAnimation((Animation)localObject);
    localObject = this.jdField_a_of_type_ComTencentAvWidgetRotateLayout;
    if (this.jdField_g_of_type_Boolean) {}
    for (int i1 = 8;; i1 = 0)
    {
      ((RotateLayout)localObject).setVisibility(i1);
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setTag(Long.valueOf(System.currentTimeMillis()));
      return;
    }
  }
  
  void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "initQQGlView");
    }
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView = new GLVideoView[5];
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1] = new GLVideoView(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].g(1);
      if (i1 == 0) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].h(i1 * 2);
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].h(this.jdField_g_of_type_Boolean);
        super.a(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1]);
        i1 += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].h((this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length - i1) * 2);
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l == 1008)) {}
    for (i1 = 2130839128;; i1 = 2130839012)
    {
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].i(0);
        this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = ((GLRootView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299419));
        this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(this);
        this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController = new EffectsRenderController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView);
        this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setEffects(this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController);
        if (!this.jdField_g_of_type_Boolean) {
          break label352;
        }
        super.i(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(this.jdField_a_of_type_AndroidContentContext, new hap(this));
        this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new hah(this));
        this.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector = new MoveGestureDetector(this.jdField_a_of_type_AndroidContentContext, new haj(this));
        this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnTouchListener = new haq(this);
        super.a(this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnTouchListener);
        return;
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b(UITools.a(this.jdField_a_of_type_AndroidContentContext, i1));
        break;
        label352:
        super.b(UITools.a(this.jdField_a_of_type_AndroidContentContext, i1));
      }
    }
  }
  
  public void j(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  void k()
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)
    {
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = ((RotateLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299422));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299423));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299266));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299268));
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources();
      this.n = ((int)localResources.getDimension(2131494046));
      this.o = ((int)localResources.getDimension(2131494047));
      int i1 = (int)(localResources.getDimension(2131493040) + localResources.getDimension(2131493047));
      int i2 = (int)(localResources.getDimension(2131493038) + localResources.getDimension(2131493045));
      int i3 = (int)(localResources.getDimension(2131493041) + localResources.getDimension(2131493048));
      float f1 = localResources.getDimension(2131493039);
      int i4 = (int)(localResources.getDimension(2131493046) + f1);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i1, i2, i3, i4);
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(Long.valueOf(0L));
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.n);
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(this.o);
      this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(128);
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setVisibility(8);
      }
    }
  }
  
  public void k(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      k();
    }
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {}
    while (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130842999);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#5f656f"));
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130843000);
  }
  
  void l()
  {
    RotateLayout localRotateLayout;
    if ((this.jdField_a_of_type_ComTencentAvWidgetRotateLayout != null) && (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getTag()).longValue() >= 10000L))
    {
      localRotateLayout = this.jdField_a_of_type_ComTencentAvWidgetRotateLayout;
      if (!this.jdField_g_of_type_Boolean) {
        break label52;
      }
    }
    label52:
    for (int i1 = 8;; i1 = 4)
    {
      localRotateLayout.setVisibility(i1);
      return;
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView != null)
    {
      int i1 = 1;
      while (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].h(-1);
        i1 += 1;
      }
    }
  }
  
  public void n()
  {
    int i1 = b();
    if (this.r != i1)
    {
      this.r = i1;
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$SmallScreenListener != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$SmallScreenListener.a(this.r);
      }
    }
  }
  
  void o()
  {
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].f() == 0))
    {
      String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      String str2 = (String)this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0);
      if ((str2 != null) && (str2.equals(str1)))
      {
        int i1 = e();
        if (i1 > 0) {
          a(0, i1);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\VideoLayerUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */