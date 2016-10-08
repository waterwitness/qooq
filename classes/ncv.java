import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ncv
  extends Handler
{
  public ncv(CustomizeStrategyFactory paramCustomizeStrategyFactory, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = (CustomizeStrategyFactory.RedPacketInfo)paramMessage.obj;
      if ((CustomizeStrategyFactory.a(this.a).containsKey(paramMessage.c)) && (!((ArrayList)CustomizeStrategyFactory.a(this.a).get(paramMessage.c)).isEmpty())) {
        break label57;
      }
    }
    label57:
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("CustomizeStrategyFactory", 2, "info =" + paramMessage.jdField_a_of_type_Int + "|" + paramMessage.jdField_a_of_type_JavaLangString + "|" + paramMessage.jdField_b_of_type_JavaLangString + "|" + System.currentTimeMillis());
          }
          Iterator localIterator = ((ArrayList)CustomizeStrategyFactory.a(this.a).get(paramMessage.c)).iterator();
          while (localIterator.hasNext())
          {
            CustomizeStrategyFactory.OnCustomizeListener localOnCustomizeListener = (CustomizeStrategyFactory.OnCustomizeListener)localIterator.next();
            if (localOnCustomizeListener != null) {
              localOnCustomizeListener.a(paramMessage.jdField_a_of_type_Int, paramMessage);
            }
          }
          ((ArrayList)CustomizeStrategyFactory.a(this.a).get(paramMessage.c)).clear();
          CustomizeStrategyFactory.a(this.a).remove(paramMessage.c);
        } while (CustomizeStrategyFactory.b(this.a).containsKey(paramMessage.c));
        if (paramMessage.jdField_a_of_type_Int != 2) {
          break;
        }
      } while (paramMessage.jdField_b_of_type_AndroidGraphicsBitmap == null);
      if (QLog.isColorLevel()) {
        QLog.i("CustomizeStrategyFactory", 2, "onLoadFinish: customizeBg is prepared");
      }
      CustomizeStrategyFactory.b(this.a).put(paramMessage.c, paramMessage);
      return;
    } while ((paramMessage.jdField_a_of_type_Int != 1) || (paramMessage.jdField_a_of_type_AndroidGraphicsBitmap == null));
    if (QLog.isColorLevel()) {
      QLog.i("CustomizeStrategyFactory", 2, "onLoadFinish: customizeBg is prepared");
    }
    CustomizeStrategyFactory.b(this.a).put(paramMessage.c, paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ncv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */