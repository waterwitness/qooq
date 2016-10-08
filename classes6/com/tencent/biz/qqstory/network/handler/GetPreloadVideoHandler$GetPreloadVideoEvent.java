package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Map;

public class GetPreloadVideoHandler$GetPreloadVideoEvent
  extends BaseEvent
{
  public int a;
  public Map a;
  public Map b;
  
  public GetPreloadVideoHandler$GetPreloadVideoEvent()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder().append("GetPreloadVideoEvent{pullType=").append(this.jdField_a_of_type_Int).append(", mUinPreloadVideoList size =");
    if (this.jdField_a_of_type_JavaUtilMap != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilMap.size();; i = 0)
    {
      localStringBuilder = localStringBuilder.append(i).append(", mUnionIdPreloadVideoList size =");
      i = j;
      if (this.b != null) {
        i = this.b.size();
      }
      return i + '}';
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\GetPreloadVideoHandler$GetPreloadVideoEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */