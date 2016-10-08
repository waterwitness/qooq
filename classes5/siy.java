import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

public final class siy
  implements Runnable
{
  public siy(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (FileUtil.a(this.a.getFilePath())) {}
    PackageInfo localPackageInfo;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((this.a.strApkPackageName == null) || (this.a.strApkPackageName.length() == 0)) {}
        localIterator = FileCategoryUtil.a(BaseApplicationImpl.getContext()).iterator();
      } while (!localIterator.hasNext());
      localPackageInfo = (PackageInfo)localIterator.next();
    } while (!this.a.strApkPackageName.equalsIgnoreCase(localPackageInfo.packageName));
    this.a.setFilePath(localPackageInfo.applicationInfo.publicSourceDir);
    this.a.fileName = FileCategoryUtil.a(this.a.getFilePath());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\siy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */