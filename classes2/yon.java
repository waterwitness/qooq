import android.os.Binder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.OnQZonePluginInstallListner;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZoneRemotePluginManager.Stub;

public class yon
  extends QZoneRemotePluginManager.Stub
{
  private static yon jdField_a_of_type_Yon;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IQZonePluginManager jdField_a_of_type_CooperationQzonePluginIQZonePluginManager;
  
  private yon()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static yon a()
  {
    if (jdField_a_of_type_Yon == null) {}
    try
    {
      if (jdField_a_of_type_Yon == null) {
        jdField_a_of_type_Yon = new yon();
      }
      return jdField_a_of_type_Yon;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager = ((IQZonePluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174));
  }
  
  public Binder a()
  {
    return this;
  }
  
  public PluginRecord a(String paramString)
  {
    a();
    return this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a(paramString);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public boolean a()
  {
    a();
    return this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a();
  }
  
  public boolean a(String paramString)
  {
    a();
    return this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a();
  }
  
  public boolean a(String paramString, OnQZonePluginInstallListner paramOnQZonePluginInstallListner)
  {
    a();
    return this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a(paramString, paramOnQZonePluginInstallListner);
  }
  
  public boolean b(String paramString)
  {
    a();
    return this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.b(paramString);
  }
  
  public boolean c(String paramString)
  {
    a();
    return this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.c(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */