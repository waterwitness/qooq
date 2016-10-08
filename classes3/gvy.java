import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gvy
  implements Runnable
{
  public gvy(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.b == null) || (this.a.j == null) || (this.a.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUIBase", 2, "SetTitleMaxWidth Failed --> RootView Or TitleView Or Resource is NULL");
      }
      return;
    }
    if (this.a.i == null)
    {
      i = this.a.a.getDimensionPixelSize(2131493886);
      this.a.j.setMaxWidth(i);
      return;
    }
    int i = this.a.b.getWidth();
    int j = this.a.i.getWidth();
    this.a.j.setMaxWidth(i - j * 2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */