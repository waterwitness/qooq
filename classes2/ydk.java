import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ydk
  implements Runnable
{
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public ydk(PhotoPlusManager paramPhotoPlusManager, List paramList, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      PhotoPlusManager.a(this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager, this.jdField_a_of_type_JavaUtilList);
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[updateStickerResource] saved stickers = null");
      }
      return;
    }
    int i = 0;
    label43:
    Sticker localSticker;
    String str;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localSticker = (Sticker)this.jdField_a_of_type_JavaUtilList.get(i);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[updateStickerResource] saved sticker:" + localSticker);
      }
      str = PhotoPlusManager.b + localSticker.getZipFilePath();
      if (new File(str).exists()) {
        break label166;
      }
      PhotoPlusManager.a(this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager, localSticker.url, str, localSticker.md5);
    }
    for (;;)
    {
      i += 1;
      break label43;
      break;
      label166:
      Object localObject2 = localSticker.getUnzippedDir();
      Object localObject1 = PhotoPlusManager.b + (String)localObject2 + localSticker.getImageFileName();
      localObject2 = PhotoPlusManager.b + (String)localObject2 + localSticker.getThumbImageFileName();
      localObject1 = new File((String)localObject1);
      localObject2 = new File((String)localObject2);
      if ((!((File)localObject1).exists()) || (!((File)localObject2).exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoPlusManager", 2, "[updateStickerResource] zip exist but resource not exist:" + localSticker.getZipFilePath());
        }
        if (TextUtils.isEmpty(localSticker.md5))
        {
          this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager.a(str);
        }
        else
        {
          localObject1 = PortalUtils.a(str);
          if (localSticker.md5.equalsIgnoreCase((String)localObject1))
          {
            this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager.a(str);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("PhotoPlusManager", 2, "[updateStickerResource] checkMd5 failed: " + str);
            }
            FileUtils.d(str);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ydk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */