import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.DownloadManager;

public final class wve
  implements Runnable
{
  public wve(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DownloadManager.a().b(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */