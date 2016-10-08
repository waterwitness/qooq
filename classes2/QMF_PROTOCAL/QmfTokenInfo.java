package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class QmfTokenInfo
  extends JceStruct
{
  static byte[] cache_Key;
  static Map cache_ext_key;
  public byte[] Key;
  public int Type;
  public Map ext_key;
  
  public QmfTokenInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QmfTokenInfo(int paramInt, byte[] paramArrayOfByte, Map paramMap)
  {
    this.Type = paramInt;
    this.Key = paramArrayOfByte;
    this.ext_key = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Type = paramJceInputStream.read(this.Type, 0, true);
    if (cache_Key == null)
    {
      cache_Key = (byte[])new byte[1];
      ((byte[])cache_Key)[0] = 0;
    }
    this.Key = ((byte[])paramJceInputStream.read(cache_Key, 1, true));
    if (cache_ext_key == null)
    {
      cache_ext_key = new HashMap();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_ext_key.put(Integer.valueOf(0), arrayOfByte);
    }
    this.ext_key = ((Map)paramJceInputStream.read(cache_ext_key, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Type, 0);
    paramJceOutputStream.write(this.Key, 1);
    if (this.ext_key != null) {
      paramJceOutputStream.write(this.ext_key, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QMF_PROTOCAL\QmfTokenInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */