package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class ReqSetDiscussAttr
  extends JceStruct
{
  static Map cache_Attr;
  public Map Attr;
  public long DiscussUin;
  
  public ReqSetDiscussAttr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqSetDiscussAttr(long paramLong, Map paramMap)
  {
    this.DiscussUin = paramLong;
    this.Attr = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    if (cache_Attr == null)
    {
      cache_Attr = new HashMap();
      MemberAttrInfo localMemberAttrInfo = new MemberAttrInfo();
      cache_Attr.put(Integer.valueOf(0), localMemberAttrInfo);
    }
    this.Attr = ((Map)paramJceInputStream.read(cache_Attr, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.Attr, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\ReqSetDiscussAttr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */