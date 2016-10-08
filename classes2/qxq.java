import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class qxq
  implements Runnable
{
  qxq(qxo paramqxo, Object paramObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qxq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */