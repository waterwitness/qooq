import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import common.qzone.component.cache.common.SoftHashMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class xyg
  implements Iterator
{
  int jdField_a_of_type_Int;
  Object jdField_a_of_type_JavaLangObject;
  xyd jdField_a_of_type_Xyd;
  int jdField_b_of_type_Int;
  Object jdField_b_of_type_JavaLangObject;
  xyd jdField_b_of_type_Xyd;
  
  xyg(SoftHashMap paramSoftHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Xyd = null;
    this.jdField_b_of_type_Xyd = null;
    this.jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_b_of_type_JavaLangObject = null;
    if (paramSoftHashMap.size() != 0) {}
    for (int i = SoftHashMap.a(paramSoftHashMap).length;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  protected xyd a()
  {
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    if ((this.jdField_a_of_type_JavaLangObject == null) && (!hasNext())) {
      throw new NoSuchElementException();
    }
    this.jdField_b_of_type_Xyd = this.jdField_a_of_type_Xyd;
    this.jdField_a_of_type_Xyd = xyd.a(this.jdField_a_of_type_Xyd);
    this.jdField_b_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_JavaLangObject = null;
    return this.jdField_b_of_type_Xyd;
  }
  
  public boolean hasNext()
  {
    xyd[] arrayOfxyd = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    while (this.jdField_a_of_type_JavaLangObject == null)
    {
      xyd localxyd = this.jdField_a_of_type_Xyd;
      int i = this.jdField_a_of_type_Int;
      while ((localxyd == null) && (i > 0))
      {
        i -= 1;
        localxyd = arrayOfxyd[i];
      }
      this.jdField_a_of_type_Xyd = localxyd;
      this.jdField_a_of_type_Int = i;
      if (localxyd == null)
      {
        this.jdField_b_of_type_JavaLangObject = null;
        return false;
      }
      this.jdField_a_of_type_JavaLangObject = localxyd.get();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        this.jdField_a_of_type_Xyd = xyd.a(this.jdField_a_of_type_Xyd);
      }
    }
    return true;
  }
  
  public void remove()
  {
    if (this.jdField_b_of_type_Xyd == null) {
      throw new IllegalStateException();
    }
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap.remove(this.jdField_b_of_type_JavaLangObject);
    this.jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    this.jdField_b_of_type_Xyd = null;
    this.jdField_b_of_type_JavaLangObject = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xyg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */