package com.tencent.tmdatasourcesdk;

import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppSimpleDetail;
import java.util.ArrayList;

public abstract interface ITMAssistantExchangeURLListenner
{
  public abstract void onExchangedURLSucceed(ArrayList<AppSimpleDetail> paramArrayList, boolean paramBoolean);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdatasourcesdk\ITMAssistantExchangeURLListenner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */