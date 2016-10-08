package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_bg_music_setting
  extends JceStruct
{
  public byte wifi_autu_play_flag;
  
  public mobile_bg_music_setting()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_bg_music_setting(byte paramByte)
  {
    this.wifi_autu_play_flag = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.wifi_autu_play_flag = paramJceInputStream.read(this.wifi_autu_play_flag, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wifi_autu_play_flag, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MUSIC\mobile_bg_music_setting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */