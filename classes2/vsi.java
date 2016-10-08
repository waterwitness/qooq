import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;

class vsi
  implements Runnable
{
  vsi(vsh paramvsh, TroopUploadingThread.UploadState paramUploadState)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    AvatarWallAdapter.o = 0;
    this.jdField_a_of_type_Vsh.a.p = 0;
    int i = this.jdField_a_of_type_Vsh.a.b - this.jdField_a_of_type_Vsh.a.j;
    if (i >= 8) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.a != 1) {
            break;
          }
          this.jdField_a_of_type_Vsh.a.a(i, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.c);
        } while (this.jdField_a_of_type_Vsh.a.a(this.jdField_a_of_type_Vsh.a.g));
        this.jdField_a_of_type_Vsh.a.d = false;
        this.jdField_a_of_type_Vsh.a.c();
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.a != 2);
      str = this.jdField_a_of_type_Vsh.a.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.b);
    } while (str == null);
    this.jdField_a_of_type_Vsh.a.a(str, i);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */