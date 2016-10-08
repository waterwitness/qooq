import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Writer;

public class pqz
  extends Writer
{
  private StringBuilder a;
  
  pqz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new StringBuilder();
  }
  
  private void a()
  {
    if (this.a.length() > 0)
    {
      Log.v("GLTextureView", this.a.toString());
      this.a.delete(0, this.a.length());
    }
  }
  
  public void close()
  {
    a();
  }
  
  public void flush()
  {
    a();
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        a();
      }
      for (;;)
      {
        i += 1;
        break;
        this.a.append(c);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */