import com.tencent.mobileqq.activity.StructMsgObserver;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mmi
  implements Runnable
{
  public mmi(StructMsgObserver paramStructMsgObserver, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    WebAccelerator.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.c);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mmi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */