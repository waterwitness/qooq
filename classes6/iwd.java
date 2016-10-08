import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantItem;
import com.tencent.biz.qqstory.model.pendant.PendantManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStorySelectPendant;
import com.tencent.biz.qqstory.takevideo.pendant.OnPendantItemClickListener;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class iwd
  implements OnPendantItemClickListener
{
  private iwd(NewStorySelectPendant paramNewStorySelectPendant)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NewStoryPendantItem paramNewStoryPendantItem, int paramInt1, int paramInt2)
  {
    NewStorySelectPendant.a(this.a, paramNewStoryPendantItem);
    if (paramNewStoryPendantItem == NewStoryPendantItem.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem)
    {
      StoryReportor.a("video_shoot", "close_effect", 0, 0, new String[0]);
      NewStorySelectPendant.a(this.a).setVideoFilter("");
      NewStorySelectPendant.b(this.a, paramNewStoryPendantItem);
    }
    while (paramNewStoryPendantItem == NewStoryPendantItem.b) {
      return;
    }
    StoryReportor.a("video_shoot", "use_effect", 0, 0, new String[] { paramNewStoryPendantItem.jdField_a_of_type_JavaLangString });
    String str = paramNewStoryPendantItem.a();
    if (str != null)
    {
      NewStorySelectPendant.a(this.a).setVideoFilter(str);
      NewStorySelectPendant.b(this.a, paramNewStoryPendantItem);
      return;
    }
    if (!((PendantManager)SuperManager.a(11)).a(paramNewStoryPendantItem, false))
    {
      SLog.d("Q.qqstory.record.NewStorySelectPendant", "can not fire downloading pendant : " + paramNewStoryPendantItem);
      QQToast.a(this.a.a, "无法下载", 0).a();
      return;
    }
    SLog.c("Q.qqstory.record.NewStorySelectPendant", "start download pendant : " + paramNewStoryPendantItem);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */