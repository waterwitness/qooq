package cooperation.dingdong;

import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.DingdongPluginBizHandler;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.data.OfficeCenterSharedPref;
import java.util.ArrayList;
import ybk;
import ybl;

public class OfficeCenterProtoManager
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "OfficeCenterProtoManager";
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  private static final int f = 99;
  private long jdField_a_of_type_Long;
  private ArrayMap jdField_a_of_type_AndroidSupportV4UtilArrayMap;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DingdongPluginBizHandler jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizHandler;
  private DingdongPluginBizObserver jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver;
  
  public OfficeCenterProtoManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(10);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver = new ybk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizHandler = ((DingdongPluginBizHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(75));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver);
  }
  
  private void a(long paramLong1, long paramLong2, ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (!paramArrayList.contains(Long.valueOf(paramLong2))) {
        break label51;
      }
      paramArrayList = (ybl)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(Long.valueOf(paramLong1));
      if (paramArrayList != null)
      {
        paramArrayList.jdField_a_of_type_Int = 3;
        a(paramArrayList);
      }
    }
    return;
    label51:
    if (paramArrayList.size() <= 99)
    {
      paramArrayList.add(Long.valueOf(paramLong2));
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizHandler.a(paramLong1, paramArrayList);
      return;
    }
    paramArrayList = (ybl)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(Long.valueOf(paramLong1));
    paramArrayList.jdField_a_of_type_Int = 5;
    a(paramArrayList);
    QLog.e("OfficeCenterProtoManager", 1, "add app out of max num.");
  }
  
  private void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      int j = paramArrayList.size();
      Object localObject = "";
      int i = 0;
      while (i < j)
      {
        String str = (String)localObject + Long.toString(((Long)paramArrayList.get(i)).longValue());
        localObject = str;
        if (i != j - 1) {
          localObject = str + ",";
        }
        i += 1;
      }
      if (((String)localObject).length() > 0) {
        OfficeCenterSharedPref.a().a("officecenter_user_apps_list_txt_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (String)localObject);
      }
    }
  }
  
  private void a(ybl paramybl)
  {
    if (paramybl != null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.remove(Long.valueOf(paramybl.b));
      OfficeCenterProtoManager.Callback localCallback = paramybl.jdField_a_of_type_CooperationDingdongOfficeCenterProtoManager$Callback;
      if (localCallback != null) {
        localCallback.a(paramybl.b, paramybl.jdField_a_of_type_Int);
      }
    }
  }
  
  public long a(long paramLong, OfficeCenterProtoManager.Callback paramCallback)
  {
    ybl localybl = new ybl(this, null);
    long l = this.jdField_a_of_type_Long + 1L;
    this.jdField_a_of_type_Long = l;
    localybl.b = l;
    localybl.jdField_a_of_type_CooperationDingdongOfficeCenterProtoManager$Callback = paramCallback;
    localybl.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(Long.valueOf(localybl.b), localybl);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizHandler.b(localybl.b);
    return localybl.b;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver);
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\dingdong\OfficeCenterProtoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */