import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class nsw
  implements Runnable
{
  nsw(nst paramnst, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    AIOImageListModel localAIOImageListModel;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localAIOImageListModel = (AIOImageListModel)nss.a(this.jdField_a_of_type_Nst.a);
      if (!localAIOImageListModel.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int)) {
        break label92;
      }
      if (nss.e(this.jdField_a_of_type_Nst.a) != null) {
        ((AIOGalleryScene)nss.f(this.jdField_a_of_type_Nst.a)).u();
      }
    }
    for (;;)
    {
      if (nss.e(this.jdField_a_of_type_Nst.a) != null) {
        nss.f(this.jdField_a_of_type_Nst.a).g();
      }
      return;
      label92:
      if ((nss.c(this.jdField_a_of_type_Nst.a) != null) && (this.jdField_a_of_type_Nst.a.a() == nss.d(this.jdField_a_of_type_Nst.a)))
      {
        localAIOImageListModel.a();
        if (nss.g(this.jdField_a_of_type_Nst.a) != null) {
          ((AIOGalleryScene)nss.h(this.jdField_a_of_type_Nst.a)).u();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nsw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */