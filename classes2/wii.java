import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.CheckOfflineCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class wii
  implements Runnable
{
  public wii(SwiftBrowserOfflineHandler paramSwiftBrowserOfflineHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((QLog.isColorLevel()) && (SwiftBrowserOfflineHandler.a(this.a).size() != 0)) {
      QLog.i(SwiftBrowserOfflineHandler.jdField_a_of_type_JavaLangString, 2, "now post offline callback, bid is " + SwiftBrowserOfflineHandler.a(this.a) + ", mode: " + this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    }
    Iterator localIterator = SwiftBrowserOfflineHandler.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((SwiftBrowserOfflineHandler.CheckOfflineCallback)localIterator.next()).a(this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    }
    SwiftBrowserOfflineHandler.a(this.a).clear();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */