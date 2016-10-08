package com.tencent.mobileqq.activity.aio.photo;

import android.os.IInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;

public abstract interface ICompressionCallBack
  extends IInterface
{
  public static final String a = ICompressionCallBack.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract void a(CompressInfo paramCompressInfo);
  
  public abstract void b(CompressInfo paramCompressInfo);
  
  public abstract void c(CompressInfo paramCompressInfo);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\ICompressionCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */