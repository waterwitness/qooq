package com.tencent.biz.qqstory.takevideo.music;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ptvfilter.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.io.File;

public class QQStoryBGMusicUtils
{
  public static final int a = 5;
  public static final String a = "action_music_start";
  protected static final int b = 1000;
  protected static final String b = "https://y.qq.com/m/qzonemusic/mqzsearch.html?_wv=3&_bid=203&entry=buluo&uin=%s";
  protected static final int c = 60000;
  protected static final int d = 3600000;
  protected static final int e = 86400000;
  public static final int f = 1000;
  
  public QQStoryBGMusicUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static final String a(int paramInt)
  {
    if (paramInt >= 86400000) {
      return "unknow";
    }
    int i = (int)Math.floor(paramInt / 3600000);
    int j = (int)Math.floor(paramInt % 3600000) / 60000;
    paramInt = (int)Math.floor(paramInt % 60000 / 1000);
    if (i > 0) {
      return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt) });
    }
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
  }
  
  public static final String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("MusicComposeDialog.createMusicFilePath() musicUrl is null!!!!");
    }
    File localFile = new File(QQStoryConstant.r);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
    paramString = QQStoryConstant.r + MD5.a(paramString) + "." + FileUtils.c(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "createMusicFilePath destPath = " + paramString);
    }
    return paramString;
  }
  
  protected static void a(BaseActivity paramBaseActivity)
  {
    Intent localIntent = new Intent(paramBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://y.qq.com/m/qzonemusic/mqzsearch.html?_wv=3&_bid=203&entry=buluo&uin=%s", new Object[] { QQStoryContext.a().a() }));
    localIntent.putExtra("finish_animation_up_down", true);
    paramBaseActivity.startActivityForResult(localIntent, 1000);
    paramBaseActivity.overridePendingTransition(2130968585, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\music\QQStoryBGMusicUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */