import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mqp.app.sec.d;

public final class wpg
  implements Runnable
{
  public wpg(int paramInt, Object[] paramArrayOfObject, byte[] paramArrayOfByte)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_ArrayOfJavaLangObject != null) && (this.jdField_a_of_type_ArrayOfByte != null)) {}
    try
    {
      d.e(this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfJavaLangObject, this.jdField_a_of_type_ArrayOfByte);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      try
      {
        d.ManualLoad();
        d.e(this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfJavaLangObject, this.jdField_a_of_type_ArrayOfByte);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        localUnsatisfiedLinkError2.printStackTrace();
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return;
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */