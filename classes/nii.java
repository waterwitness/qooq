import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nii
  implements Runnable
{
  public nii(ArkContainerWrapper paramArkContainerWrapper, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.a.MouseDown(this.b, this.c, 1L, 0L);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.a.MouseMove(this.b, this.c, 0L);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.a.MouseUp(this.b, this.c, 1L, 0L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.a.MouseUp(this.b, this.c, 1L, 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */