package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetCallerSettingResponse
  extends JceStruct
{
  public long beginTime = 0L;
  public long endTime = 0L;
  public int isSwitch = 0;
  public int ret = 0;
  
  public GetCallerSettingResponse() {}
  
  public GetCallerSettingResponse(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.ret = paramInt1;
    this.isSwitch = paramInt2;
    this.beginTime = paramLong1;
    this.endTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.isSwitch = paramJceInputStream.read(this.isSwitch, 1, false);
    this.beginTime = paramJceInputStream.read(this.beginTime, 2, false);
    this.endTime = paramJceInputStream.read(this.endTime, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.isSwitch, 1);
    paramJceOutputStream.write(this.beginTime, 2);
    paramJceOutputStream.write(this.endTime, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistant\common\jce\GetCallerSettingResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */