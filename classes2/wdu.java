import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VoicePlayer;

public class wdu
  implements Runnable
{
  public wdu(VoicePlayer paramVoicePlayer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    VoicePlayer.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */