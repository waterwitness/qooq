import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;

class wwd
  implements Runnable
{
  wwd(wwb paramwwb, long paramLong1, long paramLong2, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = (int)((float)this.jdField_a_of_type_Long * 100.0F / (float)this.b);
    DownloadInfo localDownloadInfo = this.jdField_a_of_type_Wwb.a.c(this.jdField_a_of_type_JavaLangString, i);
    if (localDownloadInfo == null) {
      LogUtility.d(DownloadManager.jdField_a_of_type_JavaLangString, "OnDownloadSDKTaskProgressChanged info == null");
    }
    for (;;)
    {
      this.jdField_a_of_type_Wwb.a.a(2, localDownloadInfo);
      return;
      LogUtility.a(DownloadManager.jdField_a_of_type_JavaLangString, "OnDownloadSDKTaskProgressChanged info state=" + localDownloadInfo.a() + " progress=" + localDownloadInfo.l);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wwd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */