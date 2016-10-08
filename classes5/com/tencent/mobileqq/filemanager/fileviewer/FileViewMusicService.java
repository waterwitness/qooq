package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView.IGetTotalTime;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioHelper.AudioPlayerParameter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import shn;
import shp;
import shq;

public class FileViewMusicService
  implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static FileViewMusicService jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService;
  private static WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  IFileViewMusicEvent jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent;
  String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  private FileViewMusicService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "FileViewMusicService<FileAssistant>";
    this.jdField_a_of_type_AndroidViewSurfaceHolder = null;
  }
  
  public static FileViewMusicService a()
  {
    FileViewMusicService localFileViewMusicService1 = null;
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {
      localFileViewMusicService1 = (FileViewMusicService)jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    FileViewMusicService localFileViewMusicService2 = localFileViewMusicService1;
    if (localFileViewMusicService1 == null)
    {
      localFileViewMusicService2 = new FileViewMusicService();
      jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localFileViewMusicService2);
    }
    return localFileViewMusicService2;
  }
  
  private void f()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.c)) {}
    label99:
    do
    {
      do
      {
        do
        {
          return;
          try
          {
            if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() != 0)) {
              break label99;
            }
            if (!QLog.isDevelopLevel()) {
              break;
            }
            throw new NullPointerException("没有初始化");
          }
          catch (Exception localException1) {}
        } while (!QLog.isColorLevel());
        QLog.e("FileViewMusicService<FileAssistant>", 2, "musicPathString not init " + localException1.toString());
        return;
      } while (!QLog.isColorLevel());
      QLog.e("FileViewMusicService<FileAssistant>", 2, "musci path not init!");
      return;
      if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).requestAudioFocus(this, 3, 1) == 0)
      {
        QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
        return;
      }
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
      try
      {
        ((QQAppInterface)BaseApplicationImpl.a().a()).a().a(true, 25, Boolean.valueOf(true));
        return;
      }
      catch (Exception localException2) {}
    } while (!QLog.isColorLevel());
    QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
    try
    {
      ((QQAppInterface)BaseApplicationImpl.a().a()).a().a(true, 25, Boolean.valueOf(true));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_b_of_type_Int = paramInt;
      this.d = true;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_b_of_type_Int);
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {}
    int j;
    int i;
    do
    {
      return;
      j = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
      i = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
    } while ((j == 0) || (i == 0));
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int n = localDisplayMetrics.widthPixels;
    int m = localDisplayMetrics.heightPixels;
    float f = n / m;
    f = j / i;
    if ((j == n) && (i == m)) {}
    for (;;)
    {
      int k;
      if ((Build.VERSION.SDK_INT < 11) && (this.jdField_a_of_type_AndroidViewSurfaceView != null))
      {
        paramActivity = new RelativeLayout.LayoutParams(j, i);
        paramActivity.addRule(13);
        this.jdField_a_of_type_AndroidViewSurfaceView.setLayoutParams(paramActivity);
        return;
        if (f > 1.0F)
        {
          j = j * n / j;
          k = (int)(j / f);
          if (k <= m) {
            break label260;
          }
          i = i * m / i;
          j = (int)(i * f);
          continue;
        }
        i = i * m / i;
        k = (int)(i * f);
        if (i > m)
        {
          j = j * n / j;
          i = (int)(j / f);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidViewSurfaceHolder.setFixedSize(j, i);
        return;
      }
      j = k;
      continue;
      label260:
      i = k;
    }
  }
  
  public void a(Activity paramActivity, SurfaceView paramSurfaceView)
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      if (Build.VERSION.SDK_INT >= 14) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 0)
    {
      if (!paramSurfaceView.getHolder().getSurface().isValid()) {
        j = 1;
      }
      if ((j == 0) || (i != 0)) {
        break;
      }
      QLog.e("FileViewMusicService<FileAssistant>", 1, "Surface is invalid!");
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidViewSurfaceHolder = paramSurfaceView.getHolder();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder);
      this.jdField_a_of_type_AndroidViewSurfaceView = paramSurfaceView;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnVideoSizeChangedListener(new shq(this, paramActivity));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("FileViewMusicService<FileAssistant>", 2, "mediaPlayer.setDisplay Exception happens:" + localException);
      }
    }
  }
  
  public void a(IFileViewMusicEvent paramIFileViewMusicEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent = paramIFileViewMusicEvent;
  }
  
  public void a(String paramString, LocalVideoFileView.IGetTotalTime paramIGetTotalTime)
  {
    ThreadManager.b(new shn(this, paramString, paramIGetTotalTime));
  }
  
  public void a(List paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    if (localAudioManager != null) {
      try
      {
        boolean bool = localAudioManager.isSpeakerphoneOn();
        AudioHelper.AudioPlayerParameter localAudioPlayerParameter;
        if (paramBoolean)
        {
          if (!bool)
          {
            localAudioPlayerParameter = AudioHelper.a();
            localAudioManager.setSpeakerphoneOn(localAudioPlayerParameter.jdField_a_of_type_Boolean);
            localAudioManager.setMode(localAudioPlayerParameter.jdField_a_of_type_Int);
            if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
              this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(localAudioPlayerParameter.jdField_b_of_type_Int);
            }
          }
        }
        else if (bool)
        {
          localAudioPlayerParameter = AudioHelper.b();
          localAudioManager.setSpeakerphoneOn(localAudioPlayerParameter.jdField_a_of_type_Boolean);
          localAudioManager.setMode(localAudioPlayerParameter.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
          {
            this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(localAudioPlayerParameter.jdField_b_of_type_Int);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      return false;
    }
    return this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
    this.jdField_a_of_type_JavaLangString = null;
    try
    {
      Object localObject = new FileInputStream(new File(paramString));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(((FileInputStream)localObject).getFD());
      ((FileInputStream)localObject).close();
      this.c = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 0;
      this.d = false;
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new shp(this);
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.media.AUDIO_BECOMING_NOISY");
        BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setWakeMode(BaseApplicationImpl.getContext(), 1);
      this.jdField_a_of_type_JavaLangString = paramString;
      return true;
    }
    catch (IllegalArgumentException paramString)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent.a(null);
      }
      if (QLog.isColorLevel()) {
        QLog.e("FileViewMusicService<FileAssistant>", 2, "mediaplay init error[IllegalArgumentException]:" + paramString.toString());
      }
      return false;
    }
    catch (SecurityException paramString)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent.a(null);
      }
      if (QLog.isColorLevel()) {
        QLog.e("FileViewMusicService<FileAssistant>", 2, "mediaplay init error[SecurityException]:" + paramString.toString());
      }
      return false;
    }
    catch (IllegalStateException paramString)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent.a(null);
      }
      if (QLog.isColorLevel()) {
        QLog.e("FileViewMusicService<FileAssistant>", 2, "mediaplay init error[IllegalStateException]:" + paramString.toString());
      }
      paramString.printStackTrace();
      return false;
    }
    catch (IOException paramString)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent.a("文件读取失败，文件不存在或格式不支持！");
      }
      if (QLog.isColorLevel()) {
        QLog.e("FileViewMusicService<FileAssistant>", 2, "mediaplay init error[IOException]:" + paramString.toString());
      }
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = this;
    this.jdField_a_of_type_Boolean = true;
    this.c = true;
    f();
  }
  
  public boolean b(String paramString)
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString) == true);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    try
    {
      if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
        QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not abandon audio focus");
      }
      ((QQAppInterface)BaseApplicationImpl.a().a()).a().a(true, 25, Boolean.valueOf(true));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
        }
      }
    }
    this.jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = null;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_Boolean)) {
      try
      {
        if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).requestAudioFocus(this, 3, 1) == 0)
        {
          QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
          return;
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onAudioFocusChange(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying());
      a();
      jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = null;
      return;
    } while (this.jdField_a_of_type_AndroidMediaMediaPlayer == null);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setVolume(0.1F, 0.1F);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(0);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent.f();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
    try
    {
      ((QQAppInterface)BaseApplicationImpl.a().a()).a().a(true, 25, Boolean.valueOf(true));
      this.jdField_a_of_type_Boolean = false;
      jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = null;
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
        }
      }
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "what[" + paramInt1 + "],extra[" + paramInt2 + "]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent.a("系统资源不足，文件解码失败！请稍后再试。");
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    this.jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = null;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
    try
    {
      ((QQAppInterface)BaseApplicationImpl.a().a()).a().a(true, 25, Boolean.valueOf(true));
      return true;
    }
    catch (Exception paramMediaPlayer)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
    }
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.jdField_b_of_type_Boolean = true;
    f();
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.d)) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_b_of_type_Int);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileViewMusicService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */