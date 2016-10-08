package com.tencent.biz.qqstory.base.preload.storylist.strategy;

import com.tencent.biz.qqstory.base.preload.storylist.PreloadVideoSource;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class VariantJobSegment
  extends JobSegment
{
  public static final String a = "Q.qqstory.download.preload.VariantJobSegment";
  public ClickPolicy a;
  public NetConditionPolicy a;
  
  public VariantJobSegment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(JobContext paramJobContext, PreloadVideoSource paramPreloadVideoSource)
  {
    long l = System.currentTimeMillis();
    paramJobContext = new ArrayList();
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyClickPolicy != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyClickPolicy.a(paramPreloadVideoSource, paramJobContext);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyNetConditionPolicy != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyNetConditionPolicy.a(paramPreloadVideoSource, paramJobContext);
    }
    a(paramJobContext);
    super.notifyResult(paramJobContext);
    SLog.b("Q.qqstory.download.preload.VariantJobSegment", "runSegment cost time=" + (System.currentTimeMillis() - l));
  }
  
  public void a(List paramList) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\strategy\VariantJobSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */