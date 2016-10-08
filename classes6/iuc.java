import android.os.Bundle;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView.OnSegmentDataChangeListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.OfficialRecommendSegment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class iuc
  extends QQStoryObserver
{
  public iuc(OfficialRecommendSegment paramOfficialRecommendSegment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void b(boolean paramBoolean, int paramInt, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "OfficialRecommendSegment onGetSubscribeMediaList isSuccess" + paramBoolean + " seq=" + paramInt + " data:" + paramList);
    }
    Bundle localBundle;
    if ((paramBoolean) && (paramList != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView != null))
    {
      this.a.a(paramList);
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$OnSegmentDataChangeListener != null)
      {
        localBundle = new Bundle();
        if (paramList.size() <= 0) {
          break label130;
        }
      }
    }
    label130:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localBundle.putBoolean("needShowTitle", paramBoolean);
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$OnSegmentDataChangeListener.a("offical_recommend", localBundle);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */