import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.GalleryURLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nta
  implements TroopMemberApiClient.Callback
{
  public nta(AIOGalleryAdapter paramAIOGalleryAdapter, int paramInt, AIOGalleryAdapter.GalleryURLImageView paramGalleryURLImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("ThumbnailFile_Small");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a.runOnUiThread(new ntb(this, paramBundle));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */