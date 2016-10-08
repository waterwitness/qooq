package com.tencent.biz.qqstory.base.videoupload.task;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class BaseTaskInfo
{
  public volatile int a;
  public long a;
  public ErrorMessage a;
  public List a;
  public int b;
  
  public BaseTaskInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 3);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 7);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("BaseTaskInfo{");
    localStringBuffer.append("status=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", retryTimes=").append(this.b);
    localStringBuffer.append(", result=").append(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\task\BaseTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */