import com.tencent.mobileqq.filemanager.settings.FMSettingInterface.MoveFileCallback;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class shx
  implements Runnable
{
  public shx(FMSettings paramFMSettings, String paramString, File paramFile, int paramInt, FMSettingInterface.MoveFileCallback paramMoveFileCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, localFile, this.jdField_a_of_type_JavaIoFile, new shy(this));
    localFile.delete();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */