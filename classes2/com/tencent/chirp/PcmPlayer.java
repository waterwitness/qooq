package com.tencent.chirp;

import android.content.Context;
import android.media.AudioRecord;
import android.media.AudioTrack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import jki;

public class PcmPlayer
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "PcmPlayer";
  public static final int b = 1;
  public static final int c = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private PcmPlayer.QQPlayerListener jdField_a_of_type_ComTencentChirpPcmPlayer$QQPlayerListener;
  private jki jdField_a_of_type_Jki;
  private String b;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public PcmPlayer(Context paramContext, PcmPlayer.QQPlayerListener paramQQPlayerListener, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = 44100;
    this.f = 2;
    this.g = 2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentChirpPcmPlayer$QQPlayerListener = paramQQPlayerListener;
    this.d = paramInt;
    this.b = paramString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Jki != null) {}
    do
    {
      return;
      int i = AudioRecord.getMinBufferSize(this.d, this.f, this.g);
      this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(3, this.d, this.f, this.g, i, 1);
      this.e = (this.d / 1000 * 20 * this.g);
      this.jdField_a_of_type_AndroidMediaAudioTrack.play();
      this.jdField_a_of_type_Jki = new jki(this, null);
      this.jdField_a_of_type_Jki.start();
    } while (this.jdField_a_of_type_ComTencentChirpPcmPlayer$QQPlayerListener == null);
    this.jdField_a_of_type_ComTencentChirpPcmPlayer$QQPlayerListener.j();
  }
  
  public void b()
  {
    jki localjki = this.jdField_a_of_type_Jki;
    if (localjki != null) {
      localjki.a = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\chirp\PcmPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */