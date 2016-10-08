import android.os.Bundle;
import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.biz.pubaccount.VideoListView.OnRefreshListener;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hoz
  implements VideoListView.OnRefreshListener
{
  public hoz(MultiVideoPlayActivity paramMultiVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    String str = this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID");
    this.a.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler.a(Long.parseLong(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a()), str);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hoz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */