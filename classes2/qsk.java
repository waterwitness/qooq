import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class qsk
  implements Runnable
{
  public qsk(DynamicAvatarManager paramDynamicAvatarManager, DynamicFaceDrawable paramDynamicFaceDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a.remove(this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.b)) {
        return;
      }
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.b.size() - 1;
      if (i >= 0)
      {
        WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.b.remove(i);
        if (localWeakReference != null)
        {
          Object localObject3 = localWeakReference.get();
          if (localObject3 != null) {
            break label107;
          }
        }
        label107:
        while (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a.contains(localObject1))
        {
          i -= 1;
          break;
          localObject1 = finally;
          throw ((Throwable)localObject1);
        }
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a((DynamicFaceDrawable)((WeakReference)localObject1).get());
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, "onPlayFinished to play. result : " + bool);
        }
        if (bool) {
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a.add(localObject1);
        }
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qsk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */