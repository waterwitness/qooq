import android.view.View;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionRecommendAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ImageProgressCircle;

public class hvw
  implements URLDrawableDownListener
{
  public hvw(ImageCollectionRecommendAdapter paramImageCollectionRecommendAdapter, ImageProgressCircle paramImageProgressCircle, URLImageView paramURLImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.setProgress(paramInt / 100);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    ImageCollectionRecommendAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionRecommendAdapter, this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramURLDrawable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hvw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */