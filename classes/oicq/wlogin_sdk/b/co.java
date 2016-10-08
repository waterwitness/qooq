package oicq.wlogin_sdk.b;

import java.nio.ByteBuffer;

public class co
  extends a
{
  public static boolean h = true;
  public static int i = 1000;
  public static byte[] j = new byte[0];
  
  public co()
  {
    this.g = 1288;
  }
  
  public Boolean e()
  {
    for (;;)
    {
      try
      {
        localObject1 = ByteBuffer.wrap(this.f);
        ((ByteBuffer)localObject1).position(this.d);
        if (((ByteBuffer)localObject1).get() != 1) {
          continue;
        }
        bool = true;
        h = bool;
        i = ((ByteBuffer)localObject1).getInt();
        j = new byte[((ByteBuffer)localObject1).getShort()];
        ((ByteBuffer)localObject1).get(j);
        if (i == 0) {
          i = 1000;
        }
        if (j == null) {
          j = new byte[0];
        }
        localObject1 = Boolean.valueOf(true);
      }
      catch (Exception localException)
      {
        Object localObject1;
        boolean bool;
        Boolean localBoolean = Boolean.valueOf(false);
        if (i != 0) {
          continue;
        }
        i = 1000;
        Object localObject2 = localBoolean;
        if (j != null) {
          continue;
        }
        j = new byte[0];
        return localBoolean;
      }
      finally
      {
        if (i != 0) {
          continue;
        }
        i = 1000;
        if (j != null) {
          continue;
        }
        j = new byte[0];
      }
      return (Boolean)localObject1;
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\b\co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */