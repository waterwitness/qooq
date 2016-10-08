package ct;

public final class ai
  extends bi
{
  private static an g;
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public an f = null;
  
  public final void a(bg parambg)
  {
    this.a = parambg.a(this.a, 0, false);
    this.b = parambg.a(this.b, 1, false);
    this.c = parambg.a(this.c, 2, false);
    this.d = parambg.a(this.d, 3, false);
    this.e = parambg.a(this.e, 4, false);
    if (g == null) {
      g = new an();
    }
    this.f = ((an)parambg.a(g, 5, false));
  }
  
  public final void a(bh parambh)
  {
    parambh.a(this.a, 0);
    parambh.a(this.b, 1);
    parambh.a(this.c, 2);
    parambh.a(this.d, 3);
    parambh.a(this.e, 4);
    if (this.f != null) {
      parambh.a(this.f, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */