package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class mobile_get_config_rsp
  extends JceStruct
{
  static Map cache_config;
  public Map config;
  public String cookies;
  public int scene_flag;
  
  public mobile_get_config_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cookies = "";
  }
  
  public mobile_get_config_rsp(Map paramMap, String paramString, int paramInt)
  {
    this.cookies = "";
    this.config = paramMap;
    this.cookies = paramString;
    this.scene_flag = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_config == null)
    {
      cache_config = new HashMap();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_config.put("", arrayOfByte);
    }
    this.config = ((Map)paramJceInputStream.read(cache_config, 0, false));
    this.cookies = paramJceInputStream.readString(1, false);
    this.scene_flag = paramJceInputStream.read(this.scene_flag, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.config != null) {
      paramJceOutputStream.write(this.config, 0);
    }
    if (this.cookies != null) {
      paramJceOutputStream.write(this.cookies, 1);
    }
    paramJceOutputStream.write(this.scene_flag, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QMF_PROTOCAL\mobile_get_config_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */