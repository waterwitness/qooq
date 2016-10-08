import android.view.View;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStoryPoiSearchViewPart;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.poilist.QQStoryPoiListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class ivu
  implements LbsManager.POIListRequestCallback
{
  public ivu(NewStoryPoiSearchViewPart paramNewStoryPoiSearchViewPart, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, LbsManager.POIListRequestSession paramPOIListRequestSession, List paramList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = paramPOIListRequestSession;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.isFinishing()) {
      return;
    }
    if (paramInt == 0) {
      if (paramPOIListRequestSession.a()) {
        break label213;
      }
    }
    label213:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.d.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.a(bool);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.b()) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.notifyDataSetChanged();
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      StoryReportor.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */