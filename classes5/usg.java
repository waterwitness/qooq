import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.ttpic.util.Coffee;
import com.tencent.ttpic.util.DecryptListener;

public final class usg
  implements DecryptListener
{
  public usg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public byte[] decrypt(byte[] paramArrayOfByte)
  {
    return Coffee.a(paramArrayOfByte);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\usg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */