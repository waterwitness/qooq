package com.tencent.mobileqq.earlydownload.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.AppleEmojiData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.AppleEmojiManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AppleEmojiHandler
  extends EarlyHandler
{
  public static final String a = "AppleMojiHandler";
  public static final String b = "qq.android.appleemoji";
  
  public AppleEmojiHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.appleemoji", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Class a()
  {
    return AppleEmojiData.class;
  }
  
  public String a()
  {
    return "AppleMojiHandler";
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("AppleMojiHandler", 2, "doOnDownloadSuccess:" + paramString);
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppleMojiHandler", 2, "doOnDownloadSuccess sorse not exists");
    }
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putString("apple_emoji_file", AppConstants.bj + "early/" + paramString.getName()).commit();
    AppleEmojiManager.a(paramString);
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\AppleEmojiHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */