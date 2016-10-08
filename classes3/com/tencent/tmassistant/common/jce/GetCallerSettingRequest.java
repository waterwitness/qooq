package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetCallerSettingRequest
  extends JceStruct
{
  public String reserve = "";
  
  public GetCallerSettingRequest() {}
  
  public GetCallerSettingRequest(String paramString)
  {
    this.reserve = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reserve = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.reserve != null) {
      paramJceOutputStream.write(this.reserve, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistant\common\jce\GetCallerSettingRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */