package cooperation.plugin;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ByteUnitTransformUtil
{
  private static final String[] a = { "B", "K", "M", "G" };
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static final String a(long paramLong)
  {
    float f1 = 0.0F;
    int i = 0;
    while (paramLong >= 1024L)
    {
      paramLong /= 1024L;
      f1 = (float)(paramLong % 1024L);
      i += 1;
    }
    if (f1 == 0.0F)
    {
      f1 = (float)paramLong;
      return String.valueOf(paramLong) + a[i];
    }
    f1 /= 1024.0F;
    float f2 = (float)paramLong;
    return String.format("%.2f", new Object[] { Float.valueOf(f1 + f2) }) + a[i];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\plugin\ByteUnitTransformUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */