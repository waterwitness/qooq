import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ukc
{
  long a;
  long b;
  public int g;
  int h;
  
  public ukc(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = paramInt;
    this.a = SystemClock.elapsedRealtime();
  }
  
  public void a(int paramInt)
  {
    this.b = (SystemClock.elapsedRealtime() - this.a);
    this.h = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(60);
    localStringBuilder.append("[ReportStep, id=").append(this.g).append(", cost=").append(this.b).append(", failCode=").append(this.h).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ukc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */