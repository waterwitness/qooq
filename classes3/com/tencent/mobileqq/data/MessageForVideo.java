package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public class MessageForVideo
  extends ChatMessage
{
  private static final String TAG = "MessageForVideo";
  public boolean isVideo;
  public String text;
  public int type;
  
  public MessageForVideo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doParse()
  {
    String[] arrayOfString;
    if (this.msg != null)
    {
      arrayOfString = this.msg.split("\\|");
      if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
        break label90;
      }
      this.text = arrayOfString[0].trim();
      if ((arrayOfString == null) || (arrayOfString.length <= 1)) {
        break label227;
      }
    }
    for (;;)
    {
      try
      {
        this.type = Integer.parseInt(arrayOfString[1]);
        if ((arrayOfString == null) || (arrayOfString.length <= 3)) {
          break label248;
        }
        if (arrayOfString.length != 4) {
          break label235;
        }
        this.isVideo = "1".equals(arrayOfString[3]);
        return;
        arrayOfString = null;
        break;
        label90:
        this.text = "";
      }
      catch (Exception localException)
      {
        if ((this.msg != null) && (this.msg.length() > 0) && (this.msg.charAt(0) == '\026')) {
          throw new RuntimeException("java.lang.NumberFormatException: Invalid int: " + arrayOfString[1] + " msg is " + this.msg);
        }
        this.type = 5;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MessageForVideo", 2, "java.lang.NumberFormatException: Invalid int: " + arrayOfString[1] + " msg byte " + Utils.a(this.msg));
        continue;
      }
      label227:
      this.type = 5;
    }
    label235:
    this.isVideo = arrayOfString[0].contains("视频");
    return;
    label248:
    this.isVideo = true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */