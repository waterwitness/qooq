package com.tencent.mobileqq.apollo.task;

import com.tencent.mobileqq.apollo.IRenderCommInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ApolloTaskParam
{
  public int a;
  public long a;
  public IRenderCommInterface a;
  public IApolloActDldCallback a;
  public IApolloTaskListener a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public int f;
  
  public ApolloTaskParam()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = -1;
    this.jdField_c_of_type_Boolean = true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[mAvatarID:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("],[mPlayMode:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("],[mFromWhere:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("],[mSessionType:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("],[mManNum:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("],[mIsSend:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("],[taskId:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("],[sendUin:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("],[recUin:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("],[msgId:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]\n");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\task\ApolloTaskParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */