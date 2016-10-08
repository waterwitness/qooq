import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class psj
{
  public static final int a = 2;
  public static final String a = "TaskCallbackRecorder";
  public int b;
  public int c;
  public int d;
  public int e;
  
  public psj()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  private void a()
  {
    this.b = -1;
    this.c = 0;
    this.d = 0;
    this.e = 1;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TaskCallbackRecorder", 2, "onStartRecoder, taskId:" + paramInt1 + ",roleNum:" + paramInt2);
    }
    if (this.b != paramInt1)
    {
      a();
      this.b = paramInt1;
      this.e = paramInt2;
      this.c += 1;
      if (this.e != 0) {}
    }
    do
    {
      return true;
      return false;
      this.c += 1;
    } while (this.c == 2);
    return false;
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TaskCallbackRecorder", 2, "onEndRecoder, taskId:" + paramInt1 + ",roleNum:" + paramInt2);
    }
    if (this.b != paramInt1) {
      if (QLog.isColorLevel()) {
        QLog.d("TaskCallbackRecorder", 2, "onCompleteCallback, Error Logic!");
      }
    }
    do
    {
      return false;
      this.d += 1;
      if (paramInt2 == 0)
      {
        a();
        return true;
      }
    } while (this.d != 2);
    a();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */