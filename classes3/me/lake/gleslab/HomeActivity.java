package me.lake.gleslab;

import android.view.Surface;

public class HomeActivity
{
  public static native void ndkdraw(Surface paramSurface, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void readPixel(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void toYV12(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\me\lake\gleslab\HomeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */