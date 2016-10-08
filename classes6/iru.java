import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector.ErrorHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.os.MqqHandler;

class iru
  implements StepExector.ErrorHandler
{
  iru(irr paramirr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    SLog.e("Q.qqstory.home.Repository", "strp %s error occur when get all data from server error=%s", new Object[] { paramErrorMessage.extraMsg, paramErrorMessage.getErrorMessage() });
    Repository.a(this.a.a, false, false);
    paramErrorMessage = (StoryConfigManager)SuperManager.a(10);
    StoryReportor.b("home_page", "refresh_time", 0, 1, new String[] { String.valueOf(NetConnInfoCenter.getServerTimeMillis() - this.a.a.a) });
    paramErrorMessage.b("story_list_request_data_from_net_running_state", Integer.valueOf(2));
    ThreadManager.c().post(new irv(this));
    Repository.a(this.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */