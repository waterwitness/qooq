import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class tf
  implements Runnable
{
  public tf(FontManager paramFontManager, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a();
        if (!this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_Boolean) {
          return;
        }
        Thread.sleep(1000L);
        this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(FontManager.jdField_b_of_type_JavaLangString);
        Object localObject = (FriendsManager)this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        ExtensionInfo localExtensionInfo = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        if ((!this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.g.get()) && ((localExtensionInfo == null) || (localExtensionInfo.uVipFont == 0L) || (localExtensionInfo.vipFontType == 2)))
        {
          localExtensionInfo = ((FriendsManager)localObject).a(this.jdField_a_of_type_JavaLangString);
          if (((localExtensionInfo == null) || (localExtensionInfo.uVipFont == 0L) || (localExtensionInfo.vipFontType == 2)) && (!this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.f.get()))
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.d("FontManager", 2, "asyncInit no font friendUin = " + this.jdField_a_of_type_JavaLangString);
            return;
          }
        }
        if (!this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
          return;
        }
        Thread.sleep(1000L);
        this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstance();
        if (this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null) {
          break;
        }
        int j = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
        i = j * j * 240 * 20;
        if (i > 1048576)
        {
          this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComEtrumpMixlayoutETEngine.initEngine(20, i);
          if (QLog.isColorLevel()) {
            QLog.d("FontManager", 2, "init font engine fontsize=" + j + ",num=" + 20 + ",cache=" + i);
          }
          Thread.sleep(1000L);
          localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          if ((localObject != null) && (0L != ((ExtensionInfo)localObject).uVipFont) && (((ExtensionInfo)localObject).vipFontType == 1))
          {
            localObject = (FontInfo)FontManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf((int)((ExtensionInfo)localObject).uVipFont));
            if (localObject != null) {
              this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(((FontInfo)localObject).jdField_a_of_type_JavaLangString, ((FontInfo)localObject).jdField_a_of_type_Int, true);
            }
          }
          this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          VasUtils.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FontManager", 2, "init font engine fail " + localThrowable.getMessage());
        }
        ReportController.b(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "load_font_fail", 0, 1, "-1", "", "", "");
        return;
      }
      int i = 1048576;
    }
    throw new Exception("create font engine Instance fail");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */