package com.tencent.mobileqq.ptt.processor;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;

public class PttCompositeProcessor
  implements IPttProcessor
{
  private IPttProcessorListener jdField_a_of_type_ComTencentMobileqqPttProcessorIPttProcessorListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public PttCompositeProcessor()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public IPttProcessor.ProcessData a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new IPttProcessor.ProcessData(paramArrayOfByte, paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      Object localObject = paramArrayOfByte;
      IPttProcessor localIPttProcessor;
      IPttProcessor.ProcessData localProcessData;
      if (localIterator.hasNext())
      {
        localIPttProcessor = (IPttProcessor)localIterator.next();
        if (this.jdField_a_of_type_ComTencentMobileqqPttProcessorIPttProcessorListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqPttProcessorIPttProcessorListener.a(localIPttProcessor, paramArrayOfByte);
        }
        localProcessData = localIPttProcessor.a(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, paramArrayOfByte.b, paramArrayOfByte.jdField_a_of_type_Int);
        localObject = localProcessData;
        if (localProcessData != null)
        {
          localObject = localProcessData;
          if (localProcessData.jdField_a_of_type_ArrayOfByte != null)
          {
            if (localProcessData.jdField_a_of_type_Int != 0) {
              break label121;
            }
            localObject = localProcessData;
          }
        }
      }
      return (IPttProcessor.ProcessData)localObject;
      label121:
      paramArrayOfByte = localProcessData;
      if (this.jdField_a_of_type_ComTencentMobileqqPttProcessorIPttProcessorListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPttProcessorIPttProcessorListener.b(localIPttProcessor, localProcessData);
        paramArrayOfByte = localProcessData;
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IPttProcessor)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IPttProcessor)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(IPttProcessor paramIPttProcessor)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramIPttProcessor);
  }
  
  public void a(IPttProcessorListener paramIPttProcessorListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttProcessorIPttProcessorListener = paramIPttProcessorListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\processor\PttCompositeProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */