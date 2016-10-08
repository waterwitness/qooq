import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class twm
  implements Runnable
{
  public twm(ProfileHeaderView paramProfileHeaderView, int paramInt, ProfileActivity.AllInOne paramAllInOne, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Bitmap localBitmap = null;
    Object localObject2 = null;
    int i = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getResources().getDimensionPixelSize(2131493004);
    Object localObject1;
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localObject1 = localObject2;
        if (ProfileCardUtil.a()) {
          localObject2 = localBitmap;
        }
      }
      try
      {
        localObject1 = ProfileCardUtil.b();
        localObject2 = localBitmap;
        Object localObject3 = new File((String)localObject1);
        localObject2 = localBitmap;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localObject2 = localBitmap;
        localObject3 = new FileInputStream((File)localObject3);
        localObject2 = localBitmap;
        localOptions.inSampleSize = ((int)ImageUtil.a((InputStream)localObject3, i, i));
        localObject2 = localBitmap;
        ((InputStream)localObject3).close();
        localObject2 = localBitmap;
        localBitmap = BitmapManager.a((String)localObject1, localOptions);
        localObject1 = localBitmap;
        if (localBitmap != null)
        {
          localObject2 = localBitmap;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.profilecard.FrdProfileCard", 2, localException.toString());
            localObject1 = localObject2;
          }
        }
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.b(this.jdField_a_of_type_JavaLangString, 16);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a(this.jdField_a_of_type_JavaLangString, true);
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new twn(this, (Bitmap)localObject1));
      }
      return;
      if (1 == this.jdField_a_of_type_Int) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11, this.jdField_a_of_type_JavaLangString, (byte)3, true, 0);
      } else if (2 == this.jdField_a_of_type_Int) {
        localObject1 = ImageUtil.b();
      } else {
        localObject1 = ImageUtil.a();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */