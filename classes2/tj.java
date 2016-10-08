import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class tj
  implements Runnable
{
  public tj(FontManager paramFontManager, FontInfo paramFontInfo, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (!this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(this.jdField_a_of_type_ComEtrumpMixlayoutFontInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComEtrumpMixlayoutFontInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean))
      {
        if (!new File(this.jdField_a_of_type_ComEtrumpMixlayoutFontInfo.jdField_a_of_type_JavaLangString).exists())
        {
          this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontInfo.jdField_a_of_type_Int, null, true, false);
          if (QLog.isColorLevel()) {
            QLog.d("FontManager", 2, "load font fail file not exist font id=" + this.jdField_a_of_type_ComEtrumpMixlayoutFontInfo.jdField_a_of_type_Int);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(false, this.jdField_a_of_type_Boolean);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("FontManager", 2, "load font fail font id=" + this.jdField_a_of_type_ComEtrumpMixlayoutFontInfo.jdField_a_of_type_Int);
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("FontManager", 2, "load font fail" + localThrowable.getMessage());
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("FontManager", 2, "setActiveFonts refreshAIO");
          }
          VasUtils.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */