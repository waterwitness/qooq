import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.qphone.base.util.QLog;

public class qtb
  implements VideoDrawable.OnPlayRepeatListener
{
  public qtb(DynamicAvatarView paramDynamicAvatarView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "onPlayRepeat: " + paramInt);
    }
    if ((this.a.b) || (paramInt < 1)) {}
    while (this.a.a == null) {
      return;
    }
    Object localObject = this.a.a.jdField_a_of_type_ComTencentImageURLDrawable;
    if ((localObject instanceof URLDrawable))
    {
      localObject = ((URLDrawable)localObject).getCurrDrawable();
      if ((localObject instanceof VideoDrawable))
      {
        ((VideoDrawable)localObject).removeOnPlayRepeatListener(this);
        this.a.a.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a(this.a.a, true);
        if (QLog.isColorLevel()) {
          QLog.e("Q.dynamicAvatar", 2, "removeOnPlayRepeatListener.03");
        }
      }
    }
    this.a.a.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qtb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */