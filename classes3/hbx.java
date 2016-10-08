import android.os.Handler;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class hbx
  implements Runnable
{
  public int a;
  
  public hbx(TipsManager paramTipsManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager.jdField_a_of_type_JavaUtilMap.size() > 0)
    {
      Object localObject = this.jdField_a_of_type_ComTencentAvUtilsTipsManager.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      int i = ((Integer)((Iterator)localObject).next()).intValue();
      if (i == this.jdField_a_of_type_Int) {
        if (((Iterator)localObject).hasNext())
        {
          i = ((Integer)((Iterator)localObject).next()).intValue();
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(this.jdField_a_of_type_Int));
        }
      }
      for (this.jdField_a_of_type_Int = i;; this.jdField_a_of_type_Int = i)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.e = true;
        localObject = (String)this.jdField_a_of_type_ComTencentAvUtilsTipsManager.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(i, (String)localObject, 0L, 0);
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 3000L);
        }
        return;
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Int = -1;
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.e = false;
        return;
      }
    }
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.e = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */