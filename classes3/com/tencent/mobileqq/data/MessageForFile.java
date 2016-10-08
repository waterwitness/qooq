package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageForFile
  extends ChatMessage
{
  private static final String TAG = MessageForFile.class.getSimpleName();
  public String fileName;
  public String filePath;
  public long fileSize;
  public String fileSizeString;
  public String fileType;
  public int status;
  public String[] tempMsg;
  public String url;
  public String urlAtServer;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void doParse()
  {
    if ((this.msg != null) && (this.msg.length() > 0) && (this.msg.charAt(0) == '\026'))
    {
      this.tempMsg = this.msg.split("\\|");
      return;
    }
    this.tempMsg = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */