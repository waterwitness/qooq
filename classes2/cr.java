import com.dataline.util.DLRouterSessionInfoRequestTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class cr
  implements Runnable
{
  cr(cq paramcq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("dataline.DLRouterSessionListAdapter", 4, "请求超时 : nCMD[" + this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask.i + "], nSendCookie[" + this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask.g + "], lastSendCookie[" + this.a.jdField_a_of_type_Int + "], uTaskCookie[" + this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask.jdField_a_of_type_Long + "], lastTaskCookie[" + this.a.jdField_a_of_type_Long + "], isRunning[" + this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask.jdField_a_of_type_Boolean);
    }
    if ((this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask.jdField_a_of_type_Boolean) && (DLRouterSessionInfoRequestTask.a(this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask) != null) && (this.a.jdField_a_of_type_Int == this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask.g) && (this.a.jdField_a_of_type_Long == this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask.jdField_a_of_type_Long)) {
      DLRouterSessionInfoRequestTask.a(this.a.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */