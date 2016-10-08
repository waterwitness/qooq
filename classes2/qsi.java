import android.text.TextUtils;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarConfig;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class qsi
  implements DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback
{
  public qsi(DynamicAvatarManager paramDynamicAvatarManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String arg1, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "onDownloadFinish url: " + ??? + " isSuccess: " + paramBoolean1 + " isFileExist: " + paramBoolean2);
    }
    if (TextUtils.isEmpty(???)) {
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.a.c)
      {
        i = this.a.c.size() - 1;
        if (i >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.a.c.get(i);
          if ((localWeakReference == null) || (localWeakReference.get() == null))
          {
            this.a.c.remove(i);
          }
          else if (???.equals(((DynamicFaceDrawable)((WeakReference)this.a.c.get(i)).get()).c))
          {
            localWeakReference = (WeakReference)this.a.c.remove(i);
            if (paramBoolean1)
            {
              this.a.b.add(localWeakReference);
              if (QLog.isColorLevel()) {
                QLog.i("Q.dynamicAvatar", 2, "onFileDownloadFinish add to wait play list.");
              }
            }
          }
        }
      }
      if (!DynamicFaceDrawable.b) {}
      for (;;)
      {
        synchronized (this.a.d)
        {
          i = this.a.d.size() - 1;
          if (i < 0) {
            break label642;
          }
          if ((this.a.d.get(i) != null) && (((WeakReference)this.a.d.get(i)).get() != null))
          {
            ??? = (WeakReference)this.a.d.get(i);
            if ((??? != null) && (???.get() != null)) {
              this.a.a((DynamicFaceDrawable)???.get(), false, false);
            }
          }
        }
        for (;;)
        {
          synchronized (this.a.a)
          {
            i = this.a.b.size() - 1;
            if (i < 0) {
              break label639;
            }
            ??? = (WeakReference)this.a.b.get(i);
            if ((??? == null) || (((WeakReference)???).get() == null))
            {
              this.a.b.remove(i);
              i -= 1;
              continue;
              this.a.d.remove(i);
              i -= 1;
              break;
              ??? = finally;
              throw ???;
            }
            if (this.a.a.size() < DynamicAvatarManager.a(this.a).b)
            {
              this.a.b.remove(i);
              if (this.a.a.contains(???)) {
                continue;
              }
              paramBoolean1 = this.a.a((DynamicFaceDrawable)((WeakReference)???).get());
              if (paramBoolean1) {
                this.a.a.add(???);
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("Q.dynamicAvatar", 2, "onFileDownloadFinish to play.02 result : " + paramBoolean1 + " playing size: " + this.a.a.size());
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.dynamicAvatar", 2, "onFileDownloadFinish to play.02 beyond maxPlayingCount : " + DynamicAvatarManager.a(this.a).b);
          }
        }
        label639:
        return;
        label642:
        ??? = null;
      }
      i -= 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qsi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */