package com.tencent.mobileqq.activity.richmedia.view;

import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.FilterPreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;

public class FSurfaceViewLayout
  extends FrameLayout
{
  public GLSurfaceView a;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  private volatile boolean e;
  
  public FSurfaceViewLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    e();
  }
  
  public FSurfaceViewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    e();
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.c = false;
    this.d = false;
    this.e = false;
  }
  
  public int a()
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      return ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.a;
    }
    return 0;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      super.addView(this.jdField_a_of_type_AndroidOpenglGLSurfaceView);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.e)
    {
      this.b = VideoEnvironment.a();
      if ((!VideoEnvironment.b()) || (!paramBoolean1)) {
        break label122;
      }
      paramBoolean1 = true;
      this.c = paramBoolean1;
      if (((!this.b) && (!this.c)) || (!paramBoolean2)) {
        break label127;
      }
    }
    label122:
    label127:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.d = paramBoolean1;
      this.e = true;
      if (QLog.isColorLevel()) {
        QLog.d("face", 2, "initEnvVar isSurpportFilter=" + this.c + "needOpenglView=" + this.d);
      }
      if (!this.c) {
        break label132;
      }
      PtvFilterUtils.c(true);
      CameraFilterGLView.a();
      return;
      paramBoolean1 = false;
      break;
    }
    label132:
    PtvFilterUtils.c(false);
  }
  
  public boolean a()
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      return ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).a();
    }
    return false;
  }
  
  public boolean a(Context paramContext, CameraFilterGLView.CameraGlFilterListener paramCameraGlFilterListener, PreviewContext paramPreviewContext)
  {
    if (!this.d)
    {
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView = null;
      return false;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, localDisplayMetrics.heightPixels);
    localLayoutParams.height = localDisplayMetrics.heightPixels;
    localLayoutParams.width = localDisplayMetrics.widthPixels;
    localLayoutParams.gravity = 49;
    if (QLog.isColorLevel()) {
      QLog.d("face", 2, "initSurfaceView needChangeNewSurfaceView=" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      super.setVisibility(8);
      if (!this.c) {
        break label241;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        super.removeAllViews();
        if ((this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) && ((this.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof CameraFilterGLView))) {
          ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).c();
        }
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView = null;
      }
      if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView == null)
      {
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView = new CameraFilterGLView(paramContext, null);
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setVisibility(8);
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setId(2131296495);
      }
      paramContext = (CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView;
      paramContext.setFilterListener(paramCameraGlFilterListener);
      paramContext.setVideoContext(paramPreviewContext);
      paramContext.b();
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      return true;
      super.setVisibility(0);
      break;
      label241:
      if (this.jdField_a_of_type_Boolean)
      {
        super.removeAllViews();
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView = null;
      }
      if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView == null)
      {
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView = new CameraGLSurfaceView(paramContext);
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setId(2131296496);
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setVisibility(8);
      }
      paramContext = (CameraGLSurfaceView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView;
      paramContext.setVideoContext(paramPreviewContext);
      paramContext.a();
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setLayoutParams(localLayoutParams);
    }
  }
  
  public int b()
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      return ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext.b();
    }
    return 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) {
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.onPause();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) {
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.onResume();
    }
  }
  
  public void d()
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null))
    {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).d();
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).e();
    }
  }
  
  public void setNeedWrite(boolean paramBoolean)
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setNeedWrite(paramBoolean);
    }
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2, RMVideoClipSpec paramRMVideoClipSpec)
  {
    if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView == null) {
      return;
    }
    if (this.c)
    {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setPreviewSize(paramInt1, paramInt2, paramRMVideoClipSpec);
      return;
    }
    ((CameraGLSurfaceView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setPreviewSize(paramInt1, paramInt2, paramRMVideoClipSpec);
  }
  
  public void setVideoFilter(String paramString)
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setVideoFilter(paramString);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) {
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setVisibility(paramInt);
    }
    super.setVisibility(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\view\FSurfaceViewLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */