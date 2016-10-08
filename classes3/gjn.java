import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.ttpic.util.Coffee;
import com.tencent.ttpic.util.DecryptListener;

public final class gjn
  implements DecryptListener
{
  public gjn()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public byte[] decrypt(byte[] paramArrayOfByte)
  {
    return Coffee.a(paramArrayOfByte);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gjn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */