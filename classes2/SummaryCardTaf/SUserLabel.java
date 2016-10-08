package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class SUserLabel
  extends JceStruct
{
  static Map cache_label;
  public Map label;
  
  public SUserLabel()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SUserLabel(Map paramMap)
  {
    this.label = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_label == null)
    {
      cache_label = new HashMap();
      SLabelInfo localSLabelInfo = new SLabelInfo();
      cache_label.put(Long.valueOf(0L), localSLabelInfo);
    }
    this.label = ((Map)paramJceInputStream.read(cache_label, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.label, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCardTaf\SUserLabel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */