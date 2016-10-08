import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoListAdapter;
import com.tencent.biz.pubaccount.VideoListView;
import com.tencent.biz.pubaccount.VideoPlayRecommendObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class hoi
  extends VideoPlayRecommendObserver
{
  public hoi(MultiVideoPlayActivity paramMultiVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "onGetRecommendInit isSuccess: " + paramBoolean + " | data.size()=: " + paramArrayList.size());
    }
    if (!paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountVideoListView == null) {
        return;
      }
      this.a.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setCurrentStatus(2);
      return;
    }
    paramArrayList = paramArrayList.iterator();
    paramBoolean = false;
    while (paramArrayList.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)paramArrayList.next();
      if (this.a.jdField_a_of_type_JavaUtilHashSet.contains(localVideoInfo.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "onGetRecommendInit info.vid=" + localVideoInfo.a + " has exist");
        }
      }
      else
      {
        paramBoolean = true;
        this.a.jdField_a_of_type_JavaUtilList.add(localVideoInfo);
        this.a.jdField_a_of_type_JavaUtilHashSet.add(localVideoInfo.a);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "hasNewVideo = " + paramBoolean);
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setCurrentStatus(0);
    this.a.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hoi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */