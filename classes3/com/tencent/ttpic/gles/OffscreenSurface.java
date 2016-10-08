package com.tencent.ttpic.gles;

public class OffscreenSurface
  extends EglSurfaceBase
{
  public OffscreenSurface(EglCore paramEglCore, int paramInt1, int paramInt2)
  {
    super(paramEglCore);
    createOffscreenSurface(paramInt1, paramInt2);
  }
  
  public void release()
  {
    releaseEglSurface();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\gles\OffscreenSurface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */