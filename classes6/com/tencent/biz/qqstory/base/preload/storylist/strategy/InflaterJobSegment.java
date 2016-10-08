package com.tencent.biz.qqstory.base.preload.storylist.strategy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class InflaterJobSegment
  extends JobSegment
{
  private static final String jdField_a_of_type_JavaLangString = "Q.qqstory.download.preload.InflaterJobSegment";
  private InflaterRepeatPolicy jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyInflaterRepeatPolicy;
  
  public InflaterJobSegment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(JobContext paramJobContext, List paramList)
  {
    if (this.a != null) {
      this.a.b(paramList);
    }
    super.notifyResult(paramList);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\strategy\InflaterJobSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */