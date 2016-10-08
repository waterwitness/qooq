import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;

class vsl
  implements Runnable
{
  vsl(vsk paramvsk, Setting paramSetting)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataSetting == null) || (this.jdField_a_of_type_ComTencentMobileqqDataSetting.bHeadType == 0))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataSetting == null) && (!this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_g_of_type_Boolean))
      {
        this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_g_of_type_Boolean = true;
        if (!this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
          this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_g_of_type_JavaLangString, 4, true);
        }
      }
      if (this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
      try
      {
        this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130839408);
        this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.b(this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_AndroidGraphicsBitmap, 6.0F, this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.i, this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.i);
        if (this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_AndroidGraphicsBitmap);
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(AvatarWallAdapter.jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(localOutOfMemoryError));
          }
        }
        this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130839408);
        return;
      }
    }
    try
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(NearbyImgDownloader.a(this.jdField_a_of_type_Vsk.jdField_a_of_type_JavaLangString));
      localURLDrawable.setTag(URLDrawableDecodeHandler.a(this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.i, this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.i, 6));
      localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.b);
      this.jdField_a_of_type_Vsk.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
      return;
    }
    catch (MalformedURLException localMalformedURLException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */