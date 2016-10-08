package com.tencent.av.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class QavTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  QavSurfaceTextureListener jdField_a_of_type_ComTencentAvCameraQavSurfaceTextureListener;
  
  public QavTextureView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    this.jdField_a_of_type_ComTencentAvCameraQavSurfaceTextureListener = null;
    setSurfaceTextureListener(this);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    if (this.jdField_a_of_type_ComTencentAvCameraQavSurfaceTextureListener != null) {
      this.jdField_a_of_type_ComTencentAvCameraQavSurfaceTextureListener.a();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    if (this.jdField_a_of_type_ComTencentAvCameraQavSurfaceTextureListener != null) {
      this.jdField_a_of_type_ComTencentAvCameraQavSurfaceTextureListener.b();
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setQavSurfaceTextureListener(QavSurfaceTextureListener paramQavSurfaceTextureListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavTextureView", 2, "setQavSurfaceTextureListener");
    }
    this.jdField_a_of_type_ComTencentAvCameraQavSurfaceTextureListener = paramQavSurfaceTextureListener;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\camera\QavTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */