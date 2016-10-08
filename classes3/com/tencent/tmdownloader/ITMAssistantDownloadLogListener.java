package com.tencent.tmdownloader;

import com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo;
import java.util.ArrayList;

public abstract interface ITMAssistantDownloadLogListener
{
  public abstract void onLog(ArrayList<TMAssistantDownloadLogInfo> paramArrayList);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\ITMAssistantDownloadLogListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */