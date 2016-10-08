package photo_share_struct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class share_attr
  extends JceStruct
{
  static Map cache_shares_attr;
  public long owner;
  public Map shares_attr;
  public String source = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_shares_attr = new HashMap();
    uin_attr localuin_attr = new uin_attr();
    cache_shares_attr.put(Long.valueOf(0L), localuin_attr);
  }
  
  public share_attr() {}
  
  public share_attr(Map paramMap, String paramString, long paramLong)
  {
    this.shares_attr = paramMap;
    this.source = paramString;
    this.owner = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shares_attr = ((Map)paramJceInputStream.read(cache_shares_attr, 0, false));
    this.source = paramJceInputStream.readString(1, false);
    this.owner = paramJceInputStream.read(this.owner, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.shares_attr != null) {
      paramJceOutputStream.write(this.shares_attr, 0);
    }
    if (this.source != null) {
      paramJceOutputStream.write(this.source, 1);
    }
    paramJceOutputStream.write(this.owner, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\photo_share_struct\share_attr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */