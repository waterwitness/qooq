import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class gfj
  implements Runnable
{
  gfj(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    while ((this.a.a() == null) || (!this.a.a().n()) || (!this.a.a().o()) || (this.a.a().y != 2) || (!this.a.a().ab)) {
      return;
    }
    Object localObject = this.a.d();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Long localLong = (Long)((Iterator)localObject).next();
      String str = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(localLong + "");
      if (str != null)
      {
        localArrayList.add(PstnUtils.a(str));
        this.a.a().a.remove(localLong);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "MultiAutoTranPstnRunnable tran list size:" + localArrayList.size());
    }
    this.a.a().a(localArrayList);
    this.a.a().g = localArrayList;
    if (this.a.a().g.size() > 0) {
      this.a.K();
    }
    this.a.Q();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gfj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */