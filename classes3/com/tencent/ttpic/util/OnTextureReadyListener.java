package com.tencent.ttpic.util;

import com.tencent.ttpic.gles.TextureDataPipe;

public abstract interface OnTextureReadyListener
{
  public abstract TextureDataPipe getReadyData();
  
  public abstract void onTextureReady(int paramInt1, int paramInt2);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\OnTextureReadyListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */