import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoListAdapter;
import com.tencent.biz.pubaccount.VideoListView;
import com.tencent.biz.pubaccount.VideoPlayRecommendObserver;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class pkd
  extends VideoPlayRecommendObserver
{
  public pkd(ShortVideoPlayActivity paramShortVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onGetRecommendInit isSuccess: " + paramBoolean + " | data.size()=: " + paramArrayList.size());
    }
    if (!paramBoolean)
    {
      ShortVideoPlayActivity.a(this.a).setCurrentStatus(2);
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)paramArrayList.next();
      if (ShortVideoPlayActivity.a(this.a).contains(localVideoInfo.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onGetRecommendInit info.vid=" + localVideoInfo.a + " has exist");
        }
      }
      else
      {
        ShortVideoPlayActivity.a(this.a).add(localVideoInfo);
        ShortVideoPlayActivity.a(this.a).add(localVideoInfo.a);
      }
    }
    ShortVideoPlayActivity.a(this.a).setCurrentStatus(0);
    ShortVideoPlayActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pkd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */