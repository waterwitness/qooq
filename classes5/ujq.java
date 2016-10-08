import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import java.util.Iterator;
import java.util.LinkedList;

class ujq
  implements Runnable
{
  ujq(ujp paramujp, int paramInt, RichStatus paramRichStatus, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (StatusManager.b(this.jdField_a_of_type_Ujp.a.a) != null)
    {
      Iterator localIterator = StatusManager.b(this.jdField_a_of_type_Ujp.a.a).iterator();
      while (localIterator.hasNext()) {
        ((IStatusListener)localIterator.next()).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ujq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */