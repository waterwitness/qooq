package qqwifi.MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ContentResponse
  extends JceStruct
{
  public String resource;
  public int ret;
  
  public ContentResponse()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.resource = "";
  }
  
  public ContentResponse(int paramInt, String paramString)
  {
    this.resource = "";
    this.ret = paramInt;
    this.resource = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.resource = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.resource, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qqwifi\MQQ\ContentResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */