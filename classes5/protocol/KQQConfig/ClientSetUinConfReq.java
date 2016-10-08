package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ClientSetUinConfReq
  extends JceStruct
{
  static Map cache_uinConf;
  public Map uinConf;
  
  public ClientSetUinConfReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ClientSetUinConfReq(Map paramMap)
  {
    this.uinConf = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_uinConf == null)
    {
      cache_uinConf = new HashMap();
      ArrayList localArrayList = new ArrayList();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      localArrayList.add(arrayOfByte);
      cache_uinConf.put("", localArrayList);
    }
    this.uinConf = ((Map)paramJceInputStream.read(cache_uinConf, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uinConf, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\protocol\KQQConfig\ClientSetUinConfReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */