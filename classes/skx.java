import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

public class skx
  implements Runnable
{
  public skx(ForwardBaseOption paramForwardBaseOption, String paramString, QQCustomDialog paramQQCustomDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1;
    label51:
    Object localObject2;
    Object localObject4;
    int i;
    if (!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(this.jdField_a_of_type_JavaLangString);
      if (localObject1 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
        return;
      }
      localObject1 = ForwardOptionUtils.a((Bitmap)localObject1, this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_Float);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a((Drawable)localObject1, this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_Boolean);
      localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_AndroidOsBundle.get("PhotoConst.PHOTO_PATHS");
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption;
      if (localObject2 != null)
      {
        i = ((ArrayList)localObject2).size();
        label97:
        ((ForwardBaseOption)localObject4).a((Drawable)localObject1, true, i);
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.f != null) && (AbsDownloader.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.f)))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.f;
      if (localObject1 == null) {
        break label330;
      }
      if (Build.VERSION.SDK_INT < 10) {
        break label356;
      }
      if (!((String)localObject1).toLowerCase(Locale.US).startsWith("file:")) {
        break label319;
      }
    }
    for (;;)
    {
      try
      {
        if (!((String)localObject1).substring(0, "file:".length()).equalsIgnoreCase("file:")) {
          break label361;
        }
        localObject2 = new File(((String)localObject1).substring("file:".length()));
        if ((localObject2 == null) || (!((File)localObject2).exists())) {
          break label356;
        }
        localObject4 = ((File)localObject2).getAbsolutePath();
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_AndroidOsBundle.putString("EditImagePath", (String)localObject4);
        localObject2 = RegionalThumbDownloader.a((String)localObject4, ForwardBaseOption.jdField_a_of_type_Int, ForwardBaseOption.jdField_a_of_type_Int);
        if (localObject2 == null) {
          break label351;
        }
        localObject2 = ((URL)localObject2).toString();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localObject4;
        }
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.e("ForwardOption.ForwardBaseOption", 2, "updateImageView  fixedUrlString=" + (String)localObject1);
          localObject2 = localObject1;
        }
        localObject1 = URLDrawable.getDrawable((String)localObject2);
        break label51;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.e;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        localObject3 = null;
        continue;
      }
      label319:
      Object localObject3 = AbsDownloader.a(AbsDownloader.b((String)localObject1));
      continue;
      label330:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ForwardOption.ForwardBaseOption", 2, "isURLDrawablFoward is true, but mBigURLDrawableUrl and URLDrawableUrl are null");
      return;
      i = 0;
      break label97;
      label351:
      localObject3 = localObject1;
      continue;
      label356:
      localObject3 = localObject1;
      continue;
      label361:
      localObject3 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\skx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */