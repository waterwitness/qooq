import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.LSRecordPanel;

public class txx
  implements Runnable
{
  public txx(LSRecordPanel paramLSRecordPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LSRecordPanel.a(this.a, "亲们，QQ没有使用麦克风权限呢");
    LSRecordPanel.b(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\txx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */