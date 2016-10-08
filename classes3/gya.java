import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView.IPtvTemplateItemCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.qphone.base.util.QLog;

public class gya
  implements PtvTemplateItemView.IPtvTemplateItemCallback
{
  public gya(QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(PtvTemplateManager.a, 2, "PtvTemplateAdapter onItemClicked position: " + paramInt);
    }
    if ((System.currentTimeMillis() - this.a.a < 500L) && (paramInt > 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(PtvTemplateManager.a, 2, "PtvTemplateAdapter onItemClicked position yes : " + paramInt);
    }
    this.a.a = System.currentTimeMillis();
    int i = this.a.d;
    this.a.d = paramInt;
    this.a.a(i, this.a.d);
    this.a.b(this.a.d);
    this.a.c(this.a.d);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gya.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */