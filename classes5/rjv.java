import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rjv
  implements Runnable
{
  public rjv(EmoticonMainPanel paramEmoticonMainPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func updateLastEmoticonPanel begins.");
    }
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rjv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */