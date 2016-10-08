package com.tencent.mobileqq.ar;

import android.media.MediaPlayer;
import android.media.SoundPool;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import qox;
import qoy;

public class ARMusicController
{
  private static final String jdField_a_of_type_JavaLangString = "ARMusicController";
  private int jdField_a_of_type_Int;
  public MediaPlayer a;
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public ARMusicController(String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    try
    {
      this.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_c_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(1, 3, 0);
      this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new qox(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new qoy(this));
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(paramString2, 1);
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString1);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
        return;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ARMusicController", 2, "playBgMusic : " + this.jdField_b_of_type_JavaLangString);
        return;
        this.d = true;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidMediaSoundPool.play(this.jdField_a_of_type_Int, 1.0F, 1.0F, 1, 0, 1.0F);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ARMusicController", 2, "playFireMusic : " + this.jdField_c_of_type_JavaLangString);
        return;
        this.jdField_c_of_type_Boolean = true;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "stopAllMusic");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void d()
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ARMusicController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */