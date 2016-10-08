import android.media.SoundPool;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hid
  implements Runnable
{
  public hid(SensorAPIJavaScript paramSensorAPIJavaScript, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a != null) && (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a.play(this.jdField_a_of_type_Int, 1.0F, 1.0F, 0, 0, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SensorApi", 2, "play failure url=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */