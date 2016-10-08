package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class operation_like_req
  extends JceStruct
{
  static Map cache_busi_param;
  public int action;
  public int appid;
  public Map busi_param;
  public String curkey;
  public long hostuin;
  public long uin;
  public String unikey;
  
  public operation_like_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.curkey = "";
    this.unikey = "";
  }
  
  public operation_like_req(long paramLong1, String paramString1, String paramString2, int paramInt1, int paramInt2, Map paramMap, long paramLong2)
  {
    this.curkey = "";
    this.unikey = "";
    this.uin = paramLong1;
    this.curkey = paramString1;
    this.unikey = paramString2;
    this.action = paramInt1;
    this.appid = paramInt2;
    this.busi_param = paramMap;
    this.hostuin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.curkey = paramJceInputStream.readString(1, false);
    this.unikey = paramJceInputStream.readString(2, false);
    this.action = paramJceInputStream.read(this.action, 3, false);
    this.appid = paramJceInputStream.read(this.appid, 4, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 5, false));
    this.hostuin = paramJceInputStream.read(this.hostuin, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.curkey != null) {
      paramJceOutputStream.write(this.curkey, 1);
    }
    if (this.unikey != null) {
      paramJceOutputStream.write(this.unikey, 2);
    }
    paramJceOutputStream.write(this.action, 3);
    paramJceOutputStream.write(this.appid, 4);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 5);
    }
    paramJceOutputStream.write(this.hostuin, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\operation_like_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */