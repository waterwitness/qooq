package ct;

import android.os.Bundle;

public abstract class bp
{
  private String a;
  private String b;
  private boolean c;
  
  public bp(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = true;
  }
  
  public void a() {}
  
  protected abstract boolean a(Bundle paramBundle);
  
  public final boolean b(Bundle paramBundle)
  {
    if (!this.c) {
      return false;
    }
    return a(paramBundle);
  }
  
  public String toString()
  {
    return "[name=" + this.a + ",desc=" + this.b + ",enabled=" + this.c + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */