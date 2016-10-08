package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class GetHotTopicListHandler$HotTopicListEvent
  extends BasePageLoaderEvent
{
  public ArrayList a;
  
  public GetHotTopicListHandler$HotTopicListEvent(GetHotTopicListHandler paramGetHotTopicListHandler, ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    return "HotTopicListEvent{mHotTopicItems=" + this.jdField_a_of_type_JavaUtilArrayList + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\GetHotTopicListHandler$HotTopicListEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */