import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.base.preload.storylist.PreloadVideoSource;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetFriendsVideoStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FriendsSegment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import java.util.ArrayList;
import java.util.List;

public class itx
  extends Job
{
  public itx(FriendsSegment paramFriendsSegment, StoryItem paramStoryItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Object doInBackground(JobContext paramJobContext, Object... paramVarArgs)
  {
    long l = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryItem.user.uid;
    paramJobContext = ((StoryManager)SuperManager.a(5)).b(l);
    if ((paramJobContext == null) || (paramJobContext.size() == 0))
    {
      SLog.d("Q.qqstory.home.friend.FriendsSegment", "click not found video list , request uin = " + l);
      paramJobContext = new Repository(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFriendsSegment.jdField_a_of_type_AndroidContentContext);
      paramJobContext.a = true;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFriendsSegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetFriendsVideoStep = new GetFriendsVideoStep(paramJobContext, l);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFriendsSegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetFriendsVideoStep.b();
    }
    for (;;)
    {
      return null;
      paramVarArgs = (PreloadVideoSource)((StoryManager)SuperManager.a(5)).a();
      Object localObject = paramVarArgs.a(IPreloadVideoSource.b, String.valueOf(l));
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        SLog.d("Q.qqstory.home.friend.FriendsSegment", "click not found preloadList , get from dbCache first one , request uin = " + l);
        localObject = new ArrayList();
        ((List)localObject).add(paramJobContext.get(0));
        paramVarArgs.a(IPreloadVideoSource.b, String.valueOf(l), (List)localObject, true);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\itx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */