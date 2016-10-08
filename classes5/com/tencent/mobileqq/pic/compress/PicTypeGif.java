package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;

public class PicTypeGif
  extends PicType
{
  PicTypeGif(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a(CompressInfo paramCompressInfo)
  {
    return 2;
  }
  
  protected boolean d()
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\pic\compress\PicTypeGif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */