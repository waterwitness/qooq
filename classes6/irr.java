import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.AsyncStepExector;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetFriendsStoryStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetHotTopicListStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetOfficialRecommendStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetRecentStroyStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.ReportWatchVideoListStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class irr
  implements Runnable
{
  public irr(Repository paramRepository)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.b();
    }
    if (this.a.b != null) {
      this.a.b.b();
    }
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestAsyncStepExector != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestAsyncStepExector.b();
    }
    if (this.a.c != null) {
      this.a.c.b();
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestAsyncStepExector = new AsyncStepExector();
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestAsyncStepExector.b(new ReportWatchVideoListStep(this.a)).a(new GetMyStoryStep(this.a)).a(new GetOfficialRecommendStep(this.a)).a(new GetRecentStroyStep(this.a)).a(new GetHotTopicListStep(this.a)).a(new GetFriendsStoryStep(this.a)).a(new iru(this)).a(new irs(this));
    this.a.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    SLog.d("Q.qqstory.home.Repository", "start get all data from server steps");
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestAsyncStepExector.a();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\irr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */