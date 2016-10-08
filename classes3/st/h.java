package st;

import android.location.Location;

final class h
{
  static h a;
  double b;
  double c;
  float d;
  float e;
  float f;
  float g;
  float h;
  float i;
  boolean j = false;
  
  final void a(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = new float[1];
    if (paramDouble2 > 179.0D)
    {
      d1 = -1.0E-5D;
      Location.distanceBetween(paramDouble1, paramDouble2, paramDouble1, paramDouble2 + d1, arrayOfFloat);
      this.i = arrayOfFloat[0];
      if (paramDouble1 <= 89.0D) {
        break label119;
      }
    }
    label119:
    for (double d1 = -1.0E-5D;; d1 = 1.0E-5D)
    {
      Location.distanceBetween(d1 + paramDouble1, paramDouble2, paramDouble1, paramDouble2, arrayOfFloat);
      this.h = arrayOfFloat[0];
      this.b = paramDouble1;
      this.c = paramDouble2;
      this.d = paramFloat2;
      this.e = paramFloat3;
      this.g = paramFloat1;
      this.f = paramFloat4;
      this.j = true;
      return;
      d1 = 1.0E-5D;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */