package QzoneCombine;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class SingleMsg
  extends JceStruct
{
  static Map cache_data;
  public long addTime;
  public Map data;
  public long opUin;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_data = new HashMap();
    cache_data.put("", "");
  }
  
  public SingleMsg() {}
  
  public SingleMsg(long paramLong1, Map paramMap, long paramLong2)
  {
    this.addTime = paramLong1;
    this.data = paramMap;
    this.opUin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.addTime = paramJceInputStream.read(this.addTime, 0, false);
    this.data = ((Map)paramJceInputStream.read(cache_data, 1, false));
    this.opUin = paramJceInputStream.read(this.opUin, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.addTime, 0);
    if (this.data != null) {
      paramJceOutputStream.write(this.data, 1);
    }
    paramJceOutputStream.write(this.opUin, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QzoneCombine\SingleMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */