package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class GrayTipsSpan
  implements Serializable
{
  public int begin;
  public int end;
  public String url;
  
  public GrayTipsSpan(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.begin = paramInt1;
    this.end = paramInt2;
    this.url = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\GrayTipsSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */