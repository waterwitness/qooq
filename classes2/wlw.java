import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CustomedTabWidget;
import java.lang.ref.WeakReference;

public class wlw
  extends Handler
{
  private WeakReference a;
  
  public wlw(CustomedTabWidget paramCustomedTabWidget)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramCustomedTabWidget);
  }
  
  public void handleMessage(Message arg1)
  {
    CustomedTabWidget localCustomedTabWidget = (CustomedTabWidget)this.a.get();
    if (localCustomedTabWidget == null) {
      return;
    }
    if (localCustomedTabWidget.jdField_a_of_type_Float < 0.0F) {
      localCustomedTabWidget.invalidate((int)(localCustomedTabWidget.b.left + localCustomedTabWidget.jdField_a_of_type_Float), localCustomedTabWidget.b.top, localCustomedTabWidget.b.right, localCustomedTabWidget.b.bottom);
    }
    synchronized (localCustomedTabWidget.jdField_a_of_type_Wlw)
    {
      Rect localRect = localCustomedTabWidget.b;
      localRect.left = ((int)(localRect.left + localCustomedTabWidget.jdField_a_of_type_Float));
      localRect = localCustomedTabWidget.b;
      localRect.right = ((int)(localRect.right + localCustomedTabWidget.jdField_a_of_type_Float));
      if ((localCustomedTabWidget.jdField_a_of_type_AndroidGraphicsRect.left - localCustomedTabWidget.b.left) / localCustomedTabWidget.jdField_a_of_type_Float >= 1.0F)
      {
        sendEmptyMessage(0);
        return;
        localCustomedTabWidget.invalidate(localCustomedTabWidget.b.left, localCustomedTabWidget.b.top, (int)(localCustomedTabWidget.b.right + localCustomedTabWidget.jdField_a_of_type_Float), localCustomedTabWidget.b.bottom);
      }
    }
    ((CustomedTabWidget)localObject).b.set(((CustomedTabWidget)localObject).jdField_a_of_type_AndroidGraphicsRect.left, ((CustomedTabWidget)localObject).jdField_a_of_type_AndroidGraphicsRect.top, ((CustomedTabWidget)localObject).jdField_a_of_type_AndroidGraphicsRect.right, ((CustomedTabWidget)localObject).jdField_a_of_type_AndroidGraphicsRect.bottom);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wlw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */