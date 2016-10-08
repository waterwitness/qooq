import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver.PhotoItemInfo;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionActivity;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public class hvd
  implements ActionSheet.OnButtonClickListener
{
  String jdField_a_of_type_JavaLangString;
  
  public hvd(ImageCollectionActivity paramImageCollectionActivity, ActionSheet paramActionSheet, URLDrawable paramURLDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = ((PublicAccountArticleObserver.PhotoItemInfo)ImageCollectionActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionActivity).get(ImageCollectionActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionActivity))).jdField_a_of_type_JavaLangString;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
    if (this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionActivity.getString(2131370093).equals(paramView)) {
      ImageCollectionActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionActivity, this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionActivity.getString(2131370099).equals(paramView)) {
        ImageCollectionActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountImageCollectionImageCollectionActivity, this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hvd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */