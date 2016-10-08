package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class SUserLable
  extends JceStruct
{
  static Map cache_lable;
  public Map lable;
  
  public SUserLable()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SUserLable(Map paramMap)
  {
    this.lable = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_lable == null)
    {
      cache_lable = new HashMap();
      SLableInfo localSLableInfo = new SLableInfo();
      cache_lable.put(Long.valueOf(0L), localSLableInfo);
    }
    this.lable = ((Map)paramJceInputStream.read(cache_lable, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lable, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCardTaf\SUserLable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */