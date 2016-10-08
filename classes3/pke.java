import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.biz.pubaccount.VideoListView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pke
  extends PublicAccountArticleObserver
{
  public pke(ShortVideoPlayActivity paramShortVideoPlayActivity)
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
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.a.a.getString("VIDEO_ARTICLE_ID"))) || (paramInt == 0)) {
      return;
    }
    ShortVideoPlayActivity.a(this.a).a(paramInt);
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onCheckIsArticleLiked isSuccess=" + paramBoolean1 + ", articleID=" + paramString + ", isLiked=" + paramBoolean2 + ", mBundle.getString(VideoUIController.VIDEO_ARTICLE_ID)=" + this.a.a.getString("VIDEO_ARTICLE_ID"));
    }
    if ((!paramBoolean1) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.a.a.getString("VIDEO_ARTICLE_ID")))) {
      return;
    }
    ShortVideoPlayActivity.a(this.a).a(paramBoolean2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */