import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector.CompletedHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.os.MqqHandler;

class irs
  implements StepExector.CompletedHandler
{
  irs(irr paramirr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    SLog.d("Q.qqstory.home.Repository", "finish get all data from server steps");
    StoryReportor.b("home_page", "refresh_time", 0, 0, new String[] { String.valueOf(NetConnInfoCenter.getServerTimeMillis() - this.a.a.a) });
    ((StoryConfigManager)SuperManager.a(10)).b("story_list_request_data_from_net_running_state", Integer.valueOf(1));
    ThreadManager.c().post(new irt(this));
    Repository.a(this.a.a, true, false);
    Repository.a(this.a.a, true);
    Repository.a(this.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\irs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */