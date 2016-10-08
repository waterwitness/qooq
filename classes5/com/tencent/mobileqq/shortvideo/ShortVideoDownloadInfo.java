package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ShortVideoDownloadInfo
  extends ShortVideoBaseInfo
{
  public static final int i = 1;
  public static final int j = 2;
  public static final int l = 1;
  public static final int m = 2;
  public static final int o = 0;
  public static final int p = -1;
  public static final int q = -2;
  public static final int r = 0;
  public static final int s = 1;
  public long b;
  public boolean b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public String h;
  public String i;
  public int k;
  public int n;
  
  public ShortVideoDownloadInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      if ((paramInt1 == 0) || (paramInt1 == 1008)) {
        this.g = 1001;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 == 3000)
          {
            this.g = 1005;
            return;
          }
        } while (paramInt1 != 1);
        this.g = 1003;
        return;
      } while (1 != paramInt2);
      if ((paramInt1 == 0) || (paramInt1 == 1008))
      {
        this.g = 1002;
        return;
      }
      if (paramInt1 == 3000)
      {
        this.g = 1006;
        return;
      }
    } while (paramInt1 != 1);
    this.g = 1004;
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.a))
    {
      a("ShortVideoDownloadInfo.check", "uuid invaid:" + this.a);
      return false;
    }
    if (this.b == null)
    {
      a("ShortVideoDownloadInfo", "selfUin invalid,selfUin:" + this.b);
      return false;
    }
    return super.a();
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoDownloadInfo");
    localStringBuilder.append("\n |-").append("md5:").append(this.e);
    localStringBuilder.append("\n |-").append("uuid:").append(this.a);
    localStringBuilder.append("\n |-").append("fileType:").append(this.g);
    localStringBuilder.append("\n |-").append("format:").append(this.d);
    localStringBuilder.append("\n |-").append("mRequestType:").append(this.h);
    localStringBuilder.append("\n |-").append("mSceneType:").append(this.k);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toLogString());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ShortVideoDownloadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */