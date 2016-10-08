import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoListAdapter.VideoListEventListener;
import com.tencent.biz.pubaccount.VideoListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class hre
  implements View.OnClickListener
{
  public hre(VideoListView paramVideoListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (VideoListView.a(this.a) != null)
    {
      VideoListView.a(this.a).h();
      ReportController.b(null, "CliOper", "", "", "0X80069B0", "0X80069B0", 0, 0, "3", "", "", this.a.a.getString("VIDEO_VID"));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */