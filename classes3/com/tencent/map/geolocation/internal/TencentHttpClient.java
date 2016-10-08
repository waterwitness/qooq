package com.tencent.map.geolocation.internal;

import android.util.Pair;
import java.io.IOException;

public abstract interface TencentHttpClient
{
  public abstract Pair<byte[], String> postSync(String paramString, byte[] paramArrayOfByte)
    throws IOException;
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\map\geolocation\internal\TencentHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */