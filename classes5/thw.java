import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyIconDecoder;
import com.tencent.mobileqq.util.IIconDecoder.IIconListener;
import java.util.Iterator;
import java.util.List;

public class thw
  implements Runnable
{
  public thw(NearbyIconDecoder paramNearbyIconDecoder, String paramString, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      String[] arrayOfString = this.jdField_a_of_type_JavaLangString.split("_s_");
      if ((arrayOfString.length == 3) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyIconDecoder.a != null))
      {
        int i = Integer.parseInt(arrayOfString[0]);
        int j = Integer.parseInt(arrayOfString[2]);
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyIconDecoder.a.iterator();
        while (localIterator.hasNext()) {
          ((IIconDecoder.IIconListener)localIterator.next()).a(i, arrayOfString[1], j, this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\thw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */