package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class clear_count_req
  extends JceStruct
{
  public String LastUndealCountTime;
  public int clearType;
  
  public clear_count_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.LastUndealCountTime = "";
  }
  
  public clear_count_req(int paramInt, String paramString)
  {
    this.LastUndealCountTime = "";
    this.clearType = paramInt;
    this.LastUndealCountTime = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.clearType = paramJceInputStream.read(this.clearType, 0, false);
    this.LastUndealCountTime = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.clearType, 0);
    if (this.LastUndealCountTime != null) {
      paramJceOutputStream.write(this.LastUndealCountTime, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\clear_count_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */