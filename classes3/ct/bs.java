package ct;

import java.util.ArrayList;

public class bs
{
  private static bs g = null;
  ArrayList<Float> a = new ArrayList();
  float b = 0.0F;
  float c = 0.0F;
  float d = 100.0F;
  boolean e = false;
  boolean f = false;
  
  public static bs a()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new bs();
      }
      return g;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */