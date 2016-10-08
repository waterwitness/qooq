import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nud
  implements DialogInterface.OnClickListener
{
  public nud(AIOImageListScene paramAIOImageListScene, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label47;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) });
    }
    for (;;)
    {
      AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene, null);
      return;
      label47:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a(new Integer[] { Integer.valueOf(0), Integer.valueOf(2) });
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */