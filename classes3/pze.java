import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.IndividualRedPacketManager.FontBitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import mqq.app.MobileQQ;

public class pze
  implements Runnable
{
  public pze(IndividualRedPacketManager paramIndividualRedPacketManager, String paramString1, String paramString2, Bundle paramBundle, MessengerService paramMessengerService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = null;
    int i = IndividualRedPacketManager.s;
    Object localObject4 = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().a.get(this.jdField_a_of_type_JavaLangString);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(this.jdField_a_of_type_JavaLangString, this.b, 6);
    String str = "";
    int j;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject1 = str;
      j = i;
    }
    for (;;)
    {
      try
      {
        localObject4 = new File((String)localObject3);
        localObject1 = str;
        j = i;
        localObject3 = new FileInputStream((File)localObject4);
        localObject1 = str;
        j = i;
        localObject4 = new byte[(int)((File)localObject4).length()];
        int k = 0;
        localObject1 = str;
        j = i;
        if (k < localObject4.length)
        {
          localObject1 = str;
          j = i;
          int m = ((FileInputStream)localObject3).read((byte[])localObject4, k, localObject4.length - k);
          if (m >= 0)
          {
            k += m;
            continue;
          }
        }
        localObject1 = str;
        j = i;
        str = Base64Util.encodeToString((byte[])localObject4, 2);
        localObject1 = str;
        j = i;
        i = IndividualRedPacketManager.r;
        localObject1 = str;
        j = i;
        ((FileInputStream)localObject3).close();
        localObject1 = str;
        str = null;
        localObject3 = null;
      }
      catch (IOException localIOException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(IndividualRedPacketManager.b(), 2, "getBitmapForWebView error:" + localIOException.getMessage());
        localObject2 = null;
        i = j;
        localObject3 = null;
        continue;
      }
      if (localObject3 != null)
      {
        localObject1 = new ByteArrayOutputStream();
        ((Bitmap)localObject3).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject1);
        localObject1 = Base64Util.encodeToString(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
        i = IndividualRedPacketManager.r;
      }
      localObject4 = new Bundle();
      ((Bundle)localObject4).putString("templateId", this.jdField_a_of_type_JavaLangString);
      ((Bundle)localObject4).putString("content", this.b);
      ((Bundle)localObject4).putInt("result", i);
      ((Bundle)localObject4).putString("bitmap", (String)localObject1);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject4);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      if (QLog.isColorLevel()) {
        QLog.d(IndividualRedPacketManager.b(), 2, "getBitmapForWebView result = " + i + " base64 length = " + ((String)localObject1).length());
      }
      if ((str != null) && (str.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!str.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(str.jdField_a_of_type_AndroidGraphicsBitmap, "", this.b, 5);
      }
      if ((str != null) && (str.jdField_a_of_type_AndroidGraphicsBitmap != null) && (localObject3 != null))
      {
        if (!str.b) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a((Bitmap)localObject3, this.jdField_a_of_type_JavaLangString, this.b, 12);
      }
      return;
      if (localObject4 != null)
      {
        if (new File(IndividualRedPacketManager.a(this.jdField_a_of_type_JavaLangString, "", 2, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject4).d, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject4).jdField_a_of_type_Int)).exists())
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(this.b, 6);
          localObject1 = IndividualRedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager, (IndividualRedPacketManager.FontBitmap)localObject2, this.jdField_a_of_type_JavaLangString, this.b, 6);
        }
        for (;;)
        {
          localObject4 = "";
          localObject3 = localObject1;
          localObject1 = localObject4;
          break;
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().a(((IndividualRedPacketResDownloader.RedPacketTemplateInfo)this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().a.get(this.jdField_a_of_type_JavaLangString)).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo, null);
          localObject2 = null;
        }
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().getLong("RedPacketUpdateJson", 0L) > 3600000L)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a.getApplication().getApplicationContext();
        localObject2 = new File(((Context)localObject1).getFilesDir(), ClubContentJsonTask.k.b);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("version", ClubContentJsonTask.a((Context)localObject1, ClubContentJsonTask.k.e));
        ((Bundle)localObject3).putString("version_key", ClubContentJsonTask.k.e);
        ((Bundle)localObject3).putString("method", "redPacketUpdateNow");
        ((Bundle)localObject3).putString("ifromet", "redPacket");
        ((Bundle)localObject3).putBoolean("forceUpdate", true);
        ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a, ClubContentJsonTask.k, null, (File)localObject2, (Bundle)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().edit().putLong("RedPacketUpdateJson", l).commit();
      }
      localObject1 = "";
      Object localObject2 = null;
      localObject3 = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a((Bitmap)localObject3, this.jdField_a_of_type_JavaLangString, this.b, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */