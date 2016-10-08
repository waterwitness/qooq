package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class DefaultPlayerVideoListSynchronizer$PlayerVideoListEvent
  extends BaseEvent
{
  public int a;
  public long a;
  public LiveVideoEntry a;
  public String a;
  public List a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public long c;
  
  public DefaultPlayerVideoListSynchronizer$PlayerVideoListEvent(DefaultPlayerVideoListSynchronizer paramDefaultPlayerVideoListSynchronizer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String toString()
  {
    return "PlayerVideoListEvent{context='" + this.jdField_a_of_type_JavaLangString + '\'' + ", isEnd=" + this.jdField_b_of_type_Boolean + ", isFromCache=" + this.jdField_a_of_type_Boolean + ", label='" + this.jdField_b_of_type_JavaLangString + '\'' + ", mStoryVideoItems=" + this.jdField_a_of_type_JavaUtilList.size() + ", totalTime=" + this.c + ", uid=" + this.jdField_a_of_type_Long + ", videoCount=" + this.jdField_a_of_type_Int + ", liveVideoInfo=" + this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\DefaultPlayerVideoListSynchronizer$PlayerVideoListEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */