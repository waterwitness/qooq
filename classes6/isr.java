import com.tencent.biz.qqstory.base.preload.pgc.PGCUrlChecker.CheckResultListener;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.GetPreloadVideoHandler.GetPreloadVideoEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetPreloadVideoStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class isr
  implements PGCUrlChecker.CheckResultListener
{
  public isr(GetPreloadVideoStep paramGetPreloadVideoStep, GetPreloadVideoHandler.GetPreloadVideoEvent paramGetPreloadVideoEvent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Map paramMap)
  {
    paramMap = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetPreloadVideoStep.jdField_b_of_type_JavaUtilList.iterator();
    while (paramMap.hasNext())
    {
      String str = (String)paramMap.next();
      List localList = (List)this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetPreloadVideoHandler$GetPreloadVideoEvent.b.get(str);
      if ((localList != null) && (localList.size() > 0)) {
        ((StoryManager)SuperManager.a(5)).a().a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetPreloadVideoStep.jdField_b_of_type_JavaLangString, str, localList, false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\isr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */