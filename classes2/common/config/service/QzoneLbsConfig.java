package common.config.service;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QzoneLbsConfig
{
  private static volatile QzoneLbsConfig jdField_a_of_type_CommonConfigServiceQzoneLbsConfig;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static QzoneLbsConfig a()
  {
    if (jdField_a_of_type_CommonConfigServiceQzoneLbsConfig == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CommonConfigServiceQzoneLbsConfig == null) {
        jdField_a_of_type_CommonConfigServiceQzoneLbsConfig = new QzoneLbsConfig();
      }
      return jdField_a_of_type_CommonConfigServiceQzoneLbsConfig;
    }
  }
  
  public int a()
  {
    return QzoneConfig.a().a("QZoneSetting", "POICacheDistance", 1000);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\common\config\service\QzoneLbsConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */