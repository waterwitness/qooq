import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryDoodle;
import com.tencent.biz.qqstory.takevideo.NewStoryPoiList.SelectLocationCallback;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopBarPOI;

public class iuo
  implements NewStoryPoiList.SelectLocationCallback
{
  public iuo(NewStoryDoodle paramNewStoryDoodle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    SLog.c("Q.qqstory.record.StoryDoodle", "onSelectLocationCancel");
  }
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    SLog.c("Q.qqstory.record.StoryDoodle", "onSelectLocation " + paramTroopBarPOI);
    if (paramTroopBarPOI != null)
    {
      NewStoryDoodle.a(this.a).setLocation(paramTroopBarPOI.j);
      return;
    }
    NewStoryDoodle.a(this.a).setLocation("None for test!!");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iuo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */