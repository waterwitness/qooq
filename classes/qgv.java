import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qgv
  implements Runnable
{
  public qgv(ThreadExcutor paramThreadExcutor, int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Job localJob = ThreadExcutor.a(this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, this.jdField_a_of_type_Boolean);
    localJob.b = 5;
    ThreadExcutor.c(this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor).a(localJob);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qgv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */