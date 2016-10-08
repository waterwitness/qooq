package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class FileMsg$StepTransInfo
  extends FileMsg.StepBaseInfo
{
  public HashMap a;
  public String b;
  public String c;
  public boolean c;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public long f;
  
  public FileMsg$StepTransInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public String a()
  {
    if (a())
    {
      long l1 = this.jdField_d_of_type_Long;
      long l2 = this.jdField_e_of_type_Long;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append("result:" + this.jdField_a_of_type_Boolean);
      localStringBuilder.append(",elapsed:" + a());
      localStringBuilder.append(",errCode:" + this.jdField_a_of_type_Int);
      localStringBuilder.append(",retryCount:" + this.b);
      localStringBuilder.append(",flow:" + (l1 + l2));
      localStringBuilder.append(",isStream:" + this.jdField_d_of_type_Boolean);
      localStringBuilder.append(",httpCode:" + this.jdField_e_of_type_Int);
      localStringBuilder.append(",serverExist:" + this.jdField_c_of_type_Boolean);
      localStringBuilder.append(",isBigChannel:" + this.jdField_e_of_type_Boolean);
      if (this.jdField_c_of_type_Long != Long.MAX_VALUE) {
        localStringBuilder.append(",detailError:" + this.jdField_c_of_type_Long);
      }
      localStringBuilder.append(",firstIp:" + this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append(",lastUseIp:" + this.jdField_d_of_type_JavaLangString);
      localStringBuilder.append(",respHeader:" + this.jdField_e_of_type_JavaLangString);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    return "{}";
  }
  
  public String b()
  {
    if (a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append("elapsed:" + a());
      localStringBuilder.append(",tryCount:" + this.b);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    return "{}";
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\FileMsg$StepTransInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */