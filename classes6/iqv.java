import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryConfigManager.StoryConfigEvent;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iqv
  extends UIBaseEventReceiver
{
  public iqv(QQStoryMainActivity paramQQStoryMainActivity)
  {
    super(paramQQStoryMainActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QQStoryMainActivity paramQQStoryMainActivity, StoryConfigManager.StoryConfigEvent paramStoryConfigEvent)
  {
    if (((Boolean)((StoryConfigManager)SuperManager.a(10)).b("first_time_pic", Boolean.valueOf(false))).booleanValue())
    {
      ((QQStoryManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(180)).a("9999_HD", new iqw(this, paramQQStoryMainActivity));
      StoryReportor.a("easter_egg", "exp", 0, 0, new String[] { "" });
    }
  }
  
  public Class acceptEventClass()
  {
    return StoryConfigManager.StoryConfigEvent.class;
  }
  
  public void b(QQStoryMainActivity paramQQStoryMainActivity, StoryConfigManager.StoryConfigEvent paramStoryConfigEvent) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iqv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */