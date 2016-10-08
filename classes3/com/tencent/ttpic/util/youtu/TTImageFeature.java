package com.tencent.ttpic.util.youtu;

public class TTImageFeature
  implements Cloneable
{
  public int h;
  public int leftEyeX;
  public int leftEyeY;
  public int mouthX;
  public int mouthY;
  public long nativeObject;
  public int rightEyeX;
  public int rightEyeY;
  public int w;
  public int x;
  public int y;
  
  private native void nClearNativeObject(long paramLong);
  
  private native long nCloneNativeObject(long paramLong);
  
  public Object clone()
  {
    Object localObject = null;
    try
    {
      TTImageFeature localTTImageFeature = (TTImageFeature)super.clone();
      localObject = localTTImageFeature;
      localTTImageFeature.nativeObject = nCloneNativeObject(this.nativeObject);
      return localTTImageFeature;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return localObject;
  }
  
  protected void finalize()
    throws Throwable
  {
    if (this.nativeObject != 0L) {
      nClearNativeObject(this.nativeObject);
    }
    this.nativeObject = 0L;
    super.finalize();
  }
  
  public long getNativeObject()
  {
    return this.nativeObject;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\youtu\TTImageFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */