package com.tencent.biz.qqstory.base.preload.storylist.strategy;

import com.tencent.biz.qqstory.base.preload.storylist.PreloadVideoSource;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.StreamFunction;
import iib;

public class StrategySet
{
  private static final String jdField_a_of_type_JavaLangString = "Q.qqstory.download.preload.StrategySet";
  private ClickPolicy jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyClickPolicy;
  private InflaterRepeatPolicy jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyInflaterRepeatPolicy;
  private NetConditionPolicy jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyNetConditionPolicy;
  
  public StrategySet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyClickPolicy = new ClickPolicy();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyNetConditionPolicy = new NetConditionPolicy();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyInflaterRepeatPolicy = new InflaterRepeatPolicy();
  }
  
  public void a(PreloadVideoSource paramPreloadVideoSource, StrategySet.OnDownloadQueuePrepareListener paramOnDownloadQueuePrepareListener)
  {
    SLog.b("Q.qqstory.download.preload.StrategySet", "start to generate new download queue");
    long l = System.currentTimeMillis();
    Object localObject1 = new VariantJobSegment.Builder();
    ((VariantJobSegment.Builder)localObject1).a(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyClickPolicy).a(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyNetConditionPolicy);
    localObject1 = ((VariantJobSegment.Builder)localObject1).a();
    Object localObject2 = new InflaterJobSegment.Builder();
    ((InflaterJobSegment.Builder)localObject2).a(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyInflaterRepeatPolicy);
    localObject2 = ((InflaterJobSegment.Builder)localObject2).a();
    Stream.of(paramPreloadVideoSource).map((StreamFunction)localObject1).map((StreamFunction)localObject2).subscribe(new iib(this, paramOnDownloadQueuePrepareListener, l));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyClickPolicy.a(paramString1, paramString2);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\strategy\StrategySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */