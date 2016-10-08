import android.os.Bundle;
import android.support.v4.util.LruCache;
import com.tencent.bitapp.BitAppBaseViewCache;
import com.tencent.bitapp.view.BitAppBaseView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hde
  extends LruCache
{
  public hde(BitAppBaseViewCache paramBitAppBaseViewCache, int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString, BitAppBaseView paramBitAppBaseView1, BitAppBaseView paramBitAppBaseView2)
  {
    super.entryRemoved(paramBoolean, paramString, paramBitAppBaseView1, paramBitAppBaseView2);
    if (paramBitAppBaseView1 != null)
    {
      paramString = paramBitAppBaseView1.getExtra();
      if (paramString != null)
      {
        paramString = paramString.getString("msgid");
        if (QLog.isColorLevel()) {
          QLog.d(BitAppBaseViewCache.a, 2, "entryRemoved msgid: " + paramString);
        }
      }
      paramBitAppBaseView1.setIsInListView(false);
      paramBitAppBaseView1.deattachMeasuredRootView();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(BitAppBaseViewCache.a, 2, "entryRemoved,but oldValue is null");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hde.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */