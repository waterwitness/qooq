import com.tencent.image.AbstractVideoImage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DynamicFaceDrawable;

class qsm
  implements Runnable
{
  qsm(qsl paramqsl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!DynamicFaceDrawable.b) {
      AbstractVideoImage.resumeAll();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qsm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */