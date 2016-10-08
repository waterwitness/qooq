package com.tencent.mobileqq.data;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class MessageForQQStory
  extends MessageForStructing
{
  public static final String KEY_AUTHOR_NAME = "authorName";
  public static final String KEY_BRIEF_BG_COLOR = "briefBgColor";
  public static final String KEY_COVER_IMG_URL = "coverImgUrl";
  public static final String KEY_LOGO_IMG_URL = "logoImgUrl";
  public static final String TAG = MessageForQQStory.class.getSimpleName();
  public String authorName;
  public String brief;
  public int briefBgColor;
  public String coverImgUrl;
  public String logoImgUrl;
  public String msgAction;
  public String srcAction;
  public String srcName;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String buildCompatibleText(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2 + "[来自" + paramString3 + "，请使用新版手机QQ查看]";
    }
    return paramString1 + "-" + paramString2 + "[来自" + paramString3 + "，请使用新版手机QQ查看]";
  }
  
  public void doParse()
  {
    super.doParse();
    localStructMsgForGeneralShare = (StructMsgForGeneralShare)this.structingMsg;
    this.brief = localStructMsgForGeneralShare.mMsgBrief;
    this.srcName = localStructMsgForGeneralShare.mSourceName;
    this.srcAction = localStructMsgForGeneralShare.mSourceAction;
    this.msgAction = localStructMsgForGeneralShare.mMsgAction;
    try
    {
      JSONObject localJSONObject = new JSONObject(localStructMsgForGeneralShare.mQQStoryExtra);
      this.coverImgUrl = localJSONObject.optString("coverImgUrl");
      this.logoImgUrl = localJSONObject.optString("logoImgUrl");
      this.briefBgColor = localJSONObject.optInt("briefBgColor");
      if (this.briefBgColor == 0) {
        this.briefBgColor = Color.parseColor("#000000");
      }
      this.briefBgColor &= 0xFFFFFF;
      this.briefBgColor |= 0xD8000000;
      this.authorName = localJSONObject.optString("authorName");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "doParse exp:" + localStructMsgForGeneralShare.mQQStoryExtra + ", " + localException.toString());
        }
      }
    }
    this.msg = getSummaryMsg();
  }
  
  public String getSummaryMsg()
  {
    return "[" + this.srcName + "]" + this.brief;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public String toString()
  {
    Object localObject2 = "";
    try
    {
      localObject1 = String.format("#%x", new Object[] { Integer.valueOf(this.briefBgColor) });
      localObject2 = new StringBuilder("MessageForQQStory{");
      ((StringBuilder)localObject2).append("coverImgUrl='").append(this.coverImgUrl).append('\'');
      ((StringBuilder)localObject2).append(", logoImgUrl='").append(this.logoImgUrl).append('\'');
      ((StringBuilder)localObject2).append(", brief='").append(this.brief).append('\'');
      ((StringBuilder)localObject2).append(", briefBgColor=").append((String)localObject1);
      ((StringBuilder)localObject2).append(", srcName='").append(this.srcName).append('\'');
      ((StringBuilder)localObject2).append(", srcAction='").append(this.srcAction).append('\'');
      ((StringBuilder)localObject2).append(", msgAction='").append(this.msgAction).append('\'');
      ((StringBuilder)localObject2).append(", authorName='").append(this.authorName).append('\'');
      ((StringBuilder)localObject2).append('}');
      return ((StringBuilder)localObject2).toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("Q.qqstory.share", 2, "toString exp:", localException);
          localObject1 = localObject2;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForQQStory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */