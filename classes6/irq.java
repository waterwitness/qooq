import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.AsyncJob;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.IMyStroyPresenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class irq
  extends AsyncJob
{
  public irq(Repository paramRepository)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Boolean a(Void... paramVarArgs)
  {
    if ((Repository.a(this.a) | Repository.b(this.a) | Repository.c(this.a) | Repository.d(this.a) | Repository.e(this.a))) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  public void a(Boolean paramBoolean)
  {
    if (!paramBoolean.booleanValue())
    {
      if (Repository.f(this.a))
      {
        this.a.c();
        return;
      }
      QQToast.a(this.a.a, 1, "当前网络不可用，请检查你的网络设置", 0).a();
      Repository.a(this.a, false, true);
      ((StoryConfigManager)SuperManager.a(10)).b("story_list_request_data_from_net_running_state", Integer.valueOf(1));
      Repository.a(this.a).d();
      return;
    }
    if (Repository.f(this.a))
    {
      Repository.a(this.a, true, true, false);
      this.a.c();
      return;
    }
    Repository.a(this.a, true, true, true);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\irq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */