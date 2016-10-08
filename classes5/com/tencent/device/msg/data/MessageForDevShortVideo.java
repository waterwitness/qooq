package com.tencent.device.msg.data;

import android.os.Parcelable.Creator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import kaz;

public class MessageForDevShortVideo
  extends MessageForShortVideo
{
  public static final Parcelable.Creator CREATOR = new kaz();
  public long fileSessionId;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getSummary()
  {
    Object localObject = BaseApplicationImpl.a().a();
    if ((localObject instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localObject;
    }
    switch (this.videoFileStatus)
    {
    default: 
      return null;
    case 2003: 
      return "[视频]";
    case 1003: 
      return ((QQAppInterface)localObject).a().getString(2131369801);
    case 1005: 
      return ((QQAppInterface)localObject).a().getString(2131369801);
    }
    return "[视频]";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\msg\data\MessageForDevShortVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */