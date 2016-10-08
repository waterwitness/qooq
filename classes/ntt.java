import android.app.Activity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;

public final class ntt
  implements URLDrawable.URLDrawableListener
{
  public int a;
  public long a;
  public URLDrawable a;
  
  public ntt(AIOGalleryScene paramAIOGalleryScene)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "rawPhotoBtn decode onLoadCanceled URL():" + paramURLDrawable.getURL());
    }
    this.a.a(false);
    this.a.jdField_a_of_type_Ntt = null;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "rawPhotoBtn decode onLoadFialed URL():" + paramURLDrawable.getURL());
    }
    QQToast.a(AIOGalleryScene.a(this.a), AIOGalleryScene.b(this.a).getString(2131370320), 0).a();
    this.a.c(true);
    this.a.a(false);
    this.a.jdField_a_of_type_Ntt = null;
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "rawPhotoBtn decode onLoadSuccessed URL():" + paramURLDrawable.getURL());
    }
    this.a.c(false);
    this.a.a(false);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b.b = paramURLDrawable.getExifOrientation();
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramURLDrawable, AIOGalleryScene.a(this.a).r());
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.notifyDataSetChanged();
    AIOGalleryScene.b(this.a).e();
    this.a.jdField_a_of_type_Ntt = null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ntt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */