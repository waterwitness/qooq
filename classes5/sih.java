import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class sih
{
  public long a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  
  private sih(FMSettings paramFMSettings)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    FMSettings.a(2, "bDefaultPath[" + this.jdField_a_of_type_Boolean + "],name[" + this.jdField_a_of_type_JavaLangString + "],rootPath[" + this.b + "],ext[" + this.c + "],freeSpace[" + this.jdField_a_of_type_Long + "]");
  }
  
  public void a(Context paramContext)
  {
    paramContext.getSharedPreferences("FMSETTING_59", 0).edit().putString("DefaultRootPath", this.b).commit();
    paramContext = FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, this.b + this.c);
    Object localObject = FMSettings.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, this.b + this.c);
    String str = FMSettings.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, this.b + this.c);
    FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, paramContext);
    FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, str);
    FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, (String)localObject);
    paramContext = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a.keySet().iterator();
    while (paramContext.hasNext())
    {
      localObject = (String)paramContext.next();
      localObject = (sih)this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a.get(localObject);
      if ((((sih)localObject).jdField_a_of_type_Boolean) && (localObject != this))
      {
        FMSettings.a(2, "getDefaultStorage[" + ((sih)localObject).b + "]");
        ((sih)localObject).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */