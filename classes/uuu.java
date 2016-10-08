import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class uuu
  extends uut
{
  static final long d = 2000L;
  static final long e = 60000L;
  static final long f = 10000L;
  public long c;
  public boolean d;
  public int j;
  public int k;
  public int l;
  public int m;
  
  public uuu(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramInt4, paramInt5, paramInt6);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = false;
    this.j = 80;
    this.k = 70;
    this.l = 5;
    this.c = 0L;
    this.l = (paramInt1 % 1000);
    this.k = (paramInt1 / 1000 % 1000);
    this.j = (paramInt1 / 1000 / 1000 % 1000);
  }
  
  void a(int[] paramArrayOfInt)
  {
    boolean bool = true;
    this.j = paramArrayOfInt[0];
    this.k = paramArrayOfInt[1];
    this.l = paramArrayOfInt[2];
    if (paramArrayOfInt[3] == 1) {}
    for (;;)
    {
      this.d = bool;
      return;
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uuu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */