package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class TopicVideoListPagerLoader$GetTopicVideoEvent
  extends BasePageLoaderEvent
{
  public int a;
  public long a;
  public String a;
  public List a;
  public long b;
  
  public TopicVideoListPagerLoader$GetTopicVideoEvent(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public String toString()
  {
    return "GetStoryVideoListEvent{cookie='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mVideoItems=" + this.jdField_a_of_type_JavaUtilList + ", topicId=" + this.jdField_a_of_type_Long + ", storyVideoTotalTime=" + this.b + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\TopicVideoListPagerLoader$GetTopicVideoEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */