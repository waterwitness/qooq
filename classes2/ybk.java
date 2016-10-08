import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.GetAppListData;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.SetAppListData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.OfficeCenterProtoManager;

public class ybk
  extends DingdongPluginBizObserver
{
  public ybk(OfficeCenterProtoManager paramOfficeCenterProtoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(DingdongPluginBizObserver.GetAppListData paramGetAppListData)
  {
    ybl localybl;
    if (paramGetAppListData != null)
    {
      long l = paramGetAppListData.jdField_a_of_type_Long;
      if (OfficeCenterProtoManager.a(this.a).containsKey(Long.valueOf(l)))
      {
        localybl = (ybl)OfficeCenterProtoManager.a(this.a).get(Long.valueOf(l));
        if (paramGetAppListData.jdField_a_of_type_Int != 0) {
          break label68;
        }
        OfficeCenterProtoManager.a(this.a, l, localybl.jdField_a_of_type_Long, paramGetAppListData.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    return;
    label68:
    localybl.jdField_a_of_type_Int = 4;
    OfficeCenterProtoManager.a(this.a, localybl);
    QLog.e("OfficeCenterProtoManager", 1, "get app list fail : " + paramGetAppListData.jdField_a_of_type_JavaLangString);
  }
  
  public void a(DingdongPluginBizObserver.SetAppListData paramSetAppListData)
  {
    ybl localybl;
    if (paramSetAppListData != null)
    {
      long l = paramSetAppListData.jdField_a_of_type_Long;
      if (OfficeCenterProtoManager.a(this.a).containsKey(Long.valueOf(l)))
      {
        localybl = (ybl)OfficeCenterProtoManager.a(this.a).get(Long.valueOf(l));
        if (paramSetAppListData.jdField_a_of_type_Int != 0) {
          break label76;
        }
        localybl.jdField_a_of_type_Int = 1;
        OfficeCenterProtoManager.a(this.a, localybl);
        OfficeCenterProtoManager.a(this.a, paramSetAppListData.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    return;
    label76:
    localybl.jdField_a_of_type_Int = 2;
    OfficeCenterProtoManager.a(this.a, localybl);
    QLog.e("OfficeCenterProtoManager", 1, "set app list fail : " + paramSetAppListData.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */