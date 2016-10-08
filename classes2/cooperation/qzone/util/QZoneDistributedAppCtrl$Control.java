package cooperation.qzone.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class QZoneDistributedAppCtrl$Control
{
  public int a;
  public Map a;
  
  public QZoneDistributedAppCtrl$Control()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public String toString()
  {
    return "ctrl:[cmd = " + this.jdField_a_of_type_Int + ", data = " + this.jdField_a_of_type_JavaUtilMap + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\util\QZoneDistributedAppCtrl$Control.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */