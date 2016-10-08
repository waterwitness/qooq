import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoListAdapter;
import com.tencent.biz.pubaccount.VideoListAdapter.VideoListEventListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hrc
  implements View.OnClickListener
{
  public hrc(VideoListAdapter paramVideoListAdapter, VideoInfo paramVideoInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter.a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter.a.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hrc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */