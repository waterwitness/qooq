import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class qsb
  implements INetEngine.INetEngineListener
{
  public qsb(DynamicAvatarDownloadManager paramDynamicAvatarDownloadManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NetReq arg1, long paramLong1, long paramLong2)
  {
    if ((!DynamicAvatarDownloadManager.a(this.a).isEmpty()) && ((??? instanceof HttpNetReq))) {
      if (paramLong2 <= 0L) {
        break label148;
      }
    }
    label148:
    for (int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);; i = 0)
    {
      String str = ((HttpNetReq)???).jdField_a_of_type_JavaLangString;
      synchronized (DynamicAvatarDownloadManager.a(this.a))
      {
        if (!DynamicAvatarDownloadManager.a(this.a).isEmpty())
        {
          Iterator localIterator = DynamicAvatarDownloadManager.a(this.a).iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback)localWeakReference.get()).a(str, i);
            }
          }
        }
      }
      return;
    }
  }
  
  public void a(NetResp arg1)
  {
    Object localObject1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("onResp reqUrl: resp is null: ");
      if (??? == null)
      {
        bool = true;
        QLog.i("Q.dynamicAvatar", 2, bool);
      }
    }
    else
    {
      if (??? != null) {
        break label52;
      }
    }
    label52:
    do
    {
      return;
      bool = false;
      break;
      localObject1 = ((HttpNetReq)???.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString;
      int i = ???.e;
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onResp reqUrl: " + (String)localObject1 + " mResult: " + i + ",httpCode:" + ???.g + ",errDesc:" + ???.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        synchronized (DynamicAvatarDownloadManager.a(this.a))
        {
          if (DynamicAvatarDownloadManager.a(this.a).isEmpty()) {
            break;
          }
          Iterator localIterator = DynamicAvatarDownloadManager.a(this.a).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject3 = (WeakReference)localIterator.next();
          if ((localObject3 == null) || (((WeakReference)localObject3).get() == null)) {
            continue;
          }
          localObject3 = (DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback)((WeakReference)localObject3).get();
          if (i == 0)
          {
            bool = true;
            ((DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback)localObject3).a((String)localObject1, bool, false);
          }
        }
        bool = false;
      }
      DynamicAvatarDownloadManager.a(this.a).remove(localObject2);
    } while ((!NetworkUtil.h(BaseApplicationImpl.getContext())) || (NetworkUtil.i(BaseApplicationImpl.getContext())));
    DynamicAvatarDownloadManager.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qsb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */