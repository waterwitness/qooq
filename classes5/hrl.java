import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoPlayActivity;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class hrl
  implements View.OnClickListener
{
  public hrl(VideoPlayActivity paramVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.a.findViewById(2131298791).getVisibility() == 8) && (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
    {
      paramView = Long.toString(this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      VideoReporter.a("0X80065FA", this.a.getIntent().getExtras().getInt("VIDEO_AIO_UIN_TYPE"), this.a.b, this.a.getIntent().getExtras().getString("VIDEO_VID"), paramView);
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.a(false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */