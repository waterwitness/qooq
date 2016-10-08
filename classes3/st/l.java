package st;

import java.util.Arrays;

final class l
{
  long a;
  long b;
  float c;
  private final float[] d = new float[3];
  private int e;
  private long f;
  
  final void a(float paramFloat, int paramInt, long paramLong)
  {
    long l = paramLong - this.f;
    if (l > this.a)
    {
      Arrays.fill(this.d, 0.0F);
      this.e = 0;
      this.f = 0L;
      this.b = 0L;
      this.c = 0.0F;
      this.d[0] = this.d[1];
      this.d[1] = this.d[2];
      this.d[2] = paramFloat;
      if (this.d[2] != 0.0F)
      {
        if (this.d[0] == 0.0F) {
          break label196;
        }
        paramFloat = (this.d[0] + this.d[1] + this.d[2]) / 3.0F;
      }
    }
    for (;;)
    {
      float f1 = w.h;
      this.c = (paramInt / (paramFloat + this.d[2] * 3.0F) * f1 + w.i * (paramInt - this.e) / (this.e + paramInt + 1));
      this.e = paramInt;
      this.f = paramLong;
      return;
      this.b = (l + this.b);
      break;
      label196:
      if (this.d[1] != 0.0F) {
        paramFloat = (this.d[1] + this.d[2]) / 2.0F;
      } else {
        paramFloat = this.d[2];
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */