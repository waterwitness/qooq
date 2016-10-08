package com.tencent.map.swlocation.api;

import java.io.IOException;
import java.net.UnknownHostException;
import st.p;

public abstract interface INetworkApi
  extends p
{
  @Deprecated
  public abstract byte[] httpRequest(String paramString, byte[] paramArrayOfByte)
    throws UnknownHostException, IOException;
  
  public abstract byte[] httpRequest(byte[] paramArrayOfByte)
    throws UnknownHostException, IOException;
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\map\swlocation\api\INetworkApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */