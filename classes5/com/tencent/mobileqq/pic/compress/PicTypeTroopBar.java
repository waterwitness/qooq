package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;

public class PicTypeTroopBar
  extends PicTypeNormal
{
  private static final int u = 90;
  private static final int v = 85;
  
  PicTypeTroopBar(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    int i = 85;
    if (this.a.g == 2)
    {
      i = 100;
      return i;
    }
    switch (this.a.h)
    {
    case 4: 
    case 2: 
    case 3: 
    default: 
      return 85;
    }
    return 90;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\pic\compress\PicTypeTroopBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */