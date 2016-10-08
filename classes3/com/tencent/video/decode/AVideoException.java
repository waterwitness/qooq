package com.tencent.video.decode;

public class AVideoException
  extends RuntimeException
{
  private static final long serialVersionUID = -3387516993124229948L;
  public int mErrCode = 0;
  public int mErrSubcode = 0;
  
  public AVideoException(int paramInt1, int paramInt2, String paramString)
  {
    super(paramString);
    this.mErrCode = paramInt1;
    this.mErrSubcode = paramInt2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\video\decode\AVideoException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */