package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class RespGetDiscussInteRemark
  extends JceStruct
{
  static Map cache_InteRemarks;
  public String DiscussName;
  public long DiscussUin;
  public Map InteRemarks;
  
  public RespGetDiscussInteRemark()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.DiscussName = "";
  }
  
  public RespGetDiscussInteRemark(long paramLong, Map paramMap, String paramString)
  {
    this.DiscussName = "";
    this.DiscussUin = paramLong;
    this.InteRemarks = paramMap;
    this.DiscussName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    if (cache_InteRemarks == null)
    {
      cache_InteRemarks = new HashMap();
      InteRemarkInfo localInteRemarkInfo = new InteRemarkInfo();
      cache_InteRemarks.put(Long.valueOf(0L), localInteRemarkInfo);
    }
    this.InteRemarks = ((Map)paramJceInputStream.read(cache_InteRemarks, 1, true));
    this.DiscussName = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.InteRemarks, 1);
    if (this.DiscussName != null) {
      paramJceOutputStream.write(this.DiscussName, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\RespGetDiscussInteRemark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */