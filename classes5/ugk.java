import android.os.Environment;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.ShortVideoConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;

public class ugk
  implements Runnable
{
  public ugk(DCShortVideo paramDCShortVideo, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean1, int paramInt3, String paramString4, boolean paramBoolean2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ugu localugu = new ugu();
    Object localObject3 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject3).exists()) {}
    for (;;)
    {
      return;
      localugu.jdField_a_of_type_Long = ((File)localObject3).length();
      if (localugu.jdField_a_of_type_Long <= 0L) {
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCShortVideo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, localugu);
      localugu.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localugu.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      try
      {
        Object localObject2 = this.jdField_a_of_type_JavaLangString;
        String str = Environment.getExternalStorageDirectory().toString();
        Object localObject1 = localObject2;
        if (str != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_JavaLangString.contains(str)) {
            localObject1 = this.jdField_a_of_type_JavaLangString.replace(str, "");
          }
        }
        int i = ((String)localObject1).lastIndexOf("/");
        localObject2 = localObject1;
        if (i != -1) {
          localObject2 = ((String)localObject1).substring(0, i);
        }
        localugu.jdField_a_of_type_JavaLangString = ((String)localObject2).replace("/", "//");
        localObject2 = FileUtil.b(this.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = ((String)localObject2).toLowerCase(Locale.US);
        }
        localObject2 = null;
        try
        {
          localObject3 = ((File)localObject3).getParentFile().getName().toLowerCase(Locale.US);
          localObject2 = localObject3;
        }
        catch (Exception localException2)
        {
          label916:
          for (;;) {}
        }
        if ((localObject1 == null) || (localObject2 == null)) {
          continue;
        }
        if (((String)localObject1).contains("/tencent/")) {
          if (((String)localObject1).contains("/mobileqq/shortvideo/"))
          {
            localugu.j = 1002;
            localugu.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
            if (this.jdField_a_of_type_Boolean)
            {
              if (this.jdField_c_of_type_Int != 0) {
                break label916;
              }
              localugu.jdField_a_of_type_Int = 0;
            }
          }
        }
        for (;;)
        {
          localugu.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
          localugu.k = ((int)((System.currentTimeMillis() - new File(this.jdField_a_of_type_JavaLangString).lastModified()) / 60000L));
          if (localugu.k == 0) {
            localugu.k = 1;
          }
          localugu.m = VideoEnvironment.f;
          localugu.l = (VideoEnvironment.a.jdField_a_of_type_Int + 2000);
          if (QLog.isDevelopLevel()) {
            QLog.d(DCShortVideo.jdField_a_of_type_JavaLangString, 4, "[reportSend]url=" + localugu.jdField_a_of_type_JavaLangString + ",shortVideoType=" + localugu.f + ",shortVideoSourceType = " + localugu.j + ",uinType = " + localugu.jdField_b_of_type_Int + ",groupMemCount = " + localugu.jdField_c_of_type_Int + ",isForward = " + localugu.jdField_a_of_type_Boolean + ",isExsit = " + localugu.jdField_b_of_type_Boolean + ",age = " + localugu.d + ",gender = " + localugu.e + ",userType = " + localugu.l + ",reprotHour = " + localugu.g + ",fileInterval = " + localugu.k + ",netType = " + localugu.h + ",forwardSourceGroupMemCount = " + localugu.i + ",forwardSourceUinType = " + localugu.jdField_a_of_type_Int + ",duration = " + localugu.jdField_b_of_type_Long + ",fileSize = " + localugu.jdField_a_of_type_Long + ",md5 = " + localugu.jdField_b_of_type_JavaLangString + ", status=" + localugu.m);
          }
          localObject1 = new ugy("ShortVideo.Send", localugu.a("ShortVideo.Send"));
          DataReport.a().a((ugy)localObject1);
          return;
          if (((String)localObject1).contains("/qq_collection/"))
          {
            localugu.j = 1001;
            break;
          }
          if (((String)localObject1).contains("/qqfile_recv/"))
          {
            localugu.j = 1003;
            break;
          }
          if ((((String)localObject1).contains("/weixin/")) || (((String)localObject1).contains("/wechat/")) || (((String)localObject1).contains("/micromsg/")))
          {
            localugu.j = 1004;
            break;
          }
          if (StatisticConstants.a((String)localObject1))
          {
            localugu.j = 1005;
            break;
          }
          localugu.j = 1006;
          break;
          if (((String)localObject1).equalsIgnoreCase(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath() + File.separator))
          {
            localugu.j = 1002;
            break;
          }
          if ((((String)localObject2).contains("camera")) || (((String)localObject2).equals("dcim")) || (((String)localObject2).equals("100MEDIA")) || (((String)localObject2).equals("100ANDRO")) || (((String)localObject2).contains("相机")) || (((String)localObject2).contains("照片")) || (((String)localObject2).contains("相片")))
          {
            localugu.j = 1007;
            break;
          }
          if (StatisticConstants.a((String)localObject1))
          {
            localugu.j = 1005;
            break;
          }
          localugu.j = 1006;
          break;
          if (this.jdField_c_of_type_Int == 3000)
          {
            localugu.jdField_a_of_type_Int = 3000;
          }
          else
          {
            if (this.jdField_c_of_type_Int == 1)
            {
              switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.d))
              {
              default: 
                localugu.jdField_a_of_type_Int = 1;
              }
              for (;;)
              {
                localugu.i = 0;
                localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                if (localObject1 == null) {
                  break;
                }
                localObject1 = ((TroopManager)localObject1).b(this.d);
                if (localObject1 == null) {
                  break;
                }
                localugu.i = ((TroopInfo)localObject1).wMemberNum;
                break;
                localugu.jdField_a_of_type_Int = 1;
                continue;
                localugu.jdField_a_of_type_Int = 3;
                continue;
                localugu.jdField_a_of_type_Int = 4;
                continue;
                localugu.jdField_a_of_type_Int = 2;
              }
            }
            localugu.jdField_a_of_type_Int = 9999;
          }
        }
        return;
      }
      catch (Exception localException1) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */