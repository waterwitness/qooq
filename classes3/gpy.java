import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.av.ui.AVLoadingDialogActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.SoftReference;

public final class gpy
  extends Handler
{
  public gpy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessage.obj != null)
    {
      localObject1 = localObject2;
      if ((paramMessage.obj instanceof SoftReference))
      {
        Object localObject3 = (SoftReference)paramMessage.obj;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((SoftReference)localObject3).get();
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if ((localObject3 instanceof AVLoadingDialogActivity)) {
              localObject1 = (AVLoadingDialogActivity)localObject3;
            }
          }
        }
      }
    }
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while (localObject1 == null);
      ((AVLoadingDialogActivity)localObject1).startActivity((Intent)((AVLoadingDialogActivity)localObject1).getIntent().getParcelableExtra("avactivity_intent"));
      ((AVLoadingDialogActivity)localObject1).overridePendingTransition(2130968714, 0);
      return;
    } while (localObject1 == null);
    ((AVLoadingDialogActivity)localObject1).finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gpy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */