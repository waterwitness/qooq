package com.weiyun.sdk.data;

public class WyCategoryInfo
{
  public static final String ID_DOCUMENT = "document";
  public static final String ID_MUSIC = "music";
  public static final String ID_OTHER = "other";
  public static final String ID_PICTURE = "picture";
  public static final String ID_RECENT = "recent";
  public static final String ID_VIDEO = "video";
  public final String categoryId;
  public final String name;
  public final long timestamp;
  public final int totalNum;
  
  public WyCategoryInfo(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    this.categoryId = paramString1;
    this.name = paramString2;
    this.totalNum = paramInt;
    this.timestamp = paramLong;
  }
  
  public String toString()
  {
    return "WyCategoryInfo [categoryId=" + this.categoryId + ", name=" + this.name + ", totalNum=" + this.totalNum + ", timestamp=" + this.timestamp + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\data\WyCategoryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */