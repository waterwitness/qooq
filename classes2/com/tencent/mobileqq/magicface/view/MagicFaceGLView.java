package com.tencent.mobileqq.magicface.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class MagicFaceGLView
  extends GLSurfaceView
  implements SurfaceHolder.Callback, IMagicFaceView
{
  public static final String a;
  private GLRender jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender;
  private MagicfaceView.SurfaceCreateListener jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView$SurfaceCreateListener;
  public volatile boolean a;
  private volatile boolean b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = MagicFaceGLView.class.getSimpleName();
  }
  
  public MagicFaceGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func [gl] MagicFaceGLView begins");
    }
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender = new GLRender();
    setRenderer(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender);
    setRenderMode(0);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func [gl] MagicFaceGLView ends");
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func [gl] frameDataGL begins, srcwidth:" + paramInt1 + ",srcheight:" + paramInt2 + ",degree:" + paramFloat);
    }
    b(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func [gl] frameDataGL ends");
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt1, int paramInt2) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender.a(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, getWidth(), getHeight(), paramFloat, this.b);
    requestRender();
  }
  
  public void setIsFullScreen(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setSurfaceCreatelistener(MagicfaceView.SurfaceCreateListener paramSurfaceCreateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView$SurfaceCreateListener = paramSurfaceCreateListener;
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func [gl] surfaceCreated begins");
    }
    super.surfaceCreated(paramSurfaceHolder);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView$SurfaceCreateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView$SurfaceCreateListener.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func [gl] surfaceCreated ends");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\view\MagicFaceGLView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */