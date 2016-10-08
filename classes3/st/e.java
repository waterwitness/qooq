package st;

import android.os.Handler;

abstract class e
{
  final Handler a;
  long b;
  private a c;
  
  e(Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (;;)
    {
      this.a = paramHandler;
      return;
      paramHandler = new Handler();
    }
  }
  
  abstract void a();
  
  final void a(long paramLong1, long paramLong2)
  {
    b();
    this.b = paramLong1;
    this.c = new a((byte)0);
    a.a(this.c, paramLong2);
  }
  
  final void b()
  {
    if (this.c != null) {
      a.a(this.c);
    }
  }
  
  final class a
    implements Runnable
  {
    private boolean a;
    private boolean b;
    
    private a() {}
    
    public final void run()
    {
      if (this.b) {
        return;
      }
      e.this.a();
      e.this.a.postDelayed(this, e.this.b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */