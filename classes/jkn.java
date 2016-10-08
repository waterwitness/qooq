import android.os.SystemClock;
import com.tencent.common.app.ThreadTracker;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.TraceUtils;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.Vector;

class jkn
  implements Iterator
{
  private Thread jdField_a_of_type_JavaLangThread;
  private final Iterator jdField_a_of_type_JavaUtilIterator;
  private boolean jdField_a_of_type_Boolean;
  private Thread b;
  
  jkn(jkm paramjkm)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_Jkm.jdField_a_of_type_JavaLangIterable.iterator();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    while ((this.jdField_a_of_type_JavaLangThread == null) && (this.jdField_a_of_type_JavaUtilIterator.hasNext()))
    {
      this.jdField_a_of_type_JavaLangThread = ((Thread)((Reference)this.jdField_a_of_type_JavaUtilIterator.next()).get());
      if ((this.jdField_a_of_type_Jkm.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangThread == null)) {
        this.jdField_a_of_type_JavaUtilIterator.remove();
      }
    }
  }
  
  public Thread a()
  {
    if (!hasNext()) {
      throw new IllegalStateException();
    }
    Thread localThread = this.jdField_a_of_type_JavaLangThread;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangThread = null;
    this.b = localThread;
    return localThread;
  }
  
  public boolean hasNext()
  {
    a();
    return this.jdField_a_of_type_JavaLangThread != null;
  }
  
  public void remove()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException();
    }
    this.jdField_a_of_type_JavaUtilIterator.remove();
    jko localjko;
    if (this.b != null)
    {
      if (!this.b.getName().startsWith("SharedPreferencesImpl")) {
        TraceUtils.a("Thread." + this.b.getName() + "." + this.b.getId());
      }
      if (ThreadTracker.a())
      {
        localjko = ThreadTracker.a(this.b.getId(), ThreadTracker.a);
        if (localjko == null) {
          break label161;
        }
        jko.a(localjko, this.b.getName());
        jko.a(localjko, SystemClock.uptimeMillis() - ThreadTracker.a());
      }
    }
    for (;;)
    {
      if (!this.b.getName().startsWith("SharedPreferencesImpl")) {
        TraceUtils.a();
      }
      this.b = null;
      return;
      label161:
      localjko = new jko(this.b.getId(), this.b.getName(), 0L, null);
      jko.a(localjko, this.b.getName());
      jko.a(localjko, SystemClock.uptimeMillis() - ThreadTracker.a());
      ThreadTracker.a.add(localjko);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jkn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */