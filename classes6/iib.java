import com.tencent.biz.qqstory.base.preload.storylist.strategy.StrategySet;
import com.tencent.biz.qqstory.base.preload.storylist.strategy.StrategySet.OnDownloadQueuePrepareListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.reactive.SimpleObserver;
import java.util.List;

public class iib
  extends SimpleObserver
{
  public iib(StrategySet paramStrategySet, StrategySet.OnDownloadQueuePrepareListener paramOnDownloadQueuePrepareListener, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(List paramList)
  {
    super.onNext(paramList);
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyStrategySet$OnDownloadQueuePrepareListener != null)
    {
      long l = System.currentTimeMillis();
      SLog.b("Q.qqstory.download.preload.StrategySet", "apply total spend time = " + (l - this.jdField_a_of_type_Long));
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyStrategySet$OnDownloadQueuePrepareListener.a(paramList);
    }
  }
  
  public void onError(Error paramError)
  {
    super.onError(paramError);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */