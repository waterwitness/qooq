import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoAllTaskChangeEvent;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class iic
  extends SimpleJob
{
  public iic(StoryVideoUploadManager paramStoryVideoUploadManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Object a(JobContext paramJobContext, Void... paramVarArgs)
  {
    paramVarArgs = ((StoryManager)SuperManager.a(5)).a();
    paramJobContext = new ArrayList(paramVarArgs.size());
    paramVarArgs = paramVarArgs.iterator();
    while (paramVarArgs.hasNext()) {
      paramJobContext.add(new StoryVideoTaskInfo((StoryVideoItem)paramVarArgs.next()));
    }
    this.a.a(paramJobContext);
    SLog.c("Q.qqstory.publish:StoryVideoUploadManager", "had load local task size " + paramJobContext.size());
    Dispatchers.get().dispatch(new StoryVideoUploadManager.StoryVideoAllTaskChangeEvent());
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */