import android.app.Activity;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import mqq.util.WeakReference;

public class vsk
  implements Runnable
{
  public vsk(AvatarWallAdapter paramAvatarWallAdapter, URLImageView paramURLImageView, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject;
    Setting localSetting;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        localSetting = (Setting)((EntityManager)localObject).a(Setting.class, "troop_" + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.g);
        ((EntityManager)localObject).a();
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_MqqUtilWeakReference == null);
      localObject = (Activity)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_MqqUtilWeakReference.get();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    ((Activity)localObject).runOnUiThread(new vsl(this, localSetting));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */