import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.securitysdk.utils.ApkExternalInfoTool;
import java.io.File;
import java.io.IOException;

public class wvx
  implements Runnable
{
  public wvx(DownloadManager paramDownloadManager, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DownloadInfo localDownloadInfo;
    try
    {
      String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("PackageName");
      LogUtility.c(DownloadManager.a, "receive write code msg pkgName|" + str1);
      if (str1 == null) {
        return;
      }
      localDownloadInfo = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.b(str1);
      if (localDownloadInfo == null)
      {
        LogUtility.c(DownloadManager.a, "receive write code msg pkgName|" + str1 + " download info is null");
        return;
      }
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.a, "downloadSDKClient>>>", localException);
      return;
    }
    if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("IsSuccess"))
    {
      localDownloadInfo.p = -20;
      localDownloadInfo.jdField_k_of_type_Int = -2;
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.e(localDownloadInfo);
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(localDownloadInfo, localDownloadInfo.p, null);
    }
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("Code");
    LogUtility.c(DownloadManager.a, "receive write code msg pkgName|" + localException + " code|" + str2);
    if (TextUtils.isEmpty(str2))
    {
      localDownloadInfo.p = 0;
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.e(localDownloadInfo);
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(4, localDownloadInfo);
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(localDownloadInfo, localDownloadInfo.c);
      StaticAnalyz.a("300", localDownloadInfo.g, localDownloadInfo.b, localDownloadInfo.m);
      if (localDownloadInfo.a) {
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.c(localDownloadInfo);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidOsBundle.getInt("VersionCode");
      Object localObject = new File(localDownloadInfo.jdField_k_of_type_JavaLangString);
      try
      {
        ApkExternalInfoTool.a((File)localObject, str2);
        localObject = ApkExternalInfoTool.a((File)localObject);
        LogUtility.c(DownloadManager.a, "receive write code msg pkgName|" + localException + " check code|" + (String)localObject);
        bool = str2.equals(localObject);
        if (bool)
        {
          LogUtility.c(DownloadManager.a, "receive write code msg pkgName|" + localException + " write code and check code suc");
          localDownloadInfo.p = 0;
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.e(localDownloadInfo);
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(4, localDownloadInfo);
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(localDownloadInfo, localDownloadInfo.c);
          StaticAnalyz.a("300", localDownloadInfo.g, localDownloadInfo.b, localDownloadInfo.m);
          if (!localDownloadInfo.a) {
            return;
          }
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.c(localDownloadInfo);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          LogUtility.c(DownloadManager.a, "write code Exception|" + localIOException.getMessage());
          boolean bool = false;
        }
        LogUtility.c(DownloadManager.a, "receive write code msg pkgName|" + localException + " write code or check code fail");
        localDownloadInfo.p = -20;
        localDownloadInfo.jdField_k_of_type_Int = -2;
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.e(localDownloadInfo);
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(localDownloadInfo, localDownloadInfo.p, null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wvx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */