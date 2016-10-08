import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DynamicFaceDrawable;

public class qsj
  implements Runnable
{
  public qsj(DynamicAvatarManager paramDynamicAvatarManager, DynamicFaceDrawable paramDynamicFaceDrawable, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DynamicAvatar localDynamicAvatar = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.k, this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.b);
    if (localDynamicAvatar != null)
    {
      localDynamicAvatar.playTimeStamp = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a(localDynamicAvatar);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qsj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */