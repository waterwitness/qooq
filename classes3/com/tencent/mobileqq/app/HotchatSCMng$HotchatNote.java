package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HotchatSCMng$HotchatNote
{
  static SimpleDateFormat a;
  static SimpleDateFormat b;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    jdField_b_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  }
  
  public static long a(String paramString)
  {
    try
    {
      l = jdField_a_of_type_JavaTextSimpleDateFormat.parse(paramString).getTime();
      return l;
    }
    catch (Exception localException)
    {
      long l;
      localException.printStackTrace();
      try
      {
        l = jdField_b_of_type_JavaTextSimpleDateFormat.parse(paramString).getTime();
        return l;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[").append(this.jdField_a_of_type_JavaLangString).append(",").append(this.jdField_b_of_type_JavaLangString).append(",").append(this.jdField_a_of_type_Long).append(",").append(this.jdField_b_of_type_Long).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\HotchatSCMng$HotchatNote.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */