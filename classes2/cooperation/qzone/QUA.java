package cooperation.qzone;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QUA
{
  public static final String a = "100084";
  private static final String b = "V1_AND_SQ_6.5.5_410_YYB_D";
  private static String c;
  private static String d;
  
  public QUA()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a()
  {
    return "V1_AND_SQ_6.5.5_410_YYB_D";
  }
  
  public static String b()
  {
    if (c == null) {
      c = d();
    }
    return c;
  }
  
  public static String c()
  {
    if (d == null) {
      d = d();
    }
    return d;
  }
  
  private static String d()
  {
    int i = "V1_AND_SQ_6.5.5_410_YYB_D".indexOf("_");
    int k = "V1_AND_SQ_6.5.5_410_YYB_D".lastIndexOf("_");
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      int j = k;
      if (k < 0) {
        j = "V1_AND_SQ_6.5.5_410_YYB_D".length();
      }
      return "V1_AND_SQ_6.5.5_410_YYB_D".substring(i, j);
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QUA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */