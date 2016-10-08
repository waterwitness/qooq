import com.tencent.av.funchat.magicface.MagicfaceManagerForAV;
import com.tencent.av.funchat.magicface.MagicfaceManagerForAV.EmotionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class ghj
  implements Runnable
{
  public ghj(MagicfaceManagerForAV paramMagicfaceManagerForAV, Map paramMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      MagicfaceManagerForAV.EmotionInfo localEmotionInfo = (MagicfaceManagerForAV.EmotionInfo)localIterator.next();
      if ((localEmotionInfo.a) && (!this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV.a(localEmotionInfo))) {
        this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV.a(localEmotionInfo, null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ghj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */