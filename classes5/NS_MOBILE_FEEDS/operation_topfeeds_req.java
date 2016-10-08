package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class operation_topfeeds_req
  extends JceStruct
{
  public int feedstype;
  public int operationtype;
  public String strkey;
  public long uin;
  
  public operation_topfeeds_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strkey = "";
  }
  
  public operation_topfeeds_req(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    this.strkey = "";
    this.uin = paramLong;
    this.operationtype = paramInt1;
    this.feedstype = paramInt2;
    this.strkey = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.operationtype = paramJceInputStream.read(this.operationtype, 1, true);
    this.feedstype = paramJceInputStream.read(this.feedstype, 2, true);
    this.strkey = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.operationtype, 1);
    paramJceOutputStream.write(this.feedstype, 2);
    paramJceOutputStream.write(this.strkey, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\operation_topfeeds_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */