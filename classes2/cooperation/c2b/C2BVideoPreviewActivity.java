package cooperation.c2b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import xzy;

public class C2BVideoPreviewActivity
  extends Activity
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, View.OnClickListener
{
  public static final String a = "video_path";
  private static final String jdField_b_of_type_JavaLangString = "C2BVideoPreviewActivity";
  private int jdField_a_of_type_Int;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Display jdField_a_of_type_AndroidViewDisplay;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private int jdField_b_of_type_Int;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  
  public C2BVideoPreviewActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  void a(String paramString)
  {
    paramString = Toast.makeText(getApplicationContext(), paramString, 0);
    paramString.setGravity(17, 0, 0);
    paramString.show();
  }
  
  public boolean a(String paramString)
  {
    try
    {
      boolean bool = new File(paramString).exists();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2BVideoPreviewActivity", 2, paramString);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903531);
    paramBundle = getIntent().getStringExtra("video_path");
    if ((paramBundle == null) || (!a(paramBundle)))
    {
      a("文件已被删除！");
      finish();
    }
    for (;;)
    {
      return;
      findViewById(2131299035).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)findViewById(2131299033));
      this.jdField_a_of_type_AndroidViewSurfaceHolder = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
      this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
      this.jdField_a_of_type_AndroidViewSurfaceHolder.setType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnInfoListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnSeekCompleteListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnVideoSizeChangedListener(this);
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramBundle);
        this.jdField_a_of_type_AndroidViewDisplay = getWindowManager().getDefaultDisplay();
        setVolumeControlStream(3);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = C2BDestoryReceiver.a(this, super.getIntent());
        if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {
          continue;
        }
        this.jdField_b_of_type_AndroidContentBroadcastReceiver = new xzy(this);
        paramBundle = new IntentFilter();
        paramBundle.addAction("tencent.av.v2q.AudioVideoRequest");
        paramBundle.addAction("mqq.intent.action.ACCOUNT_KICKED");
        registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
        return;
      }
      catch (IllegalArgumentException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      }
      catch (IllegalStateException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    C2BDestoryReceiver.a(this, this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    super.onDestroy();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    return false;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AudioManager localAudioManager = (AudioManager)getSystemService("audio");
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    case 25: 
      localAudioManager.adjustStreamVolume(3, -1, 1);
      return true;
    }
    localAudioManager.adjustStreamVolume(3, 1, 1);
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_Int = paramMediaPlayer.getVideoWidth();
    this.jdField_b_of_type_Int = paramMediaPlayer.getVideoHeight();
    this.jdField_a_of_type_AndroidViewSurfaceView.setLayoutParams(new LinearLayout.LayoutParams(this.jdField_a_of_type_AndroidViewDisplay.getWidth(), this.jdField_a_of_type_AndroidViewDisplay.getWidth() * this.jdField_b_of_type_Int / this.jdField_a_of_type_Int));
    paramMediaPlayer.start();
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer) {}
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setDisplay(paramSurfaceHolder);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\c2b\C2BVideoPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */