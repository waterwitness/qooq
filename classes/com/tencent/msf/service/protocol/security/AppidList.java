package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AppidList
  extends JceStruct
{
  static ArrayList cache_AppidVector;
  public ArrayList AppidVector;
  public long nReserved;
  
  public AppidList() {}
  
  public AppidList(long paramLong, ArrayList paramArrayList)
  {
    this.nReserved = paramLong;
    this.AppidVector = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nReserved = paramJceInputStream.read(this.nReserved, 0, true);
    if (cache_AppidVector == null)
    {
      cache_AppidVector = new ArrayList();
      cache_AppidVector.add(Long.valueOf(0L));
    }
    this.AppidVector = ((ArrayList)paramJceInputStream.read(cache_AppidVector, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nReserved, 0);
    paramJceOutputStream.write(this.AppidVector, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\msf\service\protocol\security\AppidList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */