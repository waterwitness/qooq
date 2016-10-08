package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cell_text
  extends JceStruct
{
  public String data;
  public int type;
  
  public cell_text()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.data = "";
  }
  
  public cell_text(String paramString, int paramInt)
  {
    this.data = "";
    this.data = paramString;
    this.type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.data = paramJceInputStream.readString(0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.data != null) {
      paramJceOutputStream.write(this.data, 0);
    }
    paramJceOutputStream.write(this.type, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_text.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */