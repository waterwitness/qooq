import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.ColorRingPlayer;

public class wen
  implements Runnable
{
  public wen(ColorRingPlayer paramColorRingPlayer, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("subAction", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("actionName", this.b);
    localBundle.putLong("id", this.jdField_a_of_type_Long);
    localBundle.putInt("result", this.jdField_a_of_type_Int);
    localBundle = DataFactory.a("reportColorRing", "", this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.a.key, localBundle);
    this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.a(localBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */