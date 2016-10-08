import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class tba
  implements Runnable
{
  public tba(MagicfaceActionManager paramMagicfaceActionManager, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c;
      if (bool1) {
        return;
      }
      MagicfaceActionManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager, this.jdField_a_of_type_Int);
      localObject1 = null;
      if (this.b != 0) {
        break label275;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader.a("send.xml");
      if (QLog.isColorLevel()) {
        QLog.d(MagicfaceActionManager.jdField_a_of_type_JavaLangString, 2, "func doAction. step 1");
      }
      if (localObject1 == null) {
        break label246;
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder.a((String)localObject1);
      if (this.b == 1) {
        MagicfaceActionManager.b(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      }
      MagicfaceActionManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager, this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder.a((String)localObject1);
      MagicfaceActionManager.c(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_JavaUtilList.iterator();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1;
        Object localObject1;
        Action localAction;
        boolean bool2;
        label246:
        label275:
        label299:
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceActionManager", 2, "doaction=Exception=" + localException.toString());
        }
        return;
        label380:
        if (bool1)
        {
          bool1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b;
          if (!bool1) {}
        }
      }
    }
    finally
    {
      if (!QLog.isColorLevel()) {
        break label414;
      }
      QLog.d("MagicfaceActionManager", 2, "func doAction, 【magic end】");
      label414:
      MagicfaceActionManager.b(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager, this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData);
    }
    if (((Iterator)localObject1).hasNext())
    {
      localAction = (Action)((Iterator)localObject1).next();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction = localAction;
      localAction.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager;
      localAction.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
      bool1 = localAction.a();
      bool2 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b;
      if (!bool2) {
        break label299;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func doAction, 【magic end】");
      }
      MagicfaceActionManager.b(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager, this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData);
      return;
      if (this.b != 1) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader.a("receive.xml");
      break;
      if (!localAction.c) {
        break label380;
      }
      MagicfaceActionManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */