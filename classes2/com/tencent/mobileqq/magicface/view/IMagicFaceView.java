package com.tencent.mobileqq.magicface.view;

import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicfaceRenderListener;

public abstract interface IMagicFaceView
  extends MagicfaceDecoder.MagicfaceRenderListener
{
  public abstract boolean a();
  
  public abstract void setIsFullScreen(boolean paramBoolean);
  
  public abstract void setSurfaceCreatelistener(MagicfaceView.SurfaceCreateListener paramSurfaceCreateListener);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\view\IMagicFaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */