package com.weiyun.sdk.data;

public class WyOfflineFileInfo
{
  public static final int OFFLINE_FILE_TYPE_ALL = 2;
  public static final int OFFLINE_FILE_TYPE_RECEIVE = 0;
  public static final int OFFLINE_FILE_TYPE_SEND = 1;
  public boolean bSend;
  public int dangerLevel;
  public String fileName;
  public long fileSize;
  public String guid;
  public long lifeTime;
  public long uin;
  public long uploadTime;
  
  public String toString()
  {
    return "WyOfflineFileInfo [bSend=" + this.bSend + ", guid=" + this.guid + ", uin=" + this.uin + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", lifeTime=" + this.lifeTime + ", uploadTime=" + this.uploadTime + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\data\WyOfflineFileInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */