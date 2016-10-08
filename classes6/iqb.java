import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;

public class iqb
  extends QQStoryObserver
{
  public iqb(QQStoryBasicSettingsActivity paramQQStoryBasicSettingsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    QQStoryBasicSettingsActivity.a(this.a);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 1001: 
      this.a.a(0);
      return;
    case 2: 
      this.a.a(1);
      return;
    case 3: 
      this.a.a(2);
      return;
    }
    QQToast.a(this.a, "请求失败!", 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.a(this.a.b(this.a.e));
      if (this.a.e == 2) {
        ReportController.b(null, "dc00899", "grp_story", "", "browse_friend_settings", "close", 0, 0, "", "", "", "");
      }
      do
      {
        return;
        if (this.a.e == 0)
        {
          ReportController.b(null, "dc00899", "grp_story", "", "browse_friend_settings", "choose_all", 0, 0, "", "", "", "");
          return;
        }
      } while (this.a.e != 1);
      ReportController.b(null, "dc00899", "grp_story", "", "browse_friend_settings", "choose_wifi", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.a, 2131371675, 0).b(this.a.getTitleBarHeight());
    this.a.a(this.a.f);
    this.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.b();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */