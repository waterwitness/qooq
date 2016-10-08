import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.ark.ark.Container;
import com.tencent.ark.ark.ContainerCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppModuleReg;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkUIView;
import com.tencent.mobileqq.ark.DispatchTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class nhu
  implements ark.ContainerCallback
{
  public nhu(ArkContainerWrapper paramArkContainerWrapper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void RegisterModules(long paramLong, String paramString)
  {
    ArkAppModuleReg.a(paramLong, paramString);
  }
  
  public void SyncRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.jdField_a_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (QLog.isColorLevel()) {
      QLog.i("ArkApp", 2, String.format("SyncRect.0.rect: %s, wrapper: %s.", new Object[] { this.a.jdField_a_of_type_AndroidGraphicsRect.toString(), this.a.toString() }));
    }
    ArkUIView localArkUIView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView;
    if ((this.a.e) || (localArkUIView == null))
    {
      QLog.e("ark.rect", 1, String.format("SyncRect.1.rect: %s, wrapper: %s has return incorrect.", new Object[] { this.a.jdField_a_of_type_AndroidGraphicsRect.toString(), this.a.toString() }));
      return;
    }
    Bitmap localBitmap = localArkUIView.a(this.a.jdField_a_of_type_AndroidGraphicsRect);
    if (localBitmap != null) {}
    for (;;)
    {
      try
      {
        if (this.a.jdField_a_of_type_ComTencentArkArk$Container != null)
        {
          this.a.jdField_a_of_type_ComTencentArkArk$Container.DetachBitmap(null);
          if (!this.a.jdField_a_of_type_ComTencentArkArk$Container.AttachBitmap(localBitmap)) {
            QLog.e("ark.rect", 1, String.format("SyncRect.3.rect: %s, wrapper: %s attach failed.", new Object[] { this.a.jdField_a_of_type_AndroidGraphicsRect.toString(), this.a.toString() }));
          }
          this.a.jdField_a_of_type_ComTencentArkArk$Container.Paint(localBitmap, this.a.jdField_a_of_type_AndroidGraphicsRect.left, this.a.jdField_a_of_type_AndroidGraphicsRect.top, this.a.jdField_a_of_type_AndroidGraphicsRect.right, this.a.jdField_a_of_type_AndroidGraphicsRect.bottom);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqArkDispatchTask.c(new nhv(this, localArkUIView));
        return;
      }
      finally {}
      QLog.e("ark.rect", 1, String.format("SyncRect.2.rect: %s, wrapper: %s bmp == null.", new Object[] { this.a.jdField_a_of_type_AndroidGraphicsRect.toString(), this.a.toString() }));
    }
  }
  
  public void Update(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArkUIView localArkUIView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView;
    if ((this.a.e) || (localArkUIView == null) || (!this.a.f)) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = localArkUIView.a();
    } while (localBitmap == null);
    try
    {
      this.a.jdField_a_of_type_ComTencentArkArk$Container.Paint(localBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
      localArkUIView.a(new Rect(paramInt1, paramInt2, paramInt3, paramInt4));
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */