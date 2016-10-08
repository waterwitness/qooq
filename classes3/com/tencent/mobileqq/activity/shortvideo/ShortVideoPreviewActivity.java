package com.tencent.mobileqq.activity.shortvideo;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;
import pks;
import pkt;
import pku;
import pkv;
import pkw;
import pkx;
import pky;
import pkz;
import pla;
import plb;
import plc;
import pld;
import ple;
import plf;
import plg;

public class ShortVideoPreviewActivity
  extends BaseActivity
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, View.OnClickListener
{
  static final String jdField_a_of_type_JavaLangString = "ShortVideoPreviewActivity";
  public static final int d = 0;
  public static final int e = 1;
  static final String e = "state_play_position";
  public static final int f = 2;
  static final String f = "state_play_state";
  public static final int g = 3;
  public static final String g = "preview_only";
  static final String jdField_h_of_type_JavaLangString = "VideoCompressTask";
  public static final int m = 0;
  public static final int n = 1;
  public static final int o = 2;
  public static final int p = 3;
  public static final int q = 4;
  public static final int r = 5;
  public static final int s = 6;
  public static final int t = 7;
  int jdField_a_of_type_Int;
  public long a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Bitmap a;
  public MediaPlayer a;
  SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback;
  public SurfaceView a;
  public ImageView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  public long b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  public String c;
  boolean jdField_c_of_type_Boolean;
  public String d;
  int jdField_h_of_type_Int;
  public int i;
  public int j;
  public int k;
  public int l;
  int u;
  
  public ShortVideoPreviewActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.h = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new pks(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new pla(this);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    DialogUtil.a(paramContext, 232, null, paramContext.getString(paramInt), new pkx(), null).show();
  }
  
  private void i()
  {
    this.jdField_a_of_type_Long = new File(this.d).length();
    if ((NetworkUtil.h(this)) && (!NetworkUtil.i(this)) && (this.jdField_a_of_type_Long > 3145728L))
    {
      FMDialogUtil.a(this, 2131362855, 2131362851, new pkw(this));
      return;
    }
    j();
    setResult(-1);
  }
  
  private void j()
  {
    Intent localIntent = getIntent();
    String str2 = localIntent.getStringExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME");
    Object localObject = localIntent.getStringExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME");
    String str1 = str2;
    if (str2 == null)
    {
      str2 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localObject = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      str1 = str2;
      if (str2 == null)
      {
        QQToast.a(this, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
        return;
      }
    }
    localIntent.setClassName((String)localObject, str1);
    localIntent.putExtra("file_send_path", this.d);
    localIntent.putExtra("file_send_duration", this.jdField_b_of_type_Long);
    localIntent.putExtra("file_send_size", this.jdField_a_of_type_Long);
    localIntent.putExtra("uin", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("file_source", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("start_init_activity_after_sended", true);
    if (!this.jdField_a_of_type_Boolean) {
      ReportController.b(null, "CliOper", "", "", "0X8006130", "0X8006130", 0, 0, "", "", "", "");
    }
    localObject = getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("custom_shortvideopreview_sendbtn_reportActionName")))
    {
      str2 = ((Intent)localObject).getStringExtra("custom_shortvideopreview_sendbtn_reportActionName");
      str1 = ((Intent)localObject).getStringExtra("custom_shortvideopreview_sendbtn_reportReverse2");
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
      if (str2 != null) {
        ReportController.b(null, "CliOper", "", "", str2, str2, 0, 0, (String)localObject, "", "", "");
      }
    }
    startActivity(localIntent);
  }
  
  public String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "null";
    case 0: 
      return " idle ";
    case 1: 
      return " playing ";
    case 2: 
      return " pause ";
    }
    return " error ";
  }
  
  void a()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      switch (this.u)
      {
      default: 
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131367263);
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364595);
        }
      }
      return;
      StringBuilder localStringBuilder = new StringBuilder("发送");
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        localStringBuilder.append("(").append(this.jdField_a_of_type_JavaUtilArrayList.size()).append(")");
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131367263);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131364961);
    }
  }
  
  public void a(int paramInt)
  {
    if (!FileUtils.b(this.d))
    {
      QQToast.a(this, 2131371516, 0).a();
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "#play#, msec=" + paramInt);
      }
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDisplay(this.jdField_a_of_type_AndroidViewSurfaceView.getHolder());
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this.d);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new plb(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreviewActivity", 2, "#play#, msec=" + paramInt, localException);
      }
      e();
      DialogUtil.a(this, 232, null, getString(2131371525), new plc(this), null).show();
    }
  }
  
  void a(Intent paramIntent)
  {
    this.d = paramIntent.getExtras().getString("file_send_path");
    this.jdField_b_of_type_Long = paramIntent.getExtras().getLong("file_send_duration");
    this.jdField_a_of_type_Long = paramIntent.getExtras().getLong("file_send_size");
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("file_width", 0);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("file_height", 0);
    paramIntent.removeExtra("file_width");
    paramIntent.removeExtra("file_height");
    this.jdField_b_of_type_JavaLangString = paramIntent.getExtras().getString("uin");
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("file_source");
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("preview_only", false);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("is_from_system_media", true);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    }
    boolean bool1 = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
    boolean bool2 = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_REWARD", false);
    boolean bool3 = paramIntent.getBooleanExtra("from_health", false);
    paramIntent = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if ((paramIntent.contains("SplashActivity")) || (paramIntent.contains("ChatActivity"))) {
      this.u = 0;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(this.d)) || ((this.u != 2) && (this.u != 6) && (!bool3) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) || (!FileUtils.b(this.d)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoPreviewActivity", 2, "ShortVideoPreviewActivity initData(),mVideoPath or mUin is empty or mVideoPath not exits, just finish.");
        }
        QQToast.a(this, 2131371516, 0).a();
        super.finish();
      }
      return;
      if (paramIntent.contains("QZonePublishMoodActivity")) {
        this.u = 1;
      } else if (paramIntent.contains("QZoneUploadPhotoActivity")) {
        this.u = 1;
      } else if (bool1) {
        this.u = 2;
      } else if (bool2) {
        this.u = 5;
      } else if (paramIntent.contains("TrimVideoActivity")) {
        this.u = 3;
      } else if (paramIntent.contains("LiteActivity")) {
        this.u = 4;
      } else if ((paramIntent.contains("QQBrowserActivity")) || (paramIntent.contains("PublicAccountBrowser"))) {
        this.u = 6;
      } else if (bool3) {
        this.u = 7;
      } else {
        this.u = 0;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    b(0);
  }
  
  public void b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {}
    for (;;)
    {
      return;
      this.h = paramInt;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841297);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ShortVideoPreviewActivity", 2, "changePlayState, playState => " + a(paramInt));
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841296);
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#pause#");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) && (this.h == 1))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      b(2);
    }
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#resume#");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.h == 2))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      b(1);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    a(super.getIntent());
    if (paramBundle != null)
    {
      this.l = paramBundle.getInt("state_play_state");
      this.k = paramBundle.getInt("state_play_position");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "onCreate(), mSavedCurPosition : " + this.k + ",mSavedPlayState : " + a(this.l));
      }
    }
    super.setContentView(2130904358);
    this.jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)findViewById(2131302514));
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setType(3);
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().addCallback(this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback);
    this.jdField_a_of_type_AndroidViewSurfaceView.getViewTreeObserver().addOnGlobalLayoutListener(new pky(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298138));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302516));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302517));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302507));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new pkz(this));
    a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "doOnDestroy");
    }
    b();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  void e()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
    b(0);
  }
  
  void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#stop#");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && ((this.h == 1) || (this.h == 2))) {
      b();
    }
  }
  
  public void g()
  {
    int i1 = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
    int i2 = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "adjustVideoRatio, videoWith:" + i1 + ",videoHeight:" + i2);
    }
    if ((this.j == 0) || (this.i == 0) || (i1 == 0) || (i2 == 0)) {
      return;
    }
    if (this.j / this.i > i2 / i1)
    {
      f1 = this.i;
      i1 = (int)(i2 * f1 / i1);
      i1 = (int)((this.j - i1) / 2.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.setMargins(0, i1, 0, i1);
      this.jdField_a_of_type_AndroidViewSurfaceView.setLayoutParams(localLayoutParams);
      return;
    }
    float f1 = this.j;
    i1 = (int)(i1 * f1 / i2);
    i1 = (int)((this.i - i1) / 2.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(i1, 0, i1, 0);
    this.jdField_a_of_type_AndroidViewSurfaceView.setLayoutParams(localLayoutParams);
  }
  
  void h()
  {
    Object localObject = Environment.getExternalStorageDirectory();
    int i1;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i1 == 0)) {
        break label140;
      }
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        if (Utils.b() > 512000L)
        {
          if (NetworkUtil.c(this))
          {
            this.jdField_a_of_type_Long = new File(this.d).length();
            localObject = ShortVideoUtils.a(this, this.jdField_a_of_type_Long);
            DialogUtil.a(this, 232, null, String.format(getResources().getString(2131371534), new Object[] { localObject }), new pku(this), new pkv(this)).show();
            return;
            i1 = 0;
            break;
            label140:
            i1 = 0;
            continue;
          }
          j();
          return;
        }
        a(this, 2131371531);
        return;
      }
    }
    QQToast.a(this, 1, 2131368967, 0).b(getTitleBarHeight());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302516: 
      super.finish();
      return;
    case 2131302507: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "handleClick: mPlayState = " + a(this.h));
      }
      if ((this.l == 2) && (this.k > 0))
      {
        a(this.k);
        this.l = 0;
        this.k = 0;
        return;
      }
      switch (this.h)
      {
      default: 
        return;
      case 0: 
        if (this.app.d())
        {
          QQToast.a(this, 0, 2131371537, 0).a();
          return;
        }
        a(0);
        return;
      case 1: 
        c();
        return;
      case 2: 
        d();
        return;
      }
      a(0);
      return;
    }
    ArrayList localArrayList;
    switch (this.u)
    {
    case 6: 
    default: 
      return;
    case 0: 
      h();
      return;
    case 4: 
      i();
      return;
    case 1: 
    case 3: 
      paramView = super.getIntent();
      paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      paramView.putExtra("PhotoConst.VIDEO_SIZE", this.jdField_a_of_type_Long);
      paramView.putExtra("file_send_duration", this.jdField_b_of_type_Long);
      localArrayList = new ArrayList();
      localArrayList.add(this.d);
      PhotoUtils.a(this, paramView, localArrayList, 2, false);
      return;
    case 5: 
      paramView = super.getIntent();
      paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      paramView.putExtra("PhotoConst.VIDEO_SIZE", this.jdField_a_of_type_Long);
      paramView.putExtra("file_send_duration", this.jdField_b_of_type_Long);
      localArrayList = new ArrayList();
      localArrayList.add(this.d);
      DialogUtil.a(this, 232, null, getString(2131364966, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(this.jdField_a_of_type_Long / 1024.0D / 1024.0D) }) }), new pld(this, paramView, localArrayList), new ple(this)).show();
      return;
    case 2: 
      DialogUtil.a(this, 232, null, getString(2131364966, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(this.jdField_a_of_type_Long / 1024.0D / 1024.0D) }) }), new plf(this), new pkt(this)).show();
      paramView = new Intent("key_video_select_apply_click");
      paramView.putExtra("className", super.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
      sendBroadcast(paramView);
      return;
    }
    new plg(this, this).execute(new String[] { this.d });
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onCompletion");
    }
    b(0);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPreviewActivity", 2, "mMediaPlayer onError what=" + paramInt1 + ",extra=" + paramInt2);
    }
    b(3);
    e();
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onPrepared");
    }
    g();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    b(1);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (((this.h == 1) || (this.h == 2)) && (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)) {
      this.k = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    this.l = this.h;
    paramBundle.putInt("state_play_state", this.h);
    paramBundle.putInt("state_play_position", this.k);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onSaveInstanceState: mSavedCurPosition: " + this.k + " ,playState = " + a(this.h));
    }
  }
  
  public void onStart()
  {
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.onStart();
  }
  
  protected void onStop()
  {
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.onStop();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\shortvideo\ShortVideoPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */