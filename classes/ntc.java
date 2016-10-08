import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.GalleryURLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ntc
  implements TroopMemberApiClient.Callback
{
  public ntc(AIOGalleryAdapter paramAIOGalleryAdapter, int paramInt, AIOGalleryAdapter.GalleryURLImageView paramGalleryURLImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("ProgressTotal");
    long l2 = paramBundle.getLong("ProgressValue");
    String str = paramBundle.getString("LocalFile");
    int i = paramBundle.getInt("Status");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a.runOnUiThread(new ntd(this, l2, l1, i, str));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ntc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */