package com.tencent.mobileqq.profile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ProfileBusiEntry
{
  public static final int b = 1024;
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public ProfileBusiEntry()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      bool1 = bool2;
      if (this.b.trim().length() > 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(this.jdField_a_of_type_Int).append(",").append(this.jdField_a_of_type_JavaLangString).append(",").append(this.b).append(",").append(this.c).append(",").append(this.d).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\ProfileBusiEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */