import com.tencent.biz.qqstory.model.DoodleEmojiManager.POIPostersRequestCallback;
import com.tencent.biz.qqstory.model.item.POIPosterItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryDoodle;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

public class iuq
  implements DoodleEmojiManager.POIPostersRequestCallback
{
  public iuq(NewStoryDoodle paramNewStoryDoodle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, List paramList)
  {
    SLog.b("Q.qqstory.record.StoryDoodle", "onPOIPostersRequestResult callback");
    iuw localiuw = NewStoryDoodle.a(this.a);
    if (localiuw == null)
    {
      SLog.d("Q.qqstory.record.StoryDoodle", "adapter is empty, we receive the callback after we onDestroy(), so ignore it");
      return;
    }
    if (paramInt != 0)
    {
      SLog.e("Q.qqstory.record.StoryDoodle", "onPOIPostersRequestResult callback error = " + paramInt);
      NewStoryDoodle.a(this.a).jdField_a_of_type_Boolean = false;
      localiuw.a(NewStoryDoodle.a(this.a));
      return;
    }
    NewStoryDoodle.a(this.a).jdField_a_of_type_JavaUtilList.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      POIPosterItem localPOIPosterItem = (POIPosterItem)paramList.next();
      LocationFacePackage.Item localItem = new LocationFacePackage.Item();
      localItem.d = localPOIPosterItem.d;
      localItem.b = localPOIPosterItem.a;
      localItem.c = localPOIPosterItem.b;
      localItem.a = localPOIPosterItem.c;
      localItem.e = localPOIPosterItem.e;
      NewStoryDoodle.a(this.a).jdField_a_of_type_JavaUtilList.add(localItem);
    }
    NewStoryDoodle.a(this.a).jdField_a_of_type_Boolean = false;
    localiuw.a(NewStoryDoodle.a(this.a, false));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iuq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */