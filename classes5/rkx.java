import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.comic.VipComicReportUtils;

public class rkx
  implements ActionSheet.OnButtonClickListener
{
  public rkx(FavoriteEmoticonInfo paramFavoriteEmoticonInfo, QQAppInterface paramQQAppInterface, EmoticonCallback paramEmoticonCallback, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 3;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmoticonInfo.n)) && (AIOGallerySceneWithBusiness.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmoticonInfo.n))) {
        VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3016", "2", "40052", AIOGallerySceneWithBusiness.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmoticonInfo.n), new String[] { String.valueOf(paramInt), "", AIOGallerySceneWithBusiness.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmoticonInfo.n) });
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmoticonInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramInt = 1;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmoticonInfo);
      paramInt = 2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */