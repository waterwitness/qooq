import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.view.VipPhotoViewForSimple;

public class txl
  implements Runnable
{
  public txl(VipPhotoViewForSimple paramVipPhotoViewForSimple, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (QZoneCover)this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.a.a().createEntityManager().a(QZoneCover.class, this.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      localObject = VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple, ((QZoneCover)localObject).type, ((QZoneCover)localObject).parseCoverInfo(), ((QZoneCover)localObject).parsePhotoInfo());
      Message localMessage = Message.obtain();
      localMessage.what = 200;
      localMessage.obj = localObject;
      VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple).sendMessage(localMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\txl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */