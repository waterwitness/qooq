import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet.OnDismissListener;
import cooperation.comic.VipComicReportUtils;

public class rky
  implements ActionSheet.OnDismissListener
{
  public rky(FavoriteEmoticonInfo paramFavoriteEmoticonInfo, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmoticonInfo.n)) && (AIOGallerySceneWithBusiness.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmoticonInfo.n))) {
      VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3016", "2", "40052", AIOGallerySceneWithBusiness.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmoticonInfo.n), new String[] { String.valueOf(3), "", AIOGallerySceneWithBusiness.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmoticonInfo.n) });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */