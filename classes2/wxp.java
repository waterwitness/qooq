import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.YybHandleUtil;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import java.io.File;

public final class wxp
  implements Runnable
{
  public wxp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = DownloadDBHelper.a().a("com.tencent.android.qqdownloader");
    String str = "";
    if (localObject != null) {
      str = ((DownloadInfo)localObject).k;
    }
    if (!TextUtils.isEmpty(str))
    {
      localObject = new File(str);
      LogUtility.c(YybHandleUtil.a, "---localFilePath = " + str);
      if ((localObject != null) && (((File)localObject).exists()))
      {
        LogUtility.c(YybHandleUtil.a, "---delete apk ");
        ((File)localObject).delete();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wxp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */