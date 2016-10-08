package com.tencent.mobileqq.musicgene;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.util.LyricParseHelper;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import tgl;
import tgp;
import tgq;
import tgr;
import tgs;
import tgu;
import tgv;

public class MusicPlayerActivity
  extends BaseActivity
{
  private static final int jdField_a_of_type_Int = 49;
  public static final String a = "KEY_SOURCE_NAME";
  private static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final int jdField_b_of_type_Int = 50;
  private static final String jdField_b_of_type_JavaLangString = "0X8006826";
  private static final HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private static final int jdField_c_of_type_Int = 51;
  private static final String jdField_c_of_type_JavaLangString = "0X8006827";
  private static final HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private static final int jdField_d_of_type_Int = 52;
  private static final String jdField_d_of_type_JavaLangString = "0X8006828";
  private static final HashMap jdField_d_of_type_JavaUtilHashMap = new HashMap();
  private static final int jdField_e_of_type_Int = 53;
  private static final String jdField_e_of_type_JavaLangString = "0X8006829";
  private static final int jdField_f_of_type_Int = 54;
  private static final String jdField_f_of_type_JavaLangString = "0X800682A";
  private static final int jdField_g_of_type_Int = 55;
  private static final String jdField_g_of_type_JavaLangString = "0X800682B";
  private static final String h = "0X800682C";
  private static final String i = "0X800682D";
  private static final String j = "http://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435";
  private static final String k = "androidqqmusic://form=webpage&mid=23&k1=0&k2=%s&download=1&action=download";
  private static final String l = "KEY_COLOR_LIST";
  private static final String m = "KEY_SONG_NAME";
  private static final String n = "KEY_SINGER_NAME";
  private static final String o = "KEY_IS_FAVOURITE";
  private static final String p = "KEY_IMG_URL";
  private static final String q = "KEY_MATCH_SONG";
  private static final String r = "MusicPlayerActivity";
  private final ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new tgp(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new tgl(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Lyric jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
  private LyricViewController jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController;
  public LyricViewDetail a;
  private final IQQPlayerCallback.Stub jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub = new tgq(this);
  private IQQPlayerService jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
  private final MusicPlayerActivity.MusicPlayerObserver jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$MusicPlayerObserver = new MusicPlayerActivity.MusicPlayerObserver(this);
  private MusicPlayerHandler jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerHandler;
  private final tgs jdField_a_of_type_Tgs = new tgs(this);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Lyric jdField_b_of_type_ComTencentMobileqqLyricDataLyric;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static Point a(Activity paramActivity)
  {
    Point localPoint = new Point();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      if (Build.VERSION.SDK_INT >= 13) {
        paramActivity.getSize(localPoint);
      }
    }
    else
    {
      return localPoint;
    }
    localPoint.x = paramActivity.getWidth();
    localPoint.y = paramActivity.getHeight();
    return localPoint;
  }
  
  private String a(IQQPlayerService paramIQQPlayerService, SongInfo paramSongInfo, long paramLong)
  {
    String str2 = "";
    String str1 = str2;
    if (paramSongInfo != null)
    {
      if (paramLong == paramSongInfo.jdField_a_of_type_Long) {
        paramSongInfo.jdField_a_of_type_Int = 4;
      }
      str1 = str2;
      switch (paramSongInfo.jdField_a_of_type_Int)
      {
      default: 
        str1 = str2;
      }
    }
    for (;;)
    {
      paramSongInfo = str1;
      if (TextUtils.isEmpty(str1))
      {
        paramSongInfo = str1;
        if (paramIQQPlayerService != null) {
          paramSongInfo = null;
        }
      }
      try
      {
        paramIQQPlayerService = paramIQQPlayerService.a();
        paramSongInfo = str1;
        if (paramIQQPlayerService != null) {
          paramSongInfo = paramIQQPlayerService.getString("KEY_SOURCE_NAME");
        }
        return paramSongInfo;
        str1 = getString(2131369304);
        continue;
        str1 = getString(2131372592);
      }
      catch (RemoteException paramIQQPlayerService)
      {
        for (;;)
        {
          paramIQQPlayerService = paramSongInfo;
        }
      }
    }
  }
  
  private String a(SongInfo paramSongInfo)
  {
    String str = "";
    if (paramSongInfo != null) {
      str = paramSongInfo.b + "_____" + String.valueOf(paramSongInfo.jdField_a_of_type_Long);
    }
    return str;
  }
  
  private void a()
  {
    IQQPlayerService localIQQPlayerService = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
    if (localIQQPlayerService == null)
    {
      QLog.e("MusicPlayerActivity", 1, new Object[] { "updateLyricPosition() exception", "mService is null!" });
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = localIQQPlayerService.a();
        if (localObject1 == null) {
          break label374;
        }
        localObject1 = a((SongInfo)localObject1);
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1)) {
          break label374;
        }
        l1 = ((Long)jdField_a_of_type_JavaUtilHashMap.get(localObject1)).longValue();
        if (!jdField_b_of_type_JavaUtilHashMap.containsKey(localObject1)) {
          break label368;
        }
        localObject1 = (String)jdField_b_of_type_JavaUtilHashMap.get(localObject1);
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.getTag();
        if (!(localObject2 instanceof Long)) {
          break label360;
        }
        l2 = ((Long)localObject2).longValue();
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(4);
          this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("MusicPlayerActivity", 1, localException, new Object[0]);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().b() == null) || (l2 != l1))
      {
        a(localException, this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setTag(Long.valueOf(l1));
      }
      int i1 = localIQQPlayerService.a();
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(0);
      long l2 = localIQQPlayerService.g();
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      int i2 = (int)l1;
      if (localIQQPlayerService.a())
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a();
        if (!bool) {
          this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a();
        }
        QLog.i("MusicPlayerActivity", 1, "LyricTest updateLyricPosition() try to seek! playPosition:" + l1 + " seekPosition:" + i2 + " isPlaying:" + bool);
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b(i2);
        return;
      }
      if (3 == i1)
      {
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b(i2);
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.c();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
      return;
      label360:
      l2 = -1L;
      continue;
      label368:
      String str = "";
      continue;
      label374:
      l1 = 0L;
      str = "";
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt1);
    if (localDrawable != null) {
      localDrawable.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
    }
  }
  
  private void a(String paramString, LyricViewDetail paramLyricViewDetail)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric = LyricParseHelper.a(paramString, true);
      if (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric == null) {
        this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = LyricParseHelper.a(paramString, false);
      }
    } while ((this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric == null) && (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric == null));
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
    paramLyricViewDetail.a().setHighlightCurrentLine(true);
    paramLyricViewDetail.a().setHighlightLineNumber(2);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a(paramLyricViewDetail);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a(this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric, this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric, null);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("desc", paramString2);
    localBundle.putString("detail_url", paramString3);
    localBundle.putString("from", "qq");
    localBundle.putString("audio_url", paramString5);
    localBundle.putInt("req_type", 2);
    paramString1 = new ArrayList(1);
    paramString1.add(paramString4);
    localBundle.putStringArrayList("image_url", paramString1);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("strurt_msgid", "0");
    localBundle.putString("struct_url", this.app.f());
    localBundle.putBoolean("from_web", true);
    QZoneShareManager.a(this.app, this, localBundle, null, 0);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Tgs, 52);
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_SONG_NAME", paramString1);
    localBundle.putString("KEY_SINGER_NAME", paramString2);
    localBundle.putString("KEY_IMG_URL", paramString3);
    localBundle.putString("KEY_SOURCE_NAME", paramString4);
    localBundle.putBoolean("KEY_IS_FAVOURITE", paramBoolean1);
    localBundle.putBoolean("KEY_MATCH_SONG", paramBoolean2);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  private void a(tgv paramtgv, String paramString)
  {
    tgu localtgu = new tgu(paramtgv.jdField_a_of_type_JavaLangString, paramtgv.b, paramtgv.e, paramtgv.d, paramtgv.c, "http://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
    Message localMessage = Message.obtain(this.jdField_a_of_type_Tgs, 51);
    localMessage.arg1 = 1;
    localMessage.obj = localtgu;
    localMessage.sendToTarget();
    Message.obtain(this.jdField_a_of_type_Tgs, 53).sendToTarget();
    a(paramtgv.jdField_a_of_type_JavaLangString, paramtgv.b, paramtgv.e, paramString, paramtgv.jdField_a_of_type_Boolean, true);
  }
  
  private void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, ForwardRecentActivity.class);
    localIntent.putExtra("key_flag_from_plugin", true);
    String str = paramString1;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString1.length() > 45) {
        str = paramString1.substring(0, 45) + "…";
      }
    }
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 60) {
        paramString1 = paramString2.substring(0, 60) + "…";
      }
    }
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("title", str);
    localIntent.putExtra("desc", paramString1);
    localIntent.putExtra("detail_url", paramString3);
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("req_share_id", 1101244924L);
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("image_url_remote", paramString4);
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131364569, new Object[] { str }));
    localIntent.putExtra("audio_url", paramString5);
    localIntent.putExtra("req_type", 2);
    localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getProcessName());
    if (this.app != null)
    {
      localIntent.putExtra("struct_share_key_source_name", getString(2131367251));
      Share.a(this.app, this, this.app.getAccount(), 1101244924L, 3000L, new tgr(this, localIntent));
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    boolean bool = super.doOnCreate(paramBundle);
    setContentView(2130903413);
    bindService(new Intent(this, QQPlayerService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 33);
    paramBundle = findViewById(2131298486);
    View localView = findViewById(2131298485);
    int i1 = a(this).x;
    paramBundle.getLayoutParams().height = i1;
    localView.getLayoutParams().height = i1;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298491));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298496));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298494));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298493));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298495));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerHandler = ((MusicPlayerHandler)this.app.a(92));
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail = ((LyricViewDetail)findViewById(2131298492));
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController = new LyricViewController(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
    findViewById(2131298488).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298489));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$MusicPlayerObserver);
    ReportController.b(this.app, "CliOper", "", "", "0X8006826", "0X8006826", 0, 0, "", "", "", "");
    return bool;
  }
  
  protected void doOnDestroy()
  {
    IQQPlayerService localIQQPlayerService = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
    if (localIQQPlayerService != null) {}
    try
    {
      localIQQPlayerService.b(this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub);
      unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$MusicPlayerObserver);
      super.doOnDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  protected void onDestroy()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
      }
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MusicPlayerActivity", 1, localException, new Object[0]);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\musicgene\MusicPlayerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */