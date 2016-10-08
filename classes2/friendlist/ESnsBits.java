package friendlist;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class ESnsBits
  implements Serializable
{
  public static final int _E_FAVORITE_BIT = 1;
  public static final int _E_OPEN_BIT = 2;
  public static final int _E_SHARE_LOCATOIN_BIT = 4;
  
  public ESnsBits()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\ESnsBits.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */