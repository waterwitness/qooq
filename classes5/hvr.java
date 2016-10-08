import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionCommentActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hvr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public hvr(ImageCollectionCommentActivity paramImageCollectionCommentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    int i = ImageCollectionCommentActivity.a(this.a).getRootView().getHeight() - ImageCollectionCommentActivity.a(this.a).getHeight();
    if (QLog.isDevelopLevel()) {
      QLog.d("ImageCollectionCommentActivity", 2, "heightDiff:" + i);
    }
    if (i > 150) {
      ImageCollectionCommentActivity.a(this.a, true);
    }
    while (!ImageCollectionCommentActivity.a(this.a)) {
      return;
    }
    ImageCollectionCommentActivity.a(this.a, false);
    ImageCollectionCommentActivity.a(this.a, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hvr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */