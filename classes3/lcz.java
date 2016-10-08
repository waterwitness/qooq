import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class lcz
  extends FMObserver
{
  public lcz(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("silasBug", 4, "OnFileTransferProgress");
    }
    this.a.a(8, paramString, Integer.MIN_VALUE);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("silasBug", 4, "OnFileTransferEnd");
    }
    this.a.a(8, paramString1, Integer.MIN_VALUE);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lcz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */