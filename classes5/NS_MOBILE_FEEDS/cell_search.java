package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cell_search
  extends JceStruct
{
  public String tip;
  
  public cell_search()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.tip = "";
  }
  
  public cell_search(String paramString)
  {
    this.tip = "";
    this.tip = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.tip = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.tip != null) {
      paramJceOutputStream.write(this.tip, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_search.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */