import com.tencent.mobileqq.filemanager.settings.FMSettingInterface.MoveFileCallback;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class shy
  implements FMSettingInterface.MoveFileCallback
{
  shy(shx paramshx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    synchronized (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings)
    {
      FMSettings localFMSettings2 = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings;
      localFMSettings2.jdField_a_of_type_Int += 1;
      FMSettings.a(1, "onMovedOver,count[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.jdField_a_of_type_Int + "],total[" + this.a.jdField_a_of_type_Int + "]");
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        FMSettings.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettingInterface$MoveFileCallback.a();
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings)
    {
      FMSettings localFMSettings2 = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings;
      localFMSettings2.jdField_a_of_type_Int += 1;
      FMSettings.a(1, "onMoveFail,count[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.jdField_a_of_type_Int + "],total[" + this.a.jdField_a_of_type_Int + "]");
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        FMSettings.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettingInterface$MoveFileCallback.a(16);
      }
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    FMSettings localFMSettings = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings;
    localFMSettings.jdField_a_of_type_Long += paramLong1;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettingInterface$MoveFileCallback.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.b);
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */