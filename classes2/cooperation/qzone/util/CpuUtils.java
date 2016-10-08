package cooperation.qzone.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CpuUtils
{
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    System.loadLibrary("cpu_v1.1");
  }
  
  public static native long getCpuFeatures();
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\util\CpuUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */