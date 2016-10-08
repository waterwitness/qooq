import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.PendantInfo.AnimationLruCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.Collection;
import java.util.Iterator;

public class wer
  extends MqqWeakReferenceHandler
{
  public wer(PendantInfo paramPendantInfo, Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper, paramCallback);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "handleMessage, msg.what=" + paramMessage.what);
    }
    long l;
    Object localObject;
    if (paramMessage.what == 16)
    {
      l = paramMessage.getData().getLong("targetId");
      if (PendantInfo.m == l)
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (VipPendantDrawable)paramMessage.next();
          if (localObject != null) {
            ((VipPendantDrawable)localObject).invalidateSelf();
          }
        }
      }
      paramMessage = (VipPendantDrawable)this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
      if (paramMessage != null) {
        paramMessage.invalidateSelf();
      }
    }
    Bitmap localBitmap;
    for (;;)
    {
      return;
      if (paramMessage.what != 17) {
        break label554;
      }
      this.a.jdField_a_of_type_Boolean = true;
      this.a.u = this.a.a(this.a.u);
      if (!(paramMessage.obj instanceof Bitmap)) {
        break label516;
      }
      localObject = (Bitmap)paramMessage.obj;
      if ((localObject != null) && (PendantInfo.a(this.a) != localObject))
      {
        localBitmap = this.a.a();
        if (localBitmap != null)
        {
          if ((!localBitmap.isMutable()) || (Build.VERSION.SDK_INT <= 11)) {
            break label461;
          }
          this.a.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
        }
        label244:
        PendantInfo.a(this.a, (Bitmap)localObject);
      }
      l = paramMessage.getData().getLong("targetId");
      try
      {
        if (PendantInfo.m != l) {
          break label476;
        }
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (VipPendantDrawable)paramMessage.next();
          if (localObject != null) {
            ((VipPendantDrawable)localObject).invalidateSelf();
          }
        }
        if (2 != this.a.t) {}
      }
      catch (Exception paramMessage)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PendantInfo", 2, "handleMessage, exception:" + paramMessage.getMessage());
        }
      }
    }
    label354:
    if (this.a.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PendantInfo", 2, "cancel decode pendant in market:" + this.a.jdField_a_of_type_Long);
      }
      this.a.b = false;
      l = PendantInfo.m;
      this.a.u = 0;
      this.a.v = 3;
    }
    for (;;)
    {
      if (this.a.v == 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask = null;
        return;
        label461:
        localBitmap.recycle();
        this.a.jdField_a_of_type_AndroidGraphicsBitmap = null;
        break label244;
        label476:
        paramMessage = (VipPendantDrawable)this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
        if (paramMessage == null) {
          break label354;
        }
        paramMessage.invalidateSelf();
        break label354;
      }
      this.a.a(l);
      return;
      label516:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PendantInfo", 2, "wrong type , msg.obj = " + paramMessage.obj.getClass());
      return;
      label554:
      if (paramMessage.what == 18)
      {
        if ((!PendantInfo.a(this.a)) && (this.a.t == 2) && (this.a.v > 0))
        {
          this.a.a(paramMessage.getData().getLong("targetId"));
          return;
        }
        if ((PendantInfo.a(this.a)) || (this.a.t != 1)) {
          break;
        }
        PendantInfo.a(this.a);
        return;
      }
      if (paramMessage.what == 19)
      {
        l = paramMessage.getData().getLong("targetId");
        if (PendantInfo.m == l)
        {
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
          while (paramMessage.hasNext())
          {
            localObject = (VipPendantDrawable)paramMessage.next();
            if (localObject != null) {
              this.a.a((VipPendantDrawable)localObject, true, 0L);
            }
          }
          break;
        }
        paramMessage = (VipPendantDrawable)this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
        if (paramMessage == null) {
          break;
        }
        this.a.a(paramMessage, false, 0L);
        return;
      }
      if (paramMessage.what != 20) {
        break;
      }
      l = paramMessage.getData().getLong("targetId");
      if (PendantInfo.m == l)
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (VipPendantDrawable)paramMessage.next();
          if (localObject != null) {
            this.a.a((VipPendantDrawable)localObject, l);
          }
        }
        break;
      }
      paramMessage = (VipPendantDrawable)this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
      if (paramMessage == null) {
        break;
      }
      this.a.a(paramMessage, l);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */