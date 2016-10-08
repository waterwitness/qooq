import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.font.FontManager;
import java.io.File;

public class ymc
  implements Runnable
{
  public ymc(FontManager paramFontManager, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("FontManager", 4, "begin to download font file from network, url =" + this.jdField_a_of_type_JavaLangString);
    }
    if (HttpDownloadUtil.a(null, this.jdField_a_of_type_JavaLangString, new File(FontManager.a(this.jdField_a_of_type_CooperationQzoneFontFontManager, this.jdField_a_of_type_Int)))) {
      FontManager.a(this.jdField_a_of_type_CooperationQzoneFontFontManager, this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      FontManager.a(this.jdField_a_of_type_CooperationQzoneFontFontManager, this.jdField_a_of_type_Int);
      return;
      QLog.e("FontManager", 1, "Font Download Failed, font url = " + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ymc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */