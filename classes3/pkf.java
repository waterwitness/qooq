import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoListView.OnRefreshListener;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pkf
  implements VideoListView.OnRefreshListener
{
  public pkf(ShortVideoPlayActivity paramShortVideoPlayActivity, AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.a.getString("VIDEO_ARTICLE_ID");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    if (ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity) != null) {
      ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity).a(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()), str1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pkf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */