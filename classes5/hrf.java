import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoListView;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class hrf
  implements View.OnClickListener
{
  public hrf(VideoListView paramVideoListView, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.jdField_a_of_type_AndroidContentContext, "网络连接不可用，请检查网络设置。", 2000).a();
    }
    do
    {
      return;
      if (VideoListView.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoListView))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.a(false);
        this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.a(VideoListView.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoListView) - 1);
        VideoListView.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoListView, this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"), false);
        ReportController.b(null, "CliOper", "", "", "0X80069AF", "0X80069AF", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.a(VideoListView.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoListView) + 1);
      VideoListView.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoListView, this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"), true);
      ReportController.b(null, "CliOper", "", "", "0X80069AE", "0X80069AE", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
    } while ((!this.jdField_a_of_type_AndroidOsBundle.containsKey("isFromKandian")) || (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromKandian")));
    VideoReporter.a(this.jdField_a_of_type_AndroidOsBundle.getString("innderId"), (int)this.jdField_a_of_type_AndroidOsBundle.getLong("channelID", 0L), (int)this.jdField_a_of_type_AndroidOsBundle.getLong("algorithmID", 0L), (int)this.jdField_a_of_type_AndroidOsBundle.getLong("strategyId", 0L), 2, -1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hrf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */