import com.tencent.kingkong.Common;
import com.tencent.kingkong.Common.Log;
import com.tencent.kingkong.PatchManager;
import com.tencent.kingkong.ReportThread;
import com.tencent.kingkong.UpdateManager;
import com.tencent.kingkong.Utils.InterProcessLock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class kfa
  extends Thread
{
  public kfa()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((!Common.jdField_a_of_type_Boolean) && (Common.c()) && (Common.d()) && (Common.e()))
      {
        if (!Common.jdField_a_of_type_ComTencentKingkongUtils$InterProcessLock.a()) {
          return;
        }
        Common.a(true);
        if (PatchManager.a(Common.jdField_a_of_type_AndroidContentContext))
        {
          if (Common.jdField_a_of_type_ComTencentKingkongReportThread == null)
          {
            Common.jdField_a_of_type_ComTencentKingkongReportThread = new ReportThread();
            Common.jdField_a_of_type_ComTencentKingkongReportThread.start();
          }
          UpdateManager.a(Common.jdField_a_of_type_AndroidContentContext);
          if (UpdateManager.b()) {
            UpdateManager.b();
          }
          if (UpdateManager.a()) {
            UpdateManager.a();
          }
          PatchManager.a();
        }
        Common.jdField_a_of_type_Boolean = true;
        Common.a(false);
        Common.jdField_a_of_type_ComTencentKingkongUtils$InterProcessLock.a();
        return;
      }
    }
    catch (Exception localException)
    {
      Common.jdField_a_of_type_Boolean = false;
      Common.Log.a("KingKongCommon", " SetSafeStatus Exception : " + localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */