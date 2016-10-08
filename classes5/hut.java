import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionActivity;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionPagerAdapter;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ImageCollectionGallery;
import java.util.ArrayList;

public class hut
  extends PublicAccountArticleObserver
{
  public hut(ImageCollectionActivity paramImageCollectionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageCollectionSSOTAG", 2, "onCreateArticleCommentRespond isSuccess= " + paramBoolean);
    }
    ImageCollectionActivity.a(this.a, paramBoolean);
    if (paramBoolean)
    {
      ImageCollectionActivity.d(this.a);
      ImageCollectionActivity.b(this.a, ImageCollectionActivity.e(this.a));
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageCollectionSSOTAG", 2, "onGetArticleCommentCountRespond isSuccess= " + paramBoolean + "count" + paramInt);
    }
    ImageCollectionActivity.d(this.a, paramInt);
    ImageCollectionActivity.b(this.a, ImageCollectionActivity.e(this.a));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageCollectionSSOTAG", 2, "onSendArticleLikeReq isSuccess= " + paramBoolean + "articleID" + paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageCollectionSSOTAG", 2, "onQueryArticleLikeCount isSuccess= " + paramBoolean + "articleID" + paramString + "likeCount" + paramInt);
    }
    ImageCollectionActivity.c(this.a, paramInt);
    ImageCollectionActivity.a(this.a, paramInt);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, ArrayList paramArrayList, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if (!paramBoolean)
    {
      ImageCollectionActivity.f(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImageCollectionSSOTAG", 2, "onGetPhotoCollectionInfoRespond articleUrl = " + paramString1 + "puin = " + paramString2 + "imgUrl" + paramString3 + "title:" + paramString4);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      ImageCollectionActivity.a(this.a, paramString1);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      ImageCollectionActivity.b(this.a, paramString4);
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!"0".equals(paramString2))) {
      ImageCollectionActivity.c(this.a, paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      ImageCollectionActivity.d(this.a, paramString3);
    }
    if (paramArrayList != null) {
      ImageCollectionActivity.a(this.a, paramArrayList);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      ImageCollectionActivity.e(this.a, paramString5);
    }
    ImageCollectionActivity.a(this.a, new ImageCollectionPagerAdapter(this.a));
    ImageCollectionActivity.a(this.a).setAdapter(ImageCollectionActivity.a(this.a));
    ImageCollectionActivity.a(this.a).a(ImageCollectionActivity.c(this.a));
    ImageCollectionActivity.a(this.a).b(ImageCollectionActivity.a(this.a));
    ImageCollectionActivity.c(this.a, false);
    if (paramInt == 1) {
      ImageCollectionActivity.c(this.a, true);
    }
    if (this.a.a == null)
    {
      this.a.a = new Share(ImageCollectionActivity.a(this.a), this.a);
      this.a.a.a(ImageCollectionActivity.c(this.a), "  ", ImageCollectionActivity.d(this.a), ImageCollectionActivity.e(this.a), null, true);
    }
    ImageCollectionActivity.g(this.a);
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    ImageCollectionActivity.b(this.a, paramBoolean2);
    if (paramBoolean2) {
      ImageCollectionActivity.a(this.a).setImageResource(2130838800);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageCollectionSSOTAG", 2, "onCheckIsArticleLiked isSuccess= " + paramBoolean1 + "articleID" + paramString + "isLiked" + paramBoolean2);
      }
      return;
      ImageCollectionActivity.a(this.a).setImageResource(2130838907);
    }
  }
  
  public void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageCollectionSSOTAG", 2, "onGetRecommendInfoRespond isSuccess= " + paramBoolean);
    }
    if (paramArrayList != null) {
      ImageCollectionActivity.b(this.a, paramArrayList);
    }
    if (ImageCollectionActivity.a(this.a) != null) {
      ImageCollectionActivity.a(this.a).b(ImageCollectionActivity.a(this.a));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageCollectionSSOTAG", 2, "onReportReadPhotoCollectionRespond isSuccess= " + paramBoolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */