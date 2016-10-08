import android.text.TextUtils;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStoryPoiList;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.poilist.QQStoryPoiListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

public class ivm
  implements LbsManager.POIListRequestCallback
{
  public ivm(NewStoryPoiList paramNewStoryPoiList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, LbsManager.POIListRequestSession paramPOIListRequestSession, List paramList)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = paramPOIListRequestSession;
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.isFinishing()) {
      return;
    }
    boolean bool;
    if (paramInt == 0) {
      if (!paramPOIListRequestSession.a())
      {
        bool = true;
        this.a.a(bool);
        if (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
          this.a.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.b()) {
          this.a.jdField_a_of_type_JavaUtilArrayList.clear();
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) && (paramList.size() > 0)) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramList.get(0));
        }
        this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter != null)
        {
          this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.notifyDataSetChanged();
          if (!this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            break label290;
          }
          this.a.a(false, false);
        }
        label206:
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
          break label316;
        }
        if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.j)) {
          break label302;
        }
        paramPOIListRequestSession = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.k;
        label243:
        this.a.a(1, new String[] { paramPOIListRequestSession });
      }
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      StoryReportor.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
      bool = false;
      break;
      label290:
      this.a.a(true, false);
      break label206;
      label302:
      paramPOIListRequestSession = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.j;
      break label243;
      label316:
      this.a.a(0, new String[0]);
      continue;
      this.a.a(3, new String[0]);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */