package com.tencent.mobileqq.shortvideo.mediadevice;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TexturePreviewContext
  extends PreviewContext
  implements Camera.PreviewCallback, TextureView.SurfaceTextureListener
{
  public TexturePreviewContext(CameraProxy paramCameraProxy, int paramInt1, int paramInt2)
  {
    super(paramCameraProxy, paramInt1, paramInt2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    getPreviewFrame(paramArrayOfByte, paramCamera);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mCamera.a();
    this.mCamera.a(0, paramInt1, paramInt2);
    this.mCamera.a(paramSurfaceTexture, null, this, false);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.mCamera.b();
    this.mCamera.a(true);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\TexturePreviewContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */