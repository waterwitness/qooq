import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.biz.pubaccount.VideoListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class hor
  extends PublicAccountArticleObserver
{
  public hor(MultiVideoPlayActivity paramMultiVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onSendArticleLikeReq isSuccess=" + paramBoolean + ", articleID=" + paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onQueryArticleLikeCount isSuccess=" + paramBoolean + ", articleID=" + paramString + ", likeCount=" + paramInt);
    }
    if ((this.a.jdField_a_of_type_ComTencentBizPubaccountVideoListView == null) || (!paramBoolean) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"))) || (paramInt == 0)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountVideoListView.a(paramInt);
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onCheckIsArticleLiked isSuccess=" + paramBoolean1 + ", articleID=" + paramString + ", isLiked=" + paramBoolean2 + ", mBundle.getString(VideoUIController.VIDEO_ARTICLE_ID)=" + this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"));
    }
    if ((this.a.jdField_a_of_type_ComTencentBizPubaccountVideoListView == null) || (!paramBoolean1) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID")))) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountVideoListView.a(paramBoolean2);
    ReadInJoyHelper.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, paramBoolean2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */