package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class AIOSendRes
  extends JceStruct
{
  static Map cache_mHighLightMap;
  public int iPopGrayStip;
  public Map mHighLightMap;
  public String sGrayStipMsg = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_mHighLightMap = new HashMap();
    cache_mHighLightMap.put("", "");
  }
  
  public AIOSendRes() {}
  
  public AIOSendRes(int paramInt, String paramString, Map paramMap)
  {
    this.iPopGrayStip = paramInt;
    this.sGrayStipMsg = paramString;
    this.mHighLightMap = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iPopGrayStip = paramJceInputStream.read(this.iPopGrayStip, 0, true);
    this.sGrayStipMsg = paramJceInputStream.readString(1, true);
    this.mHighLightMap = ((Map)paramJceInputStream.read(cache_mHighLightMap, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iPopGrayStip, 0);
    paramJceOutputStream.write(this.sGrayStipMsg, 1);
    paramJceOutputStream.write(this.mHighLightMap, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\VIP\AIOSendRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */