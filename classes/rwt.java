import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rwt
  extends FMObserver
{
  public rwt(FileManagerRSCenter paramFileManagerRSCenter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerRSCenter<FileAssistant>", 2, "recive TransferEnd, rmove task[" + String.valueOf(paramLong2) + "]!");
    }
    this.a.a(paramLong2);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rwt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */